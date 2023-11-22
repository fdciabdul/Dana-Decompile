package id.dana.danah5.screenshot;

import com.alibaba.fastjson.JSONObject;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes2.dex */
public class ScreenshotPluginResultFactory {

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    @interface ErrorCode {
        public static final String LOW_STORAGE = "004";
        public static final String NO_ACCESS = "002";
        public static final String SAVE_FAIL = "003";
        public static final String SUCCESS = "001";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static JSONObject getResult(String str) {
        char c;
        switch (str.hashCode()) {
            case 47665:
                if (str.equals("001")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 47666:
                if (str.equals("002")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 47667:
                if (str.equals("003")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 47668:
                if (str.equals("004")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c != 0) {
            if (c != 1) {
                if (c == 2) {
                    return getLowStorageResult();
                }
                return getFailedSaveResult();
            }
            return getNoAccessResult();
        }
        return getSuccessResult();
    }

    private static JSONObject getSuccessResult() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", (Object) Boolean.TRUE);
        jSONObject.put("error", (Object) "001");
        return jSONObject;
    }

    private static JSONObject getNoAccessResult() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", (Object) Boolean.FALSE);
        jSONObject.put("error", (Object) "002");
        return jSONObject;
    }

    private static JSONObject getLowStorageResult() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", (Object) Boolean.FALSE);
        jSONObject.put("error", (Object) "004");
        return jSONObject;
    }

    private static JSONObject getFailedSaveResult() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", (Object) Boolean.FALSE);
        jSONObject.put("error", (Object) "003");
        return jSONObject;
    }
}
