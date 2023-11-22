package id.dana.sendmoney.domain.groupsend.interactor;

import dagger.internal.Factory;
import id.dana.sendmoney.domain.groupsend.GroupSendRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetGroupSendDetail_Factory implements Factory<GetGroupSendDetail> {
    private final Provider<GroupSendRepository> PlaceComponentResult;

    private GetGroupSendDetail_Factory(Provider<GroupSendRepository> provider) {
        this.PlaceComponentResult = provider;
    }

    public static GetGroupSendDetail_Factory PlaceComponentResult(Provider<GroupSendRepository> provider) {
        return new GetGroupSendDetail_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetGroupSendDetail(this.PlaceComponentResult.get());
    }
}
