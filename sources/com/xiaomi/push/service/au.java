package com.xiaomi.push.service;

import android.util.Pair;
import com.xiaomi.push.dc;
import com.xiaomi.push.dd;
import com.xiaomi.push.de;
import com.xiaomi.push.dg;
import com.xiaomi.push.dr;
import com.xiaomi.push.ds;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class au {
    public static int BuiltInFictitiousFunctionClassFactory(at atVar, dc dcVar) {
        return atVar.BuiltInFictitiousFunctionClassFactory(dcVar, av.MyBillsEntityDataFactory[dcVar.ordinal()] != 1 ? 0 : 1);
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(at atVar, dr drVar) {
        atVar.MyBillsEntityDataFactory(PlaceComponentResult(drVar.a(), true));
        atVar.BuiltInFictitiousFunctionClassFactory();
    }

    private static List<Pair<Integer, Object>> PlaceComponentResult(List<dg> list, boolean z) {
        if (com.xiaomi.push.k.getAuthRequestContext(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (dg dgVar : list) {
            int a2 = dgVar.a();
            dd a3 = dd.a(dgVar.b());
            if (a3 != null) {
                if (z && dgVar.f110a) {
                    arrayList.add(new Pair(Integer.valueOf(a2), null));
                } else {
                    int i = av.KClassImpl$Data$declaredNonStaticMembers$2[a3.ordinal()];
                    arrayList.add(i != 1 ? i != 2 ? i != 3 ? i != 4 ? null : new Pair(Integer.valueOf(a2), Boolean.valueOf(dgVar.g())) : new Pair(Integer.valueOf(a2), dgVar.m263a()) : new Pair(Integer.valueOf(a2), Long.valueOf(dgVar.m262a())) : new Pair(Integer.valueOf(a2), Integer.valueOf(dgVar.c())));
                }
            }
        }
        return arrayList;
    }

    public static void getAuthRequestContext(at atVar, ds dsVar) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (de deVar : dsVar.a()) {
            arrayList.add(new Pair<>(deVar.m258a(), Integer.valueOf(deVar.a())));
            List<Pair<Integer, Object>> PlaceComponentResult = PlaceComponentResult(deVar.f102a, false);
            if (!com.xiaomi.push.k.getAuthRequestContext(PlaceComponentResult)) {
                arrayList2.addAll(PlaceComponentResult);
            }
        }
        atVar.BuiltInFictitiousFunctionClassFactory(arrayList, arrayList2);
        atVar.BuiltInFictitiousFunctionClassFactory();
    }
}
