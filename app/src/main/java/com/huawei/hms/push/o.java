package com.huawei.hms.push;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.api.push.TransActivity;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.zoloz.rpc.encryption.EncryptionProxyInvocationHandler;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes8.dex */
public class o {
    public static int PlaceComponentResult;

    public static void getAuthRequestContext(Context context, k kVar) {
        int hashCode;
        int i;
        int i2;
        int hashCode2;
        PendingIntent broadcast;
        PendingIntent broadcast2;
        synchronized (o.class) {
            if (context != null) {
                if (!MyBillsEntityDataFactory(kVar)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("showNotification, the msg id = ");
                    sb.append(kVar.PlaceComponentResult());
                    HMSLog.d("PushSelfShowLog", sb.toString());
                    if (PlaceComponentResult == 0) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(context.getPackageName());
                        sb2.append(System.currentTimeMillis());
                        PlaceComponentResult = sb2.toString().hashCode();
                    }
                    if (!TextUtils.isEmpty(kVar.NetworkUserEntityData$$ExternalSyntheticLambda0)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(kVar.NetworkUserEntityData$$ExternalSyntheticLambda0);
                        sb3.append(kVar.GetContactSyncConfig);
                        hashCode = sb3.toString().hashCode();
                        i = PlaceComponentResult + 1;
                        i2 = i + 1;
                        PlaceComponentResult = i2;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(kVar.NetworkUserEntityData$$ExternalSyntheticLambda0);
                        sb4.append(kVar.GetContactSyncConfig);
                        sb4.append(context.getPackageName());
                        hashCode2 = sb4.toString().hashCode();
                    } else {
                        String str = kVar.KClassImpl$Data$declaredNonStaticMembers$2;
                        if (!TextUtils.isEmpty(str)) {
                            int hashCode3 = str.hashCode();
                            kVar.PlaceComponentResult = hashCode3;
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("notification msgTag = ");
                            sb5.append(hashCode3);
                            HMSLog.d("PushSelfShowLog", sb5.toString());
                        }
                        if (kVar.PlaceComponentResult == -1) {
                            hashCode = PlaceComponentResult + 1;
                            i = hashCode + 1;
                            i2 = i + 1;
                            hashCode2 = i2 + 1;
                            PlaceComponentResult = hashCode2;
                        } else {
                            hashCode = kVar.PlaceComponentResult;
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append(kVar.GetContactSyncConfig);
                            sb6.append(System.currentTimeMillis());
                            i = sb6.toString().hashCode();
                            i2 = i + 1;
                            StringBuilder sb7 = new StringBuilder();
                            sb7.append(kVar.PlaceComponentResult);
                            sb7.append(kVar.GetContactSyncConfig);
                            sb7.append(context.getPackageName());
                            hashCode2 = sb7.toString().hashCode();
                        }
                    }
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append("notifyId:");
                    sb8.append(hashCode);
                    sb8.append(",openNotifyId:");
                    sb8.append(i);
                    sb8.append(",delNotifyId:");
                    sb8.append(i2);
                    sb8.append(",alarmNotifyId:");
                    sb8.append(hashCode2);
                    HMSLog.d("PushSelfShowLog", sb8.toString());
                    int[] iArr = new int[4];
                    iArr[0] = hashCode;
                    iArr[1] = i;
                    iArr[2] = i2;
                    if (kVar.scheduleImpl <= 0) {
                        hashCode2 = 0;
                    }
                    iArr[3] = hashCode2;
                    Notification notification = null;
                    if (q.BuiltInFictitiousFunctionClassFactory()) {
                        Notification.Builder builder = new Notification.Builder(context);
                        if (m.getAuthRequestContext(kVar) == n.STYLE_BIGTEXT) {
                            m.BuiltInFictitiousFunctionClassFactory(builder, kVar.getCallingPid, kVar);
                        }
                        l.BuiltInFictitiousFunctionClassFactory(context, builder, kVar);
                        String str2 = kVar.isLayoutRequested;
                        if (!TextUtils.isEmpty(str2)) {
                            builder.setSubText(str2);
                        }
                        String str3 = kVar.NetworkUserEntityData$$ExternalSyntheticLambda7;
                        String str4 = kVar.initRecordTimeStamp;
                        if (TextUtils.isEmpty(str4)) {
                            builder.setContentText(str3);
                        } else {
                            builder.setContentText(str4);
                            if (!TextUtils.isEmpty(str3)) {
                                builder.setContentTitle(str3);
                            }
                        }
                        Bitmap BuiltInFictitiousFunctionClassFactory = l.BuiltInFictitiousFunctionClassFactory(context, kVar);
                        if (BuiltInFictitiousFunctionClassFactory != null) {
                            builder.setLargeIcon(BuiltInFictitiousFunctionClassFactory);
                        }
                        builder.setShowWhen(true);
                        builder.setWhen(System.currentTimeMillis());
                        builder.setAutoCancel(kVar.SubSequence == 1);
                        builder.setOngoing(false);
                        builder.setTicker(kVar.getAuthRequestContext);
                        Intent authRequestContext = getAuthRequestContext(context, kVar, iArr, "1", SQLiteDatabase.CREATE_IF_NECESSARY);
                        if (getAuthRequestContext()) {
                            authRequestContext.setClass(context, TransActivity.class);
                            authRequestContext.setFlags(268468224);
                            broadcast = PendingIntent.getActivity(context, iArr[1], authRequestContext, q.KClassImpl$Data$declaredNonStaticMembers$2());
                        } else {
                            broadcast = PendingIntent.getBroadcast(context, iArr[1], authRequestContext, q.KClassImpl$Data$declaredNonStaticMembers$2());
                        }
                        builder.setContentIntent(broadcast);
                        Intent authRequestContext2 = getAuthRequestContext(context, kVar, iArr, "2", SQLiteDatabase.CREATE_IF_NECESSARY);
                        if (getAuthRequestContext()) {
                            authRequestContext2.setClass(context, TransActivity.class);
                            authRequestContext2.setFlags(268468224);
                            broadcast2 = PendingIntent.getActivity(context, iArr[2], authRequestContext2, q.KClassImpl$Data$declaredNonStaticMembers$2());
                        } else {
                            broadcast2 = PendingIntent.getBroadcast(context, iArr[2], authRequestContext2, q.KClassImpl$Data$declaredNonStaticMembers$2());
                        }
                        builder.setDeleteIntent(broadcast2);
                        if (Build.VERSION.SDK_INT >= 26) {
                            builder.setChannelId("HwPushChannelID");
                        }
                        if ("com.huawei.android.pushagent".equals(context.getPackageName())) {
                            Bundle bundle = new Bundle();
                            String str5 = kVar.GetContactSyncConfig;
                            if (!TextUtils.isEmpty(str5)) {
                                bundle.putString("hw_origin_sender_package_name", str5);
                                builder.setExtras(bundle);
                            }
                        }
                        if (HwBuildEx.VERSION.EMUI_SDK_INT >= 11 && q.PlaceComponentResult(context)) {
                            Bundle bundle2 = new Bundle();
                            String str6 = kVar.GetContactSyncConfig;
                            StringBuilder sb9 = new StringBuilder();
                            sb9.append("the package name of notification is:");
                            sb9.append(str6);
                            HMSLog.i("PushSelfShowLog", sb9.toString());
                            if (!TextUtils.isEmpty(str6)) {
                                String BuiltInFictitiousFunctionClassFactory2 = q.BuiltInFictitiousFunctionClassFactory(context, str6);
                                StringBuilder sb10 = new StringBuilder();
                                sb10.append("the app name is:");
                                sb10.append(BuiltInFictitiousFunctionClassFactory2);
                                HMSLog.i("PushSelfShowLog", sb10.toString());
                                if (BuiltInFictitiousFunctionClassFactory2 != null) {
                                    bundle2.putCharSequence("android.extraAppName", BuiltInFictitiousFunctionClassFactory2);
                                }
                            }
                            builder.setExtras(bundle2);
                        }
                        notification = builder.build();
                    }
                    NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                    if (notificationManager != null && notification != null) {
                        if (Build.VERSION.SDK_INT >= 26) {
                            notificationManager.createNotificationChannel(new NotificationChannel("HwPushChannelID", context.getString(ResourceLoaderUtil.getStringId("hms_push_channel")), 3));
                        }
                        notificationManager.notify(hashCode, notification);
                        StringBuilder sb11 = new StringBuilder();
                        sb11.append("setAutoClear time is: ");
                        sb11.append(kVar.scheduleImpl);
                        HMSLog.i("PushSelfShowLog", sb11.toString());
                        if (kVar.scheduleImpl > 0) {
                            Intent authRequestContext3 = getAuthRequestContext(context, kVar, iArr, "-1", 32);
                            long j = kVar.scheduleImpl;
                            int i3 = iArr[3];
                            try {
                                StringBuilder sb12 = new StringBuilder();
                                sb12.append("enter setDelayAlarm(interval:");
                                sb12.append(j);
                                sb12.append("ms.");
                                HMSLog.d("PushSelfShowLog", sb12.toString());
                                AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
                                if (alarmManager != null) {
                                    alarmManager.set(0, System.currentTimeMillis() + j, PendingIntent.getBroadcast(context, i3, authRequestContext3, q.KClassImpl$Data$declaredNonStaticMembers$2()));
                                }
                            } catch (Exception e) {
                                StringBuilder sb13 = new StringBuilder();
                                sb13.append("set DelayAlarm error.");
                                sb13.append(e.toString());
                                HMSLog.w("PushSelfShowLog", sb13.toString());
                            }
                        }
                        e.getAuthRequestContext(context, kVar.PlaceComponentResult(), kVar.getErrorConfigVersion, EncryptionProxyInvocationHandler.SUCCESS_RET_CODE);
                    }
                }
            }
        }
    }

    private static boolean getAuthRequestContext() {
        return Build.VERSION.SDK_INT >= 30;
    }

    private static Intent getAuthRequestContext(Context context, k kVar, int[] iArr, String str, int i) {
        Intent intent = new Intent("com.huawei.intent.action.PUSH_DELAY_NOTIFY");
        intent.putExtra("selfshow_info", kVar.MyBillsEntityDataFactory()).putExtra("selfshow_token", kVar.BuiltInFictitiousFunctionClassFactory()).putExtra("selfshow_event_id", str).putExtra("selfshow_notify_id", iArr[0]).putExtra("selfshow_auto_clear_id", iArr[3]).setPackage(context.getPackageName()).setFlags(i);
        return intent;
    }

    private static boolean MyBillsEntityDataFactory(k kVar) {
        return kVar == null || (TextUtils.isEmpty(kVar.NetworkUserEntityData$$ExternalSyntheticLambda7) && TextUtils.isEmpty(kVar.initRecordTimeStamp));
    }
}
