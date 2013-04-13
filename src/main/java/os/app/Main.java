package os.app;

import os.app.RepMP3.Pausa;

import static os.app.RepMP3.*;


public class Main {

	public static void main(String[] args) {

		System.out.println("-------------- Sin Conf ---------------------------");		
		
		getRepMP3().load("file.mp3").play().pause(in(7), by(3));

		// or
		System.out.println("");
		System.out.println("--------------- Conf desde Commands ---------------");
				
		Commands c = new Commands();
        getRepMP3Conf().conf(c).load("file.mp3").play( in(4), to(30)).pause(in(5), by(6));
      
        // or
        System.out.println("");
        System.out.println("--------------- Conf Objeto Anonimo ---------------");		
		
        getRepMP3Conf().conf(
   
          new Actions() {
              
              @Override
              public void action(Pausa p) {
                  System.out.println("Otra accion para la pausa ");
             }
          }          
        ).load("file.mp3").play( in(5), to(15) ).pause(in(7), by(3));
      
        System.out.println("-----------------------------------------");
	
	}
}
