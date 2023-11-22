package com.huawei.hms.support.api.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.push.i;
import com.huawei.hms.push.u;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;

/* loaded from: classes8.dex */
public class PushMsgReceiver extends BroadcastReceiver {
    public static void a(Context context, Intent intent) {
        if (intent.hasExtra("selfshow_info")) {
            if (!u.BuiltInFictitiousFunctionClassFactory(context)) {
                StringBuilder sb = new StringBuilder();
                sb.append(context.getPackageName());
                sb.append(" disable display notification.");
                HMSLog.i("PushMsgReceiver", sb.toString());
            }
            i.KClassImpl$Data$declaredNonStaticMembers$2(context, intent);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || context == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("push receive broadcast message, Intent:");
        sb.append(intent.getAction());
        sb.append(" pkgName:");
        sb.append(context.getPackageName());
        HMSLog.i("PushMsgReceiver", sb.toString());
        try {
            intent.getStringExtra("TestIntent");
            String action = intent.getAction();
            if (ResourceLoaderUtil.getmContext() == null) {
                ResourceLoaderUtil.setmContext(context.getApplicationContext());
            }
            if (!"com.huawei.intent.action.PUSH_DELAY_NOTIFY".equals(action) && (!"com.huawei.intent.action.PUSH".equals(action) || HwBuildEx.VERSION.EMUI_SDK_INT >= 10)) {
                HMSLog.i("PushMsgReceiver", "message can't be recognised.");
            } else {
                a(context, intent);
            }
        } catch (Exception unused) {
            HMSLog.e("PushMsgReceiver", "intent has some error");
        }
    }
}
