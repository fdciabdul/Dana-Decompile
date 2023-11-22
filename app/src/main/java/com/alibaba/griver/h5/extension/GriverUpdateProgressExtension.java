package com.alibaba.griver.h5.extension;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.ui.PageContainer;
import com.alibaba.ariver.kernel.api.node.NodeAware;
import com.alibaba.griver.base.api.PageProcessPoint;
import com.alibaba.griver.ui.container.GriverPageContainer;
import java.lang.ref.WeakReference;

/* loaded from: classes6.dex */
public class GriverUpdateProgressExtension implements NodeAware<Page>, PageProcessPoint {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<Page> f6547a;

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public void setNode(WeakReference<Page> weakReference) {
        this.f6547a = weakReference;
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public Class<Page> getNodeType() {
        return Page.class;
    }

    @Override // com.alibaba.griver.base.api.PageProcessPoint
    public void onProgressChanged(String str, int i) {
        Page page;
        WeakReference<Page> weakReference = this.f6547a;
        if (weakReference == null || weakReference.get() == null || (page = this.f6547a.get()) == null || page.getPageContext() == null) {
            return;
        }
        PageContainer pageContainer = page.getPageContext().getPageContainer();
        if (pageContainer instanceof GriverPageContainer) {
            GriverPageContainer griverPageContainer = (GriverPageContainer) pageContainer;
            griverPageContainer.onProgressChanged(i);
            if (i == 100) {
                griverPageContainer.getProgressBar().setVisibility(8);
            }
        }
    }
}
