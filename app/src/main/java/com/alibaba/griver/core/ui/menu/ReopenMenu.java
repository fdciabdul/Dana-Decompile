package com.alibaba.griver.core.ui.menu;

import android.os.Bundle;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.griver.api.common.menu.GriverBaseMenuItem;
import com.alibaba.griver.api.common.menu.OnMenuItemClickListener;
import com.alibaba.griver.api.constants.GriverLaunchParams;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.core.Griver;
import com.alibaba.griver.core.R;
import java.util.concurrent.TimeUnit;

/* loaded from: classes6.dex */
public class ReopenMenu extends GriverBaseMenuItem {
    public ReopenMenu() {
        this.identifier = "Reopen";
        this.name = "Reopen";
        this.row = 2;
        this.iconDrawable = R.drawable.griver_core_menu_reopen;
        this.listener = new OnMenuItemClickListener() { // from class: com.alibaba.griver.core.ui.menu.ReopenMenu.1
            @Override // com.alibaba.griver.api.common.menu.OnMenuItemClickListener
            public void onItemClick(Page page, String str) {
                final App app = page.getApp();
                if (app != null) {
                    app.exit();
                    final Bundle startParams = app.getStartParams();
                    GriverExecutors.getScheduledExecutor().schedule(new Runnable() { // from class: com.alibaba.griver.core.ui.menu.ReopenMenu.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Bundle bundle = startParams;
                            if (bundle != null) {
                                bundle.putBoolean(GriverLaunchParams.REOPEN, true);
                                startParams.remove("version");
                                startParams.remove("appVersion");
                            }
                            Griver.openApp(GriverEnv.getApplicationContext(), app.getAppId(), startParams);
                        }
                    }, 400L, TimeUnit.MILLISECONDS);
                }
            }
        };
    }
}
