package id.dana.data.paylater.repository.source.local;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class LocalPaylaterEntityData_Factory implements Factory<LocalPaylaterEntityData> {
    private final Provider<PaylaterPreference> paylaterPreferenceProvider;

    public LocalPaylaterEntityData_Factory(Provider<PaylaterPreference> provider) {
        this.paylaterPreferenceProvider = provider;
    }

    @Override // javax.inject.Provider
    public final LocalPaylaterEntityData get() {
        return newInstance(this.paylaterPreferenceProvider.get());
    }

    public static LocalPaylaterEntityData_Factory create(Provider<PaylaterPreference> provider) {
        return new LocalPaylaterEntityData_Factory(provider);
    }

    public static LocalPaylaterEntityData newInstance(PaylaterPreference paylaterPreference) {
        return new LocalPaylaterEntityData(paylaterPreference);
    }
}
