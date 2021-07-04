package lesson5;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        AppData appData;
        Scanner in = new Scanner(System.in);
        String file = in.nextLine();
        appData = csvReader(file);
        appData.displayInfo();
    }

    private static AppData csvReader(String pathToFile) {
        AppData appData;
        try (BufferedReader reader =  new BufferedReader(new FileReader(pathToFile))) {
            String line = reader.readLine();
            String[] header = line.split(";");
            if (!line.isEmpty()) {
                appData = new AppData();
                int row = 0;
                while ((line = reader.readLine()) != null) {
                    String[] tempArr = line.split("[;,]" );
                    for (int i = 0; i < tempArr.length; i++) {
                        appData.setData(row, i, Integer.parseInt(tempArr[i]));
                    }
                    row++;
                }
                appData.setHeader(header);

                return appData;
            } else {
                System.out.println("File is empty");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new AppData();
    }
}
