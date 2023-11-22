package com.alibaba.griver.ui.extension;

import com.alibaba.ariver.app.api.EmbedType;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.PageContext;
import com.alibaba.ariver.app.api.point.view.TitleBarOptionClickPoint;
import com.alibaba.ariver.app.api.point.view.TitleBarSegCheckPoint;
import com.alibaba.ariver.app.api.point.view.TitleBarShowClosePoint;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.node.NodeAware;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.h5.point.GriverOptionMenuClickPoint;
import com.alibaba.griver.api.ui.optionmenu.GriverOptionMenuEvent;
import com.alibaba.griver.api.ui.optionmenu.ToolbarMenu;
import com.alibaba.griver.api.ui.optionmenu.ToolbarMenuClickListener;
import com.alibaba.griver.base.api.ReceivedTitlePoint;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.ui.titlebar.GriverTitleBar;
import java.lang.ref.WeakReference;

/* loaded from: classes6.dex */
public class TitleBarExtension implements TitleBarOptionClickPoint, TitleBarSegCheckPoint, TitleBarShowClosePoint, NodeAware<Page>, ReceivedTitlePoint {

    /* renamed from: a  reason: collision with root package name */
    private String f6710a;
    private WeakReference<Page> b;

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public GriverTitleBar a() {
        PageContext pageContext;
        WeakReference<Page> weakReference = this.b;
        if (weakReference == null || weakReference.get() == null || (pageContext = this.b.get().getPageContext()) == null) {
            return null;
        }
        return (GriverTitleBar) pageContext.getTitleBar();
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public void setNode(WeakReference<Page> weakReference) {
        this.b = weakReference;
        if (weakReference.get() == null || this.b.get().getApp() == null) {
            return;
        }
        this.f6710a = this.b.get().getApp().getAppType();
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public Class<Page> getNodeType() {
        return Page.class;
    }

    @Override // com.alibaba.ariver.app.api.point.view.TitleBarOptionClickPoint
    public void onOptionClick(int i, boolean z) {
        WeakReference<Page> weakReference = this.b;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("index", (Object) Integer.valueOf(i));
        jSONObject2.put("fromMenu", (Object) Boolean.valueOf(z));
        jSONObject.put("data", (Object) jSONObject2);
        final Page page = this.b.get();
        EngineUtils.sendToRender(page.getRender(), "optionMenu", jSONObject, null);
        boolean z2 = BundleUtils.getBoolean(page.getStartParams(), RVParams.isH5App, false);
        GriverOptionMenuEvent griverOptionMenuEvent = (GriverOptionMenuEvent) ExtensionPoint.as(GriverOptionMenuEvent.class).node(page).create();
        griverOptionMenuEvent.optionMenuClicked(page.getOriginalURI(), page.getApp().getAppId(), i);
        if (z) {
            if (z2 && griverOptionMenuEvent.interceptH5OptionMenuClick(page.getPageContext().getActivity(), page.getOriginalURI(), new ToolbarMenuClickListener() { // from class: com.alibaba.griver.ui.extension.TitleBarExtension.1
                @Override // com.alibaba.griver.api.ui.optionmenu.ToolbarMenuClickListener
                public void onClick(ToolbarMenu toolbarMenu) {
                    if (toolbarMenu != null) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("name", (Object) toolbarMenu.getName());
                        jSONObject3.put("tag", (Object) toolbarMenu.getTag());
                        jSONObject3.put("title", (Object) toolbarMenu.getName());
                        ((GriverOptionMenuClickPoint) ExtensionPoint.as(GriverOptionMenuClickPoint.class).node(page).create()).menuClick(jSONObject3);
                    }
                }
            })) {
                GriverLogger.d("TitleBarExtension", "option menu click is intercepted");
            } else {
                ((GriverTitleBar) this.b.get().getPageContext().getTitleBar()).onOptionMenuClick();
            }
        }
    }

    @Override // com.alibaba.ariver.app.api.point.view.TitleBarShowClosePoint
    public void showClose(boolean z) {
        WeakReference<Page> weakReference = this.b;
        if (weakReference != null && weakReference.get() != null && this.b.get().isUseForEmbed()) {
            RVLogger.d("TitleBarExtension", "embed webview not supprt showClose Button");
            return;
        }
        GriverTitleBar a2 = a();
        if (a2 == null || a2.getTitleView() == null) {
            return;
        }
        a2.getTitleView().showCloseButton(z);
    }

    @Override // com.alibaba.ariver.app.api.point.view.TitleBarSegCheckPoint
    public void onSegItemChecked(int i) {
        WeakReference<Page> weakReference = this.b;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("segmentGroup checked index is :\t");
        sb.append(i);
        RVLogger.d("TitleBarExtension", sb.toString());
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("index", (Object) Integer.valueOf(i));
        jSONObject.put("data", (Object) jSONObject2);
        EngineUtils.sendToRender(this.b.get().getRender(), "segControlClick", jSONObject, new SegControlCheckCallback());
    }

    @Override // com.alibaba.griver.base.api.ReceivedTitlePoint
    public void onReceivedTitle(String str, String str2) {
        WeakReference<Page> weakReference = this.b;
        if (weakReference != null && weakReference.get() != null && EmbedType.MINI == this.b.get().getEmbedType()) {
            RVLogger.d("TitleBarExtension", "mini embed webView onReceivedTitle don't change title");
            return;
        }
        WeakReference<Page> weakReference2 = this.b;
        if (weakReference2 != null && weakReference2.get() != null && EmbedType.FULL == this.b.get().getEmbedType()) {
            RVLogger.d("TitleBarExtension", "full embed webView onReceivedTitle  force update  title");
            GriverTitleBar a2 = a();
            if (a2 == null || a2.getTitleView() == null) {
                return;
            }
            a2.getTitleView().setTitle(str2);
            return;
        }
        GriverTitleBar a3 = a();
        if (a3 != null) {
            a3.onReceivedTitle(str, str2);
        }
    }

    /* loaded from: classes6.dex */
    class SegControlCheckCallback implements SendToRenderCallback {
        SegControlCheckCallback() {
        }

        @Override // com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback
        public void onCallBack(JSONObject jSONObject) {
            boolean z = JSONUtils.getBoolean(jSONObject, "prevent", false);
            StringBuilder sb = new StringBuilder();
            sb.append("segControlClick event prevent: ");
            sb.append(z);
            RVLogger.d("TitleBarExtension", sb.toString());
            GriverTitleBar a2 = TitleBarExtension.this.a();
            if (a2 != null) {
                a2.getTitleView().performLastSegItemChecked(z);
            }
        }
    }
}
