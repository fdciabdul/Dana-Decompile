package com.alibaba.griver.base.common.webview;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.griver.api.common.webview.GriverUserAgentExtension;
import com.alibaba.griver.api.common.webview.GriverWebViewSettingExtension;

/* loaded from: classes3.dex */
public class GriverWebviewSetting {
    public static final String SPACE = " ";

    /* renamed from: a  reason: collision with root package name */
    private static GriverWebViewSettingExtension f6318a = new GriverWebViewSettingExtension() { // from class: com.alibaba.griver.base.common.webview.GriverWebviewSetting.1

        /* renamed from: a  reason: collision with root package name */
        private String f6319a = " Griver/2.52.0 AppContainer/10.5.10";

        @Override // com.alibaba.griver.api.common.webview.GriverWebViewSettingExtension
        public final String getUserAgent() {
            String userAgent = ((GriverUserAgentExtension) RVProxy.get(GriverUserAgentExtension.class)).getUserAgent();
            if (TextUtils.isEmpty(userAgent)) {
                return this.f6319a;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.f6319a);
            sb.append(" ");
            sb.append(userAgent.trim());
            return sb.toString();
        }

        @Override // com.alibaba.griver.api.common.webview.GriverWebViewSettingExtension
        public final void setUserAgent(String str) {
            if (TextUtils.isEmpty(str) || this.f6319a.contains(str)) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.f6319a);
            sb.append(" ");
            sb.append(str.trim());
            this.f6319a = sb.toString();
        }
    };

    public static String getUserAgent() {
        return TextUtils.isEmpty(f6318a.getUserAgent()) ? "" : f6318a.getUserAgent();
    }

    public static void setUserAgent(String str) {
        f6318a.setUserAgent(str);
    }
}
