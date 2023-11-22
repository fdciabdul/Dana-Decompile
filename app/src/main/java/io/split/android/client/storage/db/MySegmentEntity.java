package io.split.android.client.storage.db;

/* loaded from: classes6.dex */
public class MySegmentEntity {
    private String segmentList;
    private long updatedAt;
    private String userKey;

    public String getUserKey() {
        return this.userKey;
    }

    public void setUserKey(String str) {
        this.userKey = str;
    }

    public String getSegmentList() {
        return this.segmentList;
    }

    public void setSegmentList(String str) {
        this.segmentList = str;
    }

    public long getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(long j) {
        this.updatedAt = j;
    }
}
