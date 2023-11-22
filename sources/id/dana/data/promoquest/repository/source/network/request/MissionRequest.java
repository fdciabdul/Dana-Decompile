package id.dana.data.promoquest.repository.source.network.request;

import com.alipayplus.mobile.component.common.facade.base.MobileEnvInfo;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import java.io.Serializable;

/* loaded from: classes4.dex */
public class MissionRequest extends BaseRpcRequest implements Serializable {
    public int pageNumber;
    public int pageSize;
    public String userId;

    public MissionRequest() {
    }

    public MissionRequest(MobileEnvInfo mobileEnvInfo, int i, int i2) {
        this.pageNumber = i;
        this.pageSize = i2;
        this.envInfo = mobileEnvInfo;
    }
}
