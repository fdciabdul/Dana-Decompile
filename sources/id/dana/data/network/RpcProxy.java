package id.dana.data.network;

import android.content.Context;
import android.util.Base64;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.network.HttpRequest;
import com.alibaba.griver.api.common.network.HttpResponse;
import com.alipay.iap.android.lbs.LBSLocation;
import com.huawei.hms.framework.common.ContainerUtils;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.foundation.RpcException;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.foundation.facade.SecurityGuardFacade;
import id.dana.data.foundation.h5app.utils.H5ResponseCacheUtil;
import id.dana.data.foundation.toolbox.AbstractHttpTransport;
import id.dana.data.foundation.toolbox.HttpTransportFactory;
import id.dana.data.foundation.utils.CommonUtil;
import id.dana.data.foundation.utils.CookieUtil;
import id.dana.data.globalnetwork.source.local.UserLocation;
import id.dana.data.network.interceptor.HttpSessionInterceptor;
import id.dana.data.security.SecureString;
import id.dana.data.util.NetworkUtils;
import id.dana.utils.foundation.facede.LbsFacade;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.holdlogin.v2.HoldLoginConfig;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.net.ssl.SSLHandshakeException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Singleton
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)BI\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\r\u0012\u0006\u0010 \u001a\u00020\n\u0012\u0006\u0010!\u001a\u00020\u0019\u0012\u0006\u0010\"\u001a\u00020\u0015\u0012\u0006\u0010#\u001a\u00020\u0012\u0012\u0006\u0010$\u001a\u00020\u001c\u0012\u0006\u0010%\u001a\u00020\u0010\u0012\u0006\u0010&\u001a\u00020\u0007¢\u0006\u0004\b'\u0010(J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0005\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e"}, d2 = {"Lid/dana/data/network/RpcProxy;", "Lid/dana/data/foundation/toolbox/AbstractHttpTransport;", "Lcom/alibaba/griver/api/common/network/HttpRequest;", "p0", "Lcom/alibaba/griver/api/common/network/HttpResponse;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lcom/alibaba/griver/api/common/network/HttpRequest;)Lcom/alibaba/griver/api/common/network/HttpResponse;", "Lid/dana/data/account/repository/source/AccountEntityDataFactory;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/data/account/repository/source/AccountEntityDataFactory;", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "getAuthRequestContext", "Landroid/content/Context;", "PlaceComponentResult", "Landroid/content/Context;", "Lid/dana/utils/holdlogin/v2/HoldLoginConfig;", "Lid/dana/utils/holdlogin/v2/HoldLoginConfig;", "Lid/dana/data/network/interceptor/HttpSessionInterceptor;", "MyBillsEntityDataFactory", "Lid/dana/data/network/interceptor/HttpSessionInterceptor;", "Lid/dana/data/foundation/toolbox/HttpTransportFactory;", "lookAheadTest", "Lid/dana/data/foundation/toolbox/HttpTransportFactory;", "moveToNextValue", "Lid/dana/data/foundation/facade/SecurityGuardFacade;", "Lid/dana/data/foundation/facade/SecurityGuardFacade;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/data/globalnetwork/source/local/UserLocation;", "scheduleImpl", "Lid/dana/data/globalnetwork/source/local/UserLocation;", "getErrorConfigVersion", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "<init>", "(Landroid/content/Context;Lid/dana/data/foundation/facade/ApSecurityFacade;Lid/dana/data/foundation/facade/SecurityGuardFacade;Lid/dana/data/foundation/toolbox/HttpTransportFactory;Lid/dana/data/network/interceptor/HttpSessionInterceptor;Lid/dana/data/globalnetwork/source/local/UserLocation;Lid/dana/utils/holdlogin/v2/HoldLoginConfig;Lid/dana/data/account/repository/source/AccountEntityDataFactory;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RpcProxy implements AbstractHttpTransport {
    private final AccountEntityDataFactory BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final ApSecurityFacade getAuthRequestContext;
    private final HttpSessionInterceptor MyBillsEntityDataFactory;
    private final Context PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final HoldLoginConfig KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final HttpTransportFactory moveToNextValue;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final SecurityGuardFacade NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final UserLocation getErrorConfigVersion;

    @Inject
    public RpcProxy(Context context, ApSecurityFacade apSecurityFacade, SecurityGuardFacade securityGuardFacade, HttpTransportFactory httpTransportFactory, HttpSessionInterceptor httpSessionInterceptor, UserLocation userLocation, HoldLoginConfig holdLoginConfig, AccountEntityDataFactory accountEntityDataFactory) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(securityGuardFacade, "");
        Intrinsics.checkNotNullParameter(httpTransportFactory, "");
        Intrinsics.checkNotNullParameter(httpSessionInterceptor, "");
        Intrinsics.checkNotNullParameter(userLocation, "");
        Intrinsics.checkNotNullParameter(holdLoginConfig, "");
        Intrinsics.checkNotNullParameter(accountEntityDataFactory, "");
        this.PlaceComponentResult = context;
        this.getAuthRequestContext = apSecurityFacade;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = securityGuardFacade;
        this.moveToNextValue = httpTransportFactory;
        this.MyBillsEntityDataFactory = httpSessionInterceptor;
        this.getErrorConfigVersion = userLocation;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = holdLoginConfig;
        this.BuiltInFictitiousFunctionClassFactory = accountEntityDataFactory;
    }

    @Override // id.dana.data.foundation.toolbox.AbstractHttpTransport
    public final HttpResponse KClassImpl$Data$declaredNonStaticMembers$2(HttpRequest p0) {
        HttpResponse KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullParameter(p0, "");
        StringBuilder sb = new StringBuilder();
        sb.append("performRequest [before request] request=");
        sb.append(p0);
        sb.append("\t url=");
        sb.append(p0.getUrl());
        DanaLog.MyBillsEntityDataFactory("RpcProxy", sb.toString());
        if (H5ResponseCacheUtil.PlaceComponentResult(p0.getUrl()) || NetworkUtils.isNetworkAvailable(this.PlaceComponentResult)) {
            if (CookieUtil.getAuthRequestContext(p0.getUrl())) {
                String url = p0.getUrl();
                SecureString MyBillsEntityDataFactory = CookieUtil.MyBillsEntityDataFactory();
                p0.setUrl(CookieUtil.MyBillsEntityDataFactory(url, MyBillsEntityDataFactory != null ? MyBillsEntityDataFactory.toString() : null));
                String BuiltInFictitiousFunctionClassFactory = this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory();
                Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
                if (!(BuiltInFictitiousFunctionClassFactory.length() == 0)) {
                    if (p0.getHeaders() == null) {
                        p0.setHeaders(new HashMap());
                    }
                    Map<String, String> headers = p0.getHeaders();
                    Intrinsics.checkNotNullExpressionValue(headers, "");
                    headers.put("X-Apdid-Token", BuiltInFictitiousFunctionClassFactory);
                }
                String blockingFirst = this.BuiltInFictitiousFunctionClassFactory.createData2("local").getClientKey().blockingFirst();
                Intrinsics.checkNotNullExpressionValue(blockingFirst, "");
                if (blockingFirst.length() == 0) {
                    if (p0.getHeaders() == null) {
                        p0.setHeaders(new HashMap());
                    }
                    Map<String, String> headers2 = p0.getHeaders();
                    Intrinsics.checkNotNullExpressionValue(headers2, "");
                    headers2.put("X-Client-Key", "");
                } else {
                    Map<String, String> headers3 = p0.getHeaders();
                    Intrinsics.checkNotNullExpressionValue(headers3, "");
                    headers3.put("X-Client-Key", blockingFirst);
                }
                if (p0.getHeaders() == null) {
                    p0.setHeaders(new HashMap());
                }
                Map<String, String> headers4 = p0.getHeaders();
                Intrinsics.checkNotNullExpressionValue(headers4, "");
                headers4.put("X-Timestamp", String.valueOf(System.currentTimeMillis()));
                Map<String, String> headers5 = p0.getHeaders();
                Intrinsics.checkNotNullExpressionValue(headers5, "");
                headers5.put("X-AppKey", this.NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory);
                Map<String, String> headers6 = p0.getHeaders();
                Intrinsics.checkNotNullExpressionValue(headers6, "");
                headers6.put("X-Nonce", CommonUtil.MyBillsEntityDataFactory());
                byte[] requestData = p0.getRequestData();
                if (requestData == null) {
                    requestData = new byte[0];
                }
                p0.setRequestData(requestData);
                TreeMap treeMap = new TreeMap();
                TreeMap treeMap2 = treeMap;
                treeMap2.put("Timestamp", p0.getHeaders().get("X-Timestamp"));
                byte[] requestData2 = p0.getRequestData();
                Intrinsics.checkNotNullExpressionValue(requestData2, "");
                treeMap2.put("Body", new String(requestData2, Charsets.UTF_8));
                treeMap2.put(TrackerKey.DeeplinkProperty.PATH, CommonUtil.BuiltInFictitiousFunctionClassFactory(CommonUtil.MyBillsEntityDataFactory(p0.getUrl())));
                treeMap2.put("UserId", CommonUtil.BuiltInFictitiousFunctionClassFactory(CookieUtil.KClassImpl$Data$declaredNonStaticMembers$2()));
                treeMap2.put("AppKey", p0.getHeaders().get("X-AppKey"));
                treeMap2.put("Nonce", p0.getHeaders().get("X-Nonce"));
                treeMap2.put("ClientKey", CommonUtil.BuiltInFictitiousFunctionClassFactory(p0.getHeaders().get("X-Client-Key")));
                treeMap2.put("Env", CommonUtil.BuiltInFictitiousFunctionClassFactory(p0.getHeaders().get("X-Env")));
                StringBuilder sb2 = new StringBuilder();
                for (Map.Entry entry : treeMap2.entrySet()) {
                    String str = (String) entry.getKey();
                    String str2 = (String) entry.getValue();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("key=");
                    sb3.append(str);
                    sb3.append(",value=");
                    sb3.append((String) treeMap.get(str));
                    DanaLog.scheduleImpl("RpcProxy", sb3.toString());
                    sb2.append(ContainerUtils.FIELD_DELIMITER);
                    sb2.append(str);
                    sb2.append("=");
                    sb2.append(str2);
                }
                try {
                    String substring = sb2.substring(1);
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("source=");
                    sb4.append(substring);
                    DanaLog.scheduleImpl("RpcProxy", sb4.toString());
                    String PlaceComponentResult = this.NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult(substring);
                    Map<String, String> headers7 = p0.getHeaders();
                    Intrinsics.checkNotNullExpressionValue(headers7, "");
                    headers7.put("X-Sign", PlaceComponentResult);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("X-Sign=");
                    sb5.append(PlaceComponentResult);
                    DanaLog.scheduleImpl("RpcProxy", sb5.toString());
                } catch (Exception e) {
                    DanaLog.BuiltInFictitiousFunctionClassFactory("RpcProxy", "setupSign", e);
                }
                int BuiltInFictitiousFunctionClassFactory2 = CommonUtil.BuiltInFictitiousFunctionClassFactory();
                if (p0.getHeaders() == null) {
                    p0.setHeaders(new HashMap());
                }
                Map<String, String> headers8 = p0.getHeaders();
                Intrinsics.checkNotNullExpressionValue(headers8, "");
                headers8.put("X-Local-Config", String.valueOf(BuiltInFictitiousFunctionClassFactory2));
                try {
                    LBSLocation authRequestContext = LbsFacade.getAuthRequestContext(this.PlaceComponentResult);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put((JSONObject) "latitude", String.valueOf(authRequestContext.getLatitude()));
                    jSONObject.put((JSONObject) "longitude", String.valueOf(authRequestContext.getLongitude()));
                    jSONObject.put((JSONObject) "updateTime", (String) Long.valueOf(authRequestContext.getTime()));
                    jSONObject.put((JSONObject) "type", authRequestContext.getType());
                    jSONObject.put((JSONObject) "status", String.valueOf(authRequestContext.getErrorCode()));
                    jSONObject.put((JSONObject) "userCountryCurrent", this.getErrorConfigVersion.getCurrentCountryCode());
                    if (p0.getHeaders() == null) {
                        p0.setHeaders(new HashMap());
                    }
                    Map<String, String> headers9 = p0.getHeaders();
                    Intrinsics.checkNotNullExpressionValue(headers9, "");
                    String obj = jSONObject.toString();
                    Intrinsics.checkNotNullExpressionValue(obj, "");
                    byte[] bytes = obj.getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes, "");
                    headers9.put("X-Location", Base64.encodeToString(bytes, 2));
                } catch (Exception e2) {
                    DanaLog.BuiltInFictitiousFunctionClassFactory("RpcProxy", e2.getMessage());
                }
                Map<String, String> headers10 = p0.getHeaders();
                Intrinsics.checkNotNullExpressionValue(headers10, "");
                headers10.put("X-UTDID", this.getAuthRequestContext.MyBillsEntityDataFactory.getDeviceUtdId());
            }
            try {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("performRequest [later request] request=");
                sb6.append(p0);
                sb6.append("\t url=");
                sb6.append(p0.getUrl());
                DanaLog.MyBillsEntityDataFactory("RpcProxy", sb6.toString());
                if (!this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory()) {
                    HttpResponse KClassImpl$Data$declaredNonStaticMembers$22 = HttpTransportFactory.PlaceComponentResult(this.moveToNextValue).KClassImpl$Data$declaredNonStaticMembers$2(p0);
                    Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$22, "");
                    KClassImpl$Data$declaredNonStaticMembers$2 = this.MyBillsEntityDataFactory.getAuthRequestContext(this, p0, KClassImpl$Data$declaredNonStaticMembers$22);
                    Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
                } else {
                    KClassImpl$Data$declaredNonStaticMembers$2 = HttpTransportFactory.PlaceComponentResult(this.moveToNextValue).KClassImpl$Data$declaredNonStaticMembers$2(p0);
                    Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
                }
                StringBuilder sb7 = new StringBuilder();
                sb7.append("response=");
                sb7.append(KClassImpl$Data$declaredNonStaticMembers$2);
                DanaLog.MyBillsEntityDataFactory("RpcProxy", sb7.toString());
                return KClassImpl$Data$declaredNonStaticMembers$2;
            } catch (MalformedURLException e3) {
                throw new RpcException("006", e3);
            } catch (SocketTimeoutException e4) {
                throw new RpcException("005", e4);
            } catch (KeyManagementException e5) {
                throw new RpcException("000", e5);
            } catch (NoSuchAlgorithmException e6) {
                throw new RpcException("000", e6);
            } catch (SSLHandshakeException e7) {
                throw new RpcException("002", e7);
            } catch (IOException e8) {
                throw new RpcException("000", e8);
            } catch (Exception e9) {
                throw new RpcException("000", e9);
            }
        }
        throw new RpcException("012");
    }
}
