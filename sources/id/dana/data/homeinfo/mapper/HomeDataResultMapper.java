package id.dana.data.homeinfo.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.feeds.mapper.FeedsResultMapper;
import id.dana.data.homeinfo.repository.source.network.result.HomeDataResult;
import id.dana.data.notificationcenter.mapper.NotificationCenterMapper;
import id.dana.domain.homeinfo.HomeData;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class HomeDataResultMapper extends BaseMapper<HomeDataResult, HomeData> {
    private final FeedsResultMapper feedsResultMapper;
    private final HomeInfoResultMapper homeInfoResultMapper;
    private final NotificationCenterMapper notificationCenterMapper;

    @Inject
    public HomeDataResultMapper(HomeInfoResultMapper homeInfoResultMapper, FeedsResultMapper feedsResultMapper, NotificationCenterMapper notificationCenterMapper) {
        this.homeInfoResultMapper = homeInfoResultMapper;
        this.feedsResultMapper = feedsResultMapper;
        this.notificationCenterMapper = notificationCenterMapper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public HomeData map(HomeDataResult homeDataResult) {
        if (homeDataResult != null) {
            HomeData homeData = new HomeData();
            homeData.setHomeInfoResponse(this.homeInfoResultMapper.transform(homeDataResult.getHomeInfoResult()));
            homeData.setFeeds(this.feedsResultMapper.apply(homeDataResult.getFeedsResult()));
            homeData.setHasNewResponse(this.notificationCenterMapper.transform(homeDataResult.getHasNewResult()));
            homeData.setSpace(homeDataResult.getSpace());
            return homeData;
        }
        return null;
    }
}
