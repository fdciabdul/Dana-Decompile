package id.dana.domain.referralconfig.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.referralconfig.ReferralConfigRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetReferralHomeConfig_Factory implements Factory<GetReferralHomeConfig> {
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ReferralConfigRepository> referralConfigRepositoryProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public GetReferralHomeConfig_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<ReferralConfigRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.referralConfigRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetReferralHomeConfig get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.referralConfigRepositoryProvider.get());
    }

    public static GetReferralHomeConfig_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<ReferralConfigRepository> provider3) {
        return new GetReferralHomeConfig_Factory(provider, provider2, provider3);
    }

    public static GetReferralHomeConfig newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, ReferralConfigRepository referralConfigRepository) {
        return new GetReferralHomeConfig(threadExecutor, postExecutionThread, referralConfigRepository);
    }
}
