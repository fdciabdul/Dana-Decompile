package id.dana.data.promoquest.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import java.io.Serializable;

/* loaded from: classes4.dex */
public class RedeemQuestRequest extends BaseRpcRequest implements Serializable {
    private String missionId;
    private String questId;
    private String userId;

    public RedeemQuestRequest(String str, String str2, String str3) {
        setMissionId(str);
        setQuestId(str2);
        setUserId(str3);
    }

    public String getMissionId() {
        return this.missionId;
    }

    public void setMissionId(String str) {
        this.missionId = str;
    }

    public String getQuestId() {
        return this.questId;
    }

    public void setQuestId(String str) {
        this.questId = str;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String str) {
        this.userId = str;
    }
}
