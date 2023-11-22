package id.dana.domain.pushverify.repository;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import id.dana.domain.pushverify.model.PushVerificationList;
import id.dana.domain.pushverify.model.PushVerifyChallenge;
import id.dana.domain.pushverify.model.PushVerifyParam;
import id.dana.domain.pushverify.model.VerifyPushChallenge;
import id.dana.domain.pushverify.model.VerifyPushChallengeParam;
import io.reactivex.Completable;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J3\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\b2\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\bH&¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0011H&¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\b2\u0006\u0010\u0019\u001a\u00020\u0018H&¢\u0006\u0004\b\u001b\u0010\u001cø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/domain/pushverify/repository/PushVerifyRepository;", "", "", "", "verificationStatusList", "", "pageNum", SecurityConstants.KEY_PAGE_SIZE, "Lio/reactivex/Observable;", "Lid/dana/domain/pushverify/model/PushVerificationList;", "getPushVerificationList", "(Ljava/util/List;II)Lio/reactivex/Observable;", "Lid/dana/domain/pushverify/model/PushVerifyParam;", "pushVerifyParam", "Lid/dana/domain/pushverify/model/PushVerifyChallenge;", "getPushVerifyChallenge", "(Lid/dana/domain/pushverify/model/PushVerifyParam;)Lio/reactivex/Observable;", "", "isNotificationPromptDisabled", "()Lio/reactivex/Observable;", "enabled", "Lio/reactivex/Completable;", "saveNotificationPromptPreference", "(Z)Lio/reactivex/Completable;", "Lid/dana/domain/pushverify/model/VerifyPushChallengeParam;", "verifyPushChallengeParam", "Lid/dana/domain/pushverify/model/VerifyPushChallenge;", "verifyPushChallenge", "(Lid/dana/domain/pushverify/model/VerifyPushChallengeParam;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface PushVerifyRepository {
    Observable<PushVerificationList> getPushVerificationList(List<String> verificationStatusList, int pageNum, int pageSize);

    Observable<PushVerifyChallenge> getPushVerifyChallenge(PushVerifyParam pushVerifyParam);

    Observable<Boolean> isNotificationPromptDisabled();

    Completable saveNotificationPromptPreference(boolean enabled);

    Observable<VerifyPushChallenge> verifyPushChallenge(VerifyPushChallengeParam verifyPushChallengeParam);
}
