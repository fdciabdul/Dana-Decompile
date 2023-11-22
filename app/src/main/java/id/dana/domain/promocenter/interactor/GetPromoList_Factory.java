package id.dana.domain.promocenter.interactor;

import dagger.internal.Factory;
import id.dana.domain.promocenter.repository.PromoCenterRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetPromoList_Factory implements Factory<GetPromoList> {
    private final Provider<PromoCenterRepository> promoCenterRepositoryProvider;

    public GetPromoList_Factory(Provider<PromoCenterRepository> provider) {
        this.promoCenterRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetPromoList get() {
        return newInstance(this.promoCenterRepositoryProvider.get());
    }

    public static GetPromoList_Factory create(Provider<PromoCenterRepository> provider) {
        return new GetPromoList_Factory(provider);
    }

    public static GetPromoList newInstance(PromoCenterRepository promoCenterRepository) {
        return new GetPromoList(promoCenterRepository);
    }
}
