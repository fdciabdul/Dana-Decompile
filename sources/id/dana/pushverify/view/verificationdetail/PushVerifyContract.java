package id.dana.pushverify.view.verificationdetail;

import id.dana.base.AbstractContract;
import id.dana.base.AbstractContractKt;
import id.dana.pushverify.model.PushVerifyChallengeModel;
import id.dana.pushverify.model.VerifyPushChallengeParamModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/pushverify/view/verificationdetail/PushVerifyContract;", "", "<init>", "()V", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PushVerifyContract {

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/pushverify/view/verificationdetail/PushVerifyContract$Presenter;", "Lid/dana/base/AbstractContract$AbstractPresenter;", "", "p0", "p1", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;Ljava/lang/String;)V", "Lid/dana/pushverify/model/VerifyPushChallengeParamModel;", "PlaceComponentResult", "(Lid/dana/pushverify/model/VerifyPushChallengeParamModel;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void MyBillsEntityDataFactory(String p0, String p1);

        void PlaceComponentResult(VerifyPushChallengeParamModel p0, String p1);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H&¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\tJ\u0019\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H&¢\u0006\u0004\b\u0010\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/pushverify/view/verificationdetail/PushVerifyContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "", "throwable", "", "onErrorGetPushVerifyChallenge", "(Ljava/lang/Throwable;)V", "onErrorVerifyPushChallenge", "onExpiredGetPushVerifyChallenge", "()V", "onInvalidSessionGetPushVerifyChallenge", "onRejectVerifyPushChallenge", "Lid/dana/pushverify/model/PushVerifyChallengeModel;", "pushVerifyChallengeModel", "onSuccessGetPushVerifyChallenge", "(Lid/dana/pushverify/model/PushVerifyChallengeModel;)V", "onSuccessVerifyPushChallenge"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface View extends AbstractContractKt.AbstractView {
        void onErrorGetPushVerifyChallenge(Throwable throwable);

        void onErrorVerifyPushChallenge(Throwable throwable);

        void onExpiredGetPushVerifyChallenge();

        void onInvalidSessionGetPushVerifyChallenge();

        void onRejectVerifyPushChallenge();

        void onSuccessGetPushVerifyChallenge(PushVerifyChallengeModel pushVerifyChallengeModel);

        void onSuccessVerifyPushChallenge();
    }
}
