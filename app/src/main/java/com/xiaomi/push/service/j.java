package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.xiaomi.push.service.az;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes8.dex */
public class j {
    v BuiltInFictitiousFunctionClassFactory = new v();

    public static void MyBillsEntityDataFactory(Context context, az.b bVar, String str, String str2) {
        if ("5".equalsIgnoreCase(bVar.newProxyInstance)) {
            com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2("mipush kicked by server");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.kicked");
        intent.setPackage(bVar.NetworkUserEntityData$$ExternalSyntheticLambda0);
        intent.putExtra("ext_kick_type", str);
        intent.putExtra("ext_kick_reason", str2);
        intent.putExtra("ext_chid", bVar.newProxyInstance);
        intent.putExtra(bd.getSupportButtonTintMode, bVar.DatabaseTableConfigUtil);
        intent.putExtra(bd.NetworkUserEntityData$$ExternalSyntheticLambda0, bVar.NetworkUserEntityData$$ExternalSyntheticLambda8);
        com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(String.format("[Bcst] notify packet(blob) arrival. %s,%s,%s", bVar.newProxyInstance, bVar.NetworkUserEntityData$$ExternalSyntheticLambda0, str2));
        PlaceComponentResult(context, intent, bVar);
    }

    public static void getAuthRequestContext(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.service_started");
        if (com.xiaomi.channel.commonutils.android.f.MyBillsEntityDataFactory()) {
            intent.addFlags(16777216);
        }
        com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("[Bcst] send ***.push.service_started broadcast to inform push service has started.");
        context.sendBroadcast(intent);
    }

    public static void getAuthRequestContext(Context context, az.b bVar, int i) {
        if ("5".equalsIgnoreCase(bVar.newProxyInstance)) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.channel_closed");
        intent.setPackage(bVar.NetworkUserEntityData$$ExternalSyntheticLambda0);
        intent.putExtra(bd.A, bVar.newProxyInstance);
        intent.putExtra("ext_reason", i);
        intent.putExtra(bd.getSupportButtonTintMode, bVar.DatabaseTableConfigUtil);
        intent.putExtra(bd.NetworkUserEntityData$$ExternalSyntheticLambda0, bVar.NetworkUserEntityData$$ExternalSyntheticLambda8);
        if (bVar.BuiltInFictitiousFunctionClassFactory == null || !PrepareException.ERROR_OFFLINE_APP.equals(bVar.newProxyInstance)) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(String.format("[Bcst] notify channel closed. %s,%s,%d", bVar.newProxyInstance, bVar.NetworkUserEntityData$$ExternalSyntheticLambda0, Integer.valueOf(i)));
            PlaceComponentResult(context, intent, bVar);
            return;
        }
        try {
            bVar.BuiltInFictitiousFunctionClassFactory.send(Message.obtain(null, 17, intent));
        } catch (RemoteException unused) {
            bVar.BuiltInFictitiousFunctionClassFactory = null;
            StringBuilder sb = new StringBuilder();
            sb.append("peer may died: ");
            sb.append(bVar.DatabaseTableConfigUtil.substring(bVar.DatabaseTableConfigUtil.lastIndexOf(64)));
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
        }
    }

    public final void PlaceComponentResult(Context context, az.b bVar, boolean z, int i, String str) {
        if ("5".equalsIgnoreCase(bVar.newProxyInstance)) {
            v.MyBillsEntityDataFactory(context, z, str);
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.channel_opened");
        intent.setPackage(bVar.NetworkUserEntityData$$ExternalSyntheticLambda0);
        intent.putExtra("ext_succeeded", z);
        if (!z) {
            intent.putExtra("ext_reason", i);
        }
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("ext_reason_msg", str);
        }
        intent.putExtra("ext_chid", bVar.newProxyInstance);
        intent.putExtra(bd.getSupportButtonTintMode, bVar.DatabaseTableConfigUtil);
        intent.putExtra(bd.NetworkUserEntityData$$ExternalSyntheticLambda0, bVar.NetworkUserEntityData$$ExternalSyntheticLambda8);
        com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(String.format("[Bcst] notify channel open result. %s,%s,%b,%d", bVar.newProxyInstance, bVar.NetworkUserEntityData$$ExternalSyntheticLambda0, Boolean.valueOf(z), Integer.valueOf(i)));
        PlaceComponentResult(context, intent, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void PlaceComponentResult(Context context, Intent intent, az.b bVar) {
        StringBuilder sb;
        String str;
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            context.sendBroadcast(intent);
            return;
        }
        if (PrepareException.ERROR_OFFLINE_APP.equals(bVar.newProxyInstance)) {
            sb = new StringBuilder();
            sb.append(bVar.NetworkUserEntityData$$ExternalSyntheticLambda0);
            str = ".permission.MIMC_RECEIVE";
        } else {
            sb = new StringBuilder();
            sb.append(bVar.NetworkUserEntityData$$ExternalSyntheticLambda0);
            str = ".permission.MIPUSH_RECEIVE";
        }
        sb.append(str);
        context.sendBroadcast(intent, sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static az.b MyBillsEntityDataFactory(com.xiaomi.push.bi biVar) {
        Collection<az.b> authRequestContext = az.BuiltInFictitiousFunctionClassFactory().getAuthRequestContext(Integer.toString(biVar.PlaceComponentResult.PlaceComponentResult));
        if (authRequestContext.isEmpty()) {
            return null;
        }
        Iterator<az.b> it = authRequestContext.iterator();
        if (authRequestContext.size() == 1) {
            return it.next();
        }
        String scheduleImpl = biVar.scheduleImpl();
        while (it.hasNext()) {
            az.b next = it.next();
            if (TextUtils.equals(scheduleImpl, next.DatabaseTableConfigUtil)) {
                return next;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static az.b PlaceComponentResult(com.xiaomi.push.cj cjVar) {
        Collection<az.b> authRequestContext = az.BuiltInFictitiousFunctionClassFactory().getAuthRequestContext(cjVar.NetworkUserEntityData$$ExternalSyntheticLambda3);
        if (authRequestContext.isEmpty()) {
            return null;
        }
        Iterator<az.b> it = authRequestContext.iterator();
        if (authRequestContext.size() == 1) {
            return it.next();
        }
        String str = cjVar.NetworkUserEntityData$$ExternalSyntheticLambda8;
        String str2 = cjVar.NetworkUserEntityData$$ExternalSyntheticLambda7;
        while (it.hasNext()) {
            az.b next = it.next();
            if (TextUtils.equals(str, next.DatabaseTableConfigUtil) || TextUtils.equals(str2, next.DatabaseTableConfigUtil)) {
                return next;
            }
        }
        return null;
    }
}
