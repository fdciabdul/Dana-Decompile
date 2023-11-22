package com.iap.ac.android.container.adapter.griver.extension;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.griver.core.ui.menu.FeedbackMenu;

/* loaded from: classes3.dex */
public class CustomFeedBackMenu extends FeedbackMenu {
    public CustomFeedBackMenu() {
        this.listener = null;
    }

    @Override // com.alibaba.griver.core.ui.menu.FeedbackMenu, com.alibaba.griver.api.common.menu.GriverMenuItem
    public boolean canShow(Page page) {
        return this.show;
    }
}
