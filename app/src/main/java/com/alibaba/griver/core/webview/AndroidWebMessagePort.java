package com.alibaba.griver.core.webview;

import android.os.Handler;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import com.alibaba.griver.base.api.APWebMessagePort;
import com.alibaba.griver.base.nebula.APWebMessage;

/* loaded from: classes6.dex */
public class AndroidWebMessagePort extends APWebMessagePort {

    /* renamed from: a  reason: collision with root package name */
    private WebMessagePort f6486a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AndroidWebMessagePort(WebMessagePort webMessagePort) {
        this.f6486a = webMessagePort;
    }

    public WebMessagePort getWebMessagePort() {
        return this.f6486a;
    }

    @Override // com.alibaba.griver.base.api.APWebMessagePort
    public void postMessage(APWebMessage aPWebMessage) {
        this.f6486a.postMessage(new WebMessage(aPWebMessage.getData()));
    }

    @Override // com.alibaba.griver.base.api.APWebMessagePort
    public void close() {
        this.f6486a.close();
    }

    @Override // com.alibaba.griver.base.api.APWebMessagePort
    public void setWebMessageCallback(APWebMessagePort.APWebMessageCallback aPWebMessageCallback) {
        setWebMessageCallback(aPWebMessageCallback, null);
    }

    @Override // com.alibaba.griver.base.api.APWebMessagePort
    public void setWebMessageCallback(final APWebMessagePort.APWebMessageCallback aPWebMessageCallback, Handler handler) {
        this.f6486a.setWebMessageCallback(new WebMessagePort.WebMessageCallback() { // from class: com.alibaba.griver.core.webview.AndroidWebMessagePort.1
            @Override // android.webkit.WebMessagePort.WebMessageCallback
            public void onMessage(WebMessagePort webMessagePort, WebMessage webMessage) {
                aPWebMessageCallback.onMessage(new AndroidWebMessagePort(webMessagePort), new APWebMessage(webMessage.getData()));
            }
        }, handler);
    }
}
