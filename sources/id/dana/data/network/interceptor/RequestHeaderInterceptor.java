package id.dana.data.network.interceptor;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.alipay.iap.android.lbs.LBSLocation;
import com.google.common.net.HttpHeaders;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.huawei.hms.framework.common.ContainerUtils;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.foundation.facade.SecurityGuardFacade;
import id.dana.data.foundation.utils.CommonUtil;
import id.dana.data.foundation.utils.CookieUtil;
import id.dana.data.globalnetwork.source.local.UserLocation;
import id.dana.data.security.SecureString;
import id.dana.lib.gcontainer.util.UserAgentFactory;
import id.dana.utils.foundation.facede.LbsFacade;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import javax.inject.Inject;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Version;
import okio.Buffer;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class RequestHeaderInterceptor implements Interceptor {
    private final SecurityGuardFacade BuiltInFictitiousFunctionClassFactory;
    private final Context KClassImpl$Data$declaredNonStaticMembers$2;
    private final AccountEntityDataFactory MyBillsEntityDataFactory;
    private final UserLocation PlaceComponentResult;
    private final ApSecurityFacade getAuthRequestContext;

    @Inject
    public RequestHeaderInterceptor(SecurityGuardFacade securityGuardFacade, ApSecurityFacade apSecurityFacade, Context context, UserLocation userLocation, AccountEntityDataFactory accountEntityDataFactory) {
        this.BuiltInFictitiousFunctionClassFactory = securityGuardFacade;
        this.getAuthRequestContext = apSecurityFacade;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        this.PlaceComponentResult = userLocation;
        this.MyBillsEntityDataFactory = accountEntityDataFactory;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder newBuilder = request.newBuilder();
        if (TextUtils.isEmpty(request.header(HttpHeaders.USER_AGENT))) {
            StringBuilder sb = new StringBuilder();
            sb.append(UserAgentFactory.getUserAgent());
            sb.append(" ");
            sb.append(Version.userAgent());
            newBuilder.header(HttpHeaders.USER_AGENT, sb.toString());
        }
        SecureString PlaceComponentResult = CookieUtil.PlaceComponentResult();
        if (!TextUtils.isEmpty(PlaceComponentResult)) {
            newBuilder.header("Cookie", PlaceComponentResult.toString());
            PlaceComponentResult.clear();
        }
        newBuilder.addHeader("Accept-Language", (Locale.getDefault() == null || Locale.getDefault().toString().endsWith("ID")) ? "id_ID" : "en_US");
        newBuilder.addHeader("X-UTDID", this.getAuthRequestContext.MyBillsEntityDataFactory.getDeviceUtdId());
        newBuilder.addHeader("X-Apdid-Token", this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory());
        String blockingFirst = this.MyBillsEntityDataFactory.createData2("local").getClientKey().blockingFirst();
        if (blockingFirst.isEmpty()) {
            newBuilder.addHeader("X-Client-Key", "");
        } else {
            newBuilder.addHeader("X-Client-Key", blockingFirst);
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        String str = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory;
        String MyBillsEntityDataFactory = CommonUtil.MyBillsEntityDataFactory();
        String blockingFirst2 = this.MyBillsEntityDataFactory.createData2("local").getClientKey().blockingFirst();
        newBuilder.addHeader("X-Timestamp", valueOf);
        newBuilder.addHeader("X-AppKey", str);
        newBuilder.addHeader("X-Nonce", MyBillsEntityDataFactory);
        TreeMap treeMap = new TreeMap();
        treeMap.put("Timestamp", valueOf);
        treeMap.put("Body", KClassImpl$Data$declaredNonStaticMembers$2(request));
        treeMap.put(TrackerKey.DeeplinkProperty.PATH, CommonUtil.BuiltInFictitiousFunctionClassFactory(CommonUtil.MyBillsEntityDataFactory(request.url().toString())));
        treeMap.put("UserId", CookieUtil.KClassImpl$Data$declaredNonStaticMembers$2());
        treeMap.put("AppKey", CommonUtil.BuiltInFictitiousFunctionClassFactory(str));
        treeMap.put("Nonce", CommonUtil.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory));
        treeMap.put("ClientKey", CommonUtil.BuiltInFictitiousFunctionClassFactory(blockingFirst2));
        treeMap.put("Env", CommonUtil.BuiltInFictitiousFunctionClassFactory(request.header("X-Env")));
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry entry : treeMap.entrySet()) {
            sb2.append(ContainerUtils.FIELD_DELIMITER);
            sb2.append((String) entry.getKey());
            sb2.append("=");
            sb2.append((String) entry.getValue());
        }
        try {
            newBuilder.addHeader("X-Sign", this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(sb2.substring(1)));
        } catch (Exception e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.SIGN_CHECK, e.toString());
        }
        newBuilder.addHeader("X-Local-Config", String.valueOf(CommonUtil.BuiltInFictitiousFunctionClassFactory()));
        MyBillsEntityDataFactory(request, newBuilder);
        return chain.proceed(newBuilder.build());
    }

    void MyBillsEntityDataFactory(Request request, Request.Builder builder) {
        try {
            LBSLocation authRequestContext = LbsFacade.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2);
            JSONObject jSONObject = new JSONObject();
            BuiltInFictitiousFunctionClassFactory(request.headers(), "X-Location", jSONObject);
            jSONObject.put("latitude", authRequestContext.getLatitude());
            jSONObject.put("longitude", authRequestContext.getLongitude());
            jSONObject.put("updateTime", authRequestContext.getTime());
            jSONObject.put("type", authRequestContext.getType());
            jSONObject.put("status", authRequestContext.getErrorCode());
            jSONObject.put("userCountryCurrent", this.PlaceComponentResult.getCurrentCountryCode());
            builder.addHeader("X-Location", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (JSONException e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.SIGN_CHECK, e.toString());
        }
    }

    public static void BuiltInFictitiousFunctionClassFactory(Headers headers, String str, JSONObject jSONObject) {
        JsonObject asJsonObject;
        String str2 = headers.get("additionalHeader");
        try {
            if (TextUtils.isEmpty(str2) || (asJsonObject = new JsonParser().parse(str2).getAsJsonObject().getAsJsonObject(str)) == null || asJsonObject.size() <= 0) {
                return;
            }
            for (String str3 : asJsonObject.keySet()) {
                jSONObject.put(str3, asJsonObject.get(str3).getAsString());
            }
        } catch (Exception e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.SIGN_CHECK, e.toString());
        }
    }

    private static String KClassImpl$Data$declaredNonStaticMembers$2(Request request) {
        Buffer buffer;
        Buffer buffer2 = null;
        try {
            try {
                Request build = request.newBuilder().build();
                buffer = new Buffer();
                try {
                    if (build.body() != null) {
                        build.body().writeTo(buffer);
                    }
                    String FragmentBottomSheetPaymentSettingBinding = buffer.FragmentBottomSheetPaymentSettingBinding();
                    buffer.close();
                    return FragmentBottomSheetPaymentSettingBinding;
                } catch (IOException e) {
                    e = e;
                    buffer2 = buffer;
                    DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.SIGN_CHECK, e.toString());
                    if (buffer2 != null) {
                        buffer2.close();
                        return "";
                    }
                    return "";
                } catch (Throwable th) {
                    th = th;
                    if (buffer != null) {
                        buffer.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                buffer = buffer2;
            }
        } catch (IOException e2) {
            e = e2;
        }
    }
}
