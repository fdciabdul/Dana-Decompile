package com.alibaba.ariver.app.api;

import android.os.Bundle;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.kernel.api.annotation.Local;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.node.DataNode;
import com.alibaba.ariver.kernel.api.node.Scope;
import com.alibaba.ariver.kernel.api.node.ValueStore;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes2.dex */
public interface Page extends DataNode, Scope, ValueStore {

    /* loaded from: classes2.dex */
    public static class AnimStore {
        public boolean disableEnter = false;
        public boolean disableExit = false;
    }

    /* loaded from: classes3.dex */
    public interface ExitListener {
        void onExit();
    }

    /* loaded from: classes6.dex */
    public interface JsBridgeReadyListener {
        void onJsBridgeReady();
    }

    /* loaded from: classes3.dex */
    public interface RenderReadyListener {
        void onRenderReady();
    }

    void addJsBridgeReadyListener(JsBridgeReadyListener jsBridgeReadyListener);

    void addRenderReadyListener(RenderReadyListener renderReadyListener);

    boolean backPressed();

    void bindContext(PageContext pageContext);

    void destroy();

    void enter();

    void exit(boolean z);

    @Local
    App getApp();

    Page getEmbedPage();

    EmbedType getEmbedType();

    ExtensionManager getExtensionManager();

    @Local
    String getOriginalURI();

    PageContext getPageContext();

    int getPageId();

    @Local
    String getPageType();

    String getPageURI();

    Render getRender();

    @Local
    Bundle getSceneParams();

    @Local
    Bundle getStartParams();

    void hide();

    boolean isDestroyed();

    boolean isExited();

    boolean isJsBridgeReady();

    boolean isPageLoaded();

    boolean isRenderReady();

    boolean isShadowNode();

    boolean isUseForEmbed();

    void pause();

    void resume();

    void setEmbedPage(Page page);

    void setExitListener(ExitListener exitListener);

    void setJsBridgeReady();

    void setPageLoaded();

    void show(JSONObject jSONObject);

    boolean waitResourceReady(String str, boolean z, boolean z2);
}
