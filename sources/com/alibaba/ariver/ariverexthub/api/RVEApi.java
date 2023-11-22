package com.alibaba.ariver.ariverexthub.api;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.collection.SparseArrayCompat;
import com.alibaba.ariver.ariverexthub.api.RVEApiHandler;
import com.alibaba.ariver.ariverexthub.api.annotations.BindingRVECallback;
import com.alibaba.ariver.ariverexthub.api.annotations.BindingRVEContext;
import com.alibaba.ariver.ariverexthub.api.annotations.BindingRVEExtParams;
import com.alibaba.ariver.ariverexthub.api.annotations.BindingRVEHost;
import com.alibaba.ariver.ariverexthub.api.annotations.BindingRVEParams;
import com.alibaba.ariver.ariverexthub.api.annotations.RVEApiFilter;
import com.alibaba.ariver.ariverexthub.api.annotations.RVEThreadType;
import com.alibaba.ariver.ariverexthub.api.bind.Binder;
import com.alibaba.ariver.ariverexthub.api.bind.RVECallbackBinder;
import com.alibaba.ariver.ariverexthub.api.bind.RVEContextBinder;
import com.alibaba.ariver.ariverexthub.api.bind.RVEExtParamsBinder;
import com.alibaba.ariver.ariverexthub.api.bind.RVEHostBinder;
import com.alibaba.ariver.ariverexthub.api.bind.RVEParamsBinder;
import com.alibaba.ariver.ariverexthub.api.instance.RVEApiInfoManager;
import com.alibaba.ariver.ariverexthub.api.instance.RVEExtraHandlerCenter;
import com.alibaba.ariver.ariverexthub.api.instance.RVEHandlerCenter;
import com.alibaba.ariver.ariverexthub.api.instance.RVEProxyCenter;
import com.alibaba.ariver.ariverexthub.api.model.RVEActionMeta;
import com.alibaba.ariver.ariverexthub.api.model.RVEApiInfo;
import com.alibaba.ariver.ariverexthub.api.model.RVEApiRequestMetaData;
import com.alibaba.ariver.ariverexthub.api.model.RVEHandlerProcess;
import com.alibaba.ariver.ariverexthub.api.model.RVEHandlerScope;
import com.alibaba.ariver.ariverexthub.api.provider.RVEApiExtraFilter;
import com.alibaba.ariver.ariverexthub.api.provider.RVEApiResponseCallback;
import com.alibaba.ariver.ariverexthub.api.utils.ExtHubLogger;
import com.alibaba.fastjson.JSONObject;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public class RVEApi {
    private static final Set<Class> i;

    /* renamed from: a  reason: collision with root package name */
    private String f5992a;
    private String b;
    private JSONObject c;
    private RVEContext d;
    private Bundle e;
    private RVEApiResponseCallback f;
    private RVEApiHandler g;
    private RVEApiInfo h;
    private RVEApiResponseCallback j = new RVEApiResponseCallback() { // from class: com.alibaba.ariver.ariverexthub.api.RVEApi.1
        @Override // com.alibaba.ariver.ariverexthub.api.provider.RVEApiResponseCallback
        public void onResult(JSONObject jSONObject) {
            if (RVEApi.this.f != null) {
                RVEApi.this.f.onResult(jSONObject);
            }
            if (jSONObject == null || !jSONObject.containsKey("error")) {
                return;
            }
            try {
                RVEApiAnalysis.recordExthubApiCallError(RVEApi.this.b, RVEApi.this.d.getAppId(), RVEApi.this.f5992a, jSONObject.getIntValue("error"), jSONObject.getString("errorMessage"));
            } catch (Throwable th) {
                ExtHubLogger.e("RVEApi", "JSAPI 错误埋点异常", th);
            }
        }
    };

    static {
        HashSet hashSet = new HashSet();
        i = hashSet;
        hashSet.add(BindingRVEContext.class);
        hashSet.add(BindingRVEParams.class);
        hashSet.add(BindingRVECallback.class);
        hashSet.add(BindingRVEHost.class);
        hashSet.add(BindingRVEExtParams.class);
    }

    private RVEApi() {
    }

    public static RVEApi extApi(String str, String str2) {
        return new RVEApi(str, str2);
    }

    private RVEApi(String str, String str2) {
        this.h = RVEApiInfoManager.getApiInfo(str);
        this.f5992a = str;
        this.b = str2;
    }

    @Deprecated
    public static boolean canUse(String str, String str2) {
        boolean z = RVEProxyCenter.getInstance().isApiAvailable(str, str2) != null;
        StringBuilder sb = new StringBuilder();
        sb.append("RVEApi ask canUse，apiName = ");
        sb.append(str);
        sb.append("，canUse = ");
        sb.append(z);
        ExtHubLogger.d("RVEApi", sb.toString());
        return z;
    }

    public static RVEApiRequestMetaData isApiAvailable(String str, String str2) {
        RVEApiInfo isApiAvailable = RVEProxyCenter.getInstance().isApiAvailable(str, str2);
        if (isApiAvailable != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("RVEApi ask canUse，apiName = ");
            sb.append(str);
            sb.append("，canUse = true");
            ExtHubLogger.d("RVEApi", sb.toString());
            return RVEApiRequestMetaData.avaliableRequest(isApiAvailable.process == RVEHandlerProcess.Remote);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("RVEApi ask canUse，apiName = ");
        sb2.append(str);
        sb2.append("，canUse = false");
        ExtHubLogger.d("RVEApi", sb2.toString());
        return RVEApiRequestMetaData.unAvaliableRequest();
    }

    public void handleApi(RVEContext rVEContext, JSONObject jSONObject, RVEApiResponseCallback rVEApiResponseCallback) {
        RVEApiExtraFilter apiFilter;
        StringBuilder sb = new StringBuilder();
        sb.append("rve jsapi call，jsapiName = ");
        sb.append(this.f5992a);
        ExtHubLogger.d("RVEApi", sb.toString());
        this.f = rVEApiResponseCallback;
        this.d = rVEContext;
        this.c = jSONObject;
        RVEApiAnalysis.recordRVEApiCall(this.b, rVEContext.getAppId(), this.f5992a);
        if (RVEProxyCenter.getInstance().interceptAPI(this.f5992a)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("rve jsapi call 命中intercept，jsapiName = ");
            sb2.append(this.f5992a);
            ExtHubLogger.d("RVEApi", sb2.toString());
            RVEApiHandler.sendError(this.j, RVEApiHandler.Error.UNKNOWN_ERROR);
            RVEApiAnalysis.recordExthubApiCallError(this.b, rVEContext.getAppId(), this.f5992a, -1, "hit interceptAPI");
        } else if (this.h == null) {
            sendApiClassNotFound(this.j);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("没找到注册信息，api not found error msg，apiName = ");
            sb3.append(this.f5992a);
            ExtHubLogger.e("RVEApi", sb3.toString(), null);
            RVEApiAnalysis.recordExthubApiCallError(this.b, rVEContext.getAppId(), this.f5992a, -2, "api not found");
        } else {
            Bundle bundle = new Bundle();
            if (RVEExtraHandlerCenter.getInstance().needHandleFilter(this.f5992a) && (apiFilter = RVEExtraHandlerCenter.getInstance().getApiFilter(this.b, this.f5992a)) != null) {
                bundle = apiFilter.handleExtParams(rVEContext);
            }
            this.e = bundle;
            if (this.h.scope == RVEHandlerScope.Service) {
                this.g = RVEHandlerCenter.getInstance().getGlobalHandler(this.f5992a, this.h);
            } else if (this.h.scope == RVEHandlerScope.App) {
                this.g = RVEHandlerCenter.getInstance().getAppHandler(rVEContext.getAppId(), this.f5992a, this.h);
            } else if (this.h.scope == RVEHandlerScope.Singal) {
                this.g = RVEHandlerCenter.getInstance().getSingalHandler(this.f5992a, this.h);
            }
            RVEApiHandler rVEApiHandler = this.g;
            if (rVEApiHandler == null) {
                sendApiClassNotFound(this.j);
                StringBuilder sb4 = new StringBuilder();
                sb4.append("api not found error msg，apiName = ");
                sb4.append(this.f5992a);
                ExtHubLogger.e("RVEApi", sb4.toString(), null);
                RVEApiAnalysis.recordExthubApiCallError(this.b, rVEContext.getAppId(), this.f5992a, -3, "rveApiHandler create error");
                return;
            }
            Class cls = rVEApiHandler.getClass();
            for (final Method method : cls.getDeclaredMethods()) {
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
                RVEApiFilter rVEApiFilter = (RVEApiFilter) method.getAnnotation(RVEApiFilter.class);
                if (rVEApiFilter != null) {
                    String value = rVEApiFilter.value();
                    if (TextUtils.isEmpty(value)) {
                        value = method.getName();
                    }
                    if (value.equals(this.f5992a)) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("find annotations method，apiName = ");
                        sb5.append(this.f5992a);
                        ExtHubLogger.d("RVEApi", sb5.toString());
                        int length = method.getParameterTypes().length;
                        final Object[] objArr = new Object[length];
                        RVEActionMeta rVEActionMeta = new RVEActionMeta();
                        rVEActionMeta.actionMethod = method;
                        rVEActionMeta.actionName = value;
                        rVEActionMeta.handlerClazz = cls;
                        rVEActionMeta.paramAnnotationArray = method.getParameterAnnotations();
                        rVEActionMeta.paramTypes = method.getParameterTypes();
                        SparseArrayCompat<Annotation[]> a2 = a(method, rVEActionMeta);
                        for (int i2 = 0; i2 < length; i2++) {
                            try {
                                objArr[i2] = a(rVEActionMeta.paramTypes[i2], a2.BuiltInFictitiousFunctionClassFactory(i2));
                            } catch (Exception e) {
                                sendApiClassNotFound(this.j);
                                StringBuilder sb6 = new StringBuilder();
                                sb6.append("api not found error msg，apiName = ");
                                sb6.append(this.f5992a);
                                ExtHubLogger.e("RVEApi", sb6.toString(), e);
                                String substring = e.getMessage().length() > 1024 ? e.getMessage().substring(0, 1024) : e.getMessage();
                                String str = this.b;
                                String appId = rVEContext.getAppId();
                                String str2 = this.f5992a;
                                StringBuilder sb7 = new StringBuilder();
                                sb7.append("run jsapi error，e = ");
                                sb7.append(substring);
                                RVEApiAnalysis.recordExthubApiCallError(str, appId, str2, -4, sb7.toString());
                            }
                        }
                        RVEThreadType rVEThreadType = (RVEThreadType) method.getAnnotation(RVEThreadType.class);
                        if (rVEThreadType != null) {
                            RVEProxyCenter.getInstance().getRVEThreadService().getExecutor(rVEThreadType.value()).execute(new Runnable() { // from class: com.alibaba.ariver.ariverexthub.api.RVEApi.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        method.invoke(RVEApi.this.g, objArr);
                                    } catch (Exception e2) {
                                        RVEApiHandler.sendError(RVEApi.this.j, RVEApiHandler.Error.UNKNOWN_ERROR);
                                        ExtHubLogger.e("RVEApi", "switch to thread error", e2);
                                    }
                                }
                            });
                        } else {
                            method.invoke(this.g, objArr);
                        }
                    }
                }
            }
        }
    }

    public static void sendApiClassNotFound(RVEApiResponseCallback rVEApiResponseCallback) {
        RVEApiHandler.sendError(rVEApiResponseCallback, RVEApiHandler.Error.NOT_FOUND);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private SparseArrayCompat<Annotation[]> a(Method method, RVEActionMeta rVEActionMeta) {
        SparseArrayCompat<Annotation[]> sparseArrayCompat = new SparseArrayCompat<>();
        if (method == null) {
            return sparseArrayCompat;
        }
        Class[] clsArr = rVEActionMeta.paramTypes;
        Annotation[][] annotationArr = rVEActionMeta.paramAnnotationArray;
        if (clsArr != null && clsArr.length != 0) {
            for (int i2 = 0; i2 < clsArr.length; i2++) {
                Annotation[] annotationArr2 = annotationArr[i2];
                if (annotationArr2 != null) {
                    ArrayList arrayList = new ArrayList();
                    for (Annotation annotation : annotationArr2) {
                        if (annotation != null && annotation.annotationType() != null && i.contains(annotation.annotationType())) {
                            arrayList.add(annotation);
                        }
                    }
                    if (arrayList.size() > 0) {
                        sparseArrayCompat.PlaceComponentResult(i2, arrayList.toArray(new Annotation[arrayList.size()]));
                    }
                }
            }
        }
        return sparseArrayCompat;
    }

    private Object a(Class cls, Annotation[] annotationArr) {
        Binder rVEHostBinder;
        Annotation annotation = (annotationArr == null || annotationArr.length <= 0) ? null : annotationArr[0];
        if (annotation instanceof BindingRVEContext) {
            rVEHostBinder = new RVEContextBinder(this.d);
        } else if (annotation instanceof BindingRVEParams) {
            rVEHostBinder = new RVEParamsBinder(this.c);
        } else if (annotation instanceof BindingRVECallback) {
            rVEHostBinder = new RVECallbackBinder(this.j);
        } else if (annotation instanceof BindingRVEExtParams) {
            rVEHostBinder = new RVEExtParamsBinder(this.e);
        } else {
            rVEHostBinder = annotation instanceof BindingRVEHost ? new RVEHostBinder(this.b) : null;
        }
        Object bind = rVEHostBinder != null ? rVEHostBinder.bind(cls, annotation) : null;
        if (bind == null && cls.isPrimitive()) {
            return 0;
        }
        return bind;
    }
}
