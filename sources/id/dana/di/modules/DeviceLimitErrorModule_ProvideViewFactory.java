package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.onboarding.verify.devicelimit.DeviceLimitErrorContract;

/* loaded from: classes4.dex */
public final class DeviceLimitErrorModule_ProvideViewFactory implements Factory<DeviceLimitErrorContract.View> {
    private final DeviceLimitErrorModule MyBillsEntityDataFactory;

    private DeviceLimitErrorModule_ProvideViewFactory(DeviceLimitErrorModule deviceLimitErrorModule) {
        this.MyBillsEntityDataFactory = deviceLimitErrorModule;
    }

    public static DeviceLimitErrorModule_ProvideViewFactory BuiltInFictitiousFunctionClassFactory(DeviceLimitErrorModule deviceLimitErrorModule) {
        return new DeviceLimitErrorModule_ProvideViewFactory(deviceLimitErrorModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (DeviceLimitErrorContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getPlaceComponentResult());
    }
}
