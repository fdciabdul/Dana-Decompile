package id.dana.domain.home.interactor;

import dagger.internal.Factory;
import id.dana.domain.home.HomeWidgetRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SaveNewsWidgetActivitiesIntoPersistence_Factory implements Factory<SaveNewsWidgetActivitiesIntoPersistence> {
    private final Provider<HomeWidgetRepository> homeWidgetRepositoryProvider;

    public SaveNewsWidgetActivitiesIntoPersistence_Factory(Provider<HomeWidgetRepository> provider) {
        this.homeWidgetRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SaveNewsWidgetActivitiesIntoPersistence get() {
        return newInstance(this.homeWidgetRepositoryProvider.get());
    }

    public static SaveNewsWidgetActivitiesIntoPersistence_Factory create(Provider<HomeWidgetRepository> provider) {
        return new SaveNewsWidgetActivitiesIntoPersistence_Factory(provider);
    }

    public static SaveNewsWidgetActivitiesIntoPersistence newInstance(HomeWidgetRepository homeWidgetRepository) {
        return new SaveNewsWidgetActivitiesIntoPersistence(homeWidgetRepository);
    }
}
