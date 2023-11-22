package id.dana.data.foundation.toolbox;

import android.text.TextUtils;
import com.alibaba.griver.api.common.network.HttpRequest;
import com.alibaba.griver.api.common.network.HttpResponse;
import com.google.common.net.HttpHeaders;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.domain.featureconfig.StartupConfigEntityData;
import id.dana.domain.featureconfig.model.DiagnosticLogConfig;
import id.dana.rum.Rum;
import id.dana.rum.exception.RumInterceptorNullException;
import id.dana.utils.foundation.logger.log.DanaLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.VerifyPinStateManager$executeRiskChallenge$2$2;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.Version;

/* loaded from: classes8.dex */
public class OkHttpUrlTransport implements AbstractHttpTransport {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    private static final String MyBillsEntityDataFactory;
    private static char[] PlaceComponentResult = null;
    private static int scheduleImpl = 1;
    private final OkHttpClient KClassImpl$Data$declaredNonStaticMembers$2;
    private final StartupConfigEntityData getAuthRequestContext;

    static {
        getAuthRequestContext();
        Object[] objArr = new Object[1];
        a(new int[]{0, 50, 0, 0}, false, new byte[]{1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0}, objArr);
        MyBillsEntityDataFactory = ((String) objArr[0]).intern();
        int i = BuiltInFictitiousFunctionClassFactory + 65;
        scheduleImpl = i % 128;
        int i2 = i % 2;
    }

    static void getAuthRequestContext() {
        PlaceComponentResult = new char[]{35498, 35576, 35543, 35543, 35580, 35577, 35577, 35545, 35543, 35580, 35572, 35572, 35545, 35540, 35572, 35564, 35567, 35575, 35580, 35572, 35568, 35570, 35568, 35536, 35535, 35567, 35569, 35571, 35577, 35574, 35565, 35533, 35488, 35523, 35527, 35520, 35562, 35564, 35580, 35581, 35569, 35582, 35581, 35575, 35577, 35566, 35567, 35569, 35566, 35565};
    }

    @Inject
    public OkHttpUrlTransport(OkHttpClient okHttpClient, StartupConfigEntityData startupConfigEntityData) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = okHttpClient;
        this.getAuthRequestContext = startupConfigEntityData;
    }

    @Override // id.dana.data.foundation.toolbox.AbstractHttpTransport
    public final HttpResponse KClassImpl$Data$declaredNonStaticMembers$2(HttpRequest httpRequest) throws Exception {
        Call newCall;
        Map<String, String> authRequestContext = getAuthRequestContext(httpRequest);
        Request.Builder builder = new Request.Builder();
        builder.url(httpRequest.getUrl());
        PlaceComponentResult(authRequestContext, builder);
        BuiltInFictitiousFunctionClassFactory(authRequestContext, builder);
        KClassImpl$Data$declaredNonStaticMembers$2(httpRequest, authRequestContext, builder);
        DiagnosticLogConfig diagnosticLog = this.getAuthRequestContext.getDiagnosticLog();
        Rum.CC.getAuthRequestContext(new Function3() { // from class: id.dana.data.foundation.toolbox.OkHttpUrlTransport$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return OkHttpUrlTransport.BuiltInFictitiousFunctionClassFactory((Boolean) obj, (Boolean) obj2, (Boolean) obj3);
            }
        });
        if (Rum.CC.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2) != null) {
            if (diagnosticLog.getSplunkConfig().getH5NetworkInstrumentation()) {
                int i = BuiltInFictitiousFunctionClassFactory + 13;
                scheduleImpl = i % 128;
                if (i % 2 == 0) {
                    newCall = ((Call.Factory) Objects.requireNonNull(Rum.CC.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2))).newCall(builder.build());
                    int i2 = 67 / 0;
                } else {
                    try {
                        try {
                            newCall = ((Call.Factory) Objects.requireNonNull(Rum.CC.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2))).newCall(builder.build());
                        } catch (Exception e) {
                            throw e;
                        }
                    } catch (Exception e2) {
                        throw e2;
                    }
                }
                int i3 = scheduleImpl + 17;
                BuiltInFictitiousFunctionClassFactory = i3 % 128;
                int i4 = i3 % 2;
                Response execute = FirebasePerfOkHttpClient.execute(newCall);
                MyBillsEntityDataFactory(execute);
                HttpResponse PlaceComponentResult2 = PlaceComponentResult(execute);
                String str = MyBillsEntityDataFactory;
                StringBuilder sb = new StringBuilder();
                sb.append("performRequest response OkHttp=");
                sb.append(httpRequest.getUrl());
                sb.append(PlaceComponentResult2);
                DanaLog.MyBillsEntityDataFactory(str, sb.toString());
                return PlaceComponentResult2;
            }
        }
        Crashlytics BuiltInFictitiousFunctionClassFactory2 = Crashlytics.BuiltInFictitiousFunctionClassFactory();
        RumInterceptorNullException rumInterceptorNullException = new RumInterceptorNullException();
        Intrinsics.checkNotNullParameter(rumInterceptorNullException, "");
        BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext.recordException(rumInterceptorNullException);
        Rum.CC.getAuthRequestContext().MyBillsEntityDataFactory(new RumInterceptorNullException(), new Pair[0]);
        newCall = this.KClassImpl$Data$declaredNonStaticMembers$2.newCall(builder.build());
        Response execute2 = FirebasePerfOkHttpClient.execute(newCall);
        MyBillsEntityDataFactory(execute2);
        HttpResponse PlaceComponentResult22 = PlaceComponentResult(execute2);
        String str2 = MyBillsEntityDataFactory;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("performRequest response OkHttp=");
        sb2.append(httpRequest.getUrl());
        sb2.append(PlaceComponentResult22);
        DanaLog.MyBillsEntityDataFactory(str2, sb2.toString());
        return PlaceComponentResult22;
    }

    public static /* synthetic */ Unit BuiltInFictitiousFunctionClassFactory(Boolean bool, Boolean bool2, Boolean bool3) {
        int i = scheduleImpl + 91;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        Crashlytics BuiltInFictitiousFunctionClassFactory2 = Crashlytics.BuiltInFictitiousFunctionClassFactory();
        String obj = bool.toString();
        Intrinsics.checkNotNullParameter("Is Above API 21", "");
        Intrinsics.checkNotNullParameter(obj, "");
        BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext.setCustomKey("Is Above API 21", obj);
        String obj2 = bool2.toString();
        Intrinsics.checkNotNullParameter("Is Network Instrumentation", "");
        Intrinsics.checkNotNullParameter(obj2, "");
        BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext.setCustomKey("Is Network Instrumentation", obj2);
        String obj3 = bool3.toString();
        Intrinsics.checkNotNullParameter("Is Rum No Op", "");
        Intrinsics.checkNotNullParameter(obj3, "");
        BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext.setCustomKey("Is Rum No Op", obj3);
        int i3 = BuiltInFictitiousFunctionClassFactory + 45;
        scheduleImpl = i3 % 128;
        if (i3 % 2 != 0) {
            return null;
        }
        int i4 = 4 / 0;
        return null;
    }

    private static void PlaceComponentResult(Map<String, String> map, Request.Builder builder) {
        Iterator<String> it = map.keySet().iterator();
        while (true) {
            if ((it.hasNext() ? 'b' : 'S') != 'b') {
                return;
            }
            int i = BuiltInFictitiousFunctionClassFactory + 57;
            scheduleImpl = i % 128;
            int i2 = i % 2;
            String next = it.next();
            getAuthRequestContext(next, map.get(next), builder);
            int i3 = BuiltInFictitiousFunctionClassFactory + 99;
            scheduleImpl = i3 % 128;
            int i4 = i3 % 2;
        }
    }

    private static Map<String, String> getAuthRequestContext(HttpRequest httpRequest) {
        HashMap hashMap = new HashMap();
        PlaceComponentResult(httpRequest.getHeaders(), hashMap);
        int i = scheduleImpl + 45;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if (i % 2 != 0) {
            Object[] objArr = null;
            int length = objArr.length;
            return hashMap;
        }
        return hashMap;
    }

    private static void BuiltInFictitiousFunctionClassFactory(Map<String, String> map, Request.Builder builder) {
        int i = scheduleImpl + 63;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        if ((TextUtils.isEmpty(map.get("Accept-Language")) ? 'B' : '%') != '%') {
            getAuthRequestContext("Accept-Language", MyBillsEntityDataFactory(), builder);
            int i3 = BuiltInFictitiousFunctionClassFactory + 89;
            scheduleImpl = i3 % 128;
            int i4 = i3 % 2;
        }
    }

    private static void PlaceComponentResult(Map<String, String> map, Map<String, String> map2) {
        if (!(map != null)) {
            return;
        }
        int i = BuiltInFictitiousFunctionClassFactory + 89;
        scheduleImpl = i % 128;
        if (i % 2 == 0) {
            boolean isEmpty = map.isEmpty();
            Object obj = null;
            obj.hashCode();
            if ((!isEmpty ? 'D' : 'R') == 'R') {
                return;
            }
        } else if (map.isEmpty()) {
            return;
        }
        Iterator<String> it = map.keySet().iterator();
        while (true) {
            if (!(it.hasNext())) {
                return;
            }
            int i2 = scheduleImpl + 7;
            BuiltInFictitiousFunctionClassFactory = i2 % 128;
            int i3 = i2 % 2;
            String next = it.next();
            if (TextUtils.isEmpty(map2.get(next))) {
                BuiltInFictitiousFunctionClassFactory(next, map.get(next), map2);
            }
        }
    }

    private static void BuiltInFictitiousFunctionClassFactory(String str, String str2, Map<String, String> map) {
        int i = BuiltInFictitiousFunctionClassFactory + 69;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        try {
            if ((str.equalsIgnoreCase("Content-Type") ? Typography.quote : (char) 11) == 11) {
                if (str.equalsIgnoreCase(HttpHeaders.USER_AGENT)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    sb.append(" ");
                    sb.append(Version.userAgent());
                    str2 = sb.toString();
                    int i3 = scheduleImpl + 121;
                    BuiltInFictitiousFunctionClassFactory = i3 % 128;
                    int i4 = i3 % 2;
                }
            } else {
                int i5 = scheduleImpl + 35;
                BuiltInFictitiousFunctionClassFactory = i5 % 128;
                int i6 = i5 % 2;
                str = "Content-Type";
            }
            map.put(str, str2);
        } catch (Exception e) {
            throw e;
        }
    }

    private static void getAuthRequestContext(String str, String str2, Request.Builder builder) {
        try {
            int i = scheduleImpl + 21;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            builder.addHeader(str, str2);
            int i3 = scheduleImpl + 111;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0025, code lost:
    
        if ((r0 ? '1' : kotlin.text.Typography.dollar) != '$') goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0041, code lost:
    
        if ((java.util.Locale.getDefault().toString().endsWith("ID") ? '8' : '\b') != '\b') goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0043, code lost:
    
        r0 = "id_ID";
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0046, code lost:
    
        r0 = "en_US";
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String MyBillsEntityDataFactory() {
        /*
            int r0 = id.dana.data.foundation.toolbox.OkHttpUrlTransport.scheduleImpl
            r1 = 1
            int r0 = r0 + r1
            int r2 = r0 % 128
            id.dana.data.foundation.toolbox.OkHttpUrlTransport.BuiltInFictitiousFunctionClassFactory = r2
            int r0 = r0 % 2
            r2 = 0
            java.lang.String r3 = "ID"
            if (r0 == 0) goto L2c
            java.util.Locale r0 = java.util.Locale.getDefault()     // Catch: java.lang.Exception -> L2a
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L2a
            boolean r0 = r0.endsWith(r3)     // Catch: java.lang.Exception -> L2a
            int r3 = r2.length     // Catch: java.lang.Throwable -> L28
            r3 = 36
            if (r0 == 0) goto L23
            r0 = 49
            goto L25
        L23:
            r0 = 36
        L25:
            if (r0 == r3) goto L46
            goto L43
        L28:
            r0 = move-exception
            throw r0
        L2a:
            r0 = move-exception
            throw r0
        L2c:
            java.util.Locale r0 = java.util.Locale.getDefault()
            java.lang.String r0 = r0.toString()
            boolean r0 = r0.endsWith(r3)
            r3 = 8
            if (r0 == 0) goto L3f
            r0 = 56
            goto L41
        L3f:
            r0 = 8
        L41:
            if (r0 == r3) goto L46
        L43:
            java.lang.String r0 = "id_ID"
            goto L48
        L46:
            java.lang.String r0 = "en_US"
        L48:
            int r3 = id.dana.data.foundation.toolbox.OkHttpUrlTransport.scheduleImpl
            int r3 = r3 + 101
            int r4 = r3 % 128
            id.dana.data.foundation.toolbox.OkHttpUrlTransport.BuiltInFictitiousFunctionClassFactory = r4
            int r3 = r3 % 2
            if (r3 == 0) goto L56
            r3 = 0
            goto L57
        L56:
            r3 = 1
        L57:
            if (r3 == r1) goto L5d
            int r1 = r2.length     // Catch: java.lang.Throwable -> L5b
            return r0
        L5b:
            r0 = move-exception
            throw r0
        L5d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.foundation.toolbox.OkHttpUrlTransport.MyBillsEntityDataFactory():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x0023, code lost:
    
        if (r1 != null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x003d, code lost:
    
        if ((r4.body() != null ? 18 : '.') != '.') goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x003f, code lost:
    
        r1 = id.dana.data.foundation.toolbox.OkHttpUrlTransport.BuiltInFictitiousFunctionClassFactory + 13;
        id.dana.data.foundation.toolbox.OkHttpUrlTransport.scheduleImpl = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0049, code lost:
    
        if ((r1 % 2) != 0) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x004b, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x004d, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x004e, code lost:
    
        if (r1 == false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0050, code lost:
    
        r1 = r4.body().byteStream();
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0058, code lost:
    
        r2 = r2.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0059, code lost:
    
        r2 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x005d, code lost:
    
        r2 = r4.body().byteStream();
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0068, code lost:
    
        r1 = id.dana.data.foundation.toolbox.OkHttpUrlTransport.scheduleImpl + 109;
        id.dana.data.foundation.toolbox.OkHttpUrlTransport.BuiltInFictitiousFunctionClassFactory = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0070, code lost:
    
        r1 = new com.alibaba.griver.api.common.network.HttpResponse();
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0075, code lost:
    
        r1.setHeaders(r0);
        r1.setStatusCode(r4.code());
        r1.setInputStream(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0082, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0083, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0084, code lost:
    
        throw r4;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v9, types: [com.alibaba.griver.api.common.network.HttpResponse] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.alibaba.griver.api.common.network.HttpResponse PlaceComponentResult(okhttp3.Response r4) {
        /*
            int r0 = id.dana.data.foundation.toolbox.OkHttpUrlTransport.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 99
            int r1 = r0 % 128
            id.dana.data.foundation.toolbox.OkHttpUrlTransport.scheduleImpl = r1
            int r0 = r0 % 2
            r1 = 88
            if (r0 != 0) goto L11
            r0 = 14
            goto L13
        L11:
            r0 = 88
        L13:
            r2 = 0
            if (r0 == r1) goto L28
            okhttp3.Headers r0 = r4.headers()
            java.util.Map r0 = r0.toMultimap()
            okhttp3.ResponseBody r1 = r4.body()
            int r3 = r2.length     // Catch: java.lang.Throwable -> L26
            if (r1 == 0) goto L66
            goto L3f
        L26:
            r4 = move-exception
            throw r4
        L28:
            okhttp3.Headers r0 = r4.headers()
            java.util.Map r0 = r0.toMultimap()
            okhttp3.ResponseBody r1 = r4.body()
            r3 = 46
            if (r1 == 0) goto L3b
            r1 = 18
            goto L3d
        L3b:
            r1 = 46
        L3d:
            if (r1 == r3) goto L66
        L3f:
            int r1 = id.dana.data.foundation.toolbox.OkHttpUrlTransport.BuiltInFictitiousFunctionClassFactory
            int r1 = r1 + 13
            int r3 = r1 % 128
            id.dana.data.foundation.toolbox.OkHttpUrlTransport.scheduleImpl = r3
            int r1 = r1 % 2
            if (r1 != 0) goto L4d
            r1 = 1
            goto L4e
        L4d:
            r1 = 0
        L4e:
            if (r1 == 0) goto L5d
            okhttp3.ResponseBody r1 = r4.body()
            java.io.InputStream r1 = r1.byteStream()
            int r2 = r2.length     // Catch: java.lang.Throwable -> L5b
            r2 = r1
            goto L70
        L5b:
            r4 = move-exception
            throw r4
        L5d:
            okhttp3.ResponseBody r1 = r4.body()
            java.io.InputStream r2 = r1.byteStream()
            goto L70
        L66:
            int r1 = id.dana.data.foundation.toolbox.OkHttpUrlTransport.scheduleImpl     // Catch: java.lang.Exception -> L83
            int r1 = r1 + 109
            int r3 = r1 % 128
            id.dana.data.foundation.toolbox.OkHttpUrlTransport.BuiltInFictitiousFunctionClassFactory = r3
            int r1 = r1 % 2
        L70:
            com.alibaba.griver.api.common.network.HttpResponse r1 = new com.alibaba.griver.api.common.network.HttpResponse
            r1.<init>()
            r1.setHeaders(r0)     // Catch: java.lang.Exception -> L83
            int r4 = r4.code()     // Catch: java.lang.Exception -> L83
            r1.setStatusCode(r4)     // Catch: java.lang.Exception -> L83
            r1.setInputStream(r2)     // Catch: java.lang.Exception -> L83
            return r1
        L83:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.foundation.toolbox.OkHttpUrlTransport.PlaceComponentResult(okhttp3.Response):com.alibaba.griver.api.common.network.HttpResponse");
    }

    private static void KClassImpl$Data$declaredNonStaticMembers$2(HttpRequest httpRequest, Map<String, String> map, Request.Builder builder) {
        if ((!TextUtils.isEmpty(httpRequest.getMethod()) ? '(' : 'H') != 'H') {
            try {
                try {
                    if ((!TextUtils.equals(httpRequest.getMethod(), "GET") ? 'B' : '#') != '#') {
                        if ((TextUtils.equals(httpRequest.getMethod(), "POST") ? '=' : 'a') != '=') {
                            return;
                        }
                        String str = map.get("Content-Type");
                        if (TextUtils.isEmpty(str)) {
                            int i = BuiltInFictitiousFunctionClassFactory + 109;
                            scheduleImpl = i % 128;
                            if (i % 2 == 0) {
                                int i2 = 99 / 0;
                            }
                            str = "application/x-www-form-urlencoded";
                        }
                        builder.post(RequestBody.create(MediaType.parse(str), new String(httpRequest.getRequestData())));
                        return;
                    }
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        builder.get();
        int i3 = scheduleImpl + 101;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        int i4 = i3 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x001a, code lost:
    
        if (r2.isEmpty() != false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0064, code lost:
    
        if (r2 != false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x006d, code lost:
    
        if (r1.isEmpty() != false) goto L61;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void MyBillsEntityDataFactory(okhttp3.Response r6) {
        /*
            android.webkit.CookieManager r0 = android.webkit.CookieManager.getInstance()
            r1 = 1
            r0.setAcceptCookie(r1)
            java.lang.String r2 = "Set-Cookie"
            java.lang.String r2 = r6.header(r2)
            if (r2 == 0) goto L11
            r1 = 0
        L11:
            java.lang.String r3 = ""
            if (r1 == 0) goto L16
            goto L1c
        L16:
            boolean r1 = r2.isEmpty()     // Catch: java.lang.Exception -> Laa
            if (r1 == 0) goto L37
        L1c:
            id.dana.analytics.firebase.Crashlytics r1 = id.dana.analytics.firebase.Crashlytics.BuiltInFictitiousFunctionClassFactory()
            java.lang.String r4 = "CookieValue is empty"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r3)
            com.google.firebase.crashlytics.FirebaseCrashlytics r5 = r1.getAuthRequestContext
            r5.log(r4)
            id.dana.data.security.CookieNullThrowable r4 = new id.dana.data.security.CookieNullThrowable
            r4.<init>()
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r3)
            com.google.firebase.crashlytics.FirebaseCrashlytics r1 = r1.getAuthRequestContext
            r1.recordException(r4)
        L37:
            okhttp3.Request r1 = r6.request()
            okhttp3.HttpUrl r1 = r1.url()
            java.net.URL r1 = r1.url()
            java.lang.String r1 = r1.toString()
            r0.setCookie(r1, r2)
            java.lang.String r1 = "Set-Cookie2"
            java.lang.String r1 = r6.header(r1)
            if (r1 == 0) goto L6f
            int r2 = id.dana.data.foundation.toolbox.OkHttpUrlTransport.BuiltInFictitiousFunctionClassFactory
            int r2 = r2 + 83
            int r4 = r2 % 128
            id.dana.data.foundation.toolbox.OkHttpUrlTransport.scheduleImpl = r4
            int r2 = r2 % 2
            if (r2 != 0) goto L69
            boolean r2 = r1.isEmpty()
            r4 = 0
            int r4 = r4.length     // Catch: java.lang.Throwable -> L67
            if (r2 == 0) goto L94
            goto L6f
        L67:
            r6 = move-exception
            throw r6
        L69:
            boolean r2 = r1.isEmpty()
            if (r2 == 0) goto L94
        L6f:
            id.dana.analytics.firebase.Crashlytics r2 = id.dana.analytics.firebase.Crashlytics.BuiltInFictitiousFunctionClassFactory()     // Catch: java.lang.Exception -> Laa
            java.lang.String r4 = "CookieValue2 is empty"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r3)     // Catch: java.lang.Exception -> La8
            com.google.firebase.crashlytics.FirebaseCrashlytics r5 = r2.getAuthRequestContext     // Catch: java.lang.Exception -> La8
            r5.log(r4)     // Catch: java.lang.Exception -> La8
            id.dana.data.security.CookieNullThrowable r4 = new id.dana.data.security.CookieNullThrowable     // Catch: java.lang.Exception -> La8
            r4.<init>()     // Catch: java.lang.Exception -> La8
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r3)     // Catch: java.lang.Exception -> La8
            com.google.firebase.crashlytics.FirebaseCrashlytics r2 = r2.getAuthRequestContext     // Catch: java.lang.Exception -> La8
            r2.recordException(r4)     // Catch: java.lang.Exception -> La8
            int r2 = id.dana.data.foundation.toolbox.OkHttpUrlTransport.scheduleImpl
            int r2 = r2 + 71
            int r3 = r2 % 128
            id.dana.data.foundation.toolbox.OkHttpUrlTransport.BuiltInFictitiousFunctionClassFactory = r3
            int r2 = r2 % 2
        L94:
            okhttp3.Request r6 = r6.request()
            okhttp3.HttpUrl r6 = r6.url()
            java.net.URL r6 = r6.url()
            java.lang.String r6 = r6.toString()
            r0.setCookie(r6, r1)
            return
        La8:
            r6 = move-exception
            throw r6
        Laa:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.foundation.toolbox.OkHttpUrlTransport.MyBillsEntityDataFactory(okhttp3.Response):void");
    }

    private static void a(int[] iArr, boolean z, byte[] bArr, Object[] objArr) {
        int i;
        int i2;
        VerifyPinStateManager$executeRiskChallenge$2$2 verifyPinStateManager$executeRiskChallenge$2$2 = new VerifyPinStateManager$executeRiskChallenge$2$2();
        int i3 = iArr[0];
        int i4 = iArr[1];
        int i5 = iArr[2];
        int i6 = iArr[3];
        char[] cArr = PlaceComponentResult;
        if (cArr != null) {
            int length = cArr.length;
            char[] cArr2 = new char[length];
            int i7 = 0;
            while (i7 < length) {
                int i8 = $10 + 39;
                $11 = i8 % 128;
                if (i8 % 2 == 0) {
                    i2 = i6;
                    cArr2[i7] = (char) (cArr[i7] / 5097613533456403102L);
                    i7 *= 0;
                } else {
                    i2 = i6;
                    cArr2[i7] = (char) (cArr[i7] ^ 5097613533456403102L);
                    i7++;
                }
                i6 = i2;
            }
            i = i6;
            int i9 = $11 + 55;
            $10 = i9 % 128;
            int i10 = i9 % 2;
            cArr = cArr2;
        } else {
            i = i6;
        }
        char[] cArr3 = new char[i4];
        System.arraycopy(cArr, i3, cArr3, 0, i4);
        if (bArr != null) {
            char[] cArr4 = new char[i4];
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            char c = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i4) {
                if ((bArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] == 1 ? '%' : '\n') != '\n') {
                    int i11 = $10 + 3;
                    $11 = i11 % 128;
                    if ((i11 % 2 == 0 ? 'I' : '#') != 'I') {
                        cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) + 1) - c);
                    } else {
                        cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 4) / 0) / c);
                    }
                } else {
                    cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) ((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) - c);
                }
                c = cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
            }
            cArr3 = cArr4;
        }
        if (i > 0) {
            char[] cArr5 = new char[i4];
            try {
                System.arraycopy(cArr3, 0, cArr5, 0, i4);
                int i12 = i4 - i;
                int i13 = i;
                System.arraycopy(cArr5, 0, cArr3, i12, i13);
                System.arraycopy(cArr5, i13, cArr3, 0, i12);
            } catch (Exception e) {
                throw e;
            }
        }
        if (!(!z)) {
            char[] cArr6 = new char[i4];
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            try {
                int i14 = $10 + 37;
                $11 = i14 % 128;
                int i15 = i14 % 2;
                while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i4) {
                    int i16 = $10 + 123;
                    $11 = i16 % 128;
                    int i17 = i16 % 2;
                    cArr6[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = cArr3[(i4 - verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory) - 1];
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                }
                cArr3 = cArr6;
            } catch (Exception e2) {
                throw e2;
            }
        }
        if (i5 > 0) {
            int i18 = $10 + 5;
            $11 = i18 % 128;
            if (i18 % 2 == 0) {
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 1;
            } else {
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            }
            while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i4) {
                cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] - iArr[2]);
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
            }
        }
        objArr[0] = new String(cArr3);
    }
}
