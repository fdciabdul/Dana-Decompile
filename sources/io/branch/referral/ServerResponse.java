package io.branch.referral;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ServerResponse {
    int BuiltInFictitiousFunctionClassFactory;
    public Object PlaceComponentResult;
    private String getAuthRequestContext;

    public ServerResponse(String str, int i) {
        this.getAuthRequestContext = str;
        this.BuiltInFictitiousFunctionClassFactory = i;
    }

    public final String MyBillsEntityDataFactory() {
        JSONObject jSONObject;
        try {
            Object obj = this.PlaceComponentResult;
            if (obj instanceof JSONObject) {
                jSONObject = (JSONObject) obj;
            } else {
                jSONObject = new JSONObject();
            }
            if (jSONObject != null && jSONObject.has("error") && jSONObject.getJSONObject("error").has("message")) {
                String string = jSONObject.getJSONObject("error").getString("message");
                if (string == null || string.trim().length() <= 0) {
                    return string;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                sb.append(".");
                return sb.toString();
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }
}
