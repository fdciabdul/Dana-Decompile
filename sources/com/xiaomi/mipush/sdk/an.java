package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.dt;

/* loaded from: classes8.dex */
public class an {
    public static void BuiltInFictitiousFunctionClassFactory(Context context, dt dtVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("need to update local info with: ");
        sb.append(dtVar.m324a());
        com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
        String str = dtVar.m324a().get("accept_time");
        if (str != null) {
            MiPushClient.NetworkUserEntityData$$ExternalSyntheticLambda2(context);
            String[] split = str.split("-");
            if (split.length == 2) {
                MiPushClient.getAuthRequestContext(context, split[0], split[1]);
                if ("00:00".equals(split[0]) && "00:00".equals(split[1])) {
                    a.PlaceComponentResult(context).KClassImpl$Data$declaredNonStaticMembers$2(true);
                } else {
                    a.PlaceComponentResult(context).KClassImpl$Data$declaredNonStaticMembers$2(false);
                }
            }
        }
        String str2 = dtVar.m324a().get("aliases");
        if (str2 != null) {
            MiPushClient.NetworkUserEntityData$$ExternalSyntheticLambda7(context);
            if (!"".equals(str2)) {
                for (String str3 : str2.split(",")) {
                    MiPushClient.BuiltInFictitiousFunctionClassFactory(context, str3);
                }
            }
        }
        String str4 = dtVar.m324a().get("topics");
        if (str4 != null) {
            MiPushClient.newProxyInstance(context);
            if (!"".equals(str4)) {
                for (String str5 : str4.split(",")) {
                    MiPushClient.MyBillsEntityDataFactory(context, str5);
                }
            }
        }
        String str6 = dtVar.m324a().get("user_accounts");
        if (str6 != null) {
            MiPushClient.NetworkUserEntityData$$ExternalSyntheticLambda8(context);
            if ("".equals(str6)) {
                return;
            }
            for (String str7 : str6.split(",")) {
                MiPushClient.getAuthRequestContext(context, str7);
            }
        }
    }
}
