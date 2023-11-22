package com.alibaba.griver.core.point;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.point.page.PageBackPoint;
import com.alibaba.ariver.app.api.point.page.PageDestroyPoint;
import com.alibaba.ariver.app.api.point.page.PageExitPoint;
import com.alibaba.ariver.app.api.point.page.PagePausePoint;
import com.alibaba.ariver.app.api.point.page.PageResumePoint;
import com.alibaba.ariver.app.api.point.page.PageStartedPoint;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.node.NodeAware;
import com.alibaba.griver.api.common.page.GriverPageHelperEvent;
import com.alibaba.griver.api.webview.PageFinishedPoint;
import com.alibaba.griver.base.api.PageProcessPoint;
import java.lang.ref.WeakReference;

/* loaded from: classes6.dex */
public class PageHelperPoint implements PageBackPoint, PageDestroyPoint, PageExitPoint, PagePausePoint, PageResumePoint, PageStartedPoint, NodeAware<Page>, PageFinishedPoint, PageProcessPoint {
    WeakReference<Page> pageWeakReference;

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.app.api.point.page.PageStartedPoint
    public void onStarted(String str) {
        ((GriverPageHelperEvent) ExtensionPoint.as(GriverPageHelperEvent.class).node(this.pageWeakReference.get()).create()).onPageStarted(this.pageWeakReference.get(), str);
    }

    @Override // com.alibaba.griver.base.api.PageProcessPoint
    public void onProgressChanged(String str, int i) {
        ((GriverPageHelperEvent) ExtensionPoint.as(GriverPageHelperEvent.class).node(this.pageWeakReference.get()).create()).onProgressChanged(this.pageWeakReference.get(), str, i);
    }

    @Override // com.alibaba.griver.api.webview.PageFinishedPoint
    public void onPageFinished(String str) {
        ((GriverPageHelperEvent) ExtensionPoint.as(GriverPageHelperEvent.class).node(this.pageWeakReference.get()).create()).onPageFinished(this.pageWeakReference.get(), str);
    }

    @Override // com.alibaba.ariver.app.api.point.page.PageResumePoint
    public void onPageResume(Page page) {
        ((GriverPageHelperEvent) ExtensionPoint.as(GriverPageHelperEvent.class).node(page).create()).onPageResume(page);
    }

    @Override // com.alibaba.ariver.app.api.point.page.PagePausePoint
    public void onPagePause(Page page) {
        ((GriverPageHelperEvent) ExtensionPoint.as(GriverPageHelperEvent.class).node(page).create()).onPagePause(page);
    }

    @Override // com.alibaba.ariver.app.api.point.page.PageBackPoint
    public void onBackPerformed(Page page) {
        ((GriverPageHelperEvent) ExtensionPoint.as(GriverPageHelperEvent.class).node(page).create()).onPageBacked(page);
    }

    @Override // com.alibaba.ariver.app.api.point.page.PageDestroyPoint
    public void onPageDestroy(Page page) {
        ((GriverPageHelperEvent) ExtensionPoint.as(GriverPageHelperEvent.class).node(page).create()).onPageDestroy(page);
    }

    @Override // com.alibaba.ariver.app.api.point.page.PageExitPoint
    public void onPageExit(Page page) {
        ((GriverPageHelperEvent) ExtensionPoint.as(GriverPageHelperEvent.class).node(page).create()).onPageExit(page);
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public void setNode(WeakReference<Page> weakReference) {
        if (weakReference != null) {
            this.pageWeakReference = weakReference;
        }
        WeakReference<Page> weakReference2 = this.pageWeakReference;
        if (weakReference2 != null) {
            weakReference2.get();
        }
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public Class<Page> getNodeType() {
        return Page.class;
    }
}
