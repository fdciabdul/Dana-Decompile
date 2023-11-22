package id.dana.sendmoney.data.api.groupsend.modify.mapper;

import id.dana.sendmoney.data.api.groupsend.modify.model.request.BizGroupModifyEntityRequest;
import id.dana.sendmoney.data.api.groupsend.modify.model.request.ParticipantInfoModifyEntity;
import id.dana.sendmoney.data.api.groupsend.modify.model.request.ParticipantModifyEntity;
import id.dana.sendmoney.data.api.groupsend.modify.model.response.BizGroupModifyEntityResult;
import id.dana.sendmoney.domain.groupsend.model.modify.BizGroupModifyRequest;
import id.dana.sendmoney.domain.groupsend.model.modify.BizGroupModifyResult;
import id.dana.sendmoney.domain.groupsend.model.modify.ParticipantInfoModify;
import id.dana.sendmoney.domain.groupsend.model.modify.ParticipantModify;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\n\u001a\u00020\t*\u00020\b¢\u0006\u0004\b\n\u0010\u000b\u001a\u0011\u0010\u000e\u001a\u00020\r*\u00020\f¢\u0006\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/sendmoney/domain/groupsend/model/modify/BizGroupModifyRequest;", "Lid/dana/sendmoney/data/api/groupsend/modify/model/request/BizGroupModifyEntityRequest;", "toBizGroupModifyEntityRequest", "(Lid/dana/sendmoney/domain/groupsend/model/modify/BizGroupModifyRequest;)Lid/dana/sendmoney/data/api/groupsend/modify/model/request/BizGroupModifyEntityRequest;", "Lid/dana/sendmoney/data/api/groupsend/modify/model/response/BizGroupModifyEntityResult;", "Lid/dana/sendmoney/domain/groupsend/model/modify/BizGroupModifyResult;", "toBizGroupModifyResult", "(Lid/dana/sendmoney/data/api/groupsend/modify/model/response/BizGroupModifyEntityResult;)Lid/dana/sendmoney/domain/groupsend/model/modify/BizGroupModifyResult;", "Lid/dana/sendmoney/domain/groupsend/model/modify/ParticipantInfoModify;", "Lid/dana/sendmoney/data/api/groupsend/modify/model/request/ParticipantInfoModifyEntity;", "toParticipantInfoModifyEntity", "(Lid/dana/sendmoney/domain/groupsend/model/modify/ParticipantInfoModify;)Lid/dana/sendmoney/data/api/groupsend/modify/model/request/ParticipantInfoModifyEntity;", "Lid/dana/sendmoney/domain/groupsend/model/modify/ParticipantModify;", "Lid/dana/sendmoney/data/api/groupsend/modify/model/request/ParticipantModifyEntity;", "toParticipantModifyEntity", "(Lid/dana/sendmoney/domain/groupsend/model/modify/ParticipantModify;)Lid/dana/sendmoney/data/api/groupsend/modify/model/request/ParticipantModifyEntity;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BizGroupModifyEntityMapperKt {
    public static final BizGroupModifyResult toBizGroupModifyResult(BizGroupModifyEntityResult bizGroupModifyEntityResult) {
        Intrinsics.checkNotNullParameter(bizGroupModifyEntityResult, "");
        String groupId = bizGroupModifyEntityResult.getGroupId();
        return new BizGroupModifyResult(groupId != null ? groupId : "");
    }

    public static final BizGroupModifyEntityRequest toBizGroupModifyEntityRequest(BizGroupModifyRequest bizGroupModifyRequest) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(bizGroupModifyRequest, "");
        String str = bizGroupModifyRequest.BuiltInFictitiousFunctionClassFactory;
        String str2 = bizGroupModifyRequest.getAuthRequestContext;
        String str3 = bizGroupModifyRequest.KClassImpl$Data$declaredNonStaticMembers$2;
        String str4 = bizGroupModifyRequest.PlaceComponentResult;
        String str5 = bizGroupModifyRequest.MyBillsEntityDataFactory;
        List<ParticipantModify> list = bizGroupModifyRequest.scheduleImpl;
        if (list != null) {
            List<ParticipantModify> list2 = list;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList2.add(toParticipantModifyEntity((ParticipantModify) it.next()));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        return new BizGroupModifyEntityRequest(str, str2, str3, str4, str5, arrayList);
    }

    public static final ParticipantInfoModifyEntity toParticipantInfoModifyEntity(ParticipantInfoModify participantInfoModify) {
        Intrinsics.checkNotNullParameter(participantInfoModify, "");
        return new ParticipantInfoModifyEntity(participantInfoModify.KClassImpl$Data$declaredNonStaticMembers$2, participantInfoModify.getAuthRequestContext);
    }

    public static final ParticipantModifyEntity toParticipantModifyEntity(ParticipantModify participantModify) {
        Intrinsics.checkNotNullParameter(participantModify, "");
        String str = participantModify.KClassImpl$Data$declaredNonStaticMembers$2;
        String str2 = participantModify.MyBillsEntityDataFactory;
        ParticipantInfoModify participantInfoModify = participantModify.getAuthRequestContext;
        return new ParticipantModifyEntity(str, str2, participantInfoModify != null ? toParticipantInfoModifyEntity(participantInfoModify) : null);
    }
}
