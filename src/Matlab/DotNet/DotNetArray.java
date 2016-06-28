package Matlab.DotNet;

public class DotNetArray
{
    // region STATIC METHODS:

    public static boolean Contains(int[] array, int element)
    {
        for(int item : array)
        {
            if (item == element)
            {
                return true;
            }
        }

        return false;
    }

    // endregion
}
