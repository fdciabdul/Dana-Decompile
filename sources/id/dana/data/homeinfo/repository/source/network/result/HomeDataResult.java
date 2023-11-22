package id.dana.data.homeinfo.repository.source.network.result;

import id.dana.data.feeds.repository.source.network.result.FeedsResult;
import id.dana.data.notificationcenter.repository.source.network.result.HasNewResult;
import id.dana.domain.promotion.model.BannerCollection;

/* loaded from: classes4.dex */
public class HomeDataResult {
    private FeedsResult feedsResult;
    private HasNewResult hasNewResult;
    private HomeInfoResult homeInfoResult;
    private BannerCollection space;

    public HomeInfoResult getHomeInfoResult() {
        return this.homeInfoResult;
    }

    public void setHomeInfoResult(HomeInfoResult homeInfoResult) {
        this.homeInfoResult = homeInfoResult;
    }

    public FeedsResult getFeedsResult() {
        return this.feedsResult;
    }

    public void setFeedsResult(FeedsResult feedsResult) {
        this.feedsResult = feedsResult;
    }

    public BannerCollection getSpace() {
        return this.space;
    }

    public void setSpace(BannerCollection bannerCollection) {
        this.space = bannerCollection;
    }

    public HasNewResult getHasNewResult() {
        return this.hasNewResult;
    }

    public void setHasNewResult(HasNewResult hasNewResult) {
        this.hasNewResult = hasNewResult;
    }
}
