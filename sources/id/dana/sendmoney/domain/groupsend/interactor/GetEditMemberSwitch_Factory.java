package id.dana.sendmoney.domain.groupsend.interactor;

import dagger.internal.Factory;
import id.dana.sendmoney.domain.groupsend.GroupSendRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetEditMemberSwitch_Factory implements Factory<GetEditMemberSwitch> {
    private final Provider<GroupSendRepository> KClassImpl$Data$declaredNonStaticMembers$2;

    private GetEditMemberSwitch_Factory(Provider<GroupSendRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static GetEditMemberSwitch_Factory getAuthRequestContext(Provider<GroupSendRepository> provider) {
        return new GetEditMemberSwitch_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetEditMemberSwitch(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
