package com.iap.ac.config.lite.c;

import android.text.TextUtils;
import com.alibaba.griver.base.common.constants.SecurityConstants;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.staticdataencrypt.IStaticDataEncryptComponent;
import com.alipay.plus.android.config.sdk.common.AmcsConstants;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.iap.ac.android.common.json.JsonUtils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.config.lite.ConfigCenterContext;
import com.iap.ac.config.lite.common.KVBuilder;
import com.iap.ac.config.lite.delegate.ConfigMonitor;
import com.iap.ac.config.lite.delegate.ConfigRpcProvider;
import com.iap.ac.config.lite.facade.request.AmcsConfigRpcRequest;
import com.iap.ac.config.lite.facade.request.AmcsConfigRpcV1Request;
import com.iap.ac.config.lite.facade.result.AmcsConfigRpcResult;
import com.iap.ac.config.lite.fetcher.FetchException;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class f extends b {
    private static final String e = com.iap.ac.config.lite.d.e.b("RpcFetchTask");
    private boolean c;
    private boolean d;

    public f(ConfigCenterContext configCenterContext, boolean z) {
        super(configCenterContext);
        this.c = false;
        this.d = z;
    }

    private AmcsConfigRpcResult a(AmcsConfigRpcResult amcsConfigRpcResult) throws Exception {
        if (this.d && amcsConfigRpcResult != null && amcsConfigRpcResult.success) {
            if (this.f7627a.getVersion() == ConfigCenterContext.SchemeVersion.V1) {
                return TextUtils.isEmpty(amcsConfigRpcResult.responseTime) ? amcsConfigRpcResult : (AmcsConfigRpcResult) JsonUtils.fromJson(c(amcsConfigRpcResult.responseTime), AmcsConfigRpcResult.class);
            }
            JSONObject jSONObject = amcsConfigRpcResult.updateKeys;
            return (jSONObject == null || !jSONObject.has("business")) ? amcsConfigRpcResult : (AmcsConfigRpcResult) JsonUtils.fromJson(c(amcsConfigRpcResult.updateKeys.getString("business")), AmcsConfigRpcResult.class);
        }
        return amcsConfigRpcResult;
    }

    private String c(String str) throws Exception {
        String staticSafeDecrypt = b().staticSafeDecrypt(16, AmcsConstants.AMCS_ENCRYPT_SECRET_KEY, str, this.f7627a.getRpcProfile().authCode);
        if (TextUtils.isEmpty(staticSafeDecrypt)) {
            throw new FetchException("failed to decrypt result");
        }
        return staticSafeDecrypt;
    }

    private String d(String str) throws Exception {
        String staticSafeEncrypt = b().staticSafeEncrypt(16, AmcsConstants.AMCS_ENCRYPT_SECRET_KEY, str, this.f7627a.getRpcProfile().authCode);
        if (TextUtils.isEmpty(staticSafeEncrypt)) {
            throw new FetchException("failed to mEncrypt request!");
        }
        return staticSafeEncrypt;
    }

    @Override // com.iap.ac.config.lite.c.b
    public String a() {
        return "RpcFetchTask";
    }

    @Override // com.iap.ac.config.lite.c.b
    protected AmcsConfigRpcResult b(String str, JSONObject jSONObject) throws Exception {
        ConfigRpcProvider configRpcProvider = this.f7627a.getConfigRpcProvider();
        if (this.f7627a.getVersion() == ConfigCenterContext.SchemeVersion.V1) {
            AmcsConfigRpcV1Request amcsConfigRpcV1Request = new AmcsConfigRpcV1Request();
            amcsConfigRpcV1Request.lastResponseTime = str;
            a(amcsConfigRpcV1Request, jSONObject);
            return a(configRpcProvider.fetchConfigV1(a(amcsConfigRpcV1Request)));
        }
        AmcsConfigRpcRequest amcsConfigRpcRequest = new AmcsConfigRpcRequest();
        try {
            amcsConfigRpcRequest.lastResponseTime = Long.parseLong(str);
        } catch (NumberFormatException unused) {
            amcsConfigRpcRequest.lastResponseTime = 0L;
        }
        a(amcsConfigRpcRequest, jSONObject);
        return a(configRpcProvider.fetchConfig(a(amcsConfigRpcRequest)));
    }

    public f(ConfigCenterContext configCenterContext) {
        super(configCenterContext);
        this.c = false;
        this.d = false;
    }

    private AmcsConfigRpcRequest a(AmcsConfigRpcRequest amcsConfigRpcRequest) throws Exception {
        if (this.d) {
            AmcsConfigRpcRequest amcsConfigRpcRequest2 = new AmcsConfigRpcRequest();
            amcsConfigRpcRequest2.lastResponseTime = -1L;
            amcsConfigRpcRequest2.addParameter("business", d(JsonUtils.toJson(amcsConfigRpcRequest)));
            return amcsConfigRpcRequest2;
        }
        return amcsConfigRpcRequest;
    }

    private AmcsConfigRpcV1Request a(AmcsConfigRpcV1Request amcsConfigRpcV1Request) throws Exception {
        if (this.d) {
            AmcsConfigRpcV1Request amcsConfigRpcV1Request2 = new AmcsConfigRpcV1Request();
            amcsConfigRpcV1Request2.lastResponseTime = "-1";
            amcsConfigRpcV1Request2.business = d(JsonUtils.toJson(amcsConfigRpcV1Request));
            return amcsConfigRpcV1Request2;
        }
        return amcsConfigRpcV1Request;
    }

    private IStaticDataEncryptComponent b() throws Exception {
        if (!b(SecurityConstants.SG_CLASS) && !b("com.alibaba.wireless.security.open.staticdataencrypt.IStaticDataEncryptComponent")) {
            SecurityGuardManager securityGuardManager = SecurityGuardManager.getInstance(this.f7627a.getContext(), this.f7627a.getRpcProfile().authCode);
            if (securityGuardManager != null) {
                IStaticDataEncryptComponent staticDataEncryptComp = securityGuardManager.getStaticDataEncryptComp();
                if (staticDataEncryptComp != null) {
                    return staticDataEncryptComp;
                }
                throw new FetchException("failed to get security guard component!");
            }
            throw new FetchException("failed to get security guard component!");
        }
        throw new FetchException("Can not find security guard library!");
    }

    @Override // com.iap.ac.config.lite.c.b
    protected void a(KVBuilder kVBuilder, AmcsConfigRpcResult amcsConfigRpcResult) {
        JSONObject jSONObject = amcsConfigRpcResult.updateKeys;
        a(ConfigMonitor.Events.CONFIG_UPDATE, kVBuilder.put(ConfigMonitor.Keywords.KEY_WORD_IS_RETRY, Boolean.valueOf(this.c)).put(UserMetadata.KEYDATA_FILENAME, (jSONObject == null || jSONObject.length() == 0) ? null : com.iap.ac.config.lite.d.e.a((Iterator<? extends CharSequence>) amcsConfigRpcResult.updateKeys.keys(), ',')).put(ConfigMonitor.Keywords.KEY_WORD_NEED_ENCRYPT, Boolean.valueOf(this.d)).put("success", "1").build());
    }

    @Override // com.iap.ac.config.lite.c.b
    protected void a(KVBuilder kVBuilder) {
        a(ConfigMonitor.Events.CONFIG_UPDATE, kVBuilder.put(ConfigMonitor.Keywords.KEY_WORD_NEED_ENCRYPT, Boolean.valueOf(this.d)).put(ConfigMonitor.Keywords.KEY_WORD_IS_RETRY, Boolean.valueOf(this.c)).put("success", "0").build());
    }

    private boolean b(String str) {
        try {
            return Class.forName(str) == null;
        } catch (ClassNotFoundException e2) {
            String str2 = e;
            StringBuilder sb = new StringBuilder();
            sb.append("library not found: ");
            sb.append(str);
            ACLog.e(str2, sb.toString(), e2);
            return true;
        }
    }
}
