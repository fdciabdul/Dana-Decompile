package id.dana.data.promoquest.repository.source.network.result;

import java.util.Date;

/* loaded from: classes8.dex */
public class MissionSummaryResult {
    private QuestEntityResult activeQuest;
    private Date missionExpireTime;
    private String missionId;
    private String missionStatus;
    private String missionThumbnail;

    public String getMissionId() {
        return this.missionId;
    }

    public void setMissionId(String str) {
        this.missionId = str;
    }

    public QuestEntityResult getActiveQuest() {
        return this.activeQuest;
    }

    public void setActiveQuest(QuestEntityResult questEntityResult) {
        this.activeQuest = questEntityResult;
    }

    public Date getMissionExpireTime() {
        return this.missionExpireTime;
    }

    public void setMissionExpireTime(Date date) {
        this.missionExpireTime = date;
    }

    public String getMissionStatus() {
        return this.missionStatus;
    }

    public void setMissionStatus(String str) {
        this.missionStatus = str;
    }

    public String getMissionThumbnail() {
        return this.missionThumbnail;
    }

    public void setMissionThumbnail(String str) {
        this.missionThumbnail = str;
    }
}
