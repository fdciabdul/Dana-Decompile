package id.dana.data.pushverify.source;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import id.dana.data.pushverify.source.model.PushVerificationListResult;
import id.dana.data.pushverify.source.model.PushVerifyChallengeRequest;
import id.dana.data.pushverify.source.model.PushVerifyChallengeResult;
import id.dana.data.pushverify.source.model.VerifyPushChallengeRequest;
import id.dana.data.pushverify.source.model.VerifyPushChallengeResult;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J3\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\b2\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\b2\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0014\u0010\u0015ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/pushverify/source/PushVerifyEntityData;", "", "", "", "verificationStatusList", "", "pageNum", SecurityConstants.KEY_PAGE_SIZE, "Lio/reactivex/Observable;", "Lid/dana/data/pushverify/source/model/PushVerificationListResult;", "getPushVerificationList", "(Ljava/util/List;II)Lio/reactivex/Observable;", "Lid/dana/data/pushverify/source/model/PushVerifyChallengeRequest;", "pushVerifyChallengeRequest", "Lid/dana/data/pushverify/source/model/PushVerifyChallengeResult;", "getPushVerifyChallenge", "(Lid/dana/data/pushverify/source/model/PushVerifyChallengeRequest;)Lio/reactivex/Observable;", "Lid/dana/data/pushverify/source/model/VerifyPushChallengeRequest;", "verifyPushChallengeRequest", "Lid/dana/data/pushverify/source/model/VerifyPushChallengeResult;", "verifyPushChallenge", "(Lid/dana/data/pushverify/source/model/VerifyPushChallengeRequest;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface PushVerifyEntityData {
    Observable<PushVerificationListResult> getPushVerificationList(List<String> verificationStatusList, int pageNum, int pageSize);

    Observable<PushVerifyChallengeResult> getPushVerifyChallenge(PushVerifyChallengeRequest pushVerifyChallengeRequest);

    Observable<VerifyPushChallengeResult> verifyPushChallenge(VerifyPushChallengeRequest verifyPushChallengeRequest);
}
