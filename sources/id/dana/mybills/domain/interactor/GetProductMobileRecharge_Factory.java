package id.dana.mybills.domain.interactor;

import dagger.internal.Factory;
import id.dana.mybills.domain.MyBillsRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetProductMobileRecharge_Factory implements Factory<GetProductMobileRecharge> {
    private final Provider<MyBillsRepository> PlaceComponentResult;

    private GetProductMobileRecharge_Factory(Provider<MyBillsRepository> provider) {
        this.PlaceComponentResult = provider;
    }

    public static GetProductMobileRecharge_Factory PlaceComponentResult(Provider<MyBillsRepository> provider) {
        return new GetProductMobileRecharge_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetProductMobileRecharge(this.PlaceComponentResult.get());
    }
}
