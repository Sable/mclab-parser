package Matlab.DotNet;

public class DotNetConsole
{
    // region STATIC METHODS:

    public static void WriteLine()
    {
        System.out.println();
    }

    public static void WriteLine(String format, Object... args)
    {
        System.out.printf(format, args);

        System.out.println();
    }

    // endregion
}
