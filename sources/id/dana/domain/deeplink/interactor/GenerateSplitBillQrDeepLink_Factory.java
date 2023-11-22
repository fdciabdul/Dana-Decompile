package id.dana.domain.deeplink.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.deeplink.repository.GenerateLinkRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GenerateSplitBillQrDeepLink_Factory implements Factory<GenerateSplitBillQrDeepLink> {
    private final Provider<GenerateLinkRepository> generateLinkRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public GenerateSplitBillQrDeepLink_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<GenerateLinkRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.generateLinkRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GenerateSplitBillQrDeepLink get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.generateLinkRepositoryProvider.get());
    }

    public static GenerateSplitBillQrDeepLink_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<GenerateLinkRepository> provider3) {
        return new GenerateSplitBillQrDeepLink_Factory(provider, provider2, provider3);
    }

    public static GenerateSplitBillQrDeepLink newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, GenerateLinkRepository generateLinkRepository) {
        return new GenerateSplitBillQrDeepLink(threadExecutor, postExecutionThread, generateLinkRepository);
    }
}
