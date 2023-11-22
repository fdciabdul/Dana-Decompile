package id.dana.domain.senddigitalmoney.interactor;

import dagger.internal.Factory;
import id.dana.domain.senddigitalmoney.SendDigitalMoneyRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CheckCardNoPrefixFeature_Factory implements Factory<CheckCardNoPrefixFeature> {
    private final Provider<SendDigitalMoneyRepository> sendDigitalMoneyRepositoryProvider;

    public CheckCardNoPrefixFeature_Factory(Provider<SendDigitalMoneyRepository> provider) {
        this.sendDigitalMoneyRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CheckCardNoPrefixFeature get() {
        return newInstance(this.sendDigitalMoneyRepositoryProvider.get());
    }

    public static CheckCardNoPrefixFeature_Factory create(Provider<SendDigitalMoneyRepository> provider) {
        return new CheckCardNoPrefixFeature_Factory(provider);
    }

    public static CheckCardNoPrefixFeature newInstance(SendDigitalMoneyRepository sendDigitalMoneyRepository) {
        return new CheckCardNoPrefixFeature(sendDigitalMoneyRepository);
    }
}
