package os.app;

import os.app.filters.*;


public class RepMP3 implements Load, Conf, Play, Stop {

    enum Status {
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

    
    public static final class InValue {
        final int value;      
        InValue(int value){
            this.value = value;
        }
        
        public static void otroMetodo()
        {
            System.out.println("otro metodo value");
        }
        
    }
    public static InValue in(int value) {
        return new InValue(value);
    }
    
    public static final class ToValue {
        final int value;      
        ToValue(int value){
            this.value = value;
        }
    }
    public static ToValue to(int value) {
        return new ToValue(value);
    }
    
    public static final class ByValue {
        final int value;      
        ByValue(int value){
            this.value = value;
        }
    }
    public static ByValue by(int value) {
        return new ByValue(value);
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
    public Stop play(InValue in) {
    	System.out.println("Play desde " + in.value);
        return this;
    }  
    @Override
	public Stop play(InValue in, ToValue to) {
    	System.out.println("Play desde " + in.value + " hasta " + to.value);
		return this;
	}
    
    @Override
    public void stopIn(InValue in) {
    	System.out.println("Stop in " + in.value );
    }
    
     @Override
    public void pause(InValue in, ByValue by) {
        status = Status.Paused;
        System.out.println(getStatus());
            Pausa p = new Pausa(in, by);
            
            if (cmds != null) 
                p.setAction(cmds);       
    }
     
      
    public static final class Pausa implements Element {

        @Override
        public void setAction(Actions a) {
            a.action(this);
        }
        
        public Pausa (InValue in, ByValue by)
        {
            System.out.println("Pausa en " + in.value + " por " + by.value);
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

