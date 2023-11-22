package com.google.android.gms.auth.api.accounttransfer;

import android.os.RemoteException;
import com.alibaba.wireless.security.SecExceptionCode;
import com.google.android.gms.internal.auth.zzaq;
import com.google.android.gms.internal.auth.zzau;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzg extends zzl {
    final /* synthetic */ zzaq zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzg(AccountTransferClient accountTransferClient, int i, zzaq zzaqVar) {
        super(SecExceptionCode.SEC_ERROR_SAFETOKEN_STORAGE_NOT_EXIST, null);
        this.zza = zzaqVar;
    }

    @Override // com.google.android.gms.auth.api.accounttransfer.zzl
    protected final void zza(zzau zzauVar) throws RemoteException {
        zzauVar.zzd(new zzf(this, this), this.zza);
    }
}
