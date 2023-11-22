package id.dana.sendmoney.domain.globalsend.interactor;

import dagger.internal.Factory;
import id.dana.sendmoney.domain.globalsend.GlobalSendRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class ValidateRecurringTransaction_Factory implements Factory<ValidateRecurringTransaction> {
    private final Provider<GlobalSendRepository> BuiltInFictitiousFunctionClassFactory;

    private ValidateRecurringTransaction_Factory(Provider<GlobalSendRepository> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static ValidateRecurringTransaction_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<GlobalSendRepository> provider) {
        return new ValidateRecurringTransaction_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ValidateRecurringTransaction(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
