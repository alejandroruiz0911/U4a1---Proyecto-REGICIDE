import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        System.out.println("=================================");
        System.out.println("BIENVENIDO A REGICIDE");
        System.out.println("MODO SOLITARIO");
        System.out.println("=================================");
        System.out.println();
        System.out.println();
        System.out.println("=================================");

        // Crear la baraja
        Baraja baraja = new Baraja();

        // Mostrar la baraja completa (opcional, solo para verificación)
        System.out.println("Baraja completa:");
        System.out.println(baraja.getBarajaCartas());

        // Separar las cartas del castillo
        baraja.cartasCastillo();

        // Mostrar la baraja después de separar el castillo
        System.out.println("Baraja después de separar el castillo:");
        System.out.println(baraja.getBarajaCartas());

        // Mostrar el castillo
        System.out.println("Cartas en el castillo:");
        baraja.mostrarCastillo();

        ArrayList<Carta> mano= new ArrayList<>();
        for (int i =1; i<=8; i++){
            mano.add(baraja.cartasJugador());
        }
        System.out.println(mano);
    }
}