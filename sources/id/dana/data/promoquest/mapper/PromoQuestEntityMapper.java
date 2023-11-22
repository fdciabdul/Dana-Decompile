package id.dana.data.promoquest.mapper;

import id.dana.data.promoquest.repository.source.network.result.ListOfMissionResult;
import id.dana.data.promoquest.repository.source.network.result.MissionEntityResult;
import id.dana.domain.promoquest.model.Mission;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\t\u001a\u00020\u0005*\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/data/promoquest/mapper/PromoQuestEntityMapper;", "", "Lid/dana/data/promoquest/repository/source/network/result/ListOfMissionResult;", "listOfMissionResult", "", "Lid/dana/domain/promoquest/model/Mission;", "transform", "(Lid/dana/data/promoquest/repository/source/network/result/ListOfMissionResult;)Ljava/util/List;", "Lid/dana/data/promoquest/repository/source/network/result/MissionEntityResult;", "toMission", "(Lid/dana/data/promoquest/repository/source/network/result/MissionEntityResult;)Lid/dana/domain/promoquest/model/Mission;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PromoQuestEntityMapper {
    @Inject
    public PromoQuestEntityMapper() {
    }

    public final List<Mission> transform(ListOfMissionResult listOfMissionResult) {
        ArrayList arrayList;
        List<MissionEntityResult> missionInfoList;
        List filterNotNull;
        if (listOfMissionResult == null || (missionInfoList = listOfMissionResult.getMissionInfoList()) == null || (filterNotNull = CollectionsKt.filterNotNull(missionInfoList)) == null) {
            arrayList = null;
        } else {
            List list = filterNotNull;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(toMission((MissionEntityResult) it.next()));
            }
            arrayList = arrayList2;
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    private final Mission toMission(MissionEntityResult missionEntityResult) {
        String missionDescription = missionEntityResult.getMissionDescription();
        Date missionExpireTime = missionEntityResult.getMissionExpireTime();
        String missionId = missionEntityResult.getMissionId();
        String missionActiveImage = missionEntityResult.getMissionActiveImage();
        String missionFinishImage = missionEntityResult.getMissionFinishImage();
        String missionName = missionEntityResult.getMissionName();
        String missionStatus = missionEntityResult.getMissionStatus();
        String missionThumbnail = missionEntityResult.getMissionThumbnail();
        boolean hasPrize = missionEntityResult.getHasPrize();
        String missionType = missionEntityResult.getMissionType();
        String missionTnc = missionEntityResult.getMissionTnc();
        if (missionTnc == null) {
            missionTnc = "";
        }
        return new Mission(missionId, missionName, missionDescription, missionExpireTime, missionStatus, missionFinishImage, missionActiveImage, missionThumbnail, null, hasPrize, missionType, missionTnc, 256, null);
    }
}
