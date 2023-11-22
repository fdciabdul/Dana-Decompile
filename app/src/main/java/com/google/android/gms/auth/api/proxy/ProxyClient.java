package com.google.android.gms.auth.api.proxy;

import com.google.android.gms.auth.api.AuthProxyOptions;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;

/* loaded from: classes7.dex */
public interface ProxyClient extends HasApiKey<AuthProxyOptions> {
    Task<String> getSpatulaHeader();

    Task<ProxyResponse> performProxyRequest(ProxyRequest proxyRequest);
}
