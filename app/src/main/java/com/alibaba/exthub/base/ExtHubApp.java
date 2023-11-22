package com.alibaba.exthub.base;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcel;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppContext;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.RVEngine;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.api.security.Accessor;
import com.alibaba.ariver.kernel.api.security.Group;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.multiinstance.InstanceType;
import com.alibaba.ariver.kernel.ipc.IpcMessageHandler;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.List;

/* loaded from: classes3.dex */
public class ExtHubApp implements App {

    /* renamed from: a  reason: collision with root package name */
    private String f6258a;
    private Page b;
    private AppContext c;

    @Override // com.alibaba.ariver.app.api.App
    public void addPageReadyListener(App.PageReadyListener pageReadyListener) {
    }

    @Override // com.alibaba.ariver.app.api.App
    public boolean backPressed() {
        return false;
    }

    @Override // com.alibaba.ariver.kernel.api.node.Node
    public <T extends Node> T bubbleFindNode(Class<T> cls) {
        return null;
    }

    @Override // com.alibaba.ariver.kernel.api.node.ValueStore
    public boolean containsKey(String str) {
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.alibaba.ariver.app.api.App
    public void exit() {
    }

    @Override // com.alibaba.ariver.app.api.App
    public int getAlivePageCount() {
        return 0;
    }

    @Override // com.alibaba.ariver.app.api.App
    public String getAppType() {
        return null;
    }

    @Override // com.alibaba.ariver.app.api.App
    public String getAppVersion() {
        return null;
    }

    @Override // com.alibaba.ariver.kernel.api.node.ValueStore
    public boolean getBooleanValue(String str) {
        return false;
    }

    @Override // com.alibaba.ariver.kernel.api.node.Node
    public Node getChild(long j) {
        return null;
    }

    @Override // com.alibaba.ariver.kernel.api.node.Node
    public Node getChildAt(int i) {
        return null;
    }

    @Override // com.alibaba.ariver.kernel.api.node.Node
    public int getChildCount() {
        return 0;
    }

    @Override // com.alibaba.ariver.kernel.api.node.DataNode
    public <T> T getData(Class<T> cls) {
        return null;
    }

    @Override // com.alibaba.ariver.kernel.api.node.DataNode, com.alibaba.ariver.kernel.api.node.Node
    public <T> T getData(Class<T> cls, boolean z) {
        return null;
    }

    @Override // com.alibaba.ariver.app.api.App
    public RVEngine getEngineProxy() {
        return null;
    }

    @Override // com.alibaba.ariver.app.api.App
    public ExtensionManager getExtensionManager() {
        return null;
    }

    @Override // com.alibaba.ariver.kernel.api.security.Accessor
    public Group getGroup() {
        return null;
    }

    @Override // com.alibaba.ariver.kernel.api.node.Node
    public int getIndexOfChild(Node node) {
        return 0;
    }

    @Override // com.alibaba.ariver.kernel.api.node.Node
    public InstanceType getInstanceType() {
        return null;
    }

    @Override // com.alibaba.ariver.kernel.api.node.ValueStore
    public int getIntValue(String str) {
        return 0;
    }

    @Override // com.alibaba.ariver.kernel.api.node.ValueStore
    public JSONArray getJsonArrayValue(String str) {
        return null;
    }

    @Override // com.alibaba.ariver.kernel.api.node.ValueStore
    public JSONObject getJsonValue(String str) {
        return null;
    }

    @Override // com.alibaba.ariver.kernel.api.node.ValueStore
    public long getLongValue(String str) {
        return 0L;
    }

    @Override // com.alibaba.ariver.app.api.App
    public IpcMessageHandler getMsgHandler() {
        return null;
    }

    @Override // com.alibaba.ariver.kernel.api.node.Node
    public long getNodeId() {
        return 0L;
    }

    @Override // com.alibaba.ariver.app.api.App
    public Page getPageByIndex(int i) {
        return null;
    }

    @Override // com.alibaba.ariver.app.api.App
    public Page getPageByNodeId(long j) {
        return null;
    }

    @Override // com.alibaba.ariver.kernel.api.node.Node
    public Node getParentNode() {
        return null;
    }

    @Override // com.alibaba.ariver.app.api.App
    public Bundle getSceneParams() {
        return null;
    }

    @Override // com.alibaba.ariver.kernel.api.node.Scope
    public Class getScopeType() {
        return null;
    }

    @Override // com.alibaba.ariver.app.api.App
    public long getStartToken() {
        return 0L;
    }

    @Override // com.alibaba.ariver.app.api.App
    public String getStartUrl() {
        return null;
    }

    @Override // com.alibaba.ariver.kernel.api.node.ValueStore
    public String getStringValue(String str) {
        return null;
    }

    @Override // com.alibaba.ariver.app.api.App
    public void init(String str, Bundle bundle, Bundle bundle2) {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Accessor
    public void inquiry(List<? extends Permission> list, Accessor.InquiryCallback inquiryCallback) {
    }

    @Override // com.alibaba.ariver.kernel.api.node.Node
    public boolean isChildless() {
        return false;
    }

    @Override // com.alibaba.ariver.app.api.App
    public boolean isDestroyed() {
        return false;
    }

    @Override // com.alibaba.ariver.app.api.App
    public boolean isExited() {
        return false;
    }

    @Override // com.alibaba.ariver.app.api.App
    public boolean isFirstPage() {
        return false;
    }

    @Override // com.alibaba.ariver.app.api.App
    public boolean isShadowNode() {
        return false;
    }

    @Override // com.alibaba.ariver.app.api.App
    public boolean isTinyApp() {
        return false;
    }

    @Override // com.alibaba.ariver.app.api.App
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.alibaba.ariver.kernel.api.node.Node
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.node.Node
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.app.api.App
    public void onUserInteraction() {
    }

    @Override // com.alibaba.ariver.app.api.App
    public void onUserLeaveHint() {
    }

    @Override // com.alibaba.ariver.app.api.App
    public void pause() {
    }

    @Override // com.alibaba.ariver.kernel.api.node.Node
    public Node peekChild() {
        return null;
    }

    @Override // com.alibaba.ariver.app.api.App
    public void performBack() {
    }

    @Override // com.alibaba.ariver.kernel.api.node.Node
    public Node popChild() {
        return null;
    }

    @Override // com.alibaba.ariver.app.api.App
    public void popPage(JSONObject jSONObject) {
    }

    @Override // com.alibaba.ariver.app.api.App
    public void popTo(int i, boolean z, JSONObject jSONObject) {
    }

    @Override // com.alibaba.ariver.app.api.App
    public Page preCreatePage() {
        return null;
    }

    @Override // com.alibaba.ariver.kernel.api.node.Node
    public void pushChild(Node node) {
    }

    @Override // com.alibaba.ariver.app.api.App
    public boolean pushPage(String str, Bundle bundle, Bundle bundle2) {
        return false;
    }

    @Override // com.alibaba.ariver.kernel.api.node.ValueStore
    public void putBooleanValue(String str, boolean z) {
    }

    @Override // com.alibaba.ariver.kernel.api.node.ValueStore
    public void putIntValue(String str, int i) {
    }

    @Override // com.alibaba.ariver.kernel.api.node.ValueStore
    public void putJsonArrayValue(String str, JSONArray jSONArray) {
    }

    @Override // com.alibaba.ariver.kernel.api.node.ValueStore
    public void putJsonValue(String str, JSONObject jSONObject) {
    }

    @Override // com.alibaba.ariver.kernel.api.node.ValueStore
    public void putLongValue(String str, long j) {
    }

    @Override // com.alibaba.ariver.kernel.api.node.ValueStore
    public void putStringValue(String str, String str2) {
    }

    @Override // com.alibaba.ariver.app.api.App
    public void relaunchToUrl(String str, Bundle bundle, Bundle bundle2) {
    }

    @Override // com.alibaba.ariver.kernel.api.node.Node
    public boolean removeChild(Node node) {
        return false;
    }

    @Override // com.alibaba.ariver.app.api.App
    public void removePage(Page page, boolean z) {
    }

    @Override // com.alibaba.ariver.app.api.App
    public void restart(Bundle bundle, Bundle bundle2) {
    }

    @Override // com.alibaba.ariver.app.api.App
    public void restartFromServer(Bundle bundle) {
    }

    @Override // com.alibaba.ariver.app.api.App
    public void resume() {
    }

    @Override // com.alibaba.ariver.app.api.App
    public void setAppType(String str) {
    }

    @Override // com.alibaba.ariver.kernel.api.node.DataNode
    public <T> void setData(Class<T> cls, T t) {
    }

    @Override // com.alibaba.ariver.kernel.api.node.Node
    public void setParentNode(Node node) {
    }

    @Override // com.alibaba.ariver.app.api.App
    public void start() {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Accessor
    public List<Permission> usePermissions() {
        return null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
    }

    public ExtHubApp(String str) {
        this.b = new ExtHubPage(this);
        this.f6258a = str;
        this.c = new ExtHubAppContext();
    }

    public ExtHubApp(String str, Page page) {
        this.f6258a = str;
        this.b = page;
        this.c = new ExtHubAppContext();
    }

    @Override // com.alibaba.ariver.app.api.App
    public String getAppId() {
        return this.f6258a;
    }

    @Override // com.alibaba.ariver.app.api.App
    public Bundle getStartParams() {
        Bundle bundle = new Bundle();
        bundle.putString("appId", this.f6258a);
        return bundle;
    }

    @Override // com.alibaba.ariver.app.api.App
    public void bindContext(AppContext appContext) {
        this.c = appContext;
    }

    @Override // com.alibaba.ariver.app.api.App
    public AppContext getAppContext() {
        return this.c;
    }

    @Override // com.alibaba.ariver.app.api.App
    public Page getActivePage() {
        return this.b;
    }
}
