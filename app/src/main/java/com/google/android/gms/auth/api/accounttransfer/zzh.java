package com.google.android.gms.auth.api.accounttransfer;

import android.os.RemoteException;
import com.alibaba.wireless.security.SecExceptionCode;
import com.google.android.gms.internal.auth.zzau;
import com.google.android.gms.internal.auth.zzbb;

/* loaded from: classes7.dex */
final class zzh extends zzn {
    final /* synthetic */ zzbb zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzh(AccountTransferClient accountTransferClient, int i, zzbb zzbbVar) {
        super(SecExceptionCode.SEC_ERROR_SAFETOKEN_INVALID_TOKEN_ENCRYPTED);
        this.zza = zzbbVar;
    }

    @Override // com.google.android.gms.auth.api.accounttransfer.zzl
    protected final void zza(zzau zzauVar) throws RemoteException {
        zzauVar.zze(this.zzc, this.zza);
    }
}
