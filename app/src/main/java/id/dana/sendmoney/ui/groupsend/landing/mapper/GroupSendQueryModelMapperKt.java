package id.dana.sendmoney.ui.groupsend.landing.mapper;

import id.dana.sendmoney.domain.groupsend.model.query.Group;
import id.dana.sendmoney.domain.groupsend.model.submit.Milestone;
import id.dana.sendmoney.domain.groupsend.model.submit.ParticipantInfoSubmit;
import id.dana.sendmoney.domain.groupsend.model.submit.ParticipantSubmit;
import id.dana.sendmoney.ui.groupsend.landing.model.GroupModel;
import id.dana.sendmoney.ui.groupsend.summary.model.MilestoneModel;
import id.dana.sendmoney.ui.groupsend.summary.model.ParticipantInfoSubmitModel;
import id.dana.sendmoney.ui.groupsend.summary.model.ParticipantSubmitModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/sendmoney/domain/groupsend/model/query/Group;", "Lid/dana/sendmoney/ui/groupsend/landing/model/GroupModel;", "getAuthRequestContext", "(Lid/dana/sendmoney/domain/groupsend/model/query/Group;)Lid/dana/sendmoney/ui/groupsend/landing/model/GroupModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GroupSendQueryModelMapperKt {
    public static final GroupModel getAuthRequestContext(Group group) {
        String str;
        Iterator it;
        String str2;
        String str3;
        int i;
        ArrayList arrayList;
        ParticipantInfoSubmitModel participantInfoSubmitModel;
        String str4;
        String str5;
        ParticipantSubmit participantSubmit;
        ArrayList arrayList2;
        String str6 = "";
        Intrinsics.checkNotNullParameter(group, "");
        String str7 = group.KClassImpl$Data$declaredNonStaticMembers$2;
        String str8 = group.PlaceComponentResult;
        int i2 = group.getErrorConfigVersion;
        List<ParticipantSubmit> list = group.getAuthRequestContext;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            ParticipantSubmit participantSubmit2 = (ParticipantSubmit) it2.next();
            Intrinsics.checkNotNullParameter(participantSubmit2, str6);
            ParticipantInfoSubmit participantInfoSubmit = participantSubmit2.KClassImpl$Data$declaredNonStaticMembers$2;
            if (participantInfoSubmit != null) {
                Intrinsics.checkNotNullParameter(participantInfoSubmit, str6);
                String str9 = participantInfoSubmit.NetworkUserEntityData$$ExternalSyntheticLambda4;
                String str10 = participantInfoSubmit.KClassImpl$Data$declaredNonStaticMembers$2;
                String str11 = participantInfoSubmit.NetworkUserEntityData$$ExternalSyntheticLambda8;
                String str12 = participantInfoSubmit.PrepareContext;
                String str13 = participantInfoSubmit.DatabaseTableConfigUtil;
                String str14 = participantInfoSubmit.BuiltInFictitiousFunctionClassFactory;
                String str15 = participantInfoSubmit.NetworkUserEntityData$$ExternalSyntheticLambda2;
                it = it2;
                String str16 = participantInfoSubmit.MyBillsEntityDataFactory;
                i = i2;
                String str17 = participantInfoSubmit.getAuthRequestContext;
                str3 = str8;
                String str18 = participantInfoSubmit.scheduleImpl;
                str2 = str7;
                String str19 = participantInfoSubmit.NetworkUserEntityData$$ExternalSyntheticLambda0;
                String str20 = participantInfoSubmit.getErrorConfigVersion;
                List<Milestone> list2 = participantInfoSubmit.NetworkUserEntityData$$ExternalSyntheticLambda7;
                if (list2 != null) {
                    List<Milestone> list3 = list2;
                    arrayList = arrayList3;
                    str4 = str20;
                    participantSubmit = participantSubmit2;
                    ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                    Iterator it3 = list3.iterator();
                    while (it3.hasNext()) {
                        Milestone milestone = (Milestone) it3.next();
                        Intrinsics.checkNotNullParameter(milestone, str6);
                        arrayList4.add(new MilestoneModel(milestone.getAuthRequestContext, milestone.BuiltInFictitiousFunctionClassFactory, milestone.PlaceComponentResult, milestone.MyBillsEntityDataFactory));
                        it3 = it3;
                        str19 = str19;
                        str6 = str6;
                    }
                    str = str6;
                    str5 = str19;
                    arrayList2 = arrayList4;
                } else {
                    str4 = str20;
                    str = str6;
                    str5 = str19;
                    arrayList = arrayList3;
                    participantSubmit = participantSubmit2;
                    arrayList2 = null;
                }
                participantInfoSubmitModel = new ParticipantInfoSubmitModel(str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str5, str4, arrayList2, participantInfoSubmit.isLayoutRequested, participantInfoSubmit.newProxyInstance, participantInfoSubmit.GetContactSyncConfig, participantInfoSubmit.moveToNextValue, participantInfoSubmit.lookAheadTest, participantInfoSubmit.FragmentBottomSheetPaymentSettingBinding, null, null, null, 3670016, null);
                participantSubmit2 = participantSubmit;
            } else {
                str = str6;
                it = it2;
                str2 = str7;
                str3 = str8;
                i = i2;
                arrayList = arrayList3;
                participantInfoSubmitModel = null;
            }
            String str21 = participantSubmit2.getErrorConfigVersion;
            String str22 = participantSubmit2.PlaceComponentResult;
            String str23 = null;
            arrayList3 = arrayList;
            arrayList3.add(new ParticipantSubmitModel(participantInfoSubmitModel, str23, participantSubmit2.getAuthRequestContext, participantSubmit2.MyBillsEntityDataFactory, str21, str22, participantSubmit2.BuiltInFictitiousFunctionClassFactory, 2, null));
            it2 = it;
            i2 = i;
            str8 = str3;
            str7 = str2;
            str6 = str;
        }
        return new GroupModel(str7, str8, i2, arrayList3, group.BuiltInFictitiousFunctionClassFactory, group.scheduleImpl, group.NetworkUserEntityData$$ExternalSyntheticLambda0, group.MyBillsEntityDataFactory);
    }
}
