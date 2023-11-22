package com.alibaba.griver.api.cache;

import android.webkit.WebResourceResponse;
import com.alibaba.griver.api.common.GriverExtension;
import java.util.Map;

/* loaded from: classes3.dex */
public interface H5WebViewCacheExtension extends GriverExtension {
    boolean canUseH5Cache(String str);

    WebResourceResponse getEntry(String str, String str2, String str3, Map<String, String> map);

    void presetEntry();
}
