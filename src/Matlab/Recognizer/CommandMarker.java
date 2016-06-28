package Matlab.Recognizer;

import java.util.*;

class CommandMarker extends TreeSet<Integer>
{
    // region CONSTRUCTORS:

    public CommandMarker()
    {
        super();
    }

    // endregion

    // region METHODS:

    public boolean Contains(Integer item)
    {
        return this.contains(item);
    }

    public boolean Add(Integer item)
    {
        return this.add(item);
    }

    // endregion
}
