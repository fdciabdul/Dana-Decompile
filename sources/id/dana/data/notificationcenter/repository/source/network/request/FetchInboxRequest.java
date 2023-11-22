package id.dana.data.notificationcenter.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import java.io.Serializable;

/* loaded from: classes4.dex */
public class FetchInboxRequest extends BaseRpcRequest implements Serializable {
    private String maxId;
    private String minId;
    private int pageSize;

    public String getMinId() {
        return this.minId;
    }

    public void setMinId(String str) {
        this.minId = str;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int i) {
        this.pageSize = i;
    }

    public String getMaxId() {
        return this.maxId;
    }

    public void setMaxId(String str) {
        this.maxId = str;
    }
}
