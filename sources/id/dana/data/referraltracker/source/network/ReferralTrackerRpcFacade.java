package id.dana.data.referraltracker.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import id.dana.data.referraltracker.source.network.request.ReferralTrackerRpcRequest;
import id.dana.data.referraltracker.source.network.result.ReferralTrackerRpcResult;

/* loaded from: classes4.dex */
public interface ReferralTrackerRpcFacade {
    @OperationType("alipayplus.mobilewallet.referral.tracker.consult")
    @SignCheck
    ReferralTrackerRpcResult getReferralTracker(ReferralTrackerRpcRequest referralTrackerRpcRequest);
}
