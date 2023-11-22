package id.dana.onboarding.verify.devicelimit;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.domain.registration.interactor.GetHelpButtonOtpLimitDevice;
import id.dana.onboarding.verify.devicelimit.DeviceLimitErrorContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class DeviceLimitErrorPresenter_Factory implements Factory<DeviceLimitErrorPresenter> {
    private final Provider<GetHelpButtonOtpLimitDevice> BuiltInFictitiousFunctionClassFactory;
    private final Provider<DeviceLimitErrorContract.View> KClassImpl$Data$declaredNonStaticMembers$2;

    private DeviceLimitErrorPresenter_Factory(Provider<GetHelpButtonOtpLimitDevice> provider, Provider<DeviceLimitErrorContract.View> provider2) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
    }

    public static DeviceLimitErrorPresenter_Factory BuiltInFictitiousFunctionClassFactory(Provider<GetHelpButtonOtpLimitDevice> provider, Provider<DeviceLimitErrorContract.View> provider2) {
        return new DeviceLimitErrorPresenter_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DeviceLimitErrorPresenter(DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2));
    }
}
