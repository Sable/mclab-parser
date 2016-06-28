package Matlab.Utils;

import Matlab.DotNet.*;
import java.util.*;

public class ReadOnlySequence<T> implements ISequence<T>
{
    // region FIELDS:

    private ISequence<T> innerCollection;

    // endregion

    // region PROPERTIES:

    protected ISequence<T> GetInnerCollection()
    {
        return this.innerCollection;
    }

    private void SetInnerCollection(ISequence<T> value)
    {
        this.innerCollection = value;
    }

    public boolean GetIsReadOnly()
    {
        return true;
    }

    public int GetCount()
    {
        return this.GetInnerCollection().GetCount();
    }

    public boolean GetIsEmpty()
    {
        return (this.GetInnerCollection().GetCount() == 0);
    }

    // endregion

    // region CONSTRUCTORS:

    public ReadOnlySequence(ISequence<T> innerCollection)
    {
        Checker.CheckNotNull(innerCollection);

        this.SetInnerCollection(innerCollection);
    }

    // endregion

    // region INDEXERS:

    public T GetIndex(int index)
    {
        return this.GetInnerCollection().GetIndex(index);
    }

    public void SetIndex(int index, T value)
    {
        this.CheckNotReadOnly();
    }

    // endregion

    // region METHODS:

    // region CHECK METHODS:

    protected void CheckNotReadOnly()
    {
        if (this.GetIsReadOnly())
        {
            throw new DotNetInvalidOperationException();
        }
    }

    // endregion

    // region QUERY METHODS:

    public int IndexOf(T item)
    {
        return this.GetInnerCollection().IndexOf(item);
    }

    public boolean Contains(T item)
    {
        return this.GetInnerCollection().Contains(item);
    }

    public void CopyTo(T[] array, int arrayIndex)
    {
        this.GetInnerCollection().CopyTo(array, arrayIndex);
    }

    // endregion

    // region ALTER METHODS:

    public void Insert(int index, T item)
    {
        this.CheckNotReadOnly();
    }

    public void Add(T item)
    {
        this.CheckNotReadOnly();
    }

    public void AddRange(Iterable<? extends T> collection)
    {
        this.CheckNotReadOnly();
    }

    public void RemoveAt(int index)
    {
        this.CheckNotReadOnly();
    }

    public boolean Remove(T item)
    {
        this.CheckNotReadOnly();

        return false;
    }

    public void RemoveRange(Iterable<? extends T> collection)
    {
        this.CheckNotReadOnly();
    }

    public void Clear()
    {
        this.CheckNotReadOnly();
    }

    // endregion

    // endregion

    // region JAVA MEMBERS:

    @Override
    public Iterator<T> iterator()
    {
        return this.GetInnerCollection().iterator();
    }

    // endregion
}
