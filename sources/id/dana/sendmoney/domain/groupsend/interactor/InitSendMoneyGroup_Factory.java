package id.dana.sendmoney.domain.groupsend.interactor;

import dagger.internal.Factory;
import id.dana.sendmoney.domain.groupsend.GroupSendRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class InitSendMoneyGroup_Factory implements Factory<InitSendMoneyGroup> {
    private final Provider<GroupSendRepository> MyBillsEntityDataFactory;

    private InitSendMoneyGroup_Factory(Provider<GroupSendRepository> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static InitSendMoneyGroup_Factory getAuthRequestContext(Provider<GroupSendRepository> provider) {
        return new InitSendMoneyGroup_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new InitSendMoneyGroup(this.MyBillsEntityDataFactory.get());
    }
}
