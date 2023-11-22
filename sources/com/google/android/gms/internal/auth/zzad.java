package com.google.android.gms.internal.auth;

import android.accounts.Account;
import com.google.android.gms.common.api.Status;

/* loaded from: classes7.dex */
final class zzad extends zzah {
    final /* synthetic */ zzae zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzad(zzae zzaeVar) {
        this.zza = zzaeVar;
    }

    @Override // com.google.android.gms.internal.auth.zzah, com.google.android.gms.auth.account.zzb
    public final void zzb(Account account) {
        this.zza.setResult((zzae) new zzai(account != null ? Status.RESULT_SUCCESS : zzal.zza, account));
    }
}
