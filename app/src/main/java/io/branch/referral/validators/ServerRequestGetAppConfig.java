package io.branch.referral.validators;

import android.content.Context;
import io.branch.referral.Branch;
import io.branch.referral.Defines;
import io.branch.referral.PrefHelper;
import io.branch.referral.ServerRequest;
import io.branch.referral.ServerResponse;
import org.json.JSONObject;

/* loaded from: classes9.dex */
class ServerRequestGetAppConfig extends ServerRequest {
    private final IGetAppConfigEvents moveToNextValue;

    /* loaded from: classes9.dex */
    public interface IGetAppConfigEvents {
        void BuiltInFictitiousFunctionClassFactory(JSONObject jSONObject);
    }

    @Override // io.branch.referral.ServerRequest
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
    }

    @Override // io.branch.referral.ServerRequest
    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return true;
    }

    @Override // io.branch.referral.ServerRequest
    public final boolean getAuthRequestContext(Context context) {
        return false;
    }

    @Override // io.branch.referral.ServerRequest
    public final void getAuthRequestContext(ServerResponse serverResponse, Branch branch) {
        JSONObject jSONObject;
        IGetAppConfigEvents iGetAppConfigEvents = this.moveToNextValue;
        if (iGetAppConfigEvents != null) {
            Object obj = serverResponse.PlaceComponentResult;
            if (obj instanceof JSONObject) {
                jSONObject = (JSONObject) obj;
            } else {
                jSONObject = new JSONObject();
            }
            iGetAppConfigEvents.BuiltInFictitiousFunctionClassFactory(jSONObject);
        }
    }

    @Override // io.branch.referral.ServerRequest
    public final void PlaceComponentResult(int i, String str) {
        IGetAppConfigEvents iGetAppConfigEvents = this.moveToNextValue;
        if (iGetAppConfigEvents != null) {
            iGetAppConfigEvents.BuiltInFictitiousFunctionClassFactory(null);
        }
    }

    @Override // io.branch.referral.ServerRequest
    public final String MyBillsEntityDataFactory() {
        StringBuilder sb = new StringBuilder();
        PrefHelper prefHelper = this.KClassImpl$Data$declaredNonStaticMembers$2;
        sb.append(PrefHelper.getAuthRequestContext());
        sb.append(Defines.RequestPath.GetApp.getPath());
        sb.append("/");
        PrefHelper prefHelper2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (PrefHelper.getAuthRequestContext == null) {
            PrefHelper.getAuthRequestContext = PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_branch_key", "bnc_no_value");
        }
        sb.append(PrefHelper.getAuthRequestContext);
        return sb.toString();
    }
}
