package io.branch.referral;

import android.content.Context;
import io.branch.referral.Branch;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class ServerRequestGetRewards extends ServerRequest {
    Branch.BranchReferralStateChangedListener moveToNextValue;

    @Override // io.branch.referral.ServerRequest
    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return true;
    }

    public ServerRequestGetRewards(String str, JSONObject jSONObject, Context context) {
        super(str, jSONObject, context);
    }

    @Override // io.branch.referral.ServerRequest
    public final String MyBillsEntityDataFactory() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.MyBillsEntityDataFactory());
        PrefHelper prefHelper = this.KClassImpl$Data$declaredNonStaticMembers$2;
        sb.append(PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_identity_id", "bnc_no_value"));
        return sb.toString();
    }

    @Override // io.branch.referral.ServerRequest
    public final void PlaceComponentResult(int i, String str) {
        if (this.moveToNextValue != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Trouble retrieving user credits. ");
            sb.append(str);
            new BranchError(sb.toString(), i);
        }
    }

    @Override // io.branch.referral.ServerRequest
    public final boolean getAuthRequestContext(Context context) {
        if (ServerRequest.PlaceComponentResult(context)) {
            return false;
        }
        if (this.moveToNextValue != null) {
            new BranchError("Trouble retrieving user credits.", -102);
            return true;
        }
        return true;
    }

    @Override // io.branch.referral.ServerRequest
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.moveToNextValue = null;
    }

    @Override // io.branch.referral.ServerRequest
    public final void getAuthRequestContext(ServerResponse serverResponse, Branch branch) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        Object obj = serverResponse.PlaceComponentResult;
        if (obj instanceof JSONObject) {
            jSONObject = (JSONObject) obj;
        } else {
            jSONObject = new JSONObject();
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                Object obj2 = serverResponse.PlaceComponentResult;
                if (obj2 instanceof JSONObject) {
                    jSONObject2 = (JSONObject) obj2;
                } else {
                    jSONObject2 = new JSONObject();
                }
                int i = jSONObject2.getInt(next);
                PrefHelper prefHelper = this.KClassImpl$Data$declaredNonStaticMembers$2;
                PrefHelper.KClassImpl$Data$declaredNonStaticMembers$2(next);
                PrefHelper prefHelper2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                PrefHelper.getAuthRequestContext(next, i);
            } catch (JSONException unused) {
            }
        }
    }
}
