package id.dana.domain.referral.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.referral.MyReferralConsultRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetReferralConsult_Factory implements Factory<GetReferralConsult> {
    private final Provider<MyReferralConsultRepository> myReferralConsultRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public GetReferralConsult_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<MyReferralConsultRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.myReferralConsultRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetReferralConsult get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.myReferralConsultRepositoryProvider.get());
    }

    public static GetReferralConsult_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<MyReferralConsultRepository> provider3) {
        return new GetReferralConsult_Factory(provider, provider2, provider3);
    }

    public static GetReferralConsult newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, MyReferralConsultRepository myReferralConsultRepository) {
        return new GetReferralConsult(threadExecutor, postExecutionThread, myReferralConsultRepository);
    }
}
