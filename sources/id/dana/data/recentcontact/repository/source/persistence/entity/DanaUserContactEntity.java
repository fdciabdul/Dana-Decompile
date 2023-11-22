package id.dana.data.recentcontact.repository.source.persistence.entity;

/* loaded from: classes4.dex */
public class DanaUserContactEntity {
    private long lastUpdated;
    private String phoneNumber;
    private int uid;
    private String userId;

    public DanaUserContactEntity() {
    }

    public DanaUserContactEntity(String str, String str2, long j) {
        this.userId = str;
        this.phoneNumber = str2;
        this.lastUpdated = j;
    }

    public long getLastUpdated() {
        return this.lastUpdated;
    }

    public void setLastUpdated(long j) {
        this.lastUpdated = j;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    public int getUid() {
        return this.uid;
    }

    public void setUid(int i) {
        this.uid = i;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String str) {
        this.userId = str;
    }
}
