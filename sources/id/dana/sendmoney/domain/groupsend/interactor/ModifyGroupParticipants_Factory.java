package id.dana.sendmoney.domain.groupsend.interactor;

import dagger.internal.Factory;
import id.dana.sendmoney.domain.groupsend.GroupSendRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class ModifyGroupParticipants_Factory implements Factory<ModifyGroupParticipants> {
    private final Provider<GroupSendRepository> KClassImpl$Data$declaredNonStaticMembers$2;

    private ModifyGroupParticipants_Factory(Provider<GroupSendRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static ModifyGroupParticipants_Factory getAuthRequestContext(Provider<GroupSendRepository> provider) {
        return new ModifyGroupParticipants_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ModifyGroupParticipants(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
