package id.dana.domain.playstorereview.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.playstorereview.repository.PlayStoreReviewRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SaveLastPlayStoreReviewShow_Factory implements Factory<SaveLastPlayStoreReviewShow> {
    private final Provider<PlayStoreReviewRepository> playStoreReviewRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public SaveLastPlayStoreReviewShow_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<PlayStoreReviewRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.playStoreReviewRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final SaveLastPlayStoreReviewShow get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.playStoreReviewRepositoryProvider.get());
    }

    public static SaveLastPlayStoreReviewShow_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<PlayStoreReviewRepository> provider3) {
        return new SaveLastPlayStoreReviewShow_Factory(provider, provider2, provider3);
    }

    public static SaveLastPlayStoreReviewShow newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, PlayStoreReviewRepository playStoreReviewRepository) {
        return new SaveLastPlayStoreReviewShow(threadExecutor, postExecutionThread, playStoreReviewRepository);
    }
}
