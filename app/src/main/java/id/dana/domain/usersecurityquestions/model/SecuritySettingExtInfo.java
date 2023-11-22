package id.dana.domain.usersecurityquestions.model;

import java.io.Serializable;

/* loaded from: classes8.dex */
public class SecuritySettingExtInfo implements Serializable {
    private String redDot;
    private String status;
    private String type;

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getRedDot() {
        return this.redDot;
    }

    public void setRedDot(String str) {
        this.redDot = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
