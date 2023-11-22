package id.dana.data.globalnetwork.source.split;

import dagger.internal.Factory;
import id.dana.data.toggle.SplitFacade;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SplitGnConfigEntityData_Factory implements Factory<SplitGnConfigEntityData> {
    private final Provider<SplitFacade> splitFacadeProvider;

    public SplitGnConfigEntityData_Factory(Provider<SplitFacade> provider) {
        this.splitFacadeProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SplitGnConfigEntityData get() {
        return newInstance(this.splitFacadeProvider.get());
    }

    public static SplitGnConfigEntityData_Factory create(Provider<SplitFacade> provider) {
        return new SplitGnConfigEntityData_Factory(provider);
    }

    public static SplitGnConfigEntityData newInstance(SplitFacade splitFacade) {
        return new SplitGnConfigEntityData(splitFacade);
    }
}
