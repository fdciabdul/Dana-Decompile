package id.dana.feeds.data.relationship.mapper;

import id.dana.data.social.repository.source.persistence.entity.FollowerEntity;
import id.dana.data.social.repository.source.persistence.entity.FollowerItemEntity;
import id.dana.data.social.repository.source.persistence.entity.PaginatorEntity;
import id.dana.feeds.data.relationship.source.network.response.FollowerResponse;
import id.dana.feeds.data.relationship.source.network.response.RelationshipItemResponse;
import id.dana.feeds.domain.relationship.model.Follower;
import id.dana.feeds.domain.relationship.model.RelationshipItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0005\u001a\u00020\u0001*\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0017\u0010\u0005\u001a\u00020\u0000*\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\u0005\u0010\t\u001a\u0011\u0010\u000b\u001a\u00020\n*\u00020\b¢\u0006\u0004\b\u000b\u0010\f\u001a\u001d\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\b0\u0007*\b\u0012\u0004\u0012\u00020\r0\u0007¢\u0006\u0004\b\u0002\u0010\u000e"}, d2 = {"Lid/dana/data/social/repository/source/persistence/entity/FollowerEntity;", "Lid/dana/feeds/domain/relationship/model/Follower;", "getAuthRequestContext", "(Lid/dana/data/social/repository/source/persistence/entity/FollowerEntity;)Lid/dana/feeds/domain/relationship/model/Follower;", "Lid/dana/feeds/data/relationship/source/network/response/FollowerResponse;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/feeds/data/relationship/source/network/response/FollowerResponse;)Lid/dana/feeds/domain/relationship/model/Follower;", "", "Lid/dana/data/social/repository/source/persistence/entity/FollowerItemEntity;", "(Ljava/util/List;)Lid/dana/data/social/repository/source/persistence/entity/FollowerEntity;", "Lid/dana/feeds/domain/relationship/model/RelationshipItem;", "MyBillsEntityDataFactory", "(Lid/dana/data/social/repository/source/persistence/entity/FollowerItemEntity;)Lid/dana/feeds/domain/relationship/model/RelationshipItem;", "Lid/dana/feeds/data/relationship/source/network/response/RelationshipItemResponse;", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FollowerMapperKt {
    public static final Follower getAuthRequestContext(FollowerEntity followerEntity) {
        Intrinsics.checkNotNullParameter(followerEntity, "");
        List<FollowerItemEntity> followerList = followerEntity.getFollowerList();
        Intrinsics.checkNotNullParameter(followerList, "");
        List<FollowerItemEntity> list = followerList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(MyBillsEntityDataFactory((FollowerItemEntity) it.next()));
        }
        return new Follower(arrayList, PaginatorMapperKt.getAuthRequestContext(followerEntity.getPaginator()));
    }

    public static final FollowerEntity BuiltInFictitiousFunctionClassFactory(List<FollowerItemEntity> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<FollowerItemEntity> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add((FollowerItemEntity) it.next());
        }
        return new FollowerEntity(arrayList, new PaginatorEntity(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, 8176, null));
    }

    public static final RelationshipItem MyBillsEntityDataFactory(FollowerItemEntity followerItemEntity) {
        Intrinsics.checkNotNullParameter(followerItemEntity, "");
        return new RelationshipItem(followerItemEntity.getLoginId(), followerItemEntity.getNickName(), followerItemEntity.getStatus(), followerItemEntity.getUserId(), followerItemEntity.getAvatar(), followerItemEntity.getUsername(), false, 0, 192, null);
    }

    public static final List<FollowerItemEntity> getAuthRequestContext(List<RelationshipItemResponse> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<RelationshipItemResponse> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (RelationshipItemResponse relationshipItemResponse : list2) {
            Intrinsics.checkNotNullParameter(relationshipItemResponse, "");
            String userId = relationshipItemResponse.getUserId();
            String loginId = relationshipItemResponse.getLoginId();
            String nickName = relationshipItemResponse.getNickName();
            String status = relationshipItemResponse.getStatus();
            long gmtCreate = relationshipItemResponse.getGmtCreate();
            long gmtModified = relationshipItemResponse.getGmtModified();
            String avatar = relationshipItemResponse.getAvatar();
            String username = relationshipItemResponse.getUsername();
            arrayList.add(new FollowerItemEntity(userId, loginId, nickName, status, gmtCreate, gmtModified, avatar, username == null ? "" : username));
        }
        return arrayList;
    }

    public static final Follower BuiltInFictitiousFunctionClassFactory(FollowerResponse followerResponse) {
        Intrinsics.checkNotNullParameter(followerResponse, "");
        List<RelationshipItemResponse> followerList = followerResponse.getFollowerList();
        Intrinsics.checkNotNullParameter(followerList, "");
        List<RelationshipItemResponse> list = followerList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (RelationshipItemResponse relationshipItemResponse : list) {
            Intrinsics.checkNotNullParameter(relationshipItemResponse, "");
            String loginId = relationshipItemResponse.getLoginId();
            String nickName = relationshipItemResponse.getNickName();
            String status = relationshipItemResponse.getStatus();
            String userId = relationshipItemResponse.getUserId();
            String avatar = relationshipItemResponse.getAvatar();
            String username = relationshipItemResponse.getUsername();
            arrayList.add(new RelationshipItem(loginId, nickName, status, userId, avatar, username == null ? "" : username, false, 0, 192, null));
        }
        return new Follower(arrayList, PaginatorMapperKt.MyBillsEntityDataFactory(followerResponse.getPaginator()));
    }
}
