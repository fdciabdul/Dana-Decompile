package id.dana.data.pushverify.source.mock;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.data.pushverify.source.PushVerifyEntityData;
import id.dana.data.pushverify.source.model.PushVerificationDetailResult;
import id.dana.data.pushverify.source.model.PushVerificationListResult;
import id.dana.data.pushverify.source.model.PushVerifyChallengeRequest;
import id.dana.data.pushverify.source.model.PushVerifyChallengeResult;
import id.dana.data.pushverify.source.model.VerificationDetailItemDTO;
import id.dana.data.pushverify.source.model.VerifyPushChallengeRequest;
import id.dana.data.pushverify.source.model.VerifyPushChallengeResult;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0016\u0010\u0017J3\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\b2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/data/pushverify/source/mock/MockPushVerifyEntityData;", "Lid/dana/data/pushverify/source/PushVerifyEntityData;", "", "", "verificationStatusList", "", "pageNum", SecurityConstants.KEY_PAGE_SIZE, "Lio/reactivex/Observable;", "Lid/dana/data/pushverify/source/model/PushVerificationListResult;", "getPushVerificationList", "(Ljava/util/List;II)Lio/reactivex/Observable;", "Lid/dana/data/pushverify/source/model/PushVerifyChallengeRequest;", "pushVerifyChallengeRequest", "Lid/dana/data/pushverify/source/model/PushVerifyChallengeResult;", "getPushVerifyChallenge", "(Lid/dana/data/pushverify/source/model/PushVerifyChallengeRequest;)Lio/reactivex/Observable;", "Lid/dana/data/pushverify/source/model/VerifyPushChallengeRequest;", "verifyPushChallengeRequest", "Lid/dana/data/pushverify/source/model/VerifyPushChallengeResult;", "verifyPushChallenge", "(Lid/dana/data/pushverify/source/model/VerifyPushChallengeRequest;)Lio/reactivex/Observable;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MockPushVerifyEntityData implements PushVerifyEntityData {
    @Inject
    public MockPushVerifyEntityData() {
    }

    @Override // id.dana.data.pushverify.source.PushVerifyEntityData
    public final Observable<PushVerificationListResult> getPushVerificationList(List<String> verificationStatusList, int pageNum, int pageSize) {
        Intrinsics.checkNotNullParameter(verificationStatusList, "");
        StringBuilder sb = new StringBuilder();
        sb.append("5 Oct 2020, ");
        sb.append(Calendar.getInstance().getTimeInMillis());
        VerificationDetailItemDTO verificationDetailItemDTO = new VerificationDetailItemDTO("KFC", sb.toString(), "LOGIN", "https://a.m.dana.id/abc.jpg", "INIT", 120, "trxIdXXX", "tokenValue", "userId_bizType_mid_did_sid_platform_device");
        ArrayList arrayList = new ArrayList(pageSize);
        for (int i = 0; i < pageSize; i++) {
            arrayList.add(verificationDetailItemDTO);
        }
        Observable<PushVerificationListResult> just = Observable.just(new PushVerificationListResult(arrayList, true));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.pushverify.source.PushVerifyEntityData
    public final Observable<PushVerifyChallengeResult> getPushVerifyChallenge(PushVerifyChallengeRequest pushVerifyChallengeRequest) {
        Intrinsics.checkNotNullParameter(pushVerifyChallengeRequest, "");
        Observable<PushVerifyChallengeResult> just = Observable.just(new PushVerifyChallengeResult("userId_bizType_mid_did_sid_platform_device", new PushVerificationDetailResult(null, "KFC", "WEB", "5 Oct 2020", "LOGIN", null, 15, null, null, null, PDF417Common.NUMBER_OF_CODEWORDS, null)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.pushverify.source.PushVerifyEntityData
    public final Observable<VerifyPushChallengeResult> verifyPushChallenge(VerifyPushChallengeRequest verifyPushChallengeRequest) {
        Intrinsics.checkNotNullParameter(verifyPushChallengeRequest, "");
        Observable<VerifyPushChallengeResult> just = Observable.just(new VerifyPushChallengeResult(true));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }
}
