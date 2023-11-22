package id.dana.sendmoney.domain.globalsend.interactor;

import dagger.internal.Factory;
import id.dana.sendmoney.domain.globalsend.GlobalSendRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class InitGlobalTransfer_Factory implements Factory<InitGlobalTransfer> {
    private final Provider<GlobalSendRepository> MyBillsEntityDataFactory;

    private InitGlobalTransfer_Factory(Provider<GlobalSendRepository> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static InitGlobalTransfer_Factory PlaceComponentResult(Provider<GlobalSendRepository> provider) {
        return new InitGlobalTransfer_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new InitGlobalTransfer(this.MyBillsEntityDataFactory.get());
    }
}
