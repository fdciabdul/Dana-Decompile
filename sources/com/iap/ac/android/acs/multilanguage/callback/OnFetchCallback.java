package com.iap.ac.android.acs.multilanguage.callback;

import java.util.Map;

/* loaded from: classes3.dex */
public interface OnFetchCallback {
    void onFetchOnError(String str, String str2);

    void onFetchSuccess(String str, Map<String, String> map);
}
