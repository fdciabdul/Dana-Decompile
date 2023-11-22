package id.dana.domain.feeds.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.feeds.FeedsRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetGlobalFeeds_Factory implements Factory<GetGlobalFeeds> {
    private final Provider<FeedsRepository> feedsRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public GetGlobalFeeds_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<FeedsRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.feedsRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetGlobalFeeds get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.feedsRepositoryProvider.get());
    }

    public static GetGlobalFeeds_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<FeedsRepository> provider3) {
        return new GetGlobalFeeds_Factory(provider, provider2, provider3);
    }

    public static GetGlobalFeeds newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, FeedsRepository feedsRepository) {
        return new GetGlobalFeeds(threadExecutor, postExecutionThread, feedsRepository);
    }
}
