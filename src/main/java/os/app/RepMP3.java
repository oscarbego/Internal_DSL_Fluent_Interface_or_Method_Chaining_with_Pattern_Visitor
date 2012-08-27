package os.app;

import os.app.filters.*;


public class RepMP3 implements load, conf, play, stop {

    private static RepMP3 p;
    private actions cmds;
    //private RepMP3(){	}

    @Override
    public load conf( actions cmds) {
        this.cmds = cmds;
        return this;
    }

    
    public static final class inValue {
        final int value;      
        inValue(int value){
            this.value = value;
        }
        
        public static void otroMetodo()
        {
            System.out.println("otro metodo value");
        }
        
    }
    public static inValue in(int value) {
        return new inValue(value);
    }
    
    public static final class toValue {
        final int value;      
        toValue(int value){
            this.value = value;
        }
    }
    public static toValue to(int value) {
        return new toValue(value);
    }
    
    public static final class byValue {
        final int value;      
        byValue(int value){
            this.value = value;
        }
    }
    public static byValue by(int value) {
        return new byValue(value);
    }
    
    
    public static load getRepMP3()
    {
        if(p == null)
        {
            p = new RepMP3();
        }
        
        return p;
    }
    
    public static conf getRepMP3Conf()
    {
        if(p == null)
        {
            p = new RepMP3();
        }
        
        return p;
    }
    
    @Override
    public play load(String mp3) {
        System.out.println("Se cargo " + mp3);
        return this;
    }

    @Override
    public stop play() {
    	System.out.println("Play");
        return this;
    }
    @Override
    public stop play(inValue In) {
    	System.out.println("Play desde " + In.value);
        return this;
    }  
    @Override
	public stop play(inValue In, toValue To) {
    	System.out.println("Play desde " + In.value + " hasta " + To.value);
		return this;
	}
    
    @Override
    public void sotopIn(inValue In) {
    	System.out.println("Stop in " + In.value );
    }
    
     @Override
    public void pause(inValue In, byValue By) {
        
            Pausa p = new Pausa(In, By);
            
            if (cmds != null) 
                p.setAction(cmds);       
    }
     
      
    public static final class Pausa implements Element {

        @Override
        public void setAction(actions a) {
            a.action(this); 
        }
        
        public Pausa (inValue In, byValue By)
        {
            System.out.println("Pausa en " + In.value + " por " + By.value);
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
	
     
    
}

