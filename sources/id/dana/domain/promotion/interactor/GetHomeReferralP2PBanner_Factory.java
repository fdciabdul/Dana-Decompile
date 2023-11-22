package id.dana.domain.promotion.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.promotion.repository.PromotionRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetHomeReferralP2PBanner_Factory implements Factory<GetHomeReferralP2PBanner> {
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<PromotionRepository> promotionRepositoryProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public GetHomeReferralP2PBanner_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<PromotionRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.promotionRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetHomeReferralP2PBanner get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.promotionRepositoryProvider.get());
    }

    public static GetHomeReferralP2PBanner_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<PromotionRepository> provider3) {
        return new GetHomeReferralP2PBanner_Factory(provider, provider2, provider3);
    }

    public static GetHomeReferralP2PBanner newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, PromotionRepository promotionRepository) {
        return new GetHomeReferralP2PBanner(threadExecutor, postExecutionThread, promotionRepository);
    }
}
