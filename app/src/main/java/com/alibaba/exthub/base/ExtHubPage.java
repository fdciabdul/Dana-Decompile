package com.alibaba.exthub.base;

import android.os.Bundle;
import android.os.Parcel;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.EmbedType;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.PageContext;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.common.bridge.dispatch.BridgeDispatcher;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.api.security.Accessor;
import com.alibaba.ariver.kernel.api.security.Group;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.multiinstance.InstanceType;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.List;

/* loaded from: classes3.dex */
public class ExtHubPage implements Page {

    /* renamed from: a  reason: collision with root package name */
    private App f6260a;
    private Render b = new ExtHubRender(this);
    private PageContext c;

    @Override // com.alibaba.ariver.app.api.Page
    public void addJsBridgeReadyListener(Page.JsBridgeReadyListener jsBridgeReadyListener) {
    }

    @Override // com.alibaba.ariver.app.api.Page
    public void addRenderReadyListener(Page.RenderReadyListener renderReadyListener) {
    }

    @Override // com.alibaba.ariver.app.api.Page
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

    @Override // com.alibaba.ariver.app.api.Page
    public void enter() {
    }

    @Override // com.alibaba.ariver.app.api.Page
    public void exit(boolean z) {
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

    @Override // com.alibaba.ariver.app.api.Page
    public Page getEmbedPage() {
        return null;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public EmbedType getEmbedType() {
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

    @Override // com.alibaba.ariver.kernel.api.node.Node
    public long getNodeId() {
        return 0L;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public int getPageId() {
        return 0;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public String getPageType() {
        return null;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public Bundle getSceneParams() {
        return null;
    }

    @Override // com.alibaba.ariver.kernel.api.node.Scope
    public Class getScopeType() {
        return null;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public Bundle getStartParams() {
        return null;
    }

    @Override // com.alibaba.ariver.kernel.api.node.ValueStore
    public String getStringValue(String str) {
        return null;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public void hide() {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Accessor
    public void inquiry(List<? extends Permission> list, Accessor.InquiryCallback inquiryCallback) {
    }

    @Override // com.alibaba.ariver.kernel.api.node.Node
    public boolean isChildless() {
        return false;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public boolean isDestroyed() {
        return false;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public boolean isExited() {
        return false;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public boolean isJsBridgeReady() {
        return false;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public boolean isPageLoaded() {
        return false;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public boolean isRenderReady() {
        return false;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public boolean isShadowNode() {
        return false;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public boolean isUseForEmbed() {
        return false;
    }

    @Override // com.alibaba.ariver.kernel.api.node.Node
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.node.Node
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.app.api.Page
    public void pause() {
    }

    @Override // com.alibaba.ariver.kernel.api.node.Node
    public Node peekChild() {
        return null;
    }

    @Override // com.alibaba.ariver.kernel.api.node.Node
    public Node popChild() {
        return null;
    }

    @Override // com.alibaba.ariver.kernel.api.node.Node
    public void pushChild(Node node) {
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

    @Override // com.alibaba.ariver.kernel.api.node.Node
    public boolean removeChild(Node node) {
        return false;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public void resume() {
    }

    @Override // com.alibaba.ariver.kernel.api.node.DataNode
    public <T> void setData(Class<T> cls, T t) {
    }

    @Override // com.alibaba.ariver.app.api.Page
    public void setEmbedPage(Page page) {
    }

    @Override // com.alibaba.ariver.app.api.Page
    public void setExitListener(Page.ExitListener exitListener) {
    }

    @Override // com.alibaba.ariver.app.api.Page
    public void setJsBridgeReady() {
    }

    @Override // com.alibaba.ariver.app.api.Page
    public void setPageLoaded() {
    }

    @Override // com.alibaba.ariver.kernel.api.node.Node
    public void setParentNode(Node node) {
    }

    @Override // com.alibaba.ariver.app.api.Page
    public void show(JSONObject jSONObject) {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Accessor
    public List<Permission> usePermissions() {
        return null;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public boolean waitResourceReady(String str, boolean z, boolean z2) {
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
    }

    public ExtHubPage(String str) {
        this.f6260a = new ExtHubApp(str, this);
        BridgeDispatcher.getInstance().getNativeExtensionManager().enterNode(this);
    }

    public ExtHubPage(App app) {
        this.f6260a = app;
        BridgeDispatcher.getInstance().getNativeExtensionManager().enterNode(this);
    }

    @Override // com.alibaba.ariver.app.api.Page
    public App getApp() {
        return this.f6260a;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public String getOriginalURI() {
        StringBuilder sb = new StringBuilder();
        sb.append("mocked_url_");
        sb.append(this.f6260a.getAppId());
        return sb.toString();
    }

    @Override // com.alibaba.ariver.app.api.Page
    public String getPageURI() {
        StringBuilder sb = new StringBuilder();
        sb.append("mocked_url_");
        sb.append(this.f6260a.getAppId());
        return sb.toString();
    }

    @Override // com.alibaba.ariver.app.api.Page
    public void bindContext(PageContext pageContext) {
        this.c = pageContext;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public PageContext getPageContext() {
        return this.c;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public void destroy() {
        BridgeDispatcher.getInstance().getNativeExtensionManager().exitNode(this);
    }

    @Override // com.alibaba.ariver.app.api.Page
    public Render getRender() {
        return this.b;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public ExtensionManager getExtensionManager() {
        return BridgeDispatcher.getInstance().getExtensionManager();
    }

    @Override // com.alibaba.ariver.kernel.api.node.Node
    public Node getParentNode() {
        return this.f6260a;
    }
}
