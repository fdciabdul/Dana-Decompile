package io.branch.referral;

import io.branch.indexing.BranchUniversalObject;
import io.branch.referral.Branch;
import io.branch.referral.util.LinkProperties;
import org.json.JSONObject;

/* loaded from: classes9.dex */
class BranchUniversalReferralInitWrapper implements Branch.BranchReferralInitListener {
    private final Branch.BranchUniversalReferralInitListener MyBillsEntityDataFactory;

    @Override // io.branch.referral.Branch.BranchReferralInitListener
    public void onInitFinished(JSONObject jSONObject, BranchError branchError) {
        if (this.MyBillsEntityDataFactory == null || branchError != null) {
            return;
        }
        BranchUniversalObject.BuiltInFictitiousFunctionClassFactory();
        LinkProperties.MyBillsEntityDataFactory();
    }
}
