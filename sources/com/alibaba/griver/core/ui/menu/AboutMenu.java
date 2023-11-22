package com.alibaba.griver.core.ui.menu;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.griver.api.common.menu.GriverMenuItem;
import com.alibaba.griver.api.common.menu.OnMenuItemClickListener;
import com.alibaba.griver.api.open.GriverAboutUrlExtension;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.AppInfoUtils;
import com.alibaba.griver.base.common.utils.MonitorUtil;
import com.alibaba.griver.core.Griver;
import com.alibaba.griver.core.R;
import com.alibaba.griver.core.jsapi.aboutinfo.AboutInfoBridgeExtension;
import com.alibaba.griver.ui.popmenu.TinyBlurMenu;

/* loaded from: classes6.dex */
public class AboutMenu extends GriverMenuItem {
    public AboutMenu() {
        this.identifier = TinyBlurMenu.ABOUT_MENU_NAME;
        this.name = TinyBlurMenu.ABOUT_MENU_NAME;
        this.row = 2;
        this.iconDrawable = R.drawable.griver_core_menu_about;
        this.listener = new OnMenuItemClickListener() { // from class: com.alibaba.griver.core.ui.menu.AboutMenu.1
            @Override // com.alibaba.griver.api.common.menu.OnMenuItemClickListener
            public void onItemClick(Page page, String str) {
                String aboutUrl = ((GriverAboutUrlExtension) RVProxy.get(GriverAboutUrlExtension.class)).getAboutUrl(page);
                if (TextUtils.isEmpty(aboutUrl)) {
                    GriverLogger.w("AboutMenu", "no about url integrated, do not open");
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString("screenOrientation", page.getStartParams().getString("screenOrientation", "portrait"));
                bundle.putString(AboutInfoBridgeExtension.PARAM_QUERY_APP_ID, page.getApp().getAppId());
                bundle.putString(AboutInfoBridgeExtension.PARAM_QUERY_APP_VERSION, AppInfoUtils.getDeveloperVersion((AppModel) page.getApp().getData(AppModel.class)));
                Griver.openUrl(GriverEnv.getApplicationContext(), aboutUrl, bundle);
                MonitorUtil.trackMenuClick(AboutMenu.this.name);
            }
        };
    }

    @Override // com.alibaba.griver.api.common.menu.GriverMenuItem
    public boolean canShow(Page page) {
        if (TextUtils.isEmpty(((GriverAboutUrlExtension) RVProxy.get(GriverAboutUrlExtension.class)).getAboutUrl(page))) {
            GriverLogger.w("AboutMenu", "no about url integrated, do not show");
        }
        return !TextUtils.isEmpty(r3);
    }
}
