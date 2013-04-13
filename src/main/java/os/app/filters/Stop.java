package os.app.filters;

import os.app.RepMP3;

public interface Stop {
    public void stopIn(RepMP3.InValue in);
    public void pause( RepMP3.InValue in, RepMP3.ByValue By);
}
