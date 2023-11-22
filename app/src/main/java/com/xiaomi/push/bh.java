package com.xiaomi.push;

import android.text.TextUtils;
import com.google.android.gms.fido.u2f.api.common.ClientData;
import com.xiaomi.push.au;
import com.xiaomi.push.service.az;
import id.dana.data.foundation.logger.log.LoginTrackingConstants;
import java.util.HashMap;

/* loaded from: classes8.dex */
class bh {
    public static void KClassImpl$Data$declaredNonStaticMembers$2(az.b bVar, String str, bt btVar) {
        String authRequestContext;
        au.c cVar = new au.c();
        if (!TextUtils.isEmpty(bVar.NetworkUserEntityData$$ExternalSyntheticLambda2)) {
            String str2 = bVar.NetworkUserEntityData$$ExternalSyntheticLambda2;
            cVar.PlaceComponentResult = true;
            cVar.getAuthRequestContext = str2;
        }
        if (!TextUtils.isEmpty(bVar.GetContactSyncConfig)) {
            String str3 = bVar.GetContactSyncConfig;
            cVar.lookAheadTest = true;
            cVar.scheduleImpl = str3;
        }
        if (!TextUtils.isEmpty(bVar.PrepareContext)) {
            String str4 = bVar.PrepareContext;
            cVar.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
            cVar.moveToNextValue = str4;
        }
        String str5 = bVar.scheduleImpl ? "1" : "0";
        cVar.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        cVar.MyBillsEntityDataFactory = str5;
        if (!TextUtils.isEmpty(bVar.NetworkUserEntityData$$ExternalSyntheticLambda1)) {
            String str6 = bVar.NetworkUserEntityData$$ExternalSyntheticLambda1;
            cVar.getErrorConfigVersion = true;
            cVar.BuiltInFictitiousFunctionClassFactory = str6;
        } else {
            cVar.getErrorConfigVersion = true;
            cVar.BuiltInFictitiousFunctionClassFactory = "XIAOMI-SASL";
        }
        bi biVar = new bi();
        biVar.BuiltInFictitiousFunctionClassFactory(bVar.DatabaseTableConfigUtil);
        int parseInt = Integer.parseInt(bVar.newProxyInstance);
        au.a aVar = biVar.PlaceComponentResult;
        aVar.getAuthRequestContext = true;
        aVar.PlaceComponentResult = parseInt;
        biVar.getAuthRequestContext = bVar.NetworkUserEntityData$$ExternalSyntheticLambda0;
        biVar.getAuthRequestContext("BIND", null);
        String MyBillsEntityDataFactory = biVar.MyBillsEntityDataFactory();
        au.a aVar2 = biVar.PlaceComponentResult;
        aVar2.PrepareContext = true;
        aVar2.initRecordTimeStamp = MyBillsEntityDataFactory;
        StringBuilder sb = new StringBuilder();
        sb.append("[Slim]: bind id=");
        sb.append(biVar.MyBillsEntityDataFactory());
        com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
        HashMap hashMap = new HashMap();
        hashMap.put(ClientData.KEY_CHALLENGE, str);
        hashMap.put("token", bVar.NetworkUserEntityData$$ExternalSyntheticLambda2);
        hashMap.put("chid", bVar.newProxyInstance);
        hashMap.put("from", bVar.DatabaseTableConfigUtil);
        hashMap.put("id", biVar.MyBillsEntityDataFactory());
        hashMap.put(LoginTrackingConstants.LoginParam.TO, "xiaomi.com");
        if (bVar.scheduleImpl) {
            hashMap.put("kick", "1");
        } else {
            hashMap.put("kick", "0");
        }
        if (TextUtils.isEmpty(bVar.GetContactSyncConfig)) {
            hashMap.put("client_attrs", "");
        } else {
            hashMap.put("client_attrs", bVar.GetContactSyncConfig);
        }
        if (TextUtils.isEmpty(bVar.PrepareContext)) {
            hashMap.put("cloud_attrs", "");
        } else {
            hashMap.put("cloud_attrs", bVar.PrepareContext);
        }
        if (bVar.NetworkUserEntityData$$ExternalSyntheticLambda1.equals("XIAOMI-PASS") || bVar.NetworkUserEntityData$$ExternalSyntheticLambda1.equals("XMPUSH-PASS")) {
            authRequestContext = ab.getAuthRequestContext(bVar.NetworkUserEntityData$$ExternalSyntheticLambda1, hashMap, bVar.isLayoutRequested);
        } else {
            bVar.NetworkUserEntityData$$ExternalSyntheticLambda1.equals("XIAOMI-SASL");
            authRequestContext = null;
        }
        cVar.GetContactSyncConfig = true;
        cVar.DatabaseTableConfigUtil = authRequestContext;
        biVar.BuiltInFictitiousFunctionClassFactory(cVar.moveToNextValue(), (String) null);
        btVar.PlaceComponentResult(biVar);
    }

    public static void MyBillsEntityDataFactory(String str, String str2, bt btVar) {
        bi biVar = new bi();
        biVar.BuiltInFictitiousFunctionClassFactory(str2);
        int parseInt = Integer.parseInt(str);
        au.a aVar = biVar.PlaceComponentResult;
        aVar.getAuthRequestContext = true;
        aVar.PlaceComponentResult = parseInt;
        biVar.getAuthRequestContext("UBND", null);
        btVar.PlaceComponentResult(biVar);
    }
}
