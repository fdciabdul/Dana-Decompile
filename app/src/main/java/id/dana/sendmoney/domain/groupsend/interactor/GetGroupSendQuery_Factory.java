package id.dana.sendmoney.domain.groupsend.interactor;

import dagger.internal.Factory;
import id.dana.sendmoney.domain.groupsend.GroupSendRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetGroupSendQuery_Factory implements Factory<GetGroupSendQuery> {
    private final Provider<GroupSendRepository> MyBillsEntityDataFactory;

    private GetGroupSendQuery_Factory(Provider<GroupSendRepository> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static GetGroupSendQuery_Factory PlaceComponentResult(Provider<GroupSendRepository> provider) {
        return new GetGroupSendQuery_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetGroupSendQuery(this.MyBillsEntityDataFactory.get());
    }
}
