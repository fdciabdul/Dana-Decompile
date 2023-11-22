package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.onboarding.verify.devicelimit.DeviceLimitErrorContract;
import id.dana.onboarding.verify.devicelimit.DeviceLimitErrorPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DeviceLimitErrorModule_ProvidesPresenterFactory implements Factory<DeviceLimitErrorContract.Presenter> {
    private final DeviceLimitErrorModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<DeviceLimitErrorPresenter> PlaceComponentResult;

    private DeviceLimitErrorModule_ProvidesPresenterFactory(DeviceLimitErrorModule deviceLimitErrorModule, Provider<DeviceLimitErrorPresenter> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = deviceLimitErrorModule;
        this.PlaceComponentResult = provider;
    }

    public static DeviceLimitErrorModule_ProvidesPresenterFactory KClassImpl$Data$declaredNonStaticMembers$2(DeviceLimitErrorModule deviceLimitErrorModule, Provider<DeviceLimitErrorPresenter> provider) {
        return new DeviceLimitErrorModule_ProvidesPresenterFactory(deviceLimitErrorModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (DeviceLimitErrorContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(this.PlaceComponentResult.get()));
    }
}
