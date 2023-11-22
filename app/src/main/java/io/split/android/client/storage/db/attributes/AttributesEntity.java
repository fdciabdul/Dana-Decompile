package io.split.android.client.storage.db.attributes;

/* loaded from: classes6.dex */
public class AttributesEntity {
    private String attributes;
    private long updatedAt;
    private String userKey;

    public AttributesEntity() {
    }

    public AttributesEntity(String str, String str2, long j) {
        this.userKey = str;
        this.attributes = str2;
        this.updatedAt = j;
    }

    public String getUserKey() {
        return this.userKey;
    }

    public String getAttributes() {
        return this.attributes;
    }

    public void setUserKey(String str) {
        this.userKey = str;
    }

    public void setAttributes(String str) {
        this.attributes = str;
    }

    public long getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(long j) {
        this.updatedAt = j;
    }
}
