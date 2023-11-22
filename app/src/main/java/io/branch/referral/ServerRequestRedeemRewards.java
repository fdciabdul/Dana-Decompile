package io.branch.referral;

import android.content.Context;
import io.branch.referral.Branch;
import io.branch.referral.Defines;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class ServerRequestRedeemRewards extends ServerRequest {
    Branch.BranchReferralStateChangedListener getErrorConfigVersion;
    int scheduleImpl;

    @Override // io.branch.referral.ServerRequest
    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return false;
    }

    public ServerRequestRedeemRewards(String str, JSONObject jSONObject, Context context) {
        super(str, jSONObject, context);
        this.scheduleImpl = 0;
    }

    @Override // io.branch.referral.ServerRequest
    public final boolean getAuthRequestContext(Context context) {
        if (!ServerRequest.PlaceComponentResult(context)) {
            if (this.getErrorConfigVersion != null) {
                new BranchError("Trouble redeeming rewards.", -102);
            }
            return true;
        } else if (this.scheduleImpl <= 0) {
            if (this.getErrorConfigVersion != null) {
                new BranchError("Trouble redeeming rewards.", -107);
            }
            return true;
        } else {
            return false;
        }
    }

    @Override // io.branch.referral.ServerRequest
    public final void PlaceComponentResult(int i, String str) {
        if (this.getErrorConfigVersion != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Trouble redeeming rewards. ");
            sb.append(str);
            new BranchError(sb.toString(), i);
        }
    }

    @Override // io.branch.referral.ServerRequest
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.getErrorConfigVersion = null;
    }

    @Override // io.branch.referral.ServerRequest
    public final void getAuthRequestContext(ServerResponse serverResponse, Branch branch) {
        JSONObject jSONObject = this.PlaceComponentResult;
        if (jSONObject != null && jSONObject.has(Defines.Jsonkey.Bucket.getKey()) && jSONObject.has(Defines.Jsonkey.Amount.getKey())) {
            try {
                int i = jSONObject.getInt(Defines.Jsonkey.Amount.getKey());
                String string = jSONObject.getString(Defines.Jsonkey.Bucket.getKey());
                r5 = i > 0;
                PrefHelper prefHelper = this.KClassImpl$Data$declaredNonStaticMembers$2;
                int KClassImpl$Data$declaredNonStaticMembers$2 = PrefHelper.KClassImpl$Data$declaredNonStaticMembers$2(string);
                PrefHelper prefHelper2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                PrefHelper.getAuthRequestContext(string, KClassImpl$Data$declaredNonStaticMembers$2 - i);
            } catch (JSONException unused) {
            }
        }
        if (this.getErrorConfigVersion == null || r5) {
            return;
        }
        new BranchError("Trouble redeeming rewards.", -107);
    }
}
