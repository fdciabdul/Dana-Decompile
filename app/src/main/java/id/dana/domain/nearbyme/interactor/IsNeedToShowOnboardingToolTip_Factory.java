package id.dana.domain.nearbyme.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.nearbyme.NearbyMeRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class IsNeedToShowOnboardingToolTip_Factory implements Factory<IsNeedToShowOnboardingToolTip> {
    private final Provider<NearbyMeRepository> nearbyMeRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public IsNeedToShowOnboardingToolTip_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<NearbyMeRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.nearbyMeRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final IsNeedToShowOnboardingToolTip get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.nearbyMeRepositoryProvider.get());
    }

    public static IsNeedToShowOnboardingToolTip_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<NearbyMeRepository> provider3) {
        return new IsNeedToShowOnboardingToolTip_Factory(provider, provider2, provider3);
    }

    public static IsNeedToShowOnboardingToolTip newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, NearbyMeRepository nearbyMeRepository) {
        return new IsNeedToShowOnboardingToolTip(threadExecutor, postExecutionThread, nearbyMeRepository);
    }
}
