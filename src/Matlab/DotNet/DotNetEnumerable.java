package Matlab.DotNet;

import java.util.*;
import java.util.function.*;

public class DotNetEnumerable
{
    // region STATIC METHODS:

    // region COLLECTION METHODS:

    public static <T> Iterable<T> ToIterable(T[] collection)
    {
        LinkedList<T> linkedList = new LinkedList<T>();

        for (T item : collection)
        {
            linkedList.add(item);
        }

        return linkedList;
    }

    public static <T> DotNetList<T> ToDotNetList(Iterable<T> collection)
    {
        ArrayList<T> arrayList = new ArrayList<T>();

        for (T item: collection)
        {
            arrayList.add(item);
        }

        return new DotNetList<T>(arrayList);
    }

    public static <T> List<T> ToList(Iterable<T> collection)
    {
        ArrayList<T> list = new ArrayList<T>();

        for (T item : collection)
        {
            list.add(item);
        }

        return list;
    }

    // endregion

    // region PREDICATE METHODS:

    public static <T> Iterable<T> Where(Iterable<T> collection, Predicate<T> predicate)
    {
        LinkedList<T> linkedList = new LinkedList<T>();

        for (T item: collection)
        {
            if (predicate.test(item))
            {
                linkedList.add(item);
            }
        }

        return linkedList;
    }

    public static <T> T First(Iterable<T> collection)
    {
        LinkedList<T> linkedList = new LinkedList<T>();

        for (T item : collection)
        {
            return item;
        }

        throw new DotNetArgumentException();
    }

    public static <T> T FirstOrDefault(Iterable<T> collection, Predicate<T> predicate)
    {
        LinkedList<T> linkedList = new LinkedList<T>();

        for (T item : collection)
        {
            if (predicate.test(item))
            {
                return item;
            }
        }

        return null;
    }

    public static <T> T FirstOrDefault(Iterable<T> collection)
    {
        return DotNetEnumerable.FirstOrDefault(collection, x -> true);
    }

    public static <T1, T2> Iterable<T2> OfType(Iterable<T1> collection, Class<T2> type)
    {
        LinkedList<T2> linkedList = new LinkedList<T2>();

        for (T1 item : collection)
        {
            if (item == null || type.isAssignableFrom(item.getClass()))
            {
                linkedList.add((T2)item);
            }
        }

        return linkedList ;
    }

    public static <T1, T2> Iterable<T2> Cast(Iterable<T1> collection, Class<T2> type)
    {
        LinkedList<T2> linkedList = new LinkedList<T2>();

        for (T1 item : collection)
        {
            linkedList.add((T2)item);
        }

        return linkedList;
    }

    public static <T> Iterable<T> Skip(Iterable<T> collection, int count)
    {
        LinkedList<T> linkedList = new LinkedList<T>();

        int currentCount = 0;

        for (T item: collection)
        {
            if (currentCount >= count)
            {
                linkedList.add(item);
            }
            else
            {
                currentCount++;
            }
        }

        return linkedList;
    }

    public static <T> int Count(Iterable<T> collection)
    {
        if (collection instanceof List<?>)
        {
            return ((List<?>)collection).size();
        }
        else if (collection instanceof DotNetIList<?>)
        {
            return ((DotNetIList<?>)collection).GetCount();
        }
        else
        {
            int count = 0;

            for (T item : collection)
            {
                count++;
            }

            return count;
        }
    }

    public static int Max(Iterable<Integer> collection)
    {
        int count = 0;

        int max = Integer.MIN_VALUE;

        for (Integer integer: collection)
        {
            count++;

            if (count == 1)
            {
                max = integer.intValue();
            }
            else
            {
                int newInt = integer.intValue();

                if (newInt > max)
                {
                    max = newInt;
                }
            }
        }

        if (count == 0)
        {
            throw new DotNetArgumentException();
        }
        else
        {
            return max;
        }
    }

    public static <T1, T2> Iterable<T2> Select(Iterable<T1> collection, Function<T1, T2> function)
    {
        LinkedList<T2> linkedList = new LinkedList<T2>();

        for (T1 item : collection)
        {
            linkedList.add(function.apply(item));
        }

        return linkedList ;
    }

    public static <T> T Single(Iterable<T> collection)
    {
        int count = 0;

        T result = null;

        for(T item: collection)
        {
            count++;

            if (count == 1)
            {
                result = item;
            }
            else
            {
                break;
            }
        }

        if (count == 1)
        {
            return result;
        }
        else
        {
            throw new DotNetArgumentException();
        }
    }

    public static <T> int IndexOf(Iterable<? extends T> collection, T element)
    {
        int index = 0;

        for (T item : collection)
        {
            if ((item == null && element == null) || item.equals(element))
            {
                return index;
            }

            index++;
        }

        return -1;
    }

    // endregion

    // endregion
}
