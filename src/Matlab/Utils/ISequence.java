package Matlab.Utils;

import Matlab.DotNet.DotNetIList;

public interface ISequence<T> extends DotNetIList<T>
{
    // region PROPERTIES:

    boolean GetIsEmpty();

    // endregion

    // region METHODS:

    void AddRange(Iterable<? extends T> collection);

    void RemoveRange(Iterable<? extends T> collection);

    // endregion
}
