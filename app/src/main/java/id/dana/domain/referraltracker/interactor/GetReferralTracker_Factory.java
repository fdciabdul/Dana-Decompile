package id.dana.domain.referraltracker.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.referraltracker.ReferralTrackerRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetReferralTracker_Factory implements Factory<GetReferralTracker> {
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ReferralTrackerRepository> referralTrackerRepositoryProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public GetReferralTracker_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<ReferralTrackerRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.referralTrackerRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetReferralTracker get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.referralTrackerRepositoryProvider.get());
    }

    public static GetReferralTracker_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<ReferralTrackerRepository> provider3) {
        return new GetReferralTracker_Factory(provider, provider2, provider3);
    }

    public static GetReferralTracker newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, ReferralTrackerRepository referralTrackerRepository) {
        return new GetReferralTracker(threadExecutor, postExecutionThread, referralTrackerRepository);
    }
}
