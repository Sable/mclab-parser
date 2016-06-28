package Matlab.Recognizer;

import Matlab.Utils.*;

class Configuration
{
    // region FIELDS:

    private String path;

    private Report report;

    private CommandMarker commandMarker;

    private boolean stopOnFirstError;

    // endregion

    // region PROPERTIES:

    public String GetPath()
    {
        return this.path;
    }

    private void SetPath(String value)
    {
        this.path = value;
    }

    public Report GetReport()
    {
        return this.report;
    }

    private void SetReport(Report value)
    {
        this.report = value;
    }

    public CommandMarker GetCommandMarker()
    {
        return this.commandMarker;
    }

    private void SetCommandMarker(CommandMarker value)
    {
        this.commandMarker = value;
    }

    public boolean GetStopOnFirstError()
    {
        return this.stopOnFirstError;
    }

    private void SetStopOnFirstError(boolean value)
    {
        this.stopOnFirstError = value;
    }

    // endregion

    // region CONSTRUCTORS:

    public Configuration(String path, Report report, CommandMarker commandMarker, boolean stopOnFirstError)
    {
        Checker.CheckNotNull(path);

        Checker.CheckNotNull(report);

        Checker.CheckNotNull(commandMarker);

        this.SetPath(path);

        this.SetReport(report);

        this.SetCommandMarker(commandMarker);

        this.SetStopOnFirstError(stopOnFirstError);
    }

    // endregion
}
