package id.dana.domain.home.interactor;

import dagger.internal.Factory;
import id.dana.domain.home.HomeWidgetRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetDanaProtectionHomeWidgetInfoWithConfigFromLocal_Factory implements Factory<GetDanaProtectionHomeWidgetInfoWithConfigFromLocal> {
    private final Provider<HomeWidgetRepository> homeWidgetRepositoryProvider;

    public GetDanaProtectionHomeWidgetInfoWithConfigFromLocal_Factory(Provider<HomeWidgetRepository> provider) {
        this.homeWidgetRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetDanaProtectionHomeWidgetInfoWithConfigFromLocal get() {
        return newInstance(this.homeWidgetRepositoryProvider.get());
    }

    public static GetDanaProtectionHomeWidgetInfoWithConfigFromLocal_Factory create(Provider<HomeWidgetRepository> provider) {
        return new GetDanaProtectionHomeWidgetInfoWithConfigFromLocal_Factory(provider);
    }

    public static GetDanaProtectionHomeWidgetInfoWithConfigFromLocal newInstance(HomeWidgetRepository homeWidgetRepository) {
        return new GetDanaProtectionHomeWidgetInfoWithConfigFromLocal(homeWidgetRepository);
    }
}
