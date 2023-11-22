package id.dana.domain.oauth.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.oauth.repository.OauthRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ConfirmScopes_Factory implements Factory<ConfirmScopes> {
    private final Provider<OauthRepository> oauthRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public ConfirmScopes_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<OauthRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.oauthRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final ConfirmScopes get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.oauthRepositoryProvider.get());
    }

    public static ConfirmScopes_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<OauthRepository> provider3) {
        return new ConfirmScopes_Factory(provider, provider2, provider3);
    }

    public static ConfirmScopes newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, OauthRepository oauthRepository) {
        return new ConfirmScopes(threadExecutor, postExecutionThread, oauthRepository);
    }
}
