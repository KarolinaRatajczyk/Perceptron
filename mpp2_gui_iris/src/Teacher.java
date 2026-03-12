import java.util.List;

public class Teacher {
    Perceptron perceptron;
    List<double[]> trainingData;
    List<double[]> testData;
    int epochs;
    String klasa;

    public Teacher(String trainingFile, String testFile) {
        this.trainingData = ReadData.readData(trainingFile, klasa);
        this.testData = ReadData.readData(testFile, klasa);
    }

    public void setEpochs(int epochs) {
        this.epochs = epochs;
    }

    public void setKlasa(String klasa) {
        this.klasa = klasa;
    }

    public void setPerceptron(Perceptron perceptron) {
        this.perceptron = perceptron;
    }

    public void train() {
        if (perceptron == null){
            throw new IllegalArgumentException("Perceptron has not been set!");
        }

        for (int i = 0; i < epochs; i++) {
            for (double[] vector : trainingData) {
                double[] x = new double[vector.length-1];
                System.arraycopy(vector, 0, x, 0, vector.length-1);
                int d = (int)vector[vector.length-1];

                int y = perceptron.compute(x);

                if (y != d){
                    perceptron.learn(x, d);
                }
            }
        }
    }

    public String test(){
        int dobrze = 0;
        int wszystkie = 0;
        for (double[] vector : testData) {
            wszystkie += 1;
            double[] x = new double[vector.length-1];
            System.arraycopy(vector, 0, x, 0, vector.length-1);
            int d = (int)vector[vector.length-1];
            int y = perceptron.compute(x);

            if (y == d) {
                dobrze += 1;
            }
        }
        return String.format("Procent dobrze rozpoznanych (dokładność) = %.2f%%\n\n", ((double)dobrze / (double)wszystkie)*100);
    }
}