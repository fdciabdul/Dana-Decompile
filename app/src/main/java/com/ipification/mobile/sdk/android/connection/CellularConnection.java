package com.ipification.mobile.sdk.android.connection;

import android.content.Context;
import android.net.Network;
import android.os.Build;
import com.alibaba.wireless.security.SecExceptionCode;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.net.InternetDomainName;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.ipification.mobile.sdk.android.IPConfiguration;
import com.ipification.mobile.sdk.android.NetworkDns;
import com.ipification.mobile.sdk.android.callback.CellularCallback;
import com.ipification.mobile.sdk.android.exception.CellularException;
import com.ipification.mobile.sdk.android.interceptor.HandleRedirectInterceptor;
import com.ipification.mobile.sdk.android.request.API_TYPE;
import com.ipification.mobile.sdk.android.request.AuthRequest;
import com.ipification.mobile.sdk.android.utils.IPConstant;
import com.ipification.mobile.sdk.android.utils.LogUtils;
import id.dana.cashier.view.InputCardNumberView;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B/\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB\u0005¢\u0006\u0002\u0010\fJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0015\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0016\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0010\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!H\u0002R\u000e\u0010\r\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/ipification/mobile/sdk/android/connection/CellularConnection;", "T", "", "request", "Lcom/ipification/mobile/sdk/android/request/AuthRequest;", "callback", "Lcom/ipification/mobile/sdk/android/callback/CellularCallback;", "network", "Landroid/net/Network;", HummerConstants.CONTEXT, "Landroid/content/Context;", "(Lcom/ipification/mobile/sdk/android/request/AuthRequest;Lcom/ipification/mobile/sdk/android/callback/CellularCallback;Landroid/net/Network;Landroid/content/Context;)V", "()V", "authRequest", "cellularCallback", "cookieJar", "Lokhttp3/CookieJar;", "callbackFailed", "", "ex", "Lcom/ipification/mobile/sdk/android/exception/CellularException;", "callbackSuccess", "cellularResponse", "(Ljava/lang/Object;)V", "logInfo", "log", "", "makeConnection", "requestUri", "isRedirect", "", "parseResponse", "response", "Lokhttp3/Response;", "ipification-auth_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class CellularConnection<T> {
    public Network BuiltInFictitiousFunctionClassFactory;
    public AuthRequest KClassImpl$Data$declaredNonStaticMembers$2;
    public final CookieJar MyBillsEntityDataFactory;
    public CellularCallback<T> PlaceComponentResult;
    public Context getAuthRequestContext;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] PlaceComponentResult;

        static {
            API_TYPE.values();
            API_TYPE api_type = API_TYPE.COVERAGE;
            API_TYPE api_type2 = API_TYPE.AUTH;
            PlaceComponentResult = new int[]{2, 1};
        }
    }

    public CellularConnection() {
        this.MyBillsEntityDataFactory = new CookieJar(this) { // from class: com.ipification.mobile.sdk.android.connection.CellularConnection$cookieJar$1

            /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
            public final HashMap<String, ArrayList<Cookie>> PlaceComponentResult = new HashMap<>();
            public final /* synthetic */ CellularConnection<T> getAuthRequestContext;

            {
                this.getAuthRequestContext = this;
            }

            @Override // okhttp3.CookieJar
            public final List<Cookie> loadForRequest(HttpUrl p0) {
                Intrinsics.checkParameterIsNotNull(p0, "");
                CellularConnection.MyBillsEntityDataFactory("\nloadCookieForRequest --- start ---");
                IPConfiguration.Companion companion = IPConfiguration.INSTANCE;
                if (IPConfiguration.Companion.MyBillsEntityDataFactory().getGetValueOfTouchPositionAbsolute()) {
                    for (Map.Entry<String, ArrayList<Cookie>> entry : this.PlaceComponentResult.entrySet()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("load cookie: ");
                        sb.append(entry.getKey());
                        sb.append(InputCardNumberView.DIVIDER);
                        sb.append(entry.getValue().size());
                        CellularConnection.MyBillsEntityDataFactory(sb.toString());
                        Iterator<Cookie> it = entry.getValue().iterator();
                        while (it.hasNext()) {
                            Cookie next = it.next();
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("load cookie info : ");
                            sb2.append((Object) next.name());
                            sb2.append(InputCardNumberView.DIVIDER);
                            sb2.append((Object) next.value());
                            sb2.append(InputCardNumberView.DIVIDER);
                            sb2.append((Object) next.domain());
                            sb2.append(InputCardNumberView.DIVIDER);
                            sb2.append((Object) next.path());
                            sb2.append(InputCardNumberView.DIVIDER);
                            CellularConnection.MyBillsEntityDataFactory(sb2.toString());
                        }
                    }
                }
                String obj = InternetDomainName.from(p0.host()).topPrivateDomain().toString();
                Intrinsics.checkExpressionValueIsNotNull(obj, "");
                IPConfiguration.Companion companion2 = IPConfiguration.INSTANCE;
                if (IPConfiguration.Companion.MyBillsEntityDataFactory().getGetValueOfTouchPositionAbsolute()) {
                    CellularConnection.MyBillsEntityDataFactory(Intrinsics.stringPlus("url.host: ", obj));
                }
                ArrayList<Cookie> arrayList = this.PlaceComponentResult.get(obj);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                if (IPConfiguration.Companion.MyBillsEntityDataFactory().getGetValueOfTouchPositionAbsolute()) {
                    CellularConnection.MyBillsEntityDataFactory(Intrinsics.stringPlus("cookies: ", Integer.valueOf(arrayList.size())));
                }
                if (this.PlaceComponentResult.get(obj) != null) {
                    ArrayList<Cookie> arrayList2 = this.PlaceComponentResult.get(obj);
                    if (arrayList2 == null) {
                        Intrinsics.throwNpe();
                    }
                    Intrinsics.checkExpressionValueIsNotNull(arrayList2, "");
                    ArrayList<Cookie> arrayList3 = arrayList2;
                    CellularConnection.MyBillsEntityDataFactory(Intrinsics.stringPlus("cookieTopDomain: ", Integer.valueOf(arrayList3.size())));
                    CellularConnection.MyBillsEntityDataFactory("check Cookie Path\n");
                    ArrayList arrayList4 = new ArrayList();
                    Iterator<Cookie> it2 = arrayList3.iterator();
                    while (it2.hasNext()) {
                        Cookie next2 = it2.next();
                        IPConfiguration.Companion companion3 = IPConfiguration.INSTANCE;
                        if (IPConfiguration.Companion.MyBillsEntityDataFactory().getGetValueOfTouchPositionAbsolute()) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("url:");
                            sb3.append(p0);
                            sb3.append(InputCardNumberView.DIVIDER);
                            sb3.append((Object) next2.path());
                            CellularConnection.MyBillsEntityDataFactory(sb3.toString());
                        }
                        String obj2 = p0.toString();
                        Intrinsics.checkExpressionValueIsNotNull(obj2, "");
                        String path = next2.path();
                        Intrinsics.checkExpressionValueIsNotNull(path, "");
                        if (StringsKt.contains$default((CharSequence) obj2, (CharSequence) path, false, 2, (Object) null)) {
                            if (IPConfiguration.Companion.MyBillsEntityDataFactory().getGetValueOfTouchPositionAbsolute()) {
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append("validPathCookies: ");
                                sb4.append((Object) next2.path());
                                sb4.append(InputCardNumberView.DIVIDER);
                                sb4.append((Object) next2.value());
                                CellularConnection.MyBillsEntityDataFactory(sb4.toString());
                            }
                            arrayList4.add(next2);
                        } else if (IPConfiguration.Companion.MyBillsEntityDataFactory().getGetValueOfTouchPositionAbsolute()) {
                            CellularConnection.MyBillsEntityDataFactory("invalid PathCookies");
                        }
                    }
                    arrayList.addAll(arrayList4);
                }
                IPConfiguration.Companion companion4 = IPConfiguration.INSTANCE;
                if (IPConfiguration.Companion.MyBillsEntityDataFactory().getGetValueOfTouchPositionAbsolute()) {
                    Iterator<Cookie> it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        Cookie next3 = it3.next();
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("loadCookieForRequest - cookie: ");
                        sb5.append((Object) next3.domain());
                        sb5.append(InputCardNumberView.DIVIDER);
                        sb5.append((Object) next3.name());
                        sb5.append(InputCardNumberView.DIVIDER);
                        sb5.append((Object) next3.value());
                        CellularConnection.MyBillsEntityDataFactory(sb5.toString());
                    }
                }
                CellularConnection.MyBillsEntityDataFactory(Intrinsics.stringPlus("loadCookieForRequest --- end --- ", Integer.valueOf(arrayList.size())));
                return arrayList;
            }

            @Override // okhttp3.CookieJar
            public final void saveFromResponse(HttpUrl p0, List<Cookie> p1) {
                int i;
                int i2;
                String stringPlus;
                Intrinsics.checkParameterIsNotNull(p0, "");
                Intrinsics.checkParameterIsNotNull(p1, "");
                CellularConnection.MyBillsEntityDataFactory(Intrinsics.stringPlus("saveFromResponse --- start --- ", Integer.valueOf(this.PlaceComponentResult.size())));
                ArrayList<Cookie> arrayList = this.PlaceComponentResult.get(p0.host());
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                for (Cookie cookie : p1) {
                    IPConfiguration.Companion companion = IPConfiguration.INSTANCE;
                    if (IPConfiguration.Companion.MyBillsEntityDataFactory().getGetValueOfTouchPositionAbsolute()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("cookie info: ");
                        sb.append((Object) cookie.name());
                        sb.append(InputCardNumberView.DIVIDER);
                        sb.append((Object) cookie.path());
                        sb.append(InputCardNumberView.DIVIDER);
                        sb.append((Object) cookie.value());
                        sb.append(InputCardNumberView.DIVIDER);
                        sb.append((Object) cookie.domain());
                        sb.append(" -- ");
                        sb.append((Object) p0.host());
                        CellularConnection.MyBillsEntityDataFactory(sb.toString());
                    }
                    if (Intrinsics.areEqual(cookie.domain(), p0.host())) {
                        if (IPConfiguration.Companion.MyBillsEntityDataFactory().getGetValueOfTouchPositionAbsolute()) {
                            Iterator<Cookie> it = arrayList.iterator();
                            while (it.hasNext()) {
                                Cookie next = it.next();
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("sameDomainCookies cookie: ");
                                sb2.append((Object) next.domain());
                                sb2.append(InputCardNumberView.DIVIDER);
                                sb2.append((Object) next.name());
                                CellularConnection.MyBillsEntityDataFactory(sb2.toString());
                            }
                        }
                        Iterator<Cookie> it2 = arrayList.iterator();
                        int i3 = 0;
                        while (true) {
                            if (!it2.hasNext()) {
                                i = -1;
                                break;
                            } else if (Intrinsics.areEqual(it2.next().name(), cookie.name())) {
                                i = i3;
                                break;
                            } else {
                                i3++;
                            }
                        }
                        IPConfiguration.Companion companion2 = IPConfiguration.INSTANCE;
                        if (IPConfiguration.Companion.MyBillsEntityDataFactory().getGetValueOfTouchPositionAbsolute()) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("same cookie domain: ");
                            sb3.append((Object) cookie.name());
                            sb3.append(InputCardNumberView.DIVIDER);
                            sb3.append((Object) cookie.domain());
                            sb3.append(" -- ");
                            sb3.append(i);
                            CellularConnection.MyBillsEntityDataFactory(sb3.toString());
                        }
                        if (i >= 0) {
                            if (IPConfiguration.Companion.MyBillsEntityDataFactory().getGetValueOfTouchPositionAbsolute()) {
                                CellularConnection.MyBillsEntityDataFactory(Intrinsics.stringPlus("override before: ", Integer.valueOf(arrayList.size())));
                            }
                            arrayList.set(i, cookie);
                            if (IPConfiguration.Companion.MyBillsEntityDataFactory().getGetValueOfTouchPositionAbsolute()) {
                                CellularConnection.MyBillsEntityDataFactory(Intrinsics.stringPlus("override after: ", Integer.valueOf(arrayList.size())));
                            }
                        } else {
                            arrayList.add(cookie);
                        }
                    } else {
                        ArrayList<Cookie> arrayList2 = this.PlaceComponentResult.get(cookie.domain());
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList<>();
                        }
                        if (IPConfiguration.Companion.MyBillsEntityDataFactory().getGetValueOfTouchPositionAbsolute()) {
                            Iterator<Cookie> it3 = arrayList2.iterator();
                            while (it3.hasNext()) {
                                Cookie next2 = it3.next();
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append("root domain cookie: ");
                                sb4.append((Object) next2.domain());
                                sb4.append(InputCardNumberView.DIVIDER);
                                sb4.append((Object) next2.name());
                                CellularConnection.MyBillsEntityDataFactory(sb4.toString());
                            }
                        }
                        IPConfiguration.Companion companion3 = IPConfiguration.INSTANCE;
                        if (IPConfiguration.Companion.MyBillsEntityDataFactory().getGetValueOfTouchPositionAbsolute()) {
                            CellularConnection.MyBillsEntityDataFactory(Intrinsics.stringPlus("root domain dmCookies: ", Integer.valueOf(arrayList2.size())));
                        }
                        Iterator<Cookie> it4 = arrayList2.iterator();
                        int i4 = 0;
                        while (true) {
                            if (!it4.hasNext()) {
                                i2 = -1;
                                break;
                            }
                            Cookie next3 = it4.next();
                            if (Intrinsics.areEqual(next3.name(), cookie.name()) && Intrinsics.areEqual(next3.domain(), cookie.domain())) {
                                i2 = i4;
                                break;
                            }
                            i4++;
                        }
                        IPConfiguration.Companion companion4 = IPConfiguration.INSTANCE;
                        if (IPConfiguration.Companion.MyBillsEntityDataFactory().getGetValueOfTouchPositionAbsolute()) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("root domain: ");
                            sb5.append((Object) cookie.name());
                            sb5.append(InputCardNumberView.DIVIDER);
                            sb5.append((Object) cookie.domain());
                            sb5.append(" -- ");
                            sb5.append(i2);
                            CellularConnection.MyBillsEntityDataFactory(sb5.toString());
                        }
                        if (i2 >= 0) {
                            if (IPConfiguration.Companion.MyBillsEntityDataFactory().getGetValueOfTouchPositionAbsolute()) {
                                CellularConnection.MyBillsEntityDataFactory(Intrinsics.stringPlus("override before: ", Integer.valueOf(arrayList2.size())));
                            }
                            arrayList2.set(i2, cookie);
                            if (IPConfiguration.Companion.MyBillsEntityDataFactory().getGetValueOfTouchPositionAbsolute()) {
                                stringPlus = Intrinsics.stringPlus("override after: ", Integer.valueOf(arrayList2.size()));
                                CellularConnection.MyBillsEntityDataFactory(stringPlus);
                            }
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("saveFromResponse - topDomainCookies: ");
                            sb6.append((Object) cookie.domain());
                            sb6.append(InputCardNumberView.DIVIDER);
                            sb6.append(arrayList2.size());
                            sb6.append('\n');
                            CellularConnection.MyBillsEntityDataFactory(sb6.toString());
                            HashMap<String, ArrayList<Cookie>> hashMap = this.PlaceComponentResult;
                            String domain = cookie.domain();
                            Intrinsics.checkExpressionValueIsNotNull(domain, "");
                            hashMap.put(domain, arrayList2);
                        } else {
                            arrayList2.add(cookie);
                            if (IPConfiguration.Companion.MyBillsEntityDataFactory().getGetValueOfTouchPositionAbsolute()) {
                                stringPlus = Intrinsics.stringPlus("add new: ", Integer.valueOf(arrayList2.size()));
                                CellularConnection.MyBillsEntityDataFactory(stringPlus);
                            }
                            StringBuilder sb62 = new StringBuilder();
                            sb62.append("saveFromResponse - topDomainCookies: ");
                            sb62.append((Object) cookie.domain());
                            sb62.append(InputCardNumberView.DIVIDER);
                            sb62.append(arrayList2.size());
                            sb62.append('\n');
                            CellularConnection.MyBillsEntityDataFactory(sb62.toString());
                            HashMap<String, ArrayList<Cookie>> hashMap2 = this.PlaceComponentResult;
                            String domain2 = cookie.domain();
                            Intrinsics.checkExpressionValueIsNotNull(domain2, "");
                            hashMap2.put(domain2, arrayList2);
                        }
                    }
                }
                StringBuilder sb7 = new StringBuilder();
                sb7.append("saveFromResponse - sameDomainCookies: ");
                sb7.append(arrayList.size());
                sb7.append('\n');
                CellularConnection.MyBillsEntityDataFactory(sb7.toString());
                HashMap<String, ArrayList<Cookie>> hashMap3 = this.PlaceComponentResult;
                String host = p0.host();
                Intrinsics.checkExpressionValueIsNotNull(host, "");
                hashMap3.put(host, arrayList);
                IPConfiguration.Companion companion5 = IPConfiguration.INSTANCE;
                if (IPConfiguration.Companion.MyBillsEntityDataFactory().getGetValueOfTouchPositionAbsolute()) {
                    for (Map.Entry<String, ArrayList<Cookie>> entry : this.PlaceComponentResult.entrySet()) {
                        IPConfiguration.Companion companion6 = IPConfiguration.INSTANCE;
                        if (IPConfiguration.Companion.MyBillsEntityDataFactory().getGetValueOfTouchPositionAbsolute()) {
                            StringBuilder sb8 = new StringBuilder();
                            sb8.append("print saved cookie: ");
                            sb8.append(entry.getKey());
                            sb8.append(InputCardNumberView.DIVIDER);
                            sb8.append(entry.getValue().size());
                            CellularConnection.MyBillsEntityDataFactory(sb8.toString());
                            Iterator<Cookie> it5 = entry.getValue().iterator();
                            while (it5.hasNext()) {
                                Cookie next4 = it5.next();
                                StringBuilder sb9 = new StringBuilder();
                                sb9.append("print saved cookie info : ");
                                sb9.append((Object) next4.name());
                                sb9.append(InputCardNumberView.DIVIDER);
                                sb9.append((Object) next4.value());
                                sb9.append(InputCardNumberView.DIVIDER);
                                sb9.append((Object) next4.domain());
                                sb9.append(InputCardNumberView.DIVIDER);
                                sb9.append((Object) next4.path());
                                sb9.append(InputCardNumberView.DIVIDER);
                                CellularConnection.MyBillsEntityDataFactory(sb9.toString());
                            }
                        }
                    }
                }
                CellularConnection.MyBillsEntityDataFactory(Intrinsics.stringPlus("saveFromResponse --- end --- ", Integer.valueOf(this.PlaceComponentResult.size())));
            }
        };
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CellularConnection(AuthRequest authRequest, CellularCallback<T> cellularCallback, Network network, Context context) {
        this();
        Intrinsics.checkParameterIsNotNull(authRequest, "");
        Intrinsics.checkParameterIsNotNull(cellularCallback, "");
        Intrinsics.checkParameterIsNotNull(context, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = authRequest;
        this.PlaceComponentResult = cellularCallback;
        this.BuiltInFictitiousFunctionClassFactory = network;
        this.getAuthRequestContext = context;
    }

    /* JADX WARN: Code restructure failed: missing block: B:112:0x00f1, code lost:
    
        if (r7 != null) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0079, code lost:
    
        if (r7 == null) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0085, code lost:
    
        if (r7 == null) goto L114;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12, types: [com.ipification.mobile.sdk.android.response.CoverageResponse] */
    /* JADX WARN: Type inference failed for: r1v16, types: [com.ipification.mobile.sdk.android.response.CellularResponse] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void getAuthRequestContext(com.ipification.mobile.sdk.android.connection.CellularConnection r6, okhttp3.Response r7) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ipification.mobile.sdk.android.connection.CellularConnection.getAuthRequestContext(com.ipification.mobile.sdk.android.connection.CellularConnection, okhttp3.Response):void");
    }

    public final void BuiltInFictitiousFunctionClassFactory(CellularException cellularException) {
        StringBuilder sb = new StringBuilder();
        sb.append("callbackFailed:");
        sb.append(cellularException.getAuthRequestContext);
        sb.append("  ");
        sb.append((Object) cellularException.PlaceComponentResult);
        sb.append(InputCardNumberView.DIVIDER);
        sb.append(cellularException.PlaceComponentResult());
        MyBillsEntityDataFactory(sb.toString());
        CellularCallback<T> cellularCallback = this.PlaceComponentResult;
        if (cellularCallback != null) {
            cellularCallback.BuiltInFictitiousFunctionClassFactory(cellularException);
        }
        this.PlaceComponentResult = null;
    }

    public static void MyBillsEntityDataFactory(String str) {
        Intrinsics.stringPlus("[CellularConnection]: ", str);
        IPConfiguration.Companion companion = IPConfiguration.INSTANCE;
        if (IPConfiguration.Companion.MyBillsEntityDataFactory().getCom.alibaba.griver.image.photo.utils.DiskFormatter.B java.lang.String()) {
            IPConstant.Companion companion2 = IPConstant.INSTANCE;
            IPConstant PlaceComponentResult = IPConstant.Companion.PlaceComponentResult();
            StringBuilder sb = new StringBuilder();
            sb.append(PlaceComponentResult.DatabaseTableConfigUtil);
            sb.append("[CellularConnection]: ");
            LogUtils.Companion companion3 = LogUtils.getAuthRequestContext;
            sb.append(LogUtils.Companion.MyBillsEntityDataFactory());
            sb.append(" - ");
            sb.append(str);
            sb.append('\n');
            String obj = sb.toString();
            Intrinsics.checkParameterIsNotNull(obj, "");
            PlaceComponentResult.DatabaseTableConfigUtil = obj;
        }
    }

    public final void getAuthRequestContext(final String str, boolean z) {
        OkHttpClient.Builder addNetworkInterceptor;
        Intrinsics.checkParameterIsNotNull(str, "");
        MyBillsEntityDataFactory(Intrinsics.stringPlus("request Url: ", str));
        IPConfiguration.Companion companion = IPConfiguration.INSTANCE;
        IPConfiguration MyBillsEntityDataFactory = IPConfiguration.Companion.MyBillsEntityDataFactory();
        Intrinsics.checkParameterIsNotNull(str, "");
        MyBillsEntityDataFactory.C = str;
        if (this.BuiltInFictitiousFunctionClassFactory != null && Build.VERSION.SDK_INT >= 21) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            InstrumentInjector.okhttp_addInterceptors(builder);
            Context context = this.getAuthRequestContext;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                throw null;
            }
            AuthRequest authRequest = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (authRequest == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                throw null;
            }
            String valueOf = String.valueOf(authRequest.NetworkUserEntityData$$ExternalSyntheticLambda0);
            AuthRequest authRequest2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (authRequest2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                throw null;
            }
            OkHttpClient.Builder addNetworkInterceptor2 = builder.addNetworkInterceptor(new HandleRedirectInterceptor(context, str, valueOf, Boolean.valueOf(authRequest2.getKClassImpl$Data$declaredNonStaticMembers$2()), this.PlaceComponentResult));
            Network network = this.BuiltInFictitiousFunctionClassFactory;
            if (network == null) {
                Intrinsics.throwNpe();
            }
            addNetworkInterceptor = addNetworkInterceptor2.socketFactory(network.getSocketFactory());
        } else {
            OkHttpClient.Builder builder2 = new OkHttpClient.Builder();
            InstrumentInjector.okhttp_addInterceptors(builder2);
            Context context2 = this.getAuthRequestContext;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                throw null;
            }
            AuthRequest authRequest3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (authRequest3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                throw null;
            }
            String valueOf2 = String.valueOf(authRequest3.NetworkUserEntityData$$ExternalSyntheticLambda0);
            AuthRequest authRequest4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (authRequest4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                throw null;
            }
            addNetworkInterceptor = builder2.addNetworkInterceptor(new HandleRedirectInterceptor(context2, str, valueOf2, Boolean.valueOf(authRequest4.getKClassImpl$Data$declaredNonStaticMembers$2()), this.PlaceComponentResult));
        }
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            NetworkDns PlaceComponentResult = NetworkDns.PlaceComponentResult();
            PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2 = this.BuiltInFictitiousFunctionClassFactory;
            CellularCallback.DefaultImpls.KClassImpl$Data$declaredNonStaticMembers$2(LogUtils.getAuthRequestContext, "enable network specific dns lookup");
            addNetworkInterceptor.dns(PlaceComponentResult);
        }
        addNetworkInterceptor.cookieJar(this.MyBillsEntityDataFactory);
        AuthRequest authRequest5 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (authRequest5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            throw null;
        }
        MyBillsEntityDataFactory(Intrinsics.stringPlus("connectTimeout ", Long.valueOf(authRequest5.MyBillsEntityDataFactory)));
        AuthRequest authRequest6 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (authRequest6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            throw null;
        }
        MyBillsEntityDataFactory(Intrinsics.stringPlus("readTimeout ", Long.valueOf(authRequest6.NetworkUserEntityData$$ExternalSyntheticLambda2)));
        AuthRequest authRequest7 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (authRequest7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            throw null;
        }
        long j = authRequest7.MyBillsEntityDataFactory;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        addNetworkInterceptor.connectTimeout(j, timeUnit);
        AuthRequest authRequest8 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (authRequest8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            throw null;
        }
        addNetworkInterceptor.readTimeout(authRequest8.NetworkUserEntityData$$ExternalSyntheticLambda2, timeUnit);
        OkHttpClient build = addNetworkInterceptor.build();
        Request.Builder builder3 = new Request.Builder();
        builder3.url(str);
        if (!z) {
            AuthRequest authRequest9 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (authRequest9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                throw null;
            }
            HashMap<String, String> hashMap = authRequest9.PlaceComponentResult;
            if (hashMap != null) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    builder3.header(entry.getKey(), entry.getValue());
                }
            }
        }
        Request build2 = builder3.build();
        Intrinsics.checkExpressionValueIsNotNull(build2, "");
        FirebasePerfOkHttpClient.enqueue(build.newCall(build2), new Callback(this) { // from class: com.ipification.mobile.sdk.android.connection.CellularConnection$makeConnection$1
            public final /* synthetic */ CellularConnection<T> PlaceComponentResult;

            {
                this.PlaceComponentResult = this;
            }

            @Override // okhttp3.Callback
            public final void onFailure(Call p0, IOException p1) {
                Intrinsics.checkParameterIsNotNull(p0, "");
                Intrinsics.checkParameterIsNotNull(p1, "");
                CellularConnection.MyBillsEntityDataFactory(Intrinsics.stringPlus("onFailure: ", p1.getMessage()));
                CellularException cellularException = new CellularException();
                IPConfiguration.Companion companion2 = IPConfiguration.INSTANCE;
                cellularException.BuiltInFictitiousFunctionClassFactory = IPConfiguration.Companion.MyBillsEntityDataFactory().C;
                cellularException.MyBillsEntityDataFactory = p1;
                cellularException.getAuthRequestContext = Integer.valueOf((int) SecExceptionCode.SEC_ERROR_PKG_VALID_NO_MEMORY);
                this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(cellularException);
            }

            @Override // okhttp3.Callback
            public final void onResponse(Call p0, Response p1) {
                Intrinsics.checkParameterIsNotNull(p0, "");
                Intrinsics.checkParameterIsNotNull(p1, "");
                if (p1.isRedirect()) {
                    String header = p1.header("Location");
                    if (header == null) {
                        header = p1.header("location");
                    }
                    if (header != null && StringsKt.startsWith$default(header, SemanticAttributes.FaasTriggerValues.HTTP, false, 2, (Object) null)) {
                        AuthRequest authRequest10 = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
                        if (authRequest10 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            throw null;
                        } else if (!StringsKt.startsWith$default(header, String.valueOf(authRequest10.NetworkUserEntityData$$ExternalSyntheticLambda0), false, 2, (Object) null)) {
                            CellularConnection.MyBillsEntityDataFactory(Intrinsics.stringPlus("redirect ", header));
                            this.PlaceComponentResult.getAuthRequestContext(header, true);
                            return;
                        }
                    }
                    CellularConnection.MyBillsEntityDataFactory("no location");
                }
                try {
                    CellularConnection.getAuthRequestContext(this.PlaceComponentResult, p1);
                } catch (ClassCastException e) {
                    CellularException cellularException = new CellularException();
                    cellularException.getAuthRequestContext = Integer.valueOf((int) SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM);
                    cellularException.BuiltInFictitiousFunctionClassFactory = str;
                    StringBuilder sb = new StringBuilder();
                    sb.append("invalid callback type. (");
                    sb.append((Object) e.getLocalizedMessage());
                    sb.append(')');
                    cellularException.MyBillsEntityDataFactory = new Exception(sb.toString());
                    this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(cellularException);
                }
            }
        });
    }
}
