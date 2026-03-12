import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadData {
    public static List<double[]> readData(String fileName) {
        List<double[]> data = new ArrayList<>();
        String filePath = "/Users/karo/Desktop/Ćwiczenia 2 - Perceptron/" + fileName;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while((line = br.readLine()) != null){
                String[] parts = line.split(",");
                double[] vector = new double[parts.length];

                for (int i = 0; i < parts.length - 1; i++) {
                    vector[i] = Double.parseDouble(parts[i]);
                }

                if (parts[parts.length-1].equals("Iris-versicolor")) {
                    vector[vector.length-1] = 1;
                } else {
                    vector[vector.length-1] = 0;
                }
                data.add(vector);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return data;
    }
}