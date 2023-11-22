package id.dana.riskChallenges.data.verifypassword.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.riskChallenges.data.verifypassword.source.network.request.VerifyPasswordRequest;
import id.dana.riskChallenges.data.verifypassword.source.network.request.VerifySecurityPasswordRequest;
import id.dana.riskChallenges.data.verifypassword.source.network.result.VerifyPasswordResult;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\b\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/riskChallenges/data/verifypassword/source/network/VerifyPasswordFacade;", "", "Lid/dana/riskChallenges/data/verifypassword/source/network/request/VerifyPasswordRequest;", "request", "Lid/dana/riskChallenges/data/verifypassword/source/network/result/VerifyPasswordResult;", "verifyPassword", "(Lid/dana/riskChallenges/data/verifypassword/source/network/request/VerifyPasswordRequest;)Lid/dana/riskChallenges/data/verifypassword/source/network/result/VerifyPasswordResult;", "Lid/dana/riskChallenges/data/verifypassword/source/network/request/VerifySecurityPasswordRequest;", "verifySecurityPassword", "(Lid/dana/riskChallenges/data/verifypassword/source/network/request/VerifySecurityPasswordRequest;)Lid/dana/riskChallenges/data/verifypassword/source/network/result/VerifyPasswordResult;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface VerifyPasswordFacade {
    @OperationType("alipayplus.mobilewallet.user.password.verify")
    @SignCheck
    VerifyPasswordResult verifyPassword(VerifyPasswordRequest request);

    @OperationType(TrackerDataKey.NetworkErrorOperationTypeProperty.VERIFY_OTP_RISK)
    @SignCheck
    VerifyPasswordResult verifySecurityPassword(VerifySecurityPasswordRequest request);
}
