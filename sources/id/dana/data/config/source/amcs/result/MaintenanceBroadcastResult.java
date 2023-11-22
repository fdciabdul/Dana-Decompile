package id.dana.data.config.source.amcs.result;

/* loaded from: classes2.dex */
public class MaintenanceBroadcastResult {
    public static final String KEY_DATE = "date";
    public static final String KEY_ICON_URL = "iconUrl";
    public static final String KEY_TEXT = "text";
    public static final String KEY_VERSION = "version";
    public static final String KEY_VISIBLE = "visible";
    private String date;
    private String iconUrl;
    private String text;
    private int version;
    private boolean visible;

    public static MaintenanceBroadcastResult createDefault() {
        MaintenanceBroadcastResult maintenanceBroadcastResult = new MaintenanceBroadcastResult();
        maintenanceBroadcastResult.setText("");
        maintenanceBroadcastResult.setVisible(false);
        maintenanceBroadcastResult.setVersion(0);
        maintenanceBroadcastResult.setDate("");
        maintenanceBroadcastResult.setIconUrl("");
        return maintenanceBroadcastResult;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String str) {
        this.text = str;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public void setVisible(boolean z) {
        this.visible = z;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(int i) {
        this.version = i;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }
}
