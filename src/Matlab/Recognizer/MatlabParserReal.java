package Matlab.Recognizer;

import Matlab.DotNet.*;
import Matlab.Utils.*;
import Matlab.Nodes.*;
import org.antlr.runtime.*;
import java.util.*;

class MatlabParserReal extends MatlabParser
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

    public ExtendedTokenStream GetInput()
    {
        return ((ExtendedTokenStream)this.getTokenStream());
    }

    // endregion

    // region CONSTRUCTORS:

    public MatlabParserReal(TokenStream input, Configuration configuration)
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
        this.GetConfiguration().GetReport().AddError(this.GetConfiguration().GetPath(), e.line, e.charPositionInLine + 1, String.format("PARSER - %1$s", this.getErrorMessage(e, this.getTokenNames())));

        if (this.GetConfiguration().GetStopOnFirstError())
        {
            throw new StopException();
        }
    }

    // endregion

    // endregion

    // region GROUP MEMBERS:

    // region KEYWORD GROUP:

    @Override
    protected boolean Keyword_EventsIdFollows()
    {
        Token token1 = this.GetInput().LT(1);

        return (token1.getType() == MatlabLexer.ID && token1.getText().equals("events"));
    }

    @Override
    protected boolean Keyword_PropertiesIdFollows()
    {
        Token token1 = this.GetInput().LT(1);

        return (token1.getType() == MatlabLexer.ID && token1.getText().equals("properties"));
    }

    @Override
    protected boolean Keyword_MethodsIdFollows()
    {
        Token token1 = this.GetInput().LT(1);

        return (token1.getType() == MatlabLexer.ID && token1.getText().equals("methods"));
    }

    @Override
    protected boolean Keyword_EnumerationIdFollows()
    {
        Token token1 = this.GetInput().LT(1);

        return (token1.getType() == MatlabLexer.ID && token1.getText().equals("enumeration"));
    }

    @Override
    protected boolean Keyword_IdFollows(String keyword)
    {
        Token token1 = this.GetInput().LT(1);

        return (token1.getType() == MatlabLexer.ID && token1.getText().equals(keyword));
    }

    // endregion

    // region COMMAND GROUP:

    @Override
    protected void Command_Mark()
    {
        Token token1 = this.GetInput().LT(1);

        this.GetConfiguration().GetCommandMarker().Add(((CommonToken)token1).getStartIndex());
    }

    @Override
    protected void Command_Abort()
    {
        throw new CommandException();
    }

    @Override
    protected boolean Command_IsEnabled()
    {
        Token token1 = this.GetInput().LT(1);

        Token token2 = this.GetInput().LT(2);

        Token token3 = this.GetInput().LT(3);

        return (token1.getType() == MatlabLexer.ID
                && this.GetInput().GetOffChannelTokensToRight(token1.getTokenIndex(), Channel.GetSpacesInt()) != null
                && token2.getType() != MatlabLexer.LPAREN
                && token2.getType() != MatlabLexer.RPAREN
                && token2.getType() != MatlabLexer.ASSIGN
                && !(DotNetArray.Contains(MatlabParser.command_SpecialOperatorsSet, token2.getType())
                && this.GetInput().GetOffChannelTokensToRight(token2.getTokenIndex(), (int)Channel.GetSpacesInt()) != null
                && DotNetArray.Contains(MatlabParser.command_SpecialOperatorsFollowSet, token3.getType())
                )
        );
    }

    // endregion

    // region SEPARATOR GROUP:

    @Override
    protected boolean Separator_CommaFollowsOrSpacesPrecede()
    {
        Token token1 = this.GetInput().LT(1);

        return (token1.getType() == MatlabLexer.COMMA || this.GetInput().GetOffChannelTokensToLeft(token1.getTokenIndex(), Channel.GetSpacesInt()) != null);
    }

    @Override
    protected boolean Separator_SpacesPrecede()
    {
        Token token1 = this.GetInput().LT(1);

        return (this.GetInput().GetOffChannelTokensToLeft(token1.getTokenIndex(), Channel.GetSpacesInt()) != null);
    }

    @Override
    protected boolean Separator_EllipsisFollows()
    {
        Token token1 = this.GetInput().LT(1);

        DotNetIList<? extends Token> offChannelTokensToLeft = this.GetInput().GetOffChannelTokensToLeft(token1.getTokenIndex(), Channel.GetSpacesInt());

        return (offChannelTokensToLeft != null && DotNetEnumerable.FirstOrDefault(offChannelTokensToLeft, x -> x.getType() == MatlabLexer.ELLIPSIS) != null);
    }

    @Override
    protected boolean Separator_EllipsisOrEolFollows()
    {
        Token token1 = this.GetInput().LT(1);

        if (token1.getType() == MatlabLexer.EOL)
        {
            return true;
        }
        else
        {
            DotNetIList<? extends Token> offChannelTokensToLeft = this.GetInput().GetOffChannelTokensToLeft(token1.getTokenIndex(), Channel.GetSpacesInt());

            return (offChannelTokensToLeft != null && DotNetEnumerable.FirstOrDefault(offChannelTokensToLeft, x -> x.getType() == MatlabLexer.ELLIPSIS) != null);
        }
    }

    // endregion

    // region INDEX GROUP:

    @Override
    protected IndexOperator Index_GetTop()
    {
        if (StackHelper.IsEmpty(this.index_Stack))
        {
            return IndexOperator.None;
        }
        else
        {
            return StackHelper.Peek(this.index_Stack);
        }
    }

    @Override
    protected void Index_EnterParenthesis()
    {
        StackHelper.Push(this.index_Stack, IndexOperator.Parenthesis);
    }

    @Override
    protected void Index_EnterCurlyBrace()
    {
        StackHelper.Push(this.index_Stack, IndexOperator.CurlyBrace);
    }

    @Override
    protected void Index_ExitParenthesis()
    {
        StackHelper.Pop(this.index_Stack, IndexOperator.Parenthesis);
    }

    @Override
    protected void Index_ExitCurlyBrace()
    {
        StackHelper.Pop(this.index_Stack, IndexOperator.CurlyBrace);
    }

    @Override
    protected boolean Index_IsActive()
    {
        return !StackHelper.IsEmpty(this.index_Stack);
    }

    // endregion

    // region BALANCE GROUP:

    @Override
    protected void Balance_EnterCreationSquareBrace()
    {
        StackHelper.Push(this.balance_Stack, BalanceOperator.CreationSquareBrace);
    }

    @Override
    protected void Balance_EnterCreationCurlyBrace()
    {
        StackHelper.Push(this.balance_Stack, BalanceOperator.CreationCurlyBrace);
    }

    @Override
    protected void Balance_EnterStorageSquareBrace()
    {
        StackHelper.Push(this.balance_Stack, BalanceOperator.StorageSquareBrace);
    }

    @Override
    protected void Balance_EnterIndexCurlyBrace()
    {
        StackHelper.Push(this.balance_Stack, BalanceOperator.IndexCurlyBrace);
    }

    @Override
    protected void Balance_EnterParenthesis()
    {
        StackHelper.Push(this.balance_Stack, BalanceOperator.Parenthesis);
    }

    @Override
    protected void Balance_ExitCreationSquareBrace()
    {
        StackHelper.Pop(this.balance_Stack, BalanceOperator.CreationSquareBrace);
    }

    @Override
    protected void Balance_ExitCreationCurlyBrace()
    {
        StackHelper.Pop(this.balance_Stack, BalanceOperator.CreationCurlyBrace);
    }

    @Override
    protected void Balance_ExitStorageSquareBrace()
    {
        StackHelper.Pop(this.balance_Stack, BalanceOperator.StorageSquareBrace);
    }

    @Override
    protected void Balance_ExitIndexCurlyBrace()
    {
        StackHelper.Pop(this.balance_Stack, BalanceOperator.IndexCurlyBrace);
    }

    @Override
    protected void Balance_ExitParenthesis()
    {
        StackHelper.Pop(this.balance_Stack, BalanceOperator.Parenthesis);
    }

    @Override
    protected BalanceOperator Balance_GetTop()
    {
        if (StackHelper.IsEmpty(this.balance_Stack))
        {
            return BalanceOperator.None;
        }
        else
        {
            return StackHelper.Peek(this.balance_Stack);
        }
    }

    @Override
    protected boolean Balance_TopIsCreationOrStoreOperator()
    {
        BalanceOperator balanceOperator = this.Balance_GetTop();

        switch (balanceOperator)
        {
            case CreationSquareBrace:
            case CreationCurlyBrace:
            case StorageSquareBrace:
                return true;
            default:
                return false;
        }
    }

    @Override
    protected boolean Balance_InCreationOrStore_SpacesOnLeftButNotOnRight()
    {
        if (this.Balance_TopIsCreationOrStoreOperator())
        {
            Token token1 = this.GetInput().LT(1);

            DotNetIList<? extends Token> offChannelTokensToLeft = this.GetInput().GetOffChannelTokensToLeft(token1.getTokenIndex(), (int)Channel.GetSpacesInt());

            DotNetIList<? extends Token> offChannelTokensToRight = this.GetInput().GetOffChannelTokensToRight(token1.getTokenIndex(), (int)Channel.GetSpacesInt());

            return (offChannelTokensToLeft != null && offChannelTokensToRight == null);
        }
        else
        {
            return false;
        }
    }

    @Override
    protected boolean Balance_InCreationOrStore_SpacesOnLeft()
    {
        if (this.Balance_TopIsCreationOrStoreOperator())
        {
            Token token1 = this.GetInput().LT(1);

            DotNetIList<? extends Token> offChannelTokensToLeft = this.GetInput().GetOffChannelTokensToLeft(token1.getTokenIndex(), Channel.GetSpacesInt());

            return (offChannelTokensToLeft != null);
        }
        else
        {
            return false;
        }
    }

    // endregion

    // region CHAIN GROUP:

    @Override
    protected void Chain_Begin()
    {
        StackHelper.Push(this.chain_Stack, ChainOperator.Start);
    }

    @Override
    protected void Chain_End()
    {
        while (!StackHelper.OnTop(this.chain_Stack, ChainOperator.Start))
        {
            StackHelper.Pop(this.chain_Stack);
        }

        StackHelper.Pop(this.chain_Stack, ChainOperator.Start);
    }

    @Override
    protected void Chain_AddedParenthesis()
    {
        StackHelper.Push(this.chain_Stack, ChainOperator.Parenthesis);
    }

    @Override
    protected void Chain_AddedCurlyBrace()
    {
        StackHelper.Push(this.chain_Stack, ChainOperator.CurlyBrace);
    }

    @Override
    protected void Chain_AddedDotName()
    {
        StackHelper.Push(this.chain_Stack, ChainOperator.DotName);
    }

    @Override
    protected void Chain_AddedDotExpression()
    {
        StackHelper.Push(this.chain_Stack, ChainOperator.DotExpression);
    }

    @Override
    protected void Chain_AddedAtBase()
    {
        StackHelper.Push(this.chain_Stack, ChainOperator.AtBase);
    }

    @Override
    protected ChainOperator Chain_GetTop()
    {
        if (StackHelper.IsEmpty(this.chain_Stack))
        {
            return ChainOperator.None;
        }
        else
        {
            return StackHelper.Peek(this.chain_Stack);
        }
    }

    @Override
    protected boolean Chain_MayAddParenthesis()
    {
        ChainOperator chainOperator = this.Chain_GetTop();

        switch (chainOperator)
        {
            case Start:
            case CurlyBrace:
            case DotName:
            case DotExpression:
            case AtBase:
                return true;
            default:
                return false;
        }
    }

    @Override
    protected boolean Chain_MayAddCurlyBrace()
    {
        ChainOperator chainOperator = this.Chain_GetTop();

        switch (chainOperator)
        {
            case Start:
            case CurlyBrace:
            case DotName:
            case DotExpression:
                return true;
            default:
                return false;
        }
    }

    @Override
    protected boolean Chain_MayAddDotName()
    {
        ChainOperator chainOperator = this.Chain_GetTop();

        switch (chainOperator)
        {
            case Start:
            case Parenthesis:
            case CurlyBrace:
            case DotName:
            case DotExpression:
                return true;
            default:
                return false;
        }
    }

    @Override
    protected boolean Chain_MayAddDotExpression()
    {
        ChainOperator chainOperator = this.Chain_GetTop();

        switch (chainOperator)
        {
            case Start:
            case Parenthesis:
            case CurlyBrace:
            case DotName:
            case DotExpression:
                return true;
            default:
                return false;
        }
    }

    @Override
    protected boolean Chain_MayAddAtBase()
    {
        ChainOperator chainOperator = this.Chain_GetTop();

        switch (chainOperator)
        {
            case Start:
            case DotName:
                return true;
            default:
                return false;
        }
    }

    // endregion

    // region METHOD GROUP:

    @Override
    protected void Method_EnterSignature()
    {
        this.method_Signature = true;
    }

    @Override
    protected void Method_ExitSignature()
    {
        this.method_Signature = false;
    }

    @Override
    protected boolean Method_SignatureIsActive()
    {
        return this.method_Signature;
    }

    // endregion

    // region TEXT GROUP:

    @Override
    protected String Text_UnquoteString(String text)
    {
        return Text.UnquoteString(text);
    }

    @Override
    protected String Text_QuoteString(String text)
    {
        return Text.QuoteString(text);
    }

    // endregion

    // endregion
}
