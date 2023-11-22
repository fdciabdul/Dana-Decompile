package id.dana.data.playstorereview.model;

/* loaded from: classes4.dex */
public class PlayStoreReviewEntity {
    private String action;
    private String actionTime;
    private String triggerTime;

    public PlayStoreReviewEntity() {
    }

    public PlayStoreReviewEntity(String str, String str2, String str3) {
        this.action = str;
        this.actionTime = str2;
        this.triggerTime = str3;
    }

    public String getTriggerTime() {
        return this.triggerTime;
    }

    public void setTriggerTime(String str) {
        this.triggerTime = str;
    }

    public String getAction() {
        return this.action;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public String getActionTime() {
        return this.actionTime;
    }

    public void setActionTime(String str) {
        this.actionTime = str;
    }
}
