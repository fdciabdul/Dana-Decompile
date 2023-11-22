package com.alibaba.ariver.engine.common.extension;

import android.os.SystemClock;
import androidx.collection.SparseArrayCompat;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.BridgeResponseHelper;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindExtHubContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingExecutor;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingId;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.proxy.RVBridgeCallContextHandleProxy;
import com.alibaba.ariver.engine.common.bridge.internal.DefaultBridgeCallback;
import com.alibaba.ariver.engine.common.extension.bind.ApiContextBinder;
import com.alibaba.ariver.engine.common.extension.bind.Binder;
import com.alibaba.ariver.engine.common.extension.bind.CallbackBinder;
import com.alibaba.ariver.engine.common.extension.bind.ExecutorBinder;
import com.alibaba.ariver.engine.common.extension.bind.ExtHubApiContextBinder;
import com.alibaba.ariver.engine.common.extension.bind.ExtHubContextBinder;
import com.alibaba.ariver.engine.common.extension.bind.ExtHubNodeBinder;
import com.alibaba.ariver.engine.common.extension.bind.IdBinder;
import com.alibaba.ariver.engine.common.extension.bind.NodeBinder;
import com.alibaba.ariver.engine.common.extension.bind.ParamBinder;
import com.alibaba.ariver.engine.common.extension.bind.RequestBinder;
import com.alibaba.ariver.engine.common.extension.bind.RequiredParamNotFoundException;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.ExtensionOpt;
import com.alibaba.ariver.kernel.api.extension.bridge.ActionMeta;
import com.alibaba.ariver.kernel.api.invoke.ExtensionInvoker;
import com.alibaba.ariver.kernel.api.invoke.InvokeException;
import com.alibaba.ariver.kernel.api.invoke.NodeAwareUtils;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.immutable.ImmutableList;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.exthub.base.ExtHubApiContext;
import com.alibaba.exthub.base.ExtHubContext;
import com.alibaba.exthub.common.ExtHubLogger;
import com.alibaba.fastjson.JSONObject;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public class BindBridgeExtensionInvoker extends ExtensionInvoker {
    public static final String TAG = "AriverEngine:BridgeExtensionInvoker";

    /* renamed from: a */
    private static final Set<Class> f6035a;
    private final BridgeResponseHelper b;
    private JSONObject c;
    private ApiContext d;
    private NativeCallContext e;
    private ExtHubContext f;
    private ActionMeta g;
    private String h;

    static {
        HashSet hashSet = new HashSet();
        f6035a = hashSet;
        hashSet.add(BindingApiContext.class);
        hashSet.add(BindingCallback.class);
        hashSet.add(BindingExecutor.class);
        hashSet.add(BindingId.class);
        hashSet.add(BindingNode.class);
        hashSet.add(BindingParam.class);
        hashSet.add(BindingRequest.class);
        hashSet.add(BindExtHubContext.class);
    }

    public BindBridgeExtensionInvoker(Node node, NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper, ActionMeta actionMeta) {
        this(node, nativeCallContext, bridgeResponseHelper, actionMeta, null, null);
    }

    public BindBridgeExtensionInvoker(Node node, ExtHubContext extHubContext, BridgeResponseHelper bridgeResponseHelper, ActionMeta actionMeta) {
        super(node, null, null);
        this.f = extHubContext;
        this.nativeCall = true;
        this.c = extHubContext.getParams();
        this.b = bridgeResponseHelper;
        this.g = actionMeta;
    }

    public BindBridgeExtensionInvoker(Node node, NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper, ActionMeta actionMeta, ApiContext apiContext, Class<? extends Extension> cls) {
        super(node, null, cls);
        this.b = bridgeResponseHelper;
        this.c = nativeCallContext.getParams();
        this.e = nativeCallContext;
        this.g = actionMeta;
        this.h = nativeCallContext.getId();
        if (apiContext == null) {
            this.d = (ApiContext) ((RVBridgeCallContextHandleProxy) RVProxy.get(RVBridgeCallContextHandleProxy.class)).handleEvent("getDefaultApiContext", node, nativeCallContext);
        } else {
            this.d = apiContext;
        }
    }

    @Override // com.alibaba.ariver.kernel.api.invoke.ExtensionInvoker
    public ExtensionOpt.MethodInvokeOptimizer getMethodInvokeOptimizer(Class<? extends Extension> cls) {
        return ExtensionOpt.getMethodInvokeOptimizer(cls, true);
    }

    @Override // com.alibaba.ariver.kernel.api.invoke.ExtensionInvoker
    public ExtensionInvoker.InvokeResult onInvoke(ImmutableList<Extension> immutableList, Object obj, Method method, Object[] objArr) throws Throwable {
        Object proceed;
        JSONObject jSONObject;
        if (this.g.paramRequired && ((jSONObject = this.c) == null || jSONObject.isEmpty())) {
            new DefaultBridgeCallback(this.b, false).sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return ExtensionInvoker.InvokeResult.decide(null);
        }
        int length = method.getParameterTypes().length;
        Object[] objArr2 = new Object[length];
        SparseArrayCompat<Annotation[]> a2 = a(method, this.g);
        for (int i = 0; i < length; i++) {
            try {
                objArr2[i] = a(this.g.paramTypes[i], a2.BuiltInFictitiousFunctionClassFactory(i));
            } catch (Exception e) {
                ExtHubLogger.e(TAG, "buildActionMethodParam", e);
                if ("yes".equalsIgnoreCase(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("h5_enableJsApiInvalidParam", "yes"))) {
                    new DefaultBridgeCallback(this.b, false).sendBridgeResponse(new BridgeResponse.Error(2, "INVALID_PARAM"));
                    return ExtensionInvoker.InvokeResult.decide(null);
                } else if (e instanceof RequiredParamNotFoundException) {
                    new DefaultBridgeCallback(this.b, false).sendBridgeResponse(new BridgeResponse.Error(2, e.getMessage()));
                    return ExtensionInvoker.InvokeResult.decide(null);
                }
            }
        }
        try {
            NodeAwareUtils.handleSetNode(this.targetNode, immutableList.get(0));
            if (this.nativeCall) {
                proceed = proceed(immutableList, obj, method, objArr2);
                ExtHubLogger.d(TAG, "native call");
            } else {
                this.b.setTargetExtension(immutableList.get(0));
                this.e.setExecuteTimeStamp(SystemClock.elapsedRealtime());
                if (this.e.bridgeInterceptPreInvoke(this.targetNode, this.d, this.b)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("preInvoke handled!\nExtension: ");
                    sb.append(immutableList.get(0));
                    sb.append("\nMethod: ");
                    sb.append(method);
                    ExtHubLogger.d(TAG, sb.toString());
                    return ExtensionInvoker.InvokeResult.decide(null);
                }
                proceed = proceed(immutableList, obj, method, objArr2);
                if (this.e.bridgeInterceptPostInvoke(this.targetNode, this.d, this.b)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("postInvoke handled!\nExtension: ");
                    sb2.append(immutableList.get(0));
                    sb2.append("\nMethod: ");
                    sb2.append(method);
                    ExtHubLogger.d(TAG, sb2.toString());
                    return ExtensionInvoker.InvokeResult.decide(proceed);
                }
            }
            if (this.g.autoCallback) {
                if (proceed == null) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("AutoCallback but got null!!! ");
                    sb3.append(immutableList.get(0));
                    sb3.append(" method: ");
                    sb3.append(method);
                    ExtHubLogger.w(sb3.toString());
                    new DefaultBridgeCallback(this.b, false).sendBridgeResponse(BridgeResponse.SUCCESS);
                    return ExtensionInvoker.InvokeResult.decide(null);
                } else if (proceed instanceof BridgeResponse) {
                    new DefaultBridgeCallback(this.b, false).sendBridgeResponse((BridgeResponse) proceed);
                } else if (proceed instanceof JSONObject) {
                    new DefaultBridgeCallback(this.b, false).sendJSONResponse((JSONObject) proceed);
                } else {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("method ");
                    sb4.append(method.getName());
                    sb4.append(" return type not recognized ");
                    sb4.append(proceed.getClass().getName());
                    new DefaultBridgeCallback(this.b, false).sendBridgeResponse(new BridgeResponse.Error(2, sb4.toString()));
                }
            }
            return ExtensionInvoker.InvokeResult.decide(proceed);
        } catch (InvokeException e2) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Java exception happened!\nExtension: ");
            sb5.append(immutableList.get(0));
            sb5.append("\nMethod: ");
            sb5.append(method);
            ExtHubLogger.e(TAG, sb5.toString(), e2);
            StringBuilder sb6 = new StringBuilder();
            sb6.append("Java exception happen in method: ");
            sb6.append(method);
            sb6.append(" message: ");
            sb6.append(e2.getMessage());
            new DefaultBridgeCallback(this.b, false).sendBridgeResponse(new BridgeResponse.Error(6, sb6.toString()));
            return ExtensionInvoker.InvokeResult.decide(null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private SparseArrayCompat<Annotation[]> a(Method method, ActionMeta actionMeta) {
        SparseArrayCompat<Annotation[]> sparseArrayCompat = new SparseArrayCompat<>();
        if (method == null) {
            return sparseArrayCompat;
        }
        Class[] clsArr = actionMeta.paramTypes;
        Annotation[][] annotationArr = actionMeta.paramAnnotationArray;
        if (clsArr != null && clsArr.length != 0) {
            for (int i = 0; i < clsArr.length; i++) {
                Annotation[] annotationArr2 = annotationArr[i];
                if (annotationArr2 != null) {
                    ArrayList arrayList = new ArrayList();
                    for (Annotation annotation : annotationArr2) {
                        if (annotation != null && annotation.annotationType() != null && f6035a.contains(annotation.annotationType())) {
                            arrayList.add(annotation);
                        }
                    }
                    if (arrayList.size() > 0) {
                        sparseArrayCompat.PlaceComponentResult(i, arrayList.toArray(new Annotation[arrayList.size()]));
                    }
                }
            }
        }
        return sparseArrayCompat;
    }

    private Object a(Class cls, Annotation[] annotationArr) {
        Binder extHubContextBinder;
        Annotation annotation = (annotationArr == null || annotationArr.length <= 0) ? null : annotationArr[0];
        if (annotation instanceof BindingParam) {
            extHubContextBinder = new ParamBinder(this.c);
        } else if (annotation instanceof BindingRequest) {
            extHubContextBinder = new RequestBinder(this.c);
        } else if (annotation instanceof BindingCallback) {
            extHubContextBinder = new CallbackBinder(this.b);
        } else if (annotation instanceof BindingExecutor) {
            extHubContextBinder = new ExecutorBinder();
        } else if (annotation instanceof BindingNode) {
            if (this.nativeCall) {
                if (this.targetNode instanceof Page) {
                    extHubContextBinder = new ExtHubNodeBinder(this.f.getAppId(), (Page) this.targetNode);
                } else {
                    extHubContextBinder = new ExtHubNodeBinder(this.f.getAppId(), null);
                }
            } else {
                extHubContextBinder = new NodeBinder(this.targetNode);
            }
        } else if (annotation instanceof BindingApiContext) {
            if (this.nativeCall) {
                extHubContextBinder = new ExtHubApiContextBinder(new ExtHubApiContext(this.f.getAppId(), this.f.getActivity(), this.f.getBizType()));
            } else {
                extHubContextBinder = new ApiContextBinder(this.d);
            }
        } else if (annotation instanceof BindingId) {
            extHubContextBinder = new IdBinder(this.h);
        } else {
            extHubContextBinder = annotation instanceof BindExtHubContext ? new ExtHubContextBinder(this.f) : null;
        }
        Object bind = extHubContextBinder != null ? extHubContextBinder.bind(cls, annotation) : null;
        if (bind == null && cls.isPrimitive()) {
            return 0;
        }
        return bind;
    }
}
