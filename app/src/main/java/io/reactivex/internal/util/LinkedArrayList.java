package io.reactivex.internal.util;

import java.util.ArrayList;

/* loaded from: classes9.dex */
public class LinkedArrayList {
    volatile int BuiltInFictitiousFunctionClassFactory;
    final int KClassImpl$Data$declaredNonStaticMembers$2;
    Object[] PlaceComponentResult;

    public String toString() {
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int i2 = this.BuiltInFictitiousFunctionClassFactory;
        ArrayList arrayList = new ArrayList(i2 + 1);
        Object[] objArr = this.PlaceComponentResult;
        int i3 = 0;
        while (true) {
            int i4 = 0;
            while (i3 < i2) {
                arrayList.add(objArr[i4]);
                i3++;
                i4++;
                if (i4 == i) {
                    break;
                }
            }
            return arrayList.toString();
            objArr = objArr[i];
        }
    }
}
