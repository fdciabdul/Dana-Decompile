package com.iap.ac.android.container.adapter.griver.event;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.griver.api.common.page.GriverPageHelperEvent;
import com.iap.ac.android.common.container.constant.ContainerEventAction;
import com.iap.ac.android.common.container.event.ContainerEvent;
import com.iap.ac.android.common.container.plugin.BaseContainerPlugin;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.container.adapter.griver.GriverContainerPresenter;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class PageHelperEventHandler implements GriverPageHelperEvent {

    /* renamed from: a  reason: collision with root package name */
    private static BaseContainerPlugin f7560a;

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.griver.api.common.page.GriverPageHelperEvent
    public void onPageBacked(Page page) {
    }

    @Override // com.alibaba.griver.api.common.page.GriverPageHelperEvent
    public void onPageDestroy(Page page) {
    }

    @Override // com.alibaba.griver.api.common.page.GriverPageHelperEvent
    public void onPageExit(Page page) {
    }

    @Override // com.alibaba.griver.api.common.page.GriverPageHelperEvent
    public void onPagePause(Page page) {
    }

    @Override // com.alibaba.griver.api.common.page.GriverPageHelperEvent
    public void onPageResume(Page page) {
    }

    @Override // com.alibaba.griver.api.common.page.GriverPageHelperEvent
    public void onProgressChanged(Page page, String str, int i) {
    }

    public static void setPlugin(BaseContainerPlugin baseContainerPlugin) {
        f7560a = baseContainerPlugin;
    }

    @Override // com.alibaba.griver.api.common.page.GriverPageHelperEvent
    public void onPageStarted(Page page, String str) {
        ACLog.d("AppEventHandler", "onPageStarted url == ".concat(String.valueOf(str)));
        if (f7560a != null) {
            ContainerEvent containerEvent = new ContainerEvent(ContainerEventAction.ACTION_WEB_PAGE_STARTED, new GriverContainerPresenter(page));
            containerEvent.params = new JSONObject();
            try {
                containerEvent.params.put("url", str);
            } catch (JSONException unused) {
            }
            f7560a.interceptorEvent(containerEvent);
        }
    }

    @Override // com.alibaba.griver.api.common.page.GriverPageHelperEvent
    public void onPageFinished(Page page, String str) {
        ACLog.d("AppEventHandler", "onPageFinished url == ".concat(String.valueOf(str)));
        if (f7560a != null) {
            ContainerEvent containerEvent = new ContainerEvent(ContainerEventAction.ACTION_WEB_PAGE_FINISHED, new GriverContainerPresenter(page));
            containerEvent.params = new JSONObject();
            try {
                containerEvent.params.put("url", str);
            } catch (JSONException unused) {
            }
            f7560a.interceptorEvent(containerEvent);
        }
    }
}
