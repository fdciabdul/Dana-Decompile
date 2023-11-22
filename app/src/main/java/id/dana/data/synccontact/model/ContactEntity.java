package id.dana.data.synccontact.model;

/* loaded from: classes4.dex */
public class ContactEntity {
    private String lastUpdatedTime;
    private String phoneNumber;
    private String rawId;

    public String getRawId() {
        return this.rawId;
    }

    public void setRawId(String str) {
        this.rawId = str;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    public String getLastUpdatedTime() {
        return this.lastUpdatedTime;
    }

    public void setLastUpdatedTime(String str) {
        this.lastUpdatedTime = str;
    }
}
