package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.playstorereview.PlayStoreReviewContract;

/* loaded from: classes4.dex */
public final class PlayStoreReviewModules_ProvidePlayStoreReviewViewFactory implements Factory<PlayStoreReviewContract.View> {
    private final PlayStoreReviewModules KClassImpl$Data$declaredNonStaticMembers$2;

    private PlayStoreReviewModules_ProvidePlayStoreReviewViewFactory(PlayStoreReviewModules playStoreReviewModules) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = playStoreReviewModules;
    }

    public static PlayStoreReviewModules_ProvidePlayStoreReviewViewFactory getAuthRequestContext(PlayStoreReviewModules playStoreReviewModules) {
        return new PlayStoreReviewModules_ProvidePlayStoreReviewViewFactory(playStoreReviewModules);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PlayStoreReviewContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2());
    }
}
