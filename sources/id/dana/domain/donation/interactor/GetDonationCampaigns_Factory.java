package id.dana.domain.donation.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.donation.DonationRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetDonationCampaigns_Factory implements Factory<GetDonationCampaigns> {
    private final Provider<DonationRepository> donationRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public GetDonationCampaigns_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<DonationRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.donationRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetDonationCampaigns get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.donationRepositoryProvider.get());
    }

    public static GetDonationCampaigns_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<DonationRepository> provider3) {
        return new GetDonationCampaigns_Factory(provider, provider2, provider3);
    }

    public static GetDonationCampaigns newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, DonationRepository donationRepository) {
        return new GetDonationCampaigns(threadExecutor, postExecutionThread, donationRepository);
    }
}
