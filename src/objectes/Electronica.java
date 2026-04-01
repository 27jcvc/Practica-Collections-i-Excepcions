package objectes;

public class Electronica extends Producte{

    protected int diesGarantia;

    public Electronica(String nom, double preu, int codiDeBarres, int diesGarantia) throws Exception {
        super(nom, preu, codiDeBarres);

        this.diesGarantia = diesGarantia;
        this.preu = calcularPreu(preu);
    }

    @Override
    public double calcularPreu(double preu){
        return preu + preu*((double) this.diesGarantia /365)*0.1;
    }

    public int getDiesGarantia() {
        return diesGarantia;
    }

    @Override
    public int compareTo(Producte p) {
        if (p instanceof Electronica) {
            ///  Integer.compare retorna positivo negativo o 0 si es igual
            return Integer.compare(this.diesGarantia, ((Electronica) p).getDiesGarantia());
        }

        return 0;
    }
}
