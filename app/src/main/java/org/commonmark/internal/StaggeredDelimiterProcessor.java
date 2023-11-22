package org.commonmark.internal;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import org.commonmark.node.Text;
import org.commonmark.parser.delimiter.DelimiterProcessor;
import org.commonmark.parser.delimiter.DelimiterRun;

/* loaded from: classes6.dex */
class StaggeredDelimiterProcessor implements DelimiterProcessor {
    private int BuiltInFictitiousFunctionClassFactory = 0;
    private LinkedList<DelimiterProcessor> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedList<>();
    private final char MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StaggeredDelimiterProcessor(char c) {
        this.MyBillsEntityDataFactory = c;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public final char MyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public final char PlaceComponentResult() {
        return this.MyBillsEntityDataFactory;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public final int BuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void getAuthRequestContext(DelimiterProcessor delimiterProcessor) {
        boolean z;
        int BuiltInFictitiousFunctionClassFactory;
        int BuiltInFictitiousFunctionClassFactory2 = delimiterProcessor.BuiltInFictitiousFunctionClassFactory();
        ListIterator<DelimiterProcessor> listIterator = this.KClassImpl$Data$declaredNonStaticMembers$2.listIterator();
        do {
            if (listIterator.hasNext()) {
                BuiltInFictitiousFunctionClassFactory = listIterator.next().BuiltInFictitiousFunctionClassFactory();
                if (BuiltInFictitiousFunctionClassFactory2 > BuiltInFictitiousFunctionClassFactory) {
                    listIterator.previous();
                    listIterator.add(delimiterProcessor);
                    z = true;
                }
            } else {
                z = false;
            }
            if (z) {
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.add(delimiterProcessor);
            this.BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory2;
            return;
        } while (BuiltInFictitiousFunctionClassFactory2 != BuiltInFictitiousFunctionClassFactory);
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot add two delimiter processors for char '");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append("' and minimum length ");
        sb.append(BuiltInFictitiousFunctionClassFactory2);
        throw new IllegalArgumentException(sb.toString());
    }

    private DelimiterProcessor KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        Iterator<DelimiterProcessor> it = this.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
        while (it.hasNext()) {
            DelimiterProcessor next = it.next();
            if (next.BuiltInFictitiousFunctionClassFactory() <= i) {
                return next;
            }
        }
        return this.KClassImpl$Data$declaredNonStaticMembers$2.getFirst();
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public final int getAuthRequestContext(DelimiterRun delimiterRun, DelimiterRun delimiterRun2) {
        return KClassImpl$Data$declaredNonStaticMembers$2(delimiterRun.BuiltInFictitiousFunctionClassFactory()).getAuthRequestContext(delimiterRun, delimiterRun2);
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Text text, Text text2, int i) {
        KClassImpl$Data$declaredNonStaticMembers$2(i).KClassImpl$Data$declaredNonStaticMembers$2(text, text2, i);
    }
}
