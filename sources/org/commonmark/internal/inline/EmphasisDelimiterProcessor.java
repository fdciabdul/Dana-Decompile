package org.commonmark.internal.inline;

import org.commonmark.node.Emphasis;
import org.commonmark.node.Node;
import org.commonmark.node.StrongEmphasis;
import org.commonmark.node.Text;
import org.commonmark.parser.delimiter.DelimiterProcessor;
import org.commonmark.parser.delimiter.DelimiterRun;

/* loaded from: classes6.dex */
public abstract class EmphasisDelimiterProcessor implements DelimiterProcessor {
    private final char KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public final int BuiltInFictitiousFunctionClassFactory() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public EmphasisDelimiterProcessor(char c) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = c;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public final char MyBillsEntityDataFactory() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public final char PlaceComponentResult() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public final int getAuthRequestContext(DelimiterRun delimiterRun, DelimiterRun delimiterRun2) {
        if ((delimiterRun.getAuthRequestContext() || delimiterRun2.PlaceComponentResult()) && (delimiterRun.KClassImpl$Data$declaredNonStaticMembers$2() + delimiterRun2.KClassImpl$Data$declaredNonStaticMembers$2()) % 3 == 0) {
            return 0;
        }
        return (delimiterRun.BuiltInFictitiousFunctionClassFactory() < 2 || delimiterRun2.BuiltInFictitiousFunctionClassFactory() < 2) ? 1 : 2;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Text text, Text text2, int i) {
        Node strongEmphasis;
        String valueOf = String.valueOf(MyBillsEntityDataFactory());
        if (i == 1) {
            strongEmphasis = new Emphasis(valueOf);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(valueOf);
            sb.append(valueOf);
            strongEmphasis = new StrongEmphasis(sb.toString());
        }
        Node node = text.NetworkUserEntityData$$ExternalSyntheticLambda0;
        while (node != null && node != text2) {
            Node node2 = node.NetworkUserEntityData$$ExternalSyntheticLambda0;
            strongEmphasis.KClassImpl$Data$declaredNonStaticMembers$2(node);
            node = node2;
        }
        text.PlaceComponentResult(strongEmphasis);
    }
}
