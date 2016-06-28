package Matlab.Nodes;

public abstract class InternalNode extends MNode
{
    // region FIELDS:

    // region REGULAR FIELDS:

    private int index;

    private int minIndex;

    private int maxIndex;

    // endregion

    // region INFORMATION FIELDS:

    private int line;

    private int column;

    private String text;

    // endregion

    // endregion

    // region PROPERTIES:

    // region REGULAR PROPERTIES:

    public int GetIndex()
    {
        return this.index;
    }

    public void SetIndex(int value)
    {
        this.CheckNotFrozen();

        this.index = value;
    }

    public int GetMinIndex()
    {
        return this.minIndex;
    }

    public void SetMinIndex(int value)
    {
        this.CheckNotFrozen();

        this.minIndex = value;
    }

    public int GetMaxIndex()
    {
        return this.maxIndex;
    }

    public void SetMaxIndex(int value)
    {
        this.CheckNotFrozen();

        this.maxIndex = value;
    }

    // endregion

    // region INFORMATION PROPERTIES:

    @Information(Index = 0)
    public int GetLine()
    {
        return this.line;
    }

    @Information(Index = 0)
    public void SetLine(int value)
    {
        this.CheckNotFrozen();

        this.line = value;
    }

    @Information(Index = 1)
    public int GetColumn()
    {
        return this.column;
    }

    @Information(Index = 1)
     public void SetColumn(int value)
    {
        this.CheckNotFrozen();

        this.column = value;
    }

    @Information(Index = 2)
    public String GetText()
    {
        return this.text;
    }

    @Information(Index = 2)
    public void SetText(String value)
    {
        this.CheckNotFrozen();

        this.text = value;
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    protected InternalNode()
    {
        super();

        this.SetIndex(-1);

        this.SetMinIndex(-1);

        this.SetMaxIndex(-1);

        this.SetLine(-1);

        this.SetColumn(-1);

        this.SetText(null);
    }

    // endregion
}
