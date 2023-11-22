package id.dana.domain.homeinfo;

import id.dana.domain.feeds.model.Feeds;
import id.dana.domain.notificationcenter.model.HasNewResponse;
import id.dana.domain.promotion.model.BannerCollection;

/* loaded from: classes4.dex */
public class HomeData {
    private Feeds feeds;
    private HasNewResponse hasNewResponse;
    private HomeInfoResponse homeInfoResponse;
    private BannerCollection space;

    public HomeInfoResponse getHomeInfoResponse() {
        return this.homeInfoResponse;
    }

    public void setHomeInfoResponse(HomeInfoResponse homeInfoResponse) {
        this.homeInfoResponse = homeInfoResponse;
    }

    public BannerCollection getSpace() {
        return this.space;
    }

    public void setSpace(BannerCollection bannerCollection) {
        this.space = bannerCollection;
    }

    public Feeds getFeeds() {
        return this.feeds;
    }

    public void setFeeds(Feeds feeds) {
        this.feeds = feeds;
    }

    public HasNewResponse getHasNewResponse() {
        return this.hasNewResponse;
    }

    public void setHasNewResponse(HasNewResponse hasNewResponse) {
        this.hasNewResponse = hasNewResponse;
    }
}
