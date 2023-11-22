package id.dana.feeds.domain.relationship;

import id.dana.feeds.domain.relationship.model.Follower;
import id.dana.feeds.domain.relationship.model.Following;
import id.dana.feeds.domain.relationship.model.RelationshipItem;
import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003H&J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003H&J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u0003H&J\b\u0010\r\u001a\u00020\u0004H&J\b\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u000fH&J\b\u0010\u0011\u001a\u00020\u0012H&J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003H&J\b\u0010\u0014\u001a\u00020\u0004H&J\b\u0010\u0015\u001a\u00020\u000fH&J\b\u0010\u0016\u001a\u00020\u000fH&J\b\u0010\u0017\u001a\u00020\u0012H&J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003H&J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u000fH&J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u000fH&J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000fH&J\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000fH&J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003H&J \u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00032\u0006\u0010!\u001a\u00020\u00062\b\b\u0002\u0010\"\u001a\u00020\u0004H&J \u0010#\u001a\b\u0012\u0004\u0012\u00020 0\u00032\u0006\u0010!\u001a\u00020\u00062\b\b\u0002\u0010\"\u001a\u00020\u0004H&J\u001e\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u0006H&J\u001e\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u0006H&J\u001e\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u0006H&J\u001e\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u0006H&J\u000e\u0010)\u001a\b\u0012\u0004\u0012\u00020\t0\u0003H&J\u000e\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003H&J\b\u0010+\u001a\u00020,H&J\b\u0010-\u001a\u00020,H&J\b\u0010.\u001a\u00020,H&J\b\u0010/\u001a\u00020,H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u00060À\u0006\u0001"}, d2 = {"Lid/dana/feeds/domain/relationship/FeedsRelationshipRepository;", "", "approveFriendRequest", "Lio/reactivex/Observable;", "", "targetUserId", "", "declineFriendRequest", "getActiveFollower", "Lid/dana/feeds/domain/relationship/model/Follower;", "getActiveFollowing", "Lid/dana/feeds/domain/relationship/model/Following;", "getBlockedFollower", "getFollowerFullSyncFinished", "getFollowerFullSyncLastPage", "", "getFollowerPartialSyncLastPage", "getFollowerPartialSyncModifiedTime", "", "getFollowingCount", "getFollowingFullSyncFinished", "getFollowingFullSyncLastPage", "getFollowingPartialSyncLastPage", "getFollowingPartialSyncModifiedTime", "getMutedFollowing", "getNextFollowerFullSync", "page", "getNextFollowerPartialSync", "getNextFollowingFullSync", "getNextFollowingPartialSync", "getReciprocalFriend", "getSelectedFollowerItem", "Lid/dana/feeds/domain/relationship/model/RelationshipItem;", "userId", "maskUntilUsername", "getSelectedFollowingItem", "modifyFollowerRelationship", "operationType", "modifyFollowerRelationshipWithPublishResult", "modifyFollowingRelationship", "modifyFollowingRelationshipWithPublishResult", "observeFollowerFullSyncStatus", "observeFollowingFullSyncStatus", "saveFollowerFullSyncFinished", "", "saveFollowerPartialSyncModifiedTime", "saveFollowingFullSyncFinished", "saveFollowingPartialSyncModifiedTime", "feature-feeds_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface FeedsRelationshipRepository {
    Follower BuiltInFictitiousFunctionClassFactory(int i);

    Observable<Following> BuiltInFictitiousFunctionClassFactory();

    Observable<RelationshipItem> BuiltInFictitiousFunctionClassFactory(String str);

    Observable<Boolean> BuiltInFictitiousFunctionClassFactory(String str, String str2);

    int DatabaseTableConfigUtil();

    Observable<Following> GetContactSyncConfig();

    Observable<Follower> KClassImpl$Data$declaredNonStaticMembers$2();

    Observable<RelationshipItem> KClassImpl$Data$declaredNonStaticMembers$2(String str, boolean z);

    int MyBillsEntityDataFactory();

    Following MyBillsEntityDataFactory(int i);

    Observable<Boolean> MyBillsEntityDataFactory(String str);

    Observable<Boolean> MyBillsEntityDataFactory(String str, String str2);

    int NetworkUserEntityData$$ExternalSyntheticLambda0();

    void NetworkUserEntityData$$ExternalSyntheticLambda1();

    Observable<Following> NetworkUserEntityData$$ExternalSyntheticLambda2();

    void NetworkUserEntityData$$ExternalSyntheticLambda7();

    void NetworkUserEntityData$$ExternalSyntheticLambda8();

    Following PlaceComponentResult(int i);

    Observable<Boolean> PlaceComponentResult(String str);

    Observable<Boolean> PlaceComponentResult(String str, String str2);

    boolean PlaceComponentResult();

    Follower getAuthRequestContext(int i);

    Observable<Follower> getAuthRequestContext();

    Observable<Boolean> getAuthRequestContext(String str, String str2);

    long getErrorConfigVersion();

    long initRecordTimeStamp();

    void isLayoutRequested();

    Observable<Integer> lookAheadTest();

    int moveToNextValue();

    boolean scheduleImpl();

    /* renamed from: id.dana.feeds.domain.relationship.FeedsRelationshipRepository$-CC  reason: invalid class name */
    /* loaded from: classes5.dex */
    public final /* synthetic */ class CC {
    }
}
