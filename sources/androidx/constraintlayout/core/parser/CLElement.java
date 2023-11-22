package androidx.constraintlayout.core.parser;

import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: classes6.dex */
public class CLElement {
    private final char[] BuiltInFictitiousFunctionClassFactory;
    protected long MyBillsEntityDataFactory;
    int PlaceComponentResult;
    protected long getAuthRequestContext;

    public String toString() {
        long j = this.getAuthRequestContext;
        long j2 = this.MyBillsEntityDataFactory;
        if (j > j2 || j2 == LongCompanionObject.MAX_VALUE) {
            StringBuilder sb = new StringBuilder();
            sb.append(getClass());
            sb.append(" (INVALID, ");
            sb.append(this.getAuthRequestContext);
            sb.append("-");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(")");
            return sb.toString();
        }
        String substring = new String(this.BuiltInFictitiousFunctionClassFactory).substring((int) this.getAuthRequestContext, ((int) this.MyBillsEntityDataFactory) + 1);
        StringBuilder sb2 = new StringBuilder();
        String obj = getClass().toString();
        sb2.append(obj.substring(obj.lastIndexOf(46) + 1));
        sb2.append(" (");
        sb2.append(this.getAuthRequestContext);
        sb2.append(" : ");
        sb2.append(this.MyBillsEntityDataFactory);
        sb2.append(") <<");
        sb2.append(substring);
        sb2.append(">>");
        return sb2.toString();
    }
}
