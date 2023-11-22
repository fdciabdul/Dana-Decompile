package id.dana.data.sendmoney.repository.source.split;

import dagger.internal.Factory;
import id.dana.data.toggle.SplitFacade;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SplitSendMoneyScenariosEntityData_Factory implements Factory<SplitSendMoneyScenariosEntityData> {
    private final Provider<SplitFacade> splitFacadeProvider;

    public SplitSendMoneyScenariosEntityData_Factory(Provider<SplitFacade> provider) {
        this.splitFacadeProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SplitSendMoneyScenariosEntityData get() {
        return newInstance(this.splitFacadeProvider.get());
    }

    public static SplitSendMoneyScenariosEntityData_Factory create(Provider<SplitFacade> provider) {
        return new SplitSendMoneyScenariosEntityData_Factory(provider);
    }

    public static SplitSendMoneyScenariosEntityData newInstance(SplitFacade splitFacade) {
        return new SplitSendMoneyScenariosEntityData(splitFacade);
    }
}
