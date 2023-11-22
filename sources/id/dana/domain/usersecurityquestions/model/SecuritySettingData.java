package id.dana.domain.usersecurityquestions.model;

import java.io.Serializable;

/* loaded from: classes4.dex */
public class SecuritySettingData implements Serializable {
    private String extInfo;
    private SecuritySettingMenuData menuData;
    private String menuTitle;
    private boolean showMenu;

    public SecuritySettingMenuData getMenuData() {
        return this.menuData;
    }

    public void setMenuData(SecuritySettingMenuData securitySettingMenuData) {
        this.menuData = securitySettingMenuData;
    }

    public boolean isShowMenu() {
        return this.showMenu;
    }

    public void setShowMenu(boolean z) {
        this.showMenu = z;
    }

    public String getMenuTitle() {
        return this.menuTitle;
    }

    public void setMenuTitle(String str) {
        this.menuTitle = str;
    }

    public String getExtInfo() {
        return this.extInfo;
    }

    public void setExtInfo(String str) {
        this.extInfo = str;
    }
}
