import javafx.collections.ListChangeListener;

import java.util.Random;

class Enemigo extends Coordenada implements ListChangeListener<Coordenada> {
    //en enemigo definimos un jugador para poder observar el listado de movimientos.
    //además esto nos facilita añadir mas enemigos en el futuro.
    private Jugador jugador;

    public Enemigo(int y, int x, Jugador jugador) {
        super(y, x);
        this.jugador = jugador;
        //añadimos el listener para que cuando el jugador se mueva, el enemigo se mueva hacia él
        jugador.getMovimientos().addListener(this);
    }

    @Override
    public void onChanged(Change<? extends Coordenada> change) {
        while (change.next()) {
            if (change.wasAdded()) {
                moverHaciaJugador();
                System.out.println("El enemigo se ha movido a la posición " + this);
            }
        }
    }

    private void moverHaciaJugador() {
        int deltaX = jugador.getCoordenadaX() - getCoordenadaX();
        int deltaY = jugador.getCoordenadaY() - getCoordenadaY();

        if (Math.abs(deltaX) > Math.abs(deltaY)) {
            setCoordenadaX(getCoordenadaX() + (deltaX > 0 ? 2 : -2));
        } else {
            setCoordenadaY(getCoordenadaY() + (deltaY > 0 ? 2 : -2));
        }
    }

}
