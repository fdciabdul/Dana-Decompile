package org.commonmark.ext.gfm.strikethrough.internal;

import org.commonmark.ext.gfm.strikethrough.Strikethrough;
import org.commonmark.node.Node;
import org.commonmark.node.Text;
import org.commonmark.parser.delimiter.DelimiterProcessor;
import org.commonmark.parser.delimiter.DelimiterRun;

/* loaded from: classes6.dex */
public class StrikethroughDelimiterProcessor implements DelimiterProcessor {
    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public final int BuiltInFictitiousFunctionClassFactory() {
        return 2;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public final char MyBillsEntityDataFactory() {
        return '~';
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public final char PlaceComponentResult() {
        return '~';
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public final int getAuthRequestContext(DelimiterRun delimiterRun, DelimiterRun delimiterRun2) {
        return (delimiterRun.BuiltInFictitiousFunctionClassFactory() < 2 || delimiterRun2.BuiltInFictitiousFunctionClassFactory() < 2) ? 0 : 2;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Text text, Text text2, int i) {
        Strikethrough strikethrough = new Strikethrough();
        Node node = text.NetworkUserEntityData$$ExternalSyntheticLambda0;
        while (node != null && node != text2) {
            Node node2 = node.NetworkUserEntityData$$ExternalSyntheticLambda0;
            strikethrough.KClassImpl$Data$declaredNonStaticMembers$2(node);
            node = node2;
        }
        text.PlaceComponentResult(strikethrough);
    }
}
