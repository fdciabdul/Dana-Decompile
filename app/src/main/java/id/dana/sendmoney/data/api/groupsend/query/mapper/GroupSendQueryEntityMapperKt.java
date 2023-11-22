package id.dana.sendmoney.data.api.groupsend.query.mapper;

import id.dana.sendmoney.data.api.groupsend.detail.mapper.GroupDetailEntityMapperKt;
import id.dana.sendmoney.data.api.groupsend.query.model.GroupEntity;
import id.dana.sendmoney.data.api.groupsend.query.model.TransferUserInfoQueryEntity;
import id.dana.sendmoney.data.api.groupsend.query.model.response.BizGroupQueryEntityResult;
import id.dana.sendmoney.data.api.groupsend.submit.model.ParticipantSubmitEntity;
import id.dana.sendmoney.domain.groupsend.model.query.BizGroupQueryResult;
import id.dana.sendmoney.domain.groupsend.model.query.Group;
import id.dana.sendmoney.domain.groupsend.model.query.TransferUserInfoQuery;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\n\u001a\u00020\t*\u00020\b¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/sendmoney/data/api/groupsend/query/model/response/BizGroupQueryEntityResult;", "Lid/dana/sendmoney/domain/groupsend/model/query/BizGroupQueryResult;", "toBizGroupQueryResult", "(Lid/dana/sendmoney/data/api/groupsend/query/model/response/BizGroupQueryEntityResult;)Lid/dana/sendmoney/domain/groupsend/model/query/BizGroupQueryResult;", "Lid/dana/sendmoney/data/api/groupsend/query/model/GroupEntity;", "Lid/dana/sendmoney/domain/groupsend/model/query/Group;", "toGroup", "(Lid/dana/sendmoney/data/api/groupsend/query/model/GroupEntity;)Lid/dana/sendmoney/domain/groupsend/model/query/Group;", "Lid/dana/sendmoney/data/api/groupsend/query/model/TransferUserInfoQueryEntity;", "Lid/dana/sendmoney/domain/groupsend/model/query/TransferUserInfoQuery;", "toTransferUserInfoQuery", "(Lid/dana/sendmoney/data/api/groupsend/query/model/TransferUserInfoQueryEntity;)Lid/dana/sendmoney/domain/groupsend/model/query/TransferUserInfoQuery;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GroupSendQueryEntityMapperKt {
    public static final BizGroupQueryResult toBizGroupQueryResult(BizGroupQueryEntityResult bizGroupQueryEntityResult) {
        ArrayList emptyList;
        Intrinsics.checkNotNullParameter(bizGroupQueryEntityResult, "");
        List<GroupEntity> groups = bizGroupQueryEntityResult.getGroups();
        if (groups == null) {
            emptyList = CollectionsKt.emptyList();
        } else {
            List<GroupEntity> list = groups;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(toGroup((GroupEntity) it.next()));
            }
            emptyList = arrayList;
        }
        return new BizGroupQueryResult(emptyList);
    }

    public static final Group toGroup(GroupEntity groupEntity) {
        ArrayList emptyList;
        Intrinsics.checkNotNullParameter(groupEntity, "");
        String groupId = groupEntity.getGroupId();
        String str = groupId == null ? "" : groupId;
        String groupName = groupEntity.getGroupName();
        String str2 = groupName == null ? "" : groupName;
        Integer totalParticipant = groupEntity.getTotalParticipant();
        int intValue = totalParticipant != null ? totalParticipant.intValue() : 0;
        List<ParticipantSubmitEntity> participants = groupEntity.getParticipants();
        if (participants == null) {
            emptyList = CollectionsKt.emptyList();
        } else {
            List<ParticipantSubmitEntity> list = participants;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(GroupDetailEntityMapperKt.toParticipantSubmit((ParticipantSubmitEntity) it.next()));
            }
            emptyList = arrayList;
        }
        String groupImageUrl = groupEntity.getGroupImageUrl();
        String str3 = groupImageUrl == null ? "" : groupImageUrl;
        String subBizType = groupEntity.getSubBizType();
        String str4 = subBizType == null ? "" : subBizType;
        String status = groupEntity.getStatus();
        String str5 = status == null ? "" : status;
        String lastTransactionTime = groupEntity.getLastTransactionTime();
        return new Group(str, str2, intValue, emptyList, str3, str4, str5, lastTransactionTime == null ? "" : lastTransactionTime);
    }

    public static final TransferUserInfoQuery toTransferUserInfoQuery(TransferUserInfoQueryEntity transferUserInfoQueryEntity) {
        Intrinsics.checkNotNullParameter(transferUserInfoQueryEntity, "");
        String userId = transferUserInfoQueryEntity.getUserId();
        if (userId == null) {
            userId = "";
        }
        String loginId = transferUserInfoQueryEntity.getLoginId();
        if (loginId == null) {
            loginId = "";
        }
        String avatar = transferUserInfoQueryEntity.getAvatar();
        return new TransferUserInfoQuery(userId, loginId, avatar != null ? avatar : "");
    }
}
