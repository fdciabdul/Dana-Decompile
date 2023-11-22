package com.google.android.gms.auth.api.accounttransfer;

import android.os.RemoteException;
import com.alibaba.wireless.security.SecExceptionCode;
import com.google.android.gms.internal.auth.zzau;
import com.google.android.gms.internal.auth.zzaz;

/* loaded from: classes7.dex */
final class zzc extends zzn {
    final /* synthetic */ zzaz zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzc(AccountTransferClient accountTransferClient, int i, zzaz zzazVar) {
        super(SecExceptionCode.SEC_ERROR_SAFETOKEN_INVALID_TOKEN_FORMAT);
        this.zza = zzazVar;
    }

    @Override // com.google.android.gms.auth.api.accounttransfer.zzl
    protected final void zza(zzau zzauVar) throws RemoteException {
        zzauVar.zzh(this.zzc, this.zza);
    }
}
