package Matlab.Recognizer;

import Matlab.Utils.*;

public interface INotifier
{
    // region METHODS:

    void Notify(String path, IReport report);

    // endregion
}
