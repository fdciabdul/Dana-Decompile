package com.zoloz.rpc.pb;

import android.text.TextUtils;
import com.alipay.imobile.network.quake.transport.http.constant.HeaderConstant;
import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.security.bio.service.local.rpc.IRpcException;
import com.zoloz.rpc.NormalRequest;
import com.zoloz.rpc.RpcConfig;
import com.zoloz.rpc.ZolozRpcException;
import com.zoloz.rpccommon.InterceptorManager;
import com.zoloz.rpccommon.NetRequest;
import com.zoloz.rpccommon.NetResponse;
import com.zoloz.wire.Message;
import com.zoloz.wire.Wire;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes8.dex */
public class PbInvocationHandler implements InvocationHandler {
    private static String TAG = "PbInvocationHandler";
    private static AtomicInteger rpcSequence;

    public PbInvocationHandler() {
        rpcSequence = new AtomicInteger();
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        if (RpcConfig.needDebugRpc) {
            return performRequest(obj, method, objArr);
        }
        return performRequest(obj, method, objArr);
    }

    private Object performRequest(Object obj, Method method, Object[] objArr) {
        NetResponse doRequest;
        OperationType operationType = (OperationType) method.getAnnotation(OperationType.class);
        String remoteUrl = RpcConfig.getInstance().getRemoteUrl();
        if (operationType == null) {
            throw new ZolozRpcException(Integer.valueOf((int) IRpcException.ErrorCode.PRC_OPERATIONTYPE_EMPTY), "operation type is null");
        }
        if (TextUtils.isEmpty(remoteUrl)) {
            throw new ZolozRpcException((Integer) 16, "host is null");
        }
        byte[] bArr = null;
        if (objArr.length <= 1) {
            Object obj2 = objArr[0];
            if (obj2 instanceof Message) {
                bArr = ((Message) obj2).toByteArray();
            }
        }
        int incrementAndGet = rpcSequence.incrementAndGet();
        String value = operationType.value();
        HashMap hashMap = new HashMap();
        hashMap.put("AppId", RpcConfig.getInstance().getAppId());
        hashMap.put("workspaceId", RpcConfig.getInstance().getWorkspaceId());
        hashMap.put("Content-Type", HeaderConstant.HEADER_VALUE_PB_TYPE);
        hashMap.put("Operation-Type", value);
        hashMap.put("id", String.valueOf(incrementAndGet));
        NetRequest build = NetRequest.build(incrementAndGet, remoteUrl, value, hashMap, bArr);
        if (RpcConfig.needCatchRpc) {
            InterceptorManager.get().onPreExecute(build);
        }
        if (RpcConfig.getInstance().getRpcProxyImpl() != null) {
            doRequest = RpcConfig.getInstance().getRpcProxyImpl().doRequest(build);
        } else {
            doRequest = NormalRequest.doRequest(remoteUrl, hashMap, build.requestBody);
        }
        if (RpcConfig.needCatchRpc) {
            InterceptorManager.get().onPostExecute(build, doRequest);
        }
        if (doRequest.rpcCode == 4001) {
            throw new ZolozRpcException((Integer) 4001, "time out of 10s");
        }
        if (doRequest.responseBody != null) {
            try {
                Class<?> returnType = method.getReturnType();
                Class<?> cls = returnType;
                return new Wire(new Class[0]).parseFrom(doRequest.responseBody, returnType);
            } catch (Exception unused) {
                throw new ZolozRpcException((Integer) 3002, "pb object null");
            }
        }
        throw new ZolozRpcException((Integer) 5000, "null result error");
    }

    private String getTimeTamp() {
        return String.valueOf(System.currentTimeMillis());
    }
}
