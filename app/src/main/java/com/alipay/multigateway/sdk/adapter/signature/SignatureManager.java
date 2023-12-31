package com.alipay.multigateway.sdk.adapter.signature;

import android.text.TextUtils;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.multigateway.sdk.GatewayInfo;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class SignatureManager {
    private static final String TAG = "SignatureManager";
    private HashMap<String, SignatureHandler> signatureHandlerMap = new HashMap<>();

    public void addSignatureHandler(String str, SignatureHandler signatureHandler) {
        this.signatureHandlerMap.put(str, signatureHandler);
    }

    public String signRequest(String str, GatewayInfo.SignInfo signInfo) {
        SignatureHandler signatureHandler = this.signatureHandlerMap.get(signInfo.type);
        if (signatureHandler == null) {
            return null;
        }
        try {
            return signatureHandler.signRequest(str, signInfo);
        } catch (Exception e) {
            LoggerWrapper.e(TAG, "invoke signatureHandler signRequest occurs error.", e);
            return null;
        }
    }

    public void setSignatureToGatewayInfo(String str, GatewayInfo gatewayInfo) {
        if (gatewayInfo == null || gatewayInfo.headers == null) {
            return;
        }
        String str2 = gatewayInfo.signInfo != null ? gatewayInfo.signInfo.headerName : null;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        gatewayInfo.headers.put(str2, str);
    }
}
