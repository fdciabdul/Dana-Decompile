package com.alibaba.griver.biz.jsapi.scan;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.biz.WalletAPIUtils;
import com.alipay.iap.android.wallet.acl.WalletServiceManager;
import com.alipay.iap.android.wallet.acl.base.Callback;
import com.alipay.iap.android.wallet.foundation.code.CodeService;
import com.alipay.iap.android.wallet.foundation.code.CodeType;
import com.alipay.iap.android.wallet.foundation.code.ScannerOption;
import com.alipay.iap.android.wallet.foundation.code.ScannerResult;
import com.iap.ac.android.acs.plugin.interceptor.Interceptor4scan;

/* loaded from: classes2.dex */
public class ScanBridgeExtension extends SimpleBridgeExtension {
    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void scan(@BindingParam({"type"}) String str, @BindingNode(Page.class) Page page, @BindingCallback final BridgeCallback bridgeCallback) {
        final CodeType codeType;
        if (TextUtils.isEmpty(str)) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(2, "Please specify a type, either qr or bar"));
            return;
        }
        try {
            CodeService codeService = (CodeService) WalletServiceManager.getInstance().getService(CodeService.class);
            if (Interceptor4scan.TYPE_QR.equals(str)) {
                codeType = CodeType.QRCODE;
            } else if (Interceptor4scan.TYPE_BAR.equals(str)) {
                codeType = CodeType.BARCODE;
            } else {
                bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(2, "Unsupported type. Only qr and bar are supported"));
                return;
            }
            codeService.scan(new ScannerOption(codeType, false, null), WalletAPIUtils.createApiContext(page, "scan"), new Callback<ScannerResult>() { // from class: com.alibaba.griver.biz.jsapi.scan.ScanBridgeExtension.1
                @Override // com.alipay.iap.android.wallet.acl.base.Callback
                public void result(ScannerResult scannerResult) {
                    if (scannerResult == null) {
                        bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
                    } else if (scannerResult.isHasError()) {
                        if (scannerResult.getResultError().errorCode == 1001) {
                            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(10, "User cancellation"));
                        } else if (scannerResult.getResultError().errorCode == 1000) {
                            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(11, "Operation failure"));
                        }
                    } else {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", (Object) scannerResult.getCode());
                        jSONObject.put("qrCode", (Object) (codeType == CodeType.QRCODE ? scannerResult.getCode() : ""));
                        jSONObject.put("barCode", (Object) (codeType == CodeType.BARCODE ? scannerResult.getCode() : ""));
                        bridgeCallback.sendJSONResponse(jSONObject);
                    }
                }
            });
        } catch (WalletServiceManager.ServiceNotFoundException e) {
            RVLogger.e("ScanBridgeExtension", "com.alibaba.griver.biz.scan failed", e);
            bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
        }
    }
}
