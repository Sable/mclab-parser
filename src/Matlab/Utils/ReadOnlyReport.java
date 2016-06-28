package Matlab.Utils;

public final class ReadOnlyReport extends ReadOnlySequence<Message> implements IReport
{
    // region STATIC FIELDS:

    private static IReport empty;

    // endregion

    // region STATIC PROPERTIES:

    public static IReport GetEmpty()
    {
        return ReadOnlyReport.empty;
    }

    private static void SetEmpty(IReport value)
    {
        ReadOnlyReport.empty = value;
    }

    // endregion

    // region STATIC CONSTRUCTORS:

    static
    {
        ReadOnlyReport.SetEmpty(new ReadOnlyReport(new Report()));
    }

    // endregion
    
    // region PROPERTIES:

    public Severity GetSeverity()
    {
        return ((IReport)this.GetInnerCollection()).GetSeverity();
    }

    public boolean GetIsOk()
    {
        return ((IReport)this.GetInnerCollection()).GetIsOk();
    }

     // endregion

    // region CONSTRUCTORS:

    public ReadOnlyReport(IReport innerCollection)
    {
        super(innerCollection);
    }

    // endregion

    // region METHODS:

    public void Insert(int index, Severity severity, String path, int line, int column, String text)
    {
        this.CheckNotReadOnly();
    }

    public void Add(Severity severity, String path, int line, int column, String text)
    {
        this.CheckNotReadOnly();
    }

    public void AddInfo(String path, int line, int column, String text)
    {
        this.CheckNotReadOnly();
    }

    public void AddWarning(String path, int line, int column, String text)
    {
        this.CheckNotReadOnly();
    }

    public void AddError(String path, int line, int column, String text)
    {
        this.CheckNotReadOnly();
    }
    
    // endregion
}