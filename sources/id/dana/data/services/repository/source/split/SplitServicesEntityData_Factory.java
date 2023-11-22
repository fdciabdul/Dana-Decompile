package id.dana.data.services.repository.source.split;

import dagger.internal.Factory;
import id.dana.data.toggle.SplitFacade;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SplitServicesEntityData_Factory implements Factory<SplitServicesEntityData> {
    private final Provider<SplitFacade> splitFacadeProvider;

    public SplitServicesEntityData_Factory(Provider<SplitFacade> provider) {
        this.splitFacadeProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SplitServicesEntityData get() {
        return newInstance(this.splitFacadeProvider.get());
    }

    public static SplitServicesEntityData_Factory create(Provider<SplitFacade> provider) {
        return new SplitServicesEntityData_Factory(provider);
    }

    public static SplitServicesEntityData newInstance(SplitFacade splitFacade) {
        return new SplitServicesEntityData(splitFacade);
    }
}
