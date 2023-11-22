package com.alibaba.ariver.engine;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.PageContext;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.RVEngine;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.bridge.model.CreateParams;
import com.alibaba.ariver.engine.api.bridge.model.ExitCallback;
import com.alibaba.ariver.engine.api.bridge.model.GoBackCallback;
import com.alibaba.ariver.engine.api.bridge.model.LoadParams;
import com.alibaba.ariver.engine.api.common.CommonBackPerform;
import com.alibaba.ariver.engine.api.common.CommonExitPerform;
import com.alibaba.ariver.engine.api.embedview.IEmbedView;
import com.alibaba.ariver.kernel.api.node.DataNode;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public abstract class BaseRenderImpl implements Render {

    /* renamed from: a  reason: collision with root package name */
    private static AtomicInteger f6014a = new AtomicInteger(1);
    private boolean b;
    private CommonBackPerform c;
    protected LoadParams currentLoadParam;
    private CommonExitPerform d;
    private String e;
    private String f;
    private String g = null;
    protected Activity mActivity;
    protected CreateParams mCreateParams;
    protected RVEngine mEngineProxy;
    protected DataNode mNode;

    protected abstract void onDestroy();

    @Override // com.alibaba.ariver.engine.api.Render
    public void reset() {
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public void setTextSize(int i) {
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public void triggerSaveSnapshot() {
    }

    public BaseRenderImpl(RVEngine rVEngine, Activity activity, DataNode dataNode, CreateParams createParams) {
        this.mEngineProxy = rVEngine;
        this.f = rVEngine.getAppId();
        this.mActivity = activity;
        this.mNode = dataNode;
        this.mCreateParams = createParams;
        StringBuilder sb = new StringBuilder();
        sb.append(f6014a.addAndGet(1));
        this.e = sb.toString();
    }

    public void setRenderId(String str) {
        this.e = str;
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public String getUserAgent() {
        String str;
        synchronized (this) {
            if (this.g == null) {
                WebView webView = new WebView(this.mActivity);
                this.g = webView.getSettings().getUserAgentString();
                StringBuilder sb = new StringBuilder();
                sb.append(this.g);
                sb.append(" ");
                sb.append(EngineUtils.getUserAgentSuffix());
                this.g = sb.toString();
                webView.destroy();
            }
            str = this.g;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setBackPerform(CommonBackPerform commonBackPerform) {
        this.c = commonBackPerform;
    }

    public CommonBackPerform getBackPerform() {
        return this.c;
    }

    protected void setExitPerform(CommonExitPerform commonExitPerform) {
        this.d = commonExitPerform;
    }

    public CommonExitPerform getExitPerform() {
        return this.d;
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public void load(LoadParams loadParams) {
        StringBuilder sb = new StringBuilder();
        sb.append("load ");
        sb.append(loadParams);
        RVLogger.d("AriverEngine:BaseRenderImpl", sb.toString());
        this.currentLoadParam = loadParams;
    }

    public void updateLoadParamUrl(String str) {
        if (this.currentLoadParam != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("updateLoadParamUrl\t");
            sb.append(str);
            RVLogger.d("AriverEngine:BaseRenderImpl", sb.toString());
            this.currentLoadParam.url = str;
        }
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public void reload() {
        load(new LoadParams(this.currentLoadParam));
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public void goBack(GoBackCallback goBackCallback) {
        CommonBackPerform commonBackPerform = this.c;
        if (commonBackPerform != null) {
            commonBackPerform.goBack(goBackCallback);
        } else {
            goBackCallback.afterProcess(false);
        }
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public void runExit(ExitCallback exitCallback) {
        CommonExitPerform commonExitPerform = this.d;
        if (commonExitPerform != null) {
            commonExitPerform.runExit(exitCallback);
        } else {
            exitCallback.afterProcess(false);
        }
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public void onResume() {
        PageContext pageContext;
        List<IEmbedView> findAllEmbedView;
        Page page = (Page) getPage();
        if (page == null || page.getPageContext() == null || (pageContext = page.getPageContext()) == null || pageContext.getEmbedViewManager() == null || (findAllEmbedView = pageContext.getEmbedViewManager().findAllEmbedView()) == null) {
            return;
        }
        Iterator<IEmbedView> it = findAllEmbedView.iterator();
        while (it.hasNext()) {
            it.next().onWebViewResume();
        }
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public void onPause() {
        PageContext pageContext;
        List<IEmbedView> findAllEmbedView;
        Page page = (Page) getPage();
        if (page == null || page.getPageContext() == null || (pageContext = page.getPageContext()) == null || pageContext.getEmbedViewManager() == null || (findAllEmbedView = pageContext.getEmbedViewManager().findAllEmbedView()) == null) {
            return;
        }
        Iterator<IEmbedView> it = findAllEmbedView.iterator();
        while (it.hasNext()) {
            it.next().onWebViewPause();
        }
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public Bundle getStartParams() {
        return this.mCreateParams.startParams;
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public String getCurrentUri() {
        LoadParams loadParams = this.currentLoadParam;
        if (loadParams != null) {
            return loadParams.url;
        }
        DataNode page = getPage();
        if (page instanceof Page) {
            return ((Page) page).getOriginalURI();
        }
        return null;
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public final void destroy() {
        synchronized (this) {
            if (this.b) {
                return;
            }
            this.b = true;
            onDestroy();
        }
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public boolean isDestroyed() {
        return this.b;
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public String getAppId() {
        return this.f;
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public RVEngine getEngine() {
        return this.mEngineProxy;
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public DataNode getPage() {
        return this.mNode;
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public Activity getActivity() {
        return this.mActivity;
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public String getRenderId() {
        return this.e;
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public boolean hasTriggeredLoad() {
        return this.currentLoadParam != null;
    }
}
