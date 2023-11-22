package id.dana.domain.oauth.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.oauth.repository.OauthRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GnAuthAgreement_Factory implements Factory<GnAuthAgreement> {
    private final Provider<OauthRepository> oauthRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public GnAuthAgreement_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<OauthRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.oauthRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GnAuthAgreement get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.oauthRepositoryProvider.get());
    }

    public static GnAuthAgreement_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<OauthRepository> provider3) {
        return new GnAuthAgreement_Factory(provider, provider2, provider3);
    }

    public static GnAuthAgreement newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, OauthRepository oauthRepository) {
        return new GnAuthAgreement(threadExecutor, postExecutionThread, oauthRepository);
    }
}
