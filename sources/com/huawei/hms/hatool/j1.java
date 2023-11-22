package com.huawei.hms.hatool;

import android.text.TextUtils;

/* loaded from: classes8.dex */
public class j1 {
    public m KClassImpl$Data$declaredNonStaticMembers$2 = new m();
    public String getAuthRequestContext;

    public j1(String str) {
        this.getAuthRequestContext = str;
        i.KClassImpl$Data$declaredNonStaticMembers$2();
        i.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    public final boolean MyBillsEntityDataFactory(int i) {
        String obj;
        if (i != 2) {
            k kVar = i != 0 ? i != 1 ? i != 2 ? i != 3 ? null : this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext : this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult : this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 : this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory;
            if (kVar != null && !TextUtils.isEmpty(kVar.KClassImpl$Data$declaredNonStaticMembers$2)) {
                return true;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("verifyURL(): URL check failed. type: ");
            sb.append(i);
            obj = sb.toString();
        } else if ("_default_config_tag".equals(this.getAuthRequestContext)) {
            return true;
        } else {
            obj = "verifyURL(): type: preins. Only default config can report Pre-install data.";
        }
        y.PlaceComponentResult("hmsSdk", obj);
        return false;
    }
}
