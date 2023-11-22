package com.iap.ac.config.lite;

import android.content.Context;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.rpc.RpcAppInfo;
import com.iap.ac.config.lite.d.e;
import com.iap.ac.config.lite.d.g;
import com.iap.ac.config.lite.delegate.ConfigIdentifierProvider;
import com.iap.ac.config.lite.delegate.ConfigMonitor;
import com.iap.ac.config.lite.delegate.ConfigRpcProvider;
import com.iap.ac.config.lite.rpc.DefaultConfigRpcProvider;
import com.iap.ac.config.lite.storage.a;
import com.iap.ac.config.lite.utils.ConfigUtils;

/* loaded from: classes.dex */
public class ConfigCenterContext {
    private static final String l = e.b("ConfigCenterContext");

    /* renamed from: a  reason: collision with root package name */
    private Context f7613a;
    private SchemeVersion b;
    private ConfigRpcProvider c;
    private ConfigIdentifierProvider d;
    private ConfigMonitor e;
    private String f;
    private ApplicationInfo g;
    private RpcAppInfo h;
    private String i;
    private String j;
    private a k;

    /* loaded from: classes3.dex */
    public static class ApplicationInfo {
        public String appId;
        public String tntInstId;
        public String workspaceId;
    }

    /* loaded from: classes.dex */
    public enum SchemeVersion {
        V1,
        V2
    }

    public ConfigCenterContext(Context context, RpcAppInfo rpcAppInfo, String str, String str2, String str3, String str4, String str5) {
        this.b = SchemeVersion.V2;
        this.c = new DefaultConfigRpcProvider();
        this.d = new g();
        this.e = new ConfigMonitor.ACLogMonitor();
        this.g = new ApplicationInfo();
        this.f7613a = context;
        this.f = str;
        a(str4, str2, str3);
        a(rpcAppInfo);
        setBizCode(str5);
    }

    private void a(String str, String str2, String str3) {
        ApplicationInfo applicationInfo = this.g;
        applicationInfo.appId = str;
        applicationInfo.tntInstId = str2;
        applicationInfo.workspaceId = str3;
        String str4 = l;
        StringBuilder sb = new StringBuilder();
        sb.append("applicationInfo: ");
        sb.append(ConfigUtils.toJSONString(this.g));
        ACLog.d(str4, sb.toString());
    }

    public String getAppId() {
        return this.g.appId;
    }

    public String getBizCode() {
        return this.j;
    }

    public ConfigMonitor getConfigMonitor() {
        return this.e;
    }

    public ConfigRpcProvider getConfigRpcProvider() {
        return this.c;
    }

    public a getConfigStorage() {
        return this.k;
    }

    public final Context getContext() {
        return this.f7613a;
    }

    public String getDnsServer() {
        return this.i;
    }

    public String getEnvironment() {
        return this.f;
    }

    public ConfigIdentifierProvider getIdentifierProvider() {
        return this.d;
    }

    public RpcAppInfo getRpcProfile() {
        return this.h;
    }

    public String getTntInstId() {
        return this.g.tntInstId;
    }

    public SchemeVersion getVersion() {
        return this.b;
    }

    public String getWorkspaceId() {
        return this.g.workspaceId;
    }

    public void setAppId(String str) {
        this.g.appId = str;
    }

    public void setBizCode(String str) {
        this.j = str;
        this.e.setBizCode(str);
        ConfigRpcProvider configRpcProvider = this.c;
        if (configRpcProvider instanceof DefaultConfigRpcProvider) {
            ((DefaultConfigRpcProvider) configRpcProvider).setBizCode(this.j);
        }
    }

    public void setConfigMonitor(ConfigMonitor configMonitor) {
        this.e = configMonitor;
    }

    public void setConfigRpcProvider(ConfigRpcProvider configRpcProvider) {
        this.c = configRpcProvider;
    }

    public void setConfigStorage(a aVar) {
        this.k = aVar;
    }

    public void setDnsServer(String str) {
        this.i = str;
    }

    public void setEnvironment(String str) {
        this.f = str;
    }

    public void setIdentifierProvider(ConfigIdentifierProvider configIdentifierProvider) {
        this.d = configIdentifierProvider;
    }

    public void setTntInstId(String str) {
        this.g.tntInstId = str;
    }

    public void setVersion(SchemeVersion schemeVersion) {
        this.b = schemeVersion;
    }

    public void setWorkspaceId(String str) {
        this.g.workspaceId = str;
    }

    private void a(RpcAppInfo rpcAppInfo) {
        this.h = rpcAppInfo;
        String str = l;
        StringBuilder sb = new StringBuilder();
        sb.append("rpcProfile: ");
        sb.append(ConfigUtils.toJSONString(this.h));
        ACLog.d(str, sb.toString());
    }

    public ConfigCenterContext(Context context, RpcAppInfo rpcAppInfo, String str, String str2, String str3) {
        this(context, rpcAppInfo, str, str2, null, str3, null);
    }

    public ConfigCenterContext(Context context, RpcAppInfo rpcAppInfo, String str, String str2) {
        this(context, rpcAppInfo, str, null, null, str2, null);
    }
}
