package id.dana.data.social.repository.source.persistence.dao;

import id.dana.data.social.repository.source.persistence.entity.FollowingItemEntity;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u000b2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0006H&¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0012\u001a\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\tH&¢\u0006\u0004\b\u0016\u0010\u0017ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/social/repository/source/persistence/dao/FollowingDao;", "", "", "clearFollowing", "()V", "", "Lid/dana/data/social/repository/source/persistence/entity/FollowingItemEntity;", "getFollowingItemEntityList", "()Ljava/util/List;", "", "userId", "Lio/reactivex/Observable;", "getSelectedFollowing", "(Ljava/lang/String;)Lio/reactivex/Observable;", "followingItemEntity", "insertFollowingItem", "(Lid/dana/data/social/repository/source/persistence/entity/FollowingItemEntity;)V", "followingItemEntityList", "insertFollowingItemList", "(Ljava/util/List;)V", "targetUserId", "modifiedRelation", "updateModifiedRelation", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface FollowingDao {
    void clearFollowing();

    List<FollowingItemEntity> getFollowingItemEntityList();

    Observable<List<FollowingItemEntity>> getSelectedFollowing(String userId);

    void insertFollowingItem(FollowingItemEntity followingItemEntity);

    void insertFollowingItemList(List<FollowingItemEntity> followingItemEntityList);

    void updateModifiedRelation(String targetUserId, String modifiedRelation);
}
