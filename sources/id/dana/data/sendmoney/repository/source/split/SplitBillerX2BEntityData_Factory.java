package id.dana.data.sendmoney.repository.source.split;

import dagger.internal.Factory;
import id.dana.data.toggle.SplitFacade;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SplitBillerX2BEntityData_Factory implements Factory<SplitBillerX2BEntityData> {
    private final Provider<SplitFacade> splitFacadeProvider;

    public SplitBillerX2BEntityData_Factory(Provider<SplitFacade> provider) {
        this.splitFacadeProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SplitBillerX2BEntityData get() {
        return newInstance(this.splitFacadeProvider.get());
    }

    public static SplitBillerX2BEntityData_Factory create(Provider<SplitFacade> provider) {
        return new SplitBillerX2BEntityData_Factory(provider);
    }

    public static SplitBillerX2BEntityData newInstance(SplitFacade splitFacade) {
        return new SplitBillerX2BEntityData(splitFacade);
    }
}
