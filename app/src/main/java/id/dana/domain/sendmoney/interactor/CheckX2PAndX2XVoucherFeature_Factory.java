package id.dana.domain.sendmoney.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CheckX2PAndX2XVoucherFeature_Factory implements Factory<CheckX2PAndX2XVoucherFeature> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public CheckX2PAndX2XVoucherFeature_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<FeatureConfigRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.featureConfigRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final CheckX2PAndX2XVoucherFeature get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.featureConfigRepositoryProvider.get());
    }

    public static CheckX2PAndX2XVoucherFeature_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<FeatureConfigRepository> provider3) {
        return new CheckX2PAndX2XVoucherFeature_Factory(provider, provider2, provider3);
    }

    public static CheckX2PAndX2XVoucherFeature newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, FeatureConfigRepository featureConfigRepository) {
        return new CheckX2PAndX2XVoucherFeature(threadExecutor, postExecutionThread, featureConfigRepository);
    }
}
