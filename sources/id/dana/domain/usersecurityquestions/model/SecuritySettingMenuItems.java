package id.dana.domain.usersecurityquestions.model;

import java.io.Serializable;

/* loaded from: classes4.dex */
public class SecuritySettingMenuItems implements Serializable {
    private String desc;
    private SecuritySettingExtInfo extInfo;
    private String title;
    private String url;

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public SecuritySettingExtInfo getExtInfo() {
        return this.extInfo;
    }

    public void setExtInfo(SecuritySettingExtInfo securitySettingExtInfo) {
        this.extInfo = securitySettingExtInfo;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
