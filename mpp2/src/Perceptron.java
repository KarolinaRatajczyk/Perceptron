import java.util.Arrays;

public class Perceptron {
    public double[] weights;
    public double threshold;
    double alpha;
    double beta;
    int dimension;

    public Perceptron(int dimension) {
        this.dimension = dimension;

        this.weights = new double[dimension];
        for (int i = 0; i < dimension; i++) {
            this.weights[i] = 1.0 - Math.random();
        }
        //zakres (0, 1], dlatego 1-, bo normalnie Math.random() zwraca z zakresu [0, 1)
        this.threshold = 1.0 - Math.random();
    }

    //liczenie wyjścia y
    public int compute(double[] vector) {
        double net = LinAlg.iloczynSkalarny(weights, vector) - threshold;
        if (net < 0){
            return 0;
        }else{
            return 1;
        }
    }

    //nowe wagi i nowy prog
    public void learn(double[] vector, int decision) {
        int y = compute(vector); //obliczone wyjscie
        double[] newWeights;
        newWeights = LinAlg.mnozenieWektoraPrzezSkalar(alpha*(decision-y), vector);
        newWeights = LinAlg.dodawanieWektorow(weights, newWeights);
        weights = newWeights;
        threshold = threshold - beta*(decision-y);
    }

    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }

    public void setBeta(double beta) {
        this.beta = beta;
    }

    public String toString() {
        return "weights = " + Arrays.toString(weights) + "\nthreshold = " + threshold ;
    }
}