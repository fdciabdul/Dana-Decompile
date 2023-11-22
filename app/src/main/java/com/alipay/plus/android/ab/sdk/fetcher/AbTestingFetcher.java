package com.alipay.plus.android.ab.sdk.fetcher;

import com.alipay.plus.android.config.sdk.fetcher.FetchException;
import java.util.Map;

/* loaded from: classes7.dex */
public interface AbTestingFetcher {
    Map<String, String> getVariation(String str, String str2) throws FetchException;
}
