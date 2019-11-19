package MVVM.Parts.Model;

import Bootstrap.Tools.Alog;
import Bootstrap.Tools.CSVReaderWriter;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class SieveofEratosthenes implements IMVVM_Model {
    ArrayList<Long> primeNumbers = new ArrayList<Long>();
    Long currentNumber = 2L;
    boolean stop = false;

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public void Run(int findCount) {
        String csvPath = System.getProperty("user.dir") + "\\PrimeNumbers.csv";
        int count = 0;
        try {
            File file = new File(System.getProperty("user.dir"), "PrimeNumbers.csv");
            if (file.isFile())
            {
                ArrayList<String> csvDate = CSVReaderWriter.reader(csvPath);
                currentNumber = Long.parseLong(csvDate.get(0));
                primeNumbers = (ArrayList<Long>) Arrays.stream(csvDate.get(1).split(",")).map(Long::parseLong).collect(Collectors.toList());
            }
        } catch (Exception e) {
            /*If is empty csv file or format is not correct finding prime number will start run from 2*/
            currentNumber = 2L;
            primeNumbers = new ArrayList<>();
            primeNumbers.add(currentNumber);
        }

        boolean isPrimeNumber = true;
        while (!stop) {
            currentNumber++;
            isPrimeNumber = true;
            for (Long primeNumber : primeNumbers) {
                if (currentNumber % primeNumber == 0) {
                    isPrimeNumber = false;
                    break;
                }
            }
            if (isPrimeNumber) {
                count++;
                primeNumbers.add(currentNumber);
            }
            if (count == findCount) {
                stop = true;
            }
        }

        CSVReaderWriter.writer(csvPath, String.valueOf(currentNumber));
        CSVReaderWriter.pushWriter(csvPath, String.join(",", primeNumbers.stream().map(Object::toString).collect(Collectors.toList())));
        CSVReaderWriter.pushWriter(csvPath, String.valueOf(primeNumbers.size()));
        Alog.logInfo(primeNumbers.size() + " are found");
        Alog.logInfo("Prime Numbers are save in " + csvPath);
    }
}
