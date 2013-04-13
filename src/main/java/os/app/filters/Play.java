package os.app.filters;

import os.app.RepMP3.InValue;
import os.app.RepMP3.ToValue;

public interface Play {

    public Stop play();
    public Stop play(InValue in);
    public Stop play(InValue in, ToValue to);
}
