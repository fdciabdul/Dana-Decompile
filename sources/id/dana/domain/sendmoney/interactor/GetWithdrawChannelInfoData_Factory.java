package id.dana.domain.sendmoney.interactor;

import dagger.internal.Factory;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetWithdrawChannelInfoData_Factory implements Factory<GetWithdrawChannelInfoData> {
    private final Provider<SendMoneyRepository> sendMoneyRepositoryProvider;

    public GetWithdrawChannelInfoData_Factory(Provider<SendMoneyRepository> provider) {
        this.sendMoneyRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetWithdrawChannelInfoData get() {
        return newInstance(this.sendMoneyRepositoryProvider.get());
    }

    public static GetWithdrawChannelInfoData_Factory create(Provider<SendMoneyRepository> provider) {
        return new GetWithdrawChannelInfoData_Factory(provider);
    }

    public static GetWithdrawChannelInfoData newInstance(SendMoneyRepository sendMoneyRepository) {
        return new GetWithdrawChannelInfoData(sendMoneyRepository);
    }
}
