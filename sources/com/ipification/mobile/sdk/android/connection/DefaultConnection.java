package com.ipification.mobile.sdk.android.connection;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import com.alipay.mobile.security.zim.msgchannel.ZimMessageChannel;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.net.HttpHeaders;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.ipification.mobile.sdk.android.callback.CellularCallback;
import com.ipification.mobile.sdk.android.exception.CellularException;
import com.ipification.mobile.sdk.android.model.ResponseBody;
import com.ipification.mobile.sdk.android.model.SIMOperator;
import com.ipification.mobile.sdk.android.request.API_TYPE;
import com.ipification.mobile.sdk.android.request.AuthRequest;
import com.ipification.mobile.sdk.android.response.AuthResponse;
import com.ipification.mobile.sdk.android.response.CellularResponse;
import com.ipification.mobile.sdk.android.response.CoverageResponse;
import com.ipification.mobile.sdk.android.response.RedirectResponse;
import com.ipification.mobile.sdk.android.ssl.TLSSocketFactory;
import com.ipification.mobile.sdk.android.utils.DeviceUtils;
import com.ipification.mobile.sdk.android.utils.LogUtils;
import com.ipification.mobile.sdk.android.utils.NetworkUtils;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.data.here.HereOauthManager;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.http.conn.ssl.AllowAllHostnameVerifier;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002B-\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\f¢\u0006\u0002\u0010\rB\u0005¢\u0006\u0002\u0010\u000eJ'\u0010\u001d\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u001e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u001f\"\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0002\u0010 J\u0012\u0010!\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010#\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0012\u0010$\u001a\u00020\u00032\b\u0010%\u001a\u0004\u0018\u00010\u0004H\u0014J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0002R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n\u0018\u00010\u0019j\u0004\u0018\u0001`\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/ipification/mobile/sdk/android/connection/DefaultConnection;", "T", "Landroid/os/AsyncTask;", "", "Lcom/ipification/mobile/sdk/android/model/ResponseBody;", "isRedirect", "", HummerConstants.CONTEXT, "Landroid/content/Context;", "request", "Lcom/ipification/mobile/sdk/android/request/AuthRequest;", "cellularCallback", "Lcom/ipification/mobile/sdk/android/callback/CellularCallback;", "(ZLandroid/content/Context;Lcom/ipification/mobile/sdk/android/request/AuthRequest;Lcom/ipification/mobile/sdk/android/callback/CellularCallback;)V", "()V", DanaLogConstants.BizType.DEVICE_INFO, "Lcom/ipification/mobile/sdk/android/utils/DeviceUtils;", "forceCheckRedirect", "getForceCheckRedirect$ipification_auth_release", "()Z", "setForceCheckRedirect$ipification_auth_release", "(Z)V", ZimMessageChannel.K_RPC_RES_CODE, "", "responseException", "Ljava/lang/Exception;", "Lkotlin/Exception;", "url", "Ljava/net/URL;", "doInBackground", "params", "", "([Lkotlin/Unit;)Lcom/ipification/mobile/sdk/android/model/ResponseBody;", "doPostExecute", "responseBody", "makeConnection", "onPostExecute", "result", "readStream", "", "inputStream", "Ljava/io/BufferedInputStream;", "ipification-auth_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class DefaultConnection<T> extends AsyncTask<Unit, Unit, ResponseBody> {
    public boolean BuiltInFictitiousFunctionClassFactory;
    public Context KClassImpl$Data$declaredNonStaticMembers$2;
    public CellularCallback<T> MyBillsEntityDataFactory;
    public AuthRequest NetworkUserEntityData$$ExternalSyntheticLambda0;
    public DeviceUtils PlaceComponentResult;
    public boolean getAuthRequestContext;
    public URL getErrorConfigVersion;
    public int moveToNextValue;
    public Exception scheduleImpl;

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

    public DefaultConnection() {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultConnection(boolean z, Context context, AuthRequest authRequest, CellularCallback<T> cellularCallback) {
        this();
        Intrinsics.checkParameterIsNotNull(context, "");
        Intrinsics.checkParameterIsNotNull(authRequest, "");
        Intrinsics.checkParameterIsNotNull(cellularCallback, "");
        this.getAuthRequestContext = z;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = authRequest;
        this.MyBillsEntityDataFactory = cellularCallback;
        this.PlaceComponentResult = DeviceUtils.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(context);
    }

    @Override // android.os.AsyncTask
    public final ResponseBody doInBackground(Unit[] unitArr) {
        HttpURLConnection httpURLConnection;
        ResponseBody responseBody;
        ResponseBody responseBody2;
        String stringPlus;
        String str;
        URLConnection uRLConnection;
        Intrinsics.checkParameterIsNotNull(unitArr, "");
        AuthRequest authRequest = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (authRequest == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            throw null;
        }
        Context context = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            throw null;
        }
        URL url = new URL(authRequest.PlaceComponentResult(context).toString());
        this.getErrorConfigVersion = url;
        LogUtils.Companion companion = LogUtils.getAuthRequestContext;
        AuthRequest authRequest2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (authRequest2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            throw null;
        }
        Context context2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (context2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            throw null;
        }
        CellularCallback.DefaultImpls.KClassImpl$Data$declaredNonStaticMembers$2(companion, Intrinsics.stringPlus("openConnection ", authRequest2.PlaceComponentResult(context2)));
        boolean z = false;
        HttpsURLConnection.setFollowRedirects(false);
        HttpURLConnection.setFollowRedirects(false);
        try {
            uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(InstrumentInjector.urlconnection_wrapInstance(url.openConnection()));
        } catch (Exception unused) {
            URLConnection uRLConnection2 = (URLConnection) FirebasePerfUrlConnection.instrument(InstrumentInjector.urlconnection_wrapInstance(url.openConnection()));
            if (uRLConnection2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.net.HttpURLConnection");
            }
            httpURLConnection = (HttpURLConnection) uRLConnection2;
        }
        if (uRLConnection != null) {
            httpURLConnection = (HttpsURLConnection) uRLConnection;
            if (httpURLConnection instanceof HttpsURLConnection) {
                HttpsURLConnection.setDefaultHostnameVerifier(new AllowAllHostnameVerifier());
                ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(new TLSSocketFactory());
            }
            AuthRequest authRequest3 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (authRequest3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                throw null;
            }
            httpURLConnection.setReadTimeout((int) authRequest3.NetworkUserEntityData$$ExternalSyntheticLambda2);
            AuthRequest authRequest4 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (authRequest4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                throw null;
            }
            httpURLConnection.setConnectTimeout((int) authRequest4.MyBillsEntityDataFactory);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestProperty("charset", HereOauthManager.ENC);
            httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT, "*/*");
            AuthRequest authRequest5 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (authRequest5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                throw null;
            }
            HashMap<String, String> hashMap = authRequest5.PlaceComponentResult;
            if (hashMap != null && !this.getAuthRequestContext) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }
            AuthRequest authRequest6 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (authRequest6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                throw null;
            }
            authRequest6.getKClassImpl$Data$declaredNonStaticMembers$2();
            if (!this.getAuthRequestContext) {
                AuthRequest authRequest7 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (authRequest7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    throw null;
                } else if (authRequest7.BuiltInFictitiousFunctionClassFactory != API_TYPE.OTHER) {
                    httpURLConnection.setRequestProperty("ip-sdk-version", "2.0.15");
                    httpURLConnection.setRequestProperty("device-type", "android");
                    StringBuilder sb = new StringBuilder();
                    sb.append((Object) Build.MANUFACTURER);
                    sb.append(" - ");
                    sb.append((Object) Build.MODEL);
                    httpURLConnection.setRequestProperty("device-name", sb.toString());
                    httpURLConnection.setRequestProperty("os-version", Build.VERSION.RELEASE);
                    httpURLConnection.setRequestProperty("os-sdk", String.valueOf(Build.VERSION.SDK_INT));
                    AuthRequest authRequest8 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    if (authRequest8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        throw null;
                    } else if (authRequest8.getKClassImpl$Data$declaredNonStaticMembers$2()) {
                        DeviceUtils deviceUtils = this.PlaceComponentResult;
                        if (deviceUtils == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            throw null;
                        }
                        boolean MyBillsEntityDataFactory = deviceUtils.MyBillsEntityDataFactory();
                        DeviceUtils deviceUtils2 = this.PlaceComponentResult;
                        if (deviceUtils2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            throw null;
                        }
                        SIMOperator authRequestContext = deviceUtils2.getAuthRequestContext();
                        httpURLConnection.setRequestProperty("mcc-1", authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2());
                        httpURLConnection.setRequestProperty("mnc-1", authRequestContext.MyBillsEntityDataFactory());
                        httpURLConnection.setRequestProperty("mnc-1-error-msg", authRequestContext.PlaceComponentResult());
                        httpURLConnection.setRequestProperty("dual-sim-phone", MyBillsEntityDataFactory ? "yes" : "no");
                        NetworkUtils.Companion companion2 = NetworkUtils.KClassImpl$Data$declaredNonStaticMembers$2;
                        Context context3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                        if (context3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            throw null;
                        }
                        httpURLConnection.setRequestProperty("wifi-on", NetworkUtils.Companion.MyBillsEntityDataFactory(context3) ? "yes" : "no");
                        if (MyBillsEntityDataFactory) {
                            DeviceUtils deviceUtils3 = this.PlaceComponentResult;
                            if (deviceUtils3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("");
                                throw null;
                            }
                            SIMOperator KClassImpl$Data$declaredNonStaticMembers$2 = deviceUtils3.KClassImpl$Data$declaredNonStaticMembers$2();
                            httpURLConnection.setRequestProperty("mcc-2", KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2());
                            httpURLConnection.setRequestProperty("mnc-2", KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory());
                            httpURLConnection.setRequestProperty("mnc-2-error-msg", KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult());
                            DeviceUtils deviceUtils4 = this.PlaceComponentResult;
                            if (deviceUtils4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("");
                                throw null;
                            }
                            SIMOperator sIMOperator = deviceUtils4.BuiltInFictitiousFunctionClassFactory;
                            String KClassImpl$Data$declaredNonStaticMembers$22 = sIMOperator == null ? null : sIMOperator.KClassImpl$Data$declaredNonStaticMembers$2();
                            if (KClassImpl$Data$declaredNonStaticMembers$22 == null) {
                                DeviceUtils deviceUtils5 = this.PlaceComponentResult;
                                if (deviceUtils5 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("");
                                    throw null;
                                }
                                KClassImpl$Data$declaredNonStaticMembers$22 = deviceUtils5.BuiltInFictitiousFunctionClassFactory().KClassImpl$Data$declaredNonStaticMembers$2();
                            }
                            DeviceUtils deviceUtils6 = this.PlaceComponentResult;
                            if (deviceUtils6 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("");
                                throw null;
                            }
                            SIMOperator sIMOperator2 = deviceUtils6.BuiltInFictitiousFunctionClassFactory;
                            String MyBillsEntityDataFactory2 = sIMOperator2 == null ? null : sIMOperator2.MyBillsEntityDataFactory();
                            if (MyBillsEntityDataFactory2 == null) {
                                DeviceUtils deviceUtils7 = this.PlaceComponentResult;
                                if (deviceUtils7 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("");
                                    throw null;
                                }
                                MyBillsEntityDataFactory2 = deviceUtils7.BuiltInFictitiousFunctionClassFactory().MyBillsEntityDataFactory();
                            }
                            Context context4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                            if (context4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("");
                                throw null;
                            }
                            boolean authRequestContext2 = NetworkUtils.Companion.getAuthRequestContext(context4);
                            stringPlus = Intrinsics.stringPlus(KClassImpl$Data$declaredNonStaticMembers$22, MyBillsEntityDataFactory2);
                            if (!authRequestContext2) {
                                str = "last-active-data-session-sim";
                                httpURLConnection.setRequestProperty(str, stringPlus);
                            }
                        } else {
                            stringPlus = Intrinsics.stringPlus(authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(), authRequestContext.MyBillsEntityDataFactory());
                        }
                        str = "active-data-session-sim";
                        httpURLConnection.setRequestProperty(str, stringPlus);
                    }
                }
            }
            try {
                httpURLConnection.connect();
                LogUtils.Companion companion3 = LogUtils.getAuthRequestContext;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(httpURLConnection.getHeaderFields());
                sb2.append(" - ");
                sb2.append((Object) httpURLConnection.getResponseMessage());
                CellularCallback.DefaultImpls.KClassImpl$Data$declaredNonStaticMembers$2(companion3, sb2.toString());
                this.moveToNextValue = httpURLConnection.getResponseCode();
                if (httpURLConnection.getResponseCode() == 200) {
                    try {
                        try {
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new BufferedInputStream(httpURLConnection.getInputStream())));
                            final StringBuilder sb3 = new StringBuilder();
                            TextStreamsKt.forEachLine(bufferedReader, new Function1<String, Unit>() { // from class: com.ipification.mobile.sdk.android.connection.DefaultConnection$readStream$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(String str2) {
                                    String str3 = str2;
                                    Intrinsics.checkParameterIsNotNull(str3, "");
                                    sb3.append(str3);
                                    return Unit.INSTANCE;
                                }
                            });
                            String obj = sb3.toString();
                            Intrinsics.checkExpressionValueIsNotNull(obj, "");
                            Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                            Intrinsics.checkExpressionValueIsNotNull(headerFields, "");
                            responseBody = new ResponseBody(obj, headerFields);
                        } catch (Throwable th) {
                            httpURLConnection.disconnect();
                            throw th;
                        }
                    } catch (Exception e) {
                        String message = e.getMessage();
                        if (message != null) {
                            CellularCallback.DefaultImpls.getAuthRequestContext(LogUtils.getAuthRequestContext, message);
                        }
                        this.scheduleImpl = e;
                        responseBody = null;
                    }
                    httpURLConnection.disconnect();
                    return responseBody;
                }
                int responseCode = httpURLConnection.getResponseCode();
                if (300 <= responseCode && responseCode <= 310) {
                    z = true;
                }
                if (z) {
                    String headerField = httpURLConnection.getHeaderField("Location");
                    if (headerField == null) {
                        headerField = httpURLConnection.getHeaderField("location");
                    }
                    Map<String, List<String>> headerFields2 = httpURLConnection.getHeaderFields();
                    Intrinsics.checkExpressionValueIsNotNull(headerFields2, "");
                    responseBody2 = new ResponseBody(headerField, headerFields2);
                } else {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(httpURLConnection.getResponseCode());
                    sb4.append(" - ");
                    sb4.append((Object) httpURLConnection.getResponseMessage());
                    String obj2 = sb4.toString();
                    Map<String, List<String>> headerFields3 = httpURLConnection.getHeaderFields();
                    Intrinsics.checkExpressionValueIsNotNull(headerFields3, "");
                    responseBody2 = new ResponseBody(obj2, headerFields3);
                }
                return responseBody2;
            } catch (Exception e2) {
                this.scheduleImpl = e2;
                String message2 = e2.getMessage();
                if (message2 == null) {
                    return null;
                }
                CellularCallback.DefaultImpls.getAuthRequestContext(LogUtils.getAuthRequestContext, message2);
                return null;
            }
        }
        throw new TypeCastException("null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(ResponseBody responseBody) {
        CellularException cellularException;
        CellularCallback<T> cellularCallback;
        ResponseBody responseBody2 = responseBody;
        super.onPostExecute(responseBody2);
        LogUtils.Companion companion = LogUtils.getAuthRequestContext;
        StringBuilder sb = new StringBuilder();
        sb.append("onPostExecute ");
        sb.append(this.moveToNextValue);
        sb.append(InputCardNumberView.DIVIDER);
        sb.append(responseBody2);
        CellularCallback.DefaultImpls.KClassImpl$Data$declaredNonStaticMembers$2(companion, sb.toString());
        String str = responseBody2 == null ? null : responseBody2.BuiltInFictitiousFunctionClassFactory;
        int i = this.moveToNextValue;
        boolean z = false;
        if (300 <= i && i <= 310) {
            if (str != null && StringsKt.startsWith$default(str, SemanticAttributes.FaasTriggerValues.HTTP, false, 2, (Object) null)) {
                AuthRequest authRequest = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (authRequest == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    throw null;
                } else if (!StringsKt.startsWith$default(str, String.valueOf(authRequest.NetworkUserEntityData$$ExternalSyntheticLambda0), false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) str, (CharSequence) "imbox_session_id", false, 2, (Object) null)) {
                    CellularCallback<T> cellularCallback2 = this.MyBillsEntityDataFactory;
                    if (cellularCallback2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        throw null;
                    }
                    int i2 = this.moveToNextValue;
                    AuthRequest authRequest2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    if (authRequest2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        throw null;
                    }
                    API_TYPE api_type = authRequest2.BuiltInFictitiousFunctionClassFactory;
                    if (api_type == null) {
                        Intrinsics.throwNpe();
                    }
                    cellularCallback2.PlaceComponentResult(new RedirectResponse(i2, str, api_type));
                    return;
                }
            }
            if (str != null && StringsKt.startsWith$default(str, SemanticAttributes.FaasTriggerValues.HTTP, false, 2, (Object) null)) {
                AuthRequest authRequest3 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (authRequest3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    throw null;
                } else if (!StringsKt.startsWith$default(str, String.valueOf(authRequest3.NetworkUserEntityData$$ExternalSyntheticLambda0), false, 2, (Object) null) && this.BuiltInFictitiousFunctionClassFactory) {
                    CellularCallback<T> cellularCallback3 = this.MyBillsEntityDataFactory;
                    if (cellularCallback3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        throw null;
                    }
                    int i3 = this.moveToNextValue;
                    AuthRequest authRequest4 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    if (authRequest4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        throw null;
                    }
                    API_TYPE api_type2 = authRequest4.BuiltInFictitiousFunctionClassFactory;
                    if (api_type2 == null) {
                        Intrinsics.throwNpe();
                    }
                    cellularCallback3.PlaceComponentResult(new RedirectResponse(i3, str, api_type2));
                    return;
                }
            }
            if (str != null && StringsKt.startsWith$default(str, "/", false, 2, (Object) null)) {
                StringBuilder sb2 = new StringBuilder();
                URL url = this.getErrorConfigVersion;
                if (url == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    throw null;
                }
                sb2.append(url.getProtocol());
                sb2.append("://");
                URL url2 = this.getErrorConfigVersion;
                if (url2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    throw null;
                }
                sb2.append((Object) url2.getHost());
                sb2.append((Object) str);
                String obj = sb2.toString();
                CellularCallback<T> cellularCallback4 = this.MyBillsEntityDataFactory;
                if (cellularCallback4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    throw null;
                }
                int i4 = this.moveToNextValue;
                AuthRequest authRequest5 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (authRequest5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    throw null;
                }
                API_TYPE api_type3 = authRequest5.BuiltInFictitiousFunctionClassFactory;
                if (api_type3 == null) {
                    Intrinsics.throwNpe();
                }
                cellularCallback4.PlaceComponentResult(new RedirectResponse(i4, obj, api_type3));
                return;
            }
        }
        int i5 = this.moveToNextValue;
        if (!(200 <= i5 && i5 <= 299)) {
            if (300 <= i5 && i5 <= 310) {
                z = true;
            }
            if (!z) {
                cellularException = new CellularException();
                cellularException.getAuthRequestContext = Integer.valueOf(this.moveToNextValue);
                Exception exc = this.scheduleImpl;
                if (exc == null) {
                    if (str == null) {
                        str = Intrinsics.stringPlus("Unspecified Exception with statusCode ", Integer.valueOf(this.moveToNextValue));
                    }
                    exc = new NetworkErrorException(str);
                }
                cellularException.MyBillsEntityDataFactory = exc;
                cellularCallback = this.MyBillsEntityDataFactory;
                if (cellularCallback == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    throw null;
                }
                cellularCallback.BuiltInFictitiousFunctionClassFactory(cellularException);
                return;
            }
        }
        if (str == null) {
            cellularException = new CellularException();
            cellularException.getAuthRequestContext = 500;
            Exception exc2 = this.scheduleImpl;
            if (exc2 == null) {
                exc2 = new NetworkErrorException(Intrinsics.stringPlus("Unspecified Exception with status ", Integer.valueOf(this.moveToNextValue)));
            }
            cellularException.MyBillsEntityDataFactory = exc2;
            cellularCallback = this.MyBillsEntityDataFactory;
            if (cellularCallback == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                throw null;
            }
            cellularCallback.BuiltInFictitiousFunctionClassFactory(cellularException);
            return;
        }
        AuthRequest authRequest6 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (authRequest6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            throw null;
        }
        API_TYPE api_type4 = authRequest6.BuiltInFictitiousFunctionClassFactory;
        int i6 = api_type4 == null ? -1 : WhenMappings.PlaceComponentResult[api_type4.ordinal()];
        CellularResponse cellularResponse = i6 != 1 ? i6 != 2 ? new CellularResponse(200, str) : new AuthResponse(this.moveToNextValue, str, responseBody2.PlaceComponentResult()) : new CoverageResponse(this.moveToNextValue, str);
        CellularCallback<T> cellularCallback5 = this.MyBillsEntityDataFactory;
        if (cellularCallback5 != null) {
            cellularCallback5.PlaceComponentResult(cellularResponse);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
            throw null;
        }
    }
}
