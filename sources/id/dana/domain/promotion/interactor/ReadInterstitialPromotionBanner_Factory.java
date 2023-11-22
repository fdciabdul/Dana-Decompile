package id.dana.domain.promotion.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.promotion.repository.PromotionRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ReadInterstitialPromotionBanner_Factory implements Factory<ReadInterstitialPromotionBanner> {
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<PromotionRepository> promotionRepositoryProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public ReadInterstitialPromotionBanner_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<PromotionRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.promotionRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final ReadInterstitialPromotionBanner get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.promotionRepositoryProvider.get());
    }

    public static ReadInterstitialPromotionBanner_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<PromotionRepository> provider3) {
        return new ReadInterstitialPromotionBanner_Factory(provider, provider2, provider3);
    }

    public static ReadInterstitialPromotionBanner newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, PromotionRepository promotionRepository) {
        return new ReadInterstitialPromotionBanner(threadExecutor, postExecutionThread, promotionRepository);
    }
}
