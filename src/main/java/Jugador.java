import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class Jugador extends Coordenada {
    private ObservableList<Coordenada> movimientos = FXCollections.observableArrayList();

    public Jugador(int coordenadaX, int coordenadaY) {
        super(coordenadaX, coordenadaY);

        movimientos.addListener(new ListChangeListener<Coordenada>() {
            @Override
            public void onChanged(Change<? extends Coordenada> change) {
                while (change.next()) {
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
            movimientos.add(new Coordenada(getCoordenadaX(), getCoordenadaY()));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());

        }
    }
}

