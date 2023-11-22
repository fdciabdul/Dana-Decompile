package io.split.android.client.service.http;

import java.util.Map;

/* loaded from: classes6.dex */
public interface HttpFetcher<T> {
    T execute(Map<String, Object> map, Map<String, String> map2) throws HttpFetcherException;
}
