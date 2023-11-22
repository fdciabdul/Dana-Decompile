package id.dana.domain.home.interactor;

import dagger.internal.Factory;
import id.dana.domain.home.HomeWidgetRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetMoreForYouDataFromPersistence_Factory implements Factory<GetMoreForYouDataFromPersistence> {
    private final Provider<HomeWidgetRepository> homeWidgetRepositoryProvider;

    public GetMoreForYouDataFromPersistence_Factory(Provider<HomeWidgetRepository> provider) {
        this.homeWidgetRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetMoreForYouDataFromPersistence get() {
        return newInstance(this.homeWidgetRepositoryProvider.get());
    }

    public static GetMoreForYouDataFromPersistence_Factory create(Provider<HomeWidgetRepository> provider) {
        return new GetMoreForYouDataFromPersistence_Factory(provider);
    }

    public static GetMoreForYouDataFromPersistence newInstance(HomeWidgetRepository homeWidgetRepository) {
        return new GetMoreForYouDataFromPersistence(homeWidgetRepository);
    }
}
