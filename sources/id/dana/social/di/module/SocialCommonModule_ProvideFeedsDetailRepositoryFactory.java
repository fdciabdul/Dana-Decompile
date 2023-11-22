package id.dana.social.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.feeds.data.detail.FeedsDetailEntityRepository;
import id.dana.feeds.domain.detail.FeedsDetailRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SocialCommonModule_ProvideFeedsDetailRepositoryFactory implements Factory<FeedsDetailRepository> {
    private final Provider<FeedsDetailEntityRepository> MyBillsEntityDataFactory;
    private final SocialCommonModule PlaceComponentResult;

    private SocialCommonModule_ProvideFeedsDetailRepositoryFactory(SocialCommonModule socialCommonModule, Provider<FeedsDetailEntityRepository> provider) {
        this.PlaceComponentResult = socialCommonModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static SocialCommonModule_ProvideFeedsDetailRepositoryFactory getAuthRequestContext(SocialCommonModule socialCommonModule, Provider<FeedsDetailEntityRepository> provider) {
        return new SocialCommonModule_ProvideFeedsDetailRepositoryFactory(socialCommonModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FeedsDetailRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory.get()));
    }
}
