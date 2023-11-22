package com.iap.ac.android.rpc;

import android.text.TextUtils;
import com.alibaba.griver.api.common.network.HttpResponse;
import com.alipay.mobile.common.rpc.RpcException;
import com.huawei.hms.framework.common.ContainerUtils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.log.ACMonitor;
import com.iap.ac.android.common.log.event.LogEvent;
import com.iap.ac.android.common.log.event.LogEventType;
import com.iap.ac.android.common.rpc.RpcAppInfo;
import com.iap.ac.android.common.rpc.RpcRequest;
import com.iap.ac.android.common.rpc.interfaces.FacadeInvoker;
import com.iap.ac.android.common.rpc.model.HttpMethod;
import com.iap.ac.android.common.timesync.TimeSyncManager;
import com.iap.ac.android.rpc.constant.RpcLogEvent;
import com.iap.ac.android.rpc.http.utils.OkHttpUtils;
import com.iap.ac.android.rpc.utils.RpcUtils;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import o.E;

/* loaded from: classes3.dex */
public class BaseRpcFacadeInvoker implements FacadeInvoker {
    private static int $10 = 0;
    private static int $11 = 1;
    private static long BuiltInFictitiousFunctionClassFactory = 0;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static int MyBillsEntityDataFactory = 1;
    private static int PlaceComponentResult;
    public static final String TAG;
    private static char getAuthRequestContext;
    public String bizCode;
    public RpcProxyImpl mRpcProxy;

    static {
        getAuthRequestContext();
        TAG = RpcUtils.logTag("BaseRpcFacadeInvoker");
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 63;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public BaseRpcFacadeInvoker(RpcProxyImpl rpcProxyImpl, String str) {
        this.mRpcProxy = rpcProxyImpl;
        this.bizCode = str;
    }

    public static /* synthetic */ String access$000(BaseRpcFacadeInvoker baseRpcFacadeInvoker) {
        int i = MyBillsEntityDataFactory + 15;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        try {
            String str = baseRpcFacadeInvoker.bizCode;
            int i3 = MyBillsEntityDataFactory + 75;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            if (!(i3 % 2 == 0)) {
                int i4 = 92 / 0;
                return str;
            }
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    private String formatRequestBody(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("operationType=");
        sb.append(str);
        sb.append(ContainerUtils.FIELD_DELIMITER);
        sb.append("requestData");
        sb.append("=");
        sb.append(str2);
        sb.append(ContainerUtils.FIELD_DELIMITER);
        sb.append("ts");
        sb.append("=");
        sb.append(str3);
        String obj = sb.toString();
        int i = MyBillsEntityDataFactory + 25;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (!(i % 2 == 0)) {
            Object obj2 = null;
            obj2.hashCode();
            return obj;
        }
        return obj;
    }

    private String formatRequestBodyV2(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("ts=");
        sb.append(str3);
        sb.append(ContainerUtils.FIELD_DELIMITER);
        sb.append("requestData");
        sb.append("=");
        sb.append(str2);
        sb.append(ContainerUtils.FIELD_DELIMITER);
        sb.append("operationType");
        sb.append("=");
        sb.append(str);
        String obj = sb.toString();
        int i = MyBillsEntityDataFactory + 91;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        return obj;
    }

    static void getAuthRequestContext() {
        getAuthRequestContext = (char) 14858;
        BuiltInFictitiousFunctionClassFactory = 4360990799332652212L;
        PlaceComponentResult = -956812108;
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x0035, code lost:
    
        r9 = r5.split("=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x003c, code lost:
    
        if (r9.length != 2) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x003e, code lost:
    
        r0 = com.iap.ac.android.rpc.BaseRpcFacadeInvoker.MyBillsEntityDataFactory + 93;
        com.iap.ac.android.rpc.BaseRpcFacadeInvoker.KClassImpl$Data$declaredNonStaticMembers$2 = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x004d, code lost:
    
        return r9[1].trim();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String getTraceIdFromErrorMsg(java.lang.String r9) {
        /*
            r8 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r9)     // Catch: java.lang.Exception -> L5e
            r1 = 50
            if (r0 == 0) goto Lb
            r0 = 50
            goto Ld
        Lb:
            r0 = 70
        Ld:
            java.lang.String r2 = ""
            r3 = 2
            if (r0 == r1) goto L54
            java.lang.String r0 = ","
            java.lang.String[] r9 = r9.split(r0)
            int r0 = r9.length
            r1 = 0
            r4 = 0
        L1b:
            if (r4 >= r0) goto L53
            r5 = r9[r4]
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Exception -> L51
            if (r6 != 0) goto L4e
            java.lang.String r6 = "traceId"
            boolean r6 = r5.contains(r6)     // Catch: java.lang.Exception -> L5e
            r7 = 1
            if (r6 != 0) goto L31
            r6 = 0
            goto L32
        L31:
            r6 = 1
        L32:
            if (r6 == r7) goto L35
            goto L4e
        L35:
            java.lang.String r9 = "="
            java.lang.String[] r9 = r5.split(r9)
            int r0 = r9.length
            if (r0 != r3) goto L53
            int r0 = com.iap.ac.android.rpc.BaseRpcFacadeInvoker.MyBillsEntityDataFactory
            int r0 = r0 + 93
            int r1 = r0 % 128
            com.iap.ac.android.rpc.BaseRpcFacadeInvoker.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % r3
            r9 = r9[r7]
            java.lang.String r9 = r9.trim()     // Catch: java.lang.Exception -> L51
            return r9
        L4e:
            int r4 = r4 + 1
            goto L1b
        L51:
            r9 = move-exception
            throw r9
        L53:
            return r2
        L54:
            int r9 = com.iap.ac.android.rpc.BaseRpcFacadeInvoker.KClassImpl$Data$declaredNonStaticMembers$2
            int r9 = r9 + 21
            int r0 = r9 % 128
            com.iap.ac.android.rpc.BaseRpcFacadeInvoker.MyBillsEntityDataFactory = r0
            int r9 = r9 % r3
            return r2
        L5e:
            r9 = move-exception
            goto L61
        L60:
            throw r9
        L61:
            goto L60
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.rpc.BaseRpcFacadeInvoker.getTraceIdFromErrorMsg(java.lang.String):java.lang.String");
    }

    public RpcAppInfo getRpcAppInfo() {
        try {
            int i = MyBillsEntityDataFactory + 5;
            try {
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                if (!(i % 2 == 0)) {
                    RpcAppInfo rpcAppInfo = this.mRpcProxy.getRpcAppInfo();
                    Object[] objArr = null;
                    int length = objArr.length;
                    return rpcAppInfo;
                }
                return this.mRpcProxy.getRpcAppInfo();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:248:0x00b2, code lost:
    
        if (r1.endsWith("]") == false) goto L257;
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x00bc, code lost:
    
        if (r2 == false) goto L257;
     */
    /* JADX WARN: Code restructure failed: missing block: B:349:0x02f6, code lost:
    
        if (com.iap.ac.android.rpc.RpcProxyImpl.getInstance(r28.bizCode).isCanMonit() != false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:353:0x0305, code lost:
    
        if (r10 != false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:354:0x0307, code lost:
    
        r10 = new java.util.HashMap(5);
        r10.put(com.iap.ac.android.rpc.constant.RpcLogEvent.PARAM_KEY_OPERATION_TYPE, r31.operationType);
        r10.put("url", r12.rpcGateWayUrl);
        r10.put(com.iap.ac.android.rpc.constant.RpcLogEvent.PARAM_KEY_REAL_URL, r12.rpcGateWayUrl);
        r10.put("result", "T");
        r6 = new java.lang.StringBuilder();
        r6.append(r13);
        r10.put(com.iap.ac.android.rpc.constant.RpcLogEvent.PARAM_KEY_NET_COST, r6.toString());
        r6 = new java.lang.StringBuilder();
        r6.append(r3);
        r10.put("duration", r6.toString());
        com.iap.ac.android.common.log.ACMonitor.getInstance(r28.bizCode).logEvent(new com.iap.ac.android.common.log.event.LogEvent(com.iap.ac.android.rpc.constant.RpcLogEvent.RPC_NET_RESULT, r10));
        r6 = new java.util.HashMap(4);
        r6.put(com.iap.ac.android.rpc.constant.RpcLogEvent.PARAM_KEY_RPC_ID, r31.operationType);
        r8 = new java.lang.StringBuilder();
        r8.append(r3);
        r6.put(com.iap.ac.android.rpc.constant.RpcLogEvent.PARAM_KEY_RPC_TIME, r8.toString());
        r6.put(com.iap.ac.android.rpc.constant.RpcLogEvent.PARAM_KEY_RPC_RESULT_CODE, "1000");
        r6.put(com.iap.ac.android.rpc.constant.RpcLogEvent.PARAM_KEY_RPC_RESULT, "T");
        r6.put(com.iap.ac.android.rpc.constant.RpcLogEvent.PARAM_KEY_RPC_TRACE_ID, r24);
     */
    /* JADX WARN: Code restructure failed: missing block: B:355:0x0391, code lost:
    
        if (com.iap.ac.android.rpc.http.utils.OkHttpUtils.canUseOkhttp(r17) == false) goto L357;
     */
    /* JADX WARN: Code restructure failed: missing block: B:356:0x0393, code lost:
    
        r3 = "HTTP/2.0";
     */
    /* JADX WARN: Code restructure failed: missing block: B:357:0x0396, code lost:
    
        r3 = com.alibaba.griver.api.common.network.HttpResponse.PROTOCOL.HTTP_1_1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:358:0x0398, code lost:
    
        r6.put(com.iap.ac.android.rpc.constant.RpcLogEvent.PARAM_KEY_RPC_HTTP_PROTOCOLS, r3);
        r3 = new com.iap.ac.android.common.log.event.LogEvent(com.iap.ac.android.rpc.constant.RpcLogEvent.RPC_NATIVE_RPC_PERFORMANCE, r6);
        r3.eventType = com.iap.ac.android.common.log.event.LogEventType.PERFORMANCE_LOG;
        com.iap.ac.android.common.log.ACMonitor.getInstance(r28.bizCode).logEvent(r3);
     */
    /* JADX WARN: Removed duplicated region for block: B:260:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0161 A[Catch: Exception -> 0x0466, TRY_ENTER, TryCatch #5 {Exception -> 0x0466, blocks: (B:265:0x0151, B:268:0x0161, B:269:0x016c), top: B:395:0x0151 }] */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:378:0x045d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <Response> Response performRequest(java.lang.reflect.Method r29, com.iap.ac.android.common.rpc.model.HttpMethod r30, com.iap.ac.android.common.rpc.RpcRequest r31) throws com.alipay.mobile.common.rpc.RpcException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 1178
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.rpc.BaseRpcFacadeInvoker.performRequest(java.lang.reflect.Method, com.iap.ac.android.common.rpc.model.HttpMethod, com.iap.ac.android.common.rpc.RpcRequest):java.lang.Object");
    }

    public <Response> Response postRequest(Method method, RpcRequest rpcRequest) throws RpcException, IOException {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 49;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        try {
            Response response = (Response) performRequest(method, HttpMethod.POST, rpcRequest);
            int i3 = MyBillsEntityDataFactory + 27;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            if ((i3 % 2 != 0 ? 'K' : '[') != 'K') {
                return response;
            }
            Object obj = null;
            obj.hashCode();
            return response;
        } catch (Exception e) {
            throw e;
        }
    }

    public String prepareRequestBody(Method method, String str, RpcAppInfo rpcAppInfo, String str2, Map<String, String> map) {
        String valueOf;
        String str3;
        try {
            TimeSyncManager timeSyncManager = TimeSyncManager.getInstance(RpcProxyImpl.getInstance(this.bizCode).getApplicationContext(), this.bizCode);
            if (!(timeSyncManager == null)) {
                valueOf = String.valueOf(timeSyncManager.getServerTime());
            } else {
                int i = MyBillsEntityDataFactory + 9;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                if ((i % 2 != 0 ? '8' : (char) 11) != 11) {
                    valueOf = String.valueOf(System.currentTimeMillis());
                    Object obj = null;
                    obj.hashCode();
                } else {
                    valueOf = String.valueOf(System.currentTimeMillis());
                }
            }
            String signV2Request = RpcProxyImpl.getInstance(this.bizCode).signV2Request(rpcAppInfo, str, formatRequestBodyV2(str, str2, valueOf), map);
            if (!TextUtils.isEmpty(signV2Request)) {
                int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 17;
                MyBillsEntityDataFactory = i2 % 128;
                int i3 = i2 % 2;
                str3 = "";
            } else {
                str3 = RpcProxyImpl.getInstance(this.bizCode).signRequest(rpcAppInfo, formatRequestBody(str, str2, valueOf), map);
            }
            String formatForUrlEncode = RpcUtils.formatForUrlEncode(str, str2, valueOf, str3, signV2Request);
            try {
                int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 59;
                MyBillsEntityDataFactory = i4 % 128;
                int i5 = i4 % 2;
                return formatForUrlEncode;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // com.iap.ac.android.common.rpc.interfaces.FacadeInvoker
    public Object invokeMethod(Method method, RpcRequest rpcRequest) throws RpcException {
        RpcException rpcException;
        int i = MyBillsEntityDataFactory + 55;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            return postRequest(method, rpcRequest);
        } catch (Exception e) {
            long currentTimeMillis2 = System.currentTimeMillis();
            String str = rpcRequest.operationType;
            RpcAppInfo rpcAppInfo = rpcRequest.getRpcAppInfo();
            if (rpcAppInfo == null) {
                try {
                    rpcAppInfo = getRpcAppInfo();
                    try {
                        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 53;
                        MyBillsEntityDataFactory = i3 % 128;
                        int i4 = i3 % 2;
                    } catch (Exception e2) {
                        throw e2;
                    }
                } catch (Exception e3) {
                    throw e3;
                }
            }
            ACLog.w(TAG, String.format("Cannot invoke rpc with UrlTransport! operationType = %s, message = %s", str, e.getMessage()));
            if ((e instanceof RpcException ? 'W' : (char) 2) == 2) {
                rpcException = new RpcException((Integer) 5000, (Throwable) e);
            } else {
                int i5 = MyBillsEntityDataFactory + 27;
                KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
                if ((i5 % 2 != 0 ? 'V' : (char) 20) != 'V') {
                    rpcException = (RpcException) e;
                } else {
                    rpcException = (RpcException) e;
                    Object obj = null;
                    obj.hashCode();
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(rpcException.getCode());
            reportRpcError(sb.toString(), rpcException.getMsg(), str, rpcAppInfo.rpcGateWayUrl, currentTimeMillis2 - currentTimeMillis, rpcRequest);
            throw rpcException;
        }
    }

    public void reportRpcError(String str, String str2, String str3, String str4, long j, RpcRequest rpcRequest) {
        String str5;
        int i = MyBillsEntityDataFactory + 113;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if ((i % 2 != 0 ? '@' : (char) 22) != 22) {
            boolean isCanMonit = RpcProxyImpl.getInstance(this.bizCode).isCanMonit();
            Object obj = null;
            obj.hashCode();
            if (!isCanMonit) {
                return;
            }
        } else {
            try {
                if (!RpcProxyImpl.getInstance(this.bizCode).isCanMonit()) {
                    return;
                }
            } catch (Exception e) {
                throw e;
            }
        }
        HashMap hashMap = new HashMap(5);
        hashMap.put("code", str);
        hashMap.put("message", str2);
        hashMap.put(RpcLogEvent.PARAM_KEY_OPERATION_TYPE, str3);
        hashMap.put("url", str4);
        hashMap.put(RpcLogEvent.PARAM_KEY_REAL_URL, str4);
        StringBuilder sb = new StringBuilder();
        sb.append(j);
        hashMap.put("duration", sb.toString());
        ACMonitor.getInstance(this.bizCode).logEvent(new LogEvent(RpcLogEvent.RPC_NET_ERROR, hashMap));
        HashMap hashMap2 = new HashMap(4);
        hashMap2.put(RpcLogEvent.PARAM_KEY_RPC_ID, str3);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(j);
        hashMap2.put(RpcLogEvent.PARAM_KEY_RPC_TIME, sb2.toString());
        hashMap2.put(RpcLogEvent.PARAM_KEY_RPC_RESULT_CODE, str);
        hashMap2.put(RpcLogEvent.PARAM_KEY_RPC_RESULT, str2);
        hashMap2.put(RpcLogEvent.PARAM_KEY_RPC_TRACE_ID, getTraceIdFromErrorMsg(str2));
        if (!(!OkHttpUtils.canUseOkhttp(rpcRequest))) {
            int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 5;
            MyBillsEntityDataFactory = i2 % 128;
            int i3 = i2 % 2;
            str5 = "HTTP/2.0";
        } else {
            str5 = HttpResponse.PROTOCOL.HTTP_1_1;
        }
        hashMap2.put(RpcLogEvent.PARAM_KEY_RPC_HTTP_PROTOCOLS, str5);
        LogEvent logEvent = new LogEvent(RpcLogEvent.RPC_NATIVE_RPC_PERFORMANCE, hashMap2);
        logEvent.eventType = LogEventType.PERFORMANCE_LOG;
        ACMonitor.getInstance(this.bizCode).logEvent(logEvent);
        int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 85;
        MyBillsEntityDataFactory = i4 % 128;
        int i5 = i4 % 2;
    }

    private static void a(char[] cArr, char[] cArr2, char c, char[] cArr3, int i, Object[] objArr) {
        E e = new E();
        int length = cArr2.length;
        char[] cArr4 = new char[length];
        int length2 = cArr3.length;
        char[] cArr5 = new char[length2];
        System.arraycopy(cArr2, 0, cArr4, 0, length);
        System.arraycopy(cArr3, 0, cArr5, 0, length2);
        cArr4[0] = (char) (cArr4[0] ^ c);
        cArr5[2] = (char) (cArr5[2] + ((char) i));
        int length3 = cArr.length;
        char[] cArr6 = new char[length3];
        e.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        while (true) {
            if ((e.KClassImpl$Data$declaredNonStaticMembers$2 < length3 ? 'R' : (char) 19) != 19) {
                int i2 = $10 + 99;
                $11 = i2 % 128;
                int i3 = i2 % 2;
                int i4 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
                int i5 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
                e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i4]) % 65535);
                cArr5[i5] = (char) (((cArr4[i5] * 32718) + cArr5[i4]) / 65535);
                cArr4[i5] = e.MyBillsEntityDataFactory;
                cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i5] ^ cArr[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (BuiltInFictitiousFunctionClassFactory ^ 4360990799332652212L)) ^ ((int) (PlaceComponentResult ^ 4360990799332652212L))) ^ ((char) (getAuthRequestContext ^ 4360990799332652212L)));
                e.KClassImpl$Data$declaredNonStaticMembers$2++;
            } else {
                String str = new String(cArr6);
                int i6 = $10 + 21;
                $11 = i6 % 128;
                int i7 = i6 % 2;
                objArr[0] = str;
                return;
            }
        }
    }
}
