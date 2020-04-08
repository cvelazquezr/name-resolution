private void toFile(File file, ConfigInstance map) {
    map.Encrypt();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    String jsonConfig = gson.toJson(map);
    FileWriter writer;
    try {
        writer = new FileWriter(file);
        writer.write(jsonConfig);
        writer.flush();
        writer.close();
    } catch (IOException e) {
        System.out.println("Error exporting config: " + e.toString());
    }
}