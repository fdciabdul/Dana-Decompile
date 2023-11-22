package id.dana.data.notificationcenter.repository.source.network.result;

/* loaded from: classes4.dex */
public class NotificationDTOResult {
    private String content;
    private long createdTime;
    private String iconUrl;

    /* renamed from: id  reason: collision with root package name */
    private String f8074id;
    private boolean read;
    private String redirectType;
    private String redirectValue;

    public String getId() {
        return this.f8074id;
    }

    public void setId(String str) {
        this.f8074id = str;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public String getRedirectType() {
        return this.redirectType;
    }

    public void setRedirectType(String str) {
        this.redirectType = str;
    }

    public String getRedirectValue() {
        return this.redirectValue;
    }

    public void setRedirectValue(String str) {
        this.redirectValue = str;
    }

    public boolean isRead() {
        return this.read;
    }

    public void setRead(boolean z) {
        this.read = z;
    }

    public long getCreatedTime() {
        return this.createdTime;
    }

    public void setCreatedTime(long j) {
        this.createdTime = j;
    }
}
