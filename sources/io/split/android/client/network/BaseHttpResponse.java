package io.split.android.client.network;

/* loaded from: classes6.dex */
public interface BaseHttpResponse {
    int getHttpStatus();

    boolean isBadRequestError();

    boolean isClientRelatedError();

    boolean isCredentialsError();

    boolean isSuccess();
}
