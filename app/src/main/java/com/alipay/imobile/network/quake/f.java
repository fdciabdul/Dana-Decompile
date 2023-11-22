package com.alipay.imobile.network.quake;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.imobile.network.quake.cache.Cache;
import com.alipay.imobile.network.quake.cache.DiskBasedCache;
import com.alipay.imobile.network.quake.exception.ClientException;
import com.alipay.imobile.network.quake.exception.ReinitializationException;
import com.alipay.imobile.network.quake.protocol.Protocol;
import com.alipay.imobile.network.quake.transport.Transporter;
import com.alipay.imobile.network.quake.transport.http.DefaultHttpTransport;
import com.alipay.mobile.common.rpc.RpcException;
import com.google.common.base.Ascii;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class f {
    private static f p;

    /* renamed from: a  reason: collision with root package name */
    private Map<String, Protocol<?>> f7048a;
    private Map<String, Cache> b;
    private Map<String, Transporter> c;
    private Context d;
    private String e;
    private String f;
    private String k;
    private String l;
    private String m;
    private QuakeConfig n;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {42, -75, 2, Ascii.US, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
    public static final int BuiltInFictitiousFunctionClassFactory = 233;
    private String g = "";
    private String h = "INNER_JSON_SIGN_V1";
    private String i = "INNER_DISK_V1";
    private String j = "INNER_HTTP_V1";

    /* renamed from: o  reason: collision with root package name */
    private boolean f7049o = false;

    private f(Context context) {
        if (context != null) {
            this.f7048a = new HashMap();
            this.b = new HashMap();
            this.c = new HashMap();
            this.d = context;
            return;
        }
        throw new RpcException((Integer) 9, "QuakeContext can not be initialized with null parameters.");
    }

    public static f a(Context context) {
        f fVar;
        synchronized (f.class) {
            if (p == null) {
                p = new f(context);
            }
            fVar = p;
        }
        return fVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0046 A[Catch: Exception -> 0x0074, TryCatch #0 {Exception -> 0x0074, blocks: (B:13:0x0042, B:15:0x0046, B:16:0x0062), top: B:28:0x0042 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0062 A[Catch: Exception -> 0x0074, TRY_LEAVE, TryCatch #0 {Exception -> 0x0074, blocks: (B:13:0x0042, B:15:0x0046, B:16:0x0062), top: B:28:0x0042 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0064 -> B:18:0x0068). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void n() {
        /*
            r15 = this;
            java.lang.String r0 = "com.google.gson.Gson"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch: java.lang.Exception -> L73
            java.lang.String r1 = "com.alipay.imobile.network.quake.ext.protocol.gson.GsonProtocol"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.Exception -> L73
            if (r0 == 0) goto L71
            if (r1 == 0) goto L71
            java.lang.Class<com.alipay.imobile.network.quake.protocol.Protocol> r0 = com.alipay.imobile.network.quake.protocol.Protocol.class
            boolean r0 = r0.isAssignableFrom(r1)     // Catch: java.lang.Exception -> L73
            if (r0 == 0) goto L71
            java.lang.String r0 = com.alipay.imobile.network.quake.Quake.TAG     // Catch: java.lang.Exception -> L73
            java.lang.String r2 = "register gson protocol as the default protocol"
            com.alipay.iap.android.common.log.LoggerWrapper.i(r0, r2)     // Catch: java.lang.Exception -> L73
            r0 = 1
            java.lang.Class[] r2 = new java.lang.Class[r0]     // Catch: java.lang.Exception -> L73
            r3 = 3
            byte[] r4 = com.alipay.imobile.network.quake.f.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L73
            r5 = 23
            byte[] r6 = new byte[r5]     // Catch: java.lang.Exception -> L73
            r7 = 97
            r8 = 0
            r11 = r15
            r3 = r2
            if (r4 != 0) goto L38
            r9 = r6
            r10 = 23
            r12 = 0
            r6 = r4
            r4 = 3
            goto L68
        L38:
            r7 = r6
            r9 = 97
            r10 = 0
            r6 = r4
            r4 = 3
        L3e:
            int r4 = r4 + r0
            int r12 = r10 + 1
            byte r13 = (byte) r9
            r7[r10] = r13     // Catch: java.lang.Exception -> L74
            if (r12 != r5) goto L62
            java.lang.String r4 = new java.lang.String     // Catch: java.lang.Exception -> L74
            r4.<init>(r7, r8)     // Catch: java.lang.Exception -> L74
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch: java.lang.Exception -> L74
            r2[r8] = r4     // Catch: java.lang.Exception -> L74
            java.lang.reflect.Constructor r1 = r1.getDeclaredConstructor(r3)     // Catch: java.lang.Exception -> L74
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.Exception -> L74
            android.content.Context r2 = r11.d     // Catch: java.lang.Exception -> L74
            r0[r8] = r2     // Catch: java.lang.Exception -> L74
            java.lang.Object r0 = r1.newInstance(r0)     // Catch: java.lang.Exception -> L74
            com.alipay.imobile.network.quake.protocol.Protocol r0 = (com.alipay.imobile.network.quake.protocol.Protocol) r0     // Catch: java.lang.Exception -> L74
            goto L7c
        L62:
            r10 = r6[r4]     // Catch: java.lang.Exception -> L74
            r14 = r9
            r9 = r7
            r7 = r10
            r10 = r14
        L68:
            int r7 = -r7
            int r10 = r10 + r7
            int r7 = r10 + (-8)
            r10 = r12
            r14 = r9
            r9 = r7
            r7 = r14
            goto L3e
        L71:
            r11 = r15
            goto L7b
        L73:
            r11 = r15
        L74:
            java.lang.String r0 = com.alipay.imobile.network.quake.Quake.TAG
            java.lang.String r1 = "gson or gson protocol is not exist"
            com.alipay.iap.android.common.log.LoggerWrapper.i(r0, r1)
        L7b:
            r0 = 0
        L7c:
            if (r0 != 0) goto L8d
            java.lang.String r0 = com.alipay.imobile.network.quake.Quake.TAG
            java.lang.String r1 = "register fastjson protocol as the default protocol"
            com.alipay.iap.android.common.log.LoggerWrapper.i(r0, r1)
            com.alipay.imobile.network.quake.protocol.json.SignedJsonProtocolV1 r0 = new com.alipay.imobile.network.quake.protocol.json.SignedJsonProtocolV1
            android.content.Context r1 = r11.d
            r0.<init>(r1)
        L8d:
            com.alipay.imobile.network.quake.f r1 = com.alipay.imobile.network.quake.f.p
            java.lang.String r2 = "INNER_JSON_SIGN_V1"
            r1.a(r2, r0)
            com.alipay.imobile.network.quake.f r0 = com.alipay.imobile.network.quake.f.p
            com.alipay.imobile.network.quake.protocol.SimpleRpcServiceProtocolV1 r1 = new com.alipay.imobile.network.quake.protocol.SimpleRpcServiceProtocolV1
            android.content.Context r2 = r11.d
            r1.<init>(r2)
            java.lang.String r2 = "alipay.client.executerpc"
            r0.a(r2, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.imobile.network.quake.f.n():void");
    }

    public static f o() throws RpcException {
        f fVar;
        synchronized (f.class) {
            fVar = p;
            if (fVar == null) {
                throw new RpcException((Integer) 9, "QuakeContext instance has not been initialized.");
            }
        }
        return fVar;
    }

    public Protocol b(String str) throws ClientException {
        Protocol<?> protocol;
        synchronized (this) {
            StringBuilder sb = new StringBuilder();
            sb.append("can not find request protocol which name is ");
            sb.append(str);
            String obj = sb.toString();
            if (!TextUtils.isEmpty(str)) {
                protocol = this.f7048a.get(str);
                if (protocol == null) {
                    throw new ClientException((Integer) 18, obj);
                }
            } else {
                throw new ClientException((Integer) 18, obj);
            }
        }
        return protocol;
    }

    public Transporter c(String str) throws ClientException {
        Transporter transporter;
        synchronized (this) {
            StringBuilder sb = new StringBuilder();
            sb.append("can not find transporter which name is ");
            sb.append(str);
            String obj = sb.toString();
            if (!TextUtils.isEmpty(str)) {
                transporter = this.c.get(str);
                if (transporter == null) {
                    throw new ClientException((Integer) 1, obj);
                }
            } else {
                throw new ClientException((Integer) 1, obj);
            }
        }
        return transporter;
    }

    public QuakeConfig d() {
        return this.n;
    }

    public Context e() {
        return this.d;
    }

    public String f() {
        return this.i;
    }

    public String g() {
        return this.h;
    }

    public String h() {
        return this.j;
    }

    public String i() {
        return this.m;
    }

    public String j() {
        return this.k;
    }

    public String k() {
        return this.l;
    }

    protected void l() {
        if (this.f7049o) {
            return;
        }
        n();
        p.a("INNER_HTTP_V1", new DefaultHttpTransport());
        p.a("INNER_DISK_V1", new DiskBasedCache(new File(this.d.getCacheDir(), "quake")));
        this.f7049o = true;
    }

    public void m() {
        synchronized (this) {
            p = null;
            this.h = "INNER_JSON_SIGN_V1";
            this.f7048a.clear();
            this.i = "INNER_DISK_V1";
            this.b.clear();
            this.j = "INNER_HTTP_V1";
            this.c.clear();
            this.d = null;
        }
    }

    public void d(String str) throws ReinitializationException {
        if (TextUtils.isEmpty(str) || this.i.equals(str) || "INNER_DISK_V1".equals(str)) {
            return;
        }
        if ("INNER_DISK_V1".equals(this.i)) {
            this.i = str;
            return;
        }
        throw new ReinitializationException(9, "The default cache has been set");
    }

    public void e(String str) throws ReinitializationException {
        if (TextUtils.isEmpty(str) || this.h.equals(str) || "INNER_JSON_SIGN_V1".equals(str)) {
            return;
        }
        if ("INNER_JSON_SIGN_V1".equals(this.h)) {
            this.h = str;
            return;
        }
        throw new ReinitializationException(9, "The default protocol has been set");
    }

    public void f(String str) throws ReinitializationException {
        if (TextUtils.isEmpty(str) || this.j.equals(str) || "INNER_HTTP_V1".equals(str)) {
            return;
        }
        if ("INNER_HTTP_V1".equals(this.j)) {
            this.j = str;
            return;
        }
        throw new ReinitializationException(9, "The default transport has been set");
    }

    public void a(QuakeConfig quakeConfig) throws ReinitializationException {
        QuakeConfig quakeConfig2 = this.n;
        if (quakeConfig2 != null && quakeConfig != quakeConfig2) {
            throw new ReinitializationException(9, "Error to duplicate setting QuakeConfig.");
        }
        this.n = quakeConfig;
        quakeConfig.getGwUrl();
        this.f = this.n.getAppId();
        this.e = this.n.getAppKeyForSecurityGuard();
        this.g = this.n.getAuthCodeForSecurityGuard();
        this.k = this.n.getVersion();
        this.l = this.n.getWorkspaceId();
        this.m = this.n.getTenantId();
        l();
    }

    public String b() {
        return this.e;
    }

    public String c() {
        return this.g;
    }

    public void a(String str, Protocol<?> protocol) throws ReinitializationException {
        synchronized (this) {
            if (TextUtils.isEmpty(str) || protocol == null) {
                return;
            }
            if (this.f7048a.containsKey(str)) {
                Protocol<?> protocol2 = this.f7048a.get(str);
                if (protocol2 != null && !protocol2.equals(protocol)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("The protocol specified with name=");
                    sb.append(str);
                    sb.append(" has already exist, and it is not equals to ");
                    sb.append(protocol);
                    String obj = sb.toString();
                    LoggerWrapper.e(Quake.TAG, obj);
                    throw new ReinitializationException(9, obj);
                }
            } else if (str.startsWith("Quake")) {
                LoggerWrapper.e(Quake.TAG, "The name of the request protocol can not start with 'Quake' and 'quake'");
                throw new ReinitializationException(9, "The name of the request protocol can not start with 'Quake' and 'quake'");
            }
            this.f7048a.put(str, protocol);
        }
    }

    public void a(String str, Cache cache) throws ReinitializationException {
        Cache cache2;
        synchronized (this) {
            if (TextUtils.isEmpty(str) || cache == null) {
                return;
            }
            if (this.b.containsKey(str) && (cache2 = this.b.get(str)) != null && !cache2.equals(cache)) {
                StringBuilder sb = new StringBuilder();
                sb.append("The cache specified with name=");
                sb.append(str);
                sb.append(" has already exist, and it is not equals to ");
                sb.append(cache);
                String obj = sb.toString();
                LoggerWrapper.e(Quake.TAG, obj);
                throw new ReinitializationException(9, obj);
            }
            String str2 = Quake.TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("register cache with the name=");
            sb2.append(str);
            LoggerWrapper.d(str2, sb2.toString());
            this.b.put(str, cache);
        }
    }

    public Cache a(String str) throws ClientException {
        Cache cache;
        synchronized (this) {
            StringBuilder sb = new StringBuilder();
            sb.append("can not find cache which name is ");
            sb.append(str);
            String obj = sb.toString();
            if (!TextUtils.isEmpty(str)) {
                cache = this.b.get(str);
                if (cache == null) {
                    throw new ClientException((Integer) 19, obj);
                }
            } else {
                throw new ClientException((Integer) 19, obj);
            }
        }
        return cache;
    }

    public void a(String str, Transporter transporter) throws ReinitializationException {
        Transporter transporter2;
        synchronized (this) {
            if (TextUtils.isEmpty(str) || transporter == null) {
                return;
            }
            if (this.c.containsKey(str) && (transporter2 = this.c.get(str)) != null && !transporter2.equals(transporter)) {
                StringBuilder sb = new StringBuilder();
                sb.append("The transporter specified with name=");
                sb.append(str);
                sb.append(" has already exist, and it is not equals to ");
                sb.append(transporter);
                String obj = sb.toString();
                LoggerWrapper.e(Quake.TAG, obj);
                throw new ReinitializationException(9, obj);
            }
            String str2 = Quake.TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("register transporter with the name=");
            sb2.append(str);
            LoggerWrapper.d(str2, sb2.toString());
            this.c.put(str, transporter);
        }
    }

    public String a() {
        return this.f;
    }
}
