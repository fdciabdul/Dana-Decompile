package id.dana.domain.sendmoney.interactor;

import dagger.internal.Factory;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetSendMoneyScenarios_Factory implements Factory<GetSendMoneyScenarios> {
    private final Provider<SendMoneyRepository> sendMoneyRepositoryProvider;

    public GetSendMoneyScenarios_Factory(Provider<SendMoneyRepository> provider) {
        this.sendMoneyRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetSendMoneyScenarios get() {
        return newInstance(this.sendMoneyRepositoryProvider.get());
    }

    public static GetSendMoneyScenarios_Factory create(Provider<SendMoneyRepository> provider) {
        return new GetSendMoneyScenarios_Factory(provider);
    }

    public static GetSendMoneyScenarios newInstance(SendMoneyRepository sendMoneyRepository) {
        return new GetSendMoneyScenarios(sendMoneyRepository);
    }
}
