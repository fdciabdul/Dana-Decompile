package com.alipay.plus.android.config.sdk.fetcher;

import java.util.Map;

/* loaded from: classes7.dex */
public interface ConfigNotifyCallback {
    void onFetchFailed(String str, String str2);

    void onFetchSuccess(Map<String, Object> map);
}
