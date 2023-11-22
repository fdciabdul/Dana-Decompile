package com.alibaba.ariver.resource.api.content;

import com.alibaba.ariver.kernel.common.utils.UrlUtils;

/* loaded from: classes2.dex */
public class ResourceQuery {

    /* renamed from: a  reason: collision with root package name */
    private boolean f6208a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private String h;
    private boolean i = false;
    public String originUrl;
    public String pureUrl;

    public ResourceQuery(String str) {
        this.originUrl = str;
        this.pureUrl = UrlUtils.purifyUrl(str);
    }

    public ResourceQuery setNeedAutoCompleteHost() {
        this.f6208a = true;
        return this;
    }

    public void setPageUrl(String str) {
        this.h = str;
    }

    public String getPageUrl() {
        return this.h;
    }

    public boolean isForceNet() {
        return this.i;
    }

    public void setForceNet(boolean z) {
        this.i = z;
    }

    public ResourceQuery setCanUseFallback(boolean z) {
        this.b = z;
        return this;
    }

    public ResourceQuery setLanguageAware(boolean z) {
        this.g = z;
        return this;
    }

    public boolean isNeedAutoCompleteHost() {
        return this.f6208a;
    }

    public boolean isCanUseFallback() {
        return this.b;
    }

    public boolean isMainDoc() {
        return this.c;
    }

    public boolean isLanguageAware() {
        return this.g;
    }

    public void setDisableResourcePackage() {
        this.e = true;
    }

    public boolean isDisableResourcePackage() {
        return this.e;
    }

    public void setMainDoc(boolean z) {
        this.c = z;
    }

    public boolean isPreRenderMainDoc() {
        return this.d;
    }

    public void setPreRenderMainDoc(boolean z) {
        this.d = z;
    }

    public boolean isAppxNgRoute() {
        return this.f;
    }

    public void setAppxNgRoute(boolean z) {
        this.f = z;
    }

    public static ResourceQuery asUrl(String str) {
        return new ResourceQuery(str);
    }
}
