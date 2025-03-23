import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Baraja {;
    private ArrayList<Carta> barajaCartas;
    private ArrayList<Carta> castillo=new ArrayList<>();
    private ArrayList<Carta> mazoCartasJugadas=new ArrayList<>();
    private ArrayList<Carta> mazoDescartes = new ArrayList<>();

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

    public ArrayList<Carta> getCastillo() {
        return castillo;
    }

    public void setCastillo(ArrayList<Carta> castillo) {
        this.castillo = castillo;
    }

    public ArrayList<Carta> getMazoCartasJugadas() {
        return mazoCartasJugadas;
    }

    public void setMazoCartasJugadas(ArrayList<Carta> mazoCartasJugadas) {
        this.mazoCartasJugadas = mazoCartasJugadas;
    }

    public ArrayList<Carta> getMazoDescartes() {
        return mazoDescartes;
    }

    public void setMazoDescartes(ArrayList<Carta> mazoDescartes) {
        this.mazoDescartes = mazoDescartes;
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

    public void mostrarEnemigo(){
        Carta enemigo= castillo.get(0);

        String nombre = "";
        int vida = 0;

        switch (enemigo.getNumero()){
            case 11:
                nombre="Jota de "+ enemigo.getPalo();
                vida=20;
                break;
            case 12:
                nombre="Reina de "+ enemigo.getPalo();
                vida=30;
                break;
            case 13:
                nombre="Rey de "+ enemigo.getPalo();
                vida=40;
                break;
        }
        System.out.println(nombre +" (Vida: "+vida+")");
    }

    public Carta cartasJugador(){
        return barajaCartas.remove(0);
    }

    public void jugarCarta(int indice, ArrayList<Carta> manoJugador,ArrayList<Carta> manoJugadas ){
        Carta jugada=manoJugador.remove(indice);

        manoJugadas.add(jugada);
        int danio= jugada.getNumero();
        Carta enemigo= castillo.get(0);

        int vida = 0;
        switch (enemigo.getNumero()){
            case 11:
                vida=20;
                break;
            case 12:
                vida=30;
                break;
            case 13:
                vida=40;
                break;
        }
        vida-=danio;

        System.out.println("Has jugado: "+jugada.getNumero()+" de "+jugada.getPalo());
        System.out.println("Daño causado al enemigo: "+jugada.getNumero());
        System.out.println("Vida restante del enemigo: "+vida);

    }


    @Override
    public String toString() {
        return "Baraja{" +
                "barajaCartas=" + barajaCartas +
                '}';
    }


}
