package com.xiaomi.push;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class ch extends cj {
    final Map<String, String> BuiltInFictitiousFunctionClassFactory;
    a PlaceComponentResult;

    /* loaded from: classes8.dex */
    public static class a {
        private String NetworkUserEntityData$$ExternalSyntheticLambda0;
        public static final a PlaceComponentResult = new a("get");
        public static final a BuiltInFictitiousFunctionClassFactory = new a("set");
        public static final a KClassImpl$Data$declaredNonStaticMembers$2 = new a("result");
        public static final a MyBillsEntityDataFactory = new a("error");
        public static final a getAuthRequestContext = new a("command");

        private a(String str) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str;
        }

        public static a getAuthRequestContext(String str) {
            if (str == null) {
                return null;
            }
            String lowerCase = str.toLowerCase();
            a aVar = PlaceComponentResult;
            if (aVar.toString().equals(lowerCase)) {
                return aVar;
            }
            a aVar2 = BuiltInFictitiousFunctionClassFactory;
            if (aVar2.toString().equals(lowerCase)) {
                return aVar2;
            }
            a aVar3 = MyBillsEntityDataFactory;
            if (aVar3.toString().equals(lowerCase)) {
                return aVar3;
            }
            a aVar4 = KClassImpl$Data$declaredNonStaticMembers$2;
            if (aVar4.toString().equals(lowerCase)) {
                return aVar4;
            }
            a aVar5 = getAuthRequestContext;
            if (aVar5.toString().equals(lowerCase)) {
                return aVar5;
            }
            return null;
        }

        public String toString() {
            return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }
    }

    public ch() {
        this.PlaceComponentResult = a.PlaceComponentResult;
        this.BuiltInFictitiousFunctionClassFactory = new HashMap();
    }

    public ch(Bundle bundle) {
        super(bundle);
        this.PlaceComponentResult = a.PlaceComponentResult;
        this.BuiltInFictitiousFunctionClassFactory = new HashMap();
        if (bundle.containsKey("ext_iq_type")) {
            this.PlaceComponentResult = a.getAuthRequestContext(bundle.getString("ext_iq_type"));
        }
    }

    @Override // com.xiaomi.push.cj
    public final Bundle KClassImpl$Data$declaredNonStaticMembers$2() {
        Bundle KClassImpl$Data$declaredNonStaticMembers$2 = super.KClassImpl$Data$declaredNonStaticMembers$2();
        a aVar = this.PlaceComponentResult;
        if (aVar != null) {
            KClassImpl$Data$declaredNonStaticMembers$2.putString("ext_iq_type", aVar.toString());
        }
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // com.xiaomi.push.cj
    public final String MyBillsEntityDataFactory() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("<iq ");
        if (getAuthRequestContext() != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("id=\"");
            sb2.append(getAuthRequestContext());
            sb2.append("\" ");
            sb.append(sb2.toString());
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda7 != null) {
            sb.append("to=\"");
            sb.append(cu.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda7));
            sb.append("\" ");
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda8 != null) {
            sb.append("from=\"");
            sb.append(cu.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda8));
            sb.append("\" ");
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda3 != null) {
            sb.append("chid=\"");
            sb.append(cu.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda3));
            sb.append("\" ");
        }
        for (Map.Entry<String, String> entry : this.BuiltInFictitiousFunctionClassFactory.entrySet()) {
            sb.append(cu.BuiltInFictitiousFunctionClassFactory(entry.getKey()));
            sb.append("=\"");
            sb.append(cu.BuiltInFictitiousFunctionClassFactory(entry.getValue()));
            sb.append("\" ");
        }
        if (this.PlaceComponentResult == null) {
            str = "type=\"get\">";
        } else {
            sb.append("type=\"");
            sb.append(this.PlaceComponentResult);
            str = "\">";
        }
        sb.append(str);
        sb.append(scheduleImpl());
        cn cnVar = this.isLayoutRequested;
        if (cnVar != null) {
            sb.append(cnVar.PlaceComponentResult());
        }
        sb.append("</iq>");
        return sb.toString();
    }
}
