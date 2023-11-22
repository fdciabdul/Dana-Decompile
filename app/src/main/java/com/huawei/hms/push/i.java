package com.huawei.hms.push;

import android.content.Context;
import android.content.Intent;
import com.alibaba.griver.base.preload.GriverOnPreloadExtension;
import com.huawei.hms.push.utils.PluginUtil;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes8.dex */
public class i {
    public static void KClassImpl$Data$declaredNonStaticMembers$2(Context context, Intent intent) {
        k kVar;
        try {
            if (context != null && intent != null) {
                String action = intent.getAction();
                if ("com.huawei.intent.action.PUSH".equals(action) || "com.huawei.push.msg.NOTIFY_MSG".equals(action) || "com.huawei.intent.action.PUSH_DELAY_NOTIFY".equals(action)) {
                    byte[] byteArrayExtra = intent.getByteArrayExtra("selfshow_info");
                    byte[] byteArrayExtra2 = intent.getByteArrayExtra("selfshow_token");
                    if (byteArrayExtra != null && byteArrayExtra2 != null && byteArrayExtra.length != 0 && byteArrayExtra2.length != 0) {
                        String stringExtra = intent.getStringExtra("selfshow_event_id");
                        int intExtra = intent.getIntExtra("selfshow_notify_id", 0);
                        StringBuilder sb = new StringBuilder();
                        sb.append("get notifyId:");
                        sb.append(intExtra);
                        HMSLog.i("PushSelfShowLog", sb.toString());
                        k kVar2 = new k(byteArrayExtra, byteArrayExtra2);
                        if (!kVar2.KClassImpl$Data$declaredNonStaticMembers$2()) {
                            HMSLog.d("PushSelfShowLog", "parseMessage failed");
                            return;
                        }
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("onReceive the msg id = ");
                        sb2.append(kVar2.PlaceComponentResult());
                        sb2.append(",and cmd is ");
                        sb2.append(kVar2.NetworkUserEntityData$$ExternalSyntheticLambda1);
                        sb2.append(",and the eventId is ");
                        sb2.append(stringExtra);
                        HMSLog.i("PushSelfShowLog", sb2.toString());
                        if (stringExtra == null) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("receive a selfshow message, the cmd type is ");
                            sb3.append(kVar2.NetworkUserEntityData$$ExternalSyntheticLambda1);
                            HMSLog.i("PushSelfShowLog", sb3.toString());
                            if (j.getAuthRequestContext(kVar2.NetworkUserEntityData$$ExternalSyntheticLambda1)) {
                                long PlaceComponentResult = q.PlaceComponentResult(kVar2.moveToNextValue);
                                if (PlaceComponentResult == 0) {
                                    new p(context, kVar2).start();
                                    return;
                                }
                                HMSLog.d("PushSelfShowLog", "waiting...");
                                intent.setPackage(context.getPackageName());
                                q.PlaceComponentResult(context, intent, PlaceComponentResult);
                                return;
                            }
                            return;
                        }
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("receive a selfshow user handle message eventId = ");
                        sb4.append(stringExtra);
                        HMSLog.d("PushSelfShowLog", sb4.toString());
                        if (!"-1".equals(stringExtra)) {
                            q.MyBillsEntityDataFactory(context, intent);
                        } else {
                            q.getAuthRequestContext(context, intExtra);
                        }
                        if ("1".equals(stringExtra)) {
                            j jVar = new j(context, kVar2);
                            HMSLog.d("PushSelfShowLog", "enter launchNotify()");
                            if (jVar.PlaceComponentResult != null && (kVar = jVar.getAuthRequestContext) != null) {
                                if (!GriverOnPreloadExtension.PARAMS_APP.equals(kVar.NetworkUserEntityData$$ExternalSyntheticLambda1)) {
                                    if ("cosa".equals(jVar.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda1)) {
                                        jVar.PlaceComponentResult();
                                    } else if ("rp".equals(jVar.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda1)) {
                                        StringBuilder sb5 = new StringBuilder();
                                        sb5.append(jVar.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda1);
                                        sb5.append(" not support rich message.");
                                        HMSLog.w("PushSelfShowLog", sb5.toString());
                                    } else if ("url".equals(jVar.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda1)) {
                                        StringBuilder sb6 = new StringBuilder();
                                        sb6.append(jVar.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda1);
                                        sb6.append(" not support URL.");
                                        HMSLog.w("PushSelfShowLog", sb6.toString());
                                    } else {
                                        StringBuilder sb7 = new StringBuilder();
                                        sb7.append(jVar.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda1);
                                        sb7.append(" is not exist in hShowType");
                                        HMSLog.d("PushSelfShowLog", sb7.toString());
                                    }
                                } else {
                                    try {
                                        StringBuilder sb8 = new StringBuilder();
                                        sb8.append("enter launchApp, appPackageName =");
                                        sb8.append(jVar.getAuthRequestContext.newProxyInstance);
                                        HMSLog.i("PushSelfShowLog", sb8.toString());
                                        if (q.PlaceComponentResult(jVar.PlaceComponentResult, jVar.getAuthRequestContext.newProxyInstance)) {
                                            jVar.PlaceComponentResult();
                                        }
                                    } catch (Exception e) {
                                        StringBuilder sb9 = new StringBuilder();
                                        sb9.append("launchApp error:");
                                        sb9.append(e.toString());
                                        HMSLog.e("PushSelfShowLog", sb9.toString());
                                    }
                                }
                            } else {
                                HMSLog.d("PushSelfShowLog", "launchNotify  context or msg is null");
                            }
                            PluginUtil.PlaceComponentResult(context, kVar2.PlaceComponentResult(), kVar2.getErrorConfigVersion);
                            return;
                        } else if ("2".equals(stringExtra)) {
                            e.getAuthRequestContext(context, kVar2.PlaceComponentResult(), kVar2.getErrorConfigVersion, "2");
                            return;
                        } else {
                            HMSLog.d("PushSelfShowLog", "other event");
                            return;
                        }
                    }
                    HMSLog.i("PushSelfShowLog", "self show info or token is null.");
                    return;
                }
                return;
            }
            HMSLog.d("PushSelfShowLog", "enter SelfShowReceiver receiver, context or intent is null");
        } catch (RuntimeException e2) {
            HMSLog.e("PushSelfShowLog", "onReceive RuntimeException.", e2);
        } catch (Exception unused) {
            HMSLog.d("PushSelfShowLog", "onReceive Exception.");
        }
    }
}
