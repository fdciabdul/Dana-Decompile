package id.dana.domain.synccontact.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.synccontact.SyncContactRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SyncContact_Factory implements Factory<SyncContact> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<SyncContactRepository> syncContactRepositoryProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public SyncContact_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<SyncContactRepository> provider3, Provider<FeatureConfigRepository> provider4) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.syncContactRepositoryProvider = provider3;
        this.featureConfigRepositoryProvider = provider4;
    }

    @Override // javax.inject.Provider
    public final SyncContact get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.syncContactRepositoryProvider.get(), this.featureConfigRepositoryProvider.get());
    }

    public static SyncContact_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<SyncContactRepository> provider3, Provider<FeatureConfigRepository> provider4) {
        return new SyncContact_Factory(provider, provider2, provider3, provider4);
    }

    public static SyncContact newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, SyncContactRepository syncContactRepository, FeatureConfigRepository featureConfigRepository) {
        return new SyncContact(threadExecutor, postExecutionThread, syncContactRepository, featureConfigRepository);
    }
}
