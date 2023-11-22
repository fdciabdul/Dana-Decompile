package id.dana.danah5.share.file.businessaccount;

import com.alibaba.fastjson.JSONObject;
import id.dana.danah5.share.file.ShareFileResultType;

/* loaded from: classes8.dex */
public class ShareBusinessAccountResultFactory {
    private ShareBusinessAccountResultFactory() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static JSONObject getResult(String str) {
        char c;
        switch (str.hashCode()) {
            case -1489822799:
                if (str.equals("GENERAL_ERROR")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1149187101:
                if (str.equals("SUCCESS")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -687460845:
                if (str.equals(ShareFileResultType.STORAGE_RUNNING_OUT_ERROR)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 29646139:
                if (str.equals("NO_APP_SUPPORTED_ERROR")) {
                    c = 1;
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
                    return getStorageRunningOutResult();
                }
                return getFailedShareResult();
            }
            return getNoAppSupportedResult();
        }
        return getSuccessShareResult();
    }

    private static JSONObject getSuccessShareResult() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", (Object) Boolean.TRUE);
        return jSONObject;
    }

    private static JSONObject getNoAppSupportedResult() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", (Object) Boolean.FALSE);
        jSONObject.put("error", (Object) "002");
        return jSONObject;
    }

    private static JSONObject getStorageRunningOutResult() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", (Object) Boolean.FALSE);
        jSONObject.put("error", (Object) "003");
        return jSONObject;
    }

    private static JSONObject getFailedShareResult() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", (Object) Boolean.FALSE);
        jSONObject.put("error", (Object) "001");
        return jSONObject;
    }
}
