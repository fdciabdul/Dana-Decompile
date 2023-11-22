package id.dana.sendmoney.domain.groupsend.interactor;

import dagger.internal.Factory;
import id.dana.sendmoney.domain.groupsend.GroupSendRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetGroupSendMaxGroup_Factory implements Factory<GetGroupSendMaxGroup> {
    private final Provider<GroupSendRepository> PlaceComponentResult;

    private GetGroupSendMaxGroup_Factory(Provider<GroupSendRepository> provider) {
        this.PlaceComponentResult = provider;
    }

    public static GetGroupSendMaxGroup_Factory getAuthRequestContext(Provider<GroupSendRepository> provider) {
        return new GetGroupSendMaxGroup_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetGroupSendMaxGroup(this.PlaceComponentResult.get());
    }
}
