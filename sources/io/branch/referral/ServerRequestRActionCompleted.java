package io.branch.referral;

import android.app.Activity;
import android.content.Context;
import io.branch.referral.BranchViewHandler;
import io.branch.referral.Defines;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes9.dex */
class ServerRequestRActionCompleted extends ServerRequest {
    private final BranchViewHandler.IBranchViewEvents scheduleImpl;

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
                    BranchViewHandler.getAuthRequestContext().PlaceComponentResult(jSONObject3.getJSONObject(Defines.Jsonkey.BranchViewData.getKey()), str, activity, this.scheduleImpl);
                }
            } catch (JSONException unused) {
                BranchViewHandler.IBranchViewEvents iBranchViewEvents = this.scheduleImpl;
                if (iBranchViewEvents != null) {
                    iBranchViewEvents.getAuthRequestContext(str);
                }
            }
        }
    }
}
