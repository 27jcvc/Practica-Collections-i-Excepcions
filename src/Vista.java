import java.util.Scanner;

public class Vista {

    public static void mostrarMissatge(String m){
            System.out.println(m);
    }

    public static void mostrarMissatge(String m, boolean saltLinea){
        if (saltLinea){
            System.out.println(m);
        }else{
            System.out.print(m);
        }
    }

    public static void mostrarMenuPrincipal() {
        String titulo = "Inici";
        String decoradorLateral = "-".repeat(10); // 10 guiones

        String lineaMedia = String.format("%s %s %s", decoradorLateral, titulo, decoradorLateral);

        int longitudTotal = lineaMedia.length();
        String lineaBorde = "-".repeat(longitudTotal);

        System.out.println(String.format("""
                        %s
                        %s
                        %s
                        
                        1) Introduir producte
                        2) Pasar per caixa
                        3) Mostrar carret de compra
                        0) Terminar programa
                        """,
                lineaBorde, lineaMedia, lineaBorde));
    }

    public static void mostrarMenuProducte() {
        String titulo = "Producte";
        String decoradorLateral = "-".repeat(10); // 10 guiones

        String lineaMedia = String.format("%s %s %s", decoradorLateral, titulo, decoradorLateral);

        int longitudTotal = lineaMedia.length();
        String lineaBorde = "-".repeat(longitudTotal);

        System.out.println(String.format("""
                        %s
                        %s
                        %s
                        
                        1) Alimentació
                        2) Tèxtil
                        3) Electrònica
                        0) Tornar
                        """,
                lineaBorde, lineaMedia, lineaBorde));
    }



}
