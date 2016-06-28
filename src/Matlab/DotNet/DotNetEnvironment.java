package Matlab.DotNet;

public class DotNetEnvironment
{
    // region PROPERTIES:

    public static String GetNewLine()
    {
        return System.lineSeparator();
    }

    public static String GetCurrentDirectory()
    {
        return System.getProperty("user.dir");
    }

    // endregion
}
