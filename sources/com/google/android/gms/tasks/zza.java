package com.google.android.gms.tasks;

/* loaded from: classes7.dex */
final class zza implements OnSuccessListener {
    final /* synthetic */ OnTokenCanceledListener zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zza(zzb zzbVar, OnTokenCanceledListener onTokenCanceledListener) {
        this.zza = onTokenCanceledListener;
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final /* synthetic */ void onSuccess(Object obj) {
        Void r1 = (Void) obj;
        this.zza.onCanceled();
    }
}
