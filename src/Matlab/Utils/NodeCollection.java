package Matlab.Utils;

import Matlab.DotNet.*;

public class NodeCollection extends Sequence<Node> implements IFreezable
{
    // region FIELDS:

    private Node owner;

    // endregion

    // region PROPERTIES:

    // region TREE PROPERTIES:

    public Node GetOwner()
    {
        return this.owner;
    }

    private void SetOwner(Node value)
    {
        this.owner = value;
    }

    // endregion

    // region ACCESS PROPERTIES:

    @Override
    public boolean GetIsReadOnly()
    {
        return this.GetIsFrozen();
    }

    // endregion

    // region FREEZE PROPERTIES:

    public boolean GetIsFrozen()
    {
        return this.GetOwner().GetIsFrozen();
    }

    public boolean GetCanFreeze()
    {
        return false;
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    NodeCollection(Node owner)
    {
        super();

        Checker.CheckNotNull(owner);

        this.SetOwner(owner);
    }

    // endregion

    // region METHODS:

    // region CHECK METHODS:

    protected void CheckCanFreeze()
    {
        if (!this.GetCanFreeze())
        {
            throw new DotNetInvalidOperationException();
        }
    }

    // endregion

    // region EXTRA METHODS:

    @Override
    protected void OnItemInserting(Node item)
    {
        if (!item.GetIsRoot() || item.GetIsFrozen())
        {
            throw new DotNetArgumentException();
        }
    }

    @Override
    protected void OnItemInserted(Node item)
    {
        item.SetParent(this.GetOwner());
    }

    @Override
    protected void OnItemRemoved(Node item)
    {
        item.SetParent(null);
    }

    // endregion

    // region FREEZE METHODS:

    public void Freeze()
    {
        this.CheckCanFreeze();
    }

    // endregion

    // endregion
}
