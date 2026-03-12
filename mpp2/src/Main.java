import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwę pliku treningowego: ");
        String trainingFile = scanner.nextLine();
        System.out.println("Podaj nazwe pliku testowego: ");
        String testFileName = scanner.nextLine();

        Teacher teacher = new Teacher(trainingFile, testFileName);

        int dimension = teacher.trainingData.getFirst().length-1;
        Perceptron perceptron = new Perceptron(dimension);
        System.out.println(perceptron);

        System.out.println("Podaj wartość alpha: ");
        double alpha = scanner.nextDouble();
        perceptron.setAlpha(alpha);
        System.out.println("Podaj wartość beta: ");
        double beta = scanner.nextDouble();
        perceptron.setBeta(beta);

        System.out.println("Podaj liczbe epok: ");
        int epochs = scanner.nextInt();
        teacher.setEpochs(epochs);

        teacher.setPerceptron(perceptron);

        teacher.train();

        teacher.test();
    }
}