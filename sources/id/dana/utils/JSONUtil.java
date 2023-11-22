package id.dana.utils;

import android.os.Bundle;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class JSONUtil {
    private JSONUtil() {
    }

    public static Map<String, Object> getAuthRequestContext(JSONObject jSONObject) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                linkedHashMap.put(next, jSONObject.get(next));
            }
        } catch (JSONException e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.JSONUTIL_TAG, "Unable to get object from JSONObject", e);
        }
        return linkedHashMap;
    }

    public static Bundle KClassImpl$Data$declaredNonStaticMembers$2(JSONObject jSONObject) {
        Bundle bundle = new Bundle();
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                bundle.putString(next, String.valueOf(jSONObject.get(next)));
            }
        } catch (JSONException e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.JSONUTIL_TAG, "Unable to get object from JSONObject", e);
        }
        return bundle;
    }
}
