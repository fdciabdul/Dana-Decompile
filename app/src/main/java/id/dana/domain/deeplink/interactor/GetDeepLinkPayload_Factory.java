package id.dana.domain.deeplink.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.deeplink.repository.DeepLinkRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetDeepLinkPayload_Factory implements Factory<GetDeepLinkPayload> {
    private final Provider<DeepLinkRepository> deepLinkRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public GetDeepLinkPayload_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<DeepLinkRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.deepLinkRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetDeepLinkPayload get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.deepLinkRepositoryProvider.get());
    }

    public static GetDeepLinkPayload_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<DeepLinkRepository> provider3) {
        return new GetDeepLinkPayload_Factory(provider, provider2, provider3);
    }

    public static GetDeepLinkPayload newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, DeepLinkRepository deepLinkRepository) {
        return new GetDeepLinkPayload(threadExecutor, postExecutionThread, deepLinkRepository);
    }
}
