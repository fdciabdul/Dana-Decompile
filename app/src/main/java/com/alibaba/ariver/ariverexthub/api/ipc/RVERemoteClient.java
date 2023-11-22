package com.alibaba.ariver.ariverexthub.api.ipc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.alibaba.ariver.ariverexthub.api.utils.ExtHubLogger;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes3.dex */
public class RVERemoteClient {

    /* renamed from: a  reason: collision with root package name */
    private Messenger f6006a;
    private final Context b;
    private ServiceConnection c = new ServiceConnection() { // from class: com.alibaba.ariver.ariverexthub.api.ipc.RVERemoteClient.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            StringBuilder sb = new StringBuilder();
            sb.append("ServiceConnection-->");
            sb.append(System.currentTimeMillis());
            InstrumentInjector.log_e("RVERemoteClient", sb.toString());
            RVERemoteClient.this.f6006a = new Messenger(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            InstrumentInjector.log_e("RVERemoteClient", "onServiceDisconnected-->binder died");
        }
    };

    public RVERemoteClient(Context context) {
        this.b = context;
    }

    public void bindRVERemoteService() {
        if (this.b != null) {
            this.b.bindService(new Intent(this.b, RVERemoteService.class), this.c, 1);
        }
    }

    public void unbindRVERemoteService() {
        Context context = this.b;
        if (context != null) {
            context.unbindService(this.c);
        }
    }

    public void sendMessageToServer(Bundle bundle) {
        if (this.f6006a != null) {
            Message obtain = Message.obtain((Handler) null, 1000);
            obtain.setData(bundle);
            try {
                this.f6006a.send(obtain);
            } catch (RemoteException e) {
                ExtHubLogger.e("RVERemoteClient", "remoteAPI failed", e);
            }
        }
    }
}
