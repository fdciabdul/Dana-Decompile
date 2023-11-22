package id.dana.domain.oauth.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.oauth.repository.OauthRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GnAuthApply_Factory implements Factory<GnAuthApply> {
    private final Provider<OauthRepository> oauthRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public GnAuthApply_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<OauthRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.oauthRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GnAuthApply get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.oauthRepositoryProvider.get());
    }

    public static GnAuthApply_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<OauthRepository> provider3) {
        return new GnAuthApply_Factory(provider, provider2, provider3);
    }

    public static GnAuthApply newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, OauthRepository oauthRepository) {
        return new GnAuthApply(threadExecutor, postExecutionThread, oauthRepository);
    }
}
