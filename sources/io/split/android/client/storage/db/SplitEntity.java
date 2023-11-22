package io.split.android.client.storage.db;

/* loaded from: classes6.dex */
public class SplitEntity {
    private String body;
    private String name;
    private long rowId;
    private long updatedAt;

    public long getRowId() {
        return this.rowId;
    }

    public void setRowId(long j) {
        this.rowId = j;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String str) {
        this.body = str;
    }

    public long getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(long j) {
        this.updatedAt = j;
    }
}
