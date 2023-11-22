package com.alibaba.griver.core.ui.menu;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.menu.GriverBaseMenuItem;
import com.alibaba.griver.api.common.menu.OnMenuItemClickListener;
import com.alibaba.griver.api.ui.share.GriverShareSchemeExtension;
import com.alibaba.griver.api.ui.share.GriverShareURLCreatorExtension;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.MonitorUtil;
import com.alibaba.griver.base.common.utils.PWAUtils;
import com.alibaba.griver.core.R;
import com.alibaba.griver.core.jsapi.share.ShareBridgeExtension;

/* loaded from: classes6.dex */
public class ShareMenu extends GriverBaseMenuItem {
    public ShareMenu() {
        this.name = "Share";
        this.identifier = "Share";
        this.row = 1;
        this.iconDrawable = R.drawable.griver_core_menu_grv_share;
        this.listener = new OnMenuItemClickListener() { // from class: com.alibaba.griver.core.ui.menu.ShareMenu.1
            @Override // com.alibaba.griver.api.common.menu.OnMenuItemClickListener
            public void onItemClick(Page page, String str) {
                if (PWAUtils.isPwaApp(page) && PWAUtils.isLoadNewWay()) {
                    new ShareBridgeExtension().shareTinyAppMsg(page, "page/index/index", "", "", "", "", "", "", "menu", new BridgeCallback() { // from class: com.alibaba.griver.core.ui.menu.ShareMenu.1.1
                        @Override // com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback
                        public void sendBridgeResponse(BridgeResponse bridgeResponse) {
                        }

                        @Override // com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback
                        public void sendJSONResponse(JSONObject jSONObject) {
                        }

                        @Override // com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback
                        public void sendJSONResponse(JSONObject jSONObject, boolean z) {
                        }
                    });
                } else {
                    JSONObject jSONObject = new JSONObject();
                    page.putStringValue("from", "menu");
                    EngineUtils.sendToRender(page.getRender(), "onShare", jSONObject, null);
                }
                MonitorUtil.trackMenuClick(ShareMenu.this.name);
            }
        };
    }

    @Override // com.alibaba.griver.api.common.menu.GriverBaseMenuItem, com.alibaba.griver.api.common.menu.GriverMenuItem
    public boolean canShow(Page page) {
        if (TextUtils.isEmpty(((GriverShareSchemeExtension) RVProxy.get(GriverShareSchemeExtension.class)).getScheme()) && RVProxy.get(GriverShareURLCreatorExtension.class, true) == null) {
            GriverLogger.w("ShareMenu", "share scheme is not integrated, do not show");
            return false;
        }
        return true;
    }
}
