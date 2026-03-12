public class LinAlg {

    //OPERACJE NA WEKTORACH
    public static double iloczynSkalarny(double[] a, double[] b) {
        if (a.length != b.length) {
            throw new IllegalArgumentException("Wektory muszą mieć tę samą liczbę elementów.");
        }
        double iloczynSkalarny = 0;
        for (int i = 0; i < a.length; i++) {
            iloczynSkalarny += a[i] * b[i];
        }
        return iloczynSkalarny;
    }

    public static double[] mnozenieWektoraPrzezSkalar(double skalar, double[]a){
        double[] przemnozony = new double[a.length];
        for(int i = 0; i<a.length; i++){
            przemnozony[i] = a[i] * skalar;
        }
        return przemnozony;
    }

    public static double[] dodawanieWektorow(double[] a, double[] b) {
        if (a.length != b.length) {
            throw new IllegalArgumentException("Wektory muszą mieć tę samą liczbe elementów.");
        }
        double[] dodane = new double[a.length];
        for(int i = 0; i<a.length; i++){
            dodane[i] = a[i] + b[i];
        }
        return dodane;
    }

    public static double[] odejmowanieWektorow(double[] a, double[] b) {
        if (a.length != b.length) {
            throw new IllegalArgumentException("Wektory muszą mieć tę samą liczbę elementów.");
        }
        double[] odjete = new double[a.length];
        for(int i = 0; i<a.length; i++){
            odjete[i] = a[i] - b[i];
        }
        return odjete;
    }

    public static double[] normalizacjaWektora(double[] a){
        double norma = norma(a);
        if (norma == 0){
            throw new IllegalArgumentException("Wektor o zerowej normie nie może być znormalizowany.");
        }
        double[] znormalizowany = new double[a.length];
        for(int i = 0; i<a.length; i++){
            znormalizowany[i] = a[i] / norma;
        }
        return znormalizowany;

        //alternatywnie
        //return mnozenieWektoraPrzezSkalar(1/norma, a);
    }

    public static double norma(double[] a){
        double norma = 0;
        for(int i = 0; i<a.length; i++){
            norma += a[i] * a[i];
        }
        norma = Math.sqrt(norma);
        return norma;
    }

    public static double odlegloscEuklidesowaMiedzyWektorami(double[] a, double[] b){
        if (a.length != b.length) {
            throw new IllegalArgumentException("Wektory muszą mieć tę samą liczbę elementów.");
        }
        double odleglosc = 0;
        for(int i = 0; i<a.length; i++){
            odleglosc += Math.pow(b[i] - a[i], 2);
        }
        odleglosc = Math.sqrt(odleglosc);
        return odleglosc;
    }

    public static double katMiedzyWektorami(double[] a, double[] b){
        double iloczynSkalarny = iloczynSkalarny(a, b);
        double normaa = norma(a);
        double normab = norma(b);
        if (normaa == 0 || normab == 0){
            throw new IllegalArgumentException("Nie można obliczyć kąta z wektorem o zerowej normie.");
        }
        //Math.acos (arcus cosinus - funkcja odwrotna do cosinusa --> zwraca kąt w radianach)
        //Math.toDegrees() zamienia na stopnie
        double radiany = Math.acos(iloczynSkalarny / (normaa * normab));
        return Math.toDegrees(radiany);
    }

    //OPERACJE NA MACIERZACH
    public static double[] mnozenieMacierzyPrzezWektor(double[][] macierz, double[] wektor){
        if (macierz[0].length != wektor.length){
            throw new IllegalArgumentException("Liczba kolumn macierzy musi być równa liczbie elementów wektora.");
        }
        double[] przemnozone = new double[macierz.length];
        for (int i = 0; i < macierz.length; i++){
            for (int j = 0; j < macierz[i].length; j++){
                przemnozone[i] += macierz[i][j] * wektor[j];
            }
        }
        return przemnozone;
    }

    public static double[][] transpozycjaMacierzy(double[][] macierz){
        double[][] transponowa = new double[macierz[0].length][macierz.length];
        for (int i = 0; i < macierz.length; i++){
            for (int j = 0; j < macierz[i].length; j++){
                transponowa[j][i] = macierz[i][j];
            }
        }
        return transponowa;
    }

    public static double[][] mnozenieMacierzyprzezMacierz(double[][] macierz1, double[][] macierz2){
        if (macierz1[0].length != macierz2.length){
            throw new IllegalArgumentException("Liczba kolumn macierzy 1 musi być równa liczbie wierszy macierzy 2.");
        }
        double[][] pomnozone= new double[macierz1.length][macierz2[0].length];
        for (int i = 0; i < macierz1.length; i++){
            for (int j = 0; j < macierz2[0].length; j++){
                for(int k = 0; k < macierz1[0].length; k++){
                    pomnozone[i][j] += macierz1[i][k] * macierz2[k][j];
                }
            }
        }
        return pomnozone;
    }
}