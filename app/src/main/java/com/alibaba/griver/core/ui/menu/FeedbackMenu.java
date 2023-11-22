package com.alibaba.griver.core.ui.menu;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.griver.api.common.menu.GriverMenuItem;
import com.alibaba.griver.api.common.menu.OnMenuItemClickListener;
import com.alibaba.griver.api.open.GriverFeedbackExtension;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.MonitorUtil;
import com.alibaba.griver.core.Griver;
import com.alibaba.griver.core.R;
import com.iap.ac.android.container.adapter.griver.extension.CustomMenuExtensionImpl;

/* loaded from: classes3.dex */
public class FeedbackMenu extends GriverMenuItem {
    public FeedbackMenu() {
        this.identifier = CustomMenuExtensionImpl.TYPE_FEEDBACK;
        this.name = CustomMenuExtensionImpl.TYPE_FEEDBACK;
        this.row = 2;
        this.iconDrawable = R.drawable.griver_core_menu_feedback;
        this.listener = new OnMenuItemClickListener() { // from class: com.alibaba.griver.core.ui.menu.FeedbackMenu.1
            @Override // com.alibaba.griver.api.common.menu.OnMenuItemClickListener
            public void onItemClick(Page page, String str) {
                if (page == null || page.getApp() == null || page.getPageContext() == null) {
                    GriverLogger.w("FeedbackMenu", "page or app is null, do nothing");
                    return;
                }
                String feedbackMiniProgramId = ((GriverFeedbackExtension) RVProxy.get(GriverFeedbackExtension.class)).getFeedbackMiniProgramId(page);
                Bundle bundle = new Bundle();
                AppModel appModel = (AppModel) page.getApp().getData(AppModel.class);
                String name = (appModel == null || appModel.getAppInfoModel() == null) ? "" : appModel.getAppInfoModel().getName();
                StringBuilder sb = new StringBuilder();
                sb.append("appId=");
                sb.append(page.getApp().getAppId());
                sb.append("&appName=");
                sb.append(name);
                bundle.putString("query", sb.toString());
                Griver.openApp(page.getPageContext().getActivity(), feedbackMiniProgramId, bundle);
                MonitorUtil.trackMenuClick(FeedbackMenu.this.name);
            }
        };
    }

    @Override // com.alibaba.griver.api.common.menu.GriverMenuItem
    public boolean canShow(Page page) {
        String feedbackMiniProgramId = ((GriverFeedbackExtension) RVProxy.get(GriverFeedbackExtension.class)).getFeedbackMiniProgramId(page);
        if (TextUtils.isEmpty(feedbackMiniProgramId)) {
            GriverLogger.w("FeedbackMenu", "no feedback appId integrated, do not show");
        }
        return (TextUtils.isEmpty(feedbackMiniProgramId) || TextUtils.equals(feedbackMiniProgramId, page.getApp().getAppId())) ? false : true;
    }
}
