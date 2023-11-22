package com.google.android.gms.auth.api.identity;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p000authapi.zbaq;
import com.google.android.gms.internal.p000authapi.zbaw;
import com.google.android.gms.internal.p000authapi.zbbg;

/* loaded from: classes3.dex */
public final class Identity {
    private Identity() {
    }

    public static AuthorizationClient getAuthorizationClient(Activity activity) {
        return new zbaq((Activity) Preconditions.checkNotNull(activity), new zbb(null).zbb());
    }

    public static CredentialSavingClient getCredentialSavingClient(Activity activity) {
        return new zbaw((Activity) Preconditions.checkNotNull(activity), new zbh());
    }

    public static SignInClient getSignInClient(Activity activity) {
        return new zbbg((Activity) Preconditions.checkNotNull(activity), new zbu());
    }

    public static AuthorizationClient getAuthorizationClient(Context context) {
        return new zbaq((Context) Preconditions.checkNotNull(context), new zbb(null).zbb());
    }

    public static CredentialSavingClient getCredentialSavingClient(Context context) {
        return new zbaw((Context) Preconditions.checkNotNull(context), new zbh());
    }

    public static SignInClient getSignInClient(Context context) {
        return new zbbg((Context) Preconditions.checkNotNull(context), new zbu());
    }
}
