package id.dana.di.component;

import dagger.Component;
import id.dana.di.PerActivity;
import id.dana.service.favorites.FavoriteServicesModule;
import id.dana.service.favorites.FavoriteServicesView;

@Component(dependencies = {ApplicationComponent.class}, modules = {FavoriteServicesModule.class})
@PerActivity
/* loaded from: classes4.dex */
public interface FavoriteServicesComponent {
    void KClassImpl$Data$declaredNonStaticMembers$2(FavoriteServicesView favoriteServicesView);
}
