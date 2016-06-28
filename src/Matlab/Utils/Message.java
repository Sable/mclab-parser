package Matlab.Utils;

public final class Message
{
    // region FIELDS:

    private Severity severity;

    private String path;

    private int line;

    private int column;

    private String text;

    // endregion

    // region PROPERTIES:

    public Severity GetSeverity()
    {
        return this.severity;
    }

    private void SetSeverity(Severity value)
    {
        this.severity = value;
    }

    public String GetPath()
    {
        return this.path;
    }

    private void SetPath(String value)
    {
        this.path = value;
    }

    public int GetLine()
    {
        return this.line;
    }

    private void SetLine(int value)
    {
        this.line = value;
    }

    public int GetColumn()
    {
        return this.column;
    }

    private void SetColumn(int value)
    {
        this.column = value;
    }

    public String GetText()
    {
        return this.text;
    }

    public void SetText(String value)
    {
        this.text = value;
    }

    public boolean GetIsOk()
    {
        return (this.GetSeverity() != Severity.Error);
    }

    // endregion

    // region CONSTRUCTORS:

    public Message(Severity severity, String path, int line, int column, String text)
    {
        Checker.CheckDefined(severity);

        Checker.Check(path, x -> x != null);

        Checker.Check(text, x -> x != null);

        this.SetSeverity(severity);

        this.SetPath(path);

        this.SetLine(line);

        this.SetColumn(column);

        this.SetText(text);
    }

    // endregion
}