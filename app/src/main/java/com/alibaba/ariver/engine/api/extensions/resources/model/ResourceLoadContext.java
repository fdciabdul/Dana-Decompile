package com.alibaba.ariver.engine.api.extensions.resources.model;

import android.net.Uri;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.utils.UrlUtils;

/* loaded from: classes2.dex */
public class ResourceLoadContext {
    public static int WEBTYPE_IS_NOT_WEBVIEW = 4;
    public static int WEBTYPE_RN_VIEW = 3;
    public static int WEBTYPE_SYSTEM_BUILD_IN = 1;
    public static int WEBTYPE_THIRD_PARTY = 2;
    public boolean canAsyncFallback;
    public boolean canDegradeGlobalPackage;
    public boolean canUseFallback;
    public boolean forceAppxNg;
    public boolean isMainDoc;
    public boolean isPreRenderMainDoc;
    public String originUrl;
    public Node sourceNode;
    public Uri uri;
    @Deprecated
    public int webType;

    public ResourceLoadContext() {
        this.canDegradeGlobalPackage = true;
    }

    public ResourceLoadContext(Builder builder) {
        this.originUrl = builder.originUrl;
        if (builder.uri == null) {
            this.uri = UrlUtils.parseUrl(this.originUrl);
        } else {
            this.uri = builder.uri;
        }
        this.canUseFallback = builder.canUseFallback;
        this.canAsyncFallback = builder.canAsyncFallback;
        this.isMainDoc = builder.isMainDoc;
        this.isPreRenderMainDoc = builder.isPreRenderMainDoc;
        this.webType = builder.webType;
        this.canDegradeGlobalPackage = builder.canDegradeGlobalPackage;
        this.forceAppxNg = builder.forceAppxNg;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /* loaded from: classes3.dex */
    public static class Builder {
        public boolean canUseFallback;
        public String originUrl;
        public Node sourceNode;
        public Uri uri;
        public boolean canAsyncFallback = false;
        public boolean canDegradeGlobalPackage = true;
        public boolean isMainDoc = false;
        public int webType = ResourceLoadContext.WEBTYPE_IS_NOT_WEBVIEW;
        public boolean isPreRenderMainDoc = false;
        public boolean forceAppxNg = false;

        public Builder uri(Uri uri) {
            this.uri = uri;
            return this;
        }

        public Builder originUrl(String str) {
            this.originUrl = str;
            return this;
        }

        public Builder canUseFallback(boolean z) {
            this.canUseFallback = z;
            return this;
        }

        public Builder canAsyncFallback(boolean z) {
            this.canAsyncFallback = z;
            return this;
        }

        public Builder isMainDoc(boolean z) {
            this.isMainDoc = z;
            return this;
        }

        public Builder isPreRenderMainDoc(boolean z) {
            this.isPreRenderMainDoc = z;
            return this;
        }

        public Builder forceAppxNg(boolean z) {
            this.forceAppxNg = z;
            return this;
        }

        public Builder webType(int i) {
            this.webType = i;
            return this;
        }

        public Builder sourceNode(Node node) {
            this.sourceNode = node;
            return this;
        }

        public Builder canDegradeGlobalPackage(boolean z) {
            this.canDegradeGlobalPackage = z;
            return this;
        }

        public ResourceLoadContext build() {
            return new ResourceLoadContext(this);
        }
    }
}
