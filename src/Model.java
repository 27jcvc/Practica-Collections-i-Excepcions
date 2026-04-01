import objectes.Producte;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Model  {
    ///  HashMap a on guardarem les dades dels Productes
    private static final HashMap<Producte, Integer> productes = new HashMap<>();

    public static void afegirProducte(Producte p, int qt){
        try {
            if (p == null) throw new Exception("El producte es null");

            /// : Si existe le agrega la cantidad
            /// : NO existe agrega el producto nuevo con 0 de cantidad
            productes.put(p, productes.getOrDefault(p,0) + qt);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Retorna un stream del producto con todos los datos
     */
    public static void mostrarProductes(){

        /// Ordenar per preu (es podria fer amb el nom)
        List<Producte> producteStream = productes.keySet().stream()
                .sorted(Comparator.comparingInt(Producte::getnProducte))
//                .sorted((a,b) -> a.getnProducte() - b.getnProducte())
                .toList();

        producteStream.forEach(System.out::println);

    }


    public static String generarTicket() {
        StringBuilder ticket = new StringBuilder();

        /// Titol del supermercat
        ticket.append("-".repeat(50)).append("\n");
        ticket.append(String.format("%30s%n","Sapamercat"));
        ticket.append("-".repeat(50)).append("\n");


        /// Capçalera del Ticket
        ticket.append("-".repeat(50)).append("\n");
        ticket.append(String.format("%-20s %-10s %-10s %-10s\n", "Producte", "Quant", "Preu Un.", "Total"));
        ticket.append("-".repeat(50)).append("\n");

            /// Suma total dels preus
        final double[] sumaTotal = {0};

        /// Recorrer el Map usando Lambda

        productes.entrySet().stream()
                // 1. Ordenamos por la clave (Producte).
                // Nota: Producte DEBE implementar la interfaz Comparable.

                .sorted(Map.Entry.comparingByKey())
                // 2. Procesamos cada entrada para construir el ticket

                .forEach(entry -> {
                    Producte p = entry.getKey();
                    int cantidad = entry.getValue();

                    double precioTotalProducto = p.getPreu() * cantidad;
                    sumaTotal[0] += precioTotalProducto;

                    ticket.append(String.format("%-20s %-10d %-10.2f %-10.2f\n",
                            p.getNom(),
                            cantidad,
                            p.getPreu(),
                            precioTotalProducto));
                });



        /// Peu del tiquet
            ticket.append("-".repeat(50)).append("\n");
            ticket.append(String.format("%-42s %.2f%n","Total:", sumaTotal[0]));
            ticket.append("-".repeat(50)).append("\n");

        return ticket.toString();
    }

}
