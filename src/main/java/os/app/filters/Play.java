package os.app.filters;

import os.app.Position;

public interface Play {

    public Stop play();
    public Stop play(Position from);
    public Stop play(Position from, Position to);
}
