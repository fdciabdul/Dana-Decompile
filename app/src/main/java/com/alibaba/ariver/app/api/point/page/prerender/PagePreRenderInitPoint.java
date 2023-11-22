package com.alibaba.ariver.app.api.point.page.prerender;

import android.os.Bundle;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.ui.fragment.RVFragment;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.kernel.api.extension.Extension;

/* loaded from: classes3.dex */
public interface PagePreRenderInitPoint extends Extension {
    PagePreRenderHolder getReadyPreRenderHolderWithReset(App app, Bundle bundle, Bundle bundle2, String str, boolean z);

    void onPageInited(App app, Page page);

    /* loaded from: classes3.dex */
    public static class PagePreRenderHolder {
        public Render preRender;
        public RVFragment preRenderFragment;
        public Page preRenderPage;

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.preRenderFragment);
            sb.append("\t");
            sb.append(this.preRenderPage);
            sb.append("\t");
            sb.append(this.preRender);
            return sb.toString();
        }
    }
}
