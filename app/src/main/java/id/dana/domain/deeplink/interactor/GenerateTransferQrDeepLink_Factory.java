package id.dana.domain.deeplink.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.deeplink.repository.GenerateLinkRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GenerateTransferQrDeepLink_Factory implements Factory<GenerateTransferQrDeepLink> {
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<GenerateLinkRepository> repositoryProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public GenerateTransferQrDeepLink_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<GenerateLinkRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.repositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GenerateTransferQrDeepLink get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.repositoryProvider.get());
    }

    public static GenerateTransferQrDeepLink_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<GenerateLinkRepository> provider3) {
        return new GenerateTransferQrDeepLink_Factory(provider, provider2, provider3);
    }

    public static GenerateTransferQrDeepLink newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, GenerateLinkRepository generateLinkRepository) {
        return new GenerateTransferQrDeepLink(threadExecutor, postExecutionThread, generateLinkRepository);
    }
}
