package com.alibaba.griver.core.embedview;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.integration.embedview.BaseEmbedView;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.beehive.lottie.constants.LottieConstants;
import com.alibaba.griver.beehive.lottie.player.FramePlayController;
import com.alibaba.griver.beehive.lottie.player.ILottieDataStatus;
import com.alibaba.griver.beehive.lottie.player.LottieParams;
import com.alibaba.griver.beehive.lottie.player.LottiePlayer;
import com.alibaba.griver.beehive.lottie.util.ParseUtils;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes6.dex */
public class H5BeeLottieView extends BaseEmbedView implements Animator.AnimatorListener, FramePlayController.FrameAnimationListener, ILottieDataStatus {
    private LottiePlayer b;
    private Context d;

    /* renamed from: a  reason: collision with root package name */
    private Set<Map.Entry<String, Object>> f6397a = new HashSet();
    private LottieParams c = new LottieParams();

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public Bitmap getSnapshot() {
        return null;
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public String getType() {
        return "lottieview";
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onRequestPermissionResult(int i, String[] strArr, int[] iArr) {
    }

    @Override // com.alibaba.ariver.integration.embedview.BaseEmbedView, com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void triggerPreSnapshot() {
    }

    @Override // com.alibaba.ariver.integration.embedview.BaseEmbedView, com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onCreate(Map<String, String> map) {
        super.onCreate(map);
        this.d = this.mOuterPage.getPageContext().getActivity();
        if (this.b == null) {
            this.b = new LottiePlayer(this.d, "tinyApp");
        }
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public View getView(int i, int i2, String str, String str2, Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("getView, viewId=");
        sb.append(str);
        sb.append(", mType=");
        sb.append(str2);
        sb.append(", dimensio10=");
        sb.append(i);
        sb.append("x");
        sb.append(i2);
        sb.append(", params=");
        sb.append(map);
        GriverLogger.d("H5BeeLottieView", sb.toString());
        if (this.d == null) {
            return null;
        }
        if (this.b == null) {
            this.b = new LottiePlayer(this.d, "tinyApp");
        }
        return this.b;
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onReceivedRender(JSONObject jSONObject, BridgeCallback bridgeCallback) {
        StringBuilder sb = new StringBuilder();
        sb.append("onReceivedRender, jsonObject=");
        sb.append(jSONObject);
        GriverLogger.d("H5BeeLottieView", sb.toString());
        if (this.b == null) {
            GriverLogger.d("H5BeeLottieView", "onReceivedRender: LottiePlayer is null!");
        } else if (this.mOuterPage == null) {
        } else {
            this.b.setLottieDataStatus(this);
            this.b.setFrameAnimationListener(this);
            this.b.applyParams(this.c.parseH5Bee(jSONObject));
            this.b.addAnimatorListener(this);
        }
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onAttachedToWebView() {
        this.b.attach();
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onDetachedToWebView() {
        this.b.detach();
    }

    @Override // com.alibaba.ariver.integration.embedview.BaseEmbedView, com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onDestroy() {
        super.onDestroy();
        this.f6397a.clear();
        this.b.destroy();
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onEmbedViewVisibilityChanged(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("onEmbedViewVisibilityChanged, i=");
        sb.append(i);
        GriverLogger.d("H5BeeLottieView", sb.toString());
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onWebViewResume() {
        GriverLogger.d("H5BeeLottieView", "onWebViewResume");
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onWebViewPause() {
        GriverLogger.d("H5BeeLottieView", "onWebViewPause");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onReceivedMessage(String str, JSONObject jSONObject, BridgeCallback bridgeCallback) {
        char c;
        StringBuilder sb = new StringBuilder();
        sb.append("onReceivedMessage, actionType=");
        sb.append(str);
        sb.append(", data=");
        sb.append(jSONObject);
        GriverLogger.d("H5BeeLottieView", sb.toString());
        this.f6397a.addAll(jSONObject.entrySet());
        str.hashCode();
        switch (str.hashCode()) {
            case -1262213464:
                if (str.equals(LottieConstants.METHOD_GO_TO_AND_PLAY)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1262115978:
                if (str.equals(LottieConstants.METHOD_GO_TO_AND_STOP)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -555157117:
                if (str.equals(LottieConstants.METHOD_DOWNGRADE_TO_PLACEHOLDER)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -178767326:
                if (str.equals(LottieConstants.METHOD_PLAY_FROM_MIN_TO_MAX_PROGRESS)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 3443508:
                if (str.equals("play")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 3540994:
                if (str.equals("stop")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 85887754:
                if (str.equals(LottieConstants.METHOD_GET_DURATION)) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 106440182:
                if (str.equals("pause")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 170047715:
                if (str.equals(LottieConstants.METHOD_GET_INFO)) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 550124952:
                if (str.equals(LottieConstants.METHOD_PLAY_FROM_MIN_TO_MAX_FRAME)) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 1404354821:
                if (str.equals(LottieConstants.METHOD_SET_SPEED)) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 1500808082:
                if (str.equals(LottieConstants.METHOD_FILL_VARIABLE_VALUE)) {
                    c = 11;
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
                this.b.goToAndPlay(ParseUtils.getFloat(jSONObject, "value", 0.0f));
                return;
            case 1:
                this.b.goToAndStop(ParseUtils.getFloat(jSONObject, "value", 0.0f));
                return;
            case 2:
                this.b.downgradeToPlaceholder();
                return;
            case 3:
                this.b.play(ParseUtils.getFloat(jSONObject, LottieConstants.PARAM_MIN_VALUE, 0.0f), ParseUtils.getFloat(jSONObject, LottieConstants.PARAM_MAX_VALUE, 1.0f));
                return;
            case 4:
                this.b.play();
                return;
            case 5:
                this.b.stop();
                return;
            case 6:
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("duration", (Object) Long.valueOf(this.b.getDuration()));
                bridgeCallback.sendJSONResponse(jSONObject2);
                return;
            case 7:
                this.b.pause();
                return;
            case '\b':
                bridgeCallback.sendJSONResponse(this.b.getLottieInfo());
                return;
            case '\t':
                this.b.play(ParseUtils.getInt(jSONObject, LottieConstants.PARAM_MIN_VALUE, 0), ParseUtils.getInt(jSONObject, LottieConstants.PARAM_MAX_VALUE, Integer.MAX_VALUE));
                return;
            case '\n':
                this.b.setSpeed(ParseUtils.getFloat(jSONObject, "value", 1.0f));
                return;
            case 11:
                this.b.fillVariableValue((Map) JSONObject.toJavaObject(jSONObject, Map.class));
                return;
            default:
                return;
        }
    }

    private void a(String str, JSONObject jSONObject) {
        Page page = this.mOuterPage;
        if (page == null || page.getRender() == null) {
            return;
        }
        Set<Map.Entry<String, Object>> set = this.f6397a;
        if (set != null) {
            for (Map.Entry<String, Object> entry : set) {
                if (entry != null) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("data", (Object) jSONObject);
        Render render = page.getRender();
        StringBuilder sb = new StringBuilder();
        sb.append("nbcomponent.lottieview.");
        sb.append(str);
        EngineUtils.sendPushWorkMessage(render, sb.toString(), jSONObject2, null);
        Render render2 = page.getRender();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("nbcomponent.lottieview.");
        sb2.append(str);
        EngineUtils.sendToRender(render2, sb2.toString(), jSONObject2, null);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("sendMsgToH5: ");
        sb3.append(str);
        sb3.append(":");
        sb3.append(jSONObject2.toJSONString());
        GriverLogger.d("H5BeeLottieView", sb3.toString());
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        GriverLogger.d("H5BeeLottieView", "onAnimationStart.");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(LottieParams.KEY_ELEMENT_ID, (Object) this.c.getElementId());
        jSONObject.put("type", "lottieview");
        a("animationStart", jSONObject);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        StringBuilder sb = new StringBuilder();
        sb.append("onAnimationEnd: ");
        sb.append(this.b.getProgress());
        GriverLogger.d("H5BeeLottieView", sb.toString());
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(LottieParams.KEY_ELEMENT_ID, (Object) this.c.getElementId());
        jSONObject.put("type", "lottieview");
        a("animationEnd", jSONObject);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("onAnimationStart,isReverse=");
        sb.append(z);
        GriverLogger.d("H5BeeLottieView", sb.toString());
        onAnimationStart(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("onAnimationEnd,isReverse=");
        sb.append(z);
        GriverLogger.d("H5BeeLottieView", sb.toString());
        onAnimationEnd(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        StringBuilder sb = new StringBuilder();
        sb.append("onAnimationCancel: ");
        sb.append(this.b.getProgress());
        GriverLogger.d("H5BeeLottieView", sb.toString());
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(LottieParams.KEY_ELEMENT_ID, (Object) this.c.getElementId());
        jSONObject.put("type", "lottieview");
        a("animationCancel", jSONObject);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        StringBuilder sb = new StringBuilder();
        sb.append("onAnimationRepeat: ");
        sb.append(this.b.getProgress());
        GriverLogger.d("H5BeeLottieView", sb.toString());
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(LottieParams.KEY_ELEMENT_ID, (Object) this.c.getElementId());
        jSONObject.put("type", "lottieview");
        a("animationRepeat", jSONObject);
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ILottieDataStatus
    public void onDataLoadReady() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(LottieParams.KEY_ELEMENT_ID, (Object) this.c.getElementId());
        jSONObject.put("type", "lottieview");
        jSONObject.put("result", "success");
        a("dataLoadReady", jSONObject);
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ILottieDataStatus
    public void onDataReady() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(LottieParams.KEY_ELEMENT_ID, (Object) this.c.getElementId());
        jSONObject.put("type", "lottieview");
        jSONObject.put("result", "success");
        a("dataReady", jSONObject);
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ILottieDataStatus
    public void onDataFailed(String str) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(LottieParams.KEY_ELEMENT_ID, (Object) this.c.getElementId());
        jSONObject.put("type", "lottieview");
        StringBuilder sb = new StringBuilder();
        sb.append("Error:");
        sb.append(str);
        jSONObject.put("result", (Object) sb.toString());
        a("dataFailed", jSONObject);
    }

    @Override // com.alibaba.griver.beehive.lottie.player.FramePlayController.FrameAnimationListener
    public void onAnimationFrameControlEnd() {
        StringBuilder sb = new StringBuilder();
        sb.append("onAnimationFrameControlEnd: ");
        sb.append(this.b.getProgress());
        GriverLogger.d("H5BeeLottieView", sb.toString());
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(LottieParams.KEY_ELEMENT_ID, (Object) this.c.getElementId());
        jSONObject.put("type", "lottieview");
        a("animationFrameControlEnd", jSONObject);
    }
}
