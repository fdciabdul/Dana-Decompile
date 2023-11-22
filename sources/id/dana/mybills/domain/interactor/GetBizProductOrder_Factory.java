package id.dana.mybills.domain.interactor;

import dagger.internal.Factory;
import id.dana.mybills.domain.MyBillsRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetBizProductOrder_Factory implements Factory<GetBizProductOrder> {
    private final Provider<MyBillsRepository> getAuthRequestContext;

    private GetBizProductOrder_Factory(Provider<MyBillsRepository> provider) {
        this.getAuthRequestContext = provider;
    }

    public static GetBizProductOrder_Factory BuiltInFictitiousFunctionClassFactory(Provider<MyBillsRepository> provider) {
        return new GetBizProductOrder_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetBizProductOrder(this.getAuthRequestContext.get());
    }
}
