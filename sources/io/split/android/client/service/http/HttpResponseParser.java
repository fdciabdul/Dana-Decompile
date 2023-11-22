package io.split.android.client.service.http;

/* loaded from: classes6.dex */
public interface HttpResponseParser<T> {
    T parse(String str) throws HttpResponseParserException;
}
