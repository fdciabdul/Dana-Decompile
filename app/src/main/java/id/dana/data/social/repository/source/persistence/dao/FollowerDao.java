package id.dana.data.social.repository.source.persistence.dao;

import id.dana.data.social.repository.source.persistence.entity.FollowerItemEntity;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u000b2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\u0006H&¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00132\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\tH&¢\u0006\u0004\b\u0018\u0010\u0019ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/social/repository/source/persistence/dao/FollowerDao;", "", "", "clearFollower", "()V", "", "Lid/dana/data/social/repository/source/persistence/entity/FollowerItemEntity;", "getFollowerItemEntityList", "()Ljava/util/List;", "", "userId", "Lio/reactivex/Observable;", "getSelectedFollower", "(Ljava/lang/String;)Lio/reactivex/Observable;", "followerItemEntity", "", "insertFollowerItem", "(Lid/dana/data/social/repository/source/persistence/entity/FollowerItemEntity;)Ljava/lang/Long;", "followerItemEntityList", "", "insertFollowerItemList", "(Ljava/util/List;)[Ljava/lang/Long;", "targetUserId", "modifiedRelation", "updateModifiedRelation", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface FollowerDao {
    void clearFollower();

    List<FollowerItemEntity> getFollowerItemEntityList();

    Observable<List<FollowerItemEntity>> getSelectedFollower(String userId);

    Long insertFollowerItem(FollowerItemEntity followerItemEntity);

    Long[] insertFollowerItemList(List<FollowerItemEntity> followerItemEntityList);

    void updateModifiedRelation(String targetUserId, String modifiedRelation);
}
