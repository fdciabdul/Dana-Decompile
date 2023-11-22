package com.akamai.botman;

/* loaded from: classes3.dex */
public final class ai<A, B, C> {
    public final B BuiltInFictitiousFunctionClassFactory;
    public final A KClassImpl$Data$declaredNonStaticMembers$2;
    public final C MyBillsEntityDataFactory;

    public ai(A a2, B b, C c) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = a2;
        this.BuiltInFictitiousFunctionClassFactory = b;
        this.MyBillsEntityDataFactory = c;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ai) {
            ai aiVar = (ai) obj;
            return aiVar.KClassImpl$Data$declaredNonStaticMembers$2.equals(this.KClassImpl$Data$declaredNonStaticMembers$2) && aiVar.BuiltInFictitiousFunctionClassFactory.equals(this.BuiltInFictitiousFunctionClassFactory) && aiVar.MyBillsEntityDataFactory.equals(this.MyBillsEntityDataFactory);
        }
        return false;
    }

    public final int hashCode() {
        A a2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode = a2 == null ? 0 : a2.hashCode();
        B b = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode2 = b == null ? 0 : b.hashCode();
        C c = this.MyBillsEntityDataFactory;
        return (hashCode ^ hashCode2) ^ (c != null ? c.hashCode() : 0);
    }
}
