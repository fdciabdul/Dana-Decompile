package id.dana.danah5.share.file.businessaccount;

/* loaded from: classes2.dex */
public class ShareBusinessAccountFileEntity {
    private String businessName;
    private String url;

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String getBusinessName() {
        String replaceAll;
        replaceAll = this.businessName.replaceAll("[^A-Za-z0-9]", "");
        return replaceAll;
    }

    public void setBusinessName(String str) {
        this.businessName = str;
    }
}
