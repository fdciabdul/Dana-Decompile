package com.iap.ac.android.acs.plugin.interceptor;

import com.iap.ac.android.acs.plugin.a.a;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginCallback;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginContext;
import com.iap.ac.android.acs.plugin.utils.CallbackUtil;
import com.iap.ac.android.acs.plugin.utils.MonitorUtil;
import com.iap.ac.android.biz.common.model.ScanCallback;
import com.iap.ac.android.biz.common.model.ScanErrorCode;
import com.iap.ac.android.biz.common.model.ScanType;
import com.iap.ac.android.biz.common.model.ScannerOption;
import com.iap.ac.android.biz.common.spi.SPIManager;
import com.iap.ac.android.common.log.ACLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class Interceptor4scan extends BaseInterceptor {
    public static final String ERROR_CODE_OPERATION_FAIL = "11";
    public static final String ERROR_CODE_USER_CANCEL = "10";
    public static final String PARAM_HIDE_ALBUM = "hideAlbum";
    public static final String PARAM_TYPE = "type";
    public static final String TAG = "IAPConnectPlugin";
    public static final String TYPE_BAR = "bar";
    public static final String TYPE_QR = "qr";

    private void scan(ScannerOption scannerOption, final String str, final IAPConnectPluginCallback iAPConnectPluginCallback) {
        StringBuilder a2 = a.a("Interceptor4scan#scan, hideAlbum: ");
        a2.append(scannerOption.hideAlbum);
        a2.append(", type: ");
        a2.append(str);
        ACLog.d("IAPConnectPlugin", a2.toString());
        SPIManager.getInstance().scan(scannerOption, new ScanCallback() { // from class: com.iap.ac.android.acs.plugin.interceptor.Interceptor4scan.1
            @Override // com.iap.ac.android.biz.common.model.ScanCallback
            public void onFailure(ScanErrorCode scanErrorCode, String str2) {
                String str3;
                StringBuilder sb = new StringBuilder();
                sb.append("Interceptor4scan#scan, errorCode: ");
                sb.append(scanErrorCode);
                sb.append(", errorMessage: ");
                sb.append(str2);
                ACLog.e("IAPConnectPlugin", sb.toString());
                if (scanErrorCode == ScanErrorCode.USER_CANCEL) {
                    str3 = "10";
                } else {
                    ScanErrorCode scanErrorCode2 = ScanErrorCode.OPERATION_FAIL;
                    str3 = "11";
                }
                iAPConnectPluginCallback.onResult(CallbackUtil.getError("scan", str3, str2));
            }

            @Override // com.iap.ac.android.biz.common.model.ScanCallback
            public void onSuccess(String str2) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", str2);
                    if (Interceptor4scan.TYPE_QR.equals(str)) {
                        jSONObject.put("qrCode", str2);
                    } else if (Interceptor4scan.TYPE_BAR.equals(str)) {
                        jSONObject.put("barCode", str2);
                    }
                    iAPConnectPluginCallback.onResult(jSONObject);
                } catch (JSONException e) {
                    ACLog.e("IAPConnectPlugin", "Interceptor4scan#scan, convert result to JSON error");
                    MonitorUtil.monitorJSONError("scan", e);
                }
            }
        });
    }

    @Override // com.iap.ac.android.acs.plugin.interceptor.BaseInterceptor
    public void handle(IAPConnectPluginContext iAPConnectPluginContext, IAPConnectPluginCallback iAPConnectPluginCallback) {
        JSONObject jSONObject = iAPConnectPluginContext.jsParameters;
        if (jSONObject == null) {
            a.a("IAPConnectPlugin", "Interceptor4scan#handle, jsParameters is null", "scan", "parameter is null", iAPConnectPluginCallback);
            return;
        }
        ScannerOption scannerOption = new ScannerOption();
        scannerOption.hideAlbum = jSONObject.optBoolean(PARAM_HIDE_ALBUM);
        String optString = jSONObject.optString("type");
        if (!TYPE_QR.equals(optString) && TYPE_BAR.equals(optString)) {
            scannerOption.type = ScanType.BAR;
        } else {
            scannerOption.type = ScanType.QR;
        }
        scan(scannerOption, optString, iAPConnectPluginCallback);
    }
}
