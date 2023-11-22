package id.dana.service.favorites;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.service.favorites.FavoriteServicesContract;

/* loaded from: classes5.dex */
public final class FavoriteServicesModule_GetViewFactory implements Factory<FavoriteServicesContract.View> {
    private final FavoriteServicesModule KClassImpl$Data$declaredNonStaticMembers$2;

    public static FavoriteServicesContract.View MyBillsEntityDataFactory(FavoriteServicesModule favoriteServicesModule) {
        return (FavoriteServicesContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(favoriteServicesModule.PlaceComponentResult());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FavoriteServicesContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult());
    }
}
