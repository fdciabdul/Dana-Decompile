package id.dana.domain.feeds.model;

import id.dana.utils.rpc.response.BaseRpcResponse;

/* loaded from: classes4.dex */
public class DeleteFeed extends BaseRpcResponse {
    private String activityId;

    public String getActivityId() {
        return this.activityId;
    }

    public void setActivityId(String str) {
        this.activityId = str;
    }
}
