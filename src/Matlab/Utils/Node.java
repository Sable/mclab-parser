package Matlab.Utils;

import Matlab.DotNet.*;

public abstract class Node implements INode, IFreezable
{
    // region FIELDS:

    // region FREEZE FIELDS:

    private boolean isFrozen;

    // endregion

    // region NODE FIELDS:

    private Node parent;

    private NodeCollection children;

    // endregion

    // endregion

    // region PROPERTIES:

    // region TREE PROPERTIES:

    public Node GetParent()
    {
        return this.parent;
    }

    void SetParent(Node value)
    {
        this.parent = value;
    }

    public NodeCollection GetChildren()
    {
        return this.children;
    }

    private void SetChildren(NodeCollection value)
    {
        this.children = value;
    }

    public boolean GetIsRoot()
    {
        return (this.GetParent() == null);
    }

    public boolean GetIsLeaf()
    {
        return (this.GetChildren().GetIsEmpty());
    }

    // endregion

    // region FREEZE PROPERTIES:

    public boolean GetIsFrozen()
    {
        return (!this.GetIsRoot() ? this.GetParent().GetIsFrozen() : this.isFrozen);
    }

    public boolean GetCanFreeze()
    {
        return (this.GetIsRoot() && !this.GetIsFrozen());
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    protected Node()
    {
        this.isFrozen = false;

        this.SetParent(null);

        this.SetChildren(new NodeCollection(this));
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

    protected void CheckNotFrozen()
    {
        if (this.GetIsFrozen())
        {
            throw new DotNetInvalidOperationException();
        }
    }

    // endregion

    // region FREEZE METHODS:

    public void Freeze()
    {
        this.CheckCanFreeze();

        this.isFrozen = true;
    }

    // endregion

    // region VISITOR METHODS:

    public Object Accept(Visitor visitor)
    {
        Checker.CheckNotNull(visitor);

        return visitor.Visit(this);
    }

    // endregion

    // endregion
}
