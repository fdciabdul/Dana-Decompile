package com.alibaba.griver.api.webview;

import android.webkit.GeolocationPermissions;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.griver.api.common.GriverExtension;

/* loaded from: classes6.dex */
public interface GriverGeoLocationExtension extends GriverExtension {
    void onGeolocationPermissionsHidePrompt(Page page);

    void onGeolocationPermissionsShowPrompt(Page page, String str, GeolocationPermissions.Callback callback);
}
