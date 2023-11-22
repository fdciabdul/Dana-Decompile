package com.alibaba.ariver.integration.embedview;

import android.view.Surface;
import android.webkit.ValueCallback;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppManager;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback;
import com.alibaba.ariver.engine.api.embedview.IEmbedCallback;
import com.alibaba.ariver.engine.api.embedview.IEmbedView;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.TypeUtils;
import com.alibaba.ariver.resource.api.ResourceContext;
import com.alibaba.ariver.resource.runtime.ResourceContextManager;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.beehive.lottie.player.LottieParams;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class BaseEmbedView implements IEmbedView {
    protected App mOuterApp;
    protected Page mOuterPage;
    protected String mViewId;

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onSurfaceAvailable(Surface surface, int i, int i2, ValueCallback<Integer> valueCallback) {
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public boolean onSurfaceDestroyed(Surface surface) {
        return false;
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onSurfaceSizeChanged(Surface surface, int i, int i2) {
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void triggerPreSnapshot() {
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onCreate(Map<String, String> map) {
        this.mOuterApp = ((AppManager) RVProxy.get(AppManager.class)).findApp(TypeUtils.parseLong(map.get(RVConstants.EXTRA_APP_INSTANCE_ID)));
        this.mOuterPage = this.mOuterApp.getPageByNodeId(TypeUtils.parseLong(map.get(RVConstants.EXTRA_PAGE_INSTANCE_ID)));
        this.mViewId = map.get(RVConstants.EXTRA_EMBED_VIEW_ID);
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onParamChanged(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null || strArr.length != strArr2.length) {
            return;
        }
        for (int i = 0; i < strArr.length; i++) {
            if ("id".equals(strArr[i])) {
                this.mViewId = strArr2[i];
            }
        }
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void sendEvent(String str, JSONObject jSONObject, final IEmbedCallback iEmbedCallback) {
        if (this.mOuterPage == null) {
            throw new IllegalStateException("You should call super.onCreate first!!!");
        }
        JSONObject jSONObject2 = new JSONObject();
        if (!str.equals("onToWebViewMessage")) {
            StringBuilder sb = new StringBuilder();
            sb.append("nbcomponent.");
            sb.append(getType());
            sb.append(".");
            sb.append(str);
            str = sb.toString();
        }
        if (jSONObject != null) {
            jSONObject.put(LottieParams.KEY_ELEMENT_ID, (Object) this.mViewId);
            jSONObject2.put("data", (Object) jSONObject);
        }
        EngineUtils.sendToRender(this.mOuterPage.getRender(), str, jSONObject2, new SendToRenderCallback() { // from class: com.alibaba.ariver.integration.embedview.BaseEmbedView.1
            @Override // com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback
            public void onCallBack(JSONObject jSONObject3) {
                IEmbedCallback iEmbedCallback2 = iEmbedCallback;
                if (iEmbedCallback2 != null) {
                    iEmbedCallback2.onResponse(jSONObject3);
                }
            }
        });
    }

    public Resource getResource(String str) {
        ResourceContext resourceContext = ResourceContextManager.getInstance().get(this.mOuterPage.getApp().getAppId(), this.mOuterApp.getStartToken());
        if (resourceContext == null || resourceContext.getContentProvider() == null) {
            return null;
        }
        return resourceContext.getContentProvider().getContent(str);
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onDestroy() {
        this.mOuterPage = null;
    }

    public Page getOuterPage() {
        return this.mOuterPage;
    }

    public String getViewId() {
        return this.mViewId;
    }
}
