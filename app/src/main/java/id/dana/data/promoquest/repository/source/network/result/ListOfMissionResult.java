package id.dana.data.promoquest.repository.source.network.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class ListOfMissionResult extends BaseRpcResult {
    private List<MissionEntityResult> missionInfoList;

    public List<MissionEntityResult> getMissionInfoList() {
        List<MissionEntityResult> list = this.missionInfoList;
        return list == null ? new ArrayList() : list;
    }

    public void setMissionInfoList(List<MissionEntityResult> list) {
        this.missionInfoList = list;
    }
}
