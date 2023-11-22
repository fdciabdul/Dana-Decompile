package io.split.android.client.network;

/* loaded from: classes6.dex */
public class HttpResponseImpl extends BaseHttpResponseImpl implements HttpResponse {
    private String mData;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpResponseImpl(int i) {
        this(i, null);
    }

    public HttpResponseImpl(int i, String str) {
        super(i);
        this.mData = str;
    }

    @Override // io.split.android.client.network.HttpResponse
    public String getData() {
        return this.mData;
    }
}
