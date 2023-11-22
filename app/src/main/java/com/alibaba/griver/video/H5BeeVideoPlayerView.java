package com.alibaba.griver.video;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.ariver.app.api.AppContext;
import com.alibaba.ariver.app.api.point.app.AppOnConfigurationChangedPoint;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVExtensionService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.beehive.lottie.player.LottieParams;
import com.alibaba.griver.video.BeeVideoPlayerViewWrapper;
import com.alibaba.griver.video.H5Event;
import com.alibaba.griver.video.base.BasePlayer;
import com.alibaba.griver.video.base.BeeBaseEmbedView;
import com.alibaba.griver.video.base.BeeVideoPlayerBuilder;
import com.alibaba.griver.video.base.UIConfig;
import com.alibaba.griver.video.base.VideoConfig;
import id.dana.sendmoney.summary.SummaryActivity;
import java.util.Map;

/* loaded from: classes6.dex */
public class H5BeeVideoPlayerView extends BeeBaseEmbedView implements BeeVideoPlayerViewWrapper.IEventListener {
    public static String CAN_USE_VIDEO = "CAN_USE_VIDEO";

    /* renamed from: a  reason: collision with root package name */
    private UIConfig f6783a;
    private VideoConfig b;
    private boolean c = false;
    private boolean d = true;
    private String e;

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public String getType() {
        return "video";
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onRequestPermissionResult(int i, String[] strArr, int[] iArr) {
    }

    public H5BeeVideoPlayerView() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.TAG);
        sb.append("[DOWN]");
        String obj = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("H5BeeVideoPlayerView Constructed, hash=");
        sb2.append(hashCode());
        GriverLogger.e(obj, sb2.toString());
        BeeVideoPlayerBuilder beeVideoPlayerBuilder = new BeeVideoPlayerBuilder();
        this.f6783a = beeVideoPlayerBuilder.setNeedBottomToolBar(true, true).setNeedCenterPlayBtn(true, true).setNeedCloseBtn(false, 0, true).setNeedBufferingView(true).setToolbarStyle(true, true, true).showFirstFrameAsPoster(false).setMobileNetHintLevel(1).buildUIConfig();
        this.b = beeVideoPlayerBuilder.setVideoId("").setBusinessId("NBVideoPlayerComponent").setKeepScreenOn(true).setNeedThumbnail(true).buildVideoConfig();
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public View getView(int i, int i2, String str, String str2, Map<String, String> map) {
        Context context;
        StringBuilder sb = new StringBuilder();
        sb.append(this.TAG);
        sb.append("[DOWN]");
        String obj = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getView, viewId=");
        sb2.append(str);
        sb2.append(", mType=");
        sb2.append(str2);
        sb2.append(", dimension=");
        sb2.append(i);
        sb2.append("x");
        sb2.append(i2);
        sb2.append(", params=");
        sb2.append(map);
        GriverLogger.d(obj, sb2.toString());
        boolean equals = SummaryActivity.CHECKED.equals(map.get(CAN_USE_VIDEO));
        AppContext appContext = this.mOuterApp.getAppContext();
        if (appContext == null || (context = appContext.getContext()) == null) {
            return null;
        }
        this.e = str;
        this.playerView = BeePlayerManager.getInstance().createView(context, this.mOuterApp != null ? BeePlayerManager.generateKey(str) : str, str, this, equals);
        if (this.playerView == null) {
            return null;
        }
        GriverExecutors.getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.griver.video.H5BeeVideoPlayerView.1
            @Override // java.lang.Runnable
            public void run() {
                H5BeeVideoPlayerView.this.playerView.setVisibility(0);
            }
        });
        if (map != null) {
            String str3 = map.get("data");
            if (!TextUtils.isEmpty(str3)) {
                try {
                    JSONObject parseObject = JSON.parseObject(str3);
                    if (parseObject != null) {
                        a(parseObject);
                    }
                } catch (Exception e) {
                    String str4 = this.TAG;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(e);
                    GriverLogger.e(str4, sb3.toString());
                }
            }
        }
        if (this.mOuterPage != null && this.mOuterApp != null) {
            ((RVExtensionService) RVProxy.get(RVExtensionService.class)).getExtensionManager().registerExtensionByPoint(this.mOuterApp, AppOnConfigurationChangedPoint.class, this.mOnConfigurationChangedPoint);
        }
        return this.playerView;
    }

    @Override // com.alibaba.ariver.integration.embedview.BaseEmbedView, com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void triggerPreSnapshot() {
        GriverLogger.e(this.TAG, "triggerPreSnapshot");
        if (this.playerView != null) {
            this.playerView.takeSnapshot();
        }
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this.mOuterApp.getAppContext().getContext());
        Intent intent = new Intent();
        intent.setAction("embedview.snapshot.complete");
        localBroadcastManager.sendBroadcast(intent);
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public Bitmap getSnapshot() {
        if (this.playerView != null) {
            return this.playerView.getSnapshot();
        }
        return null;
    }

    @Override // com.alibaba.ariver.integration.embedview.BaseEmbedView, com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onDestroy() {
        super.onDestroy();
        String generateKey = BeePlayerManager.generateKey(this.e);
        BeePlayerManager.getInstance().destroyView(generateKey);
        this.playerView = null;
        StringBuilder sb = new StringBuilder();
        sb.append(this.TAG);
        sb.append("[DOWN]");
        String obj = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onEmbedViewDestory finished, key=");
        sb2.append(generateKey);
        GriverLogger.d(obj, sb2.toString());
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onEmbedViewVisibilityChanged(int i) {
        if (this.playerView != null) {
            this.playerView.visChanged(i);
        }
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onWebViewResume() {
        if (this.c) {
            this.c = false;
            if (this.playerView != null) {
                this.playerView.startPlay(0L);
            }
        }
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onWebViewPause() {
        if (this.playerView == null || !this.playerView.isPlaying()) {
            return;
        }
        this.playerView.pausePlay();
        this.c = true;
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onAttachedToWebView() {
        if (this.playerView != null) {
            this.playerView.onAttachedToWindow();
        }
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onDetachedToWebView() {
        if (this.playerView != null) {
            this.playerView.onDetachedFromWindow();
        }
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onReceivedMessage(String str, JSONObject jSONObject, BridgeCallback bridgeCallback) {
        char c;
        StringBuilder sb = new StringBuilder();
        sb.append(this.TAG);
        sb.append("[DOWN]");
        String obj = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("actionType=");
        sb2.append(str);
        GriverLogger.d(obj, sb2.toString());
        if (TextUtils.isEmpty(str) || this.playerView == null) {
            return;
        }
        try {
            switch (str.hashCode()) {
                case -802181223:
                    if (str.equals(H5Constants.ACTION_EXIT_FULLSCREEN)) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case -39033168:
                    if (str.equals(H5Constants.ACTION_GET_CURRENT_TIME)) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case 3363353:
                    if (str.equals(H5Constants.ACTION_MUTE)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 3443508:
                    if (str.equals("play")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 3526264:
                    if (str.equals(H5Constants.ACTION_SEEK)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 3540994:
                    if (str.equals("stop")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 106440182:
                    if (str.equals("pause")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 458133450:
                    if (str.equals(H5Constants.ACTION_REQ_FULLSCREEN)) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 1355420059:
                    if (str.equals(H5Constants.ACTION_PLAY_RATE)) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    if (this.playerView != null) {
                        this.playerView.startPlay(this.b.startPlayPos);
                        notifySuccess(bridgeCallback);
                        return;
                    }
                    notifyFailed(bridgeCallback);
                    return;
                case 1:
                    if (this.playerView != null) {
                        this.playerView.pausePlay();
                        notifySuccess(bridgeCallback);
                        return;
                    }
                    notifyFailed(bridgeCallback);
                    return;
                case 2:
                    if (jSONObject != null && jSONObject.containsKey(H5Constants.ACTION_KEY_MUTE_ISON) && this.playerView != null) {
                        this.playerView.setMute(jSONObject.getBooleanValue(H5Constants.ACTION_KEY_MUTE_ISON));
                        notifySuccess(bridgeCallback);
                        return;
                    }
                    notifyFailed(bridgeCallback);
                    return;
                case 3:
                    if (jSONObject != null && jSONObject.containsKey("time") && this.playerView != null) {
                        this.playerView.seekTo(jSONObject.getFloatValue("time") * 1000.0f);
                        notifySuccess(bridgeCallback);
                        return;
                    }
                    notifyFailed(bridgeCallback);
                    return;
                case 4:
                    this.playerView.stopPlay();
                    notifySuccess(bridgeCallback);
                    return;
                case 5:
                    if (jSONObject != null && jSONObject.containsKey("rate") && this.playerView != null) {
                        this.playerView.setPlayRate(jSONObject.getFloatValue("rate"));
                        notifySuccess(bridgeCallback);
                        return;
                    }
                    notifyFailed(bridgeCallback);
                    return;
                case 6:
                    int i = 90;
                    if (jSONObject != null && jSONObject.containsKey("direction")) {
                        i = (int) jSONObject.getFloatValue("direction");
                    }
                    if (this.playerView != null) {
                        this.playerView.enterFullScreen(i);
                        notifySuccess(bridgeCallback);
                        return;
                    }
                    notifyFailed(bridgeCallback);
                    return;
                case 7:
                    if (this.playerView != null) {
                        this.playerView.exitFullScreen();
                        notifySuccess(bridgeCallback);
                        return;
                    }
                    notifyFailed(bridgeCallback);
                    return;
                case '\b':
                    if (this.playerView != null) {
                        long currentPosition = this.playerView.getCurrentPosition();
                        if (bridgeCallback != null) {
                            String str2 = this.TAG;
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("getCurrentTime, currentTime=");
                            sb3.append(currentPosition);
                            GriverLogger.d(str2, sb3.toString());
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("success", (Object) Boolean.TRUE);
                            jSONObject2.put("currentTime", (Object) Float.valueOf(((float) currentPosition) / 1000.0f));
                            bridgeCallback.sendJSONResponse(jSONObject2);
                            return;
                        }
                        return;
                    }
                    notifyFailed(bridgeCallback, -1, "Player already destroyed!");
                    return;
                default:
                    notifyFailed(bridgeCallback);
                    return;
            }
        } catch (Exception e) {
            GriverLogger.e(this.TAG, "", e);
        }
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onReceivedRender(JSONObject jSONObject, BridgeCallback bridgeCallback) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.TAG);
        sb.append("[DOWN]");
        String obj = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onReceivedRender, jsonObject=");
        sb2.append(jSONObject);
        GriverLogger.d(obj, sb2.toString());
        if (this.playerView == null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(this.TAG);
            sb3.append("[DOWN]");
            GriverLogger.e(sb3.toString(), "onReceivedRender, playerView is null!");
            return;
        }
        a(jSONObject);
        VideoConfig videoConfig = this.b;
        StringBuilder sb4 = new StringBuilder();
        sb4.append("NBVideoPlayerComponent_");
        sb4.append(this.e);
        videoConfig.businessId = sb4.toString();
        this.playerView.setPlayerConfig(this.b, this.f6783a, JSONUtils.getBoolean(jSONObject, "autoplay", false));
        this.d = true;
        this.playerView.setFullScreenDirection(this.f6783a.direction);
        notifySuccess(bridgeCallback);
    }

    @Override // com.alibaba.griver.video.BeeVideoPlayerViewWrapper.IEventListener
    public void onReceiveNativeEvent(H5Event h5Event) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.TAG);
        sb.append("[UP]");
        String obj = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onReceiveNativeEvent, event.event=");
        sb2.append(h5Event.event);
        GriverLogger.d(obj, sb2.toString());
        if (this.playerView == null) {
            GriverLogger.e(this.TAG, "onReceiveNativeEvent, playerView is null!");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(LottieParams.KEY_ELEMENT_ID, (Object) this.playerView.getKey());
        switch (h5Event.event) {
            case -1:
                jSONObject2.put("code", (Object) Integer.valueOf(h5Event.code));
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("errorCode", (Object) Integer.valueOf(h5Event.code));
                jSONObject3.put("error", (Object) Integer.valueOf(h5Event.code));
                if (!TextUtils.isEmpty(h5Event.desc)) {
                    jSONObject3.put("errorMsg", (Object) h5Event.desc);
                    jSONObject3.put("errorMessage", (Object) h5Event.desc);
                } else {
                    jSONObject3.put("errorMsg", (Object) "");
                    jSONObject3.put("errorMessage", (Object) "");
                }
                if (h5Event.extra != null && (h5Event.extra instanceof JSONObject)) {
                    jSONObject3.put("info", (Object) ((JSONObject) h5Event.extra));
                }
                jSONObject2.put("info", (Object) jSONObject3.toJSONString());
                jSONObject.put("data", (Object) jSONObject2);
                StringBuilder sb3 = new StringBuilder();
                sb3.append(this.TAG);
                sb3.append("[UP]");
                String obj2 = sb3.toString();
                StringBuilder sb4 = new StringBuilder();
                sb4.append("onReceiveNativeEvent, EVENT_ERROR, json=");
                sb4.append(jSONObject.toJSONString());
                GriverLogger.e(obj2, sb4.toString());
                this.d = true;
                sendMsgToH5("nbcomponent.video.onError", jSONObject, null);
                return;
            case 0:
                a(h5Event);
                return;
            case 1:
                if (h5Event.extra == null || !(h5Event.extra instanceof H5Event.TimeStruct)) {
                    return;
                }
                H5Event.TimeStruct timeStruct = (H5Event.TimeStruct) h5Event.extra;
                jSONObject2.put("currentTime", (Object) Float.valueOf(((float) timeStruct.curTime) / 1000.0f));
                jSONObject2.put("userPlayDuration", (Object) Float.valueOf(((float) timeStruct.curPlayTime) / 1000.0f));
                jSONObject2.put("videoDuration", (Object) Float.valueOf(((float) timeStruct.duration) / 1000.0f));
                jSONObject.put("data", (Object) jSONObject2);
                StringBuilder sb5 = new StringBuilder();
                sb5.append(this.TAG);
                sb5.append("[UP]");
                String obj3 = sb5.toString();
                StringBuilder sb6 = new StringBuilder();
                sb6.append("onReceiveNativeEvent, EVENT_TIME_UPDATE, json=");
                sb6.append(jSONObject.toJSONString());
                GriverLogger.d(obj3, sb6.toString());
                sendMsgToH5("nbcomponent.video.onTimeUpdate", jSONObject, null);
                return;
            case 2:
                if (h5Event.extra == null || !(h5Event.extra instanceof Boolean)) {
                    return;
                }
                jSONObject2.put("fullScreen", (Object) ((Boolean) h5Event.extra));
                jSONObject2.put("direction", (Object) h5Event.desc);
                jSONObject.put("data", (Object) jSONObject2);
                StringBuilder sb7 = new StringBuilder();
                sb7.append(this.TAG);
                sb7.append("[UP]");
                String obj4 = sb7.toString();
                StringBuilder sb8 = new StringBuilder();
                sb8.append("onReceiveNativeEvent, EVENT_SCREEN_CHANGED, json=");
                sb8.append(jSONObject.toJSONString());
                GriverLogger.d(obj4, sb8.toString());
                sendMsgToH5("nbcomponent.video.onFullScreenChange", jSONObject, null);
                return;
            case 3:
                jSONObject2.put("tag", (Object) h5Event.desc);
                if (h5Event.extra != null && (h5Event.extra instanceof Boolean)) {
                    jSONObject2.put("value", (Object) Boolean.valueOf(((Boolean) h5Event.extra).booleanValue()));
                }
                jSONObject.put("data", (Object) jSONObject2);
                StringBuilder sb9 = new StringBuilder();
                sb9.append(this.TAG);
                sb9.append("[UP]");
                String obj5 = sb9.toString();
                StringBuilder sb10 = new StringBuilder();
                sb10.append("onReceiveNativeEvent, EVENT_TOOLBAR_ACTION, json=");
                sb10.append(jSONObject.toJSONString());
                GriverLogger.w(obj5, sb10.toString());
                sendMsgToH5("nbcomponent.video.onUserAction", jSONObject, null);
                return;
            case 4:
                if (h5Event.extra == null || !(h5Event.extra instanceof Boolean)) {
                    return;
                }
                jSONObject2.put("isVisible", (Object) Boolean.valueOf(((Boolean) h5Event.extra).booleanValue()));
                jSONObject.put("data", (Object) jSONObject2);
                StringBuilder sb11 = new StringBuilder();
                sb11.append(this.TAG);
                sb11.append("[UP]");
                String obj6 = sb11.toString();
                StringBuilder sb12 = new StringBuilder();
                sb12.append("onReceiveNativeEvent, EVENT_CONTROLS_SHOWED, json=");
                sb12.append(jSONObject.toJSONString());
                GriverLogger.w(obj6, sb12.toString());
                sendMsgToH5("nbcomponent.video.onControlVisible", jSONObject, null);
                return;
            case 5:
                if (h5Event.extra == null || !(h5Event.extra instanceof Point)) {
                    return;
                }
                Point point = (Point) h5Event.extra;
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("x", (Object) Integer.valueOf(point.x));
                jSONObject4.put("y", (Object) Integer.valueOf(point.y));
                jSONObject2.put("ptInView", (Object) jSONObject4);
                jSONObject.put("data", (Object) jSONObject2);
                StringBuilder sb13 = new StringBuilder();
                sb13.append(this.TAG);
                sb13.append("[UP]");
                String obj7 = sb13.toString();
                StringBuilder sb14 = new StringBuilder();
                sb14.append("onReceiveNativeEvent, EVENT_VIEW_CLICKED, json=");
                sb14.append(jSONObject.toJSONString());
                GriverLogger.w(obj7, sb14.toString());
                sendMsgToH5("nbcomponent.video.onTap", jSONObject, null);
                return;
            case 6:
                jSONObject2.put("code", (Object) Integer.valueOf(h5Event.code));
                try {
                    jSONObject2.put("data", (Object) JSONObject.parseObject(h5Event.desc));
                } catch (Throwable th) {
                    GriverLogger.e(this.TAG, "", th);
                }
                jSONObject.put("data", (Object) jSONObject2);
                StringBuilder sb15 = new StringBuilder();
                sb15.append(this.TAG);
                sb15.append("[UP]");
                String obj8 = sb15.toString();
                StringBuilder sb16 = new StringBuilder();
                sb16.append("onReceiveNativeEvent, EVENT_INFO, json=");
                sb16.append(jSONObject.toJSONString());
                GriverLogger.e(obj8, sb16.toString());
                sendMsgToH5("nbcomponent.video.onInfo", jSONObject, null);
                return;
            case 7:
            default:
                return;
            case 8:
                jSONObject2.put("key", (Object) RVParams.UP_STRATEGY);
                try {
                    jSONObject2.put("value", (Object) JSONObject.parseObject(h5Event.desc));
                } catch (Throwable th2) {
                    GriverLogger.e(this.TAG, "", th2);
                }
                jSONObject.put("data", (Object) jSONObject2);
                StringBuilder sb17 = new StringBuilder();
                sb17.append(this.TAG);
                sb17.append("[UP]");
                String obj9 = sb17.toString();
                StringBuilder sb18 = new StringBuilder();
                sb18.append("onReceiveNativeEvent, EVENT_UPS_INFO_GOT, json=");
                sb18.append(jSONObject.toJSONString());
                GriverLogger.e(obj9, sb18.toString());
                sendMsgToH5("nbcomponent.video.onInfo", jSONObject, null);
                return;
            case 9:
                jSONObject2.put("key", (Object) "sei");
                try {
                    JSONObject parseObject = JSONObject.parseObject(h5Event.desc);
                    if (h5Event.extra != null && (h5Event.extra instanceof Bundle)) {
                        parseObject.put("showPts", (Object) Integer.valueOf(((Bundle) h5Event.extra).getInt("pts")));
                    }
                    jSONObject2.put("value", (Object) parseObject);
                } catch (Throwable th3) {
                    GriverLogger.e(this.TAG, "", th3);
                }
                jSONObject.put("data", (Object) jSONObject2);
                StringBuilder sb19 = new StringBuilder();
                sb19.append(this.TAG);
                sb19.append("[UP]");
                String obj10 = sb19.toString();
                StringBuilder sb20 = new StringBuilder();
                sb20.append("onReceiveNativeEvent, EVENT_SEI_INFO_GOT, json=");
                sb20.append(jSONObject.toJSONString());
                GriverLogger.e(obj10, sb20.toString());
                sendMsgToH5("nbcomponent.video.onInfo", jSONObject, null);
                return;
        }
    }

    private void a(H5Event h5Event) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(LottieParams.KEY_ELEMENT_ID, (Object) this.playerView.getKey());
        switch (h5Event.code) {
            case 0:
                jSONObject2.put("state", (Object) 0);
                jSONObject.put("data", (Object) jSONObject2);
                StringBuilder sb = new StringBuilder();
                sb.append(this.TAG);
                sb.append("[UP]");
                String obj = sb.toString();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onReceiveNativeEvent-handleState, CODE_STATE_INFO_STOP, jsonObject=");
                sb2.append(jSONObject.toJSONString());
                GriverLogger.w(obj, sb2.toString());
                sendMsgToH5("nbcomponent.video.onChangeState", jSONObject, null);
                GriverExecutors.getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.griver.video.H5BeeVideoPlayerView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (H5BeeVideoPlayerView.this.playerView != null) {
                            H5BeeVideoPlayerView.this.playerView.setVisibility(8);
                        }
                    }
                });
                this.d = true;
                return;
            case 1:
                jSONObject2.put("state", (Object) 1);
                jSONObject.put("data", (Object) jSONObject2);
                StringBuilder sb3 = new StringBuilder();
                sb3.append(this.TAG);
                sb3.append("[UP]");
                String obj2 = sb3.toString();
                StringBuilder sb4 = new StringBuilder();
                sb4.append("onReceiveNativeEvent-handleState, CODE_STATE_INFO_PLAYING, jsonObject=");
                sb4.append(jSONObject.toJSONString());
                GriverLogger.w(obj2, sb4.toString());
                sendMsgToH5("nbcomponent.video.onChangeState", jSONObject, null);
                return;
            case 2:
                jSONObject2.put("state", (Object) 2);
                jSONObject.put("data", (Object) jSONObject2);
                StringBuilder sb5 = new StringBuilder();
                sb5.append(this.TAG);
                sb5.append("[UP]");
                String obj3 = sb5.toString();
                StringBuilder sb6 = new StringBuilder();
                sb6.append("onReceiveNativeEvent-handleState, CODE_STATE_INFO_PAUSE, jsonObject=");
                sb6.append(jSONObject.toJSONString());
                GriverLogger.w(obj3, sb6.toString());
                sendMsgToH5("nbcomponent.video.onChangeState", jSONObject, null);
                return;
            case 3:
                jSONObject2.put("state", (Object) 3);
                jSONObject.put("data", (Object) jSONObject2);
                StringBuilder sb7 = new StringBuilder();
                sb7.append(this.TAG);
                sb7.append("[UP]");
                String obj4 = sb7.toString();
                StringBuilder sb8 = new StringBuilder();
                sb8.append("onReceiveNativeEvent-handleState, CODE_STATE_INFO_LOADING, jsonObject=");
                sb8.append(jSONObject.toJSONString());
                GriverLogger.w(obj4, sb8.toString());
                sendMsgToH5("nbcomponent.video.onChangeState", jSONObject, null);
                return;
            case 4:
                jSONObject2.put("state", (Object) 1);
                jSONObject.put("data", (Object) jSONObject2);
                if (this.d) {
                    this.d = false;
                    return;
                }
                StringBuilder sb9 = new StringBuilder();
                sb9.append(this.TAG);
                sb9.append("[UP]");
                String obj5 = sb9.toString();
                StringBuilder sb10 = new StringBuilder();
                sb10.append("onReceiveNativeEvent-handleState, CODE_STATE_INFO_LOADING_END, jsonObject=");
                sb10.append(jSONObject.toJSONString());
                GriverLogger.w(obj5, sb10.toString());
                sendMsgToH5("nbcomponent.video.onChangeState", jSONObject, null);
                return;
            case 5:
                jSONObject2.put("state", (Object) 4);
                jSONObject.put("data", (Object) jSONObject2);
                StringBuilder sb11 = new StringBuilder();
                sb11.append(this.TAG);
                sb11.append("[UP]");
                String obj6 = sb11.toString();
                StringBuilder sb12 = new StringBuilder();
                sb12.append("onReceiveNativeEvent-handleState, CODE_STATE_INFO_COMPLETION, jsonObject=");
                sb12.append(jSONObject.toJSONString());
                GriverLogger.w(obj6, sb12.toString());
                sendMsgToH5("nbcomponent.video.onChangeState", jSONObject, null);
                this.d = true;
                return;
            case 6:
                jSONObject2.put("state", (Object) 5);
                jSONObject.put("data", (Object) jSONObject2);
                StringBuilder sb13 = new StringBuilder();
                sb13.append(this.TAG);
                sb13.append("[UP]");
                String obj7 = sb13.toString();
                StringBuilder sb14 = new StringBuilder();
                sb14.append("onReceiveNativeEvent-handleState, CODE_STATE_INFO_RENDER_START, jsonObject=");
                sb14.append(jSONObject.toJSONString());
                GriverLogger.w(obj7, sb14.toString());
                sendMsgToH5("nbcomponent.video.onChangeState", jSONObject, null);
                return;
            default:
                return;
        }
    }

    private void a(JSONObject jSONObject) {
        BeeVideoPlayerBuilder beeVideoPlayerBuilder = new BeeVideoPlayerBuilder();
        this.f6783a = beeVideoPlayerBuilder.setNeedBottomToolBar(true, true).setNeedCenterPlayBtn(true, true).setNeedCloseBtn(false, 0, true).setNeedBufferingView(true).setToolbarStyle(true, true, true).showFirstFrameAsPoster(false).setMobileNetHintLevel(1).buildUIConfig();
        VideoConfig buildVideoConfig = beeVideoPlayerBuilder.setVideoId("").setBusinessId("NBVideoPlayerComponent").setKeepScreenOn(true).setNeedThumbnail(true).buildVideoConfig();
        this.b = buildVideoConfig;
        try {
            buildVideoConfig.videoId = JSONUtils.getString(jSONObject, "src", buildVideoConfig.videoId);
            if (!TextUtils.isEmpty(this.b.videoId)) {
                VideoConfig videoConfig = this.b;
                videoConfig.videoId = videoConfig.videoId.trim();
            }
            this.b.startPlayPos = JSONUtils.getFloat(jSONObject, H5Constants.PARAM_INIT_TIME, (float) r1.startPlayPos) * 1000;
            this.b.videoDuration = JSONUtils.getFloat(jSONObject, "duration", (float) r1.videoDuration);
            VideoConfig videoConfig2 = this.b;
            videoConfig2.isLooping = JSONUtils.getBoolean(jSONObject, H5Constants.PARAM_LOOP, videoConfig2.isLooping);
            if (this.b.isLooping) {
                this.b.loopCount = Integer.MAX_VALUE;
            }
            VideoConfig videoConfig3 = this.b;
            videoConfig3.isMuteWhenPlaying = JSONUtils.getBoolean(jSONObject, H5Constants.PARAM_MUTED, videoConfig3.isMuteWhenPlaying);
            String string = JSONUtils.getString(jSONObject, H5Constants.PARAM_EXTRA_INFO, "");
            if (!TextUtils.isEmpty(string)) {
                try {
                    this.b.extraInfo = (JSONObject) JSONObject.parse(string);
                    VideoConfig videoConfig4 = this.b;
                    videoConfig4.minCacheTime = JSONUtils.getFloat(videoConfig4.extraInfo, H5Constants.PARAM_MIN_CACHE, -1.0f);
                    VideoConfig videoConfig5 = this.b;
                    videoConfig5.maxCacheTime = JSONUtils.getFloat(videoConfig5.extraInfo, H5Constants.PARAM_MAX_CACHE, -1.0f);
                    this.f6783a.needBufferingView = !JSONUtils.getBoolean(this.b.extraInfo, H5Constants.PARAM_HIDE_LOADING_VIEW, false);
                    this.f6783a.needErrorHint = JSONUtils.getBoolean(this.b.extraInfo, H5Constants.PARAM_NEED_ERROR_HINT, true);
                    this.f6783a.sliceProgressSeekable = JSONUtils.getBoolean(this.b.extraInfo, H5Constants.PARAM_SLICE_SEEKBAR_SEEKABLe, this.f6783a.sliceProgressSeekable);
                } catch (Exception e) {
                    GriverLogger.e(this.TAG, "", e);
                }
            }
            this.f6783a.direction = JSONUtils.getInt(jSONObject, "direction", -100);
            UIConfig uIConfig = this.f6783a;
            uIConfig.needBottomToolbar = JSONUtils.getBoolean(jSONObject, H5Constants.PARAM_CONTROLS, uIConfig.needBottomToolbar);
            UIConfig uIConfig2 = this.f6783a;
            uIConfig2.needSliceProgress = JSONUtils.getBoolean(jSONObject, H5Constants.PARAM_SLICE_PROGRESS, uIConfig2.needSliceProgress);
            UIConfig uIConfig3 = this.f6783a;
            uIConfig3.showMuteBtn = JSONUtils.getBoolean(jSONObject, H5Constants.PARAM_SHOW_MUTE_BTN, uIConfig3.needBottomToolbar);
            UIConfig uIConfig4 = this.f6783a;
            uIConfig4.showFullScreenBtn = JSONUtils.getBoolean(jSONObject, H5Constants.PARAM_SHOW_FULLSCREEN_BTN, uIConfig4.needBottomToolbar);
            UIConfig uIConfig5 = this.f6783a;
            uIConfig5.showPlayBtn = JSONUtils.getBoolean(jSONObject, H5Constants.PARAM_SHOW_PLAY_BTN, uIConfig5.showPlayBtn);
            UIConfig uIConfig6 = this.f6783a;
            uIConfig6.needCenterPlayBtn = JSONUtils.getBoolean(jSONObject, H5Constants.PARAM_SHOW_CENTER_PLAY_BTN, uIConfig6.needCenterPlayBtn);
            UIConfig uIConfig7 = this.f6783a;
            uIConfig7.mobileNetHintLevel = JSONUtils.getInt(jSONObject, H5Constants.PARAM_MOBILENET_HINT_TYPE, uIConfig7.mobileNetHintLevel);
            UIConfig uIConfig8 = this.f6783a;
            uIConfig8.mobileNetHintLevel = uIConfig8.mobileNetHintLevel > 3 ? 3 : this.f6783a.mobileNetHintLevel < 0 ? 0 : this.f6783a.mobileNetHintLevel;
            UIConfig uIConfig9 = this.f6783a;
            uIConfig9.showFlowRate = uIConfig9.mobileNetHintLevel == 3;
            this.f6783a.showFirstFrameAsPoster = JSONUtils.getBoolean(jSONObject, H5Constants.PARAM_SHOW_FIRST_FRAME_AS_POSTER, false);
            UIConfig uIConfig10 = this.f6783a;
            uIConfig10.posterUrl = JSONUtils.getString(jSONObject, H5Constants.PARAM_POSTER_URL, uIConfig10.posterUrl);
            UIConfig uIConfig11 = this.f6783a;
            uIConfig11.posterSize = JSONUtils.getString(jSONObject, H5Constants.PARAM_POSTER_SIZE, uIConfig11.posterSize);
            UIConfig uIConfig12 = this.f6783a;
            uIConfig12.needPlayHistory = JSONUtils.getBoolean(jSONObject, H5Constants.PARAM_ENABLE_PLAY_HISTORY, uIConfig12.needPlayHistory);
            String string2 = JSONUtils.getString(jSONObject, H5Constants.PARAM_OBJECT_FIT, BasePlayer.MODE_CONTAIN);
            if (!TextUtils.isEmpty(string2)) {
                if (string2.equals(BasePlayer.MODE_FILL)) {
                    this.b.needCenterCrop = true;
                } else if (string2.equals(BasePlayer.MODE_CONTAIN)) {
                    this.b.needCenterCrop = false;
                }
            }
            this.f6783a.needGestureOper = JSONUtils.getBoolean(jSONObject, H5Constants.PARAM_ENABLE_GESTURE, true);
            this.f6783a.needPageGesture = JSONUtils.getBoolean(jSONObject, H5Constants.PARAM_PAGE_GESTURE, false);
            this.f6783a.needProgressGesture = JSONUtils.getBoolean(jSONObject, H5Constants.PARAM_ENABLE_PROGRESS_GESTURE, true);
        } catch (Exception e2) {
            GriverLogger.e(this.TAG, "", e2);
        }
        String str = this.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("parseConfigJson, videoConfig=");
        sb.append(this.b);
        GriverLogger.d(str, sb.toString());
        String str2 = this.TAG;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("parseConfigJson, uiConfig=");
        sb2.append(this.f6783a);
        GriverLogger.d(str2, sb2.toString());
    }
}
