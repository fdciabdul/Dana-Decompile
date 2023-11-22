package id.dana.domain.home.interactor;

import dagger.internal.Factory;
import id.dana.domain.home.HomeWidgetRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SavePromoBannerCdpContentIntoPersistence_Factory implements Factory<SavePromoBannerCdpContentIntoPersistence> {
    private final Provider<HomeWidgetRepository> homeWidgetRepositoryProvider;

    public SavePromoBannerCdpContentIntoPersistence_Factory(Provider<HomeWidgetRepository> provider) {
        this.homeWidgetRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SavePromoBannerCdpContentIntoPersistence get() {
        return newInstance(this.homeWidgetRepositoryProvider.get());
    }

    public static SavePromoBannerCdpContentIntoPersistence_Factory create(Provider<HomeWidgetRepository> provider) {
        return new SavePromoBannerCdpContentIntoPersistence_Factory(provider);
    }

    public static SavePromoBannerCdpContentIntoPersistence newInstance(HomeWidgetRepository homeWidgetRepository) {
        return new SavePromoBannerCdpContentIntoPersistence(homeWidgetRepository);
    }
}
