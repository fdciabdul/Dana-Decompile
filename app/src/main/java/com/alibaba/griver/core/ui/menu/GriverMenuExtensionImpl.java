package com.alibaba.griver.core.ui.menu;

import android.os.Bundle;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.resource.api.models.AppInfoScene;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.api.common.menu.GriverMenuExtension;
import com.alibaba.griver.api.common.menu.GriverMenuItem;
import com.alibaba.griver.base.common.config.GriverInnerConfig;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes6.dex */
public class GriverMenuExtensionImpl implements GriverMenuExtension {
    @Override // com.alibaba.griver.api.common.menu.GriverMenuExtension
    public List<GriverMenuItem> getAppendMenuList(Page page) {
        return null;
    }

    @Override // com.alibaba.griver.api.common.menu.GriverMenuExtension
    public List<GriverMenuItem> getMenuList(Page page) {
        App app;
        Bundle startParams;
        LinkedList linkedList = new LinkedList();
        linkedList.add(new ShareMenu());
        linkedList.add(new SettingMenu());
        linkedList.add(new AboutMenu());
        if (GriverInnerConfig.getConfigBoolean(GriverConfigConstants.KEY_MENU_SHOW_REOPEN, true) && (app = page.getApp()) != null && (startParams = app.getStartParams()) != null && AppInfoScene.ONLINE.toString().equalsIgnoreCase(BundleUtils.getString(startParams, AppInfoScene.PARAM_SCENE, AppInfoScene.ONLINE.toString()))) {
            linkedList.add(new ReopenMenu());
        }
        List<GriverMenuItem> appendMenuList = getAppendMenuList(page);
        if (appendMenuList != null) {
            linkedList.addAll(appendMenuList);
        }
        return linkedList;
    }
}
