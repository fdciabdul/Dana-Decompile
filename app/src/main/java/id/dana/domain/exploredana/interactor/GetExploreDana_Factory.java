package id.dana.domain.exploredana.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.exploredana.repository.ExploreDanaRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetExploreDana_Factory implements Factory<GetExploreDana> {
    private final Provider<ExploreDanaRepository> exploreDanaRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public GetExploreDana_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<ExploreDanaRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.exploreDanaRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetExploreDana get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.exploreDanaRepositoryProvider.get());
    }

    public static GetExploreDana_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<ExploreDanaRepository> provider3) {
        return new GetExploreDana_Factory(provider, provider2, provider3);
    }

    public static GetExploreDana newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, ExploreDanaRepository exploreDanaRepository) {
        return new GetExploreDana(threadExecutor, postExecutionThread, exploreDanaRepository);
    }
}
