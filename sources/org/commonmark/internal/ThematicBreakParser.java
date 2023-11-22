package org.commonmark.internal;

import java.util.regex.Pattern;
import org.commonmark.node.Block;
import org.commonmark.node.ThematicBreak;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

/* loaded from: classes6.dex */
public class ThematicBreakParser extends AbstractBlockParser {
    private static Pattern getAuthRequestContext = Pattern.compile("^(?:(?:\\*[ \t]*){3,}|(?:_[ \t]*){3,}|(?:-[ \t]*){3,})[ \t]*$");
    private final ThematicBreak PlaceComponentResult = new ThematicBreak();

    @Override // org.commonmark.parser.block.BlockParser
    public final Block MyBillsEntityDataFactory() {
        return this.PlaceComponentResult;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public final BlockContinue PlaceComponentResult(ParserState parserState) {
        return BlockContinue.MyBillsEntityDataFactory();
    }

    /* loaded from: classes6.dex */
    public static class Factory extends AbstractBlockParserFactory {
        @Override // org.commonmark.parser.block.BlockParserFactory
        public final BlockStart MyBillsEntityDataFactory(ParserState parserState, MatchedBlockParser matchedBlockParser) {
            if (parserState.BuiltInFictitiousFunctionClassFactory() >= 4) {
                return BlockStart.KClassImpl$Data$declaredNonStaticMembers$2();
            }
            int NetworkUserEntityData$$ExternalSyntheticLambda0 = parserState.NetworkUserEntityData$$ExternalSyntheticLambda0();
            CharSequence scheduleImpl = parserState.scheduleImpl();
            return ThematicBreakParser.getAuthRequestContext.matcher(scheduleImpl.subSequence(NetworkUserEntityData$$ExternalSyntheticLambda0, scheduleImpl.length())).matches() ? BlockStart.BuiltInFictitiousFunctionClassFactory(new ThematicBreakParser()).KClassImpl$Data$declaredNonStaticMembers$2(scheduleImpl.length()) : BlockStart.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }
}
