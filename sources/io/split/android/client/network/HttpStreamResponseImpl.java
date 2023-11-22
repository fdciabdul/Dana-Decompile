package io.split.android.client.network;

import java.io.BufferedReader;

/* loaded from: classes6.dex */
public class HttpStreamResponseImpl extends BaseHttpResponseImpl implements HttpStreamResponse {
    private BufferedReader mData;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpStreamResponseImpl(int i) {
        this(i, null);
    }

    public HttpStreamResponseImpl(int i, BufferedReader bufferedReader) {
        super(i);
        this.mData = bufferedReader;
    }

    @Override // io.split.android.client.network.HttpStreamResponse
    public BufferedReader getBufferedReader() {
        return this.mData;
    }
}
