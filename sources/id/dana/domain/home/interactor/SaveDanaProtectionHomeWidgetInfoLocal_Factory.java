package id.dana.domain.home.interactor;

import dagger.internal.Factory;
import id.dana.domain.home.HomeWidgetRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SaveDanaProtectionHomeWidgetInfoLocal_Factory implements Factory<SaveDanaProtectionHomeWidgetInfoLocal> {
    private final Provider<HomeWidgetRepository> homeWidgetRepositoryProvider;

    public SaveDanaProtectionHomeWidgetInfoLocal_Factory(Provider<HomeWidgetRepository> provider) {
        this.homeWidgetRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SaveDanaProtectionHomeWidgetInfoLocal get() {
        return newInstance(this.homeWidgetRepositoryProvider.get());
    }

    public static SaveDanaProtectionHomeWidgetInfoLocal_Factory create(Provider<HomeWidgetRepository> provider) {
        return new SaveDanaProtectionHomeWidgetInfoLocal_Factory(provider);
    }

    public static SaveDanaProtectionHomeWidgetInfoLocal newInstance(HomeWidgetRepository homeWidgetRepository) {
        return new SaveDanaProtectionHomeWidgetInfoLocal(homeWidgetRepository);
    }
}
