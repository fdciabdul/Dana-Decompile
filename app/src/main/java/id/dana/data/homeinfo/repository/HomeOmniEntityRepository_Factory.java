package id.dana.data.homeinfo.repository;

import dagger.internal.Factory;
import id.dana.data.homeinfo.repository.source.HomeOmniEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class HomeOmniEntityRepository_Factory implements Factory<HomeOmniEntityRepository> {
    private final Provider<HomeOmniEntityDataFactory> homeOmniEntityDataFactoryProvider;

    public HomeOmniEntityRepository_Factory(Provider<HomeOmniEntityDataFactory> provider) {
        this.homeOmniEntityDataFactoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final HomeOmniEntityRepository get() {
        return newInstance(this.homeOmniEntityDataFactoryProvider.get());
    }

    public static HomeOmniEntityRepository_Factory create(Provider<HomeOmniEntityDataFactory> provider) {
        return new HomeOmniEntityRepository_Factory(provider);
    }

    public static HomeOmniEntityRepository newInstance(HomeOmniEntityDataFactory homeOmniEntityDataFactory) {
        return new HomeOmniEntityRepository(homeOmniEntityDataFactory);
    }
}
