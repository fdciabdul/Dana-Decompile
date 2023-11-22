package com.google.android.gms.location;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes7.dex */
final class zzau extends zzav {
    private final zzaf zza;

    public zzau(TaskCompletionSource taskCompletionSource, zzaf zzafVar, byte[] bArr) {
        super(taskCompletionSource);
        this.zza = zzafVar;
    }

    @Override // com.google.android.gms.location.zzav, com.google.android.gms.internal.location.zzai
    public final void zzc() {
        zzaf zzafVar = this.zza;
        FusedLocationProviderClient fusedLocationProviderClient = zzafVar.zza;
        zzaw zzawVar = zzafVar.zzb;
        ListenerHolder listenerHolder = zzafVar.zzc;
        zzawVar.zza(false);
        ListenerHolder.ListenerKey<?> listenerKey = listenerHolder.getListenerKey();
        if (listenerKey != null) {
            fusedLocationProviderClient.doUnregisterEventListener(listenerKey);
        }
    }
}
