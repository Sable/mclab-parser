package Matlab.Recognizer;

import Matlab.Utils.*;

enum Channel
{
    Default,
    Skipped,
    Spaces;

    // region STATIC PROPERTIES:

    public static int GetDefaultInt() { return 0; }

    public static int GetSkippedInt() { return 1; }

    public static int GetSpacesInt() { return 2; }

    // endregion

    // region METHODS:

    public int ToInt()
    {
        switch (this)
        {
            case Default:
                return Channel.GetDefaultInt();
            case Skipped:
                return Channel.GetSkippedInt();
            case Spaces:
                return Channel.GetSpacesInt();
            default:
                throw new InternalException();
        }
    }

    // endregion
}
