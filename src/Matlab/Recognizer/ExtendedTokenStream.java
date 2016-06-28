package Matlab.Recognizer;

import Matlab.DotNet.*;
import org.antlr.runtime.*;

class ExtendedTokenStream extends CommonTokenStream
{
    // region CONSTRUCTORS:

    public ExtendedTokenStream()
    {
        super();
    }

    public ExtendedTokenStream(TokenSource tokenSource)
    {
        super(tokenSource, 0);
    }

    public ExtendedTokenStream(TokenSource tokenSource, int channel)
    {
        super(tokenSource);
    }

    // endregion

    // region METHODS:

    public DotNetIList<? extends Token> GetOffChannelTokensToLeft(int tokenIndex)
    {
        int stop = tokenIndex - 1;

        if (stop < 0 || this.get(stop).getChannel() == this.channel)
        {
            return null;
        }
        else
        {
            int start = this.skipOffTokenChannelsReverse(stop);

            return new DotNetList<>(this.getTokens(start, stop));
        }
    }

    public DotNetIList<? extends Token> GetOffChannelTokensToLeft(int tokenIndex, int channel)
    {
        DotNetIList<? extends Token> list = this.GetOffChannelTokensToLeft(tokenIndex);

        return (list == null ? list : DotNetEnumerable.ToDotNetList(DotNetEnumerable.Where(list, x -> x.getChannel() == channel)));
    }

    public DotNetIList<? extends Token> GetOffChannelTokensToRight(int tokenIndex)
    {
        int start = tokenIndex + 1;

        if (start >= this.size() || this.get(start).getChannel() == this.channel)
        {
            return null;
        }
        else
        {
            int stop = this.skipOffTokenChannels(start);

            return new DotNetList<>(this.getTokens(start, stop));
        }
    }

    public DotNetIList<? extends Token> GetOffChannelTokensToRight(int tokenIndex, int channel)
    {
        DotNetIList<? extends Token> list = this.GetOffChannelTokensToRight(tokenIndex);

        return (list == null ? list : DotNetEnumerable.ToDotNetList(DotNetEnumerable.Where(list, x -> x.getChannel() == channel)));
    }

    // endregion
}
