package com.alibaba.ariver.engine.api.common;

import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.bridge.model.ExitCallback;
import com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes3.dex */
public abstract class CommonExitPerform {

    /* renamed from: a */
    private String f6027a = "AriverEngine:CommonExitPerform";
    private CollectJsApiHandler b;
    private Render c;

    protected abstract void checkDslErrorAndExit(ExitCallback exitCallback);

    protected abstract void handleCollectedApi(String str, JSONObject jSONObject);

    protected abstract boolean needCheckDslError();

    protected abstract boolean needCollectDestroyJsApi();

    public CommonExitPerform(Render render) {
        this.c = render;
    }

    public void runExit(ExitCallback exitCallback) {
        if (needCollectDestroyJsApi()) {
            a(exitCallback);
        } else if (needCheckDslError()) {
            checkDslErrorAndExit(exitCallback);
        } else {
            exitCallback.afterProcess(false);
        }
    }

    private void a(final ExitCallback exitCallback) {
        if (this.b == null && this.c != null) {
            CollectJsApiHandler collectJsApiHandler = new CollectJsApiHandler();
            this.b = collectJsApiHandler;
            collectJsApiHandler.waiting = true;
            this.b.exitCallback = exitCallback;
            EngineUtils.sendToRender(this.c, RVEvents.COLLECT_DESTROY_API, null, this.b);
            ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.engine.api.common.CommonExitPerform.1
                {
                    CommonExitPerform.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (CommonExitPerform.this.b == null || !CommonExitPerform.this.b.waiting) {
                        return;
                    }
                    RVLogger.d(CommonExitPerform.this.f6027a, "collectJsApiHandler overtime, do exit");
                    exitCallback.afterProcess(false);
                }
            }, 1000L);
        }
    }

    /* loaded from: classes3.dex */
    public class CollectJsApiHandler implements SendToRenderCallback {
        public ExitCallback exitCallback;
        public boolean waiting = false;

        public CollectJsApiHandler() {
            CommonExitPerform.this = r1;
        }

        @Override // com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback
        public void onCallBack(JSONObject jSONObject) {
            this.waiting = false;
            String str = CommonExitPerform.this.f6027a;
            StringBuilder sb = new StringBuilder();
            sb.append("collectJsApi param : ");
            sb.append(jSONObject);
            RVLogger.d(str, sb.toString());
            JSONArray jSONArray = JSONUtils.getJSONArray(jSONObject, "syncJsApis", null);
            if (jSONArray != null && !jSONArray.isEmpty()) {
                for (int i = 0; i < jSONArray.size(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        CommonExitPerform.this.handleCollectedApi(JSONUtils.getString(jSONObject2, "apiName"), JSONUtils.getJSONObject(jSONObject2, "params", null));
                    }
                }
            }
            if (CommonExitPerform.this.needCheckDslError()) {
                CommonExitPerform.this.checkDslErrorAndExit(this.exitCallback);
            } else {
                this.exitCallback.afterProcess(false);
            }
        }
    }
}
