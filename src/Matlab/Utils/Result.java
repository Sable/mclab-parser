package Matlab.Utils;

public final class Result<T> implements IResult
{
    // region FIELDS:

    private T value;

    private IReport report;

    // endregion

    // region PROPERTIES:

    public T GetValue()
    {
        return this.value;
    }

    private void SetValue(T value)
    {
        this.value = value;
    }

    public IReport GetReport()
    {
        return this.report;
    }

    private void SetReport(IReport value)
    {
        this.report = value;
    }

    public boolean GetIsOk()
    {
        return this.GetReport().GetIsOk();
    }

    // endregion

    // region CONSTRUCTORS:

    public Result(T value, IReport report)
    {
        Checker.CheckNotNull(report);

        this.SetValue(value);

        this.SetReport((report.GetIsReadOnly()) ? report : new ReadOnlyReport(report));
    }

    // endregion
}