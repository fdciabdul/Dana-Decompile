package com.google.android.gms.auth.api.accounttransfer;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import com.alibaba.wireless.security.SecExceptionCode;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.auth.zzaq;
import com.google.android.gms.internal.auth.zzav;
import com.google.android.gms.internal.auth.zzax;
import com.google.android.gms.internal.auth.zzaz;
import com.google.android.gms.internal.auth.zzbb;
import com.google.android.gms.tasks.Task;

/* loaded from: classes7.dex */
public class AccountTransferClient extends GoogleApi<zzr> {
    public static final /* synthetic */ int zza = 0;
    private static final Api.ClientKey zzb;
    private static final Api.AbstractClientBuilder zzc;
    private static final Api zzd;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zzb = clientKey;
        zzb zzbVar = new zzb();
        zzc = zzbVar;
        zzd = new Api("AccountTransfer.ACCOUNT_TRANSFER_API", zzbVar, clientKey);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AccountTransferClient(Activity activity, zzr zzrVar) {
        super(activity, (Api<zzr>) zzd, zzr.zza, new GoogleApi.Settings.Builder().setMapper(new ApiExceptionMapper()).build());
    }

    public Task<DeviceMetaData> getDeviceMetaData(String str) {
        Preconditions.checkNotNull(str);
        return doRead(new zzg(this, SecExceptionCode.SEC_ERROR_SAFETOKEN_STORAGE_NOT_EXIST, new zzaq(str)));
    }

    public Task<Void> notifyCompletion(String str, int i) {
        Preconditions.checkNotNull(str);
        return doWrite(new zzi(this, SecExceptionCode.SEC_ERROR_SAFETOKEN_TOKEN_NOT_EXIST, new zzav(str, i)));
    }

    public Task<byte[]> retrieveData(String str) {
        Preconditions.checkNotNull(str);
        return doRead(new zze(this, SecExceptionCode.SEC_ERROR_SAFETOKEN_LOW_VERISON_JPG, new zzax(str)));
    }

    public Task<Void> sendData(String str, byte[] bArr) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(bArr);
        return doWrite(new zzc(this, SecExceptionCode.SEC_ERROR_SAFETOKEN_INVALID_TOKEN_FORMAT, new zzaz(str, bArr)));
    }

    public Task<Void> showUserChallenge(String str, PendingIntent pendingIntent) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(pendingIntent);
        return doWrite(new zzh(this, SecExceptionCode.SEC_ERROR_SAFETOKEN_INVALID_TOKEN_ENCRYPTED, new zzbb(str, pendingIntent)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AccountTransferClient(Context context, zzr zzrVar) {
        super(context, zzd, zzr.zza, new GoogleApi.Settings.Builder().setMapper(new ApiExceptionMapper()).build());
    }
}
