package id.dana.data.saving.repository.source.split;

import dagger.internal.Factory;
import id.dana.data.toggle.SplitFacade;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SplitSavingConfigEntityData_Factory implements Factory<SplitSavingConfigEntityData> {
    private final Provider<SplitFacade> splitFacadeProvider;

    public SplitSavingConfigEntityData_Factory(Provider<SplitFacade> provider) {
        this.splitFacadeProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SplitSavingConfigEntityData get() {
        return newInstance(this.splitFacadeProvider.get());
    }

    public static SplitSavingConfigEntityData_Factory create(Provider<SplitFacade> provider) {
        return new SplitSavingConfigEntityData_Factory(provider);
    }

    public static SplitSavingConfigEntityData newInstance(SplitFacade splitFacade) {
        return new SplitSavingConfigEntityData(splitFacade);
    }
}
