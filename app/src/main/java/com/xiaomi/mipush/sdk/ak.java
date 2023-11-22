package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class ak implements ServiceConnection {
    final /* synthetic */ ag getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ag agVar) {
        this.getAuthRequestContext = agVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        List<Message> list;
        List list2;
        Messenger messenger;
        synchronized (this.getAuthRequestContext) {
            this.getAuthRequestContext.scheduleImpl = new Messenger(iBinder);
            ag.MyBillsEntityDataFactory(this.getAuthRequestContext);
            list = this.getAuthRequestContext.initRecordTimeStamp;
            for (Message message : list) {
                try {
                    messenger = this.getAuthRequestContext.scheduleImpl;
                    messenger.send(message);
                } catch (RemoteException e) {
                    com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e);
                }
            }
            list2 = this.getAuthRequestContext.initRecordTimeStamp;
            list2.clear();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.getAuthRequestContext.scheduleImpl = null;
        ag.MyBillsEntityDataFactory(this.getAuthRequestContext);
    }
}
