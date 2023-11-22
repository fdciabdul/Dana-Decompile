package com.huawei.hms.hatool;

import android.content.Context;

/* loaded from: classes8.dex */
public class m1 {
    public String BuiltInFictitiousFunctionClassFactory;
    public Context KClassImpl$Data$declaredNonStaticMembers$2;
    public k MyBillsEntityDataFactory;
    public k getAuthRequestContext;

    public m1(Context context) {
        if (context != null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = context.getApplicationContext();
        }
        this.getAuthRequestContext = new k();
        this.MyBillsEntityDataFactory = new k();
    }

    public final m1 KClassImpl$Data$declaredNonStaticMembers$2(int i, String str) {
        k kVar;
        StringBuilder sb = new StringBuilder();
        sb.append("Builder.setCollectURL(int type,String collectURL) is execute.TYPE : ");
        sb.append(i);
        y.BuiltInFictitiousFunctionClassFactory("hmsSdk", sb.toString());
        if (!v0.PlaceComponentResult(str)) {
            str = "";
        }
        if (i == 0) {
            kVar = this.getAuthRequestContext;
        } else if (i != 1) {
            y.moveToNextValue("hmsSdk", "Builder.setCollectURL(int type,String collectURL): invalid type!");
            return this;
        } else {
            kVar = this.MyBillsEntityDataFactory;
        }
        kVar.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        return this;
    }
}
