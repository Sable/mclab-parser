package Matlab.Utils;

import java.util.function.*;

public class EnumerablePlus
{
    // region STATIC METHODS:

    public static <T> void ForEach(Iterable<T> collection, Consumer<T> action)
    {
        Checker.CheckNotNull(collection);

        Checker.CheckNotNull(action);

        for (T item : collection)
        {
            action.accept(item);
        }
    }

    // endregion
}