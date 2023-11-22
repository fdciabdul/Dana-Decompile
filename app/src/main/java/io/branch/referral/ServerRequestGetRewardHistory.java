package io.branch.referral;

import android.content.Context;
import io.branch.referral.Branch;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class ServerRequestGetRewardHistory extends ServerRequest {
    Branch.BranchListResponseListener scheduleImpl;

    @Override // io.branch.referral.ServerRequest
    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return false;
    }

    public ServerRequestGetRewardHistory(String str, JSONObject jSONObject, Context context) {
        super(str, jSONObject, context);
    }

    @Override // io.branch.referral.ServerRequest
    public final void getAuthRequestContext(ServerResponse serverResponse, Branch branch) {
        if (this.scheduleImpl != null) {
            Object obj = serverResponse.PlaceComponentResult;
            if (obj instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) obj;
            }
        }
    }

    @Override // io.branch.referral.ServerRequest
    public final void PlaceComponentResult(int i, String str) {
        if (this.scheduleImpl != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Trouble retrieving user credit history. ");
            sb.append(str);
            new BranchError(sb.toString(), i);
        }
    }

    @Override // io.branch.referral.ServerRequest
    public final boolean getAuthRequestContext(Context context) {
        if (ServerRequest.PlaceComponentResult(context)) {
            return false;
        }
        if (this.scheduleImpl != null) {
            new BranchError("Trouble retrieving user credit history.", -102);
            return true;
        }
        return true;
    }

    @Override // io.branch.referral.ServerRequest
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.scheduleImpl = null;
    }
}
