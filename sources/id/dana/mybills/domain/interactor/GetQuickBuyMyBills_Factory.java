package id.dana.mybills.domain.interactor;

import dagger.internal.Factory;
import id.dana.mybills.domain.MyBillsRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetQuickBuyMyBills_Factory implements Factory<GetQuickBuyMyBills> {
    private final Provider<MyBillsRepository> getAuthRequestContext;

    private GetQuickBuyMyBills_Factory(Provider<MyBillsRepository> provider) {
        this.getAuthRequestContext = provider;
    }

    public static GetQuickBuyMyBills_Factory getAuthRequestContext(Provider<MyBillsRepository> provider) {
        return new GetQuickBuyMyBills_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetQuickBuyMyBills(this.getAuthRequestContext.get());
    }
}
