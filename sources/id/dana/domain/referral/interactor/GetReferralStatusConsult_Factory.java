package id.dana.domain.referral.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.referral.ReferralRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetReferralStatusConsult_Factory implements Factory<GetReferralStatusConsult> {
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ReferralRepository> referralRepositoryProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public GetReferralStatusConsult_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<ReferralRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.referralRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetReferralStatusConsult get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.referralRepositoryProvider.get());
    }

    public static GetReferralStatusConsult_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<ReferralRepository> provider3) {
        return new GetReferralStatusConsult_Factory(provider, provider2, provider3);
    }

    public static GetReferralStatusConsult newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, ReferralRepository referralRepository) {
        return new GetReferralStatusConsult(threadExecutor, postExecutionThread, referralRepository);
    }
}
