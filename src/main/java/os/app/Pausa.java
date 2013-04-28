package os.app;

public final class Pausa implements Element {

    @Override
    public void setAction(Actions a) {
        a.action(this);
    }

    public Pausa(Position in, int duration)
    {
        System.out.println("Pausa en " + in.getValue() + " por " + duration);
    }

    public void otroMetodoNS()
    {
        System.out.println("otro metodo");
    }

    public static void otroMetodo()
    {
        System.out.println("otro metodo pero static");
    }
}
