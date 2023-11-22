package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.hash.SHA;
import java.util.UUID;

/* loaded from: classes8.dex */
public class z0 {
    public static z0 KClassImpl$Data$declaredNonStaticMembers$2;
    public Context MyBillsEntityDataFactory;

    /* loaded from: classes8.dex */
    public static class a extends a1 {
        public String BuiltInFictitiousFunctionClassFactory;
        public String PlaceComponentResult;

        public a(String str, String str2) {
            this.PlaceComponentResult = str;
            this.BuiltInFictitiousFunctionClassFactory = str2;
        }

        @Override // com.huawei.hms.hatool.a1
        public final String BuiltInFictitiousFunctionClassFactory() {
            return com.huawei.hms.hatool.a.moveToNextValue(this.PlaceComponentResult, this.BuiltInFictitiousFunctionClassFactory);
        }

        @Override // com.huawei.hms.hatool.a1
        public final String KClassImpl$Data$declaredNonStaticMembers$2() {
            return com.huawei.hms.hatool.a.scheduleImpl(this.PlaceComponentResult, this.BuiltInFictitiousFunctionClassFactory);
        }

        @Override // com.huawei.hms.hatool.a1
        public final String KClassImpl$Data$declaredNonStaticMembers$2(String str) {
            return SHA.PlaceComponentResult(str);
        }

        @Override // com.huawei.hms.hatool.a1
        public final String MyBillsEntityDataFactory() {
            return com.huawei.hms.hatool.a.MyBillsEntityDataFactory(this.PlaceComponentResult, this.BuiltInFictitiousFunctionClassFactory);
        }

        @Override // com.huawei.hms.hatool.a1
        public final int PlaceComponentResult() {
            return (com.huawei.hms.hatool.a.lookAheadTest(this.PlaceComponentResult, this.BuiltInFictitiousFunctionClassFactory) ? 4 : 0) | 0 | (com.huawei.hms.hatool.a.getAuthRequestContext(this.PlaceComponentResult, this.BuiltInFictitiousFunctionClassFactory) ? 2 : 0) | (com.huawei.hms.hatool.a.NetworkUserEntityData$$ExternalSyntheticLambda0(this.PlaceComponentResult, this.BuiltInFictitiousFunctionClassFactory) ? 1 : 0);
        }
    }

    public static String BuiltInFictitiousFunctionClassFactory(String str, String str2) {
        return c1.MyBillsEntityDataFactory(str, str2);
    }

    public static z0 getAuthRequestContext() {
        z0 z0Var;
        synchronized (z0.class) {
            if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                KClassImpl$Data$declaredNonStaticMembers$2 = new z0();
            }
            z0Var = KClassImpl$Data$declaredNonStaticMembers$2;
        }
        return z0Var;
    }

    public static String getAuthRequestContext(String str, String str2) {
        String NetworkUserEntityData$$ExternalSyntheticLambda1;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = c.NetworkUserEntityData$$ExternalSyntheticLambda1(str, str2);
        return NetworkUserEntityData$$ExternalSyntheticLambda1;
    }

    public final String KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
        String str;
        if (z) {
            str = i.KClassImpl$Data$declaredNonStaticMembers$2().MyBillsEntityDataFactory.lookAheadTest;
            if (TextUtils.isEmpty(str)) {
                str = g0.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory, "global_v2", "uuid", "");
                if (TextUtils.isEmpty(str)) {
                    str = UUID.randomUUID().toString().replace("-", "");
                    g0.getAuthRequestContext(this.MyBillsEntityDataFactory, "global_v2", "uuid", str);
                }
                b.getErrorConfigVersion(str);
            }
            return str;
        }
        return "";
    }
}
