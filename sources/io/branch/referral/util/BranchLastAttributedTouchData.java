package io.branch.referral.util;

import android.content.Context;
import io.branch.referral.Branch;
import io.branch.referral.BranchError;
import io.branch.referral.ServerRequest;
import io.branch.referral.ServerResponse;
import org.json.JSONObject;

/* loaded from: classes9.dex */
public class BranchLastAttributedTouchData {
    private BranchLastAttributedTouchDataListener MyBillsEntityDataFactory;

    /* loaded from: classes9.dex */
    public interface BranchLastAttributedTouchDataListener {
    }

    /* loaded from: classes9.dex */
    class ServerRequestGetLATD extends ServerRequest {
        final /* synthetic */ BranchLastAttributedTouchData moveToNextValue;

        @Override // io.branch.referral.ServerRequest
        public final boolean GetContactSyncConfig() {
            return true;
        }

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
        public final boolean getAuthRequestContext(Context context) {
            return false;
        }

        @Override // io.branch.referral.ServerRequest
        public final void getAuthRequestContext(ServerResponse serverResponse, Branch branch) {
            if (serverResponse != null) {
                if (this.moveToNextValue.MyBillsEntityDataFactory != null) {
                    BranchLastAttributedTouchDataListener unused = this.moveToNextValue.MyBillsEntityDataFactory;
                    Object obj = serverResponse.PlaceComponentResult;
                    if (obj instanceof JSONObject) {
                        JSONObject jSONObject = (JSONObject) obj;
                        return;
                    } else {
                        new JSONObject();
                        return;
                    }
                }
                return;
            }
            BranchLastAttributedTouchDataListener unused2 = this.moveToNextValue.MyBillsEntityDataFactory;
            new BranchError("Failed to get the Cross Platform IDs", -116);
        }

        @Override // io.branch.referral.ServerRequest
        public final void PlaceComponentResult(int i, String str) {
            BranchLastAttributedTouchDataListener unused = this.moveToNextValue.MyBillsEntityDataFactory;
            new BranchError("Failed to get the Cross Platform IDs", -116);
        }

        @Override // io.branch.referral.ServerRequest
        public final ServerRequest.BRANCH_API_VERSION PlaceComponentResult() {
            return ServerRequest.BRANCH_API_VERSION.V1_LATD;
        }
    }
}
