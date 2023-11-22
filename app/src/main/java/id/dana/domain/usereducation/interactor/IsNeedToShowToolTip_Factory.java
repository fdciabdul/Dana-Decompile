package id.dana.domain.usereducation.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.usereducation.repository.UserEducationRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class IsNeedToShowToolTip_Factory implements Factory<IsNeedToShowToolTip> {
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;
    private final Provider<UserEducationRepository> userEducationRepositoryProvider;

    public IsNeedToShowToolTip_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<UserEducationRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.userEducationRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final IsNeedToShowToolTip get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.userEducationRepositoryProvider.get());
    }

    public static IsNeedToShowToolTip_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<UserEducationRepository> provider3) {
        return new IsNeedToShowToolTip_Factory(provider, provider2, provider3);
    }

    public static IsNeedToShowToolTip newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, UserEducationRepository userEducationRepository) {
        return new IsNeedToShowToolTip(threadExecutor, postExecutionThread, userEducationRepository);
    }
}
