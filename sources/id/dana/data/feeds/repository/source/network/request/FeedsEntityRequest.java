package id.dana.data.feeds.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import java.io.Serializable;

/* loaded from: classes4.dex */
public class FeedsEntityRequest extends BaseRpcRequest implements Serializable {
    private String feedSourceId;
    private String maxId;
    private int pageSize;

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int i) {
        this.pageSize = i;
    }

    public String getFeedSourceId() {
        return this.feedSourceId;
    }

    public void setFeedSourceId(String str) {
        this.feedSourceId = str;
    }

    public String getMaxId() {
        return this.maxId;
    }

    public void setMaxId(String str) {
        this.maxId = str;
    }
}
