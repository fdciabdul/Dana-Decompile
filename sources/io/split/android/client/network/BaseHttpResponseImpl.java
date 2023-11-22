package io.split.android.client.network;

/* loaded from: classes6.dex */
public abstract class BaseHttpResponseImpl implements BaseHttpResponse {
    protected static final int HTTP_BAD_REQUEST = 400;
    protected static final int HTTP_INTERNAL_SERVER_ERROR = 500;
    protected static final int HTTP_MULTIPLE_CHOICES = 300;
    private static final int HTTP_OK = 200;
    protected static final int HTTP_UNAUTHORIZED = 401;
    private int mHttpStatus;

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseHttpResponseImpl(int i) {
        this.mHttpStatus = i;
    }

    @Override // io.split.android.client.network.BaseHttpResponse
    public boolean isSuccess() {
        int i = this.mHttpStatus;
        return i >= 200 && i < 300;
    }

    @Override // io.split.android.client.network.BaseHttpResponse
    public boolean isCredentialsError() {
        return this.mHttpStatus == 401;
    }

    @Override // io.split.android.client.network.BaseHttpResponse
    public boolean isClientRelatedError() {
        int i = this.mHttpStatus;
        return i >= 400 && i < 500;
    }

    @Override // io.split.android.client.network.BaseHttpResponse
    public boolean isBadRequestError() {
        return this.mHttpStatus == 400;
    }

    @Override // io.split.android.client.network.BaseHttpResponse
    public int getHttpStatus() {
        return this.mHttpStatus;
    }
}
