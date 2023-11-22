package com.alipay.mobile.embedview;

import android.graphics.Bitmap;
import android.view.View;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.embedview.IEmbedPerformance;
import com.alibaba.ariver.engine.api.embedview.IEmbedPerformanceReporter;
import com.alibaba.ariver.integration.embedview.BaseEmbedView;
import com.alibaba.fastjson.JSONObject;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;
import java.util.Map;

/* loaded from: classes6.dex */
public class H5EmbedMapView extends BaseEmbedView implements IEmbedPerformance {

    /* renamed from: a  reason: collision with root package name */
    private H5MapContainer f7134a = new H5MapContainer();

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public Bitmap getSnapshot() {
        return null;
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public String getType() {
        return "map";
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onEmbedViewVisibilityChanged(int i) {
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onRequestPermissionResult(int i, String[] strArr, int[] iArr) {
    }

    @Override // com.alibaba.ariver.integration.embedview.BaseEmbedView, com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onCreate(Map<String, String> map) {
        super.onCreate(map);
        this.f7134a.onCreate(this.mOuterApp.getAppContext().getContext(), this.mOuterPage);
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public View getView(int i, int i2, String str, String str2, Map<String, String> map) {
        return this.f7134a.getView(i, i2, map);
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onReceivedMessage(String str, JSONObject jSONObject, BridgeCallback bridgeCallback) {
        this.f7134a.onReceivedMessage(str, jSONObject, bridgeCallback);
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onReceivedRender(JSONObject jSONObject, BridgeCallback bridgeCallback) {
        this.f7134a.onReceivedRender(jSONObject, bridgeCallback);
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onWebViewResume() {
        this.f7134a.onResume();
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onWebViewPause() {
        this.f7134a.onPause();
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onAttachedToWebView() {
        this.f7134a.onAttached();
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onDetachedToWebView() {
        this.f7134a.onPause();
        this.f7134a.onDetached();
    }

    @Override // com.alibaba.ariver.integration.embedview.BaseEmbedView, com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onDestroy() {
        this.f7134a.onDestroy();
        super.onDestroy();
    }

    @Override // com.alibaba.ariver.integration.embedview.BaseEmbedView, com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void triggerPreSnapshot() {
        this.f7134a.triggerPreSnapshot();
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedPerformance
    public void setPerformanceReporter(IEmbedPerformanceReporter iEmbedPerformanceReporter) {
        this.f7134a.renderController.setPerformanceReporter(iEmbedPerformanceReporter);
    }
}
