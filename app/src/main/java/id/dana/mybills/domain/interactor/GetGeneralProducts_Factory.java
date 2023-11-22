package id.dana.mybills.domain.interactor;

import dagger.internal.Factory;
import id.dana.mybills.domain.MyBillsRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetGeneralProducts_Factory implements Factory<GetGeneralProducts> {
    private final Provider<MyBillsRepository> PlaceComponentResult;

    private GetGeneralProducts_Factory(Provider<MyBillsRepository> provider) {
        this.PlaceComponentResult = provider;
    }

    public static GetGeneralProducts_Factory PlaceComponentResult(Provider<MyBillsRepository> provider) {
        return new GetGeneralProducts_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetGeneralProducts(this.PlaceComponentResult.get());
    }
}
