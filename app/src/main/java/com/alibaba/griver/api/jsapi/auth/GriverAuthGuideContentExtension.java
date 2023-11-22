package com.alibaba.griver.api.jsapi.auth;

import com.alibaba.griver.api.common.GriverExtension;

/* loaded from: classes6.dex */
public interface GriverAuthGuideContentExtension extends GriverExtension {

    /* loaded from: classes6.dex */
    public static class AuthGuideContent {
        public boolean cancelable;
        public String message;
        public String negativeButtonColor;
        public String negativeButtonText;
        public String positiveButtonColor;
        public String positiveButtonText;
        public String title;
    }

    AuthGuideContent getAuthGuideContent(String str);
}
