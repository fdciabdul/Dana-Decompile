package id.dana.danah5.getonlineconfig;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes2.dex */
final class GetOnlineConfigResultFactory {
    private GetOnlineConfigResultFactory() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONObject handleError(String str) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", (Object) Boolean.FALSE);
        jSONObject.put("error", (Object) str);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONObject handleSuccess(String str) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", (Object) Boolean.TRUE);
        jSONObject.put("data", JSON.parse(str));
        return jSONObject;
    }
}
