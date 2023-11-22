package com.alibaba.griver.core.ui.menu;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.griver.api.common.menu.GRVMPMoreMenuItem;
import com.alibaba.griver.api.common.menu.GRVMPMoreMenuItemPriority;
import com.alibaba.griver.core.R;
import com.iap.ac.android.acs.operation.biz.region.bean.MenuExtraInfo;

/* loaded from: classes3.dex */
public class GRVNotificationBoxMenuItem extends GRVMPMoreMenuItem {
    public GRVNotificationBoxMenuItem() {
        this.name = "Notification";
        this.identifier = MenuExtraInfo.MENU_ID_NOTIFICATION;
        this.row = 1;
        this.priority = GRVMPMoreMenuItemPriority.GRVMPMoreMenuItemPriorityHigh;
        this.iconDrawable = R.drawable.griver_core_menu_notification;
    }

    @Override // com.alibaba.griver.api.common.menu.GriverMenuItem
    public boolean canShow(Page page) {
        return this.show;
    }
}
