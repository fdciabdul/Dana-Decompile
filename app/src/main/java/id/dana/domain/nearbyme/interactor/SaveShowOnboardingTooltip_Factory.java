package id.dana.domain.nearbyme.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.nearbyme.NearbyMeRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SaveShowOnboardingTooltip_Factory implements Factory<SaveShowOnboardingTooltip> {
    private final Provider<NearbyMeRepository> nearbyMeRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public SaveShowOnboardingTooltip_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<NearbyMeRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.nearbyMeRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final SaveShowOnboardingTooltip get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.nearbyMeRepositoryProvider.get());
    }

    public static SaveShowOnboardingTooltip_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<NearbyMeRepository> provider3) {
        return new SaveShowOnboardingTooltip_Factory(provider, provider2, provider3);
    }

    public static SaveShowOnboardingTooltip newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, NearbyMeRepository nearbyMeRepository) {
        return new SaveShowOnboardingTooltip(threadExecutor, postExecutionThread, nearbyMeRepository);
    }
}
