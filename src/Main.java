import objectes.Alimentacio;
import objectes.Electronica;
import objectes.Producte;
import objectes.Textil;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try{
            iniDades();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Scanner scan = new Scanner(System.in);
//        Mal formateada la fecha
//        Producte p1 = new Alimentacio("Ojalata", 2.0,12345,"2028-01-27");
//        Producte p2 = new Alimentacio("Periodico", 5.99,12123123,"2027-01-02");
//        Producte p3 = new Alimentacio("Champion", 10.99,123123123,"2026-04-03");

        ArrayList<Producte> productes = new ArrayList<>();

        menuPrincipal(scan);

    }

    public static void menuPrincipal(Scanner scan){
        int opcio = -1;
        
        do {
            Vista.mostrarMenuPrincipal();

            try{
                opcio = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numero malament introduit");
                continue;
            }
            
            switch (opcio){
                case 1:
                    menuProductes(scan);
                    break;
                case 2:
                    Vista.mostrarMissatge(Model.generarTicket(true));
                    break;
                case 3:
                    Model.mostrarProductes();
                    break;
                case 0:
                    break;
                default:
                    Vista.mostrarMissatge("Opcion incorrecta");
            }
        }while(opcio != 0);
    }



    public static void menuProductes(Scanner scan){
        // TODO: Verificar el mayor del mes dia etc
        int opcio = -1;

        do {
            Vista.mostrarMenuProducte();

            try{
                opcio = Integer.parseInt(scan.nextLine());
                inicialitzarProducte(opcio);
            } catch (NumberFormatException e) {
                System.out.println("Opcio malament introduit");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }



        }while(opcio != 0);
    }


    public static void inicialitzarProducte(int opcio) throws Exception {

        Scanner scan = new Scanner(System.in);
        String dataCaducitat, composicio;
        int codiDeBarres, garantia;

        Producte producte;
        double preu;
        String nomProducte;

        switch (opcio){
            case 1:
                Vista.mostrarMissatge("Afegir aliment");

                System.out.print("Nom producte: ");
                nomProducte = scan.nextLine();

                System.out.print("Preu: ");
                preu = Double.parseDouble(scan.nextLine().replaceAll(",","."));

                System.out.print("Data de caducitat (dd/mm/aaaa): ");
                dataCaducitat = scan.nextLine().replaceAll("-", "/");
                // Formato: 2 dígitos - 2 dígitos - 4 dígitos
                if (!dataCaducitat.matches("\\d{2}/\\d{2}/\\d{4}")) {
                    // Es válido (ejemplo: 27-01-2028)
                    throw new Exception("Data malament introduida");
                }

                System.out.print("Codi de Barres: ");
                codiDeBarres = Integer.parseInt(scan.nextLine());

                producte = new Alimentacio(nomProducte, preu, codiDeBarres, dataCaducitat);
                Model.afegirProducte(producte);
                break;
            case 2:
                Vista.mostrarMissatge("Afegir textil");

                System.out.print("Nom producte: ");
                nomProducte = scan.nextLine();

                System.out.print("Preu: ");
                preu = Double.parseDouble(scan.nextLine().replaceAll(",","."));

                System.out.print("Composició: ");
                composicio = scan.nextLine();

                System.out.print("Codi de Barres: ");
                codiDeBarres = Integer.parseInt(scan.nextLine());

                producte = new Textil(nomProducte,preu, codiDeBarres, composicio);
                Model.afegirProducte(producte);

                break;
            case 3:
                Vista.mostrarMissatge("Afegir electronica");

                System.out.print("Nom producte: ");
                nomProducte = scan.nextLine();

                System.out.print("Preu: ");
                preu = Double.parseDouble(scan.nextLine().replaceAll(",","."));

                System.out.print("Garantia (dies): ");
                garantia = Integer.parseInt(scan.nextLine());

                System.out.print("Codi de Barres: ");
                codiDeBarres = Integer.parseInt(scan.nextLine());

                producte = new Electronica(nomProducte, preu, codiDeBarres, garantia);
                Model.afegirProducte(producte);
                break;
        }

    }

    public static void iniDades() throws Exception {
        // --- PRODUCTOS DE ALIMENTACIÓN ---
// Formato: nom, preu, codiDeBarres, dataCaducitat (AAAA-MM-DD según vimos en tu error)
        Model.afegirProducte(new Alimentacio("Llet de vaca", 1.20, 1001, "27/01/2028"));
        Model.afegirProducte(new Alimentacio("Iogurt Natural", 0.50, 1002, "15/05/2025"));
        Model.afegirProducte(new Alimentacio("Llet de vaca", 1.20, 1001, "27/01/2028"));

// --- PRODUCTOS DE TÈXTIL ---
// Formato: nom, preu, codiDeBarres, composicio (String)

        Model.afegirProducte(new Textil("Samarreta Algodó", 15.99, 2001, "100% Cotó"));
        Model.afegirProducte(new Textil("Pantalons Jeans", 35.50, 2002, "98% Dením, 2% Elastà"));

// --- PRODUCTOS DE ELECTRÓNICA ---
// Formato: nom, preu, codiDeBarres, diesGarantia (int)
        Model.afegirProducte(new Electronica("Ratolí Gaming", 25.00, 3001, 730)); // 2 años
        Model.afegirProducte(new Electronica("Teclat Mecànic", 55.00, 3002, 365)); // 1 año
        Model.afegirProducte(new Electronica("Teclat Mecànic", 55.00, 3002, 365)); // 1 año
    }
}