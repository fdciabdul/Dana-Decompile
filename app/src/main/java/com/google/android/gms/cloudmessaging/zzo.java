package com.google.android.gms.cloudmessaging;

import android.os.Bundle;

/* loaded from: classes7.dex */
final class zzo extends zzp<Void> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzo(int i, int i2, Bundle bundle) {
        super(i, 2, bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.cloudmessaging.zzp
    public final void zza(Bundle bundle) {
        if (bundle.getBoolean("ack", false)) {
            zzd(null);
        } else {
            zzc(new zzq(4, "Invalid response to one way request", null));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.cloudmessaging.zzp
    public final boolean zzb() {
        return true;
    }
}
