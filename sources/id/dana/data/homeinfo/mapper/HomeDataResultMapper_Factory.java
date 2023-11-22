package id.dana.data.homeinfo.mapper;

import dagger.internal.Factory;
import id.dana.data.feeds.mapper.FeedsResultMapper;
import id.dana.data.notificationcenter.mapper.NotificationCenterMapper;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class HomeDataResultMapper_Factory implements Factory<HomeDataResultMapper> {
    private final Provider<FeedsResultMapper> feedsResultMapperProvider;
    private final Provider<HomeInfoResultMapper> homeInfoResultMapperProvider;
    private final Provider<NotificationCenterMapper> notificationCenterMapperProvider;

    public HomeDataResultMapper_Factory(Provider<HomeInfoResultMapper> provider, Provider<FeedsResultMapper> provider2, Provider<NotificationCenterMapper> provider3) {
        this.homeInfoResultMapperProvider = provider;
        this.feedsResultMapperProvider = provider2;
        this.notificationCenterMapperProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final HomeDataResultMapper get() {
        return newInstance(this.homeInfoResultMapperProvider.get(), this.feedsResultMapperProvider.get(), this.notificationCenterMapperProvider.get());
    }

    public static HomeDataResultMapper_Factory create(Provider<HomeInfoResultMapper> provider, Provider<FeedsResultMapper> provider2, Provider<NotificationCenterMapper> provider3) {
        return new HomeDataResultMapper_Factory(provider, provider2, provider3);
    }

    public static HomeDataResultMapper newInstance(HomeInfoResultMapper homeInfoResultMapper, FeedsResultMapper feedsResultMapper, NotificationCenterMapper notificationCenterMapper) {
        return new HomeDataResultMapper(homeInfoResultMapper, feedsResultMapper, notificationCenterMapper);
    }
}
