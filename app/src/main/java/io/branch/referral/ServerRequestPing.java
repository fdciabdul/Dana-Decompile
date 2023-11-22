package io.branch.referral;

import android.content.Context;

/* loaded from: classes.dex */
public class ServerRequestPing extends ServerRequest {
    @Override // io.branch.referral.ServerRequest
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
    }

    @Override // io.branch.referral.ServerRequest
    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return false;
    }

    @Override // io.branch.referral.ServerRequest
    public final void PlaceComponentResult(int i, String str) {
    }

    @Override // io.branch.referral.ServerRequest
    public final void getAuthRequestContext(ServerResponse serverResponse, Branch branch) {
    }

    @Override // io.branch.referral.ServerRequest
    public final boolean getAuthRequestContext(Context context) {
        return !ServerRequest.PlaceComponentResult(context);
    }
}
