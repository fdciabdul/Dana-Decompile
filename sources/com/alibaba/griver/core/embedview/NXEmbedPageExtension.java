package com.alibaba.griver.core.embedview;

import com.alibaba.ariver.app.PageNode;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.point.page.BackPressedPoint;
import com.alibaba.ariver.kernel.api.extension.SimpleSortable;
import com.alibaba.ariver.kernel.api.scheduler.Interruptable;
import com.alibaba.ariver.kernel.api.scheduler.Interruptor;
import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* loaded from: classes6.dex */
public class NXEmbedPageExtension extends NXEmbedBackIntercept implements BackPressedPoint, SimpleSortable, Interruptable {

    /* renamed from: a  reason: collision with root package name */
    private String f6401a = "Griver:NXEmbedPageExtension";
    private Interruptor b;

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.SimpleSortable
    public int priority() {
        return 3;
    }

    @Override // com.alibaba.ariver.app.api.point.page.BackPressedPoint
    public Boolean handleBackPressed(Page page) {
        if (page != null && (page instanceof PageNode)) {
            PageNode pageNode = (PageNode) page;
            if (pageNode.getEmbedPage() != null && interceptBack((PageNode) pageNode.getEmbedPage())) {
                RVLogger.d(this.f6401a, "interceptBackEvent  by embedView ");
                this.b.interrupt();
            }
        }
        return Boolean.FALSE;
    }

    @Override // com.alibaba.ariver.kernel.api.scheduler.Interruptable
    public void setInterruptor(Interruptor interruptor) {
        this.b = interruptor;
    }
}
