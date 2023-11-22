package com.google.android.gms.auth.api.accounttransfer;

import android.os.RemoteException;
import com.alibaba.wireless.security.SecExceptionCode;
import com.google.android.gms.internal.auth.zzau;
import com.google.android.gms.internal.auth.zzax;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zze extends zzl {
    final /* synthetic */ zzax zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zze(AccountTransferClient accountTransferClient, int i, zzax zzaxVar) {
        super(SecExceptionCode.SEC_ERROR_SAFETOKEN_LOW_VERISON_JPG, null);
        this.zza = zzaxVar;
    }

    @Override // com.google.android.gms.auth.api.accounttransfer.zzl
    protected final void zza(zzau zzauVar) throws RemoteException {
        zzauVar.zzg(new zzd(this, this), this.zza);
    }
}
