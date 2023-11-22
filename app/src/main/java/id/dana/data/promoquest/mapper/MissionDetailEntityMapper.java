package id.dana.data.promoquest.mapper;

import id.dana.data.promoquest.repository.source.network.result.MissionDetailResult;
import id.dana.data.promoquest.repository.source.network.result.QuestEntityResult;
import id.dana.domain.promoquest.model.Mission;
import id.dana.domain.promoquest.model.Quest;
import java.util.ArrayList;
import java.util.Iterator;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class MissionDetailEntityMapper {
    @Inject
    public MissionDetailEntityMapper() {
    }

    public Mission transform(MissionDetailResult missionDetailResult) {
        if (missionDetailResult != null) {
            Mission mission = new Mission();
            if (missionDetailResult.getMissionInfo() != null) {
                mission.setMissionId(missionDetailResult.getMissionInfo().getMissionId());
                mission.setMissionName(missionDetailResult.getMissionInfo().getMissionName());
                mission.setMissionDescription(missionDetailResult.getMissionInfo().getMissionDescription());
                mission.setMissionExpireTime(missionDetailResult.getMissionInfo().getMissionExpireTime());
                mission.setMissionStatus(missionDetailResult.getMissionInfo().getMissionStatus());
                mission.setMissionFinishImage(missionDetailResult.getMissionInfo().getMissionFinishImage());
                mission.setMissionImage(missionDetailResult.getMissionInfo().getMissionActiveImage());
                mission.setHasPrize(missionDetailResult.getMissionInfo().getHasPrize());
                mission.setMissionType(missionDetailResult.getMissionInfo().getMissionType());
                mission.setMissionThumbnail(missionDetailResult.getMissionInfo().getMissionThumbnail());
                String missionTnc = missionDetailResult.getMissionInfo().getMissionTnc();
                if (missionTnc != null) {
                    mission.setMissionTnc(missionTnc);
                }
            }
            ArrayList arrayList = new ArrayList();
            if (missionDetailResult.getQuestInfoList() != null) {
                Iterator<QuestEntityResult> it = missionDetailResult.getQuestInfoList().iterator();
                while (it.hasNext()) {
                    arrayList.add(transform(it.next()));
                }
            }
            mission.setQuestList(arrayList);
            return mission;
        }
        return null;
    }

    private Quest transform(QuestEntityResult questEntityResult) {
        if (questEntityResult != null) {
            Quest quest = new Quest();
            quest.setId(questEntityResult.getQuestId());
            quest.setName(questEntityResult.getQuestName());
            quest.setDescription(questEntityResult.getQuestDescription());
            quest.setStatus(questEntityResult.getQuestStatus());
            quest.setActionType(questEntityResult.getQuestActionType());
            quest.setRedirectType(questEntityResult.getQuestRedirectType());
            quest.setRedirectValue(questEntityResult.getQuestRedirectValue());
            quest.setPriceStatus(questEntityResult.getHasPrize());
            return quest;
        }
        return null;
    }
}
