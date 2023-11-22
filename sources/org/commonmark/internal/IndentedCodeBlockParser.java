package org.commonmark.internal;

import java.util.regex.Pattern;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Block;
import org.commonmark.node.IndentedCodeBlock;
import org.commonmark.node.Paragraph;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

/* loaded from: classes6.dex */
public class IndentedCodeBlockParser extends AbstractBlockParser {
    private static final Pattern BuiltInFictitiousFunctionClassFactory = Pattern.compile("(?:\n[ \t]*)+$");
    private final IndentedCodeBlock getAuthRequestContext = new IndentedCodeBlock();
    private BlockContent PlaceComponentResult = new BlockContent();

    @Override // org.commonmark.parser.block.BlockParser
    public final Block MyBillsEntityDataFactory() {
        return this.getAuthRequestContext;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public final BlockContinue PlaceComponentResult(ParserState parserState) {
        if (parserState.BuiltInFictitiousFunctionClassFactory() >= Parsing.KClassImpl$Data$declaredNonStaticMembers$2) {
            return BlockContinue.getAuthRequestContext(parserState.PlaceComponentResult() + Parsing.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        if (parserState.lookAheadTest()) {
            return BlockContinue.BuiltInFictitiousFunctionClassFactory(parserState.NetworkUserEntityData$$ExternalSyntheticLambda0());
        }
        return BlockContinue.MyBillsEntityDataFactory();
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public final void PlaceComponentResult(CharSequence charSequence) {
        this.PlaceComponentResult.getAuthRequestContext(charSequence);
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.PlaceComponentResult.getAuthRequestContext("");
        String obj = this.PlaceComponentResult.PlaceComponentResult.toString();
        this.PlaceComponentResult = null;
        this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory.matcher(obj).replaceFirst("\n");
    }

    /* loaded from: classes6.dex */
    public static class Factory extends AbstractBlockParserFactory {
        @Override // org.commonmark.parser.block.BlockParserFactory
        public final BlockStart MyBillsEntityDataFactory(ParserState parserState, MatchedBlockParser matchedBlockParser) {
            return (parserState.BuiltInFictitiousFunctionClassFactory() < Parsing.KClassImpl$Data$declaredNonStaticMembers$2 || parserState.lookAheadTest() || (parserState.getAuthRequestContext().MyBillsEntityDataFactory() instanceof Paragraph)) ? BlockStart.KClassImpl$Data$declaredNonStaticMembers$2() : BlockStart.BuiltInFictitiousFunctionClassFactory(new IndentedCodeBlockParser()).PlaceComponentResult(parserState.PlaceComponentResult() + Parsing.KClassImpl$Data$declaredNonStaticMembers$2);
        }
    }
}
