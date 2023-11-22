package id.dana.domain.promocenter.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.promocenter.repository.PromoCenterRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetPromoAds_Factory implements Factory<GetPromoAds> {
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<PromoCenterRepository> promoCenterRepositoryProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public GetPromoAds_Factory(Provider<PromoCenterRepository> provider, Provider<ThreadExecutor> provider2, Provider<PostExecutionThread> provider3) {
        this.promoCenterRepositoryProvider = provider;
        this.threadExecutorProvider = provider2;
        this.postExecutionThreadProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetPromoAds get() {
        return newInstance(this.promoCenterRepositoryProvider.get(), this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get());
    }

    public static GetPromoAds_Factory create(Provider<PromoCenterRepository> provider, Provider<ThreadExecutor> provider2, Provider<PostExecutionThread> provider3) {
        return new GetPromoAds_Factory(provider, provider2, provider3);
    }

    public static GetPromoAds newInstance(PromoCenterRepository promoCenterRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        return new GetPromoAds(promoCenterRepository, threadExecutor, postExecutionThread);
    }
}
