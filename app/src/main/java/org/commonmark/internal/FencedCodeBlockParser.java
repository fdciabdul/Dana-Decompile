package org.commonmark.internal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.commonmark.internal.util.Escaping;
import org.commonmark.node.Block;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

/* loaded from: classes6.dex */
public class FencedCodeBlockParser extends AbstractBlockParser {
    private StringBuilder KClassImpl$Data$declaredNonStaticMembers$2;
    private final FencedCodeBlock PlaceComponentResult;
    private String getAuthRequestContext;
    private static final Pattern MyBillsEntityDataFactory = Pattern.compile("^`{3,}(?!.*`)|^~{3,}(?!.*~)");
    private static final Pattern BuiltInFictitiousFunctionClassFactory = Pattern.compile("^(?:`{3,}|~{3,})(?= *$)");

    public FencedCodeBlockParser(char c, int i, int i2) {
        FencedCodeBlock fencedCodeBlock = new FencedCodeBlock();
        this.PlaceComponentResult = fencedCodeBlock;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new StringBuilder();
        fencedCodeBlock.getAuthRequestContext = c;
        fencedCodeBlock.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        fencedCodeBlock.BuiltInFictitiousFunctionClassFactory = i2;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public final Block MyBillsEntityDataFactory() {
        return this.PlaceComponentResult;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public final BlockContinue PlaceComponentResult(ParserState parserState) {
        Matcher matcher;
        boolean z;
        int i;
        int NetworkUserEntityData$$ExternalSyntheticLambda0 = parserState.NetworkUserEntityData$$ExternalSyntheticLambda0();
        int MyBillsEntityDataFactory2 = parserState.MyBillsEntityDataFactory();
        CharSequence scheduleImpl = parserState.scheduleImpl();
        if (parserState.BuiltInFictitiousFunctionClassFactory() <= 3 && NetworkUserEntityData$$ExternalSyntheticLambda0 < scheduleImpl.length() && scheduleImpl.charAt(NetworkUserEntityData$$ExternalSyntheticLambda0) == this.PlaceComponentResult.PlaceComponentResult()) {
            matcher = BuiltInFictitiousFunctionClassFactory.matcher(scheduleImpl.subSequence(NetworkUserEntityData$$ExternalSyntheticLambda0, scheduleImpl.length()));
            if (matcher.find()) {
                z = true;
                if (!z && matcher.group(0).length() >= this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2) {
                    return BlockContinue.KClassImpl$Data$declaredNonStaticMembers$2();
                }
                for (i = this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory; i > 0 && MyBillsEntityDataFactory2 < scheduleImpl.length() && scheduleImpl.charAt(MyBillsEntityDataFactory2) == ' '; i--) {
                    MyBillsEntityDataFactory2++;
                }
                return BlockContinue.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory2);
            }
        }
        matcher = null;
        z = false;
        if (!z) {
        }
        while (i > 0) {
            MyBillsEntityDataFactory2++;
        }
        return BlockContinue.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory2);
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public final void PlaceComponentResult(CharSequence charSequence) {
        if (this.getAuthRequestContext == null) {
            this.getAuthRequestContext = charSequence.toString();
            return;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2.append(charSequence);
        this.KClassImpl$Data$declaredNonStaticMembers$2.append('\n');
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.PlaceComponentResult.MyBillsEntityDataFactory = Escaping.MyBillsEntityDataFactory(this.getAuthRequestContext.trim());
        this.PlaceComponentResult.PlaceComponentResult = this.KClassImpl$Data$declaredNonStaticMembers$2.toString();
    }

    /* loaded from: classes6.dex */
    public static class Factory extends AbstractBlockParserFactory {
        @Override // org.commonmark.parser.block.BlockParserFactory
        public final BlockStart MyBillsEntityDataFactory(ParserState parserState, MatchedBlockParser matchedBlockParser) {
            int NetworkUserEntityData$$ExternalSyntheticLambda0 = parserState.NetworkUserEntityData$$ExternalSyntheticLambda0();
            CharSequence scheduleImpl = parserState.scheduleImpl();
            if (parserState.BuiltInFictitiousFunctionClassFactory() < 4) {
                Matcher matcher = FencedCodeBlockParser.MyBillsEntityDataFactory.matcher(scheduleImpl.subSequence(NetworkUserEntityData$$ExternalSyntheticLambda0, scheduleImpl.length()));
                if (matcher.find()) {
                    int length = matcher.group(0).length();
                    return BlockStart.BuiltInFictitiousFunctionClassFactory(new FencedCodeBlockParser(matcher.group(0).charAt(0), length, parserState.BuiltInFictitiousFunctionClassFactory())).KClassImpl$Data$declaredNonStaticMembers$2(NetworkUserEntityData$$ExternalSyntheticLambda0 + length);
                }
            }
            return BlockStart.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }
}
