package com.alibaba.griver.init;

import com.alibaba.griver.core.GriverConfiguration;

/* loaded from: classes3.dex */
public class IAPConfig extends GriverConfiguration {
    private String authCode;
    private String env;
    private String environment;
    private IAPIntegrationConfiguration extra;
    private String useAmcsLite;
    @Deprecated
    private String useSecurityGuard;
    private String gpSignature = "";
    private String gatewayUrl = "";
    private String alwaysShowDiagnosticTool = "";

    public String getEnv() {
        return this.env;
    }

    public void setEnv(String str) {
        this.env = str;
    }

    public String getEnvironment() {
        return this.environment;
    }

    public void setEnvironment(String str) {
        this.environment = str;
    }

    public String getAuthCode() {
        String str = this.authCode;
        return str == null ? "0a6a" : str;
    }

    public void setAuthCode(String str) {
        this.authCode = str;
    }

    public String getUseAmcsLite() {
        return this.useAmcsLite;
    }

    public void setUseAmcsLite(String str) {
        this.useAmcsLite = str;
    }

    @Deprecated
    public String getUseSecurityGuard() {
        return this.useSecurityGuard;
    }

    @Deprecated
    public void setUseSecurityGuard(String str) {
        this.useSecurityGuard = str;
    }

    public String getGpSignature() {
        return this.gpSignature;
    }

    public void setGpSignature(String str) {
        this.gpSignature = str;
    }

    public IAPIntegrationConfiguration getExtra() {
        return this.extra;
    }

    public void setExtra(IAPIntegrationConfiguration iAPIntegrationConfiguration) {
        this.extra = iAPIntegrationConfiguration;
    }

    public String getGatewayUrl() {
        return this.gatewayUrl;
    }

    public void setGatewayUrl(String str) {
        this.gatewayUrl = str;
    }

    public String getAlwaysShowDiagnosticTool() {
        return this.alwaysShowDiagnosticTool;
    }

    public void setAlwaysShowDiagnosticTool(String str) {
        this.alwaysShowDiagnosticTool = str;
    }
}
