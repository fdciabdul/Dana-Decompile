package com.google.android.gms.auth.api.identity;

import android.content.Intent;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Task;

/* loaded from: classes3.dex */
public interface CredentialSavingClient extends HasApiKey<zbh> {
    Status getStatusFromIntent(Intent intent);

    Task<SaveAccountLinkingTokenResult> saveAccountLinkingToken(SaveAccountLinkingTokenRequest saveAccountLinkingTokenRequest);

    Task<SavePasswordResult> savePassword(SavePasswordRequest savePasswordRequest);
}
