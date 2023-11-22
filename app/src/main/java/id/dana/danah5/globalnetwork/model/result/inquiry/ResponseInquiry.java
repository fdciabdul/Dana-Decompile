package id.dana.danah5.globalnetwork.model.result.inquiry;

import java.util.List;

/* loaded from: classes8.dex */
public class ResponseInquiry {
    private List<Rate> data;
    private String lastUpdated;
    private boolean success;

    public List<Rate> getData() {
        return this.data;
    }

    public void setData(List<Rate> list) {
        this.data = list;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }

    public String getLastUpdated() {
        return this.lastUpdated;
    }

    public void setLastUpdated(String str) {
        this.lastUpdated = str;
    }
}
