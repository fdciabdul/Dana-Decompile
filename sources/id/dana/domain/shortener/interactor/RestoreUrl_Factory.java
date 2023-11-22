package id.dana.domain.shortener.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.shortener.repository.ShortenerRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class RestoreUrl_Factory implements Factory<RestoreUrl> {
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ShortenerRepository> shortenerRepositoryProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public RestoreUrl_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<ShortenerRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.shortenerRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final RestoreUrl get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.shortenerRepositoryProvider.get());
    }

    public static RestoreUrl_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<ShortenerRepository> provider3) {
        return new RestoreUrl_Factory(provider, provider2, provider3);
    }

    public static RestoreUrl newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, ShortenerRepository shortenerRepository) {
        return new RestoreUrl(threadExecutor, postExecutionThread, shortenerRepository);
    }
}
