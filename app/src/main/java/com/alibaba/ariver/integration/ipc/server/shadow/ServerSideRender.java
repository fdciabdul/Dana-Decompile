package com.alibaba.ariver.integration.ipc.server.shadow;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import com.alibaba.ariver.engine.BaseRenderImpl;
import com.alibaba.ariver.engine.api.RVEngine;
import com.alibaba.ariver.engine.api.bridge.RenderBridge;
import com.alibaba.ariver.engine.api.bridge.model.CreateParams;
import com.alibaba.ariver.engine.api.bridge.model.ScrollChangedCallback;
import com.alibaba.ariver.kernel.api.node.DataNode;

/* loaded from: classes3.dex */
public class ServerSideRender extends BaseRenderImpl {
    @Override // com.alibaba.ariver.engine.api.Render
    public Bitmap getCapture(int i) {
        return null;
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public int getPageId() {
        return 0;
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public RenderBridge getRenderBridge() {
        return null;
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public int getScrollY() {
        return 0;
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public View getView() {
        return null;
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public void init() {
    }

    @Override // com.alibaba.ariver.engine.BaseRenderImpl
    public void onDestroy() {
    }

    @Override // com.alibaba.ariver.engine.BaseRenderImpl, com.alibaba.ariver.engine.api.Render
    public void onPause() {
    }

    @Override // com.alibaba.ariver.engine.BaseRenderImpl, com.alibaba.ariver.engine.api.Render
    public void onResume() {
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public void setScrollChangedCallback(ScrollChangedCallback scrollChangedCallback) {
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public void showErrorView(View view) {
    }

    public ServerSideRender(RVEngine rVEngine, Activity activity, DataNode dataNode, CreateParams createParams) {
        super(rVEngine, activity, dataNode, createParams);
    }
}
