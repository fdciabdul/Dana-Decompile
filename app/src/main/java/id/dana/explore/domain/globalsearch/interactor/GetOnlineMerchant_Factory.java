package id.dana.explore.domain.globalsearch.interactor;

import dagger.internal.Factory;
import id.dana.explore.domain.globalsearch.GlobalSearchRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetOnlineMerchant_Factory implements Factory<GetOnlineMerchant> {
    private final Provider<GlobalSearchRepository> PlaceComponentResult;

    private GetOnlineMerchant_Factory(Provider<GlobalSearchRepository> provider) {
        this.PlaceComponentResult = provider;
    }

    public static GetOnlineMerchant_Factory MyBillsEntityDataFactory(Provider<GlobalSearchRepository> provider) {
        return new GetOnlineMerchant_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetOnlineMerchant(this.PlaceComponentResult.get());
    }
}
