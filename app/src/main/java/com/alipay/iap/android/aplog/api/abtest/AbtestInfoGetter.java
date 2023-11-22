package com.alipay.iap.android.aplog.api.abtest;

import java.util.Map;

/* loaded from: classes3.dex */
public interface AbtestInfoGetter {
    Map<String, String> getExtInfoForSpmID(String str);

    String getLogForSpmID(String str);
}
