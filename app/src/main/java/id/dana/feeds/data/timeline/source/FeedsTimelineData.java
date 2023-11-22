package id.dana.feeds.data.timeline.source;

import id.dana.feeds.data.timeline.source.network.response.FeedResult;
import id.dana.feeds.data.timeline.source.network.response.MyFeedResult;
import id.dana.feeds.domain.timeline.model.SocialFeed;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006JY\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\rH&¢\u0006\u0004\b\u0005\u0010\u0011J-\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u000f2\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\u0013\u0010\u0014J1\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00120\u000f2\u0006\u0010\u0003\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0014JY\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00150\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\rH&¢\u0006\u0004\b\u0005\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0015H&¢\u0006\u0004\b\u0017\u0010\u0018ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/feeds/data/timeline/source/FeedsTimelineData;", "", "", "p0", "", "getAuthRequestContext", "(Ljava/lang/String;)V", "", "p1", "p2", "p3", "p4", "p5", "", "p6", "Lio/reactivex/Observable;", "Lid/dana/feeds/data/timeline/source/network/response/FeedResult;", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;)Lio/reactivex/Observable;", "Lid/dana/feeds/data/timeline/source/network/response/MyFeedResult;", "KClassImpl$Data$declaredNonStaticMembers$2", "(ILjava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/feeds/domain/timeline/model/SocialFeed;", "(Ljava/lang/String;ILjava/util/List;)Lio/reactivex/Observable;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/feeds/domain/timeline/model/SocialFeed;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface FeedsTimelineData {
    void BuiltInFictitiousFunctionClassFactory(SocialFeed p0);

    Observable<MyFeedResult> KClassImpl$Data$declaredNonStaticMembers$2(int p0, String p1, String p2);

    Observable<MyFeedResult> getAuthRequestContext(int p0, String p1, String p2);

    Observable<FeedResult> getAuthRequestContext(String p0, int p1, String p2, String p3, String p4, int p5, List<String> p6);

    Observable<SocialFeed> getAuthRequestContext(String str, int i, List<String> list);

    void getAuthRequestContext(String p0);
}
