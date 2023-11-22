package com.huawei.hms.hatool;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* loaded from: classes8.dex */
public class t {
    public String BuiltInFictitiousFunctionClassFactory;
    public String MyBillsEntityDataFactory;
    public String PlaceComponentResult;
    public List<q> getAuthRequestContext;

    public t(List<q> list, String str, String str2, String str3) {
        this.getAuthRequestContext = list;
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.MyBillsEntityDataFactory = str2;
        this.PlaceComponentResult = str3;
    }

    public final void getAuthRequestContext(List<q> list, String str, String str2) {
        if (list.isEmpty()) {
            return;
        }
        int size = list.size() / 500;
        for (int i = 0; i < size + 1; i++) {
            int i2 = i * 500;
            List<q> subList = list.subList(i2, Math.min(list.size(), i2 + 500));
            String replace = UUID.randomUUID().toString().replace("-", "");
            long currentTimeMillis = System.currentTimeMillis();
            long MyBillsEntityDataFactory = c.MyBillsEntityDataFactory(str2, str);
            ArrayList arrayList = new ArrayList();
            for (q qVar : subList) {
                if (!q0.getAuthRequestContext(qVar.PlaceComponentResult, currentTimeMillis, 86400000 * MyBillsEntityDataFactory)) {
                    arrayList.add(qVar);
                }
            }
            if (arrayList.size() > 0) {
                new u(str2, str, this.PlaceComponentResult, arrayList, replace).KClassImpl$Data$declaredNonStaticMembers$2();
            } else {
                y.PlaceComponentResult("hmsSdk", "No data to report handler");
            }
        }
    }
}
