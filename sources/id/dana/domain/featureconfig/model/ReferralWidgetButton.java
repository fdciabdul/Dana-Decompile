package id.dana.domain.featureconfig.model;

/* loaded from: classes8.dex */
public class ReferralWidgetButton {
    private String action;
    private boolean enable;
    private String link;
    private String name;
    private String widgetId;
    private String widgetType;

    public String getWidgetId() {
        return this.widgetId;
    }

    public void setWidgetId(String str) {
        this.widgetId = str;
    }

    public String getWidgetType() {
        return this.widgetType;
    }

    public void setWidgetType(String str) {
        this.widgetType = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public String getAction() {
        return this.action;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public void setEnable(boolean z) {
        this.enable = z;
    }
}
