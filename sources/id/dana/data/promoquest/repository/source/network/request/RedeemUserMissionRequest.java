package id.dana.data.promoquest.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import java.io.Serializable;

/* loaded from: classes4.dex */
public class RedeemUserMissionRequest extends BaseRpcRequest implements Serializable {
    private String missionId;

    public RedeemUserMissionRequest(String str) {
        setMissionId(str);
    }

    public String getMissionId() {
        return this.missionId;
    }

    public void setMissionId(String str) {
        this.missionId = str;
    }
}
