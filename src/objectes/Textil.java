package objectes;

public class Textil extends Producte{

    protected String composicio;

    public Textil(String nom, double preu, int codiDeBarres, String composicio) throws Exception {
        super(nom, preu, codiDeBarres);
        this.composicio = composicio;
    }

    public String getComposicio() {
        return composicio;
    }

    @Override
    public int compareTo(Producte p) {
        if (p instanceof Textil){
            /// Ordenar alfabeticament
            return this.composicio.compareTo(((Textil) p).getComposicio());
        }

        return 0;
    }
}
