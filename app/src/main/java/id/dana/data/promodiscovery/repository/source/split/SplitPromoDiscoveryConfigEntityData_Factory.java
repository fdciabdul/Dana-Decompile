package id.dana.data.promodiscovery.repository.source.split;

import dagger.internal.Factory;
import id.dana.data.toggle.SplitFacade;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SplitPromoDiscoveryConfigEntityData_Factory implements Factory<SplitPromoDiscoveryConfigEntityData> {
    private final Provider<SplitFacade> splitFacadeProvider;

    public SplitPromoDiscoveryConfigEntityData_Factory(Provider<SplitFacade> provider) {
        this.splitFacadeProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SplitPromoDiscoveryConfigEntityData get() {
        return newInstance(this.splitFacadeProvider.get());
    }

    public static SplitPromoDiscoveryConfigEntityData_Factory create(Provider<SplitFacade> provider) {
        return new SplitPromoDiscoveryConfigEntityData_Factory(provider);
    }

    public static SplitPromoDiscoveryConfigEntityData newInstance(SplitFacade splitFacade) {
        return new SplitPromoDiscoveryConfigEntityData(splitFacade);
    }
}
