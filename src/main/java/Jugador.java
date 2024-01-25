import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class Jugador extends Coordenada {
    //creamos una lista observable para que cuando se mueva el jugador se añada el movimiento a la lista
    private ObservableList<Coordenada> movimientos = FXCollections.observableArrayList();

    public Jugador(int coordenadaY, int coordenadaX) {
        super(coordenadaY, coordenadaX);

        movimientos.addListener(new ListChangeListener<Coordenada>() {
            @Override
            public void onChanged(Change<? extends Coordenada> change) {
                while (change.next()) {
                    //el metodo .wasAdded actua cuando añadimos un movimiento a la lista.
                    if (change.wasAdded()) {
                        System.out.println("El jugador se ha movido a la posición " + change.getAddedSubList().get(0));
                    }
                }
            }
        });
        /*esto es lo mismo de arriba pero en funcion lambda
        movimientos.addListener((ListChangeListener<Coordenada>) change -> {
            while (change.next()) {
                if (change.wasAdded()) {
                    System.out.println("El jugador se ha movido a la posición " + change.getAddedSubList().get(0));
                }
            }
        });*/
    }

    public ObservableList<Coordenada> getMovimientos() {
        return movimientos;
    }

    public void movimiento(String direccion) {
        try {
            switch (direccion) {
                case "w":
                    setCoordenadaY(getCoordenadaY() + 1);
                    break;
                case "s":
                    setCoordenadaY(getCoordenadaY() - 1);
                    break;
                case "d":
                    setCoordenadaX(getCoordenadaX() + 1);
                    break;
                case "a":
                    setCoordenadaX(getCoordenadaX() - 1);
                    break;
                default:
                    throw new IllegalArgumentException("Dirección no válida");
            }
            //aqui añadimos el movimiento indicado y funcionará el método onChanged de la lista observable
            movimientos.add(new Coordenada(getCoordenadaX(), getCoordenadaY()));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());

        }
    }

}

