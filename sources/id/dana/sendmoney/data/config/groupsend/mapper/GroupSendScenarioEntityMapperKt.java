package id.dana.sendmoney.data.config.groupsend.mapper;

import id.dana.sendmoney.data.config.groupsend.model.GroupSendScenarioConfigEntity;
import id.dana.sendmoney.domain.groupsend.model.config.GroupSendScenarioConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004*\b\u0012\u0004\u0012\u00020\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/data/config/groupsend/model/GroupSendScenarioConfigEntity;", "Lid/dana/sendmoney/domain/groupsend/model/config/GroupSendScenarioConfig;", "toGroupSendScenarioConfig", "(Lid/dana/sendmoney/data/config/groupsend/model/GroupSendScenarioConfigEntity;)Lid/dana/sendmoney/domain/groupsend/model/config/GroupSendScenarioConfig;", "", "toGroupSendScenarioConfigList", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GroupSendScenarioEntityMapperKt {
    public static final List<GroupSendScenarioConfig> toGroupSendScenarioConfigList(List<GroupSendScenarioConfigEntity> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<GroupSendScenarioConfigEntity> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toGroupSendScenarioConfig((GroupSendScenarioConfigEntity) it.next()));
        }
        return arrayList;
    }

    public static final GroupSendScenarioConfig toGroupSendScenarioConfig(GroupSendScenarioConfigEntity groupSendScenarioConfigEntity) {
        Intrinsics.checkNotNullParameter(groupSendScenarioConfigEntity, "");
        return new GroupSendScenarioConfig(groupSendScenarioConfigEntity.getTitle(), groupSendScenarioConfigEntity.getSubTitle(), groupSendScenarioConfigEntity.getAction(), groupSendScenarioConfigEntity.getBackgroundImg(), groupSendScenarioConfigEntity.getIcon(), groupSendScenarioConfigEntity.getPromoTitle(), groupSendScenarioConfigEntity.getPromoDesc(), groupSendScenarioConfigEntity.getPromoActive(), groupSendScenarioConfigEntity.isEnable());
    }
}
