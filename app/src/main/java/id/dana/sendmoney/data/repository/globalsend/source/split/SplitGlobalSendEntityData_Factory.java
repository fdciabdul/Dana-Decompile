package id.dana.sendmoney.data.repository.globalsend.source.split;

import dagger.internal.Factory;
import id.dana.data.toggle.SplitFacade;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SplitGlobalSendEntityData_Factory implements Factory<SplitGlobalSendEntityData> {
    private final Provider<SplitFacade> MyBillsEntityDataFactory;

    private SplitGlobalSendEntityData_Factory(Provider<SplitFacade> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static SplitGlobalSendEntityData_Factory PlaceComponentResult(Provider<SplitFacade> provider) {
        return new SplitGlobalSendEntityData_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SplitGlobalSendEntityData(this.MyBillsEntityDataFactory.get());
    }
}
