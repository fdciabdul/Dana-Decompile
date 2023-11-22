package id.dana.richview.profile.switchautoroute;

import dagger.internal.Factory;
import id.dana.domain.autoroute.interactor.IsHavingAutoRouteAsset;
import id.dana.domain.autoroute.interactor.SwitchAutoRouting;
import id.dana.richview.profile.switchautoroute.SwitchAutoRouteContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SwitchAutoRoutePresenter_Factory implements Factory<SwitchAutoRoutePresenter> {
    private final Provider<SwitchAutoRouting> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<SwitchAutoRouteContract.View> PlaceComponentResult;
    private final Provider<IsHavingAutoRouteAsset> getAuthRequestContext;

    private SwitchAutoRoutePresenter_Factory(Provider<SwitchAutoRouteContract.View> provider, Provider<SwitchAutoRouting> provider2, Provider<IsHavingAutoRouteAsset> provider3) {
        this.PlaceComponentResult = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
        this.getAuthRequestContext = provider3;
    }

    public static SwitchAutoRoutePresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<SwitchAutoRouteContract.View> provider, Provider<SwitchAutoRouting> provider2, Provider<IsHavingAutoRouteAsset> provider3) {
        return new SwitchAutoRoutePresenter_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SwitchAutoRoutePresenter(this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.getAuthRequestContext.get());
    }
}
