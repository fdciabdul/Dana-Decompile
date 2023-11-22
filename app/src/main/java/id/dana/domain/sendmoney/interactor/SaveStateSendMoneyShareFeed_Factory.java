package id.dana.domain.sendmoney.interactor;

import dagger.internal.Factory;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SaveStateSendMoneyShareFeed_Factory implements Factory<SaveStateSendMoneyShareFeed> {
    private final Provider<SendMoneyRepository> sendMoneyRepositoryProvider;

    public SaveStateSendMoneyShareFeed_Factory(Provider<SendMoneyRepository> provider) {
        this.sendMoneyRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SaveStateSendMoneyShareFeed get() {
        return newInstance(this.sendMoneyRepositoryProvider.get());
    }

    public static SaveStateSendMoneyShareFeed_Factory create(Provider<SendMoneyRepository> provider) {
        return new SaveStateSendMoneyShareFeed_Factory(provider);
    }

    public static SaveStateSendMoneyShareFeed newInstance(SendMoneyRepository sendMoneyRepository) {
        return new SaveStateSendMoneyShareFeed(sendMoneyRepository);
    }
}
