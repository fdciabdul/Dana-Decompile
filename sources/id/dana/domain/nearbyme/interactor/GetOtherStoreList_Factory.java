package id.dana.domain.nearbyme.interactor;

import dagger.internal.Factory;
import id.dana.domain.nearbyme.NearbyMeRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetOtherStoreList_Factory implements Factory<GetOtherStoreList> {
    private final Provider<NearbyMeRepository> nearbyMeRepositoryProvider;

    public GetOtherStoreList_Factory(Provider<NearbyMeRepository> provider) {
        this.nearbyMeRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetOtherStoreList get() {
        return newInstance(this.nearbyMeRepositoryProvider.get());
    }

    public static GetOtherStoreList_Factory create(Provider<NearbyMeRepository> provider) {
        return new GetOtherStoreList_Factory(provider);
    }

    public static GetOtherStoreList newInstance(NearbyMeRepository nearbyMeRepository) {
        return new GetOtherStoreList(nearbyMeRepository);
    }
}
