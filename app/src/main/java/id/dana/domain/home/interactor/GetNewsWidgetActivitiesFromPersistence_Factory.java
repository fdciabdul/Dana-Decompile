package id.dana.domain.home.interactor;

import dagger.internal.Factory;
import id.dana.domain.home.HomeWidgetRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetNewsWidgetActivitiesFromPersistence_Factory implements Factory<GetNewsWidgetActivitiesFromPersistence> {
    private final Provider<HomeWidgetRepository> homeWidgetRepositoryProvider;

    public GetNewsWidgetActivitiesFromPersistence_Factory(Provider<HomeWidgetRepository> provider) {
        this.homeWidgetRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetNewsWidgetActivitiesFromPersistence get() {
        return newInstance(this.homeWidgetRepositoryProvider.get());
    }

    public static GetNewsWidgetActivitiesFromPersistence_Factory create(Provider<HomeWidgetRepository> provider) {
        return new GetNewsWidgetActivitiesFromPersistence_Factory(provider);
    }

    public static GetNewsWidgetActivitiesFromPersistence newInstance(HomeWidgetRepository homeWidgetRepository) {
        return new GetNewsWidgetActivitiesFromPersistence(homeWidgetRepository);
    }
}
