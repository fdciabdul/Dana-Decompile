package id.dana.domain.featureconfig.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class CheckTransferToBankFeature_Factory implements Factory<CheckTransferToBankFeature> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public CheckTransferToBankFeature_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<FeatureConfigRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.featureConfigRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final CheckTransferToBankFeature get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.featureConfigRepositoryProvider.get());
    }

    public static CheckTransferToBankFeature_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<FeatureConfigRepository> provider3) {
        return new CheckTransferToBankFeature_Factory(provider, provider2, provider3);
    }

    public static CheckTransferToBankFeature newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, FeatureConfigRepository featureConfigRepository) {
        return new CheckTransferToBankFeature(threadExecutor, postExecutionThread, featureConfigRepository);
    }
}
