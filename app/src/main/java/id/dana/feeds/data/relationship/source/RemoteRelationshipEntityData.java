package id.dana.feeds.data.relationship.source;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.feeds.data.relationship.source.network.response.FollowerResponse;
import id.dana.feeds.data.relationship.source.network.response.FollowingResponse;
import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\u0006\u0010\n\u001a\u00020\u000bH&J%\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0002\u0010\rJ\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH&J%\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0002\u0010\u0013J\u0018\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH&J\u001e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0017À\u0006\u0001"}, d2 = {"Lid/dana/feeds/data/relationship/source/RemoteRelationshipEntityData;", "", "approveFriendRequest", "Lio/reactivex/Observable;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "targetUserId", "", "declineFriendRequest", "getFollowerItemList", "Lid/dana/feeds/data/relationship/source/network/response/FollowerResponse;", "pageNum", "", "userId", "(Ljava/lang/Integer;Ljava/lang/String;)Lid/dana/feeds/data/relationship/source/network/response/FollowerResponse;", "getFollowerItemListByModifiedTime", "modifiedTime", "", "getFollowingItemList", "Lid/dana/feeds/data/relationship/source/network/response/FollowingResponse;", "(Ljava/lang/Integer;Ljava/lang/String;)Lid/dana/feeds/data/relationship/source/network/response/FollowingResponse;", "getFollowingItemListByModifiedTime", "modifyRelationship", "operationType", "feature-feeds_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface RemoteRelationshipEntityData {
    FollowingResponse BuiltInFictitiousFunctionClassFactory(long j, int i);

    Observable<BaseRpcResult> BuiltInFictitiousFunctionClassFactory(String str);

    FollowingResponse KClassImpl$Data$declaredNonStaticMembers$2(Integer num, String str);

    Observable<BaseRpcResult> KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2);

    FollowerResponse MyBillsEntityDataFactory(Integer num, String str);

    Observable<FollowerResponse> MyBillsEntityDataFactory(long j, int i);

    Observable<FollowerResponse> PlaceComponentResult(int i);

    Observable<BaseRpcResult> getAuthRequestContext(String str);

    /* renamed from: id.dana.feeds.data.relationship.source.RemoteRelationshipEntityData$-CC  reason: invalid class name */
    /* loaded from: classes5.dex */
    public final /* synthetic */ class CC {
    }
}
