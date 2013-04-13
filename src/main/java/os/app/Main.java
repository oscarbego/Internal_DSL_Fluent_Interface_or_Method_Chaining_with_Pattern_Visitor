package os.app;

import os.app.RepMP3.Pausa;

import static os.app.RepMP3.*;


public class Main {

	public static void main(String[] args) {

		System.out.println("-------------- Sin Conf ---------------------------");		
		
		getRepMP3().load("file.mp3").play().pause(from(7), duration(3));

		// or
		System.out.println("");
		System.out.println("--------------- Conf desde Commands ---------------");
				
		Commands c = new Commands();
        getRepMP3Conf().conf(c).load("file.mp3").play( from(4), to(30)).pause(from(5), duration(6));
      
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
        ).load("file.mp3").play( from(5), to(15) ).pause(from(7), duration(3));
      
        System.out.println("-----------------------------------------");
	
	}
}
