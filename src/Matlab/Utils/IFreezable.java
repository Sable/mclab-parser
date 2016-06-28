package Matlab.Utils;

public interface IFreezable
{
    // region PROPERTIES:

    boolean GetIsFrozen();

    boolean GetCanFreeze();

    // endregion

    // region METHODS:

    void Freeze();

    // endregion
}
