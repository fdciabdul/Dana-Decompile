package id.dana.domain.globalnetwork.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.globalnetwork.GlobalNetworkRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class IsAlipayConnectServiceFirstTime_Factory implements Factory<IsAlipayConnectServiceFirstTime> {
    private final Provider<GlobalNetworkRepository> globalNetworkRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public IsAlipayConnectServiceFirstTime_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<GlobalNetworkRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.globalNetworkRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final IsAlipayConnectServiceFirstTime get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.globalNetworkRepositoryProvider.get());
    }

    public static IsAlipayConnectServiceFirstTime_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<GlobalNetworkRepository> provider3) {
        return new IsAlipayConnectServiceFirstTime_Factory(provider, provider2, provider3);
    }

    public static IsAlipayConnectServiceFirstTime newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, GlobalNetworkRepository globalNetworkRepository) {
        return new IsAlipayConnectServiceFirstTime(threadExecutor, postExecutionThread, globalNetworkRepository);
    }
}
