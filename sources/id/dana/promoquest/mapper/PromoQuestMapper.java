package id.dana.promoquest.mapper;

import id.dana.domain.promoquest.model.Mission;
import id.dana.domain.promoquest.model.Quest;
import id.dana.promoquest.model.MissionModel;
import id.dana.promoquest.model.QuestModel;
import id.dana.utils.DateTimeUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\t\u0010\nJ%\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\b"}, d2 = {"Lid/dana/promoquest/mapper/PromoQuestMapper;", "", "", "Lid/dana/domain/promoquest/model/Mission;", "p0", "Lid/dana/promoquest/model/MissionModel;", "MyBillsEntityDataFactory", "(Ljava/util/List;)Ljava/util/List;", "(Lid/dana/domain/promoquest/model/Mission;)Lid/dana/promoquest/model/MissionModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PromoQuestMapper {
    @Inject
    public PromoQuestMapper() {
    }

    public final List<MissionModel> MyBillsEntityDataFactory(List<Mission> p0) {
        ArrayList arrayList;
        List filterNotNull;
        if (p0 == null || (filterNotNull = CollectionsKt.filterNotNull(p0)) == null) {
            arrayList = null;
        } else {
            List list = filterNotNull;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(MyBillsEntityDataFactory((Mission) it.next()));
            }
            arrayList = arrayList2;
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    public static MissionModel MyBillsEntityDataFactory(Mission mission) {
        ArrayList arrayList;
        Date missionExpireTime;
        List filterNotNull;
        String missionDescription = mission.getMissionDescription();
        String missionId = mission.getMissionId();
        String missionImage = mission.getMissionImage();
        String missionFinishImage = mission.getMissionFinishImage();
        String missionName = mission.getMissionName();
        String missionThumbnail = mission.getMissionThumbnail();
        boolean hasPrize = mission.getHasPrize();
        List<Quest> questList = mission.getQuestList();
        if (questList == null || (filterNotNull = CollectionsKt.filterNotNull(questList)) == null) {
            arrayList = null;
        } else {
            List<Quest> list = filterNotNull;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (Quest quest : list) {
                arrayList2.add(new QuestModel(quest.getId(), quest.getName(), quest.getDescription(), quest.getStatus(), quest.getActionType(), quest.getRedirectType(), quest.getRedirectValue(), quest.isPriceStatus(), quest.getExtendInfo()));
            }
            arrayList = arrayList2;
        }
        ArrayList emptyList = arrayList == null ? CollectionsKt.emptyList() : arrayList;
        long BuiltInFictitiousFunctionClassFactory = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
        Date missionExpireTime2 = mission.getMissionExpireTime();
        if (BuiltInFictitiousFunctionClassFactory > (missionExpireTime2 != null ? missionExpireTime2.getTime() : 0L)) {
            missionExpireTime = new Date();
        } else {
            missionExpireTime = mission.getMissionExpireTime();
            if (missionExpireTime == null) {
                missionExpireTime = new Date();
            }
        }
        Date date = missionExpireTime;
        long BuiltInFictitiousFunctionClassFactory2 = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
        Date missionExpireTime3 = mission.getMissionExpireTime();
        Intrinsics.checkNotNull(missionExpireTime3);
        return new MissionModel(missionId, missionName, (BuiltInFictitiousFunctionClassFactory2 <= missionExpireTime3.getTime() || Intrinsics.areEqual(mission.getMissionStatus(), "FINISH")) ? mission.getMissionStatus() : "CLOSE", missionDescription, date, missionFinishImage, missionImage, missionThumbnail, hasPrize, emptyList, mission.isMissionFlexible(), mission.getMissionTnc());
    }
}
