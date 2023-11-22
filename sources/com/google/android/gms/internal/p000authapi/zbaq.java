package com.google.android.gms.internal.p000authapi;

import android.content.Intent;
import com.google.android.gms.auth.api.identity.AuthorizationClient;
import com.google.android.gms.auth.api.identity.AuthorizationRequest;
import com.google.android.gms.auth.api.identity.AuthorizationResult;
import com.google.android.gms.auth.api.identity.zbc;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes7.dex */
public final class zbaq extends GoogleApi implements AuthorizationClient {
    private static final Api.ClientKey zba;
    private static final Api.AbstractClientBuilder zbb;
    private static final Api zbc;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zba = clientKey;
        zbao zbaoVar = new zbao();
        zbb = zbaoVar;
        zbc = new Api("Auth.Api.Identity.Authorization.API", zbaoVar, clientKey);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public zbaq(android.app.Activity r3, com.google.android.gms.auth.api.identity.zbc r4) {
        /*
            r2 = this;
            com.google.android.gms.common.api.Api r0 = com.google.android.gms.internal.p000authapi.zbaq.zbc
            com.google.android.gms.auth.api.identity.zbb r4 = com.google.android.gms.auth.api.identity.zbb.zbc(r4)
            java.lang.String r1 = com.google.android.gms.internal.p000authapi.zbbj.zba()
            r4.zba(r1)
            com.google.android.gms.auth.api.identity.zbc r4 = r4.zbb()
            com.google.android.gms.common.api.GoogleApi$Settings r1 = com.google.android.gms.common.api.GoogleApi.Settings.DEFAULT_SETTINGS
            r2.<init>(r3, r0, r4, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p000authapi.zbaq.<init>(android.app.Activity, com.google.android.gms.auth.api.identity.zbc):void");
    }

    @Override // com.google.android.gms.auth.api.identity.AuthorizationClient
    public final Task<AuthorizationResult> authorize(AuthorizationRequest authorizationRequest) {
        Preconditions.checkNotNull(authorizationRequest);
        AuthorizationRequest.Builder zba2 = AuthorizationRequest.zba(authorizationRequest);
        zba2.zbb(((zbc) getApiOptions()).zbb());
        final AuthorizationRequest build = zba2.build();
        return doRead(TaskApiCall.builder().setFeatures(zbbi.zbc).run(new RemoteCall() { // from class: com.google.android.gms.internal.auth-api.zban
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zbaq zbaqVar = zbaq.this;
                AuthorizationRequest authorizationRequest2 = build;
                ((zbaa) ((zbw) obj).getService()).zbc(new zbap(zbaqVar, (TaskCompletionSource) obj2), (AuthorizationRequest) Preconditions.checkNotNull(authorizationRequest2));
            }
        }).setAutoResolveMissingFeatures(false).setMethodKey(1534).build());
    }

    @Override // com.google.android.gms.auth.api.identity.AuthorizationClient
    public final AuthorizationResult getAuthorizationResultFromIntent(Intent intent) throws ApiException {
        if (intent == null) {
            throw new ApiException(Status.RESULT_INTERNAL_ERROR);
        }
        Status status = (Status) SafeParcelableSerializer.deserializeFromIntentExtra(intent, "status", Status.CREATOR);
        if (status == null) {
            throw new ApiException(Status.RESULT_CANCELED);
        }
        if (!status.isSuccess()) {
            throw new ApiException(status);
        }
        AuthorizationResult authorizationResult = (AuthorizationResult) SafeParcelableSerializer.deserializeFromIntentExtra(intent, "authorization_result", AuthorizationResult.CREATOR);
        if (authorizationResult != null) {
            return authorizationResult;
        }
        throw new ApiException(Status.RESULT_INTERNAL_ERROR);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public zbaq(android.content.Context r3, com.google.android.gms.auth.api.identity.zbc r4) {
        /*
            r2 = this;
            com.google.android.gms.common.api.Api r0 = com.google.android.gms.internal.p000authapi.zbaq.zbc
            com.google.android.gms.auth.api.identity.zbb r4 = com.google.android.gms.auth.api.identity.zbb.zbc(r4)
            java.lang.String r1 = com.google.android.gms.internal.p000authapi.zbbj.zba()
            r4.zba(r1)
            com.google.android.gms.auth.api.identity.zbc r4 = r4.zbb()
            com.google.android.gms.common.api.GoogleApi$Settings r1 = com.google.android.gms.common.api.GoogleApi.Settings.DEFAULT_SETTINGS
            r2.<init>(r3, r0, r4, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p000authapi.zbaq.<init>(android.content.Context, com.google.android.gms.auth.api.identity.zbc):void");
    }
}
