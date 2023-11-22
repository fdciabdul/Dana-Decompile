package io.branch.indexing;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import id.dana.data.constant.BranchLinkConstant;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ContentDiscoveryManifest {
    private static ContentDiscoveryManifest moveToNextValue;
    public String KClassImpl$Data$declaredNonStaticMembers$2;
    public JSONArray PlaceComponentResult;
    public JSONObject getAuthRequestContext;
    public SharedPreferences lookAheadTest;
    public int scheduleImpl = 0;
    public int getErrorConfigVersion = 1;
    public int MyBillsEntityDataFactory = 0;
    public boolean BuiltInFictitiousFunctionClassFactory = false;
    private final String NetworkUserEntityData$$ExternalSyntheticLambda0 = "BNC_CD_MANIFEST";

    private ContentDiscoveryManifest(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("bnc_content_discovery_manifest_storage", 0);
        this.lookAheadTest = sharedPreferences;
        String string = sharedPreferences.getString("BNC_CD_MANIFEST", null);
        if (string != null) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                this.getAuthRequestContext = jSONObject;
                if (jSONObject.has("mv")) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = this.getAuthRequestContext.getString("mv");
                }
                if (this.getAuthRequestContext.has("m")) {
                    this.PlaceComponentResult = this.getAuthRequestContext.getJSONArray("m");
                    return;
                }
                return;
            } catch (JSONException unused) {
                this.getAuthRequestContext = new JSONObject();
                return;
            }
        }
        this.getAuthRequestContext = new JSONObject();
    }

    public static ContentDiscoveryManifest getAuthRequestContext(Context context) {
        if (moveToNextValue == null) {
            moveToNextValue = new ContentDiscoveryManifest(context);
        }
        return moveToNextValue;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final CDPathProperties BuiltInFictitiousFunctionClassFactory(Activity activity) {
        if (this.PlaceComponentResult != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("/");
            sb.append(activity.getClass().getSimpleName());
            String obj = sb.toString();
            for (int i = 0; i < this.PlaceComponentResult.length(); i++) {
                try {
                    JSONObject jSONObject = this.PlaceComponentResult.getJSONObject(i);
                    if (jSONObject.has(BranchLinkConstant.PayloadKey.PROMO_CODE) && jSONObject.getString(BranchLinkConstant.PayloadKey.PROMO_CODE).equals(obj)) {
                        return new CDPathProperties(jSONObject);
                    }
                } catch (JSONException unused) {
                    return null;
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean MyBillsEntityDataFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    /* loaded from: classes2.dex */
    class CDPathProperties {
        int BuiltInFictitiousFunctionClassFactory;
        final JSONObject MyBillsEntityDataFactory;
        int PlaceComponentResult;
        private boolean getAuthRequestContext;

        CDPathProperties(JSONObject jSONObject) {
            this.MyBillsEntityDataFactory = jSONObject;
            this.PlaceComponentResult = 15;
            if (jSONObject.has("h")) {
                try {
                    this.getAuthRequestContext = !jSONObject.getBoolean("h");
                } catch (JSONException unused) {
                }
            }
            try {
                if (jSONObject.has("dri")) {
                    this.BuiltInFictitiousFunctionClassFactory = jSONObject.getInt("dri");
                }
                if (jSONObject.has("mdr")) {
                    this.PlaceComponentResult = jSONObject.getInt("mdr");
                }
            } catch (JSONException unused2) {
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final JSONArray getAuthRequestContext() {
            if (this.MyBillsEntityDataFactory.has("ck")) {
                try {
                    return this.MyBillsEntityDataFactory.getJSONArray("ck");
                } catch (JSONException unused) {
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.getAuthRequestContext;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final boolean BuiltInFictitiousFunctionClassFactory() {
            JSONArray authRequestContext = getAuthRequestContext();
            return authRequestContext != null && authRequestContext.length() == 0;
        }
    }
}
