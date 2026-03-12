import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window {
    private Teacher teacher;
    private Perceptron perceptron;

    public void show() {
        //Tworzenie okna GUI
        JFrame frame = new JFrame("Perceptron");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        frame.getContentPane().setBackground(new Color(235, 205, 240));

        //komponenty
        JLabel trainingFileLabel = new JLabel("Nazwa pliku treningowego: ");
        JTextField trainingFileField = new JTextField(20);
        JLabel testFileLabel = new JLabel("Nazwa pliku testowego: ");
        JTextField testFileFiled = new JTextField(20);

        JLabel alphaLabel = new JLabel("Wartość alpha: ");
        JTextField alphaField = new JTextField(10);
        JLabel betaLabel = new JLabel("Wartość beta: ");
        JTextField betaField = new JTextField(10);

        JLabel epochsLabel = new JLabel("Liczba epok: ");
        JTextField epochsField = new JTextField(10);
        JLabel klasaLabel = new JLabel("Podaj nazwe klasy: ");  //(tej do której będziemy sprawdzać czy należy)
        JTextField klasaField = new JTextField(10);

        JButton trainButton = new JButton("Train");
        JButton testButton = new JButton("Test");

        JTextArea outputArea = new JTextArea(12, 35);
        outputArea.setEditable(false);

        //dodaje komponenty do okna
        frame.add(trainingFileLabel);
        frame.add(trainingFileField);
        frame.add(testFileLabel);
        frame.add(testFileFiled);
        frame.add(alphaLabel);
        frame.add(alphaField);
        frame.add(betaLabel);
        frame.add(betaField);
        frame.add(epochsLabel);
        frame.add(epochsField);
        frame.add(klasaLabel);
        frame.add(klasaField);
        frame.add(trainButton);
        frame.add(testButton);
        frame.add(new JScrollPane(outputArea));

        frame.setVisible(true);

        trainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String trainingFile = trainingFileField.getText();
                    String testFile = testFileFiled.getText();
                    double alpha = Double.parseDouble(alphaField.getText());
                    double beta = Double.parseDouble(betaField.getText());
                    int epochs = Integer.parseInt(epochsField.getText());
                    String klass = klasaField.getText();

                    teacher = new Teacher(trainingFile, testFile);
                    int dimension = teacher.trainingData.getFirst().length-1;
                    perceptron = new Perceptron(dimension);
                    perceptron.setAlpha(alpha);
                    perceptron.setBeta(beta);
                    teacher.setEpochs(epochs);
                    teacher.setPerceptron(perceptron);
                    teacher.setKlasa(klass);

                    outputArea.append("Dane startowe perceptronu: \n" + perceptron + "\n");
                    outputArea.append("\nTrening...\n");
                    teacher.train();

                    outputArea.append("Dane perceptronu po treningu: \n" + perceptron + "\n");

                }catch (NumberFormatException ex){
                    outputArea.append("Błąd: Wprowadź poprawne dane.\n");
                }
            }
        });

        testButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (teacher != null) {
                    outputArea.append("\nTest... \n");
                    outputArea.append(teacher.test());
                }else{
                    outputArea.append("Najpierw przeprowadź trening! \n");
                }
            }
        });
    }
}