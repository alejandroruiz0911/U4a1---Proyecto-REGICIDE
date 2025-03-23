import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Baraja {;
    private ArrayList<Carta> barajaCartas;
    private ArrayList<Carta> castillo=new ArrayList<>();

    public Baraja() {
        this.barajaCartas = new ArrayList<>();
        generarCartas();
    }

    public ArrayList<Carta> getBarajaCartas() {
        return barajaCartas;
    }

    public void setBarajaCartas(ArrayList<Carta> barajaCartas) {
        this.barajaCartas = barajaCartas;
    }

    public void generarCartas(){
        String [] palos={"Picas", "Corazones", "Tréboles", "Diamantes"};
        for (String palo : palos) {
            for (int num = 1; num <= 13; num++) {
                barajaCartas.add(new Carta(palo, num));
            }
        }
        Collections.shuffle(barajaCartas);
    }

    public void cartasCastillo() {
        Iterator<Carta> iterator = barajaCartas.iterator();
        while (iterator.hasNext()) {
            Carta carta = iterator.next();
            if (carta.getNumero() >= 11) {
                castillo.add(carta);
                iterator.remove();
            }
        }
        Collections.shuffle(castillo);
    }

    public void mostrarCastillo() {
        System.out.println("Cartas en el castillo:");
        for (Carta carta : castillo) {
            System.out.println(carta);
        }
    }

    public Carta cartasJugador(){
        return barajaCartas.remove(0);
    }


    @Override
    public String toString() {
        return "Baraja{" +
                "barajaCartas=" + barajaCartas +
                '}';
    }
}
