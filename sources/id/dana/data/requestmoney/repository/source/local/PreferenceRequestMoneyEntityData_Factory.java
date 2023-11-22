package id.dana.data.requestmoney.repository.source.local;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class PreferenceRequestMoneyEntityData_Factory implements Factory<PreferenceRequestMoneyEntityData> {
    private final Provider<RequestMoneyPreference> requestMoneyPreferenceProvider;

    public PreferenceRequestMoneyEntityData_Factory(Provider<RequestMoneyPreference> provider) {
        this.requestMoneyPreferenceProvider = provider;
    }

    @Override // javax.inject.Provider
    public final PreferenceRequestMoneyEntityData get() {
        return newInstance(this.requestMoneyPreferenceProvider.get());
    }

    public static PreferenceRequestMoneyEntityData_Factory create(Provider<RequestMoneyPreference> provider) {
        return new PreferenceRequestMoneyEntityData_Factory(provider);
    }

    public static PreferenceRequestMoneyEntityData newInstance(RequestMoneyPreference requestMoneyPreference) {
        return new PreferenceRequestMoneyEntityData(requestMoneyPreference);
    }
}
