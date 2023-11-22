package com.alibaba.griver.core.ui.menu;

import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.griver.api.common.menu.GriverMenuItem;
import com.alibaba.griver.api.ui.optionmenu.GriverOptionMenuPanelExtension;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.iap.ac.android.container.constant.ContainerKeys;
import java.util.List;

/* loaded from: classes6.dex */
public class GriverOptionMenuPanelExtensionImpl implements GriverOptionMenuPanelExtension {
    @Override // com.alibaba.griver.api.ui.optionmenu.GriverOptionMenuPanelExtension
    public void showOptionMenuPanel(Page page, List<GriverMenuItem> list) {
        Intent intent = new Intent("show_title_bar_menu");
        intent.putExtra("appId", page.getApp().getAppId());
        intent.putExtra(ContainerKeys.PARAM_PAGE_ID, page.getPageId());
        LocalBroadcastManager.getInstance(GriverEnv.getApplicationContext()).sendBroadcast(intent);
    }
}
