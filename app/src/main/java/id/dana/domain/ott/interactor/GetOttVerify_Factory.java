package id.dana.domain.ott.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.ott.repository.OttRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetOttVerify_Factory implements Factory<GetOttVerify> {
    private final Provider<OttRepository> ottRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public GetOttVerify_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<OttRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.ottRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetOttVerify get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.ottRepositoryProvider.get());
    }

    public static GetOttVerify_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<OttRepository> provider3) {
        return new GetOttVerify_Factory(provider, provider2, provider3);
    }

    public static GetOttVerify newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, OttRepository ottRepository) {
        return new GetOttVerify(threadExecutor, postExecutionThread, ottRepository);
    }
}
