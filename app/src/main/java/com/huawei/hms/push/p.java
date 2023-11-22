package com.huawei.hms.push;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes8.dex */
public class p extends Thread {
    public Context MyBillsEntityDataFactory;
    public k getAuthRequestContext;

    public p(Context context, k kVar) {
        this.MyBillsEntityDataFactory = context;
        this.getAuthRequestContext = kVar;
    }

    private boolean PlaceComponentResult(Context context) {
        if ("cosa".equals(this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda1)) {
            return KClassImpl$Data$declaredNonStaticMembers$2(context);
        }
        return true;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        HMSLog.i("PushSelfShowLog", "enter run()");
        try {
            if (!PlaceComponentResult(this.MyBillsEntityDataFactory) || BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory, this.getAuthRequestContext)) {
                return;
            }
            o.getAuthRequestContext(this.MyBillsEntityDataFactory, this.getAuthRequestContext);
        } catch (Exception e) {
            HMSLog.e("PushSelfShowLog", e.toString());
        }
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2(Context context) {
        return q.PlaceComponentResult(context, this.getAuthRequestContext.newProxyInstance);
    }

    private static Intent PlaceComponentResult(Context context, k kVar) {
        if (kVar == null) {
            return null;
        }
        Intent MyBillsEntityDataFactory = q.MyBillsEntityDataFactory(context, kVar.newProxyInstance);
        if (kVar.lookAheadTest != null) {
            try {
                Intent parseUri = Intent.parseUri(kVar.lookAheadTest, 0);
                parseUri.setSelector(null);
                StringBuilder sb = new StringBuilder();
                sb.append("Intent.parseUri(msg.intentUri, 0), action:");
                sb.append(parseUri.getAction());
                HMSLog.d("PushSelfShowLog", sb.toString());
                return q.MyBillsEntityDataFactory(context, kVar.newProxyInstance, parseUri).booleanValue() ? parseUri : MyBillsEntityDataFactory;
            } catch (Exception e) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("intentUri error,");
                sb2.append(e.toString());
                HMSLog.w("PushSelfShowLog", sb2.toString());
                return MyBillsEntityDataFactory;
            }
        }
        if (kVar.NetworkUserEntityData$$ExternalSyntheticLambda8 != null) {
            Intent intent = new Intent(kVar.NetworkUserEntityData$$ExternalSyntheticLambda8);
            if (q.MyBillsEntityDataFactory(context, kVar.newProxyInstance, intent).booleanValue()) {
                MyBillsEntityDataFactory = intent;
            }
        }
        MyBillsEntityDataFactory.setPackage(kVar.newProxyInstance);
        return MyBillsEntityDataFactory;
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(Context context, k kVar) {
        if ("cosa".equals(kVar.NetworkUserEntityData$$ExternalSyntheticLambda1) && PlaceComponentResult(context, kVar) == null) {
            HMSLog.d("PushSelfShowLog", "launchCosaApp,intent == null");
            return true;
        }
        return false;
    }
}
