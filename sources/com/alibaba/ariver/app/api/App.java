package com.alibaba.ariver.app.api;

import android.content.res.Configuration;
import android.os.Bundle;
import com.alibaba.ariver.engine.api.RVEngine;
import com.alibaba.ariver.kernel.api.annotation.Local;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.node.DataNode;
import com.alibaba.ariver.kernel.api.node.Scope;
import com.alibaba.ariver.kernel.api.node.ValueStore;
import com.alibaba.ariver.kernel.ipc.IpcMessageHandler;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes2.dex */
public interface App extends DataNode, Scope, ValueStore {

    /* loaded from: classes6.dex */
    public interface PageReadyListener {
        void onPageReady(Page page);
    }

    void addPageReadyListener(PageReadyListener pageReadyListener);

    boolean backPressed();

    void bindContext(AppContext appContext);

    void exit();

    Page getActivePage();

    int getAlivePageCount();

    AppContext getAppContext();

    @Local
    String getAppId();

    @Local
    String getAppType();

    @Local
    String getAppVersion();

    RVEngine getEngineProxy();

    ExtensionManager getExtensionManager();

    IpcMessageHandler getMsgHandler();

    Page getPageByIndex(int i);

    Page getPageByNodeId(long j);

    @Local
    Bundle getSceneParams();

    @Local
    Bundle getStartParams();

    @Local
    long getStartToken();

    @Local
    String getStartUrl();

    void init(String str, Bundle bundle, Bundle bundle2);

    boolean isDestroyed();

    boolean isExited();

    boolean isFirstPage();

    boolean isShadowNode();

    boolean isTinyApp();

    void onConfigurationChanged(Configuration configuration);

    void onUserInteraction();

    void onUserLeaveHint();

    void pause();

    void performBack();

    void popPage(JSONObject jSONObject);

    void popTo(int i, boolean z, JSONObject jSONObject);

    Page preCreatePage();

    boolean pushPage(String str, Bundle bundle, Bundle bundle2);

    void relaunchToUrl(String str, Bundle bundle, Bundle bundle2);

    void removePage(Page page, boolean z);

    void restart(Bundle bundle, Bundle bundle2);

    void restartFromServer(Bundle bundle);

    void resume();

    void setAppType(String str);

    void start();

    /* loaded from: classes6.dex */
    public static class ResumeParams {
        public JSONObject data;

        public ResumeParams(JSONObject jSONObject) {
            this.data = jSONObject;
        }
    }

    /* loaded from: classes3.dex */
    public static class PopParams {
        public JSONObject data;

        public PopParams(JSONObject jSONObject) {
            this.data = jSONObject;
        }
    }
}
