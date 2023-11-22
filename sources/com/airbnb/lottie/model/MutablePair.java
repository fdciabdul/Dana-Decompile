package com.airbnb.lottie.model;

import androidx.core.util.Pair;

/* loaded from: classes3.dex */
public class MutablePair<T> {
    public T MyBillsEntityDataFactory;
    public T PlaceComponentResult;

    public boolean equals(Object obj) {
        if (obj instanceof Pair) {
            Pair pair = (Pair) obj;
            return KClassImpl$Data$declaredNonStaticMembers$2(pair.getAuthRequestContext, this.PlaceComponentResult) && KClassImpl$Data$declaredNonStaticMembers$2(pair.PlaceComponentResult, this.MyBillsEntityDataFactory);
        }
        return false;
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public int hashCode() {
        T t = this.PlaceComponentResult;
        int hashCode = t == null ? 0 : t.hashCode();
        T t2 = this.MyBillsEntityDataFactory;
        return hashCode ^ (t2 != null ? t2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pair{");
        sb.append(this.PlaceComponentResult);
        sb.append(" ");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append("}");
        return sb.toString();
    }
}
