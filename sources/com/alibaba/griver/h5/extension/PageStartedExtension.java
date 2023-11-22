package com.alibaba.griver.h5.extension;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.point.page.PageStartedPoint;
import com.alibaba.ariver.app.api.ui.PageContainer;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.api.node.NodeAware;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.griver.api.constants.GriverEvents;
import com.alibaba.griver.ui.container.GriverPageContainer;
import java.lang.ref.WeakReference;

/* loaded from: classes6.dex */
public class PageStartedExtension implements PageStartedPoint, NodeAware<Page> {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<Page> f6548a;

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.app.api.point.page.PageStartedPoint
    public void onStarted(String str) {
        WeakReference<Page> weakReference = this.f6548a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        Page page = this.f6548a.get();
        if (BundleUtils.getBoolean(page.getStartParams(), RVParams.isH5App, false) && page.getApp() != null && page.getApp().getEngineProxy() != null && page.getApp().getEngineProxy().getBridge() != null) {
            page.getApp().getEngineProxy().getBridge().sendToNative(new NativeCallContext.Builder().name(GriverEvents.EVENT_SHOW_BACK_BUTTON).node(page).build(), null);
        }
        PageContainer pageContainer = page.getPageContext().getPageContainer();
        if (pageContainer instanceof GriverPageContainer) {
            ((GriverPageContainer) pageContainer).onStarted(str);
        }
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public void setNode(WeakReference<Page> weakReference) {
        this.f6548a = weakReference;
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public Class<Page> getNodeType() {
        return Page.class;
    }
}
