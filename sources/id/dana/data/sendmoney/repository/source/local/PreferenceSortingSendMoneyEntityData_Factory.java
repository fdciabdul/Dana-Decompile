package id.dana.data.sendmoney.repository.source.local;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class PreferenceSortingSendMoneyEntityData_Factory implements Factory<PreferenceSortingSendMoneyEntityData> {
    private final Provider<SortingSendMoneyPreference> sortingSendMoneyPreferenceProvider;

    public PreferenceSortingSendMoneyEntityData_Factory(Provider<SortingSendMoneyPreference> provider) {
        this.sortingSendMoneyPreferenceProvider = provider;
    }

    @Override // javax.inject.Provider
    public final PreferenceSortingSendMoneyEntityData get() {
        return newInstance(this.sortingSendMoneyPreferenceProvider.get());
    }

    public static PreferenceSortingSendMoneyEntityData_Factory create(Provider<SortingSendMoneyPreference> provider) {
        return new PreferenceSortingSendMoneyEntityData_Factory(provider);
    }

    public static PreferenceSortingSendMoneyEntityData newInstance(SortingSendMoneyPreference sortingSendMoneyPreference) {
        return new PreferenceSortingSendMoneyEntityData(sortingSendMoneyPreference);
    }
}
