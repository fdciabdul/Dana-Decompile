package id.dana.data.requestmoney.repository.source.split;

import dagger.internal.Factory;
import id.dana.data.toggle.SplitFacade;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SplitRequestMoneyEntityData_Factory implements Factory<SplitRequestMoneyEntityData> {
    private final Provider<SplitFacade> splitFacadeProvider;

    public SplitRequestMoneyEntityData_Factory(Provider<SplitFacade> provider) {
        this.splitFacadeProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SplitRequestMoneyEntityData get() {
        return newInstance(this.splitFacadeProvider.get());
    }

    public static SplitRequestMoneyEntityData_Factory create(Provider<SplitFacade> provider) {
        return new SplitRequestMoneyEntityData_Factory(provider);
    }

    public static SplitRequestMoneyEntityData newInstance(SplitFacade splitFacade) {
        return new SplitRequestMoneyEntityData(splitFacade);
    }
}
