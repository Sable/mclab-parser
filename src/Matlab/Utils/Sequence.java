package Matlab.Utils;

import Matlab.DotNet.*;
import java.util.*;

public class Sequence<T> implements ISequence<T>
{
    // region FIELDS:

    private ArrayList<T> innerList;

    // endregion

    // region PROPERTIES:

    private ArrayList<T> GetInnerList()
    {
        return this.innerList;
    }
    
    private void SetInnerList(ArrayList<T> value)
    {
        this.innerList = value;
    }

    public boolean GetIsReadOnly()
    {
        return false;
    }

    public int GetCount()
    {
        return this.GetInnerList().size();
    }

    public boolean GetIsEmpty()
    {
        return (this.GetInnerList().size() == 0);
    }

    public int GetCapacity()
    {
        return this.GetInnerList().size();
    }

    // endregion

    // region CONSTRUCTORS:

    public Sequence(int initialCapacity)
    {
        Checker.CheckNotNegative(initialCapacity);

        this.SetInnerList(new ArrayList<T>(initialCapacity));
    }

    public Sequence(Iterable<T> collection)
    {
        this(0);

        this.AddRange(collection);
    }

    public Sequence()
    {
        this(0);
    }

    // endregion

    // region INDEXERS:

    public T GetIndex(int index)
    {
        this.CheckInRangeForQuery(index);

        return this.GetInnerList().get(index);
    }

    public void SetIndex(int index, T value)
    {
        this.CheckNotReadOnly();

        this.CheckInRangeForQuery(index);

        Checker.CheckNotNull(value);

        this.RemoveAt(index);

        this.Insert(index, value);
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

    protected void CheckInRangeForQuery(int index)
    {
        Checker.CheckInRange(index, 0, this.GetCount() - 1);
    }

    protected void CheckInRangeForInsert(int index)
    {
        Checker.CheckInRange(index, 0, this.GetCount());
    }

    // endregion

    // region EXTRA METHODS:

    protected void OnItemInserting(T item)
    {
        return;
    }

    protected void OnItemInserted(T item)
    {
        return;
    }

    protected void OnItemRemoving(T item)
    {
        return;
    }

    protected void OnItemRemoved(T item)
    {
        return;
    }

    // endregion

    // region QUERY METHODS:

    public int IndexOf(T item)
    {
        return this.GetInnerList().indexOf(item);
    }

    public boolean Contains(T item)
    {
        return this.GetInnerList().contains(item);
    }

    public void CopyTo(T[] array, int arrayIndex)
    {
        throw new DotNetNotImplementedException();
    }

    // endregion

    // region ALTER METHODS:

    public void TrimExcess()
    {
        throw new DotNetNotImplementedException();
    }

    public void Insert(int index, T item)
    {
        this.CheckNotReadOnly();

        this.CheckInRangeForInsert(index);

        Checker.CheckNotNull(item);

        this.OnItemInserting(item);

        this.GetInnerList().add(index, item);

        this.OnItemInserted(item);
    }

    public void Add(T item)
    {
        this.CheckNotReadOnly();

        this.Insert(this.GetCount(), item);
    }

    public void AddRange(Iterable<? extends T> collection)
    {
        this.CheckNotReadOnly();

        Checker.CheckNotNull(collection);

        EnumerablePlus.ForEach(DotNetEnumerable.ToDotNetList(collection), x -> this.Add(x));
    }

    public void RemoveAt(int index)
    {
        this.CheckNotReadOnly();

        this.CheckInRangeForQuery(index);

        T item = this.GetInnerList().get(index);

        this.OnItemRemoving(item);

        this.GetInnerList().remove(index);

        this.OnItemRemoved(item);
    }

    public boolean Remove(T item)
    {
        this.CheckNotReadOnly();

        int index = this.IndexOf(item);

        if (index >= 0)
        {
            this.RemoveAt(index);

            return true;
        }
        else
        {
            return false;
        }
    }

    public void RemoveRange(Iterable<? extends T> collection)
    {
        this.CheckNotReadOnly();

        Checker.CheckNotNull(collection);

        EnumerablePlus.ForEach(DotNetEnumerable.ToDotNetList(collection), x -> this.Remove(x));
    }

    public void Clear()
    {
        this.CheckNotReadOnly();

        while (!this.GetIsEmpty())
        {
            this.RemoveAt(this.GetCount() - 1);
        }
    }

    // endregion

    // endregion

    // region JAVA MEMBERS:

    @Override
    public Iterator<T> iterator()
    {
        return this.GetInnerList().iterator();
    }

    // endregion
}