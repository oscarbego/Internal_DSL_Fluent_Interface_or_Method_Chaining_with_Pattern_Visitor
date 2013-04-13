package os.app;

/**
 * Representa una posicion dentro de un archivo MP3.
 *
 * @author Enrique Zamudio
 *         Date: 13/04/13 13:14
 */
public class Position {
    public enum Type {
        Start,
        End
    }

    private final Type type;
    private final int value;

    public Position(Type type, int value) {
        this.type = type;
        this.value = value;
    }

    public Type getType() {
        return type;
    }
    public int getValue() {
        return value;
    }

    public String toString() {
        return "POS[" + (type==Type.Start?"Ini":"Fin") + "]:" + value;
    }
}
