package com.google.android.gms.auth.api;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.proxy.ProxyClient;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.auth.zzbo;
import com.google.android.gms.internal.auth.zzbt;

/* loaded from: classes7.dex */
public final class AuthProxy {
    public static final Api<AuthProxyOptions> API;
    public static final ProxyApi ProxyApi;
    public static final Api.ClientKey zza;
    private static final Api.AbstractClientBuilder zzb;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zza = clientKey;
        zza zzaVar = new zza();
        zzb = zzaVar;
        API = new Api<>("Auth.PROXY_API", zzaVar, clientKey);
        ProxyApi = new zzbt();
    }

    public static ProxyClient getClient(Activity activity, AuthProxyOptions authProxyOptions) {
        return new zzbo(activity, authProxyOptions);
    }

    public static ProxyClient getClient(Context context, AuthProxyOptions authProxyOptions) {
        return new zzbo(context, authProxyOptions);
    }
}
