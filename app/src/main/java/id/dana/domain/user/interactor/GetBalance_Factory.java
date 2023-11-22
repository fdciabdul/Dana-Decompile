package id.dana.domain.user.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.user.repository.UserRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetBalance_Factory implements Factory<GetBalance> {
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;
    private final Provider<UserRepository> userRepositoryProvider;

    public GetBalance_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<UserRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.userRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetBalance get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.userRepositoryProvider.get());
    }

    public static GetBalance_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<UserRepository> provider3) {
        return new GetBalance_Factory(provider, provider2, provider3);
    }

    public static GetBalance newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, UserRepository userRepository) {
        return new GetBalance(threadExecutor, postExecutionThread, userRepository);
    }
}
