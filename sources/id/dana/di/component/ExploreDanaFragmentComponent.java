package id.dana.di.component;

import dagger.Component;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.globalsearch.GlobalSearchModule;
import id.dana.contract.promoexplore.PromoExploreModule;
import id.dana.di.PerActivity;
import id.dana.explore.popularplaces.PopularPlacesModule;
import id.dana.explore.view.ExploreDanaFragment;
import kotlin.Metadata;

@Component(dependencies = {ApplicationComponent.class}, modules = {DeepLinkModule.class, GlobalSearchModule.class, PopularPlacesModule.class, PromoExploreModule.class})
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/di/component/ExploreDanaFragmentComponent;", "", "Lid/dana/explore/view/ExploreDanaFragment;", "p0", "", "PlaceComponentResult", "(Lid/dana/explore/view/ExploreDanaFragment;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes4.dex */
public interface ExploreDanaFragmentComponent {
    void PlaceComponentResult(ExploreDanaFragment p0);
}
