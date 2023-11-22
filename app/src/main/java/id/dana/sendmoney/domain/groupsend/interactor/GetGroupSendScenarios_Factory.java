package id.dana.sendmoney.domain.groupsend.interactor;

import dagger.internal.Factory;
import id.dana.sendmoney.domain.groupsend.GroupSendRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetGroupSendScenarios_Factory implements Factory<GetGroupSendScenarios> {
    private final Provider<GroupSendRepository> BuiltInFictitiousFunctionClassFactory;

    private GetGroupSendScenarios_Factory(Provider<GroupSendRepository> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static GetGroupSendScenarios_Factory MyBillsEntityDataFactory(Provider<GroupSendRepository> provider) {
        return new GetGroupSendScenarios_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetGroupSendScenarios(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
