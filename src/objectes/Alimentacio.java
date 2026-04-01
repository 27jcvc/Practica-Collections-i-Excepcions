package objectes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Alimentacio extends Producte{

//     Todo: data actual
    /**
     * guardamos localDate porque sino hay que guardar la hora tambien
     */
    LocalDateTime dataActual = LocalDateTime.now();
    LocalDate dataCaducitat;
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

//    public Alimentacio(String nom, double preu, int codiDeBarres, LocalDate dataCaducitat) throws Exception {
//        super(nom, preu, codiDeBarres);
//
//        this.dataCaducitat = dataCaducitat;
//        this.preu = calcularPreu(preu);
//    }

    public Alimentacio(String nom, double preu, int codiDeBarres, String dataCaducitat) throws Exception {
        super(nom, preu, codiDeBarres);

        this.dataCaducitat = LocalDate.parse(dataCaducitat, format);
        this.preu = calcularPreu(preu);
    }

    @Override
    public double calcularPreu(double preu) {

        long dataActual = this.dataActual.toLocalDate().toEpochDay();
        long dataCaducitat = this.dataCaducitat.toEpochDay();

        return preu - preu*((double) 1 /( dataCaducitat - dataActual + 1)) + (preu * 0.1);
    }

    @Override
    public String toString() {
        return String.format("""
                            %s       Data caducitat: %s
                            """
                            ,super.toString(), dataCaducitat.format(format));
    }

    public LocalDate getDataCaducitat() {
        return dataCaducitat;
    }

    @Override
    public int compareTo(Producte p) {
        if (p instanceof Alimentacio) {
            long fecha = this.dataCaducitat.toEpochDay();
            long fechaProducte = ((Alimentacio) p).getDataCaducitat().toEpochDay();

            // Long.compare devuelve un int (-1, 0 o 1) automáticamente
            return Long.compare(fecha, fechaProducte);
        }
        return 0;
    }
}
