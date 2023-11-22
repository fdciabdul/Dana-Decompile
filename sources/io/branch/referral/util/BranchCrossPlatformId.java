package io.branch.referral.util;

import android.content.Context;
import io.branch.referral.Branch;
import io.branch.referral.BranchError;
import io.branch.referral.ServerRequest;
import io.branch.referral.ServerResponse;
import org.json.JSONObject;

/* loaded from: classes9.dex */
public class BranchCrossPlatformId {
    private BranchCrossPlatformIdListener MyBillsEntityDataFactory;

    /* loaded from: classes9.dex */
    public interface BranchCrossPlatformIdListener {
    }

    /* loaded from: classes9.dex */
    class ServerRequestGetCPID extends ServerRequest {
        final /* synthetic */ BranchCrossPlatformId moveToNextValue;

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
            JSONObject jSONObject;
            if (serverResponse != null) {
                if (this.moveToNextValue.MyBillsEntityDataFactory != null) {
                    BranchCrossPlatformIdListener unused = this.moveToNextValue.MyBillsEntityDataFactory;
                    BranchCrossPlatformId branchCrossPlatformId = this.moveToNextValue;
                    Object obj = serverResponse.PlaceComponentResult;
                    if (obj instanceof JSONObject) {
                        jSONObject = (JSONObject) obj;
                    } else {
                        jSONObject = new JSONObject();
                    }
                    new BranchCPID(jSONObject);
                    return;
                }
                return;
            }
            BranchCrossPlatformIdListener unused2 = this.moveToNextValue.MyBillsEntityDataFactory;
            new BranchError("Failed to get the Cross Platform IDs", -116);
        }

        @Override // io.branch.referral.ServerRequest
        public final void PlaceComponentResult(int i, String str) {
            BranchCrossPlatformIdListener unused = this.moveToNextValue.MyBillsEntityDataFactory;
            new BranchError("Failed to get the Cross Platform IDs", -116);
        }

        @Override // io.branch.referral.ServerRequest
        public final ServerRequest.BRANCH_API_VERSION PlaceComponentResult() {
            return ServerRequest.BRANCH_API_VERSION.V1_CPID;
        }
    }

    /* loaded from: classes9.dex */
    public class BranchCPID {
        JSONObject KClassImpl$Data$declaredNonStaticMembers$2;

        /* loaded from: classes9.dex */
        public class ProbabilisticCPID {
        }

        public BranchCPID(JSONObject jSONObject) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = jSONObject;
        }
    }
}
