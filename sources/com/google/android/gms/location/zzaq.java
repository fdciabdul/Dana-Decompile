package com.google.android.gms.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzaq extends zzaw {
    final /* synthetic */ ListenerHolder zza;
    final /* synthetic */ FusedLocationProviderClient zzb;

    public zzaq(FusedLocationProviderClient fusedLocationProviderClient, ListenerHolder listenerHolder) {
        this.zzb = fusedLocationProviderClient;
        this.zza = listenerHolder;
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
        com.google.android.gms.internal.location.zzbe zzbeVar = (com.google.android.gms.internal.location.zzbe) obj;
        TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
        if (zzb()) {
            zzar zzarVar = new zzar(this.zzb, taskCompletionSource);
            ListenerHolder.ListenerKey listenerKey = this.zza.getListenerKey();
            if (listenerKey != null) {
                zzbeVar.zzy(listenerKey, zzarVar);
            }
        }
    }
}
