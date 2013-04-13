package os.app;


import os.app.RepMP3.Pausa;
//import static os.app.RepMP3.Pausa.otroMetodo;

public class Commands implements Actions
{

    @Override
    public void action(Pausa p) {
        System.out.println("Accion Pausa");
        p.otroMetodoNS();                
    }    
}
