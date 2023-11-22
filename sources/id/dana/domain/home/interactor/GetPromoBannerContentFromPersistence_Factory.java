package id.dana.domain.home.interactor;

import dagger.internal.Factory;
import id.dana.domain.home.HomeWidgetRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetPromoBannerContentFromPersistence_Factory implements Factory<GetPromoBannerContentFromPersistence> {
    private final Provider<HomeWidgetRepository> homeWidgetRepositoryProvider;

    public GetPromoBannerContentFromPersistence_Factory(Provider<HomeWidgetRepository> provider) {
        this.homeWidgetRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetPromoBannerContentFromPersistence get() {
        return newInstance(this.homeWidgetRepositoryProvider.get());
    }

    public static GetPromoBannerContentFromPersistence_Factory create(Provider<HomeWidgetRepository> provider) {
        return new GetPromoBannerContentFromPersistence_Factory(provider);
    }

    public static GetPromoBannerContentFromPersistence newInstance(HomeWidgetRepository homeWidgetRepository) {
        return new GetPromoBannerContentFromPersistence(homeWidgetRepository);
    }
}
