package com.bumptech.glide.util;

/* loaded from: classes3.dex */
public class MultiClassKey {
    public Class<?> BuiltInFictitiousFunctionClassFactory;
    public Class<?> KClassImpl$Data$declaredNonStaticMembers$2;
    public Class<?> MyBillsEntityDataFactory;

    public MultiClassKey() {
    }

    public MultiClassKey(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        this.MyBillsEntityDataFactory = cls;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = cls2;
        this.BuiltInFictitiousFunctionClassFactory = cls3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MultiClassKey{first=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", second=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MultiClassKey multiClassKey = (MultiClassKey) obj;
        return this.MyBillsEntityDataFactory.equals(multiClassKey.MyBillsEntityDataFactory) && this.KClassImpl$Data$declaredNonStaticMembers$2.equals(multiClassKey.KClassImpl$Data$declaredNonStaticMembers$2) && Util.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory, multiClassKey.BuiltInFictitiousFunctionClassFactory);
    }

    public int hashCode() {
        int hashCode = this.MyBillsEntityDataFactory.hashCode();
        int hashCode2 = this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
        Class<?> cls = this.BuiltInFictitiousFunctionClassFactory;
        return (((hashCode * 31) + hashCode2) * 31) + (cls != null ? cls.hashCode() : 0);
    }
}
