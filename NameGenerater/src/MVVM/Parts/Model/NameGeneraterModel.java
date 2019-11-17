package MVVM.Parts.Model;

import Bootstrap.Tools.CSVReaderWriter;
import Bootstrap.Tools.RandomTool;

import java.util.ArrayList;

public class NameGeneraterModel {
    ArrayList<String> firstNames;
    ArrayList<String> lastNames;

    public void Run(int generaterCount) {
        ArrayList<String> generateNames = new ArrayList<>();
        String generateName = "";
        String allFirstNameCSVPath = System.getProperty("user.dir") + "\\first_names.all.csv";
        String allLastNameCSVPath = System.getProperty("user.dir") + "\\last_names.all.csv";
        String generateCSVPath = System.getProperty("user.dir") + "\\generate.csv";
        firstNames = CSVReaderWriter.reader(allFirstNameCSVPath);
        lastNames = CSVReaderWriter.reader(allLastNameCSVPath);
        for (int i = 0; i < generaterCount; i++) {
            generateName = "";
            generateName += firstNames.get(RandomTool.GetRandomInt(firstNames.size())) + " ";
            generateName += lastNames.get(RandomTool.GetRandomInt(lastNames.size()));
            generateNames.add(generateName);
        }
        CSVReaderWriter.writer(generateCSVPath, String.join(",", generateNames));
    }
}
