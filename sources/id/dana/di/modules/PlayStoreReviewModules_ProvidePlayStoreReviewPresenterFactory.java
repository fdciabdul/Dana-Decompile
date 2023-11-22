package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.playstorereview.PlayStoreReviewContract;
import id.dana.playstorereview.PlayStoreReviewPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class PlayStoreReviewModules_ProvidePlayStoreReviewPresenterFactory implements Factory<PlayStoreReviewContract.Presenter> {
    private final Provider<PlayStoreReviewPresenter> BuiltInFictitiousFunctionClassFactory;
    private final PlayStoreReviewModules MyBillsEntityDataFactory;

    private PlayStoreReviewModules_ProvidePlayStoreReviewPresenterFactory(PlayStoreReviewModules playStoreReviewModules, Provider<PlayStoreReviewPresenter> provider) {
        this.MyBillsEntityDataFactory = playStoreReviewModules;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static PlayStoreReviewModules_ProvidePlayStoreReviewPresenterFactory KClassImpl$Data$declaredNonStaticMembers$2(PlayStoreReviewModules playStoreReviewModules, Provider<PlayStoreReviewPresenter> provider) {
        return new PlayStoreReviewModules_ProvidePlayStoreReviewPresenterFactory(playStoreReviewModules, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PlayStoreReviewContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
