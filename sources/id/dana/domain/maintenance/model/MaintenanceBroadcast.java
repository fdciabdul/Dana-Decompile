package id.dana.domain.maintenance.model;

/* loaded from: classes4.dex */
public class MaintenanceBroadcast {
    private String date;
    private String iconUrl;
    private String text;
    private int version;
    private boolean visible;

    public MaintenanceBroadcast(String str, boolean z, int i, String str2, String str3) {
        this.text = str;
        this.visible = z;
        this.version = i;
        this.date = str2;
        this.iconUrl = str3;
    }

    public String getText() {
        return this.text;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public int getVersion() {
        return this.version;
    }

    public String getDate() {
        String str = this.date;
        return str == null ? "" : str;
    }

    public String getIconUrl() {
        String str = this.iconUrl;
        return str == null ? "" : str;
    }
}
