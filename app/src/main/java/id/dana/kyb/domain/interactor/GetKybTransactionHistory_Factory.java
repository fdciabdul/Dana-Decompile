package id.dana.kyb.domain.interactor;

import dagger.internal.Factory;
import id.dana.kyb.domain.KybRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetKybTransactionHistory_Factory implements Factory<GetKybTransactionHistory> {
    private final Provider<KybRepository> MyBillsEntityDataFactory;

    private GetKybTransactionHistory_Factory(Provider<KybRepository> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static GetKybTransactionHistory_Factory getAuthRequestContext(Provider<KybRepository> provider) {
        return new GetKybTransactionHistory_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetKybTransactionHistory(this.MyBillsEntityDataFactory.get());
    }
}
