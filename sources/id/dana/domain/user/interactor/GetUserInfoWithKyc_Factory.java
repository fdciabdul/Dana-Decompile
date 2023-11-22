package id.dana.domain.user.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.user.repository.UserRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetUserInfoWithKyc_Factory implements Factory<GetUserInfoWithKyc> {
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;
    private final Provider<UserRepository> userRepositoryProvider;

    public GetUserInfoWithKyc_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<UserRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.userRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetUserInfoWithKyc get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.userRepositoryProvider.get());
    }

    public static GetUserInfoWithKyc_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<UserRepository> provider3) {
        return new GetUserInfoWithKyc_Factory(provider, provider2, provider3);
    }

    public static GetUserInfoWithKyc newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, UserRepository userRepository) {
        return new GetUserInfoWithKyc(threadExecutor, postExecutionThread, userRepository);
    }
}
