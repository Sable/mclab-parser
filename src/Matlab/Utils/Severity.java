package Matlab.Utils;

public enum Severity
{
    Info,
    Warning,
    Error;

    // region STATIC PROPERTIES:

    public static int GetInfoInt() { return 0; }

    public static int GetWarningInt() { return 1; }

    public static int GetErrorInt() { return 2; }

    // endregion

    // region METHODS:

    public int ToInt()
    {
        switch (this)
        {
            case Info:
                return Severity.GetInfoInt();
            case Warning:
                return Severity.GetWarningInt();
            case Error:
                return Severity.GetErrorInt();
            default:
                throw new InternalException();
        }
    }

    // endregion
}
