package id.dana.service.favorites;

import dagger.internal.Factory;
import id.dana.domain.services.interactor.GetFavoriteServices;
import id.dana.domain.services.interactor.SaveFavoriteServices;
import id.dana.mapper.ThirdPartyServicesMapper;
import id.dana.service.favorites.FavoriteServicesContract;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class FavoriteServicesPresenter_Factory implements Factory<FavoriteServicesPresenter> {
    private final Provider<FavoriteServicesContract.View> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetFavoriteServices> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ThirdPartyServicesMapper> PlaceComponentResult;
    private final Provider<SaveFavoriteServices> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FavoriteServicesPresenter(this.BuiltInFictitiousFunctionClassFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.getAuthRequestContext.get(), this.PlaceComponentResult.get());
    }
}
