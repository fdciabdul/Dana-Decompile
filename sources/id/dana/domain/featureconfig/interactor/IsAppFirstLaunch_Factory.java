package id.dana.domain.featureconfig.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.AppGeneralRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class IsAppFirstLaunch_Factory implements Factory<IsAppFirstLaunch> {
    private final Provider<AppGeneralRepository> appGeneralRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public IsAppFirstLaunch_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<AppGeneralRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.appGeneralRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final IsAppFirstLaunch get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.appGeneralRepositoryProvider.get());
    }

    public static IsAppFirstLaunch_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<AppGeneralRepository> provider3) {
        return new IsAppFirstLaunch_Factory(provider, provider2, provider3);
    }

    public static IsAppFirstLaunch newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, AppGeneralRepository appGeneralRepository) {
        return new IsAppFirstLaunch(threadExecutor, postExecutionThread, appGeneralRepository);
    }
}
