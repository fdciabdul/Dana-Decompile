package id.dana.data.promoquest.repository.source.network.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import java.util.List;

/* loaded from: classes4.dex */
public class MissionDetailResult extends BaseRpcResult {
    private MissionEntityResult missionInfo;
    private List<QuestEntityResult> questInfoList;

    public List<QuestEntityResult> getQuestInfoList() {
        return this.questInfoList;
    }

    public void setQuestInfoList(List<QuestEntityResult> list) {
        this.questInfoList = list;
    }

    public MissionEntityResult getMissionInfo() {
        return this.missionInfo;
    }

    public void setMissionInfo(MissionEntityResult missionEntityResult) {
        this.missionInfo = missionEntityResult;
    }
}
