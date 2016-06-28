package Matlab.Utils;

public interface IReport extends ISequence<Message>
{
    // region PROPERTIES:

    Severity GetSeverity();

    boolean GetIsOk();

    // endregion

    // region METHODS:

    void Insert(int index, Severity severity, String path, int line, int column, String text);

    void Add(Severity severity, String path, int line, int column, String text);

    void AddInfo(String path, int line, int column, String text);

    void AddWarning(String path, int line, int column, String text);

    void AddError(String path, int line, int column, String text);

    // endregion
}
