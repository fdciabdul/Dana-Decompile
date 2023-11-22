package id.dana.domain.login.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.globalnetwork.GlobalNetworkRepository;
import id.dana.domain.homeinfo.HomeWidgetClearable;
import id.dana.domain.login.LoginRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class Logout_Factory implements Factory<Logout> {
    private final Provider<GlobalNetworkRepository> globalNetworkRepositoryProvider;
    private final Provider<HomeWidgetClearable> homeWidgetClearableProvider;
    private final Provider<LoginRepository> loginRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public Logout_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<LoginRepository> provider3, Provider<HomeWidgetClearable> provider4, Provider<GlobalNetworkRepository> provider5) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.loginRepositoryProvider = provider3;
        this.homeWidgetClearableProvider = provider4;
        this.globalNetworkRepositoryProvider = provider5;
    }

    @Override // javax.inject.Provider
    public final Logout get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.loginRepositoryProvider.get(), this.homeWidgetClearableProvider.get(), this.globalNetworkRepositoryProvider.get());
    }

    public static Logout_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<LoginRepository> provider3, Provider<HomeWidgetClearable> provider4, Provider<GlobalNetworkRepository> provider5) {
        return new Logout_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static Logout newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, LoginRepository loginRepository, HomeWidgetClearable homeWidgetClearable, GlobalNetworkRepository globalNetworkRepository) {
        return new Logout(threadExecutor, postExecutionThread, loginRepository, homeWidgetClearable, globalNetworkRepository);
    }
}
