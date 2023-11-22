package io.branch.referral;

import android.content.Context;
import io.branch.indexing.BranchUniversalObject;

/* loaded from: classes9.dex */
class ServerRequestRegisterView extends ServerRequest {
    BranchUniversalObject.RegisterViewStatusListener scheduleImpl;

    @Override // io.branch.referral.ServerRequest
    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return false;
    }

    @Override // io.branch.referral.ServerRequest
    public final void getAuthRequestContext(ServerResponse serverResponse, Branch branch) {
    }

    @Override // io.branch.referral.ServerRequest
    public final void PlaceComponentResult(int i, String str) {
        if (this.scheduleImpl != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to register content view. ");
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
            new BranchError("Unable to register content view", -102);
            return true;
        }
        return true;
    }

    @Override // io.branch.referral.ServerRequest
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.scheduleImpl = null;
    }
}
