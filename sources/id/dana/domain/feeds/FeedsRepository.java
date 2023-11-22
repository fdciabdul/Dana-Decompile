package id.dana.domain.feeds;

import id.dana.domain.feeds.model.DeleteFeed;
import id.dana.domain.feeds.model.Feeds;
import io.reactivex.Observable;

/* loaded from: classes2.dex */
public interface FeedsRepository {
    Observable<DeleteFeed> deleteFeeds(String str);

    Observable<Feeds> getDefaultFeedFromConfig();

    Observable<Feeds> getGlobalFeeds(int i, String str);

    Observable<Feeds> getUserFeeds(int i, String str);
}
