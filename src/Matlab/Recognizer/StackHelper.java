package Matlab.Recognizer;

import Matlab.Utils.*;
import java.util.*;
import java.util.function.*;

class StackHelper
{
    // region STATIC METHODS:
        
    // region STANDARD METHODS:

    public static <T> void Push(Stack<T> stack, T item)
    {
        stack.push(item);
    }

    public static <T> T Peek(Stack<T> stack)
    {
        return stack.peek();
    }

    public static <T> T Pop(Stack<T> stack)
    {
        return stack.pop();
    }

    public static <T> int Count(Stack<T> stack)
    {
        return stack.size();
    }

    // endregion

    // region ADDITIONAL METHODS:

    public static <T> boolean IsEmpty(Stack<T> stack)
    {
        return (StackHelper.Count(stack) == 0);
    }

    public static <T> boolean OnTop(Stack<T> stack, T item)
    {
        return StackHelper.OnTop(stack, (Predicate<T>)(x -> x.equals(item)));
    }

    public static <T> boolean OnTop(Stack<T> stack, Predicate<T> predicate)
    {
        return (!StackHelper.IsEmpty(stack) && predicate.test(StackHelper.Peek(stack)));
    }

    public static <T> void Pop(Stack<T> stack, T item)
    {
        if (StackHelper.OnTop(stack, item))
        {
            StackHelper.Pop(stack);
        }
        else
        {
            throw new InternalException();
        }
    }

    // endregion

    // endregion
}
