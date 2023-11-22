package id.dana.domain.promotion.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.promotion.repository.PromotionRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetLeaderboardEntryBanner_Factory implements Factory<GetLeaderboardEntryBanner> {
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<PromotionRepository> promotionRepositoryProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public GetLeaderboardEntryBanner_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<PromotionRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.promotionRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetLeaderboardEntryBanner get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.promotionRepositoryProvider.get());
    }

    public static GetLeaderboardEntryBanner_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<PromotionRepository> provider3) {
        return new GetLeaderboardEntryBanner_Factory(provider, provider2, provider3);
    }

    public static GetLeaderboardEntryBanner newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, PromotionRepository promotionRepository) {
        return new GetLeaderboardEntryBanner(threadExecutor, postExecutionThread, promotionRepository);
    }
}
