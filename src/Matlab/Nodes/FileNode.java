package Matlab.Nodes;

public abstract class FileNode extends ExternalNode implements ICommentableNode
{
    // region FIELDS:

    // region INFORMATION FIELDS:

    private String path;

    // endregion

    // endregion

    // region PROPERTIES:

    // region INFORMATION PROPERTIES:

    @Information(Index = 0)
    public String GetPath()
    {
        return this.path;
    }

    @Information(Index = 0)
    public void SetPath(String value)
    {
        this.CheckNotFrozen();

        this.path = value;
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    protected FileNode()
    {
        super();

        this.SetPath(null);
    }

    // endregion
}