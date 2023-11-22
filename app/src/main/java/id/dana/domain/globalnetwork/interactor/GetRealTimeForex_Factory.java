package id.dana.domain.globalnetwork.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.globalnetwork.GlobalNetworkRepository;
import id.dana.domain.user.repository.UserRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetRealTimeForex_Factory implements Factory<GetRealTimeForex> {
    private final Provider<GlobalNetworkRepository> globalNetworkRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;
    private final Provider<UserRepository> userRepositoryProvider;

    public GetRealTimeForex_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<GlobalNetworkRepository> provider3, Provider<UserRepository> provider4) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.globalNetworkRepositoryProvider = provider3;
        this.userRepositoryProvider = provider4;
    }

    @Override // javax.inject.Provider
    public final GetRealTimeForex get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.globalNetworkRepositoryProvider.get(), this.userRepositoryProvider.get());
    }

    public static GetRealTimeForex_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<GlobalNetworkRepository> provider3, Provider<UserRepository> provider4) {
        return new GetRealTimeForex_Factory(provider, provider2, provider3, provider4);
    }

    public static GetRealTimeForex newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, GlobalNetworkRepository globalNetworkRepository, UserRepository userRepository) {
        return new GetRealTimeForex(threadExecutor, postExecutionThread, globalNetworkRepository, userRepository);
    }
}
