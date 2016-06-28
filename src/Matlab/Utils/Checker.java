package Matlab.Utils;

import Matlab.DotNet.*;
import java.util.function.*;

public class Checker
{
    // region STATIC METHODS:

    public static <T> void Check(T value, Predicate<T> predicate)
    {
        if (predicate == null)
        {
            throw new DotNetArgumentNullException();
        }
        else
        {
            if (!predicate.test(value))
            {
                throw new DotNetArgumentException();
            }
        }
    }

    public static void CheckNotNull(Object value)
    {
        Checker.Check(value, x -> x != null);
    }

    public static void CheckDefined(Enum value)
    {
        return;
    }

    public static void CheckNotNegative(int value)
    {
        Checker.Check(value, x -> x >= 0);
    }

    public static void CheckInRange(int value, int min, int max)
    {
        Checker.Check(value, x -> x >= min && x <= max);
    }

    // endregion
}
