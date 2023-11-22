package id.dana.contract.shortener;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.contract.shortener.RestoreUrlContract;
import id.dana.domain.shortener.interactor.RestoreUrl;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class RestoreUrlPresenter_Factory implements Factory<RestoreUrlPresenter> {
    private final Provider<RestoreUrl> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<RestoreUrlContract.View> PlaceComponentResult;

    private RestoreUrlPresenter_Factory(Provider<RestoreUrlContract.View> provider, Provider<RestoreUrl> provider2) {
        this.PlaceComponentResult = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
    }

    public static RestoreUrlPresenter_Factory MyBillsEntityDataFactory(Provider<RestoreUrlContract.View> provider, Provider<RestoreUrl> provider2) {
        return new RestoreUrlPresenter_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new RestoreUrlPresenter(DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2));
    }
}
