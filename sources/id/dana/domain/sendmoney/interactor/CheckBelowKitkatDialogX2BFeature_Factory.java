package id.dana.domain.sendmoney.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CheckBelowKitkatDialogX2BFeature_Factory implements Factory<CheckBelowKitkatDialogX2BFeature> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public CheckBelowKitkatDialogX2BFeature_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<FeatureConfigRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.featureConfigRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final CheckBelowKitkatDialogX2BFeature get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.featureConfigRepositoryProvider.get());
    }

    public static CheckBelowKitkatDialogX2BFeature_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<FeatureConfigRepository> provider3) {
        return new CheckBelowKitkatDialogX2BFeature_Factory(provider, provider2, provider3);
    }

    public static CheckBelowKitkatDialogX2BFeature newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, FeatureConfigRepository featureConfigRepository) {
        return new CheckBelowKitkatDialogX2BFeature(threadExecutor, postExecutionThread, featureConfigRepository);
    }
}
