package id.dana.domain.login.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.login.LoginRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class VerifyPushLogin_Factory implements Factory<VerifyPushLogin> {
    private final Provider<LoginRepository> loginRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public VerifyPushLogin_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<LoginRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.loginRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final VerifyPushLogin get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.loginRepositoryProvider.get());
    }

    public static VerifyPushLogin_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<LoginRepository> provider3) {
        return new VerifyPushLogin_Factory(provider, provider2, provider3);
    }

    public static VerifyPushLogin newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, LoginRepository loginRepository) {
        return new VerifyPushLogin(threadExecutor, postExecutionThread, loginRepository);
    }
}
