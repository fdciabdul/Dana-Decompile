package com.huawei.hms.push;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Messenger;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes8.dex */
public class h {
    public ServiceConnection MyBillsEntityDataFactory;
    public Messenger getAuthRequestContext = null;

    public final boolean MyBillsEntityDataFactory(Context context, Bundle bundle, Intent intent) {
        Context applicationContext = context.getApplicationContext();
        this.MyBillsEntityDataFactory = new g(this, bundle, applicationContext);
        HMSLog.i("RemoteService", "remote service bind service start");
        return applicationContext.bindService(intent, this.MyBillsEntityDataFactory, 1);
    }
}
