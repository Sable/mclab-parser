package Matlab.DotNet;

public interface DotNetIList<T> extends Iterable<T>
{
    // region PROPERTIES:

    boolean GetIsReadOnly();

    int GetCount();

    // endregion

    // region INDEXERS:

    T GetIndex(int index);

    void SetIndex(int index, T value);

    // endregion

    // region METHODS:

    void Add(T item);

    void Clear();

    boolean Contains(T item);

    void CopyTo(T[] array, int arrayIndex);

    boolean Remove(T item);

    int IndexOf(T item);

    void Insert(int index, T item);

    void RemoveAt(int index);

    // endregion
}
