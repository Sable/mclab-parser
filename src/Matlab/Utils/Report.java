package Matlab.Utils;

public final class Report extends Sequence<Message> implements IReport
{
    // region FIELDS:

    private int[] severityToCountArray;

    // endregion

    // region PROPERTIES:

    private int[] GetSeverityToCountArray() {
        return this.severityToCountArray;
    }

    private void SetSeverityToCountArray(int[] value) {
        this.severityToCountArray = value;
    }

    public Severity GetSeverity()
    {
        if (this.GetSeverityToCountArray()[Severity.GetErrorInt()] > 0)
        {
            return Severity.Error;
        }
        else if (this.GetSeverityToCountArray()[Severity.GetWarningInt()] > 0)
        {
            return Severity.Warning;
        }
        else
        {
            return Severity.Info;
        }
    }

    public boolean GetIsOk()
    {
        return (this.GetSeverity() != Severity.Error);
    }

    // endregion

    // region CONSTRUCTORS:

    public Report()
    {
        super();

        this.SetSeverityToCountArray(new int[3]);
    }

    // endregion

    // region METHODS:

    // region EXTRA METHODS:

    @Override
    protected void OnItemInserted(Message item)
    {
        super.OnItemInserted(item);

        this.GetSeverityToCountArray()[item.GetSeverity().ToInt()]++;
    }

    @Override
    protected void OnItemRemoved(Message item)
    {
        super.OnItemRemoved(item);

        this.GetSeverityToCountArray()[item.GetSeverity().ToInt()]--;
    }

    // endregion

    // region ALTER METHODS:

    public void Insert(int index, Severity severity, String path, int line, int column, String text)
    {
        this.Insert(index, new Message(severity, path, line, column, text));
    }

    public void Add(Severity severity, String path, int line, int column, String text)
    {
        this.Insert(this.GetCount(), severity, path, line, column, text);
    }

    public void AddInfo(String path, int line, int column, String text)
    {
        this.Add(Severity.Info, path, line, column, text);
    }

    public void AddWarning(String path, int line, int column, String text)
    {
        this.Add(Severity.Warning, path, line, column, text);
    }

    public void AddError(String path, int line, int column, String text)
    {
        this.Add(Severity.Error, path, line, column, text);
    }

    // endregion

    // endregion
}