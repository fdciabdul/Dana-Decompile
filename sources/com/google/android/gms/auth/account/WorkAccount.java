package com.google.android.gms.auth.account;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.auth.zzal;

/* loaded from: classes7.dex */
public class WorkAccount {
    public static final Api<Api.ApiOptions.NoOptions> API;
    @Deprecated
    public static final WorkAccountApi WorkAccountApi;
    private static final Api.ClientKey zza;
    private static final Api.AbstractClientBuilder zzb;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zza = clientKey;
        zzf zzfVar = new zzf();
        zzb = zzfVar;
        API = new Api<>("WorkAccount.API", zzfVar, clientKey);
        WorkAccountApi = new zzal();
    }

    private WorkAccount() {
    }

    public static WorkAccountClient getClient(Activity activity) {
        return new WorkAccountClient(activity);
    }

    public static WorkAccountClient getClient(Context context) {
        return new WorkAccountClient(context);
    }
}
