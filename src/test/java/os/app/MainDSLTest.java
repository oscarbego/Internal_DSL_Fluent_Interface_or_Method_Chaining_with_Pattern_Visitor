package os.app;

import org.junit.*;

import os.app.RepMP3.Pausa;
import static os.app.RepMP3.*;

public class MainDSLTest {

  @Before
  public void delimitador(){
    System.out.println("*******************************");
  }

  @Test
  public void pruebaDSLSinConfiguracion(){
    getRepMP3().load("file.mp3").play().pause(in(7), by(3));
  }

  @Test
  public void pruebaDSLConConfiguracionDesdeCommands(){
    Commands c = new Commands();
    getRepMP3Conf().conf(c).load("file.mp3").play( in(4), to(30)).pause(in(5), by(6));
  }

  @Test
  public void pruebaDSLConConfiguracionDeObjetoAnonimo(){
    getRepMP3Conf().conf(
      new Actions() {
        @Override
        public void action(Pausa p) {
          System.out.println("Otra accion para la pausa ");
        }
      }          
      ).load("file.mp3").play( in(5), to(15) ).pause(in(7), by(3));
  }
}
