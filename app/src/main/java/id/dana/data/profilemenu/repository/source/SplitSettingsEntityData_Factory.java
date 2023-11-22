package id.dana.data.profilemenu.repository.source;

import dagger.internal.Factory;
import id.dana.data.toggle.SplitFacade;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SplitSettingsEntityData_Factory implements Factory<SplitSettingsEntityData> {
    private final Provider<SplitFacade> splitFacadeProvider;

    public SplitSettingsEntityData_Factory(Provider<SplitFacade> provider) {
        this.splitFacadeProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SplitSettingsEntityData get() {
        return newInstance(this.splitFacadeProvider.get());
    }

    public static SplitSettingsEntityData_Factory create(Provider<SplitFacade> provider) {
        return new SplitSettingsEntityData_Factory(provider);
    }

    public static SplitSettingsEntityData newInstance(SplitFacade splitFacade) {
        return new SplitSettingsEntityData(splitFacade);
    }
}
