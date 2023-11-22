package com.xiaomi.push.service;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class bm implements ServiceConnection {
    final /* synthetic */ ServiceClient getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(ServiceClient serviceClient) {
        this.getAuthRequestContext = serviceClient;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        List<Message> list;
        List list2;
        Messenger messenger;
        synchronized (this.getAuthRequestContext) {
            this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0 = new Messenger(iBinder);
            ServiceClient.PlaceComponentResult(this.getAuthRequestContext);
            list = this.getAuthRequestContext.scheduleImpl;
            for (Message message : list) {
                try {
                    messenger = this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    messenger.send(message);
                } catch (RemoteException e) {
                    com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e);
                }
            }
            list2 = this.getAuthRequestContext.scheduleImpl;
            list2.clear();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
        ServiceClient.PlaceComponentResult(this.getAuthRequestContext);
    }
}
