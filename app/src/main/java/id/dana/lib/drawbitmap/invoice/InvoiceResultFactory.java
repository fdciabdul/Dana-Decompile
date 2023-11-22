package id.dana.lib.drawbitmap.invoice;

import com.alibaba.fastjson.JSONObject;
import id.dana.lib.drawbitmap.DrawBitmapResultType;

/* loaded from: classes2.dex */
public final class InvoiceResultFactory {
    private static final String ERROR = "error";
    private static final String SUCCESS = "success";
    private static final String URI = "uri";

    private InvoiceResultFactory() {
    }

    public static JSONObject getGeneralErrorResult() {
        return getGeneralError();
    }

    private static JSONObject getGeneralError() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", (Object) Boolean.FALSE);
        jSONObject.put("error", (Object) "001");
        return jSONObject;
    }

    public static JSONObject getErrorResult(String str) {
        str.hashCode();
        if (str.equals(DrawBitmapResultType.RUN_OUT_OF_STORAGE)) {
            return getRunOutOfStorageError();
        }
        if (str.equals(DrawBitmapResultType.OUT_OF_MEMORY)) {
            return getOutOfMemoryError();
        }
        return getGeneralError();
    }

    private static JSONObject getOutOfMemoryError() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", (Object) Boolean.FALSE);
        jSONObject.put("error", (Object) "002");
        return jSONObject;
    }

    private static JSONObject getRunOutOfStorageError() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", (Object) Boolean.FALSE);
        jSONObject.put("error", (Object) "003");
        return jSONObject;
    }

    public static JSONObject getSuccessResult(String str) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", (Object) Boolean.TRUE);
        jSONObject.put("uri", (Object) str);
        return jSONObject;
    }
}
