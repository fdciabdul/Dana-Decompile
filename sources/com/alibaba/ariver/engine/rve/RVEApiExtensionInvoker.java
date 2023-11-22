package com.alibaba.ariver.engine.rve;

import android.app.Activity;
import android.content.Context;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.ariverexthub.api.RVEApi;
import com.alibaba.ariver.ariverexthub.api.RVEContext;
import com.alibaba.ariver.ariverexthub.api.constant.RVEConstant;
import com.alibaba.ariver.ariverexthub.api.provider.RVEApiResponseCallback;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.engine.rve.RVEContextProviderImpl;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.invoke.ExtensionInvoker;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.immutable.ImmutableList;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class RVEApiExtensionInvoker extends ExtensionInvoker {

    /* renamed from: a */
    private SendToNativeCallback f6049a;
    private NativeCallContext b;

    public RVEApiExtensionInvoker(SendToNativeCallback sendToNativeCallback, NativeCallContext nativeCallContext) {
        super(null);
        this.f6049a = sendToNativeCallback;
        this.b = nativeCallContext;
    }

    @Override // com.alibaba.ariver.kernel.api.invoke.ExtensionInvoker
    public ExtensionInvoker.InvokeResult onInvoke(ImmutableList<Extension> immutableList, Object obj, Method method, Object[] objArr) throws Throwable {
        Context context;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("executeNative RVEApi consume ");
            sb.append(this.b.getName());
            RVLogger.d("AriverKernel:RVEApiExtensionInvoker:RVEApi", sb.toString());
            RVEApi extApi = RVEApi.extApi(this.b.getName(), RVEConstant.RVEHost.ARIVER_HOST);
            Node node = this.b.getNode();
            String pageURI = node instanceof Page ? ((Page) node).getPageURI() : "";
            App app = (App) node.bubbleFindNode(App.class);
            String appId = app.getAppId();
            Activity activity = (app.getAppContext() == null || (context = app.getAppContext().getContext()) == null || !(context instanceof Activity)) ? null : (Activity) context;
            if (activity == null && this.b.getRender() != null) {
                activity = this.b.getRender().getActivity();
            }
            final RVEContext rVEContext = new RVEContext(new RVEContextProviderImpl.Builder().activity(activity).appId(appId).pageUrl(pageURI).build());
            RVEContextPool.getInstance().setCallback(rVEContext, this.b);
            extApi.handleApi(rVEContext, this.b.getParams(), new RVEApiResponseCallback() { // from class: com.alibaba.ariver.engine.rve.RVEApiExtensionInvoker.1
                {
                    RVEApiExtensionInvoker.this = this;
                }

                @Override // com.alibaba.ariver.ariverexthub.api.provider.RVEApiResponseCallback
                public void onResult(JSONObject jSONObject) {
                    RVEApiExtensionInvoker.this.f6049a.onCallback(jSONObject, false);
                    RVEContextPool.getInstance().removeCallbackContext(rVEContext);
                }
            });
            return ExtensionInvoker.InvokeResult.decide(null);
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("RVEApi dispatch found exception !");
            sb2.append(this.b.getName());
            RVLogger.w("AriverKernel:RVEApiExtensionInvoker:RVEApi", sb2.toString(), e);
            return ExtensionInvoker.InvokeResult.proceed();
        }
    }
}
