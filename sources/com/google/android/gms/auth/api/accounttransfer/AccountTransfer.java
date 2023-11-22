package com.google.android.gms.auth.api.accounttransfer;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.auth.zzao;

/* loaded from: classes7.dex */
public final class AccountTransfer {
    public static final String ACTION_ACCOUNT_EXPORT_DATA_AVAILABLE = "com.google.android.gms.auth.ACCOUNT_EXPORT_DATA_AVAILABLE";
    public static final String ACTION_ACCOUNT_IMPORT_DATA_AVAILABLE = "com.google.android.gms.auth.ACCOUNT_IMPORT_DATA_AVAILABLE";
    public static final String ACTION_START_ACCOUNT_EXPORT = "com.google.android.gms.auth.START_ACCOUNT_EXPORT";
    public static final String KEY_EXTRA_ACCOUNT_TYPE = "key_extra_account_type";
    public static final Api zza;
    @Deprecated
    public static final zzao zzb;
    @Deprecated
    public static final zzao zzc;
    private static final Api.ClientKey zzd;
    private static final Api.AbstractClientBuilder zze;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zzd = clientKey;
        zza zzaVar = new zza();
        zze = zzaVar;
        zza = new Api("AccountTransfer.ACCOUNT_TRANSFER_API", zzaVar, clientKey);
        zzb = new zzao();
        zzc = new zzao();
    }

    private AccountTransfer() {
    }

    public static AccountTransferClient getAccountTransferClient(Activity activity) {
        return new AccountTransferClient(activity, (zzr) null);
    }

    public static AccountTransferClient getAccountTransferClient(Context context) {
        return new AccountTransferClient(context, (zzr) null);
    }
}
