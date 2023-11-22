package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.google.firebase.messaging.Constants;
import com.xiaomi.push.di;
import com.xiaomi.push.dx;
import java.util.List;

/* loaded from: classes8.dex */
public class PushMessageHelper {
    private static int MyBillsEntityDataFactory;

    public static MiPushCommandMessage BuiltInFictitiousFunctionClassFactory(String str, List<String> list, long j, String str2, String str3) {
        MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
        miPushCommandMessage.setCommand(str);
        miPushCommandMessage.setCommandArguments(list);
        miPushCommandMessage.setResultCode(j);
        miPushCommandMessage.setReason(str2);
        miPushCommandMessage.setCategory(str3);
        return miPushCommandMessage;
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(Context context) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setClassName(context.getPackageName(), "com.xiaomi.mipush.sdk.PushServiceReceiver");
        return MyBillsEntityDataFactory(context, intent);
    }

    public static MiPushMessage KClassImpl$Data$declaredNonStaticMembers$2(dx dxVar, di diVar, boolean z) {
        MiPushMessage miPushMessage = new MiPushMessage();
        miPushMessage.setMessageId(dxVar.m345a());
        if (!TextUtils.isEmpty(dxVar.d())) {
            miPushMessage.setMessageType(1);
            miPushMessage.setAlias(dxVar.d());
        } else if (!TextUtils.isEmpty(dxVar.c())) {
            miPushMessage.setMessageType(2);
            miPushMessage.setTopic(dxVar.c());
        } else if (TextUtils.isEmpty(dxVar.f())) {
            miPushMessage.setMessageType(0);
        } else {
            miPushMessage.setMessageType(3);
            miPushMessage.setUserAccount(dxVar.f());
        }
        miPushMessage.setCategory(dxVar.e());
        if (dxVar.a() != null) {
            miPushMessage.setContent(dxVar.a().c());
        }
        if (diVar != null) {
            if (TextUtils.isEmpty(miPushMessage.getMessageId())) {
                miPushMessage.setMessageId(diVar.m277a());
            }
            if (TextUtils.isEmpty(miPushMessage.getTopic())) {
                miPushMessage.setTopic(diVar.m282b());
            }
            miPushMessage.setDescription(diVar.d());
            miPushMessage.setTitle(diVar.m285c());
            miPushMessage.setNotifyType(diVar.a());
            miPushMessage.setNotifyId(diVar.c());
            miPushMessage.setPassThrough(diVar.b());
            miPushMessage.setExtra(diVar.m278a());
        }
        miPushMessage.setNotified(z);
        return miPushMessage;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(Context context, MiPushCommandMessage miPushCommandMessage) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setPackage(context.getPackageName());
        intent.putExtra(Constants.MessagePayloadKeys.MESSAGE_TYPE, 3);
        intent.putExtra("key_command", miPushCommandMessage);
        new PushServiceReceiver().onReceive(context, intent);
    }

    private static boolean MyBillsEntityDataFactory(Context context, Intent intent) {
        List<ResolveInfo> queryBroadcastReceivers;
        try {
            queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
        } catch (Exception unused) {
        }
        if (queryBroadcastReceivers != null) {
            if (!queryBroadcastReceivers.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public static int getAuthRequestContext(Context context) {
        if (MyBillsEntityDataFactory == 0) {
            MyBillsEntityDataFactory = BuiltInFictitiousFunctionClassFactory(context) ? 1 : 2;
        }
        return MyBillsEntityDataFactory;
    }
}
