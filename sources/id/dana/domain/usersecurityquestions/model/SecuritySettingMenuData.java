package id.dana.domain.usersecurityquestions.model;

import java.io.Serializable;

/* loaded from: classes4.dex */
public class SecuritySettingMenuData implements Serializable {
    private String extInfo;
    private SecuritySettingMenuGroups[] menuGroups;

    public String getExtInfo() {
        return this.extInfo;
    }

    public void setExtInfo(String str) {
        this.extInfo = str;
    }

    public SecuritySettingMenuGroups[] getMenuGroups() {
        return this.menuGroups;
    }

    public void setMenuGroups(SecuritySettingMenuGroups[] securitySettingMenuGroupsArr) {
        this.menuGroups = securitySettingMenuGroupsArr;
    }
}
