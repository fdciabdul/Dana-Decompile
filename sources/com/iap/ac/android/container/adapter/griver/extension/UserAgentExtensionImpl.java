package com.iap.ac.android.container.adapter.griver.extension;

import com.alibaba.griver.api.common.webview.GriverUserAgentExtension;
import com.iap.ac.android.common.container.provider.ContainerUaProvider;

/* loaded from: classes3.dex */
public class UserAgentExtensionImpl implements GriverUserAgentExtension {

    /* renamed from: a  reason: collision with root package name */
    private ContainerUaProvider f7563a;

    public UserAgentExtensionImpl(ContainerUaProvider containerUaProvider) {
        this.f7563a = containerUaProvider;
    }

    @Override // com.alibaba.griver.api.common.webview.GriverUserAgentExtension
    public String getUserAgent() {
        ContainerUaProvider containerUaProvider = this.f7563a;
        return containerUaProvider != null ? containerUaProvider.getUa("") : "";
    }
}
