### Purpose of the application
This small application was implemented with the purpose of testing the models trained as part of the
REsolution of Incomplete COde (RESICO) approach. It was designed as a small CLI app to modify code snippets
passed as input in the following way:
```
python3 fqn_prediction.py <path-of-the-snippet.java>
```

The application will load all trained models and will try to predict the missing FQNs in the code snippet including `import` statements at the top of the file.

The output will be another `Java` file in the same path of the one passed by parameter, ending with `_completed.java` as part as its name.

### Requeriments to run the application
* A version of Python >= 3.7
* The numpy library >= 1.18.
* A trained model to do the predictions (more details below)

### How to include a trained model?
First, you should create a folder `classifiers` within the `models` folder (e.g., `mkdir models/classifiers`).
Inside that folder you should place the following trained model: https://drive.google.com/open?id=17PGA5RfWbj_jBnbaed3QE-t-dPMywC2N

Also, the trained contexts and FQNs need to be loaded. In order to do that create another folder `word2vec` inside the `models` folder (e.g., `mkdir models/word2vec`).
Inside that folder you should place the following model: https://drive.google.com/open?id=1dfirkGufeGnCJb2S-MhCkBouq2L0nmli 

This is a Decision Tree classifier trained in the FQNs of all Java code snippets from Stack Overflow which contain import statements, hence its size (1.5 GB). This model, achieves really good metrics such as a Precision of 0.88 and a Recall of 0.89 for the top-1 recommendations.

The project includes several examples of code snippets and their predictions at the `texting_snippets` folder. To evaluate more code snippets with the model, check the links in the `evaluate` folder. Within that folder are three more folders with links to different code snippets classified by their length.

If there's any issue with the project or model(s) please let me know :)
