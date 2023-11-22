package id.dana.feeds.domain.friend;

import id.dana.feeds.domain.friend.model.Friend;
import id.dana.feeds.domain.friend.model.FriendRequestList;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0007J%\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00042\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\rJ+\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005H&¢\u0006\u0004\b\u0010\u0010\u0011ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/feeds/domain/friend/FriendRepository;", "", "", "p0", "Lio/reactivex/Observable;", "", "getAuthRequestContext", "(Ljava/lang/String;)Lio/reactivex/Observable;", "BuiltInFictitiousFunctionClassFactory", "", "p1", "Lid/dana/feeds/domain/friend/model/FriendRequestList;", "KClassImpl$Data$declaredNonStaticMembers$2", "(ILjava/lang/String;)Lio/reactivex/Observable;", "", "Lid/dana/feeds/domain/friend/model/Friend;", "PlaceComponentResult", "(Ljava/lang/String;Z)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface FriendRepository {
    Observable<Boolean> BuiltInFictitiousFunctionClassFactory(String p0);

    Observable<FriendRequestList> KClassImpl$Data$declaredNonStaticMembers$2(int p0, String p1);

    Observable<List<Friend>> PlaceComponentResult(String p0, boolean p1);

    Observable<Boolean> getAuthRequestContext(String p0);
}
