package id.dana.sendmoney.data.repository.groupsend.source;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GroupSendEntityDataFactory_Factory implements Factory<GroupSendEntityDataFactory> {
    private final Provider<GroupSendEntityData> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GroupSendEntityData> MyBillsEntityDataFactory;
    private final Provider<GroupSendEntityData> PlaceComponentResult;

    private GroupSendEntityDataFactory_Factory(Provider<GroupSendEntityData> provider, Provider<GroupSendEntityData> provider2, Provider<GroupSendEntityData> provider3) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.MyBillsEntityDataFactory = provider2;
        this.PlaceComponentResult = provider3;
    }

    public static GroupSendEntityDataFactory_Factory PlaceComponentResult(Provider<GroupSendEntityData> provider, Provider<GroupSendEntityData> provider2, Provider<GroupSendEntityData> provider3) {
        return new GroupSendEntityDataFactory_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GroupSendEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get(), this.PlaceComponentResult.get());
    }
}
