package id.dana.danah5.share.file.generic;

import com.alibaba.fastjson.JSONObject;
import id.dana.danah5.share.file.ShareFileResultType;
import javax.annotation.Nullable;

/* loaded from: classes8.dex */
public class ShareFileResultFactory {
    private ShareFileResultFactory() {
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
        return getJSONResult(true, null);
    }

    private static JSONObject getNoAppSupportedResult() {
        return getJSONResult(false, "002");
    }

    private static JSONObject getStorageRunningOutResult() {
        return getJSONResult(false, "003");
    }

    private static JSONObject getFailedShareResult() {
        return getJSONResult(false, "001");
    }

    private static JSONObject getJSONResult(boolean z, @Nullable String str) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", (Object) Boolean.valueOf(z));
        if (str != null) {
            jSONObject.put("error", (Object) str);
        }
        return jSONObject;
    }
}
