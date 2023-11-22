package org.commonmark.internal;

import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Block;
import org.commonmark.node.BlockQuote;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

/* loaded from: classes6.dex */
public class BlockQuoteParser extends AbstractBlockParser {
    private final BlockQuote KClassImpl$Data$declaredNonStaticMembers$2 = new BlockQuote();

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public final boolean PlaceComponentResult() {
        return true;
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public final boolean PlaceComponentResult(Block block) {
        return true;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public final BlockContinue PlaceComponentResult(ParserState parserState) {
        int NetworkUserEntityData$$ExternalSyntheticLambda0 = parserState.NetworkUserEntityData$$ExternalSyntheticLambda0();
        if (KClassImpl$Data$declaredNonStaticMembers$2(parserState, NetworkUserEntityData$$ExternalSyntheticLambda0)) {
            int PlaceComponentResult = parserState.PlaceComponentResult() + parserState.BuiltInFictitiousFunctionClassFactory() + 1;
            if (Parsing.MyBillsEntityDataFactory(parserState.scheduleImpl(), NetworkUserEntityData$$ExternalSyntheticLambda0 + 1)) {
                PlaceComponentResult++;
            }
            return BlockContinue.getAuthRequestContext(PlaceComponentResult);
        }
        return BlockContinue.MyBillsEntityDataFactory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(ParserState parserState, int i) {
        CharSequence scheduleImpl = parserState.scheduleImpl();
        return parserState.BuiltInFictitiousFunctionClassFactory() < Parsing.KClassImpl$Data$declaredNonStaticMembers$2 && i < scheduleImpl.length() && scheduleImpl.charAt(i) == '>';
    }

    /* loaded from: classes6.dex */
    public static class Factory extends AbstractBlockParserFactory {
        @Override // org.commonmark.parser.block.BlockParserFactory
        public final BlockStart MyBillsEntityDataFactory(ParserState parserState, MatchedBlockParser matchedBlockParser) {
            int NetworkUserEntityData$$ExternalSyntheticLambda0 = parserState.NetworkUserEntityData$$ExternalSyntheticLambda0();
            if (BlockQuoteParser.KClassImpl$Data$declaredNonStaticMembers$2(parserState, NetworkUserEntityData$$ExternalSyntheticLambda0)) {
                int PlaceComponentResult = parserState.PlaceComponentResult() + parserState.BuiltInFictitiousFunctionClassFactory() + 1;
                if (Parsing.MyBillsEntityDataFactory(parserState.scheduleImpl(), NetworkUserEntityData$$ExternalSyntheticLambda0 + 1)) {
                    PlaceComponentResult++;
                }
                return BlockStart.BuiltInFictitiousFunctionClassFactory(new BlockQuoteParser()).PlaceComponentResult(PlaceComponentResult);
            }
            return BlockStart.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    @Override // org.commonmark.parser.block.BlockParser
    public final /* bridge */ /* synthetic */ Block MyBillsEntityDataFactory() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
