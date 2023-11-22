package id.dana.data.promoquest.mapper;

import id.dana.data.promoquest.repository.source.network.result.MissionSummaryResult;
import id.dana.data.promoquest.repository.source.network.result.QuestEntityResult;
import id.dana.data.promoquest.repository.source.network.result.QuestTrackResult;
import id.dana.domain.promoquest.model.MissionSummary;
import id.dana.domain.promoquest.model.Quest;
import id.dana.domain.promoquest.model.QuestTrack;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class PromoQuestMapper {
    @Inject
    public PromoQuestMapper() {
    }

    public List<MissionSummary> transform(List<MissionSummaryResult> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<MissionSummaryResult> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(transform(it.next()));
            }
            return arrayList;
        }
        return null;
    }

    public MissionSummary transform(MissionSummaryResult missionSummaryResult) {
        if (missionSummaryResult != null) {
            MissionSummary missionSummary = new MissionSummary();
            missionSummary.setId(missionSummaryResult.getMissionId());
            missionSummary.setExpireTime(missionSummaryResult.getMissionExpireTime());
            missionSummary.setQuest(transform(missionSummaryResult.getActiveQuest()));
            missionSummary.setStatus(missionSummaryResult.getMissionStatus());
            missionSummary.setThumbnail(missionSummaryResult.getMissionThumbnail());
            return missionSummary;
        }
        return null;
    }

    public Quest transform(QuestEntityResult questEntityResult) {
        if (questEntityResult != null) {
            Quest quest = new Quest();
            quest.setActionType(questEntityResult.getQuestActionType());
            quest.setDescription(questEntityResult.getQuestDescription());
            quest.setId(questEntityResult.getQuestId());
            quest.setPriceStatus(questEntityResult.getHasPrize());
            quest.setName(questEntityResult.getQuestName());
            quest.setRedirectType(questEntityResult.getQuestRedirectType());
            quest.setRedirectValue(questEntityResult.getQuestRedirectValue());
            quest.setStatus(questEntityResult.getQuestStatus());
            quest.setExtendInfo(questEntityResult.getExtendInfo());
            return quest;
        }
        return null;
    }

    public QuestTrack transform(QuestTrackResult questTrackResult) {
        if (questTrackResult != null) {
            QuestTrack questTrack = new QuestTrack();
            questTrack.setQuestRedirectType(questTrackResult.getQuestRedirectType());
            questTrack.setQuestRedirectValue(questTrackResult.getQuestRedirectValue());
            questTrack.setRedeemResult(questTrackResult.isRedeemResult());
            questTrack.setTrackResult(questTrackResult.isTrackResult());
            return questTrack;
        }
        return null;
    }
}
