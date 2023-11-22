package io.split.android.client.network;

/* loaded from: classes6.dex */
public interface HttpStreamRequest {
    void addHeader(String str, String str2);

    void close();

    HttpStreamResponse execute() throws HttpException;
}
