package id.dana.sendmoney.data.api.groupsend.submit.mapper;

import id.dana.data.config.source.sharedpreference.CurrencyAmountModelEntityData;
import id.dana.domain.user.CurrencyAmount;
import id.dana.sendmoney.data.api.groupsend.submit.model.CreatorGroupIdentifier;
import id.dana.sendmoney.data.api.groupsend.submit.model.MilestoneEntity;
import id.dana.sendmoney.data.api.groupsend.submit.model.ParticipantInfoSubmitEntity;
import id.dana.sendmoney.data.api.groupsend.submit.model.ParticipantSubmitEntity;
import id.dana.sendmoney.data.api.groupsend.submit.model.request.BizGroupTransferSubmitRequest;
import id.dana.sendmoney.data.api.groupsend.submit.model.response.BizGroupTransferSubmitResult;
import id.dana.sendmoney.domain.groupsend.interactor.ConfirmSendMoneyGroup;
import id.dana.sendmoney.domain.groupsend.model.submit.Milestone;
import id.dana.sendmoney.domain.groupsend.model.submit.ParticipantInfoSubmit;
import id.dana.sendmoney.domain.groupsend.model.submit.ParticipantSubmit;
import id.dana.sendmoney.domain.groupsend.model.submit.SendMoneyGroupConfirm;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0011\u0010\u0007\u001a\u00020\u0006*\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b\u001a\u0013\u0010\t\u001a\u00020\u0002*\u00020\u0000H\u0002¢\u0006\u0004\b\t\u0010\u0004\u001a\u0011\u0010\f\u001a\u00020\u000b*\u00020\n¢\u0006\u0004\b\f\u0010\r\u001a\u0011\u0010\u000e\u001a\u00020\n*\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0011\u0010\u0012\u001a\u00020\u0011*\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0011\u0010\u0016\u001a\u00020\u0015*\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0011\u0010\u001a\u001a\u00020\u0019*\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001b"}, d2 = {"Lid/dana/data/config/source/sharedpreference/CurrencyAmountModelEntityData;", "originalAmount", "Lid/dana/domain/user/CurrencyAmount;", "getOriginalAmount", "(Lid/dana/data/config/source/sharedpreference/CurrencyAmountModelEntityData;)Lid/dana/domain/user/CurrencyAmount;", "Lid/dana/sendmoney/domain/groupsend/interactor/ConfirmSendMoneyGroup$Param;", "Lid/dana/sendmoney/data/api/groupsend/submit/model/request/BizGroupTransferSubmitRequest;", "toBizGroupTransferSubmitRequest", "(Lid/dana/sendmoney/domain/groupsend/interactor/ConfirmSendMoneyGroup$Param;)Lid/dana/sendmoney/data/api/groupsend/submit/model/request/BizGroupTransferSubmitRequest;", "toCurrencyAmount", "Lid/dana/sendmoney/data/api/groupsend/submit/model/MilestoneEntity;", "Lid/dana/sendmoney/domain/groupsend/model/submit/Milestone;", "toMilestone", "(Lid/dana/sendmoney/data/api/groupsend/submit/model/MilestoneEntity;)Lid/dana/sendmoney/domain/groupsend/model/submit/Milestone;", "toMilestoneEntity", "(Lid/dana/sendmoney/domain/groupsend/model/submit/Milestone;)Lid/dana/sendmoney/data/api/groupsend/submit/model/MilestoneEntity;", "Lid/dana/sendmoney/domain/groupsend/model/submit/ParticipantInfoSubmit;", "Lid/dana/sendmoney/data/api/groupsend/submit/model/ParticipantInfoSubmitEntity;", "toParticipantInfoSubmitEntity", "(Lid/dana/sendmoney/domain/groupsend/model/submit/ParticipantInfoSubmit;)Lid/dana/sendmoney/data/api/groupsend/submit/model/ParticipantInfoSubmitEntity;", "Lid/dana/sendmoney/domain/groupsend/model/submit/ParticipantSubmit;", "Lid/dana/sendmoney/data/api/groupsend/submit/model/ParticipantSubmitEntity;", "toParticipantSubmitEntity", "(Lid/dana/sendmoney/domain/groupsend/model/submit/ParticipantSubmit;)Lid/dana/sendmoney/data/api/groupsend/submit/model/ParticipantSubmitEntity;", "Lid/dana/sendmoney/data/api/groupsend/submit/model/response/BizGroupTransferSubmitResult;", "Lid/dana/sendmoney/domain/groupsend/model/submit/SendMoneyGroupConfirm;", "toSendMoneyGroupConfirm", "(Lid/dana/sendmoney/data/api/groupsend/submit/model/response/BizGroupTransferSubmitResult;)Lid/dana/sendmoney/domain/groupsend/model/submit/SendMoneyGroupConfirm;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BizGroupTransferEntityMapperKt {
    public static final Milestone toMilestone(MilestoneEntity milestoneEntity) {
        Intrinsics.checkNotNullParameter(milestoneEntity, "");
        return new Milestone(milestoneEntity.getTimeScale(), milestoneEntity.getTimeConstraint(), milestoneEntity.getBizScenario(), milestoneEntity.getTemplateId());
    }

    public static final SendMoneyGroupConfirm toSendMoneyGroupConfirm(BizGroupTransferSubmitResult bizGroupTransferSubmitResult) {
        Intrinsics.checkNotNullParameter(bizGroupTransferSubmitResult, "");
        String requestId = bizGroupTransferSubmitResult.getRequestId();
        String batchNo = bizGroupTransferSubmitResult.getBatchNo();
        String payTransferNo = bizGroupTransferSubmitResult.getPayTransferNo();
        String activityType = bizGroupTransferSubmitResult.getActivityType();
        String state = bizGroupTransferSubmitResult.getState();
        String subState = bizGroupTransferSubmitResult.getSubState();
        CurrencyAmount originalAmount = getOriginalAmount(bizGroupTransferSubmitResult.getOriginalAmount());
        CreatorGroupIdentifier creatorGroupIdentifier = bizGroupTransferSubmitResult.getCreatorGroupIdentifier();
        String groupId = creatorGroupIdentifier != null ? creatorGroupIdentifier.getGroupId() : null;
        CreatorGroupIdentifier creatorGroupIdentifier2 = bizGroupTransferSubmitResult.getCreatorGroupIdentifier();
        return new SendMoneyGroupConfirm(requestId, batchNo, payTransferNo, activityType, state, subState, originalAmount, groupId, creatorGroupIdentifier2 != null ? creatorGroupIdentifier2.getGroupIdType() : null);
    }

    private static final CurrencyAmount toCurrencyAmount(CurrencyAmountModelEntityData currencyAmountModelEntityData) {
        return new CurrencyAmount(currencyAmountModelEntityData.getAmount(), currencyAmountModelEntityData.getCurrency());
    }

    private static final CurrencyAmount getOriginalAmount(CurrencyAmountModelEntityData currencyAmountModelEntityData) {
        CurrencyAmount currencyAmount;
        return (currencyAmountModelEntityData == null || (currencyAmount = toCurrencyAmount(currencyAmountModelEntityData)) == null) ? new CurrencyAmount("", "") : currencyAmount;
    }

    public static final BizGroupTransferSubmitRequest toBizGroupTransferSubmitRequest(ConfirmSendMoneyGroup.Param param) {
        Intrinsics.checkNotNullParameter(param, "");
        String str = param.PlaceComponentResult;
        String str2 = param.KClassImpl$Data$declaredNonStaticMembers$2;
        String str3 = param.getAuthRequestContext;
        String str4 = param.BuiltInFictitiousFunctionClassFactory;
        List<ParticipantSubmit> list = param.MyBillsEntityDataFactory;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(toParticipantSubmitEntity((ParticipantSubmit) it.next()));
        }
        return new BizGroupTransferSubmitRequest(str, str2, str3, str4, arrayList, param.moveToNextValue);
    }

    public static final MilestoneEntity toMilestoneEntity(Milestone milestone) {
        Intrinsics.checkNotNullParameter(milestone, "");
        return new MilestoneEntity(milestone.getAuthRequestContext, milestone.BuiltInFictitiousFunctionClassFactory, milestone.PlaceComponentResult, milestone.MyBillsEntityDataFactory);
    }

    public static final ParticipantInfoSubmitEntity toParticipantInfoSubmitEntity(ParticipantInfoSubmit participantInfoSubmit) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(participantInfoSubmit, "");
        String str = participantInfoSubmit.NetworkUserEntityData$$ExternalSyntheticLambda4;
        String str2 = participantInfoSubmit.KClassImpl$Data$declaredNonStaticMembers$2;
        String str3 = participantInfoSubmit.NetworkUserEntityData$$ExternalSyntheticLambda8;
        String str4 = participantInfoSubmit.PrepareContext;
        String str5 = participantInfoSubmit.DatabaseTableConfigUtil;
        String str6 = participantInfoSubmit.BuiltInFictitiousFunctionClassFactory;
        String str7 = participantInfoSubmit.NetworkUserEntityData$$ExternalSyntheticLambda2;
        String str8 = participantInfoSubmit.MyBillsEntityDataFactory;
        String str9 = participantInfoSubmit.getAuthRequestContext;
        String str10 = participantInfoSubmit.scheduleImpl;
        String str11 = participantInfoSubmit.NetworkUserEntityData$$ExternalSyntheticLambda0;
        String str12 = participantInfoSubmit.getErrorConfigVersion;
        List<Milestone> list = participantInfoSubmit.NetworkUserEntityData$$ExternalSyntheticLambda7;
        if (list != null) {
            List<Milestone> list2 = list;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList2.add(toMilestoneEntity((Milestone) it.next()));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        return new ParticipantInfoSubmitEntity(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, arrayList, participantInfoSubmit.isLayoutRequested, participantInfoSubmit.newProxyInstance, participantInfoSubmit.GetContactSyncConfig, participantInfoSubmit.moveToNextValue, participantInfoSubmit.lookAheadTest, participantInfoSubmit.FragmentBottomSheetPaymentSettingBinding, participantInfoSubmit.PlaceComponentResult, participantInfoSubmit.NetworkUserEntityData$$ExternalSyntheticLambda1, participantInfoSubmit.initRecordTimeStamp);
    }

    public static final ParticipantSubmitEntity toParticipantSubmitEntity(ParticipantSubmit participantSubmit) {
        Intrinsics.checkNotNullParameter(participantSubmit, "");
        ParticipantInfoSubmit participantInfoSubmit = participantSubmit.KClassImpl$Data$declaredNonStaticMembers$2;
        return new ParticipantSubmitEntity(participantInfoSubmit != null ? toParticipantInfoSubmitEntity(participantInfoSubmit) : null, participantSubmit.getAuthRequestContext, participantSubmit.MyBillsEntityDataFactory, participantSubmit.getErrorConfigVersion, participantSubmit.PlaceComponentResult, participantSubmit.BuiltInFictitiousFunctionClassFactory);
    }
}
