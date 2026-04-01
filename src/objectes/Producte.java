package objectes;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Producte {


    protected static int id = 1;
    protected int nProducte;
    protected String nom;
    protected double preu;
    protected int codiDeBarres;

    // TODO: podria hacer un contador para la qt de productes (para que no supere los 100)

    public Producte(String nom, double preu, int codiDeBarres) throws Exception {
        this.nom = nom;
        this.preu = preu;
        this.codiDeBarres = codiDeBarres;

        this.nProducte = id++;

        if (nProducte >= 100){
            throw new Exception("No es permeten més productes");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Producte producte = (Producte) o;

        return Objects.equals(nom, producte.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }

    public double calcularPreu(double preu){
        return preu;
    }

    public String getNom() {
        return nom;
    }

    public double getPreu() {
        return preu;
    }

    @Override
    public String toString() {
        return String.format("""
                            Numero de producte: %d
                                   Nom: %s
                                   Preu: %.2f
                                   Codi de barres: %d
                            """
                            ,nProducte, nom, preu, codiDeBarres);
    }
}
