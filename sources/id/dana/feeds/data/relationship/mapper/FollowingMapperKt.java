package id.dana.feeds.data.relationship.mapper;

import id.dana.data.social.repository.source.persistence.entity.FollowingEntity;
import id.dana.data.social.repository.source.persistence.entity.FollowingItemEntity;
import id.dana.data.social.repository.source.persistence.entity.PaginatorEntity;
import id.dana.feeds.data.relationship.source.network.response.FollowingResponse;
import id.dana.feeds.data.relationship.source.network.response.RelationshipItemResponse;
import id.dana.feeds.domain.relationship.model.Following;
import id.dana.feeds.domain.relationship.model.RelationshipItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0005\u001a\u00020\u0001*\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0017\u0010\u0002\u001a\u00020\u0000*\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\u0002\u0010\t\u001a\u0011\u0010\u0002\u001a\u00020\n*\u00020\b¢\u0006\u0004\b\u0002\u0010\u000b\u001a\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007*\b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/data/social/repository/source/persistence/entity/FollowingEntity;", "Lid/dana/feeds/domain/relationship/model/Following;", "getAuthRequestContext", "(Lid/dana/data/social/repository/source/persistence/entity/FollowingEntity;)Lid/dana/feeds/domain/relationship/model/Following;", "Lid/dana/feeds/data/relationship/source/network/response/FollowingResponse;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/feeds/data/relationship/source/network/response/FollowingResponse;)Lid/dana/feeds/domain/relationship/model/Following;", "", "Lid/dana/data/social/repository/source/persistence/entity/FollowingItemEntity;", "(Ljava/util/List;)Lid/dana/data/social/repository/source/persistence/entity/FollowingEntity;", "Lid/dana/feeds/domain/relationship/model/RelationshipItem;", "(Lid/dana/data/social/repository/source/persistence/entity/FollowingItemEntity;)Lid/dana/feeds/domain/relationship/model/RelationshipItem;", "Lid/dana/feeds/data/relationship/source/network/response/RelationshipItemResponse;", "MyBillsEntityDataFactory", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FollowingMapperKt {
    public static final Following getAuthRequestContext(FollowingEntity followingEntity) {
        Intrinsics.checkNotNullParameter(followingEntity, "");
        List<FollowingItemEntity> followingList = followingEntity.getFollowingList();
        Intrinsics.checkNotNullParameter(followingList, "");
        List<FollowingItemEntity> list = followingList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(getAuthRequestContext((FollowingItemEntity) it.next()));
        }
        return new Following(arrayList, PaginatorMapperKt.getAuthRequestContext(followingEntity.getPaginator()));
    }

    public static final FollowingEntity getAuthRequestContext(List<FollowingItemEntity> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<FollowingItemEntity> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add((FollowingItemEntity) it.next());
        }
        return new FollowingEntity(arrayList, new PaginatorEntity(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, 8176, null));
    }

    public static final RelationshipItem getAuthRequestContext(FollowingItemEntity followingItemEntity) {
        Intrinsics.checkNotNullParameter(followingItemEntity, "");
        return new RelationshipItem(followingItemEntity.getLoginId(), followingItemEntity.getNickName(), followingItemEntity.getStatus(), followingItemEntity.getUserId(), followingItemEntity.getAvatar(), followingItemEntity.getUsername(), false, 0, 192, null);
    }

    public static final List<FollowingItemEntity> MyBillsEntityDataFactory(List<RelationshipItemResponse> list) {
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
            arrayList.add(new FollowingItemEntity(userId, loginId, nickName, status, gmtCreate, gmtModified, avatar, username == null ? "" : username));
        }
        return arrayList;
    }

    public static final Following BuiltInFictitiousFunctionClassFactory(FollowingResponse followingResponse) {
        Intrinsics.checkNotNullParameter(followingResponse, "");
        List<RelationshipItemResponse> followingList = followingResponse.getFollowingList();
        Intrinsics.checkNotNullParameter(followingList, "");
        List<RelationshipItemResponse> list = followingList;
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
        return new Following(arrayList, PaginatorMapperKt.MyBillsEntityDataFactory(followingResponse.getPaginator()));
    }
}
