package io.split.android.client.storage.db.impressions.unique;

import io.split.android.client.dtos.Identifiable;

/* loaded from: classes6.dex */
public class UniqueKeyEntity implements Identifiable {
    private long createdAt;
    private String featureList;

    /* renamed from: id  reason: collision with root package name */
    private long f8258id;
    private int status;
    private String userKey;

    public UniqueKeyEntity() {
    }

    public UniqueKeyEntity(String str, String str2, long j, int i) {
        this.userKey = str;
        this.featureList = str2;
        this.createdAt = j;
        this.status = i;
    }

    public String getUserKey() {
        return this.userKey;
    }

    public void setUserKey(String str) {
        this.userKey = str;
    }

    public String getFeatureList() {
        return this.featureList;
    }

    public void setFeatureList(String str) {
        this.featureList = str;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(long j) {
        this.createdAt = j;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    @Override // io.split.android.client.dtos.Identifiable
    public long getId() {
        return this.f8258id;
    }

    public void setId(long j) {
        this.f8258id = j;
    }
}
