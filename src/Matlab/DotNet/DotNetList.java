package Matlab.DotNet;

import Matlab.Utils.*;

import java.util.*;

public class DotNetList<T> implements DotNetIList<T>
{
    // region FIELDS:

    private java.util.List<T> list;

    // endregion

    // region PROPERTIES:

    @Override
    public boolean GetIsReadOnly()
    {
        return false;
    }

    @Override
    public int GetCount()
    {
        return this.list.size();
    }

    // endregion

    // region CONSTRUCTORS:

    public DotNetList(java.util.List<T> list)
    {
        Checker.CheckNotNull(list);

        this.list = list;
    }

    public DotNetList()
    {
        this(new ArrayList<T>());
    }

    // endregion

    // region INDEXERS:

    @Override
    public T GetIndex(int index)
    {
        return this.list.get(index);
    }

    @Override
    public void SetIndex(int index, T value)
    {
        this.list.set(index, value);
    }

    // endregion

    // region METHODS:

    @Override
    public void Add(T item)
    {
        this.list.add(item);
    }

    @Override
    public void Clear()
    {
        this.list.clear();
    }

    @Override
    public boolean Contains(T item)
    {
        return this.list.contains(item);
    }

    @Override
    public void CopyTo(T[] array, int arrayIndex)
    {
        throw new DotNetNotImplementedException();
    }

    @Override
    public boolean Remove(T item)
    {
        return this.list.remove(item);
    }

    @Override
    public int IndexOf(T item)
    {
        return this.list.indexOf(item);
    }

    @Override
    public void Insert(int index, T item)
    {
        this.list.add(index, item);
    }

    @Override
    public void RemoveAt(int index)
    {
        this.list.remove(index);
    }

    // endregion

    // region JAVA MEMBERS:

    @Override
    public Iterator<T> iterator()
    {
        return this.list.iterator();
    }

    // endregion
}
