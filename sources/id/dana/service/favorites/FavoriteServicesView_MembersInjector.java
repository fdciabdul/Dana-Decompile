package id.dana.service.favorites;

import dagger.MembersInjector;
import id.dana.service.favorites.FavoriteServicesContract;

/* loaded from: classes5.dex */
public final class FavoriteServicesView_MembersInjector implements MembersInjector<FavoriteServicesView> {
    public static void MyBillsEntityDataFactory(FavoriteServicesView favoriteServicesView, FavoriteServicesContract.Presenter presenter) {
        favoriteServicesView.presenter = presenter;
    }
}
