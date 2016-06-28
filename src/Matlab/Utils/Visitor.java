package Matlab.Utils;

public abstract class Visitor
{
    // region CONSTRUCTORS:

    protected Visitor()
    {
        return;
    }

    // endregion

    // region METHODS:

    public abstract Object RunOn(INode node);

    protected abstract Object Visit(INode node);

    // endregion
}
