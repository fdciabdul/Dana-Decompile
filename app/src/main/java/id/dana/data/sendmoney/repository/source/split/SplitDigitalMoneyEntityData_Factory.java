package id.dana.data.sendmoney.repository.source.split;

import dagger.internal.Factory;
import id.dana.data.toggle.SplitFacade;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SplitDigitalMoneyEntityData_Factory implements Factory<SplitDigitalMoneyEntityData> {
    private final Provider<SplitFacade> splitFacadeProvider;

    public SplitDigitalMoneyEntityData_Factory(Provider<SplitFacade> provider) {
        this.splitFacadeProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SplitDigitalMoneyEntityData get() {
        return newInstance(this.splitFacadeProvider.get());
    }

    public static SplitDigitalMoneyEntityData_Factory create(Provider<SplitFacade> provider) {
        return new SplitDigitalMoneyEntityData_Factory(provider);
    }

    public static SplitDigitalMoneyEntityData newInstance(SplitFacade splitFacade) {
        return new SplitDigitalMoneyEntityData(splitFacade);
    }
}
