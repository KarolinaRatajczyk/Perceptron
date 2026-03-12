import java.util.List;

public class Teacher {
    Perceptron perceptron;
    List<double[]> trainingData;
    List<double[]> testData;
    int epochs;

    public Teacher(String trainingFile, String testFile) {
        this.trainingData = ReadData.readData(trainingFile);
        this.testData = ReadData.readData(testFile);
    }

    public void setEpochs(int epochs) {
        this.epochs = epochs;
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

    public void test(){
        int dobrze = 0;
        int wszystkie = 0;
        for (double[] vector : testData) {
            wszystkie += 1;
            double[] x = new double[vector.length-1];
            System.arraycopy(vector, 0, x, 0, vector.length-1);
            int d = (int)vector[vector.length-1];
            int y = perceptron.compute(x);

            if (y != d){
//                System.out.println("BŁĄD");
            }else{
//                System.out.println("dobrze rozpoznane");
                dobrze += 1;
            }
        }
        System.out.println("Procent dobrze rozpoznanych = " + ((double)dobrze / (double)wszystkie)*100 + "%");
    }
}