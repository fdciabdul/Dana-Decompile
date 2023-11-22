package com.huawei.hms.opendevice;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Messenger;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes8.dex */
public class h {
    public Messenger MyBillsEntityDataFactory = null;
    public ServiceConnection getAuthRequestContext;

    public final boolean BuiltInFictitiousFunctionClassFactory(Context context, Bundle bundle, Intent intent) {
        Context applicationContext = context.getApplicationContext();
        this.getAuthRequestContext = new g(this, bundle, applicationContext);
        HMSLog.i("RemoteService", "remote service bind service start");
        return applicationContext.bindService(intent, this.getAuthRequestContext, 1);
    }
}
