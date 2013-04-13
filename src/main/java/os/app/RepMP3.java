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


    private String getStatus(){
        return status + ": " + song;
    }
}

