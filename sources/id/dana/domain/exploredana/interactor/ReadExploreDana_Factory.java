package id.dana.domain.exploredana.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.exploredana.repository.ExploreDanaRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class ReadExploreDana_Factory implements Factory<ReadExploreDana> {
    private final Provider<ExploreDanaRepository> exploreDanaRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public ReadExploreDana_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<ExploreDanaRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.exploreDanaRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final ReadExploreDana get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.exploreDanaRepositoryProvider.get());
    }

    public static ReadExploreDana_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<ExploreDanaRepository> provider3) {
        return new ReadExploreDana_Factory(provider, provider2, provider3);
    }

    public static ReadExploreDana newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, ExploreDanaRepository exploreDanaRepository) {
        return new ReadExploreDana(threadExecutor, postExecutionThread, exploreDanaRepository);
    }
}
