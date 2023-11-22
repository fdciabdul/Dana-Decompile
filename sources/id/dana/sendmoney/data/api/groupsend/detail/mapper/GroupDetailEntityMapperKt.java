package id.dana.sendmoney.data.api.groupsend.detail.mapper;

import id.dana.sendmoney.data.api.groupsend.detail.model.ParticipantDetailEntity;
import id.dana.sendmoney.data.api.groupsend.detail.model.ParticipantInfoDetailEntity;
import id.dana.sendmoney.data.api.groupsend.detail.model.response.BizGroupDetailEntityResult;
import id.dana.sendmoney.data.api.groupsend.query.model.GroupEntity;
import id.dana.sendmoney.data.api.groupsend.submit.model.MilestoneEntity;
import id.dana.sendmoney.data.api.groupsend.submit.model.ParticipantInfoSubmitEntity;
import id.dana.sendmoney.data.api.groupsend.submit.model.ParticipantSubmitEntity;
import id.dana.sendmoney.domain.groupsend.model.detail.BizGroupDetailResult;
import id.dana.sendmoney.domain.groupsend.model.detail.ParticipantDetail;
import id.dana.sendmoney.domain.groupsend.model.detail.ParticipantInfoDetail;
import id.dana.sendmoney.domain.groupsend.model.query.Group;
import id.dana.sendmoney.domain.groupsend.model.submit.Milestone;
import id.dana.sendmoney.domain.groupsend.model.submit.ParticipantInfoSubmit;
import id.dana.sendmoney.domain.groupsend.model.submit.ParticipantSubmit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0006\u001a\u00020\u0005*\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\n\u001a\u00020\t*\u00020\b¢\u0006\u0004\b\n\u0010\u000b\u001a\u0013\u0010\u000e\u001a\u00020\r*\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0013\u0010\u0012\u001a\u00020\u0011*\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0011\u0010\u0016\u001a\u00020\u0015*\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0011\u0010\u001a\u001a\u00020\u0019*\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001b"}, d2 = {"Lid/dana/sendmoney/data/api/groupsend/detail/model/response/BizGroupDetailEntityResult;", "Lid/dana/sendmoney/domain/groupsend/model/detail/BizGroupDetailResult;", "toBizGroupDetailResult", "(Lid/dana/sendmoney/data/api/groupsend/detail/model/response/BizGroupDetailEntityResult;)Lid/dana/sendmoney/domain/groupsend/model/detail/BizGroupDetailResult;", "Lid/dana/sendmoney/data/api/groupsend/query/model/GroupEntity;", "Lid/dana/sendmoney/domain/groupsend/model/query/Group;", "toGroupDetail", "(Lid/dana/sendmoney/data/api/groupsend/query/model/GroupEntity;)Lid/dana/sendmoney/domain/groupsend/model/query/Group;", "Lid/dana/sendmoney/data/api/groupsend/submit/model/MilestoneEntity;", "Lid/dana/sendmoney/domain/groupsend/model/submit/Milestone;", "toMilestone", "(Lid/dana/sendmoney/data/api/groupsend/submit/model/MilestoneEntity;)Lid/dana/sendmoney/domain/groupsend/model/submit/Milestone;", "Lid/dana/sendmoney/data/api/groupsend/detail/model/ParticipantDetailEntity;", "Lid/dana/sendmoney/domain/groupsend/model/detail/ParticipantDetail;", "toParticipantDetail", "(Lid/dana/sendmoney/data/api/groupsend/detail/model/ParticipantDetailEntity;)Lid/dana/sendmoney/domain/groupsend/model/detail/ParticipantDetail;", "Lid/dana/sendmoney/data/api/groupsend/detail/model/ParticipantInfoDetailEntity;", "Lid/dana/sendmoney/domain/groupsend/model/detail/ParticipantInfoDetail;", "toParticipantInfoDetail", "(Lid/dana/sendmoney/data/api/groupsend/detail/model/ParticipantInfoDetailEntity;)Lid/dana/sendmoney/domain/groupsend/model/detail/ParticipantInfoDetail;", "Lid/dana/sendmoney/data/api/groupsend/submit/model/ParticipantInfoSubmitEntity;", "Lid/dana/sendmoney/domain/groupsend/model/submit/ParticipantInfoSubmit;", "toParticipantInfoSubmit", "(Lid/dana/sendmoney/data/api/groupsend/submit/model/ParticipantInfoSubmitEntity;)Lid/dana/sendmoney/domain/groupsend/model/submit/ParticipantInfoSubmit;", "Lid/dana/sendmoney/data/api/groupsend/submit/model/ParticipantSubmitEntity;", "Lid/dana/sendmoney/domain/groupsend/model/submit/ParticipantSubmit;", "toParticipantSubmit", "(Lid/dana/sendmoney/data/api/groupsend/submit/model/ParticipantSubmitEntity;)Lid/dana/sendmoney/domain/groupsend/model/submit/ParticipantSubmit;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GroupDetailEntityMapperKt {
    public static final BizGroupDetailResult toBizGroupDetailResult(BizGroupDetailEntityResult bizGroupDetailEntityResult) {
        ArrayList emptyList;
        Intrinsics.checkNotNullParameter(bizGroupDetailEntityResult, "");
        Group groupDetail = toGroupDetail(bizGroupDetailEntityResult.getGroup());
        List<ParticipantDetailEntity> participants = bizGroupDetailEntityResult.getParticipants();
        if (participants == null) {
            emptyList = CollectionsKt.emptyList();
        } else {
            List<ParticipantDetailEntity> list = participants;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(toParticipantDetail((ParticipantDetailEntity) it.next()));
            }
            emptyList = arrayList;
        }
        return new BizGroupDetailResult(groupDetail, emptyList);
    }

    public static final Group toGroupDetail(GroupEntity groupEntity) {
        ArrayList emptyList;
        List<ParticipantSubmitEntity> participants;
        Integer totalParticipant;
        String groupId = groupEntity != null ? groupEntity.getGroupId() : null;
        String str = groupId == null ? "" : groupId;
        String groupName = groupEntity != null ? groupEntity.getGroupName() : null;
        String str2 = groupName == null ? "" : groupName;
        int intValue = (groupEntity == null || (totalParticipant = groupEntity.getTotalParticipant()) == null) ? 0 : totalParticipant.intValue();
        String groupImageUrl = groupEntity != null ? groupEntity.getGroupImageUrl() : null;
        String str3 = groupImageUrl == null ? "" : groupImageUrl;
        if (groupEntity == null || (participants = groupEntity.getParticipants()) == null) {
            emptyList = CollectionsKt.emptyList();
        } else {
            List<ParticipantSubmitEntity> list = participants;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(toParticipantSubmit((ParticipantSubmitEntity) it.next()));
            }
            emptyList = arrayList;
        }
        String subBizType = groupEntity != null ? groupEntity.getSubBizType() : null;
        String str4 = subBizType == null ? "" : subBizType;
        String status = groupEntity != null ? groupEntity.getStatus() : null;
        String str5 = status == null ? "" : status;
        String lastTransactionTime = groupEntity != null ? groupEntity.getLastTransactionTime() : null;
        return new Group(str, str2, intValue, emptyList, str3, str4, str5, lastTransactionTime == null ? "" : lastTransactionTime);
    }

    public static final ParticipantSubmit toParticipantSubmit(ParticipantSubmitEntity participantSubmitEntity) {
        Intrinsics.checkNotNullParameter(participantSubmitEntity, "");
        ParticipantInfoSubmitEntity participantInfo = participantSubmitEntity.getParticipantInfo();
        ParticipantInfoSubmit participantInfoSubmit = participantInfo != null ? toParticipantInfoSubmit(participantInfo) : null;
        String groupDetailId = participantSubmitEntity.getGroupDetailId();
        String subBizType = participantSubmitEntity.getSubBizType();
        String transferAmount = participantSubmitEntity.getTransferAmount();
        return new ParticipantSubmit(participantInfoSubmit, groupDetailId, subBizType, transferAmount == null ? "" : transferAmount, participantSubmitEntity.getChargeAmount(), participantSubmitEntity.getExtendInfo());
    }

    public static final ParticipantInfoSubmit toParticipantInfoSubmit(ParticipantInfoSubmitEntity participantInfoSubmitEntity) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(participantInfoSubmitEntity, "");
        String userId = participantInfoSubmitEntity.getUserId();
        String avatar = participantInfoSubmitEntity.getAvatar();
        String phoneNumber = participantInfoSubmitEntity.getPhoneNumber();
        String nickName = participantInfoSubmitEntity.getNickName();
        String maskedNickName = participantInfoSubmitEntity.getMaskedNickName();
        String contactName = participantInfoSubmitEntity.getContactName();
        String maskedLoginId = participantInfoSubmitEntity.getMaskedLoginId();
        String comment = participantInfoSubmitEntity.getComment();
        String cardIndexNo = participantInfoSubmitEntity.getCardIndexNo();
        String formattedHolderName = participantInfoSubmitEntity.getFormattedHolderName();
        String holderFirstName = participantInfoSubmitEntity.getHolderFirstName();
        String holderLastName = participantInfoSubmitEntity.getHolderLastName();
        List<MilestoneEntity> milestoneList = participantInfoSubmitEntity.getMilestoneList();
        if (milestoneList != null) {
            List<MilestoneEntity> list = milestoneList;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(toMilestone((MilestoneEntity) it.next()));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        return new ParticipantInfoSubmit(userId, avatar, phoneNumber, nickName, maskedNickName, contactName, maskedLoginId, comment, cardIndexNo, formattedHolderName, holderFirstName, holderLastName, arrayList, participantInfoSubmitEntity.getSenderName(), participantInfoSubmitEntity.getPayMethod(), participantInfoSubmitEntity.getMaskedCardNo(), participantInfoSubmitEntity.getExternalSystemId(), participantInfoSubmitEntity.getInstLocalName(), participantInfoSubmitEntity.getWithdrawInstId(), participantInfoSubmitEntity.getCertified(), participantInfoSubmitEntity.getKycLevel(), participantInfoSubmitEntity.getInternalKycLevel());
    }

    public static final ParticipantDetail toParticipantDetail(ParticipantDetailEntity participantDetailEntity) {
        String groupDetailId = participantDetailEntity != null ? participantDetailEntity.getGroupDetailId() : null;
        String str = groupDetailId == null ? "" : groupDetailId;
        ParticipantInfoDetail participantInfoDetail = toParticipantInfoDetail(participantDetailEntity != null ? participantDetailEntity.getParticipantInfo() : null);
        String participantType = participantDetailEntity != null ? participantDetailEntity.getParticipantType() : null;
        String str2 = participantType == null ? "" : participantType;
        String subBizType = participantDetailEntity != null ? participantDetailEntity.getSubBizType() : null;
        String str3 = subBizType == null ? "" : subBizType;
        String extendInfo = participantDetailEntity != null ? participantDetailEntity.getExtendInfo() : null;
        return new ParticipantDetail(str, participantInfoDetail, str2, str3, extendInfo == null ? "" : extendInfo);
    }

    public static final ParticipantInfoDetail toParticipantInfoDetail(ParticipantInfoDetailEntity participantInfoDetailEntity) {
        ArrayList emptyList;
        List<MilestoneEntity> milestoneList;
        String userId = participantInfoDetailEntity != null ? participantInfoDetailEntity.getUserId() : null;
        String str = userId == null ? "" : userId;
        String avatar = participantInfoDetailEntity != null ? participantInfoDetailEntity.getAvatar() : null;
        String str2 = avatar == null ? "" : avatar;
        String phoneNumber = participantInfoDetailEntity != null ? participantInfoDetailEntity.getPhoneNumber() : null;
        String str3 = phoneNumber == null ? "" : phoneNumber;
        String nickName = participantInfoDetailEntity != null ? participantInfoDetailEntity.getNickName() : null;
        String str4 = nickName == null ? "" : nickName;
        String contactName = participantInfoDetailEntity != null ? participantInfoDetailEntity.getContactName() : null;
        String str5 = contactName == null ? "" : contactName;
        String maskedLoginId = participantInfoDetailEntity != null ? participantInfoDetailEntity.getMaskedLoginId() : null;
        String str6 = maskedLoginId == null ? "" : maskedLoginId;
        String comment = participantInfoDetailEntity != null ? participantInfoDetailEntity.getComment() : null;
        String str7 = comment == null ? "" : comment;
        String cardIndexNo = participantInfoDetailEntity != null ? participantInfoDetailEntity.getCardIndexNo() : null;
        String str8 = cardIndexNo == null ? "" : cardIndexNo;
        String formattedHolderName = participantInfoDetailEntity != null ? participantInfoDetailEntity.getFormattedHolderName() : null;
        String str9 = formattedHolderName == null ? "" : formattedHolderName;
        String holderFirstName = participantInfoDetailEntity != null ? participantInfoDetailEntity.getHolderFirstName() : null;
        String str10 = holderFirstName == null ? "" : holderFirstName;
        String holderLastName = participantInfoDetailEntity != null ? participantInfoDetailEntity.getHolderLastName() : null;
        String str11 = holderLastName == null ? "" : holderLastName;
        if (participantInfoDetailEntity == null || (milestoneList = participantInfoDetailEntity.getMilestoneList()) == null) {
            emptyList = CollectionsKt.emptyList();
        } else {
            List<MilestoneEntity> list = milestoneList;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(toMilestone((MilestoneEntity) it.next()));
            }
            emptyList = arrayList;
        }
        String senderName = participantInfoDetailEntity != null ? participantInfoDetailEntity.getSenderName() : null;
        String str12 = senderName == null ? "" : senderName;
        String payMethod = participantInfoDetailEntity != null ? participantInfoDetailEntity.getPayMethod() : null;
        String str13 = payMethod == null ? "" : payMethod;
        String maskedCardNo = participantInfoDetailEntity != null ? participantInfoDetailEntity.getMaskedCardNo() : null;
        String str14 = maskedCardNo == null ? "" : maskedCardNo;
        String externalSystemId = participantInfoDetailEntity != null ? participantInfoDetailEntity.getExternalSystemId() : null;
        String str15 = externalSystemId == null ? "" : externalSystemId;
        String instLocalName = participantInfoDetailEntity != null ? participantInfoDetailEntity.getInstLocalName() : null;
        String str16 = instLocalName == null ? "" : instLocalName;
        String withdrawInstId = participantInfoDetailEntity != null ? participantInfoDetailEntity.getWithdrawInstId() : null;
        return new ParticipantInfoDetail(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, emptyList, str12, str13, str14, str15, str16, withdrawInstId == null ? "" : withdrawInstId);
    }

    public static final Milestone toMilestone(MilestoneEntity milestoneEntity) {
        Intrinsics.checkNotNullParameter(milestoneEntity, "");
        String timeScale = milestoneEntity.getTimeScale();
        if (timeScale == null) {
            timeScale = "";
        }
        Integer timeConstraint = milestoneEntity.getTimeConstraint();
        int intValue = timeConstraint != null ? timeConstraint.intValue() : 0;
        String bizScenario = milestoneEntity.getBizScenario();
        if (bizScenario == null) {
            bizScenario = "";
        }
        String templateId = milestoneEntity.getTemplateId();
        return new Milestone(timeScale, Integer.valueOf(intValue), bizScenario, templateId != null ? templateId : "");
    }
}
