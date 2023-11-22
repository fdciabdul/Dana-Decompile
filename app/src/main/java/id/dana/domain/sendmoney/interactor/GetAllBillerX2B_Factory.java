package id.dana.domain.sendmoney.interactor;

import dagger.internal.Factory;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetAllBillerX2B_Factory implements Factory<GetAllBillerX2B> {
    private final Provider<SendMoneyRepository> sendMoneyRepositoryProvider;

    public GetAllBillerX2B_Factory(Provider<SendMoneyRepository> provider) {
        this.sendMoneyRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetAllBillerX2B get() {
        return newInstance(this.sendMoneyRepositoryProvider.get());
    }

    public static GetAllBillerX2B_Factory create(Provider<SendMoneyRepository> provider) {
        return new GetAllBillerX2B_Factory(provider);
    }

    public static GetAllBillerX2B newInstance(SendMoneyRepository sendMoneyRepository) {
        return new GetAllBillerX2B(sendMoneyRepository);
    }
}
