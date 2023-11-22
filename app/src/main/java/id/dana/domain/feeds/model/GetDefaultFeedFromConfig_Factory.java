package id.dana.domain.feeds.model;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.feeds.FeedsRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetDefaultFeedFromConfig_Factory implements Factory<GetDefaultFeedFromConfig> {
    private final Provider<FeedsRepository> feedsRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public GetDefaultFeedFromConfig_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<FeedsRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.feedsRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetDefaultFeedFromConfig get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.feedsRepositoryProvider.get());
    }

    public static GetDefaultFeedFromConfig_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<FeedsRepository> provider3) {
        return new GetDefaultFeedFromConfig_Factory(provider, provider2, provider3);
    }

    public static GetDefaultFeedFromConfig newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, FeedsRepository feedsRepository) {
        return new GetDefaultFeedFromConfig(threadExecutor, postExecutionThread, feedsRepository);
    }
}
