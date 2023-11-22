package id.dana.di.component;

import dagger.Component;
import id.dana.di.PerActivity;
import id.dana.di.modules.PlayStoreReviewModules;
import id.dana.playstorereview.PlayStoreReviewActivity;

@Component(dependencies = {ApplicationComponent.class}, modules = {PlayStoreReviewModules.class})
@PerActivity
/* loaded from: classes8.dex */
public interface PlayStoreReviewComponent {
    void MyBillsEntityDataFactory(PlayStoreReviewActivity playStoreReviewActivity);
}
