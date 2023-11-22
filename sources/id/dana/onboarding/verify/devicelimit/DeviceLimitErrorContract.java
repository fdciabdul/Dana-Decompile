package id.dana.onboarding.verify.devicelimit;

import id.dana.base.AbstractContractKt;
import id.dana.domain.registration.model.HelpButtonOtpLimitDeviceModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/onboarding/verify/devicelimit/DeviceLimitErrorContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface DeviceLimitErrorContract {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/onboarding/verify/devicelimit/DeviceLimitErrorContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "", "MyBillsEntityDataFactory", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void MyBillsEntityDataFactory();
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/onboarding/verify/devicelimit/DeviceLimitErrorContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "Lid/dana/domain/registration/model/HelpButtonOtpLimitDeviceModel;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/domain/registration/model/HelpButtonOtpLimitDeviceModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface View extends AbstractContractKt.AbstractView {
        void KClassImpl$Data$declaredNonStaticMembers$2(HelpButtonOtpLimitDeviceModel p0);
    }
}
