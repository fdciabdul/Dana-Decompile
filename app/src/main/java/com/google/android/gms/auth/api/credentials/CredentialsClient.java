package com.google.android.gms.auth.api.credentials;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.internal.p000authapi.zbn;
import com.google.android.gms.tasks.Task;

@Deprecated
/* loaded from: classes7.dex */
public class CredentialsClient extends GoogleApi<Auth.AuthCredentialsOptions> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public CredentialsClient(Activity activity, Auth.AuthCredentialsOptions authCredentialsOptions) {
        super(activity, Auth.CREDENTIALS_API, authCredentialsOptions, (StatusExceptionMapper) new ApiExceptionMapper());
    }

    @Deprecated
    public Task<Void> delete(Credential credential) {
        return PendingResultUtil.toVoidTask(Auth.CredentialsApi.delete(asGoogleApiClient(), credential));
    }

    @Deprecated
    public Task<Void> disableAutoSignIn() {
        return PendingResultUtil.toVoidTask(Auth.CredentialsApi.disableAutoSignIn(asGoogleApiClient()));
    }

    @Deprecated
    public PendingIntent getHintPickerIntent(HintRequest hintRequest) {
        return zbn.zba(getApplicationContext(), getApiOptions(), hintRequest, getApiOptions().zbd());
    }

    @Deprecated
    public Task<CredentialRequestResponse> request(CredentialRequest credentialRequest) {
        return PendingResultUtil.toResponseTask(Auth.CredentialsApi.request(asGoogleApiClient(), credentialRequest), new CredentialRequestResponse());
    }

    @Deprecated
    public Task<Void> save(Credential credential) {
        return PendingResultUtil.toVoidTask(Auth.CredentialsApi.save(asGoogleApiClient(), credential));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CredentialsClient(Context context, Auth.AuthCredentialsOptions authCredentialsOptions) {
        super(context, Auth.CREDENTIALS_API, authCredentialsOptions, new GoogleApi.Settings.Builder().setMapper(new ApiExceptionMapper()).build());
    }
}
