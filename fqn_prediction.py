import numpy as np
import pickle
import subprocess
from sys import argv


# TODO: Check possible error in here
def calculate_probability(matches: list):
    probability = 0.0
    if matches[0]:
        probability += 0.5
    
    remaining_weight = 0.5 / (len(matches) - 1)
    for i in range(1, len(matches)):
        if matches[i]:
            probability += remaining_weight
    
    return probability


def predict_fragment_code(tokens: list, trained_model, w2vec_model, libs_mapping):
    import_line = ""
    vectors = list()

    matches = list()
    for token in tokens:
        token_lower = token.lower()
        if token_lower in list(w2vec_model.wv.vocab.keys()):
            vectors.append(w2vec_model.wv[token_lower])
            matches.append(True)
        else:
            matches.append(False)

    similarity_probability = calculate_probability(matches)
    if similarity_probability > 0.5:
        vector_model_code = sum(vectors) / len(vectors)

        # The predictions made need to be quantified
        probabilities_code = trained_model.predict_proba(np.array([vector_model_code]))
        indexes = list(np.argpartition(probabilities_code[0], -1)[-1:])

        fqn_predicted = ""
        for key, value in libs_mapping.items():
            if indexes[0] == value:
                fqn_predicted = key
        
        import_line += fqn_predicted
    
    # Check the matches
    if import_line.split(".")[-1] != tokens[0]:
        import_line = ""

    return import_line


if __name__ == "__main__":
    if len(argv) < 2:
        print("Please specify the path of a snippet")
    elif len(argv) == 2:
        path_snippet = argv[1]

        print("Extracting names of the classes ...")
        result = subprocess.run([
            "java",
            "-jar",
            "extractor_package/snippets-extractor.jar",
            "--path",
            path_snippet
            ],
            stdout=subprocess.PIPE).stdout

        result = result.decode("utf-8")
        code_to_predict = result.strip().split("\n")

        print("Loading the trained data ...")
        selected_model = pickle.load(open("models/classifiers/DT.model", "rb"))
        model_w2vec = pickle.load(open("models/word2vec/word2vec.model", "rb"))
        libs_mapping = pickle.load(open("models/libraries_information/libs_mapping.pickle", "rb"))

        print("Predicting the FQNs ...")
        include_imports = list()
        for code in code_to_predict:
            predicted_import = predict_fragment_code(code.split(","), selected_model, model_w2vec, libs_mapping)

            if len(predicted_import):
                include_imports.append(predicted_import)
        
        lines_snippet = list()
        with open(path_snippet) as f:
            while True:
                line = f.readline()
                if not line:
                    break
                else:
                    lines_snippet.append(line.strip())
        
        print("Writing the new completed version of the snippet ...")
        divided_path = path_snippet.split("/")
        new_snippet_name = divided_path[-1].split(".")[0] + "_completed.java"
        
        new_path = "/".join(divided_path[:-1]) + f"/{new_snippet_name}"

        with open(new_path, "w") as f:
            for import_line in include_imports:
                f.write(f"import {import_line};\n")

            f.write("\n")

            for line in lines_snippet:
                f.write(f"{line}\n")

        print("Done !!!")
        print(f"Find the new completed version of the snippet at {new_path}")
