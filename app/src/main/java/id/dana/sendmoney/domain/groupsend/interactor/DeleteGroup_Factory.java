package id.dana.sendmoney.domain.groupsend.interactor;

import dagger.internal.Factory;
import id.dana.sendmoney.domain.groupsend.GroupSendRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class DeleteGroup_Factory implements Factory<DeleteGroup> {
    private final Provider<GroupSendRepository> KClassImpl$Data$declaredNonStaticMembers$2;

    private DeleteGroup_Factory(Provider<GroupSendRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static DeleteGroup_Factory BuiltInFictitiousFunctionClassFactory(Provider<GroupSendRepository> provider) {
        return new DeleteGroup_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DeleteGroup(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
