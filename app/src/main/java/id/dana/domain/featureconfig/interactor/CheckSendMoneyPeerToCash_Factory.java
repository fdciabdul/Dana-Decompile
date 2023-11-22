package id.dana.domain.featureconfig.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CheckSendMoneyPeerToCash_Factory implements Factory<CheckSendMoneyPeerToCash> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public CheckSendMoneyPeerToCash_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<FeatureConfigRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.featureConfigRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final CheckSendMoneyPeerToCash get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.featureConfigRepositoryProvider.get());
    }

    public static CheckSendMoneyPeerToCash_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<FeatureConfigRepository> provider3) {
        return new CheckSendMoneyPeerToCash_Factory(provider, provider2, provider3);
    }

    public static CheckSendMoneyPeerToCash newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, FeatureConfigRepository featureConfigRepository) {
        return new CheckSendMoneyPeerToCash(threadExecutor, postExecutionThread, featureConfigRepository);
    }
}
