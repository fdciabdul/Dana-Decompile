package com.iap.ac.android.rpc;

import android.text.TextUtils;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.mobile.common.rpc.RpcException;
import com.alipay.mobile.framework.service.ext.SimpleRpcService;
import com.google.common.base.Ascii;
import com.iap.ac.android.common.json.JsonUtils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.rpc.RPCProxyHost;
import com.iap.ac.android.common.rpc.RpcRequest;
import com.iap.ac.android.common.rpc.interfaces.FacadeInvoker;
import com.iap.ac.android.common.rpc.interfaces.RpcInterceptor;
import com.iap.ac.android.common.rpc.model.RpcExceptionInterceptResult;
import com.iap.ac.android.rpc.utils.RpcUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class RpcInvocationHandler implements InvocationHandler {
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {94, Ascii.EM, -44, 73, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 140;
    public static final String TAG = "Rpc";
    public String bizCode;
    public RPCProxyHost.RpcInvocationHandlerListener handlerListener;

    public RpcInvocationHandler(String str) {
        this.bizCode = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 3
            int r8 = 16 - r8
            int r7 = r7 * 7
            int r7 = r7 + 99
            int r6 = r6 * 12
            int r6 = r6 + 4
            byte[] r0 = com.iap.ac.android.rpc.RpcInvocationHandler.BuiltInFictitiousFunctionClassFactory
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r7
            r4 = 0
            r7 = r6
            goto L2e
        L19:
            r3 = 0
        L1a:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r8) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            r3 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r5
        L2e:
            int r3 = -r3
            int r6 = r6 + r3
            int r6 = r6 + 2
            int r7 = r7 + 1
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.rpc.RpcInvocationHandler.a(byte, short, byte, java.lang.Object[]):void");
    }

    private Object invokeRpc(Method method, Object[] objArr) throws RpcException {
        Object obj;
        RpcExceptionInterceptResult rpcExceptionInterceptResult;
        String name = method.getName();
        if (RpcUtils.isMainThread()) {
            StringBuilder sb = new StringBuilder();
            sb.append("can't call Rpc in main thread. methodName = ");
            sb.append(name);
            throw new IllegalThreadStateException(sb.toString());
        } else if (objArr != null) {
            if (objArr.length != 0) {
                String rpcOperationType = RpcProxyImpl.getRpcOperationType(method);
                if (TextUtils.equals(SimpleRpcService.OPERATION_TYPE, rpcOperationType)) {
                    rpcOperationType = (String) objArr[0];
                    obj = objArr[1];
                } else {
                    obj = objArr[0];
                }
                if (!TextUtils.isEmpty(rpcOperationType)) {
                    RpcRequest rpcRequest = new RpcRequest(rpcOperationType, obj);
                    RPCProxyHost.RpcInvocationHandlerListener rpcInvocationHandlerListener = this.handlerListener;
                    if (rpcInvocationHandlerListener != null) {
                        rpcInvocationHandlerListener.onBeforeSend(rpcRequest);
                    }
                    Iterator<RpcInterceptor> it = RpcProxyImpl.getInstance(this.bizCode).getRpcInterceptors().iterator();
                    while (it.hasNext()) {
                        it.next().onBeforeSend(rpcRequest);
                    }
                    FacadeInvoker rpcFacadeInvoker = RpcProxyImpl.getInstance(this.bizCode).getRpcFacadeInvoker(rpcOperationType);
                    ACLog.i(TAG, String.format("\nWill invoke RPC:\n\toperationType = %s\n\trequest = %s\n", rpcOperationType, JsonUtils.toJson(obj)));
                    Class<?> returnType = method.getReturnType();
                    Object obj2 = null;
                    try {
                        obj2 = rpcFacadeInvoker.invokeMethod(method, rpcRequest);
                    } catch (RpcException e) {
                        Iterator<RpcInterceptor> it2 = RpcProxyImpl.getInstance(this.bizCode).getRpcInterceptors().iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                rpcExceptionInterceptResult = null;
                                break;
                            }
                            rpcExceptionInterceptResult = it2.next().onExceptionOccurred(rpcRequest, e, rpcFacadeInvoker, method);
                            if (rpcExceptionInterceptResult != null && rpcExceptionInterceptResult.isHandled) {
                                break;
                            }
                        }
                        if (rpcExceptionInterceptResult != null) {
                            if (returnType.isInstance(rpcExceptionInterceptResult.response)) {
                                obj2 = rpcExceptionInterceptResult.response;
                            }
                        } else {
                            throw e;
                        }
                    }
                    Iterator<RpcInterceptor> it3 = RpcProxyImpl.getInstance(this.bizCode).getRpcInterceptors().iterator();
                    while (it3.hasNext()) {
                        Object onAfterReceive = it3.next().onAfterReceive(rpcRequest, obj2, rpcFacadeInvoker, method);
                        if (returnType.isInstance(onAfterReceive)) {
                            obj2 = onAfterReceive;
                        }
                    }
                    ACLog.i(TAG, String.format("\nRpc response:\n\toperationType = %s\n\tresponse = %s\n", rpcOperationType, JsonUtils.toJson(obj2)));
                    return obj2;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Cannot find operationType for: ");
                sb2.append(name);
                throw new RpcException((Integer) 3000, sb2.toString());
            }
            throw new RpcException((Integer) 9, "Rpc request args.length == 0!");
        } else {
            throw new RpcException((Integer) 9, "Rpc request args is null!");
        }
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws RpcException {
        synchronized (this) {
            String name = method.getName();
            try {
                byte b = (byte) (-BuiltInFictitiousFunctionClassFactory[15]);
                byte b2 = b;
                Object[] objArr2 = new Object[1];
                a(b, b2, (byte) (b2 - 1), objArr2);
                Class<?> cls = Class.forName((String) objArr2[0]);
                byte b3 = (byte) (BuiltInFictitiousFunctionClassFactory[15] + 1);
                Object[] objArr3 = new Object[1];
                a(b3, b3, (byte) (-BuiltInFictitiousFunctionClassFactory[15]), objArr3);
                long id2 = ((Thread) cls.getMethod((String) objArr3[0], null).invoke(null, null)).getId();
                StringBuilder sb = new StringBuilder();
                sb.append("ThreadId=[");
                sb.append(id2);
                sb.append("] invoke.object=[");
                sb.append(method.getDeclaringClass().getName());
                sb.append("]  methodName=[");
                sb.append(name);
                sb.append("]");
                ACLog.d(TAG, sb.toString());
                if ("toString".equals(name)) {
                    return "Rpc-proxy-facade";
                }
                return invokeRpc(method, objArr);
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }
    }

    public RpcInvocationHandler(String str, RPCProxyHost.RpcInvocationHandlerListener rpcInvocationHandlerListener) {
        this.bizCode = str;
        this.handlerListener = rpcInvocationHandlerListener;
    }
}
