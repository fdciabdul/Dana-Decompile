package id.dana.sendmoney.data.repository.groupsend.source.split;

import dagger.internal.Factory;
import id.dana.data.toggle.SplitFacade;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SplitGroupSendEntityData_Factory implements Factory<SplitGroupSendEntityData> {
    private final Provider<SplitFacade> PlaceComponentResult;

    private SplitGroupSendEntityData_Factory(Provider<SplitFacade> provider) {
        this.PlaceComponentResult = provider;
    }

    public static SplitGroupSendEntityData_Factory MyBillsEntityDataFactory(Provider<SplitFacade> provider) {
        return new SplitGroupSendEntityData_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SplitGroupSendEntityData(this.PlaceComponentResult.get());
    }
}
