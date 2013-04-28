package os.app.filters;

import os.app.Position;

public interface Stop {
    public void stopAt(Position at);
    public void pause( Position at, int duration);
}
