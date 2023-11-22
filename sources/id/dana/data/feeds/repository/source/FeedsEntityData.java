package id.dana.data.feeds.repository.source;

import id.dana.data.feeds.repository.source.network.result.DeleteFeedResult;
import id.dana.data.feeds.repository.source.network.result.FeedsResult;
import io.reactivex.Observable;

/* loaded from: classes4.dex */
public interface FeedsEntityData {
    Observable<DeleteFeedResult> deleteFeeds(String str);

    Observable<FeedsResult> getFeeds(String str, int i, String str2);
}
