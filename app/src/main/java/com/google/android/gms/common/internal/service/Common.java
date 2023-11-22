package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.api.Api;

/* loaded from: classes7.dex */
public final class Common {
    public static final Api<Api.ApiOptions.NoOptions> API;
    public static final Api.ClientKey<zah> CLIENT_KEY;
    public static final zae zaa;
    private static final Api.AbstractClientBuilder<zah, Api.ApiOptions.NoOptions> zab;

    static {
        Api.ClientKey<zah> clientKey = new Api.ClientKey<>();
        CLIENT_KEY = clientKey;
        zab zabVar = new zab();
        zab = zabVar;
        API = new Api<>("Common.API", zabVar, clientKey);
        zaa = new zae();
    }
}
