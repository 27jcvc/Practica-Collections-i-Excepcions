package objectes;

public class Textil extends Producte{

    protected String composicio;

    public Textil(String nom, double preu, int codiDeBarres, String composicio) throws Exception {
        super(nom, preu, codiDeBarres);
        this.composicio = composicio;
    }

    @Override
    public int compareTo(Producte p) {
        return (int) (this.preu - p.getPreu());
    }
}
