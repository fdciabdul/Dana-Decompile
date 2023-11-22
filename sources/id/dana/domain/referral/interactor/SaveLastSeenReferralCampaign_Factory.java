package id.dana.domain.referral.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.referral.MyReferralConsultRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SaveLastSeenReferralCampaign_Factory implements Factory<SaveLastSeenReferralCampaign> {
    private final Provider<MyReferralConsultRepository> myReferralConsultRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public SaveLastSeenReferralCampaign_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<MyReferralConsultRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.myReferralConsultRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final SaveLastSeenReferralCampaign get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.myReferralConsultRepositoryProvider.get());
    }

    public static SaveLastSeenReferralCampaign_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<MyReferralConsultRepository> provider3) {
        return new SaveLastSeenReferralCampaign_Factory(provider, provider2, provider3);
    }

    public static SaveLastSeenReferralCampaign newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, MyReferralConsultRepository myReferralConsultRepository) {
        return new SaveLastSeenReferralCampaign(threadExecutor, postExecutionThread, myReferralConsultRepository);
    }
}
