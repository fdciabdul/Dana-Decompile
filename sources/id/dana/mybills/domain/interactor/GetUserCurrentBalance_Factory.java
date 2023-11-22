package id.dana.mybills.domain.interactor;

import dagger.internal.Factory;
import id.dana.mybills.domain.MyBillsRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetUserCurrentBalance_Factory implements Factory<GetUserCurrentBalance> {
    private final Provider<MyBillsRepository> getAuthRequestContext;

    private GetUserCurrentBalance_Factory(Provider<MyBillsRepository> provider) {
        this.getAuthRequestContext = provider;
    }

    public static GetUserCurrentBalance_Factory BuiltInFictitiousFunctionClassFactory(Provider<MyBillsRepository> provider) {
        return new GetUserCurrentBalance_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetUserCurrentBalance(this.getAuthRequestContext.get());
    }
}
