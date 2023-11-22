package id.dana.domain.synccontact.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.synccontact.SyncContactRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SyncOneContact_Factory implements Factory<SyncOneContact> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<SyncContactRepository> syncContactRepositoryProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public SyncOneContact_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<SyncContactRepository> provider3, Provider<FeatureConfigRepository> provider4) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.syncContactRepositoryProvider = provider3;
        this.featureConfigRepositoryProvider = provider4;
    }

    @Override // javax.inject.Provider
    public final SyncOneContact get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.syncContactRepositoryProvider.get(), this.featureConfigRepositoryProvider.get());
    }

    public static SyncOneContact_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<SyncContactRepository> provider3, Provider<FeatureConfigRepository> provider4) {
        return new SyncOneContact_Factory(provider, provider2, provider3, provider4);
    }

    public static SyncOneContact newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, SyncContactRepository syncContactRepository, FeatureConfigRepository featureConfigRepository) {
        return new SyncOneContact(threadExecutor, postExecutionThread, syncContactRepository, featureConfigRepository);
    }
}
