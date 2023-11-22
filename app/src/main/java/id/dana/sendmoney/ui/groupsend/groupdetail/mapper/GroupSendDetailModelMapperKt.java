package id.dana.sendmoney.ui.groupsend.groupdetail.mapper;

import id.dana.sendmoney.domain.groupsend.model.detail.BizGroupDetailResult;
import id.dana.sendmoney.domain.groupsend.model.detail.ParticipantDetail;
import id.dana.sendmoney.domain.groupsend.model.detail.ParticipantInfoDetail;
import id.dana.sendmoney.domain.groupsend.model.submit.Milestone;
import id.dana.sendmoney.ui.groupsend.groupdetail.model.BizGroupDetailResultModel;
import id.dana.sendmoney.ui.groupsend.groupdetail.model.ParticipantDetailModel;
import id.dana.sendmoney.ui.groupsend.groupdetail.model.ParticipantInfoDetailModel;
import id.dana.sendmoney.ui.groupsend.landing.mapper.GroupSendQueryModelMapperKt;
import id.dana.sendmoney.ui.groupsend.landing.model.GroupModel;
import id.dana.sendmoney.ui.groupsend.summary.model.MilestoneModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/sendmoney/domain/groupsend/model/detail/BizGroupDetailResult;", "Lid/dana/sendmoney/ui/groupsend/groupdetail/model/BizGroupDetailResultModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/sendmoney/domain/groupsend/model/detail/BizGroupDetailResult;)Lid/dana/sendmoney/ui/groupsend/groupdetail/model/BizGroupDetailResultModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GroupSendDetailModelMapperKt {
    public static final BizGroupDetailResultModel KClassImpl$Data$declaredNonStaticMembers$2(BizGroupDetailResult bizGroupDetailResult) {
        String str = "";
        Intrinsics.checkNotNullParameter(bizGroupDetailResult, "");
        GroupModel authRequestContext = GroupSendQueryModelMapperKt.getAuthRequestContext(bizGroupDetailResult.BuiltInFictitiousFunctionClassFactory);
        List<ParticipantDetail> list = bizGroupDetailResult.MyBillsEntityDataFactory;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ParticipantDetail participantDetail = (ParticipantDetail) it.next();
            Intrinsics.checkNotNullParameter(participantDetail, str);
            String str2 = participantDetail.PlaceComponentResult;
            ParticipantInfoDetail participantInfoDetail = participantDetail.getAuthRequestContext;
            Intrinsics.checkNotNullParameter(participantInfoDetail, str);
            String str3 = participantInfoDetail.NetworkUserEntityData$$ExternalSyntheticLambda8;
            String str4 = participantInfoDetail.BuiltInFictitiousFunctionClassFactory;
            String str5 = participantInfoDetail.DatabaseTableConfigUtil;
            String str6 = participantInfoDetail.initRecordTimeStamp;
            String str7 = participantInfoDetail.getAuthRequestContext;
            String str8 = participantInfoDetail.GetContactSyncConfig;
            String str9 = participantInfoDetail.KClassImpl$Data$declaredNonStaticMembers$2;
            String str10 = participantInfoDetail.PlaceComponentResult;
            String str11 = participantInfoDetail.scheduleImpl;
            Iterator it2 = it;
            String str12 = participantInfoDetail.moveToNextValue;
            GroupModel groupModel = authRequestContext;
            String str13 = participantInfoDetail.NetworkUserEntityData$$ExternalSyntheticLambda0;
            List<Milestone> list2 = participantInfoDetail.NetworkUserEntityData$$ExternalSyntheticLambda1;
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator it3 = list2.iterator();
            while (it3.hasNext()) {
                Milestone milestone = (Milestone) it3.next();
                Intrinsics.checkNotNullParameter(milestone, str);
                arrayList3.add(new MilestoneModel(milestone.getAuthRequestContext, milestone.BuiltInFictitiousFunctionClassFactory, milestone.PlaceComponentResult, milestone.MyBillsEntityDataFactory));
                it3 = it3;
                str13 = str13;
                str = str;
            }
            ParticipantDetailModel participantDetailModel = new ParticipantDetailModel(str2, new ParticipantInfoDetailModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, arrayList3, participantInfoDetail.newProxyInstance, participantInfoDetail.NetworkUserEntityData$$ExternalSyntheticLambda2, participantInfoDetail.getErrorConfigVersion, participantInfoDetail.MyBillsEntityDataFactory, participantInfoDetail.lookAheadTest, participantInfoDetail.PrepareContext), participantDetail.MyBillsEntityDataFactory, participantDetail.KClassImpl$Data$declaredNonStaticMembers$2, participantDetail.BuiltInFictitiousFunctionClassFactory);
            arrayList = arrayList2;
            arrayList.add(participantDetailModel);
            it = it2;
            authRequestContext = groupModel;
            str = str;
        }
        return new BizGroupDetailResultModel(authRequestContext, arrayList);
    }
}
