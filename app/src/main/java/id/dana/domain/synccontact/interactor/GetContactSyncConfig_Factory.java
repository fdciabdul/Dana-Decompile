package id.dana.domain.synccontact.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.synccontact.SyncContactRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class GetContactSyncConfig_Factory implements Factory<GetContactSyncConfig> {
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<SyncContactRepository> syncContactRepositoryProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public GetContactSyncConfig_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<SyncContactRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.syncContactRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetContactSyncConfig get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.syncContactRepositoryProvider.get());
    }

    public static GetContactSyncConfig_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<SyncContactRepository> provider3) {
        return new GetContactSyncConfig_Factory(provider, provider2, provider3);
    }

    public static GetContactSyncConfig newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, SyncContactRepository syncContactRepository) {
        return new GetContactSyncConfig(threadExecutor, postExecutionThread, syncContactRepository);
    }
}
