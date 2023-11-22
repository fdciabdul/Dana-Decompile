package com.alibaba.griver.base.common.utils;

import com.alibaba.griver.api.common.menu.GriverMenuItem;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.common.utils.MapBuilder;
import com.alibaba.griver.ui.popmenu.TinyBlurMenu;
import com.iap.ac.android.acs.operation.biz.region.bean.MenuExtraInfo;
import com.iap.ac.android.container.adapter.griver.extension.CustomMenuExtensionImpl;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class MonitorUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final List f6314a = Arrays.asList(CustomMenuExtensionImpl.TYPE_FAVORITE, CustomMenuExtensionImpl.TYPE_SUBSCRIPTION, "Notification", TinyBlurMenu.ABOUT_MENU_NAME, "Setting", CustomMenuExtensionImpl.TYPE_FEEDBACK, "Share", "ShareChannel");
    private static final List b = Arrays.asList(MenuExtraInfo.MENU_ID_NOTIFICATION, MenuExtraInfo.MENU_ID_COLLECT, "IAPMenuIdSubscriptionMenu", MenuExtraInfo.MENU_ID_FEEDBACK, MenuExtraInfo.MENU_ID_SUBSCRIPTION, MenuExtraInfo.MENU_ID_TITLE_BAR_COLLECT, MenuExtraInfo.MENU_ID_PANEL_COLLECT);

    public static void trackMenuClick(String str) {
        trackMenuClick(str, null);
    }

    public static void trackOtherMenu(GriverMenuItem griverMenuItem) {
        List list = f6314a;
        if (list.contains(griverMenuItem.name) || list.contains(griverMenuItem.identifier)) {
            return;
        }
        List list2 = b;
        if (list2.contains(griverMenuItem.name) || list2.contains(griverMenuItem.identifier)) {
            return;
        }
        trackMenuClick("Custom", new MapBuilder.Builder().map("name", griverMenuItem.name).build());
    }

    public static void trackMenuClick(String str, Map<String, String> map) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", str);
        if (map != null) {
            for (String str2 : map.keySet()) {
                hashMap.put(str2, map.get(str2));
            }
        }
        GriverMonitor.event(GriverMonitorConstants.EVENT_MENU_CLICK, "GriverAppContainer", hashMap);
    }
}
