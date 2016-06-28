package Matlab.Nodes;

import Matlab.Utils.*;

public class Text
{
    // region STATIC METHODS:

    public static String UnquoteString(String text)
    {
        Checker.CheckNotNull(text);

        Checker.Check(text, x -> x.length() >= 2 && x.startsWith("'") && x.endsWith("'"));

        return text.substring(1, text.length() - 1).replace("''", "'");
    }

    public static String QuoteString(String text)
    {
        Checker.CheckNotNull(text);

        return String.format("'%1$s'", text.replace("'", "''"));
    }

    // endregion
}
