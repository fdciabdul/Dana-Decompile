package com.mixpanel.android.mpmetrics;

import com.mixpanel.android.util.MPLog;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class SessionMetadata {
    private Random BuiltInFictitiousFunctionClassFactory;
    private String KClassImpl$Data$declaredNonStaticMembers$2;
    private long MyBillsEntityDataFactory;
    private long PlaceComponentResult;
    private long getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SessionMetadata() {
        getAuthRequestContext();
        this.BuiltInFictitiousFunctionClassFactory = new Random();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void getAuthRequestContext() {
        this.MyBillsEntityDataFactory = 0L;
        this.getAuthRequestContext = 0L;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = Long.toHexString(new Random().nextLong());
        this.PlaceComponentResult = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final JSONObject MyBillsEntityDataFactory(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("$mp_event_id", Long.toHexString(this.BuiltInFictitiousFunctionClassFactory.nextLong()));
            jSONObject.put("$mp_session_id", this.KClassImpl$Data$declaredNonStaticMembers$2);
            jSONObject.put("$mp_session_seq_id", z ? this.MyBillsEntityDataFactory : this.getAuthRequestContext);
            jSONObject.put("$mp_session_start_sec", this.PlaceComponentResult);
            if (z) {
                this.MyBillsEntityDataFactory++;
            } else {
                this.getAuthRequestContext++;
            }
        } catch (JSONException e) {
            MPLog.KClassImpl$Data$declaredNonStaticMembers$2(ConfigurationChecker.BuiltInFictitiousFunctionClassFactory, "Cannot create session metadata JSON object", e);
        }
        return jSONObject;
    }
}
