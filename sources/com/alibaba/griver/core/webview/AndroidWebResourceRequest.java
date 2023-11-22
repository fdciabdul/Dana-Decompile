package com.alibaba.griver.core.webview;

import android.net.Uri;
import android.webkit.WebResourceRequest;
import com.alibaba.griver.base.api.APWebResourceRequest;
import java.util.Map;

/* loaded from: classes6.dex */
public class AndroidWebResourceRequest implements APWebResourceRequest {

    /* renamed from: a  reason: collision with root package name */
    private WebResourceRequest f6487a;

    public AndroidWebResourceRequest(WebResourceRequest webResourceRequest) {
        this.f6487a = webResourceRequest;
    }

    @Override // com.alibaba.griver.base.api.APWebResourceRequest
    public String getMethod() {
        WebResourceRequest webResourceRequest = this.f6487a;
        if (webResourceRequest != null) {
            return webResourceRequest.getMethod();
        }
        return null;
    }

    @Override // com.alibaba.griver.base.api.APWebResourceRequest
    public Map<String, String> getRequestHeaders() {
        WebResourceRequest webResourceRequest = this.f6487a;
        if (webResourceRequest != null) {
            return webResourceRequest.getRequestHeaders();
        }
        return null;
    }

    @Override // com.alibaba.griver.base.api.APWebResourceRequest
    public Uri getUrl() {
        WebResourceRequest webResourceRequest = this.f6487a;
        if (webResourceRequest != null) {
            return webResourceRequest.getUrl();
        }
        return null;
    }

    @Override // com.alibaba.griver.base.api.APWebResourceRequest
    public boolean hasGesture() {
        WebResourceRequest webResourceRequest = this.f6487a;
        if (webResourceRequest != null) {
            return webResourceRequest.hasGesture();
        }
        return false;
    }

    @Override // com.alibaba.griver.base.api.APWebResourceRequest
    public boolean isForMainFrame() {
        WebResourceRequest webResourceRequest = this.f6487a;
        if (webResourceRequest != null) {
            return webResourceRequest.isForMainFrame();
        }
        return false;
    }
}
