package id.dana.danah5.ocrreceipt;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes8.dex */
class OCRReceiptPluginResultFactory {
    private OCRReceiptPluginResultFactory() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONObject getSuccessResult(boolean z, String str, OCRSuccessResult oCRSuccessResult) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", (Object) Boolean.valueOf(z));
        jSONObject.put("error", (Object) str);
        jSONObject.put("data", JSON.toJSON(oCRSuccessResult));
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONObject getFailedResult(String str) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", (Object) Boolean.FALSE);
        jSONObject.put("error", (Object) str);
        jSONObject.put("data", JSON.toJSON(new OCRSuccessResult()));
        return jSONObject;
    }
}
