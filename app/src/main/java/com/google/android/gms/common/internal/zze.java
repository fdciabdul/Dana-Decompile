package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes3.dex */
public final class zze implements ServiceConnection {
    final /* synthetic */ BaseGmsClient zza;
    private final int zzb;

    public zze(BaseGmsClient baseGmsClient, int i) {
        this.zza = baseGmsClient;
        this.zzb = i;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Object obj;
        IGmsServiceBroker zzadVar;
        BaseGmsClient baseGmsClient = this.zza;
        if (iBinder == null) {
            BaseGmsClient.zzk(baseGmsClient, 16);
            return;
        }
        obj = baseGmsClient.zzq;
        synchronized (obj) {
            BaseGmsClient baseGmsClient2 = this.zza;
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IGmsServiceBroker)) {
                zzadVar = (IGmsServiceBroker) queryLocalInterface;
            } else {
                zzadVar = new zzad(iBinder);
            }
            baseGmsClient2.zzr = zzadVar;
        }
        this.zza.zzl(0, null, this.zzb);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        Object obj;
        obj = this.zza.zzq;
        synchronized (obj) {
            this.zza.zzr = null;
        }
        Handler handler = this.zza.zzb;
        handler.sendMessage(handler.obtainMessage(6, this.zzb, 1));
    }
}
