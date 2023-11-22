package id.dana.sendmoney.domain.globalsend.interactor;

import dagger.internal.Factory;
import id.dana.sendmoney.domain.globalsend.GlobalSendRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class ValidateNewTransaction_Factory implements Factory<ValidateNewTransaction> {
    private final Provider<GlobalSendRepository> MyBillsEntityDataFactory;

    private ValidateNewTransaction_Factory(Provider<GlobalSendRepository> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static ValidateNewTransaction_Factory getAuthRequestContext(Provider<GlobalSendRepository> provider) {
        return new ValidateNewTransaction_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ValidateNewTransaction(this.MyBillsEntityDataFactory.get());
    }
}
