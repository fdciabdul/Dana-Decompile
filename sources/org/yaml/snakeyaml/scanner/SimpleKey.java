package org.yaml.snakeyaml.scanner;

import org.yaml.snakeyaml.error.Mark;

/* loaded from: classes6.dex */
final class SimpleKey {
    final int BuiltInFictitiousFunctionClassFactory;
    final int KClassImpl$Data$declaredNonStaticMembers$2;
    final int MyBillsEntityDataFactory;
    final int PlaceComponentResult;
    final Mark getAuthRequestContext;
    private final boolean lookAheadTest;

    public SimpleKey(int i, boolean z, int i2, int i3, int i4, Mark mark) {
        this.PlaceComponentResult = i;
        this.lookAheadTest = z;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i2;
        this.BuiltInFictitiousFunctionClassFactory = i3;
        this.MyBillsEntityDataFactory = i4;
        this.getAuthRequestContext = mark;
    }

    public final boolean MyBillsEntityDataFactory() {
        return this.lookAheadTest;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SimpleKey - tokenNumber=");
        sb.append(this.PlaceComponentResult);
        sb.append(" required=");
        sb.append(this.lookAheadTest);
        sb.append(" index=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(" line=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(" column=");
        sb.append(this.MyBillsEntityDataFactory);
        return sb.toString();
    }
}
