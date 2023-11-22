package id.dana.sendmoney.data.repository.groupsend;

import dagger.internal.Factory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.sendmoney.data.repository.groupsend.source.GroupSendEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GroupSendEntityRepository_Factory implements Factory<GroupSendEntityRepository> {
    private final Provider<HoldLoginV1EntityRepository> MyBillsEntityDataFactory;
    private final Provider<GroupSendEntityDataFactory> getAuthRequestContext;

    private GroupSendEntityRepository_Factory(Provider<GroupSendEntityDataFactory> provider, Provider<HoldLoginV1EntityRepository> provider2) {
        this.getAuthRequestContext = provider;
        this.MyBillsEntityDataFactory = provider2;
    }

    public static GroupSendEntityRepository_Factory getAuthRequestContext(Provider<GroupSendEntityDataFactory> provider, Provider<HoldLoginV1EntityRepository> provider2) {
        return new GroupSendEntityRepository_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GroupSendEntityRepository(this.getAuthRequestContext.get(), this.MyBillsEntityDataFactory.get());
    }
}
