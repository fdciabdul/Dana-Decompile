package id.dana.domain.usersecurityquestions.model;

import java.io.Serializable;

/* loaded from: classes4.dex */
public class SecuritySettingMenuGroups implements Serializable {
    private String extInfo;
    private SecuritySettingMenuItems[] menuItems;

    public String getExtInfo() {
        return this.extInfo;
    }

    public void setExtInfo(String str) {
        this.extInfo = str;
    }

    public SecuritySettingMenuItems[] getMenuItems() {
        return this.menuItems;
    }

    public void setMenuItems(SecuritySettingMenuItems[] securitySettingMenuItemsArr) {
        this.menuItems = securitySettingMenuItemsArr;
    }
}
