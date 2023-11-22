package id.dana.data.sendmoney.repository.source;

import dagger.internal.Factory;
import id.dana.data.sendmoney.repository.source.local.SendMoneyPreference;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SendMoneyPreferenceEntityDataFactory_Factory implements Factory<SendMoneyPreferenceEntityDataFactory> {
    private final Provider<SendMoneyPreference> sendMoneyPreferenceProvider;

    public SendMoneyPreferenceEntityDataFactory_Factory(Provider<SendMoneyPreference> provider) {
        this.sendMoneyPreferenceProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SendMoneyPreferenceEntityDataFactory get() {
        return newInstance(this.sendMoneyPreferenceProvider.get());
    }

    public static SendMoneyPreferenceEntityDataFactory_Factory create(Provider<SendMoneyPreference> provider) {
        return new SendMoneyPreferenceEntityDataFactory_Factory(provider);
    }

    public static SendMoneyPreferenceEntityDataFactory newInstance(SendMoneyPreference sendMoneyPreference) {
        return new SendMoneyPreferenceEntityDataFactory(sendMoneyPreference);
    }
}
