package id.dana.domain.feeds.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.feeds.FeedsRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class DeleteFeeds_Factory implements Factory<DeleteFeeds> {
    private final Provider<FeedsRepository> feedsRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public DeleteFeeds_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<FeedsRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.feedsRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final DeleteFeeds get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.feedsRepositoryProvider.get());
    }

    public static DeleteFeeds_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<FeedsRepository> provider3) {
        return new DeleteFeeds_Factory(provider, provider2, provider3);
    }

    public static DeleteFeeds newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, FeedsRepository feedsRepository) {
        return new DeleteFeeds(threadExecutor, postExecutionThread, feedsRepository);
    }
}
