package com.alipay.griver.ccdn;

import android.webkit.WebResourceResponse;
import com.alibaba.griver.api.cache.H5WebViewCacheExtension;
import java.util.Map;

/* loaded from: classes6.dex */
public class CCDNH5WebViewCacheExtensionImpl implements H5WebViewCacheExtension {
    @Override // com.alibaba.griver.api.cache.H5WebViewCacheExtension
    public void presetEntry() {
        CCDNH5CacheManager.getInstance().presetEntry();
    }

    @Override // com.alibaba.griver.api.cache.H5WebViewCacheExtension
    public WebResourceResponse getEntry(String str, String str2, String str3, Map<String, String> map) {
        return CCDNH5CacheManager.getInstance().getEntry(str, str2, str3, map);
    }

    @Override // com.alibaba.griver.api.cache.H5WebViewCacheExtension
    public boolean canUseH5Cache(String str) {
        return CCDNH5CacheManager.getInstance().canUseCCDN(str);
    }
}
