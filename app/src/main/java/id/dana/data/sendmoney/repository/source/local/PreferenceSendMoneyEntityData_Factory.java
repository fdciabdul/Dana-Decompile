package id.dana.data.sendmoney.repository.source.local;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class PreferenceSendMoneyEntityData_Factory implements Factory<PreferenceSendMoneyEntityData> {
    private final Provider<SendMoneyPreference> sendMoneyPreferenceProvider;

    public PreferenceSendMoneyEntityData_Factory(Provider<SendMoneyPreference> provider) {
        this.sendMoneyPreferenceProvider = provider;
    }

    @Override // javax.inject.Provider
    public final PreferenceSendMoneyEntityData get() {
        return newInstance(this.sendMoneyPreferenceProvider.get());
    }

    public static PreferenceSendMoneyEntityData_Factory create(Provider<SendMoneyPreference> provider) {
        return new PreferenceSendMoneyEntityData_Factory(provider);
    }

    public static PreferenceSendMoneyEntityData newInstance(SendMoneyPreference sendMoneyPreference) {
        return new PreferenceSendMoneyEntityData(sendMoneyPreference);
    }
}
