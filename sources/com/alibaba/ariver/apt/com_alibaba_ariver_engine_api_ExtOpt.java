package com.alibaba.ariver.apt;

import android.content.Context;
import android.os.Bundle;
import com.alibaba.ariver.engine.api.bridge.BridgeResponseHelper;
import com.alibaba.ariver.engine.api.bridge.NativeCallNotFoundPoint;
import com.alibaba.ariver.engine.api.bridge.model.GoBackCallback;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.bridge.remote.ClientRemoteCallPoint;
import com.alibaba.ariver.engine.api.extensions.CreateWorkerPoint;
import com.alibaba.ariver.engine.api.extensions.ResourceResponseInfo;
import com.alibaba.ariver.engine.api.extensions.ResourceResponsePoint;
import com.alibaba.ariver.engine.api.extensions.UnlockWorkerPoint;
import com.alibaba.ariver.engine.api.extensions.WorkerCreateConfigPoint;
import com.alibaba.ariver.engine.api.extensions.WorkerStartParamInjectPoint;
import com.alibaba.ariver.engine.api.extensions.resources.model.ResourceLoadContext;
import com.alibaba.ariver.engine.api.point.JsErrorInterceptPoint;
import com.alibaba.ariver.engine.api.point.NativeCallDispatchPoint;
import com.alibaba.ariver.engine.api.point.NativeCallOnInvokePoint;
import com.alibaba.ariver.engine.api.point.NativeCallResultPoint;
import com.alibaba.ariver.engine.api.point.NativeCallSyncErrorBackPoint;
import com.alibaba.ariver.engine.api.point.PageBackInterceptPoint;
import com.alibaba.ariver.engine.api.point.WorkerExceptionPoint;
import com.alibaba.ariver.engine.api.point.network.HttpRequestResponseHandlePoint;
import com.alibaba.ariver.engine.api.point.network.WebResourceResponseHandlePoint;
import com.alibaba.ariver.engine.api.resources.ResourceLoadPoint;
import com.alibaba.ariver.engine.api.security.BridgeAccessPoint;
import com.alibaba.ariver.engine.api.security.EventSendInterceptorPoint;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.ExtensionOpt;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.api.remote.RemoteCallArgs;
import com.alibaba.ariver.kernel.api.security.Accessor;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.fastjson.JSONObject;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: classes6.dex */
public final class com_alibaba_ariver_engine_api_ExtOpt {
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {75, -23, 102, -23, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
    public static final int getAuthRequestContext = 12;

    public static void opt2() {
    }

    public static void opt1() {
        ExtensionOpt.setupMethodInvokeOptimizer(WorkerCreateConfigPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_engine_api_ExtOpt.1
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("isAsyncCreateWorker".equals(str) && objArr.length == 3) {
                    return Boolean.valueOf(((WorkerCreateConfigPoint) extension).isAsyncCreateWorker((Node) objArr[0], (String) objArr[1], (String) objArr[2]));
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(ResourceResponsePoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_engine_api_ExtOpt.2
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onResourceResponse".equals(str) && objArr.length == 1) {
                    ((ResourceResponsePoint) extension).onResourceResponse((ResourceResponseInfo) objArr[0]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(CreateWorkerPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_engine_api_ExtOpt.3
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("createWorker".equals(str) && objArr.length == 4) {
                    return ((CreateWorkerPoint) extension).createWorker((Context) objArr[0], (Node) objArr[1], (String) objArr[2], (String) objArr[3]);
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(WorkerStartParamInjectPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_engine_api_ExtOpt.4
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("injectStartParam".equals(str) && objArr.length == 1) {
                    ((WorkerStartParamInjectPoint) extension).injectStartParam((Bundle) objArr[0]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(UnlockWorkerPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_engine_api_ExtOpt.5
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("unlockWorker".equals(str) && objArr.length == 0) {
                    ((UnlockWorkerPoint) extension).unlockWorker();
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(BridgeAccessPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_engine_api_ExtOpt.6
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("needPermissionCheck".equals(str) && objArr.length == 2) {
                    return Boolean.valueOf(((BridgeAccessPoint) extension).needPermissionCheck((Accessor) objArr[0], (List) objArr[1]));
                }
                if ("bizCheckPermission".equals(str) && objArr.length == 4) {
                    return Boolean.valueOf(((BridgeAccessPoint) extension).bizCheckPermission((Permission) objArr[0], (Accessor) objArr[1], (NativeCallContext) objArr[2], (BridgeResponseHelper) objArr[3]));
                }
                if ("checkPermission".equals(str) && objArr.length == 4) {
                    return ((BridgeAccessPoint) extension).checkPermission((Permission) objArr[0], (Accessor) objArr[1], (NativeCallContext) objArr[2], (BridgeResponseHelper) objArr[3]);
                }
                if ("asyncCheckPermission".equals(str) && objArr.length == 4) {
                    return Boolean.valueOf(((BridgeAccessPoint) extension).asyncCheckPermission((Permission) objArr[0], (Accessor) objArr[1], (NativeCallContext) objArr[2], (BridgeResponseHelper) objArr[3]));
                }
                if ("manageAccessorGroup".equals(str) && objArr.length == 1) {
                    return ((BridgeAccessPoint) extension).manageAccessorGroup((Accessor) objArr[0]);
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(EventSendInterceptorPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_engine_api_ExtOpt.7
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("needIntercept".equals(str) && objArr.length == 2) {
                    return Boolean.valueOf(((EventSendInterceptorPoint) extension).needIntercept((String) objArr[0], (JSONObject) objArr[1]));
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(JsErrorInterceptPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_engine_api_ExtOpt.8
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onWorkerErrorIntercept".equals(str) && objArr.length == 2) {
                    ((JsErrorInterceptPoint) extension).onWorkerErrorIntercept((String) objArr[0], (String) objArr[1]);
                }
                if ("onJsEngineErrorIntercept".equals(str) && objArr.length == 2) {
                    ((JsErrorInterceptPoint) extension).onJsEngineErrorIntercept((String) objArr[0], (String) objArr[1]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(WebResourceResponseHandlePoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_engine_api_ExtOpt.9
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onHandleResponse".equals(str) && objArr.length == 6) {
                    ((WebResourceResponseHandlePoint) extension).onHandleResponse((String) objArr[0], ((Boolean) objArr[1]).booleanValue(), ((Boolean) objArr[2]).booleanValue(), (byte[]) objArr[3], (String) objArr[4], (JSONObject) objArr[5]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(HttpRequestResponseHandlePoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_engine_api_ExtOpt.10
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onHandleResponse".equals(str) && objArr.length == 3) {
                    ((HttpRequestResponseHandlePoint) extension).onHandleResponse((String) objArr[0], (String) objArr[1], (JSONObject) objArr[2]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(PageBackInterceptPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_engine_api_ExtOpt.11
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("interceptBackEvent".equals(str) && objArr.length == 1) {
                    return Boolean.valueOf(((PageBackInterceptPoint) extension).interceptBackEvent((GoBackCallback) objArr[0]));
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(NativeCallDispatchPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_engine_api_ExtOpt.12
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onCallDispatch".equals(str) && objArr.length == 1) {
                    ((NativeCallDispatchPoint) extension).onCallDispatch((NativeCallContext) objArr[0]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(NativeCallSyncErrorBackPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_engine_api_ExtOpt.13
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onSyncErrorBack".equals(str) && objArr.length == 2) {
                    ((NativeCallSyncErrorBackPoint) extension).onSyncErrorBack((NativeCallContext) objArr[0], (JSONObject) objArr[1]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(NativeCallOnInvokePoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_engine_api_ExtOpt.14
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onInvoke".equals(str) && objArr.length == 1) {
                    ((NativeCallOnInvokePoint) extension).onInvoke((NativeCallContext) objArr[0]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(NativeCallResultPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_engine_api_ExtOpt.15
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onSendBack".equals(str) && objArr.length == 2) {
                    ((NativeCallResultPoint) extension).onSendBack((NativeCallContext) objArr[0], (JSONObject) objArr[1]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(WorkerExceptionPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_engine_api_ExtOpt.16
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onCreateWorkerException".equals(str) && objArr.length == 1) {
                    ((WorkerExceptionPoint) extension).onCreateWorkerException((String) objArr[0]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(ClientRemoteCallPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_engine_api_ExtOpt.17
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("addClientRemoteCallArgs".equals(str) && objArr.length == 3) {
                    ((ClientRemoteCallPoint) extension).addClientRemoteCallArgs((Class) objArr[0], (Method) objArr[1], (RemoteCallArgs) objArr[2]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(NativeCallNotFoundPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_engine_api_ExtOpt.18
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("handleNotFound".equals(str) && objArr.length == 2) {
                    return Boolean.valueOf(((NativeCallNotFoundPoint) extension).handleNotFound((NativeCallContext) objArr[0], (BridgeResponseHelper) objArr[1]));
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(ResourceLoadPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_engine_api_ExtOpt.19
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("load".equals(str) && objArr.length == 1) {
                    return ((ResourceLoadPoint) extension).load((ResourceLoadContext) objArr[0]);
                }
                if ("loadGlobalResource".equals(str) && objArr.length == 1) {
                    return ((ResourceLoadPoint) extension).loadGlobalResource((String) objArr[0]);
                }
                return null;
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0070 A[Catch: all -> 0x00ab, TryCatch #7 {all -> 0x00ab, blocks: (B:12:0x004d, B:16:0x006a, B:18:0x0070, B:19:0x009a), top: B:104:0x004d }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009a A[Catch: all -> 0x00ab, TRY_LEAVE, TryCatch #7 {all -> 0x00ab, blocks: (B:12:0x004d, B:16:0x006a, B:18:0x0070, B:19:0x009a), top: B:104:0x004d }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x009c -> B:21:0x00a1). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void opt3() {
        /*
            Method dump skipped, instructions count: 854
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.apt.com_alibaba_ariver_engine_api_ExtOpt.opt3():void");
    }
}
