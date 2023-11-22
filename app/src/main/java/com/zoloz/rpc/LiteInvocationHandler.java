package com.zoloz.rpc;

import android.text.TextUtils;
import android.view.View;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.security.bio.service.local.rpc.IRpcException;
import com.google.common.net.HttpHeaders;
import com.huawei.hms.framework.common.ContainerUtils;
import com.zoloz.rpccommon.InterceptorManager;
import com.zoloz.rpccommon.NetRequest;
import com.zoloz.rpccommon.NetResponse;
import id.dana.data.here.HereOauthManager;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import o.C;

/* loaded from: classes8.dex */
public class LiteInvocationHandler implements InvocationHandler {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    private static final String EKYC_INIT_API = "com.zoloz.ekyc.init.client";
    private static char KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static char MyBillsEntityDataFactory = 0;
    private static char PlaceComponentResult = 0;
    public static String TAG = "LiteInvocationHandler";
    private static char getAuthRequestContext = 0;
    private static int lookAheadTest = 1;
    private static int requestID;
    private static boolean sInit;
    public String host;
    private Object mDebugObject;

    static {
        PlaceComponentResult();
        int i = BuiltInFictitiousFunctionClassFactory + 93;
        lookAheadTest = i % 128;
        int i2 = i % 2;
    }

    static void PlaceComponentResult() {
        KClassImpl$Data$declaredNonStaticMembers$2 = (char) 2413;
        PlaceComponentResult = (char) 3649;
        getAuthRequestContext = (char) 43346;
        MyBillsEntityDataFactory = (char) 24406;
    }

    static /* synthetic */ Object access$002(LiteInvocationHandler liteInvocationHandler, Object obj) {
        int i = lookAheadTest + 61;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if (i % 2 == 0) {
            liteInvocationHandler.mDebugObject = obj;
        } else {
            liteInvocationHandler.mDebugObject = obj;
            Object[] objArr = null;
            int length = objArr.length;
        }
        return obj;
    }

    static /* synthetic */ Object access$100(LiteInvocationHandler liteInvocationHandler, Object obj, Method method, Object[] objArr) throws ZolozRpcException {
        int i = BuiltInFictitiousFunctionClassFactory + 105;
        lookAheadTest = i % 128;
        boolean z = i % 2 == 0;
        Object performRequest = liteInvocationHandler.performRequest(obj, method, objArr);
        if (z) {
            int i2 = 23 / 0;
        }
        return performRequest;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0019, code lost:
    
        if (r0 != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0020, code lost:
    
        if (com.zoloz.rpc.RpcConfig.needDebugRpc != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0022, code lost:
    
        r0 = new java.util.concurrent.CountDownLatch(1);
        new java.lang.Thread(new com.zoloz.rpc.LiteInvocationHandler.AnonymousClass1(r9)).start();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003d, code lost:
    
        r0.await(30, java.util.concurrent.TimeUnit.SECONDS);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0042, code lost:
    
        r10 = r9.mDebugObject;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0046, code lost:
    
        if (r10 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0048, code lost:
    
        r12 = com.alibaba.fastjson.parser.JSONLexer.EOI;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004b, code lost:
    
        r12 = '\'';
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004d, code lost:
    
        if (r12 != 26) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004f, code lost:
    
        r11 = com.zoloz.rpc.LiteInvocationHandler.lookAheadTest + 99;
        com.zoloz.rpc.LiteInvocationHandler.BuiltInFictitiousFunctionClassFactory = r11 % 128;
        r11 = r11 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0059, code lost:
    
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0067, code lost:
    
        throw new com.zoloz.rpc.ZolozRpcException((java.lang.Integer) 6666, "rpc get null result");
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0068, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006e, code lost:
    
        throw new com.zoloz.rpc.ZolozRpcException(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006f, code lost:
    
        r10 = performRequest(r10, r11, r12);
        r11 = com.zoloz.rpc.LiteInvocationHandler.lookAheadTest + 83;
        com.zoloz.rpc.LiteInvocationHandler.BuiltInFictitiousFunctionClassFactory = r11 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007f, code lost:
    
        if ((r11 % 2) == 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0081, code lost:
    
        r11 = 24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0084, code lost:
    
        r11 = '@';
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
    
        if (r11 == 24) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0088, code lost:
    
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0089, code lost:
    
        r2.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x008c, code lost:
    
        return r10;
     */
    @Override // java.lang.reflect.InvocationHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object invoke(final java.lang.Object r10, final java.lang.reflect.Method r11, final java.lang.Object[] r12) throws com.zoloz.rpc.ZolozRpcException {
        /*
            r9 = this;
            int r0 = com.zoloz.rpc.LiteInvocationHandler.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 91
            int r1 = r0 % 128
            com.zoloz.rpc.LiteInvocationHandler.lookAheadTest = r1
            int r0 = r0 % 2
            r1 = 40
            if (r0 != 0) goto L11
            r0 = 61
            goto L13
        L11:
            r0 = 40
        L13:
            r2 = 0
            if (r0 == r1) goto L1e
            boolean r0 = com.zoloz.rpc.RpcConfig.needDebugRpc
            int r1 = r2.length     // Catch: java.lang.Throwable -> L1c
            if (r0 == 0) goto L6f
            goto L22
        L1c:
            r10 = move-exception
            throw r10
        L1e:
            boolean r0 = com.zoloz.rpc.RpcConfig.needDebugRpc     // Catch: java.lang.Exception -> L8f
            if (r0 == 0) goto L6f
        L22:
            java.util.concurrent.CountDownLatch r0 = new java.util.concurrent.CountDownLatch
            r1 = 1
            r0.<init>(r1)
            java.lang.Thread r1 = new java.lang.Thread
            com.zoloz.rpc.LiteInvocationHandler$1 r2 = new com.zoloz.rpc.LiteInvocationHandler$1
            r3 = r2
            r4 = r9
            r5 = r10
            r6 = r11
            r7 = r12
            r8 = r0
            r3.<init>()
            r1.<init>(r2)
            r1.start()
            r10 = 30
            java.util.concurrent.TimeUnit r12 = java.util.concurrent.TimeUnit.SECONDS     // Catch: java.lang.InterruptedException -> L68
            r0.await(r10, r12)     // Catch: java.lang.InterruptedException -> L68
            java.lang.Object r10 = r9.mDebugObject
            r11 = 26
            if (r10 == 0) goto L4b
            r12 = 26
            goto L4d
        L4b:
            r12 = 39
        L4d:
            if (r12 != r11) goto L5a
            int r11 = com.zoloz.rpc.LiteInvocationHandler.lookAheadTest
            int r11 = r11 + 99
            int r12 = r11 % 128
            com.zoloz.rpc.LiteInvocationHandler.BuiltInFictitiousFunctionClassFactory = r12
            int r11 = r11 % 2
            return r10
        L5a:
            com.zoloz.rpc.ZolozRpcException r10 = new com.zoloz.rpc.ZolozRpcException
            r11 = 6666(0x1a0a, float:9.341E-42)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            java.lang.String r12 = "rpc get null result"
            r10.<init>(r11, r12)
            throw r10
        L68:
            r10 = move-exception
            com.zoloz.rpc.ZolozRpcException r11 = new com.zoloz.rpc.ZolozRpcException
            r11.<init>(r10)
            throw r11
        L6f:
            java.lang.Object r10 = r9.performRequest(r10, r11, r12)
            int r11 = com.zoloz.rpc.LiteInvocationHandler.lookAheadTest
            int r11 = r11 + 83
            int r12 = r11 % 128
            com.zoloz.rpc.LiteInvocationHandler.BuiltInFictitiousFunctionClassFactory = r12
            int r11 = r11 % 2
            r12 = 24
            if (r11 == 0) goto L84
            r11 = 24
            goto L86
        L84:
            r11 = 64
        L86:
            if (r11 == r12) goto L89
            return r10
        L89:
            r2.hashCode()     // Catch: java.lang.Throwable -> L8d
            return r10
        L8d:
            r10 = move-exception
            throw r10
        L8f:
            r10 = move-exception
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zoloz.rpc.LiteInvocationHandler.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object");
    }

    private Object performRequest(Object obj, Method method, Object[] objArr) throws ZolozRpcException {
        NetRequest build;
        NetResponse doRequest;
        int i = lookAheadTest + 115;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        OperationType operationType = (OperationType) method.getAnnotation(OperationType.class);
        if (!(!TextUtils.isEmpty(this.host))) {
            this.host = RpcConfig.getInstance().getRemoteUrl();
        }
        if (operationType == null) {
            throw new ZolozRpcException(Integer.valueOf((int) IRpcException.ErrorCode.PRC_OPERATIONTYPE_EMPTY), "operation type is null");
        }
        if (TextUtils.isEmpty(this.host)) {
            throw new ZolozRpcException((Integer) 16, "host is null");
        }
        requestID++;
        StringBuilder sb = new StringBuilder();
        sb.append(BridgeDSL.INVOKE);
        sb.append(objArr);
        if (sb.toString() != null) {
            int length = objArr.length;
            int i3 = lookAheadTest + 59;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            int i4 = i3 % 2;
        }
        try {
            String encode = URLEncoder.encode(args2List(objArr), HereOauthManager.ENC);
            String value = operationType.value();
            HashMap hashMap = new HashMap();
            hashMap.put("id", String.valueOf(requestID));
            hashMap.put("operationType", value);
            hashMap.put("requestData", encode);
            hashMap.put("ts", getTimeTamp());
            if ((RpcConfig.getInstance().isEncodeParam() ? '4' : 'V') != 'V') {
                int i5 = BuiltInFictitiousFunctionClassFactory + 105;
                lookAheadTest = i5 % 128;
                if (i5 % 2 != 0) {
                    hashMap.put("_aop_signature", SigApiUtil.generateSignature(this.host, hashMap));
                } else {
                    hashMap.put("_aop_signature", SigApiUtil.generateSignature(this.host, hashMap));
                    int i6 = 71 / 0;
                }
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("AppId", RpcConfig.getInstance().getAppId());
            hashMap2.put("workspaceId", RpcConfig.getInstance().getWorkspaceId());
            hashMap2.put(HttpHeaders.CONNECTION, HttpHeaders.KEEP_ALIVE);
            Object[] objArr2 = new Object[1];
            a(View.resolveSizeAndState(0, 0, 0) + 5, new char[]{43206, 6717, 43119, 16778, 37455, 55568}, objArr2);
            hashMap2.put("Charset", ((String) objArr2[0]).intern());
            if (!(TextUtils.equals(operationType.value(), EKYC_INIT_API) ? false : true)) {
                build = NetRequest.build(requestID, RpcConfig.getInstance().getRemoteInitUrl(), value, hashMap2, JSON.toJSONString(objArr[0]).getBytes());
            } else {
                build = NetRequest.build(requestID, this.host, value, hashMap2, getQuery(hashMap).getBytes());
            }
            if (RpcConfig.needCatchRpc) {
                InterceptorManager.get().onPreExecute(build);
            }
            if ((RpcConfig.getInstance().getRpcProxyImpl() != null ? 'V' : (char) 5) == 'V') {
                doRequest = RpcConfig.getInstance().getRpcProxyImpl().doRequest(build);
            } else {
                doRequest = NormalRequest.doRequest(this.host, hashMap2, build.requestBody);
                int i7 = lookAheadTest + 81;
                BuiltInFictitiousFunctionClassFactory = i7 % 128;
                int i8 = i7 % 2;
            }
            if (RpcConfig.needCatchRpc) {
                InterceptorManager.get().onPostExecute(build, doRequest);
            }
            Class returnType = method.getReturnType();
            if (doRequest.rpcCode == 4001) {
                throw new ZolozRpcException((Integer) 4001, "time out of 10s");
            }
            if (doRequest.responseBody != null) {
                try {
                    return parseResultObj(new String(doRequest.responseBody), returnType);
                } catch (JSONException unused) {
                    throw new ZolozRpcException((Integer) 6004, "json format error");
                } catch (NullPointerException unused2) {
                    throw new ZolozRpcException((Integer) 6004, "json object null");
                }
            }
            throw new ZolozRpcException((Integer) 5000, "null result error");
        } catch (UnsupportedEncodingException e) {
            throw new ZolozRpcException(e);
        }
    }

    private String getQuery(Map<String, String> map) {
        try {
            int i = lookAheadTest + 81;
            try {
                BuiltInFictitiousFunctionClassFactory = i % 128;
                if (!(i % 2 == 0)) {
                    Object[] objArr = null;
                    int length = objArr.length;
                    if (map == null) {
                        return "";
                    }
                } else if (map == null) {
                    return "";
                }
                StringBuilder sb = new StringBuilder();
                boolean z = true;
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if ((z ? (char) 15 : '-') != 15) {
                        sb.append(ContainerUtils.FIELD_DELIMITER);
                    } else {
                        int i2 = lookAheadTest + 55;
                        BuiltInFictitiousFunctionClassFactory = i2 % 128;
                        z = (i2 % 2 != 0 ? '\\' : '9') != '9';
                    }
                    sb.append(entry.getKey());
                    sb.append("=");
                    sb.append(entry.getValue());
                }
                return sb.toString();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private Object parseResultObj(String str, Class cls) throws ZolozRpcException {
        int i = lookAheadTest + 45;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        JSONObject parseObject = JSON.parseObject(str);
        String string = parseObject.getString("result");
        int intValue = parseObject.getIntValue("resultStatus");
        if (!(intValue == 1000)) {
            throw new ZolozRpcException(Integer.valueOf(intValue), "rpc return error");
        }
        try {
            Object parseObject2 = JSON.parseObject(string, cls);
            int i3 = BuiltInFictitiousFunctionClassFactory + 115;
            lookAheadTest = i3 % 128;
            int i4 = i3 % 2;
            return parseObject2;
        } catch (Exception e) {
            throw e;
        }
    }

    private String getTimeTamp() {
        String valueOf;
        int i = BuiltInFictitiousFunctionClassFactory + 35;
        lookAheadTest = i % 128;
        if ((i % 2 == 0 ? 'E' : (char) 29) != 'E') {
            valueOf = String.valueOf(System.currentTimeMillis());
        } else {
            try {
                valueOf = String.valueOf(System.currentTimeMillis());
                Object obj = null;
                obj.hashCode();
            } catch (Exception e) {
                throw e;
            }
        }
        int i2 = BuiltInFictitiousFunctionClassFactory + 73;
        lookAheadTest = i2 % 128;
        int i3 = i2 % 2;
        return valueOf;
    }

    private String args2List(Object[] objArr) {
        if ((objArr == null ? (char) 29 : '`') != '`') {
            int i = BuiltInFictitiousFunctionClassFactory + 59;
            lookAheadTest = i % 128;
            if (!(i % 2 != 0)) {
                int i2 = 43 / 0;
                return "";
            }
            return "";
        }
        ArrayList arrayList = new ArrayList();
        int length = objArr.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                try {
                    return arrayList.toString();
                } catch (Exception e) {
                    throw e;
                }
            }
            int i4 = BuiltInFictitiousFunctionClassFactory + 45;
            lookAheadTest = i4 % 128;
            if (i4 % 2 == 0) {
                try {
                    arrayList.add(JSON.parseObject(JSON.toJSONString(objArr[i3])));
                    i3 += 120;
                } catch (Exception e2) {
                    throw e2;
                }
            } else {
                arrayList.add(JSON.parseObject(JSON.toJSONString(objArr[i3])));
                i3++;
            }
        }
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        C c = new C();
        char[] cArr2 = new char[cArr.length];
        c.BuiltInFictitiousFunctionClassFactory = 0;
        char[] cArr3 = new char[2];
        while (true) {
            if (!(c.BuiltInFictitiousFunctionClassFactory >= cArr.length)) {
                cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
                cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory + 1];
                int i2 = 58224;
                int i3 = 0;
                while (true) {
                    if (!(i3 >= 16)) {
                        int i4 = $10 + 23;
                        $11 = i4 % 128;
                        int i5 = i4 % 2;
                        cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i2) ^ ((cArr3[0] << 4) + ((char) (MyBillsEntityDataFactory ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (getAuthRequestContext ^ 6353485791441662354L)))));
                        cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i2) ^ ((cArr3[1] << 4) + ((char) (PlaceComponentResult ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 6353485791441662354L)))));
                        i2 -= 40503;
                        i3++;
                        int i6 = $11 + 111;
                        $10 = i6 % 128;
                        int i7 = i6 % 2;
                    }
                }
                cArr2[c.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
                cArr2[c.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
                c.BuiltInFictitiousFunctionClassFactory += 2;
            } else {
                objArr[0] = new String(cArr2, 0, i);
                return;
            }
        }
    }
}
