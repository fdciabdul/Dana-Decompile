package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.di.PerActivity;
import id.dana.playstorereview.PlayStoreReviewContract;
import id.dana.playstorereview.PlayStoreReviewPresenter;

@Module
/* loaded from: classes2.dex */
public class PlayStoreReviewModules {
    PlayStoreReviewContract.View getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public PlayStoreReviewContract.Presenter BuiltInFictitiousFunctionClassFactory(PlayStoreReviewPresenter playStoreReviewPresenter) {
        return playStoreReviewPresenter;
    }

    public PlayStoreReviewModules(PlayStoreReviewContract.View view) {
        this.getAuthRequestContext = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public PlayStoreReviewContract.View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
