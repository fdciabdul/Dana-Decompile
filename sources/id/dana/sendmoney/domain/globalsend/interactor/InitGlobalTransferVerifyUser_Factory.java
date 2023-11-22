package id.dana.sendmoney.domain.globalsend.interactor;

import dagger.internal.Factory;
import id.dana.sendmoney.domain.globalsend.GlobalSendRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class InitGlobalTransferVerifyUser_Factory implements Factory<InitGlobalTransferVerifyUser> {
    private final Provider<GlobalSendRepository> BuiltInFictitiousFunctionClassFactory;

    private InitGlobalTransferVerifyUser_Factory(Provider<GlobalSendRepository> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static InitGlobalTransferVerifyUser_Factory PlaceComponentResult(Provider<GlobalSendRepository> provider) {
        return new InitGlobalTransferVerifyUser_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new InitGlobalTransferVerifyUser(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
