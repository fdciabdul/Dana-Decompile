package id.dana.data.feeds.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import java.io.Serializable;

/* loaded from: classes8.dex */
public class DeleteFeedsEntityRequest extends BaseRpcRequest implements Serializable {
    private String activityId;

    public String getActivityId() {
        return this.activityId;
    }

    public void setActivityId(String str) {
        this.activityId = str;
    }
}
