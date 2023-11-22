package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.xiaomi.channel.commonutils.android.g;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.COSPushHelper;
import com.xiaomi.mipush.sdk.FTOSPushHelper;
import com.xiaomi.mipush.sdk.HWPushHelper;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.ag;
import com.xiaomi.mipush.sdk.am;
import com.xiaomi.mipush.sdk.x;
import com.xiaomi.push.cx;
import com.xiaomi.push.service.ServiceClient;
import com.xiaomi.push.y;

/* loaded from: classes8.dex */
public class NetworkStatusReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f7795a;
    private boolean b = true;

    public NetworkStatusReceiver() {
    }

    public NetworkStatusReceiver(Object obj) {
        f7795a = true;
    }

    public static boolean a() {
        return f7795a;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.b) {
            return;
        }
        g.getAuthRequestContext().post(new a(this, context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        if (!ag.BuiltInFictitiousFunctionClassFactory(context).getAuthRequestContext() && com.xiaomi.mipush.sdk.a.PlaceComponentResult(context).KClassImpl$Data$declaredNonStaticMembers$2() && !com.xiaomi.mipush.sdk.a.PlaceComponentResult(context).scheduleImpl()) {
            try {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(context, "com.xiaomi.push.service.XMPushService"));
                intent.setAction("com.xiaomi.push.network_status_changed");
                ServiceClient.BuiltInFictitiousFunctionClassFactory(context).getAuthRequestContext(intent);
            } catch (Exception e) {
                b.getAuthRequestContext(e);
            }
        }
        cx.MyBillsEntityDataFactory(context);
        if (y.MyBillsEntityDataFactory(context) && ag.BuiltInFictitiousFunctionClassFactory(context).PlaceComponentResult()) {
            ag BuiltInFictitiousFunctionClassFactory = ag.BuiltInFictitiousFunctionClassFactory(context);
            if (BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory != null) {
                BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = SystemClock.elapsedRealtime();
                BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory);
                BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = null;
            }
        }
        if (y.MyBillsEntityDataFactory(context)) {
            if ("syncing".equals(x.BuiltInFictitiousFunctionClassFactory(context).MyBillsEntityDataFactory(am.DISABLE_PUSH))) {
                MiPushClient.PlaceComponentResult(context);
            }
            if ("syncing".equals(x.BuiltInFictitiousFunctionClassFactory(context).MyBillsEntityDataFactory(am.ENABLE_PUSH))) {
                MiPushClient.KClassImpl$Data$declaredNonStaticMembers$2(context);
            }
            if ("syncing".equals(x.BuiltInFictitiousFunctionClassFactory(context).MyBillsEntityDataFactory(am.UPLOAD_HUAWEI_TOKEN))) {
                MiPushClient.NetworkUserEntityData$$ExternalSyntheticLambda5(context);
            }
            if ("syncing".equals(x.BuiltInFictitiousFunctionClassFactory(context).MyBillsEntityDataFactory(am.UPLOAD_FCM_TOKEN))) {
                MiPushClient.NetworkUserEntityData$$ExternalSyntheticLambda4(context);
            }
            if ("syncing".equals(x.BuiltInFictitiousFunctionClassFactory(context).MyBillsEntityDataFactory(am.UPLOAD_COS_TOKEN))) {
                MiPushClient.PrepareContext(context);
            }
            if ("syncing".equals(x.BuiltInFictitiousFunctionClassFactory(context).MyBillsEntityDataFactory(am.UPLOAD_FTOS_TOKEN))) {
                MiPushClient.FragmentBottomSheetPaymentSettingBinding(context);
            }
            if (HWPushHelper.getAuthRequestContext() && HWPushHelper.MyBillsEntityDataFactory(context)) {
                HWPushHelper.BuiltInFictitiousFunctionClassFactory(context);
                HWPushHelper.PlaceComponentResult(context);
            }
            COSPushHelper.BuiltInFictitiousFunctionClassFactory(context);
            FTOSPushHelper.MyBillsEntityDataFactory(context);
        }
    }
}
