package id.dana.data.pushverify.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.data.pushverify.source.model.PushVerificationListRequest;
import id.dana.data.pushverify.source.model.PushVerificationListResult;
import id.dana.data.pushverify.source.model.PushVerifyChallengeRequest;
import id.dana.data.pushverify.source.model.PushVerifyChallengeResult;
import id.dana.data.pushverify.source.model.VerifyPushChallengeRequest;
import id.dana.data.pushverify.source.model.VerifyPushChallengeResult;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/pushverify/source/network/PushVerifyFacade;", "", "Lid/dana/data/pushverify/source/model/PushVerifyChallengeRequest;", "pushVerifyChallengeRequest", "Lid/dana/data/pushverify/source/model/PushVerifyChallengeResult;", "queryDetailPushChallenge", "(Lid/dana/data/pushverify/source/model/PushVerifyChallengeRequest;)Lid/dana/data/pushverify/source/model/PushVerifyChallengeResult;", "Lid/dana/data/pushverify/source/model/PushVerificationListRequest;", "pushVerificationListRequest", "Lid/dana/data/pushverify/source/model/PushVerificationListResult;", "queryListPushChallenge", "(Lid/dana/data/pushverify/source/model/PushVerificationListRequest;)Lid/dana/data/pushverify/source/model/PushVerificationListResult;", "Lid/dana/data/pushverify/source/model/VerifyPushChallengeRequest;", "verifyPushChallengeRequest", "Lid/dana/data/pushverify/source/model/VerifyPushChallengeResult;", "verifyPushChallenge", "(Lid/dana/data/pushverify/source/model/VerifyPushChallengeRequest;)Lid/dana/data/pushverify/source/model/VerifyPushChallengeResult;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface PushVerifyFacade {
    @OperationType(TrackerDataKey.NetworkErrorOperationTypeProperty.QUERY_DETAIL_PUSH_CHALLENGE)
    @SignCheck
    PushVerifyChallengeResult queryDetailPushChallenge(PushVerifyChallengeRequest pushVerifyChallengeRequest);

    @OperationType(TrackerDataKey.NetworkErrorOperationTypeProperty.QUERY_LIST_PUSH_CHALLENGE)
    @SignCheck
    PushVerificationListResult queryListPushChallenge(PushVerificationListRequest pushVerificationListRequest);

    @OperationType(TrackerDataKey.NetworkErrorOperationTypeProperty.VERIFY_PUSH_CHALLENGE)
    @SignCheck
    VerifyPushChallengeResult verifyPushChallenge(VerifyPushChallengeRequest verifyPushChallengeRequest);
}
