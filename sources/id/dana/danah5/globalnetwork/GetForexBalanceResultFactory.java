package id.dana.danah5.globalnetwork;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import id.dana.danah5.globalnetwork.model.result.forexbalance.ResponseForex;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes8.dex */
public class GetForexBalanceResultFactory {

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    @interface ErrorCode {
        public static final String ERROR_CODE_NO_CONTENT_INFO = "002";
        public static final String ERROR_CODE_NO_MESSAGE = "003";
    }

    private GetForexBalanceResultFactory() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static JSONObject getResult(String str, ResponseForex responseForex) {
        char c;
        switch (str.hashCode()) {
            case -1149187101:
                if (str.equals("SUCCESS")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 532999017:
                if (str.equals("NO_MESSAGE")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1415358098:
                if (str.equals("NO_CONTENT_INFO")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1776037267:
                if (str.equals("UNKNOWN_ERROR")) {
                    c = 3;
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
                    return getForexBalanceResult(false, "003", responseForex);
                }
                return getForexBalanceResult(false, "001", responseForex);
            }
            return getForexBalanceResult(false, "002", responseForex);
        }
        return getForexBalanceResult(true, null, responseForex);
    }

    private static JSONObject getForexBalanceResult(boolean z, String str, ResponseForex responseForex) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", (Object) Boolean.valueOf(z));
        jSONObject.put("data", (Object) responseForex.getData());
        if (!TextUtils.isEmpty(str)) {
            jSONObject.put("error", (Object) str);
        }
        return jSONObject;
    }
}
