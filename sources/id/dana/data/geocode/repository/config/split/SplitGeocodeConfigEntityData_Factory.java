package id.dana.data.geocode.repository.config.split;

import dagger.internal.Factory;
import id.dana.data.toggle.SplitFacade;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SplitGeocodeConfigEntityData_Factory implements Factory<SplitGeocodeConfigEntityData> {
    private final Provider<SplitFacade> splitFacadeProvider;

    public SplitGeocodeConfigEntityData_Factory(Provider<SplitFacade> provider) {
        this.splitFacadeProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SplitGeocodeConfigEntityData get() {
        return newInstance(this.splitFacadeProvider.get());
    }

    public static SplitGeocodeConfigEntityData_Factory create(Provider<SplitFacade> provider) {
        return new SplitGeocodeConfigEntityData_Factory(provider);
    }

    public static SplitGeocodeConfigEntityData newInstance(SplitFacade splitFacade) {
        return new SplitGeocodeConfigEntityData(splitFacade);
    }
}
