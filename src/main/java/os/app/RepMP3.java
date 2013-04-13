package os.app;

import os.app.filters.*;


public class RepMP3 implements Load, Conf, Play, Stop {

    public enum Status {
        Loading("Cargando archivo"),
        Playing("Tocando canción"),
        Stopped("Detenido"),
        Paused("En pausa");
        private String name;
        Status(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    private static RepMP3 p;
    private Actions cmds;
    private String song;
    private Status status;
    //private RepMP3(){	}

    @Override
    public Load conf(Actions cmds) {
        this.cmds = cmds;
        return this;
    }

    public static Position from(int value) {
        return new Position(Position.Type.Start, value);
    }
    
    public static Position to(int value) {
        return new Position(Position.Type.End, value);
    }
    public static int duration(int value) {
        return value;
    }
    
    
    public static Load getRepMP3()
    {
        if(p == null)
        {
            p = new RepMP3();
        }
        return p;
    }
    
    public static Conf getRepMP3Conf()
    {
        if(p == null)
        {
            p = new RepMP3();
        }
        System.out.println("Preparando reproductor MP3");
        return p;
    }
    
    @Override
    public Play load(String mp3) {
        song = mp3;
        status = Status.Loading;
        System.out.println(getStatus());
        return this;
    }

    @Override
    public Stop play() {
        status = Status.Playing;
    	System.out.println(getStatus());
        return this;
    }
    @Override
    public Stop play(Position from) {
    	System.out.println("Play desde " + from.getValue());
        return this;
    }  
    @Override
	public Stop play(Position from, Position to) {
    	System.out.println("Play desde " + from.getValue() + " hasta " + from.getValue());
		return this;
	}
    
    @Override
    public void stopAt(Position at) {
    	System.out.println("Stop in " + at.getValue() );
    }
    
     @Override
    public void pause(Position at, int duration) {
        status = Status.Paused;
        System.out.println(getStatus());
            Pausa p = new Pausa(at, duration);
            
            if (cmds != null) 
                p.setAction(cmds);       
    }
     
      
    public static final class Pausa implements Element {

        @Override
        public void setAction(Actions a) {
            a.action(this);
        }
        
        public Pausa (Position in, int duration)
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
	
     
    private String getStatus(){
        return status + ": " + song;
    }
}

