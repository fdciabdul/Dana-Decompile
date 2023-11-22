package id.dana.domain.referral.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.referral.MyReferralConsultRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetReferralBanner_Factory implements Factory<GetReferralBanner> {
    private final Provider<MyReferralConsultRepository> myReferralConsultRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public GetReferralBanner_Factory(Provider<MyReferralConsultRepository> provider, Provider<ThreadExecutor> provider2, Provider<PostExecutionThread> provider3) {
        this.myReferralConsultRepositoryProvider = provider;
        this.threadExecutorProvider = provider2;
        this.postExecutionThreadProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetReferralBanner get() {
        return newInstance(this.myReferralConsultRepositoryProvider.get(), this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get());
    }

    public static GetReferralBanner_Factory create(Provider<MyReferralConsultRepository> provider, Provider<ThreadExecutor> provider2, Provider<PostExecutionThread> provider3) {
        return new GetReferralBanner_Factory(provider, provider2, provider3);
    }

    public static GetReferralBanner newInstance(MyReferralConsultRepository myReferralConsultRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        return new GetReferralBanner(myReferralConsultRepository, threadExecutor, postExecutionThread);
    }
}
