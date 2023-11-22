package id.dana.domain.deeplink.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.deeplink.repository.GenerateLinkRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GenerateProfileQrDeepLink_Factory implements Factory<GenerateProfileQrDeepLink> {
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<GenerateLinkRepository> repositoryProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public GenerateProfileQrDeepLink_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<GenerateLinkRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.repositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GenerateProfileQrDeepLink get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.repositoryProvider.get());
    }

    public static GenerateProfileQrDeepLink_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<GenerateLinkRepository> provider3) {
        return new GenerateProfileQrDeepLink_Factory(provider, provider2, provider3);
    }

    public static GenerateProfileQrDeepLink newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, GenerateLinkRepository generateLinkRepository) {
        return new GenerateProfileQrDeepLink(threadExecutor, postExecutionThread, generateLinkRepository);
    }
}
