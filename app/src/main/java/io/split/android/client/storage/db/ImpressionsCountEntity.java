package io.split.android.client.storage.db;

import io.split.android.client.dtos.Identifiable;

/* loaded from: classes6.dex */
public class ImpressionsCountEntity implements Identifiable {
    private String body;
    private long createdAt;

    /* renamed from: id  reason: collision with root package name */
    private long f8257id;
    private int status;

    @Override // io.split.android.client.dtos.Identifiable
    public long getId() {
        return this.f8257id;
    }

    public void setId(long j) {
        this.f8257id = j;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String str) {
        this.body = str;
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
}
