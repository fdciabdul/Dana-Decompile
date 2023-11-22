package com.huawei.hms.opendevice;

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
    public final /* synthetic */ Bundle PlaceComponentResult;
    public final /* synthetic */ h getAuthRequestContext;

    public g(h hVar, Bundle bundle, Context context) {
        this.getAuthRequestContext = hVar;
        this.PlaceComponentResult = bundle;
        this.BuiltInFictitiousFunctionClassFactory = context;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ServiceConnection serviceConnection;
        Messenger messenger;
        HMSLog.i("RemoteService", "remote service onConnected");
        this.getAuthRequestContext.MyBillsEntityDataFactory = new Messenger(iBinder);
        Message obtain = Message.obtain();
        obtain.setData(this.PlaceComponentResult);
        try {
            messenger = this.getAuthRequestContext.MyBillsEntityDataFactory;
            messenger.send(obtain);
        } catch (RemoteException unused) {
            HMSLog.i("RemoteService", "remote service message send failed");
        }
        HMSLog.i("RemoteService", "remote service unbindservice");
        Context context = this.BuiltInFictitiousFunctionClassFactory;
        serviceConnection = this.getAuthRequestContext.getAuthRequestContext;
        context.unbindService(serviceConnection);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        HMSLog.i("RemoteService", "remote service onDisconnected");
        this.getAuthRequestContext.MyBillsEntityDataFactory = null;
    }
}
