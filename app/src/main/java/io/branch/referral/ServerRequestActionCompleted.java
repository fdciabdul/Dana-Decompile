package io.branch.referral;

import android.app.Activity;
import android.content.Context;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.branch.referral.BranchViewHandler;
import io.branch.referral.Defines;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ServerRequestActionCompleted extends ServerRequest {
    private final BranchViewHandler.IBranchViewEvents moveToNextValue;

    @Override // io.branch.referral.ServerRequest
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
    }

    @Override // io.branch.referral.ServerRequest
    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return false;
    }

    @Override // io.branch.referral.ServerRequest
    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda1() {
        return true;
    }

    @Override // io.branch.referral.ServerRequest
    public final void PlaceComponentResult(int i, String str) {
    }

    public ServerRequestActionCompleted(Context context, String str, JSONObject jSONObject) {
        super(context, Defines.RequestPath.CompletedAction.getPath());
        this.moveToNextValue = null;
        JSONObject jSONObject2 = new JSONObject();
        try {
            String key = Defines.Jsonkey.IdentityID.getKey();
            PrefHelper prefHelper = this.KClassImpl$Data$declaredNonStaticMembers$2;
            jSONObject2.put(key, PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_identity_id", "bnc_no_value"));
            String key2 = Defines.Jsonkey.DeviceFingerprintID.getKey();
            PrefHelper prefHelper2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            jSONObject2.put(key2, PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_device_fingerprint_id", "bnc_no_value"));
            String key3 = Defines.Jsonkey.SessionID.getKey();
            PrefHelper prefHelper3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            jSONObject2.put(key3, PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_session_id", "bnc_no_value"));
            PrefHelper prefHelper4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (!PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_link_click_id", "bnc_no_value").equals("bnc_no_value")) {
                String key4 = Defines.Jsonkey.LinkClickID.getKey();
                PrefHelper prefHelper5 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                jSONObject2.put(key4, PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_link_click_id", "bnc_no_value"));
            }
            jSONObject2.put(Defines.Jsonkey.Event.getKey(), str);
            jSONObject2.put(Defines.Jsonkey.Metadata.getKey(), jSONObject);
            getAuthRequestContext(jSONObject2);
            MyBillsEntityDataFactory(jSONObject2);
        } catch (JSONException unused) {
            this.MyBillsEntityDataFactory = true;
        }
        if (str == null || !str.equalsIgnoreCase(FirebaseAnalytics.Event.PURCHASE)) {
            return;
        }
        PrefHelper.MyBillsEntityDataFactory("Warning: You are sending a purchase event with our non-dedicated purchase function. Please see function sendCommerceEvent");
    }

    public ServerRequestActionCompleted(String str, JSONObject jSONObject, Context context) {
        super(str, jSONObject, context);
        this.moveToNextValue = null;
    }

    @Override // io.branch.referral.ServerRequest
    public final boolean getAuthRequestContext(Context context) {
        return !ServerRequest.PlaceComponentResult(context);
    }

    @Override // io.branch.referral.ServerRequest
    public final void getAuthRequestContext(ServerResponse serverResponse, Branch branch) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        Object obj = serverResponse.PlaceComponentResult;
        if (obj instanceof JSONObject) {
            jSONObject = (JSONObject) obj;
        } else {
            jSONObject = new JSONObject();
        }
        if (jSONObject != null) {
            Object obj2 = serverResponse.PlaceComponentResult;
            if (obj2 instanceof JSONObject) {
                jSONObject2 = (JSONObject) obj2;
            } else {
                jSONObject2 = new JSONObject();
            }
            if (!jSONObject2.has(Defines.Jsonkey.BranchViewData.getKey()) || Branch.BuiltInFictitiousFunctionClassFactory().KClassImpl$Data$declaredNonStaticMembers$2 == null || Branch.BuiltInFictitiousFunctionClassFactory().KClassImpl$Data$declaredNonStaticMembers$2.get() == null) {
                return;
            }
            String str = "";
            try {
                JSONObject jSONObject4 = this.PlaceComponentResult;
                if (jSONObject4 != null && jSONObject4.has(Defines.Jsonkey.Event.getKey())) {
                    str = jSONObject4.getString(Defines.Jsonkey.Event.getKey());
                }
                if (Branch.BuiltInFictitiousFunctionClassFactory().KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                    Activity activity = Branch.BuiltInFictitiousFunctionClassFactory().KClassImpl$Data$declaredNonStaticMembers$2.get();
                    Object obj3 = serverResponse.PlaceComponentResult;
                    if (obj3 instanceof JSONObject) {
                        jSONObject3 = (JSONObject) obj3;
                    } else {
                        jSONObject3 = new JSONObject();
                    }
                    BranchViewHandler.getAuthRequestContext().PlaceComponentResult(jSONObject3.getJSONObject(Defines.Jsonkey.BranchViewData.getKey()), str, activity, this.moveToNextValue);
                }
            } catch (JSONException unused) {
                BranchViewHandler.IBranchViewEvents iBranchViewEvents = this.moveToNextValue;
                if (iBranchViewEvents != null) {
                    iBranchViewEvents.getAuthRequestContext(str);
                }
            }
        }
    }
}
