package id.dana.data.paylater.repository.source.split;

import dagger.internal.Factory;
import id.dana.data.toggle.SplitFacade;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SplitPaylaterEntityData_Factory implements Factory<SplitPaylaterEntityData> {
    private final Provider<SplitFacade> splitFacadeProvider;

    public SplitPaylaterEntityData_Factory(Provider<SplitFacade> provider) {
        this.splitFacadeProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SplitPaylaterEntityData get() {
        return newInstance(this.splitFacadeProvider.get());
    }

    public static SplitPaylaterEntityData_Factory create(Provider<SplitFacade> provider) {
        return new SplitPaylaterEntityData_Factory(provider);
    }

    public static SplitPaylaterEntityData newInstance(SplitFacade splitFacade) {
        return new SplitPaylaterEntityData(splitFacade);
    }
}
