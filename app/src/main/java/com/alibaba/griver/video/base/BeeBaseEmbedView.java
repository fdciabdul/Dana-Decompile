package com.alibaba.griver.video.base;

import android.content.res.Configuration;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.point.app.AppOnConfigurationChangedPoint;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback;
import com.alibaba.ariver.integration.embedview.BaseEmbedView;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.video.BeeVideoPlayerViewWrapper;

/* loaded from: classes6.dex */
public abstract class BeeBaseEmbedView extends BaseEmbedView {
    protected static final String H5_2_NATIVE = "[DOWN]";
    protected static final String NATIVE_2_H5 = "[UP]";
    protected final String TAG;
    protected AppOnConfigurationChangedPoint mOnConfigurationChangedPoint;
    public BeeVideoPlayerViewWrapper playerView;

    public BeeBaseEmbedView() {
        StringBuilder sb = new StringBuilder();
        sb.append("H5BeePlayerView[");
        sb.append(hashCode());
        sb.append("]");
        this.TAG = sb.toString();
        this.mOnConfigurationChangedPoint = new AppOnConfigurationChangedPoint() { // from class: com.alibaba.griver.video.base.BeeBaseEmbedView.1
            @Override // com.alibaba.ariver.kernel.api.extension.Extension
            public void onInitialized() {
                GriverLogger.d(BeeBaseEmbedView.this.TAG, "AppOnConfigurationChangedPoint onInitialized");
            }

            @Override // com.alibaba.ariver.kernel.api.extension.Extension
            public void onFinalized() {
                GriverLogger.d(BeeBaseEmbedView.this.TAG, "AppOnConfigurationChangedPoint onFinalized");
            }

            @Override // com.alibaba.ariver.app.api.point.app.AppOnConfigurationChangedPoint
            public void onConfigurationChanged(App app, Configuration configuration, String str) {
                if (BeeBaseEmbedView.this.playerView != null) {
                    if (configuration.orientation == 1) {
                        String str2 = BeeBaseEmbedView.this.TAG;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("AppOnConfigurationChangedPoint onConfigurationChanged, ORIENTATION_PORTRAIT, s=");
                        sb2.append(str);
                        GriverLogger.d(str2, sb2.toString());
                        BeeBaseEmbedView.this.playerView.onSwitchToPortrait();
                    } else if (configuration.orientation == 2) {
                        String str3 = BeeBaseEmbedView.this.TAG;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("AppOnConfigurationChangedPoint onConfigurationChanged, ORIENTATION_LANDSCAPE, s=");
                        sb3.append(str);
                        GriverLogger.d(str3, sb3.toString());
                        BeeBaseEmbedView.this.playerView.onSwitchToLandscape();
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifySuccess(BridgeCallback bridgeCallback) {
        if (bridgeCallback != null) {
            GriverLogger.d(this.TAG, "notifySuccess");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("success", (Object) Boolean.TRUE);
            bridgeCallback.sendJSONResponse(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyFailed(BridgeCallback bridgeCallback) {
        if (bridgeCallback != null) {
            GriverLogger.d(this.TAG, "notifyFailed");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("success", (Object) Boolean.FALSE);
            jSONObject.put("error", (Object) (-1));
            jSONObject.put("errorMessage", "sendMessage error!");
            bridgeCallback.sendJSONResponse(jSONObject);
            notifyFailed(bridgeCallback, -1, "Param invalid or player already destroyed!");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyFailed(BridgeCallback bridgeCallback, int i, String str) {
        if (bridgeCallback != null) {
            GriverLogger.d(this.TAG, "notifyFailed");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("success", (Object) Boolean.FALSE);
            jSONObject.put("error", (Object) Integer.valueOf(i));
            jSONObject.put("errorMessage", (Object) str);
            bridgeCallback.sendJSONResponse(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendMsgToH5(String str, JSONObject jSONObject, SendToRenderCallback sendToRenderCallback) {
        EngineUtils.sendToRender(this.mOuterPage.getRender(), str, jSONObject, sendToRenderCallback);
    }
}
