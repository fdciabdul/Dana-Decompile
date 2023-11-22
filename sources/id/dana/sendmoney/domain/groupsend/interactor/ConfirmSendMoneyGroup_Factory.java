package id.dana.sendmoney.domain.groupsend.interactor;

import dagger.internal.Factory;
import id.dana.sendmoney.domain.groupsend.GroupSendRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class ConfirmSendMoneyGroup_Factory implements Factory<ConfirmSendMoneyGroup> {
    private final Provider<GroupSendRepository> KClassImpl$Data$declaredNonStaticMembers$2;

    private ConfirmSendMoneyGroup_Factory(Provider<GroupSendRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static ConfirmSendMoneyGroup_Factory getAuthRequestContext(Provider<GroupSendRepository> provider) {
        return new ConfirmSendMoneyGroup_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ConfirmSendMoneyGroup(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
