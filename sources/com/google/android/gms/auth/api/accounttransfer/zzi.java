package com.google.android.gms.auth.api.accounttransfer;

import android.os.RemoteException;
import com.alibaba.wireless.security.SecExceptionCode;
import com.google.android.gms.internal.auth.zzau;
import com.google.android.gms.internal.auth.zzav;

/* loaded from: classes7.dex */
final class zzi extends zzn {
    final /* synthetic */ zzav zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzi(AccountTransferClient accountTransferClient, int i, zzav zzavVar) {
        super(SecExceptionCode.SEC_ERROR_SAFETOKEN_TOKEN_NOT_EXIST);
        this.zza = zzavVar;
    }

    @Override // com.google.android.gms.auth.api.accounttransfer.zzl
    protected final void zza(zzau zzauVar) throws RemoteException {
        zzauVar.zzf(this.zzc, this.zza);
    }
}
