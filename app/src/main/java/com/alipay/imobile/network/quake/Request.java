package com.alipay.imobile.network.quake;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.iap.android.common.log.MonitorWrapper;
import com.alipay.imobile.network.quake.cache.Cache;
import com.alipay.imobile.network.quake.protocol.Protocol;
import com.alipay.imobile.network.quake.transport.Transporter;
import com.alipay.imobile.network.quake.transport.http.constant.HeaderConstant;
import com.alipay.imobile.network.quake.transport.strategy.DefaultRetryPolicy;
import com.alipay.imobile.network.quake.transport.strategy.RetryPolicy;
import com.alipay.imobile.network.quake.util.SignUtil;
import com.alipay.mobile.common.rpc.RpcException;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.rpc.constant.RpcLogEvent;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class Request implements Comparable<Request> {
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {33, -64, 37, -91, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int PlaceComponentResult = 238;

    /* renamed from: a  reason: collision with root package name */
    private final com.alipay.imobile.network.quake.util.f f7030a;
    private String b;
    private Type c;
    private String d;
    private ErrorListener e;
    private Listener f;
    private CheckLoginListener g;
    private b h;
    private Integer i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    protected final String mAction;
    private RetryPolicy n;

    /* renamed from: o  reason: collision with root package name */
    private Cache.Entry f7031o;
    private Object p;
    private Object q;
    private String r;
    private String s;
    private String t;
    private Map<String, String> u;
    private String v;
    private SignUtil.SignInfo w;

    /* loaded from: classes3.dex */
    public interface CheckLoginListener {
        void checkLogin(Request request) throws RpcException;
    }

    /* loaded from: classes3.dex */
    public interface ErrorListener {
        void onErrorResponse(RpcException rpcException);
    }

    /* loaded from: classes3.dex */
    public interface Listener {
        void onResponse(Object obj);
    }

    /* loaded from: classes3.dex */
    public enum Priority {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    /* loaded from: classes3.dex */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f7032a;
        final /* synthetic */ long b;

        a(String str, long j) {
            this.f7032a = str;
            this.b = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Request.this.f7030a.a(this.f7032a, this.b);
            Request.this.f7030a.a(toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface b {
        void a(Request request);
    }

    public Request(String str, Type type, Listener listener, ErrorListener errorListener) {
        String str2 = null;
        this.f7030a = LoggerWrapper.isDebuggable() ? new com.alipay.imobile.network.quake.util.f() : null;
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = false;
        this.f7031o = null;
        this.q = null;
        this.u = new HashMap();
        this.v = null;
        this.b = str;
        if (type == null) {
            this.c = Object[].class.getComponentType();
        } else {
            this.c = type;
        }
        this.f = listener;
        this.e = errorListener;
        f o2 = f.o();
        setRetryPolicy(new DefaultRetryPolicy());
        setProtocolName(o2.g());
        setCacheName(o2.f());
        setTransportName(o2.h());
        try {
            str2 = new URL(str).getPath();
        } catch (MalformedURLException unused) {
        }
        this.mAction = str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:11:0x0039). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void A(byte r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 7
            int r6 = 106 - r6
            int r7 = r7 * 12
            int r7 = 15 - r7
            int r8 = r8 * 3
            int r8 = 16 - r8
            byte[] r0 = com.alipay.imobile.network.quake.Request.BuiltInFictitiousFunctionClassFactory
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L1c
            r6 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L39
        L1c:
            r3 = 0
        L1d:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r7 = r7 + 1
            if (r3 != r8) goto L2c
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2c:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L39:
            int r8 = r8 + r7
            int r7 = r8 + 2
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.imobile.network.quake.Request.A(byte, short, int, java.lang.Object[]):void");
    }

    private String a() {
        return getProtocol().generateCacheKey(this);
    }

    public void addExternalInfo(Map<String, String> map) {
        if (map == null) {
            return;
        }
        this.u.putAll(map);
    }

    public void addMarker(String str) {
        if (LoggerWrapper.isDebuggable()) {
            com.alipay.imobile.network.quake.util.f fVar = this.f7030a;
            try {
                byte b2 = (byte) (BuiltInFictitiousFunctionClassFactory[15] - 1);
                byte b3 = b2;
                Object[] objArr = new Object[1];
                A(b2, b3, b3, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b4 = BuiltInFictitiousFunctionClassFactory[15];
                byte b5 = b4;
                Object[] objArr2 = new Object[1];
                A(b4, b5, b5, objArr2);
                fVar.a(str, ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getId());
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
    }

    public void addRpcTraceId(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        String str = this.u.get(HeaderConstant.HEADER_KEY_DID);
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        String str2 = this.u.get("ts");
        if (!TextUtils.isEmpty(str2)) {
            sb.append(str2);
        }
        map.put(RpcLogEvent.PARAM_KEY_RPC_TRACE_ID, sb.toString());
    }

    public void addSofaId(Map<String, String> map) {
        String str = this.u.get("Mgw-TraceId");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        map.put("sofa_id", str);
    }

    public void cancel() {
        this.k = true;
    }

    public void checkLogin() {
        CheckLoginListener checkLoginListener = this.g;
        if (checkLoginListener != null) {
            checkLoginListener.checkLogin(this);
        }
    }

    public Request compress() {
        this.l = true;
        return this;
    }

    public void deliverError(RpcException rpcException) {
        LoggerWrapper.e(Quake.TAG, LoggerWrapper.buildMessage("error[code=%s, msg=%s] need to be handle ", Integer.valueOf(rpcException.getCode()), rpcException.getMessage()));
        ErrorListener errorListener = this.e;
        if (errorListener != null) {
            errorListener.onErrorResponse(rpcException);
        }
        HashMap hashMap = new HashMap(5);
        hashMap.put("code", String.valueOf(rpcException.getCode()));
        hashMap.put("message", rpcException.getMessage());
        hashMap.put(RpcLogEvent.PARAM_KEY_OPERATION_TYPE, getActionType());
        addSofaId(hashMap);
        addRpcTraceId(hashMap);
        MonitorWrapper.behaviour(RpcLogEvent.RPC_NET_ERROR, hashMap);
        HashMap hashMap2 = new HashMap(4);
        hashMap2.put("result", LogConstants.RESULT_FALSE);
        hashMap2.put(RpcLogEvent.PARAM_KEY_OPERATION_TYPE, getActionType());
        addSofaId(hashMap2);
        addRpcTraceId(hashMap2);
        MonitorWrapper.behaviour(RpcLogEvent.RPC_NET_RESULT, hashMap2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void deliverResponse(Object obj) {
        Listener listener = this.f;
        if (listener != null) {
            listener.onResponse(obj);
        }
        HashMap hashMap = new HashMap(4);
        hashMap.put("result", "T");
        hashMap.put(RpcLogEvent.PARAM_KEY_OPERATION_TYPE, getActionType());
        addSofaId(hashMap);
        addRpcTraceId(hashMap);
        MonitorWrapper.behaviour(RpcLogEvent.RPC_NET_RESULT, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void finish(String str) {
        b bVar = this.h;
        if (bVar != null) {
            bVar.a(this);
            onFinish();
        }
        if (LoggerWrapper.isDebuggable()) {
            try {
                byte b2 = (byte) (BuiltInFictitiousFunctionClassFactory[15] - 1);
                byte b3 = b2;
                Object[] objArr = new Object[1];
                A(b2, b3, b3, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b4 = BuiltInFictitiousFunctionClassFactory[15];
                byte b5 = b4;
                Object[] objArr2 = new Object[1];
                A(b4, b5, b5, objArr2);
                long id2 = ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getId();
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    new Handler(Looper.getMainLooper()).post(new a(str, id2));
                    return;
                }
                this.f7030a.a(str, id2);
                this.f7030a.a(toString());
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
    }

    public String getActionType() {
        return this.mAction;
    }

    public final Cache getCache() throws RpcException {
        return f.o().a(this.s);
    }

    public Cache.Entry getCacheEntry() {
        return this.f7031o;
    }

    public String getCacheKey() {
        return this.v;
    }

    public final String getCacheName() {
        return this.s;
    }

    public final Map<String, String> getExternalInfo() {
        return this.u;
    }

    public String getOriginUrl() {
        return this.b;
    }

    public Object getParams() {
        return this.q;
    }

    public Priority getPriority() {
        return Priority.NORMAL;
    }

    public final Protocol getProtocol() throws RpcException {
        return f.o().b(this.r);
    }

    public final String getProtocolName() {
        return this.r;
    }

    public Type getResponseType() {
        return this.c;
    }

    public RetryPolicy getRetryPolicy() {
        return this.n;
    }

    public final int getSequence() {
        Integer num = this.i;
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("getSequence called before setSequence");
    }

    public SignUtil.SignInfo getSignInfo() {
        return this.w;
    }

    public Object getTag() {
        return this.p;
    }

    public final int getTimeoutMs() {
        return this.n.getCurrentTimeout();
    }

    public final Transporter getTransport() throws RpcException {
        return f.o().c(this.t);
    }

    public final String getTransportName() {
        return this.t;
    }

    public String getUrl() {
        String str = this.d;
        return str == null ? this.b : str;
    }

    public boolean hasHadResponseDelivered() {
        return this.m;
    }

    public boolean isCanceled() {
        return this.k;
    }

    public boolean isCompressed() {
        return this.l;
    }

    public void markDelivered() {
        this.m = true;
    }

    protected void onFinish() {
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.f7031o = null;
        this.n = null;
        this.q = null;
        this.u.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RpcException parseNetworkError(RpcException rpcException) {
        return rpcException;
    }

    public Request setCacheEntry(Cache.Entry entry) {
        this.f7031o = entry;
        return this;
    }

    public void setCacheKey(String str) {
        this.v = str;
    }

    public final void setCacheName(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.s = str;
    }

    public void setCheckLoginListener(CheckLoginListener checkLoginListener) {
        this.g = checkLoginListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFinishListener(b bVar) {
        this.h = bVar;
    }

    public void setOriginUrl(String str) {
        this.b = str;
    }

    public void setParams(Object obj) {
        this.q = obj;
    }

    public final void setProtocolName(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.r = str;
    }

    public void setRedirectUrl(String str) {
        this.d = str;
    }

    public void setRetryPolicy(RetryPolicy retryPolicy) {
        this.n = retryPolicy;
    }

    public final Request setSequence(int i) {
        this.i = Integer.valueOf(i);
        return this;
    }

    public final Request setShouldCache(boolean z) {
        this.j = z;
        return this;
    }

    public void setSignInfo(SignUtil.SignInfo signInfo) {
        this.w = signInfo;
    }

    public Request setTag(Object obj) {
        this.p = obj;
        return this;
    }

    public final void setTransportName(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.t = str;
    }

    public final boolean shouldCache() {
        return this.j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.k ? "[X] " : "[ ] ");
        sb.append(a());
        sb.append(" ");
        sb.append(getPriority());
        sb.append(" ");
        sb.append(this.i);
        return sb.toString();
    }

    public void addExternalInfo(String str, String str2) {
        this.u.put(str, str2);
    }

    @Override // java.lang.Comparable
    public int compareTo(Request request) {
        Priority priority = getPriority();
        Priority priority2 = request.getPriority();
        if (priority == priority2) {
            return this.i.intValue() - request.i.intValue();
        }
        return priority2.ordinal() - priority.ordinal();
    }
}
