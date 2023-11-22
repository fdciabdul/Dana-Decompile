package id.dana.domain.home.interactor;

import dagger.internal.Factory;
import id.dana.domain.home.HomeWidgetRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SaveMoreForYouDataIntoPersistence_Factory implements Factory<SaveMoreForYouDataIntoPersistence> {
    private final Provider<HomeWidgetRepository> homeWidgetRepositoryProvider;

    public SaveMoreForYouDataIntoPersistence_Factory(Provider<HomeWidgetRepository> provider) {
        this.homeWidgetRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SaveMoreForYouDataIntoPersistence get() {
        return newInstance(this.homeWidgetRepositoryProvider.get());
    }

    public static SaveMoreForYouDataIntoPersistence_Factory create(Provider<HomeWidgetRepository> provider) {
        return new SaveMoreForYouDataIntoPersistence_Factory(provider);
    }

    public static SaveMoreForYouDataIntoPersistence newInstance(HomeWidgetRepository homeWidgetRepository) {
        return new SaveMoreForYouDataIntoPersistence(homeWidgetRepository);
    }
}
