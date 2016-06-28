package Matlab.Recognizer;

import Matlab.DotNet.*;
import Matlab.Utils.*;
import org.antlr.runtime.*;
import java.util.function.*;

class MatlabLexerReal extends MatlabLexer
{
    // region FIELDS:

    private Configuration configuration;

    // endregion

    // region PROPERTIES:

    public Configuration GetConfiguration()
    {
        return this.configuration;
    }

    private void SetConfiguration(Configuration value)
    {
        this.configuration = value;
    }

    protected CharStream GetInput()
    {
        return this.getCharStream();
    }

    // endregion

    // region CONSTRUCTORS:

    protected MatlabLexerReal(CharStream input, Configuration configuration)
    {
        super(input);

        Checker.CheckNotNull(configuration);

        this.SetConfiguration(configuration);
    }

    // endregion

    // region METHODS:

    // region ERROR METHODS:

    @Override
    public void reportError(RecognitionException e)
    {
        this.GetConfiguration().GetReport().AddError(this.GetConfiguration().GetPath(), e.line, e.charPositionInLine + 1, String.format("LEXER - %1$s", this.getErrorMessage(e, this.getTokenNames())));

        if (this.GetConfiguration().GetStopOnFirstError())
        {
            throw new StopException();
        }
    }

    // endregion

    // region MATCH METHODS:

    @Override
    public Token nextToken()
    {
        Token token = super.nextToken();

        this.Quotation_AddTokenIfMeaningful(token);

        return token;
    }

    // endregion

    // endregion

    // region GROUP MEMBERS:

    // region MACHINE GROUP:

    @Override
    protected void Machine_Update(int tokenType, Channel tokenChannel, Mode lexerMode)
    {
        this.machine_TokenType = tokenType;

        this.machine_TokenChannel = tokenChannel;

        this.machine_LexerMode = lexerMode;
    }

    @Override
    protected void Machine_Update(String text, int tokenType, Channel tokenChannel, Mode lexerMode)
    {
        if (tokenType == MatlabLexer.ID)
        {
            switch (text)
            {
                case "break":
                    tokenType = MatlabLexer.BREAK;
                    break;
                case "case":
                    tokenType = MatlabLexer.CASE;
                    break;
                case "catch":
                    tokenType = MatlabLexer.CATCH;
                    break;
                case "classdef":
                    tokenType = MatlabLexer.CLASSDEF;
                    break;
                case "continue":
                    tokenType = MatlabLexer.CONTINUE;
                    break;
                case "else":
                    tokenType = MatlabLexer.ELSE;
                    break;
                case "elseif":
                    tokenType = MatlabLexer.ELSEIF;
                    break;
                case "end":
                    tokenType = MatlabLexer.END;
                    break;
                case "for":
                    tokenType = MatlabLexer.FOR;
                    break;
                case "function":
                    tokenType = MatlabLexer.FUNCTION;
                    break;
                case "global":
                    tokenType = MatlabLexer.GLOBAL;
                    break;
                case "if":
                    tokenType = MatlabLexer.IF;
                    break;
                case "otherwise":
                    tokenType = MatlabLexer.OTHERWISE;
                    break;
                case "parfor":
                    tokenType = MatlabLexer.PARFOR;
                    break;
                case "persistent":
                    tokenType = MatlabLexer.PERSISTENT;
                    break;
                case "return":
                    tokenType = MatlabLexer.RETURN;
                    break;
                case "spmd":
                    tokenType = MatlabLexer.SPMD;
                    break;
                case "switch":
                    tokenType = MatlabLexer.SWITCH;
                    break;
                case "try":
                    tokenType = MatlabLexer.TRY;
                    break;
                case "while":
                    tokenType = MatlabLexer.WHILE;
                    break;
                case "aspect_":
                    tokenType = MatlabLexer.ASPECT;
                    break;
                default:
                    tokenType = (this.GetConfiguration().GetCommandMarker().Contains(this.getCharIndex() - text.length()) ? MatlabLexer.COMMAND : tokenType);
                    break;
            }

            lexerMode = (tokenType == MatlabLexer.COMMAND ? Mode.Command : lexerMode);

            this.Machine_Update(tokenType, tokenChannel, lexerMode);
        }
        else
        {
            throw new InternalException();
        }
    }

    @Override
    protected boolean Machine_InMode(Mode mode)
    {
        return (this.machine_LexerMode == mode);
    }

    // endregion

    // region LINE GROUP:

    @Override
    protected boolean Line_StartPrecedes()
    {
        int value = this.GetInput().LA(-1);

        if (value >= 0)
        {
            char character = DotNetConvert.ToChar(value);

            return (character == '\r' || character == '\n');
        }
        else
        {
            return true;
        }
    }

    @Override
    protected boolean Line_EndFollows()
    {
        int value = this.GetInput().LA(1);

        if (value >= 0)
        {
            char character = DotNetConvert.ToChar(value);

            return (character == '\r' || character == '\n');
        }
        else
        {
            return true;
        }
    }

    // endregion

    // region SPACES GROUP:

    @Override
    protected boolean Spaces_SpacesPrecedeInLine()
    {
        int index = -1;

        int value;

        while ((value = this.GetInput().LA(index)) >= 0)
        {
            char character = DotNetConvert.ToChar(value);

            if (character == '\r' || character == '\n')
            {
                return true;
            }
            else if (character != ' ' && character != '\t')
            {
                return false;
            }
            else
            {
                index--;
            }
        }

        return true;
    }

    // endregion

    // region TEXT GROUP:

    @Override
    protected boolean Text_TextFollows(String text)
    {
        for (int i = 0; i < text.length(); i++)
        {
            int value = this.GetInput().LA(i + 1);

            if (value >= 0)
            {
                char character = DotNetConvert.ToChar(value);

                if (character != text.charAt(i))
                {
                    return false;
                }
            }
            else
            {
                return false;
            }
        }

        return true;
    }

    @Override
    protected boolean Text_ThreeDotsFollow()
    {
        return this.Text_TextFollows("...");
    }

    @Override
    protected boolean Text_TwoDotsAndNoDotFollow()
    {
        return (Text_TextFollows("..") && this.GetInput().LA(3) >= 0 && DotNetConvert.ToChar(this.GetInput().LA(3)) != '.');
    }

    // endregion

    // region QUOTATION GROUP:

    @Override
    protected void Quotation_AddTokenIfMeaningful(Token token)
    {
        if (token != null && token.getChannel() != Channel.GetSkippedInt())
        {
            this.quotation_MeaningfulTokenList.Add(token);
        }
    }

    @Override
    protected int Quotation_FindLastOrDefaultIndex(int upToIndex, Predicate<Token> predicate)
    {
        int max = Math.min(upToIndex, this.quotation_MeaningfulTokenList.GetCount() - 1);

        for (int i = max; i >= 0; i--)
        {
            if (predicate.test(this.quotation_MeaningfulTokenList.GetIndex(i)))
            {
                return i;
            }
        }

        return -1;
    }

    @Override
    protected boolean Quotation_TransposeIsEnabledAfterKeyword(int keywordIndex)
    {
        int indexOfPreviousDefaultToken = this.Quotation_FindLastOrDefaultIndex(keywordIndex - 1, x -> x.getChannel() == Channel.GetDefaultInt());

        Token previousDefaultToken = (indexOfPreviousDefaultToken < 0 ? null : this.quotation_MeaningfulTokenList.GetIndex(indexOfPreviousDefaultToken));

        return (previousDefaultToken != null && previousDefaultToken.getType() == MatlabLexer.DOT);
    }

    @Override
    protected boolean Quotation_TransposeIsEnabledAfterClosingParenthesis(int closingParenthesisIndex)
    {
        int closing = 1;

        int index = closingParenthesisIndex - 1;

        for (; index >= 0; index--)
        {
            Token token = this.quotation_MeaningfulTokenList.GetIndex(index);

            switch (token.getType())
            {
                case MatlabLexer.LPAREN:
                case MatlabLexer.LSQUARE:
                case MatlabLexer.LCURLY:
                    closing--;
                    break;
                case MatlabLexer.RPAREN:
                case MatlabLexer.RSQUARE:
                case MatlabLexer.RCURLY:
                    closing++;
                    break;
            }

            if (closing == 0)
            {
                break;
            }
        }

        if (closing == 0)
        {
            int indexOfPreviousDefaultToken = this.Quotation_FindLastOrDefaultIndex(index - 1, x -> x.getChannel() == Channel.GetDefaultInt());

            Token previousDefaultToken = (indexOfPreviousDefaultToken < 0 ? null : this.quotation_MeaningfulTokenList.GetIndex(indexOfPreviousDefaultToken));

            return (previousDefaultToken == null || previousDefaultToken.getType() != MatlabLexer.AT);
        }
        else
        {
            return true;
        }
    }

    @Override
    protected boolean Quotation_TransposeIsEnabled()
    {
        int indexOfLastDefaultToken = this.Quotation_FindLastOrDefaultIndex(this.quotation_MeaningfulTokenList.GetCount() - 1, x -> x.getChannel() == Channel.GetDefaultInt());

        if (indexOfLastDefaultToken < 0 || indexOfLastDefaultToken != this.quotation_MeaningfulTokenList.GetCount() - 1)
        {
            return false;
        }
        else
        {
            Token lastDefaultToken = this.quotation_MeaningfulTokenList.GetIndex(indexOfLastDefaultToken);

            switch (lastDefaultToken.getType())
            {
                case MatlabLexer.RPAREN:
                    return this.Quotation_TransposeIsEnabledAfterClosingParenthesis(indexOfLastDefaultToken);
                case MatlabLexer.RSQUARE:
                case MatlabLexer.RCURLY:
                case MatlabLexer.CTRANS:
                case MatlabLexer.REAL:
                case MatlabLexer.IMAGINARY:
                case MatlabLexer.ID:
                    return true;
                case MatlabLexer.BREAK:
                case MatlabLexer.CASE:
                case MatlabLexer.CATCH:
                case MatlabLexer.CLASSDEF:
                case MatlabLexer.CONTINUE:
                case MatlabLexer.ELSE:
                case MatlabLexer.ELSEIF:
                case MatlabLexer.END:
                case MatlabLexer.FOR:
                case MatlabLexer.FUNCTION:
                case MatlabLexer.GLOBAL:
                case MatlabLexer.IF:
                case MatlabLexer.OTHERWISE:
                case MatlabLexer.PARFOR:
                case MatlabLexer.PERSISTENT:
                case MatlabLexer.RETURN:
                case MatlabLexer.SPMD:
                case MatlabLexer.SWITCH:
                case MatlabLexer.TRY:
                case MatlabLexer.WHILE:
                    return this.Quotation_TransposeIsEnabledAfterKeyword(indexOfLastDefaultToken);
                default:
                    return false;
            }
        }
    }

    // endregion

    // endregion
}
