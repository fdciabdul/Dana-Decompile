package com.alibaba.exthub.base;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import com.alibaba.ariver.engine.api.RVEngine;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.bridge.RenderBridge;
import com.alibaba.ariver.engine.api.bridge.model.ExitCallback;
import com.alibaba.ariver.engine.api.bridge.model.GoBackCallback;
import com.alibaba.ariver.engine.api.bridge.model.LoadParams;
import com.alibaba.ariver.engine.api.bridge.model.ScrollChangedCallback;
import com.alibaba.ariver.kernel.api.node.DataNode;

/* loaded from: classes3.dex */
public class ExtHubRender implements Render {

    /* renamed from: a  reason: collision with root package name */
    private RenderBridge f6262a = new ExtHubRenderBridgeImpl();
    private RVEngine b = new ExtHubRVEngine();
    private DataNode c;

    @Override // com.alibaba.ariver.engine.api.Render
    public void destroy() {
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public Activity getActivity() {
        return null;
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public String getAppId() {
        return null;
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public Bitmap getCapture(int i) {
        return null;
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public String getCurrentUri() {
        return null;
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public int getPageId() {
        return 0;
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public String getRenderId() {
        return null;
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public int getScrollY() {
        return 0;
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public Bundle getStartParams() {
        return null;
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public String getUserAgent() {
        return null;
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public View getView() {
        return null;
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public void goBack(GoBackCallback goBackCallback) {
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public boolean hasTriggeredLoad() {
        return false;
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public void init() {
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public boolean isDestroyed() {
        return false;
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public void load(LoadParams loadParams) {
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public void onPause() {
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public void onResume() {
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public void reload() {
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public void reset() {
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public void runExit(ExitCallback exitCallback) {
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public void setScrollChangedCallback(ScrollChangedCallback scrollChangedCallback) {
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public void setTextSize(int i) {
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public void showErrorView(View view) {
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public void triggerSaveSnapshot() {
    }

    public ExtHubRender(DataNode dataNode) {
        this.c = dataNode;
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public RVEngine getEngine() {
        return this.b;
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public RenderBridge getRenderBridge() {
        return this.f6262a;
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public DataNode getPage() {
        return this.c;
    }
}
