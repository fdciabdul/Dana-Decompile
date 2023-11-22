package com.alibaba.griver.base.common.innerapp;

/* loaded from: classes6.dex */
public class ClientParams {
    public int appSourceTag;
    public InnerPermissionEnable innerPermissionEnable;

    /* loaded from: classes6.dex */
    public static class InnerPermissionEnable {
        public int jsapiSpConfigHttpRequestAllowedDomain;
        public int webViewConfigAllowedDomain;

        public boolean isWebViewConfigAllowedDomain() {
            return this.webViewConfigAllowedDomain == 0;
        }

        public boolean isJsapiSpConfigHttpRequestAllowedDomain() {
            return this.jsapiSpConfigHttpRequestAllowedDomain == 0;
        }
    }

    public boolean isInnerApp() {
        return this.appSourceTag == 1;
    }
}
