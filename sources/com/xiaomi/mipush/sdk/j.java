package com.xiaomi.mipush.sdk;

import com.xiaomi.push.db;
import java.util.HashMap;

/* loaded from: classes8.dex */
public class j {
    private static HashMap<c, a> KClassImpl$Data$declaredNonStaticMembers$2 = new HashMap<>();

    /* loaded from: classes8.dex */
    static class a {
        public String KClassImpl$Data$declaredNonStaticMembers$2;
        public String MyBillsEntityDataFactory;

        public a(String str, String str2) {
            this.MyBillsEntityDataFactory = str;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
        }
    }

    public static db KClassImpl$Data$declaredNonStaticMembers$2() {
        return null;
    }

    public static a PlaceComponentResult(c cVar) {
        return KClassImpl$Data$declaredNonStaticMembers$2.get(cVar);
    }

    public static am getAuthRequestContext(c cVar) {
        int i = k.MyBillsEntityDataFactory[cVar.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return null;
                    }
                    return am.UPLOAD_FTOS_TOKEN;
                }
                return am.UPLOAD_COS_TOKEN;
            }
            return am.UPLOAD_FCM_TOKEN;
        }
        return am.UPLOAD_HUAWEI_TOKEN;
    }

    static {
        KClassImpl$Data$declaredNonStaticMembers$2.put(c.ASSEMBLE_PUSH_HUAWEI, new a("com.xiaomi.assemble.control.HmsPushManager", "newInstance"));
        KClassImpl$Data$declaredNonStaticMembers$2.put(c.ASSEMBLE_PUSH_FCM, new a("com.xiaomi.assemble.control.FCMPushManager", "newInstance"));
        KClassImpl$Data$declaredNonStaticMembers$2.put(c.ASSEMBLE_PUSH_COS, new a("com.xiaomi.assemble.control.COSPushManager", "newInstance"));
        KClassImpl$Data$declaredNonStaticMembers$2.put(c.ASSEMBLE_PUSH_FTOS, new a("com.xiaomi.assemble.control.FTOSPushManager", "newInstance"));
    }
}
