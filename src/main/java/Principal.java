import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("=================================");
        System.out.println("BIENVENIDO A REGICIDE");
        System.out.println("MODO SOLITARIO");
        System.out.println("=================================");
        System.out.println();
        System.out.println();
        System.out.println("=================================");


        Baraja baraja = new Baraja();
        baraja.cartasCastillo();

        ArrayList<Carta> mano= new ArrayList<>();
        for (int i =1; i<=8; i++){
            mano.add(baraja.cartasJugador());
        }

        System.out.println("Tu mano actual: ");
        for (int i =0; i< mano.size(); i++){
            System.out.println("["+(i+1)+"] "+ mano.get(i).getNumero()+" de "+mano.get(i).getPalo());
        }

        System.out.println("Enemigo actual en el castillo");
        baraja.mostrarEnemigo();

        System.out.println("Cartas restantes");
        System.out.println("- Castillo: "+baraja.getCastillo().size());
        System.out.println("- Mazo posada: "+baraja.getBarajaCartas().size());
        System.out.println("- Mazo de cartas jugadas: "+baraja.getMazoCartasJugadas().size());
        System.out.println("- Mazo de descartes: "+baraja.getMazoDescartes().size());
        System.out.println();
        System.out.println();
        System.out.println("=================================");
        System.out.println("Comienza la pelea");

        for (int i =0;i <15;i++) {
            System.out.print("Selecciona una carta para jugar (1-8): ");
            int seleccion = sc.nextInt();

            baraja.jugarCarta(seleccion, mano, baraja.getMazoCartasJugadas());

            System.out.println("Tu mano actual: ");
            for (int j = 0; j < mano.size(); j++) {
                System.out.println("[" + (j + 1) + "] " + mano.get(j).getNumero() + " de " + mano.get(j).getPalo());
            }

        }
    }
}