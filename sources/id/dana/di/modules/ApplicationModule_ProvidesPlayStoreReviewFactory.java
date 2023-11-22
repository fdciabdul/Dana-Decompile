package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.playstorereview.repository.PlayStoreReviewEntityRepository;
import id.dana.domain.playstorereview.repository.PlayStoreReviewRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvidesPlayStoreReviewFactory implements Factory<PlayStoreReviewRepository> {
    private final ApplicationModule PlaceComponentResult;
    private final Provider<PlayStoreReviewEntityRepository> getAuthRequestContext;

    private ApplicationModule_ProvidesPlayStoreReviewFactory(ApplicationModule applicationModule, Provider<PlayStoreReviewEntityRepository> provider) {
        this.PlaceComponentResult = applicationModule;
        this.getAuthRequestContext = provider;
    }

    public static ApplicationModule_ProvidesPlayStoreReviewFactory KClassImpl$Data$declaredNonStaticMembers$2(ApplicationModule applicationModule, Provider<PlayStoreReviewEntityRepository> provider) {
        return new ApplicationModule_ProvidesPlayStoreReviewFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PlayStoreReviewRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.MyBillsEntityDataFactory(this.getAuthRequestContext.get()));
    }
}
