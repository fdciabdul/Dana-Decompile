package com.iap.ac.android.container.adapter.griver.event;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.api.common.page.GriverInterceptUrlEvent;
import com.iap.ac.android.common.container.constant.ContainerEventAction;
import com.iap.ac.android.common.container.event.ContainerEvent;
import com.iap.ac.android.common.container.plugin.BaseContainerPlugin;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.container.adapter.griver.GriverContainerPresenter;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class InterceptUrlEventHandler implements GriverInterceptUrlEvent {

    /* renamed from: a  reason: collision with root package name */
    private static BaseContainerPlugin f7559a;

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    public static void setPlugin(BaseContainerPlugin baseContainerPlugin) {
        f7559a = baseContainerPlugin;
    }

    @Override // com.alibaba.griver.api.common.page.GriverInterceptUrlEvent
    public boolean interceptUrl(Page page, String str) {
        ACLog.d("InterceptUrlEventHandler", "interceptUrl url == ".concat(String.valueOf(str)));
        if (f7559a != null) {
            ContainerEvent containerEvent = new ContainerEvent(ContainerEventAction.ACTION_WEB_PAGE_SHOULD_OVERRIDE_URL, new GriverContainerPresenter(page));
            containerEvent.params = new JSONObject();
            try {
                containerEvent.params.put("url", str);
            } catch (JSONException e) {
                ACLog.e("InterceptUrlEventHandler", String.valueOf(e));
            }
            boolean interceptorEvent = f7559a.interceptorEvent(containerEvent);
            RVLogger.d("InterceptUrlEventHandler", "interceptUrl == result ".concat(String.valueOf(interceptorEvent)));
            return interceptorEvent;
        }
        return false;
    }
}
