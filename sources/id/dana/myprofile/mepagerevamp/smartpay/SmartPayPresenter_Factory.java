package id.dana.myprofile.mepagerevamp.smartpay;

import dagger.internal.Factory;
import id.dana.domain.autoroute.interactor.GetAutoRouteInitialSetting;
import id.dana.domain.user.interactor.GetUserInfo;
import id.dana.myprofile.mepagerevamp.smartpay.SmartPayContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SmartPayPresenter_Factory implements Factory<SmartPayPresenter> {
    private final Provider<GetAutoRouteInitialSetting> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<SmartPayContract.View> MyBillsEntityDataFactory;
    private final Provider<GetUserInfo> PlaceComponentResult;

    private SmartPayPresenter_Factory(Provider<SmartPayContract.View> provider, Provider<GetUserInfo> provider2, Provider<GetAutoRouteInitialSetting> provider3) {
        this.MyBillsEntityDataFactory = provider;
        this.PlaceComponentResult = provider2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider3;
    }

    public static SmartPayPresenter_Factory getAuthRequestContext(Provider<SmartPayContract.View> provider, Provider<GetUserInfo> provider2, Provider<GetAutoRouteInitialSetting> provider3) {
        return new SmartPayPresenter_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SmartPayPresenter(this.MyBillsEntityDataFactory.get(), this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
