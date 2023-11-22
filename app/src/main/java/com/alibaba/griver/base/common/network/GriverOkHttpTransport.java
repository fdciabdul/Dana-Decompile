package com.alibaba.griver.base.common.network;

import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.griver.api.common.network.GriverTransportExtension;
import com.alipay.mobile.zebra.ZebraLoader;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import kotlin.text.Typography;
import o.C;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;

/* loaded from: classes6.dex */
public class GriverOkHttpTransport implements GriverTransportExtension {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char BuiltInFictitiousFunctionClassFactory = 0;
    public static final MediaType JSON;
    private static char KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static char MyBillsEntityDataFactory = 0;
    private static char PlaceComponentResult = 0;
    public static final MediaType STREAM;
    private static int getAuthRequestContext = 0;
    private static int lookAheadTest = 1;

    /* renamed from: a  reason: collision with root package name */
    private final OkHttpClient f6297a;

    /* loaded from: classes6.dex */
    interface GriverOkHttpTransportFactory {
        public static final GriverOkHttpTransport mInstance = new GriverOkHttpTransport();
    }

    static void PlaceComponentResult() {
        MyBillsEntityDataFactory = (char) 8030;
        KClassImpl$Data$declaredNonStaticMembers$2 = (char) 55870;
        BuiltInFictitiousFunctionClassFactory = (char) 10409;
        PlaceComponentResult = (char) 55033;
    }

    static {
        PlaceComponentResult();
        JSON = MediaType.parse("application/json;charset=utf-8");
        STREAM = MediaType.parse(ZebraLoader.MIME_TYPE_STREAM);
        int i = lookAheadTest + 125;
        getAuthRequestContext = i % 128;
        if ((i % 2 != 0 ? (char) 22 : ',') != ',') {
            Object obj = null;
            obj.hashCode();
        }
    }

    public GriverOkHttpTransport() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        try {
            InstrumentInjector.okhttp_addInterceptors(builder);
            this.f6297a = builder.protocols(Collections.unmodifiableList(Arrays.asList(Protocol.HTTP_1_1, Protocol.HTTP_2))).connectTimeout(60000L, TimeUnit.MILLISECONDS).readTimeout(60000L, TimeUnit.MILLISECONDS).build();
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x010e, code lost:
    
        if (r17.getRequestData() != null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0117, code lost:
    
        if (r17.getRequestData() != null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0119, code lost:
    
        r3 = r17.getRequestData();
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0129, code lost:
    
        if (android.text.TextUtils.isEmpty(r8.get("Content-Type")) == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x012b, code lost:
    
        r3 = okhttp3.RequestBody.create(com.alibaba.griver.base.common.network.GriverOkHttpTransport.JSON, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0132, code lost:
    
        r3 = okhttp3.RequestBody.create(okhttp3.MediaType.parse(r8.get("Content-Type")), r3);
     */
    @Override // com.alibaba.griver.api.common.network.GriverTransportExtension
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.alibaba.griver.api.common.network.HttpResponse request(com.alibaba.griver.api.common.network.HttpRequest r17) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 476
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.base.common.network.GriverOkHttpTransport.request(com.alibaba.griver.api.common.network.HttpRequest):com.alibaba.griver.api.common.network.HttpResponse");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0019, code lost:
    
        if (r3 == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x001e, code lost:
    
        if (r3 == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0020, code lost:
    
        r2 = com.alibaba.griver.base.common.network.GriverOkHttpTransport.getAuthRequestContext + 115;
        com.alibaba.griver.base.common.network.GriverOkHttpTransport.lookAheadTest = r2 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002c, code lost:
    
        if ((r2 % 2) != 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002e, code lost:
    
        r2 = '^';
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0031, code lost:
    
        r2 = 25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0033, code lost:
    
        if (r2 == '^') goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0035, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0036, code lost:
    
        r3 = 94 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0038, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003b, code lost:
    
        r3 = r3.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0047, code lost:
    
        if (r3.hasNext() == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x004b, code lost:
    
        r0 = com.alibaba.griver.base.common.network.GriverOkHttpTransport.lookAheadTest + 29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x004f, code lost:
    
        com.alibaba.griver.base.common.network.GriverOkHttpTransport.getAuthRequestContext = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0053, code lost:
    
        r0 = r3.next();
        r2.header(r0.getKey(), java.lang.String.valueOf(r0.getValue()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006b, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006c, code lost:
    
        throw r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006d, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(okhttp3.Request.Builder r2, java.util.Map<java.lang.String, ?> r3) {
        /*
            int r0 = com.alibaba.griver.base.common.network.GriverOkHttpTransport.lookAheadTest     // Catch: java.lang.Exception -> L6e
            int r0 = r0 + 45
            int r1 = r0 % 128
            com.alibaba.griver.base.common.network.GriverOkHttpTransport.getAuthRequestContext = r1     // Catch: java.lang.Exception -> L6e
            int r0 = r0 % 2
            r1 = 27
            if (r0 == 0) goto L11
            r0 = 55
            goto L13
        L11:
            r0 = 27
        L13:
            if (r0 == r1) goto L1e
            r0 = 10
            int r0 = r0 / 0
            if (r3 != 0) goto L3b
            goto L20
        L1c:
            r2 = move-exception
            throw r2
        L1e:
            if (r3 != 0) goto L3b
        L20:
            int r2 = com.alibaba.griver.base.common.network.GriverOkHttpTransport.getAuthRequestContext
            int r2 = r2 + 115
            int r3 = r2 % 128
            com.alibaba.griver.base.common.network.GriverOkHttpTransport.lookAheadTest = r3
            int r2 = r2 % 2
            r3 = 94
            if (r2 != 0) goto L31
            r2 = 94
            goto L33
        L31:
            r2 = 25
        L33:
            if (r2 == r3) goto L36
            return
        L36:
            int r3 = r3 / 0
            return
        L39:
            r2 = move-exception
            throw r2
        L3b:
            java.util.Set r3 = r3.entrySet()
            java.util.Iterator r3 = r3.iterator()
        L43:
            boolean r0 = r3.hasNext()     // Catch: java.lang.Exception -> L6e
            if (r0 == 0) goto L6d
            int r0 = com.alibaba.griver.base.common.network.GriverOkHttpTransport.lookAheadTest     // Catch: java.lang.Exception -> L6b
            int r0 = r0 + 29
            int r1 = r0 % 128
            com.alibaba.griver.base.common.network.GriverOkHttpTransport.getAuthRequestContext = r1     // Catch: java.lang.Exception -> L6e
            int r0 = r0 % 2
            java.lang.Object r0 = r3.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r2.header(r1, r0)
            goto L43
        L6b:
            r2 = move-exception
            throw r2
        L6d:
            return
        L6e:
            r2 = move-exception
            goto L71
        L70:
            throw r2
        L71:
            goto L70
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.base.common.network.GriverOkHttpTransport.a(okhttp3.Request$Builder, java.util.Map):void");
    }

    public static GriverOkHttpTransport getInstance() {
        GriverOkHttpTransport griverOkHttpTransport;
        int i = getAuthRequestContext + 25;
        lookAheadTest = i % 128;
        if ((i % 2 == 0 ? Typography.quote : 'G') != '\"') {
            griverOkHttpTransport = GriverOkHttpTransportFactory.mInstance;
        } else {
            griverOkHttpTransport = GriverOkHttpTransportFactory.mInstance;
            Object obj = null;
            obj.hashCode();
        }
        int i2 = lookAheadTest + 61;
        getAuthRequestContext = i2 % 128;
        if (!(i2 % 2 == 0)) {
            int i3 = 73 / 0;
            return griverOkHttpTransport;
        }
        return griverOkHttpTransport;
    }

    private static void b(int i, char[] cArr, Object[] objArr) {
        C c = new C();
        char[] cArr2 = new char[cArr.length];
        c.BuiltInFictitiousFunctionClassFactory = 0;
        char[] cArr3 = new char[2];
        while (true) {
            if ((c.BuiltInFictitiousFunctionClassFactory < cArr.length ? (char) 27 : JSONLexer.EOI) == 27) {
                int i2 = $11 + 73;
                $10 = i2 % 128;
                int i3 = i2 % 2;
                cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
                cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory + 1];
                int i4 = 58224;
                int i5 = 0;
                while (true) {
                    if (i5 < 16) {
                        int i6 = $11 + 79;
                        $10 = i6 % 128;
                        int i7 = i6 % 2;
                        cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i4) ^ ((cArr3[0] << 4) + ((char) (PlaceComponentResult ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (BuiltInFictitiousFunctionClassFactory ^ 6353485791441662354L)))));
                        cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i4) ^ ((cArr3[1] << 4) + ((char) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (MyBillsEntityDataFactory ^ 6353485791441662354L)))));
                        i4 -= 40503;
                        i5++;
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
