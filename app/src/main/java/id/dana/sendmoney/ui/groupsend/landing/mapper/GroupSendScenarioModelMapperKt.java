package id.dana.sendmoney.ui.groupsend.landing.mapper;

import id.dana.sendmoney.domain.groupsend.model.config.GroupSendScenarioConfig;
import id.dana.sendmoney.ui.groupsend.landing.model.GroupSendScenarioConfigModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "Lid/dana/sendmoney/domain/groupsend/model/config/GroupSendScenarioConfig;", "Lid/dana/sendmoney/ui/groupsend/landing/model/GroupSendScenarioConfigModel;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GroupSendScenarioModelMapperKt {
    public static final List<GroupSendScenarioConfigModel> BuiltInFictitiousFunctionClassFactory(List<GroupSendScenarioConfig> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<GroupSendScenarioConfig> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (GroupSendScenarioConfig groupSendScenarioConfig : list2) {
            Intrinsics.checkNotNullParameter(groupSendScenarioConfig, "");
            arrayList.add(new GroupSendScenarioConfigModel(groupSendScenarioConfig.lookAheadTest, groupSendScenarioConfig.scheduleImpl, groupSendScenarioConfig.KClassImpl$Data$declaredNonStaticMembers$2, groupSendScenarioConfig.BuiltInFictitiousFunctionClassFactory, groupSendScenarioConfig.MyBillsEntityDataFactory, groupSendScenarioConfig.getErrorConfigVersion, groupSendScenarioConfig.NetworkUserEntityData$$ExternalSyntheticLambda0, groupSendScenarioConfig.getGetAuthRequestContext(), groupSendScenarioConfig.getPlaceComponentResult()));
        }
        return arrayList;
    }
}
