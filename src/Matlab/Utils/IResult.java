package Matlab.Utils;

public interface IResult
{
    // region PROPERTIES:

    Object GetValue();

    IReport GetReport();

    boolean GetIsOk();

    // endregion
}
