package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public abstract class zbl extends BaseImplementation.ApiMethodImpl {
    public zbl(GoogleApiClient googleApiClient) {
        super(Auth.GOOGLE_SIGN_IN_API, googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl, com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((zbl) ((Result) obj));
    }
}
