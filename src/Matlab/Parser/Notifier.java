package Matlab.Parser;

import Matlab.DotNet.*;
import Matlab.Utils.*;
import Matlab.Recognizer.*;

class Notifier implements INotifier
{
    // region CONSTRUCTORS:

    public Notifier()
    {
    }

    // endregion

    // region METHODS:

    public void Notify(String path, IReport report)
    {
        DotNetConsole.WriteLine();

        DotNetConsole.WriteLine("File: %1$s", path);

        for (Message message : report)
        {
            DotNetConsole.WriteLine("[%1$s] Line: [%2$s] Column: [%3$s] Text: [%4$s]", message.GetSeverity(), message.GetLine(), message.GetColumn(), message.GetText());
        }
    }

    // endregion
}
