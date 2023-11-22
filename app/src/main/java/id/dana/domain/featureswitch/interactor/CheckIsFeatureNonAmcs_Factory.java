package id.dana.domain.featureswitch.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureswitch.FeatureNonAmcsRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class CheckIsFeatureNonAmcs_Factory implements Factory<CheckIsFeatureNonAmcs> {
    private final Provider<FeatureNonAmcsRepository> featureNonAmcsRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public CheckIsFeatureNonAmcs_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<FeatureNonAmcsRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.featureNonAmcsRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final CheckIsFeatureNonAmcs get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.featureNonAmcsRepositoryProvider.get());
    }

    public static CheckIsFeatureNonAmcs_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<FeatureNonAmcsRepository> provider3) {
        return new CheckIsFeatureNonAmcs_Factory(provider, provider2, provider3);
    }

    public static CheckIsFeatureNonAmcs newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, FeatureNonAmcsRepository featureNonAmcsRepository) {
        return new CheckIsFeatureNonAmcs(threadExecutor, postExecutionThread, featureNonAmcsRepository);
    }
}
