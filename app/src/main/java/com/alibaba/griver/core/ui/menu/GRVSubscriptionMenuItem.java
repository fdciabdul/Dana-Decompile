package com.alibaba.griver.core.ui.menu;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.griver.api.common.menu.GRVMPMoreMenuItem;
import com.alibaba.griver.api.common.menu.GRVMPMoreMenuItemPriority;
import com.alibaba.griver.core.R;

/* loaded from: classes3.dex */
public class GRVSubscriptionMenuItem extends GRVMPMoreMenuItem {
    public GRVSubscriptionMenuItem() {
        this.name = "Subscribe";
        this.identifier = "IAPMenuIdSubscriptionMenu";
        this.row = 1;
        this.priority = GRVMPMoreMenuItemPriority.GRVMPMoreMenuItemPriorityHigh;
        this.iconDrawable = R.drawable.griver_core_menu_notification_subscribe;
    }

    @Override // com.alibaba.griver.api.common.menu.GriverMenuItem
    public boolean canShow(Page page) {
        return this.show;
    }
}
