package id.dana.sendmoney.domain.globalsend.interactor;

import dagger.internal.Factory;
import id.dana.sendmoney.domain.globalsend.GlobalSendRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class TransferSubmit_Factory implements Factory<TransferSubmit> {
    private final Provider<GlobalSendRepository> BuiltInFictitiousFunctionClassFactory;

    private TransferSubmit_Factory(Provider<GlobalSendRepository> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static TransferSubmit_Factory getAuthRequestContext(Provider<GlobalSendRepository> provider) {
        return new TransferSubmit_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new TransferSubmit(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
