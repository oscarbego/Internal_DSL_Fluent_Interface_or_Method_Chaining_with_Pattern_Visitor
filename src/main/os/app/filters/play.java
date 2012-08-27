package os.app.filters;

import os.app.RepMP3.inValue;
import os.app.RepMP3.toValue;

public interface play {

    public stop play();
    public stop play(inValue In);
    public stop play(inValue In, toValue To);
}