package com.alipay.plus.android.config.sdk.fetcher.a;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.staticdataencrypt.IStaticDataEncryptComponent;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.iap.android.common.securityprofiles.profile.RpcProfile;
import com.alipay.iap.android.common.utils.MiscUtils;
import com.alipay.iap.android.f2fpay.components.defaults.DefaultInitializeComponent;
import com.alipay.plus.android.config.sdk.ConfigCenterContext;
import com.alipay.plus.android.config.sdk.a.e;
import com.alipay.plus.android.config.sdk.common.AmcsConstants;
import com.alipay.plus.android.config.sdk.common.KVBuilder;
import com.alipay.plus.android.config.sdk.delegate.ConfigIdentifierProvider;
import com.alipay.plus.android.config.sdk.facade.request.AmcsConfigRpcRequest;
import com.alipay.plus.android.config.sdk.facade.result.AmcsConfigRpcResult;
import com.alipay.plus.android.config.sdk.fetcher.FetchException;
import com.alipay.plus.android.config.sdk.retry.DistributionNode;
import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
public abstract class a {
    private static final String d = e.a("ConfigFetchTask");

    /* renamed from: a  reason: collision with root package name */
    protected ConfigCenterContext f7369a;
    protected DistributionNode b;
    protected boolean c;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(ConfigCenterContext configCenterContext, DistributionNode distributionNode) {
        this.c = false;
        this.f7369a = configCenterContext;
        this.b = distributionNode;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(ConfigCenterContext configCenterContext, DistributionNode distributionNode, boolean z) {
        this(configCenterContext, distributionNode);
        this.c = z;
    }

    private static String a(RpcProfile rpcProfile) {
        String str = rpcProfile.extras != null ? rpcProfile.extras.get(AmcsConstants.AMCS_BUSINESS_KEY) : null;
        return TextUtils.isEmpty(str) ? "default" : str;
    }

    private AmcsConfigRpcResult d(String str) throws FetchException {
        try {
            c(str);
            e();
            AmcsConfigRpcResult c = c();
            if (c != null) {
                AmcsConfigRpcResult a2 = a(c);
                if (a2.success) {
                    return a2;
                }
                throw new FetchException(a2.errorCode, a2.errorMessage);
            }
            throw new FetchException("rpc_result_is_null");
        } catch (Throwable th) {
            throw e.a(th, true);
        }
    }

    protected AmcsConfigRpcResult a(AmcsConfigRpcResult amcsConfigRpcResult) throws Exception {
        if (this.c && amcsConfigRpcResult.success) {
            String str = d;
            StringBuilder sb = new StringBuilder();
            sb.append("before encrypted: ");
            sb.append(JSONObject.toJSONString(amcsConfigRpcResult));
            LoggerWrapper.d(str, sb.toString());
            String staticSafeDecrypt = f().staticSafeDecrypt(16, AmcsConstants.AMCS_ENCRYPT_SECRET_KEY, amcsConfigRpcResult.responseTime, this.f7369a.getRpcProfile().authCode);
            if (TextUtils.isEmpty(staticSafeDecrypt)) {
                throw new FetchException("failed to decrypt result");
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("after encrypted: ");
            sb2.append(JSONObject.toJSONString(staticSafeDecrypt));
            LoggerWrapper.d(str, sb2.toString());
            return (AmcsConfigRpcResult) JSONObject.parseObject(staticSafeDecrypt, AmcsConfigRpcResult.class);
        }
        return amcsConfigRpcResult;
    }

    public abstract String a();

    protected abstract void a(KVBuilder kVBuilder);

    protected abstract void a(KVBuilder kVBuilder, AmcsConfigRpcResult amcsConfigRpcResult);

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(AmcsConfigRpcRequest amcsConfigRpcRequest) {
        if (amcsConfigRpcRequest == null) {
            return;
        }
        Context context = this.f7369a.getContext();
        ConfigIdentifierProvider identifierProvider = this.f7369a.getIdentifierProvider();
        RpcProfile rpcProfile = this.f7369a.getRpcProfile();
        String versionName = MiscUtils.getVersionName(this.f7369a.getContext());
        if (TextUtils.isEmpty(versionName)) {
            versionName = "1.0";
        }
        amcsConfigRpcRequest.utdid = identifierProvider.getUtdId(context);
        amcsConfigRpcRequest.reference = identifierProvider.getConfigUserId(context);
        amcsConfigRpcRequest.productId = rpcProfile.productId;
        amcsConfigRpcRequest.mobileModel = Build.MODEL;
        amcsConfigRpcRequest.mobileBrand = Build.BRAND;
        amcsConfigRpcRequest.manufacturer = Build.MANUFACTURER;
        amcsConfigRpcRequest.osVersion = e.a();
        amcsConfigRpcRequest.clientVersion = versionName;
        amcsConfigRpcRequest.business = a(rpcProfile);
        amcsConfigRpcRequest.systemType = DefaultInitializeComponent.PLATFORM_TYPE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, Map<String, String> map) {
        this.f7369a.getConfigMonitor().behavior(str, map);
    }

    public boolean a(String str) {
        return b().contains(str);
    }

    public final AmcsConfigRpcResult b(String str) throws FetchException {
        a(KVBuilder.newBuilder().put("localVersion", str));
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            AmcsConfigRpcResult d2 = d(str);
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            LoggerWrapper.d(d, String.format("[%s] Fetch config success! increment = %s, responseTime = %s, duration = %s.", a(), Boolean.valueOf(d2.increment), d2.responseTime, Long.valueOf(elapsedRealtime2)));
            a(KVBuilder.newBuilder().put("version", d2.responseTime).put("duration", Long.valueOf(elapsedRealtime2)).put("updateCount", Integer.valueOf(d2.updateKeys != null ? d2.updateKeys.size() : 0)), d2);
            return d2;
        } catch (FetchException e) {
            long elapsedRealtime3 = SystemClock.elapsedRealtime() - elapsedRealtime;
            LoggerWrapper.d(d, String.format("[%s] Fetch config failed! errorCode = %s, errorMessage = %s, duration = %s.", a(), e.errorCode, e.errorMessage, Long.valueOf(elapsedRealtime3)));
            b(KVBuilder.newBuilder().put("errorCode", e.errorCode).put("errorMessage", e.errorMessage).put("duration", Long.valueOf(elapsedRealtime3)));
            throw e;
        }
    }

    protected abstract List<String> b();

    protected abstract void b(KVBuilder kVBuilder);

    protected abstract AmcsConfigRpcResult c() throws Throwable;

    protected void c(String str) {
    }

    public DistributionNode d() {
        return this.b;
    }

    protected void e() throws Exception {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IStaticDataEncryptComponent f() throws Exception {
        SecurityGuardManager securityGuardManager = SecurityGuardManager.getInstance(this.f7369a.getContext());
        if (securityGuardManager != null) {
            IStaticDataEncryptComponent staticDataEncryptComp = securityGuardManager.getStaticDataEncryptComp();
            if (staticDataEncryptComp != null) {
                return staticDataEncryptComp;
            }
            throw new FetchException("failed to get security guard component!");
        }
        throw new FetchException("failed to get security guard component!");
    }

    public String toString() {
        return String.format("[%s] %s", a(), this.b);
    }
}
