import objectes.Producte;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Model {

    private static ArrayList<Producte> productes = new ArrayList<>();

    public static ArrayList<Producte> getProductes() {
        return productes;
    }

    public static void afegirProducte(Producte p){
        try {
            if (p == null) throw new Exception("El producte es null");
            productes.add(p);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());;
        }
    }

    public static void mostrarProductes(){
        for (Producte p : productes){
            System.out.println(p);
        }
    }


    public static String generarTicket(boolean a) {
        StringBuilder ticket = new StringBuilder();
        ArrayList<Producte> listaCarrito = getProductes();

        // 1. Agrupamos: La clave es el Producto, el valor es la Cantidad
        Map<Producte, Integer> cantidades = new HashMap<>();

        for (Producte p : listaCarrito) {
            // Si ya existe, suma 1. Si no, ponlo con valor 1.
            cantidades.put(p, cantidades.getOrDefault(p, 0) + 1);
        }


        // 1.1. Cabecera del Ticket
        ticket.append("-".repeat(50)).append("\n");
        ticket.append(String.format("%30s%n","Sapamercat"));
        ticket.append("-".repeat(50)).append("\n");


        // 2. Cabecera del Ticket
        ticket.append("-".repeat(50)).append("\n");
        ticket.append(String.format("%-20s %-10s %-10s %-10s\n", "Producte", "Quant", "Preu Un.", "Total"));
        ticket.append("-".repeat(50)).append("\n");

        final double[] sumaTotal = {0};

        // 3. Recorremos el Map usando Lambda (como pide el enunciado)
        cantidades.forEach((p, cantidad) -> {
            double precioTotalProducto = p.getPreu() * cantidad;
            sumaTotal[0] += precioTotalProducto;

            ticket.append(String.format("%-20s %-10d %-10.2f %-10.2f\n",
                    p.getNom(),
                    cantidad,
                    p.getPreu(),
                    precioTotalProducto));
        });



        // 4. Pie del tiquet (opcional)
        ticket.append("-".repeat(50)).append("\n");
        ticket.append(String.format("%-42s %.2f%n","Total:", sumaTotal[0]));
        ticket.append("-".repeat(50)).append("\n");

        // Para el total global necesitarías una variable externa o sumar en el loop
        return ticket.toString();
    }

}
