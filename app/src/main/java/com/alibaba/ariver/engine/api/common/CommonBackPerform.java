package com.alibaba.ariver.engine.api.common;

import android.text.TextUtils;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.bridge.model.GoBackCallback;
import com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback;
import com.alibaba.ariver.engine.api.extensions.back.BackInterceptPoint;
import com.alibaba.ariver.engine.api.point.PageBackInterceptPoint;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes3.dex */
public abstract class CommonBackPerform {
    public static int BACK = 1;
    public static int FINISHED = 4;
    public static int NONE;
    public static int POP;
    protected int backBehavior;
    private Render d;
    private PageBackInterceptPoint e;

    /* renamed from: a  reason: collision with root package name */
    private String f6026a = "AriverEngine:BackPerform";
    private Boolean f = null;
    private int c = NONE;
    private BackHandler b = new BackHandler();

    protected abstract void performBack(GoBackCallback goBackCallback);

    public CommonBackPerform(Render render) {
        this.d = render;
        this.e = (PageBackInterceptPoint) ExtensionPoint.as(PageBackInterceptPoint.class).node(this.d.getPage()).create();
    }

    public boolean enableInterceptBack(Render render) {
        return a(this.d.getAppId(), JSONUtils.getJSONArray(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONObject("h5_eventThroughWorker"), "back", null));
    }

    private boolean a(String str, JSONArray jSONArray) {
        if (jSONArray == null) {
            return false;
        }
        String str2 = this.f6026a;
        StringBuilder sb = new StringBuilder();
        sb.append("isAppIdInWhiteList, appId = ");
        sb.append(str);
        sb.append(", appIdWhiteList = ");
        sb.append(jSONArray);
        RVLogger.d(str2, sb.toString());
        for (int i = 0; i < jSONArray.size(); i++) {
            String string = jSONArray.getString(i);
            if (TextUtils.equals(string, ".*") || TextUtils.equals(string, str)) {
                return true;
            }
        }
        return false;
    }

    public void setBackBehavior(String str) {
        String str2 = this.f6026a;
        StringBuilder sb = new StringBuilder();
        sb.append("setBackBehavior ");
        sb.append(str);
        RVLogger.d(str2, sb.toString());
        if (RVStartParams.BACK_BEHAVIOR_POP.equals(str)) {
            this.backBehavior = POP;
        } else {
            this.backBehavior = BACK;
        }
    }

    public void updatePageStatus(int i) {
        this.c = i;
    }

    public void goBack(GoBackCallback goBackCallback) {
        long currentTimeMillis = System.currentTimeMillis();
        BackInterceptPoint backInterceptPoint = (BackInterceptPoint) ExtensionPoint.as(BackInterceptPoint.class).node(this.d.getPage()).create();
        if (backInterceptPoint != null && backInterceptPoint.intercepted(this.d, this.c, this.b, goBackCallback)) {
            String str = this.f6026a;
            StringBuilder sb = new StringBuilder();
            sb.append("goBack has been intercepted by ");
            sb.append(backInterceptPoint.getClass().getName());
            RVLogger.d(str, sb.toString());
            return;
        }
        if (!(((this.c == FINISHED && !this.b.waiting) && (((currentTimeMillis - this.b.lastBack) > 500L ? 1 : ((currentTimeMillis - this.b.lastBack) == 500L ? 0 : -1)) > 0)) ? false : true)) {
            RVLogger.d(this.f6026a, "send back event to bridge!");
            this.b.waiting = true;
            this.b.lastBack = currentTimeMillis;
            this.b.setGoBackCallback(goBackCallback);
            a(goBackCallback);
            return;
        }
        RVLogger.d(this.f6026a, "ignore bridge, perform goBack!");
        performBack(goBackCallback);
    }

    private void a(final GoBackCallback goBackCallback) {
        if (this.e.interceptBackEvent(new GoBackCallback() { // from class: com.alibaba.ariver.engine.api.common.CommonBackPerform.1
            @Override // com.alibaba.ariver.engine.api.bridge.model.GoBackCallback
            public void afterProcess(boolean z) {
                if (z) {
                    RVLogger.d(CommonBackPerform.this.f6026a, "sendBackEvent prevented!");
                } else {
                    CommonBackPerform.this.performBack(goBackCallback);
                }
            }
        })) {
            this.b.waiting = false;
        } else {
            EngineUtils.sendToRender(this.d, "back", null, new SendToRenderCallback() { // from class: com.alibaba.ariver.engine.api.common.CommonBackPerform.2
                @Override // com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback
                public void onCallBack(JSONObject jSONObject) {
                    if (CommonBackPerform.this.b != null) {
                        CommonBackPerform.this.b.onCallBack(jSONObject);
                    }
                }
            });
        }
    }

    /* loaded from: classes3.dex */
    public class BackHandler implements SendToRenderCallback {
        public GoBackCallback callback;
        public boolean waiting = false;
        public long lastBack = 0;

        public BackHandler() {
        }

        public void setGoBackCallback(GoBackCallback goBackCallback) {
            this.callback = goBackCallback;
        }

        @Override // com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback
        public void onCallBack(JSONObject jSONObject) {
            this.waiting = false;
            if (CommonBackPerform.this.f == null) {
                CommonBackPerform commonBackPerform = CommonBackPerform.this;
                commonBackPerform.f = Boolean.valueOf(commonBackPerform.enableInterceptBack(commonBackPerform.d));
            }
            boolean z = JSONUtils.getBoolean(jSONObject, "prevent", false) || JSONUtils.getBoolean(jSONObject, RVConstants.EXTRA_PREVENTED, false);
            String str = CommonBackPerform.this.f6026a;
            StringBuilder sb = new StringBuilder();
            sb.append("goBack event prevent ");
            sb.append(z);
            sb.append(" with cfgOpen: ");
            sb.append(CommonBackPerform.this.f);
            RVLogger.d(str, sb.toString());
            if (z && CommonBackPerform.this.f.booleanValue()) {
                return;
            }
            ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.engine.api.common.CommonBackPerform.BackHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    CommonBackPerform.this.performBack(BackHandler.this.callback);
                }
            });
        }
    }

    public int getBackBehavior() {
        return this.backBehavior;
    }
}
