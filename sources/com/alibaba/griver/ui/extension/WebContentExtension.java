package com.alibaba.griver.ui.extension;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.PageContext;
import com.alibaba.ariver.app.api.point.biz.DisclaimerPoint;
import com.alibaba.ariver.app.api.point.page.BackPressedPoint;
import com.alibaba.ariver.app.api.point.view.TitleBarCloseClickPoint;
import com.alibaba.ariver.app.api.point.view.TitleBarDisclaimerClickPoint;
import com.alibaba.ariver.app.api.point.view.TitleBarTitleClickPoint;
import com.alibaba.ariver.app.api.point.view.TitleBarTransparentPoint;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.node.NodeAware;
import com.alibaba.griver.api.common.view.GriverBackPressedPointEvent;
import com.alibaba.griver.api.common.view.GriverTitleBarCloseClickEvent;
import com.alibaba.griver.api.common.view.GriverTitleBarEvent;
import com.alibaba.griver.ui.container.GriverPageContainer;
import java.lang.ref.WeakReference;

/* loaded from: classes6.dex */
public class WebContentExtension implements DisclaimerPoint, BackPressedPoint, TitleBarCloseClickPoint, TitleBarDisclaimerClickPoint, TitleBarTitleClickPoint, TitleBarTransparentPoint, NodeAware<Page> {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<Page> f6711a;

    @Override // com.alibaba.ariver.app.api.point.view.TitleBarDisclaimerClickPoint
    public void onDisclaimerClick() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.app.api.point.view.TitleBarTransparentPoint
    public void onTrasparentTitle(Page page, String str) {
    }

    @Override // com.alibaba.ariver.app.api.point.biz.DisclaimerPoint
    public void showDisclaimer(int i) {
    }

    @Override // com.alibaba.ariver.app.api.point.view.TitleBarCloseClickPoint
    public void onCloseClick() {
        WeakReference<Page> weakReference = this.f6711a;
        if (weakReference == null || weakReference.get() == null || a() == null) {
            return;
        }
        a().handleCloseEvent();
        ((GriverTitleBarCloseClickEvent) ExtensionPoint.as(GriverTitleBarCloseClickEvent.class).node(this.f6711a.get()).create()).onCloseClick();
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public void setNode(WeakReference<Page> weakReference) {
        this.f6711a = weakReference;
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public Class<Page> getNodeType() {
        return Page.class;
    }

    private GriverPageContainer a() {
        PageContext pageContext;
        WeakReference<Page> weakReference = this.f6711a;
        if (weakReference == null || weakReference.get() == null || (pageContext = this.f6711a.get().getPageContext()) == null || pageContext.getPageContainer() == null || !(pageContext.getPageContainer() instanceof GriverPageContainer)) {
            return null;
        }
        return (GriverPageContainer) pageContext.getPageContainer();
    }

    @Override // com.alibaba.ariver.app.api.point.view.TitleBarTitleClickPoint
    public void onTitleClick() {
        WeakReference<Page> weakReference = this.f6711a;
        if (weakReference == null) {
            return;
        }
        EngineUtils.sendToRender(weakReference.get().getRender(), RVEvents.TITLE_CLICK, null, null);
        ((GriverTitleBarEvent) ExtensionPoint.as(GriverTitleBarEvent.class).node(this.f6711a.get()).create()).onTitleClick();
    }

    @Override // com.alibaba.ariver.app.api.point.view.TitleBarTitleClickPoint
    public void onSubTitleClick() {
        WeakReference<Page> weakReference = this.f6711a;
        if (weakReference == null) {
            return;
        }
        EngineUtils.sendToRender(weakReference.get().getRender(), "subtitleClick", null, null);
    }

    @Override // com.alibaba.ariver.app.api.point.page.BackPressedPoint
    public Boolean handleBackPressed(Page page) {
        page.backPressed();
        WeakReference<Page> weakReference = this.f6711a;
        if (weakReference != null && weakReference.get() != null) {
            ((GriverBackPressedPointEvent) ExtensionPoint.as(GriverBackPressedPointEvent.class).node(this.f6711a.get()).create()).handleBackPressed(page);
        }
        return Boolean.TRUE;
    }
}
