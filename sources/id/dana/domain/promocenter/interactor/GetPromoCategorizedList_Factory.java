package id.dana.domain.promocenter.interactor;

import dagger.internal.Factory;
import id.dana.domain.promocenter.repository.PromoCenterRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetPromoCategorizedList_Factory implements Factory<GetPromoCategorizedList> {
    private final Provider<PromoCenterRepository> promoCenterRepositoryProvider;

    public GetPromoCategorizedList_Factory(Provider<PromoCenterRepository> provider) {
        this.promoCenterRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetPromoCategorizedList get() {
        return newInstance(this.promoCenterRepositoryProvider.get());
    }

    public static GetPromoCategorizedList_Factory create(Provider<PromoCenterRepository> provider) {
        return new GetPromoCategorizedList_Factory(provider);
    }

    public static GetPromoCategorizedList newInstance(PromoCenterRepository promoCenterRepository) {
        return new GetPromoCategorizedList(promoCenterRepository);
    }
}
