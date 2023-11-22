package id.dana.domain.deeplink.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.deeplink.repository.DeepLinkRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class InitSessionDeepLink_Factory implements Factory<InitSessionDeepLink> {
    private final Provider<DeepLinkRepository> deepLinkRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public InitSessionDeepLink_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<DeepLinkRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.deepLinkRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final InitSessionDeepLink get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.deepLinkRepositoryProvider.get());
    }

    public static InitSessionDeepLink_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<DeepLinkRepository> provider3) {
        return new InitSessionDeepLink_Factory(provider, provider2, provider3);
    }

    public static InitSessionDeepLink newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, DeepLinkRepository deepLinkRepository) {
        return new InitSessionDeepLink(threadExecutor, postExecutionThread, deepLinkRepository);
    }
}
