package id.dana.data.sendmoney.repository.source;

import dagger.internal.Factory;
import id.dana.data.sendmoney.repository.source.local.SortingSendMoneyPreference;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SortingSendMoneyPreferenceEntityDataFactory_Factory implements Factory<SortingSendMoneyPreferenceEntityDataFactory> {
    private final Provider<SortingSendMoneyPreference> sortingSendMoneyPreferenceProvider;

    public SortingSendMoneyPreferenceEntityDataFactory_Factory(Provider<SortingSendMoneyPreference> provider) {
        this.sortingSendMoneyPreferenceProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SortingSendMoneyPreferenceEntityDataFactory get() {
        return newInstance(this.sortingSendMoneyPreferenceProvider.get());
    }

    public static SortingSendMoneyPreferenceEntityDataFactory_Factory create(Provider<SortingSendMoneyPreference> provider) {
        return new SortingSendMoneyPreferenceEntityDataFactory_Factory(provider);
    }

    public static SortingSendMoneyPreferenceEntityDataFactory newInstance(SortingSendMoneyPreference sortingSendMoneyPreference) {
        return new SortingSendMoneyPreferenceEntityDataFactory(sortingSendMoneyPreference);
    }
}
