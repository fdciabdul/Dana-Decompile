package id.dana.service.favorites;

import dagger.Module;
import dagger.Provides;
import id.dana.service.favorites.FavoriteServicesContract;

@Module
/* loaded from: classes5.dex */
public class FavoriteServicesModule {
    private FavoriteServicesContract.View MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public FavoriteServicesContract.Presenter PlaceComponentResult(FavoriteServicesPresenter favoriteServicesPresenter) {
        return favoriteServicesPresenter;
    }

    public FavoriteServicesModule(FavoriteServicesContract.View view) {
        this.MyBillsEntityDataFactory = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public FavoriteServicesContract.View PlaceComponentResult() {
        return this.MyBillsEntityDataFactory;
    }
}
