package os.app;


import os.app.RepMP3.Pausa;
//import static os.app.RepMP3.Pausa.otroMetodo;
import os.app.actions;

public class Commands implements actions
{

    @Override
    public void action(Pausa p) {
        System.out.println("Accion Pausa");
        p.otroMetodoNS();                
    }    
}
