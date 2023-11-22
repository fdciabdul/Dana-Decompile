package com.huawei.hms.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes8.dex */
public class g implements ServiceConnection {
    public final /* synthetic */ Context BuiltInFictitiousFunctionClassFactory;
    public final /* synthetic */ h KClassImpl$Data$declaredNonStaticMembers$2;
    public final /* synthetic */ Bundle MyBillsEntityDataFactory;

    public g(h hVar, Bundle bundle, Context context) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = hVar;
        this.MyBillsEntityDataFactory = bundle;
        this.BuiltInFictitiousFunctionClassFactory = context;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ServiceConnection serviceConnection;
        Messenger messenger;
        HMSLog.i("RemoteService", "remote service onConnected");
        this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = new Messenger(iBinder);
        Message obtain = Message.obtain();
        obtain.setData(this.MyBillsEntityDataFactory);
        try {
            messenger = this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext;
            messenger.send(obtain);
        } catch (RemoteException unused) {
            HMSLog.i("RemoteService", "remote service message send failed");
        }
        HMSLog.i("RemoteService", "remote service unbindservice");
        Context context = this.BuiltInFictitiousFunctionClassFactory;
        serviceConnection = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory;
        context.unbindService(serviceConnection);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        HMSLog.i("RemoteService", "remote service onDisconnected");
        this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = null;
    }
}
