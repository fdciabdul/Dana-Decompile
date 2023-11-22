package id.dana.tracker;

import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class EventPropertiesModel {
    Object BuiltInFictitiousFunctionClassFactory;
    public JSONObject MyBillsEntityDataFactory = new JSONObject();

    public final void BuiltInFictitiousFunctionClassFactory(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            try {
                this.MyBillsEntityDataFactory.put(entry.getKey(), entry.getValue());
            } catch (JSONException e) {
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.MIXPANEL, "Unable to add properties to JSONObject", e);
            }
        }
    }
}
