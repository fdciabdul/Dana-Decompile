package com.iap.ac.android.container.js;

import android.webkit.WebView;
import com.iap.ac.android.common.container.js.ContainerBridgeContext;
import com.iap.ac.android.common.log.ACLog;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ACBridgeContext extends ContainerBridgeContext {
    private static final String TAG = "ACBridgeContext";
    private String bizCode;
    private WebView mWebview;

    public ACBridgeContext(WebView webView, String str) {
        this.mWebview = webView;
        this.bizCode = str;
    }

    @Override // com.iap.ac.android.common.container.js.ContainerBridgeContext
    public boolean sendBridgeResult(JSONObject jSONObject) {
        try {
            ACJSBridge.getInstance(this.bizCode).sendBack(getToNativeMsg(), this.mWebview, jSONObject);
            return true;
        } catch (Exception e) {
            ACLog.e(TAG, "sendBridgeResult error", e);
            return false;
        }
    }

    @Override // com.iap.ac.android.common.container.js.ContainerBridgeContext
    public boolean sendBridgeResult(String str, Object obj) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(str, obj);
            return sendBridgeResult(jSONObject);
        } catch (Exception e) {
            ACLog.e(TAG, "sendBridgeResult error", e);
            return false;
        }
    }
}
