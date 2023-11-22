package org.commonmark.internal;

import org.commonmark.node.Block;
import org.commonmark.node.Paragraph;
import org.commonmark.parser.InlineParser;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.ParserState;

/* loaded from: classes6.dex */
public class ParagraphParser extends AbstractBlockParser {
    private final Paragraph BuiltInFictitiousFunctionClassFactory = new Paragraph();
    BlockContent getAuthRequestContext = new BlockContent();

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
    }

    @Override // org.commonmark.parser.block.BlockParser
    public final Block MyBillsEntityDataFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public final BlockContinue PlaceComponentResult(ParserState parserState) {
        if (!parserState.lookAheadTest()) {
            return BlockContinue.BuiltInFictitiousFunctionClassFactory(parserState.MyBillsEntityDataFactory());
        }
        return BlockContinue.MyBillsEntityDataFactory();
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public final void PlaceComponentResult(CharSequence charSequence) {
        this.getAuthRequestContext.getAuthRequestContext(charSequence);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002b, code lost:
    
        if (org.commonmark.internal.util.Parsing.getAuthRequestContext(r0) == false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002d, code lost:
    
        r5.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0();
        r5.getAuthRequestContext = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0035, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void PlaceComponentResult(org.commonmark.internal.ReferenceParser r6) {
        /*
            r5 = this;
            org.commonmark.internal.BlockContent r0 = r5.getAuthRequestContext
            java.lang.StringBuilder r0 = r0.PlaceComponentResult
            java.lang.String r0 = r0.toString()
            r1 = 0
            r2 = 0
        La:
            int r3 = r0.length()
            r4 = 3
            if (r3 <= r4) goto L25
            char r3 = r0.charAt(r1)
            r4 = 91
            if (r3 != r4) goto L25
            int r3 = r6.getAuthRequestContext(r0)
            if (r3 == 0) goto L25
            java.lang.String r0 = r0.substring(r3)
            r2 = 1
            goto La
        L25:
            if (r2 == 0) goto L36
            boolean r6 = org.commonmark.internal.util.Parsing.getAuthRequestContext(r0)
            if (r6 == 0) goto L36
            org.commonmark.node.Paragraph r6 = r5.BuiltInFictitiousFunctionClassFactory
            r6.NetworkUserEntityData$$ExternalSyntheticLambda0()
            r6 = 0
            r5.getAuthRequestContext = r6
            return
        L36:
            org.commonmark.internal.BlockContent r6 = new org.commonmark.internal.BlockContent
            r6.<init>(r0)
            r5.getAuthRequestContext = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.commonmark.internal.ParagraphParser.PlaceComponentResult(org.commonmark.internal.ReferenceParser):void");
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public final void MyBillsEntityDataFactory(InlineParser inlineParser) {
        BlockContent blockContent = this.getAuthRequestContext;
        if (blockContent != null) {
            inlineParser.MyBillsEntityDataFactory(blockContent.PlaceComponentResult.toString(), this.BuiltInFictitiousFunctionClassFactory);
        }
    }
}
