package id.dana.domain.referral.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.referral.ReferralRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class VerifyReferralCode_Factory implements Factory<VerifyReferralCode> {
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ReferralRepository> referralRepositoryProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public VerifyReferralCode_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<ReferralRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.referralRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final VerifyReferralCode get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.referralRepositoryProvider.get());
    }

    public static VerifyReferralCode_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<ReferralRepository> provider3) {
        return new VerifyReferralCode_Factory(provider, provider2, provider3);
    }

    public static VerifyReferralCode newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, ReferralRepository referralRepository) {
        return new VerifyReferralCode(threadExecutor, postExecutionThread, referralRepository);
    }
}
