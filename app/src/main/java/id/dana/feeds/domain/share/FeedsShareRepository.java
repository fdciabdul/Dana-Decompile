package id.dana.feeds.domain.share;

import id.dana.feeds.domain.share.interactor.CreateFeedActivity;
import id.dana.feeds.domain.share.model.PreviewActivityData;
import id.dana.feeds.domain.share.model.ShareFeedActivity;
import id.dana.feeds.domain.share.model.ShareableActivities;
import id.dana.feeds.domain.timeline.model.ActivityResponse;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\f0\u00022\u0006\u0010\u0007\u001a\u00020\u000bH&¢\u0006\u0004\b\u0004\u0010\rJ\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u00022\u0006\u0010\u0007\u001a\u00020\u000bH&¢\u0006\u0004\b\u000e\u0010\rJ\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0002H&¢\u0006\u0004\b\t\u0010\u0005J\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0002H&¢\u0006\u0004\b\u0011\u0010\u0005J\u000f\u0010\u000e\u001a\u00020\u0010H&¢\u0006\u0004\b\u000e\u0010\u0012JS\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00022\u0006\u0010\u0007\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000b2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\u0011\u0010\u001bJ\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00022\u0006\u0010\u0007\u001a\u00020\u0010H&¢\u0006\u0004\b\u0011\u0010\u001cJ\u0017\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0010H&¢\u0006\u0004\b\u000e\u0010\u001dJ\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u00022\u0006\u0010\u0007\u001a\u00020\u000bH&¢\u0006\u0004\b\u001e\u0010\rJ\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00100\u00022\u0006\u0010\u0007\u001a\u00020\u001aH&¢\u0006\u0004\b\u001e\u0010\u001fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/feeds/domain/share/FeedsShareRepository;", "", "Lio/reactivex/Observable;", "Lid/dana/feeds/domain/share/model/ShareFeedActivity;", "MyBillsEntityDataFactory", "()Lio/reactivex/Observable;", "Lid/dana/feeds/domain/share/interactor/CreateFeedActivity$Params;", "p0", "Lid/dana/feeds/domain/timeline/model/ActivityResponse;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/feeds/domain/share/interactor/CreateFeedActivity$Params;)Lio/reactivex/Observable;", "", "", "(Ljava/lang/String;)Lio/reactivex/Observable;", "PlaceComponentResult", "Lid/dana/feeds/domain/share/model/ShareableActivities;", "", "getAuthRequestContext", "()Z", "p1", "p2", "", "p3", "", "p4", "p5", "Lid/dana/feeds/domain/share/model/PreviewActivityData;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;ILjava/lang/String;)Lio/reactivex/Observable;", "(Z)Lio/reactivex/Observable;", "(Z)V", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/feeds/domain/share/model/PreviewActivityData;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface FeedsShareRepository {
    Observable<ShareableActivities> BuiltInFictitiousFunctionClassFactory();

    Observable<ActivityResponse> BuiltInFictitiousFunctionClassFactory(CreateFeedActivity.Params p0);

    Observable<Boolean> KClassImpl$Data$declaredNonStaticMembers$2(PreviewActivityData p0);

    Observable<Unit> KClassImpl$Data$declaredNonStaticMembers$2(String p0);

    Observable<ShareFeedActivity> MyBillsEntityDataFactory();

    Observable<Unit> MyBillsEntityDataFactory(String p0);

    Observable<Unit> PlaceComponentResult(String p0);

    void PlaceComponentResult(boolean p0);

    boolean PlaceComponentResult();

    Observable<Boolean> getAuthRequestContext();

    Observable<PreviewActivityData> getAuthRequestContext(String p0, String p1, String p2, Map<String, ? extends Object> p3, int p4, String p5);

    Observable<Boolean> getAuthRequestContext(boolean p0);
}
