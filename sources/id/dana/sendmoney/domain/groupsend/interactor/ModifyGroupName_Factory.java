package id.dana.sendmoney.domain.groupsend.interactor;

import dagger.internal.Factory;
import id.dana.sendmoney.domain.groupsend.GroupSendRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class ModifyGroupName_Factory implements Factory<ModifyGroupName> {
    private final Provider<GroupSendRepository> KClassImpl$Data$declaredNonStaticMembers$2;

    private ModifyGroupName_Factory(Provider<GroupSendRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static ModifyGroupName_Factory BuiltInFictitiousFunctionClassFactory(Provider<GroupSendRepository> provider) {
        return new ModifyGroupName_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ModifyGroupName(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
