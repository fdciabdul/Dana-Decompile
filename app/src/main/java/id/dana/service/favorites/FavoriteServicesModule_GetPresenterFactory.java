package id.dana.service.favorites;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.service.favorites.FavoriteServicesContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class FavoriteServicesModule_GetPresenterFactory implements Factory<FavoriteServicesContract.Presenter> {
    private final FavoriteServicesModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<FavoriteServicesPresenter> getAuthRequestContext;

    public static FavoriteServicesContract.Presenter KClassImpl$Data$declaredNonStaticMembers$2(FavoriteServicesModule favoriteServicesModule, FavoriteServicesPresenter favoriteServicesPresenter) {
        return (FavoriteServicesContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(favoriteServicesModule.PlaceComponentResult(favoriteServicesPresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FavoriteServicesContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(this.getAuthRequestContext.get()));
    }
}
