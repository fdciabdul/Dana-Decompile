package io.split.android.client.service.http;

import com.google.common.base.Preconditions;
import io.split.android.client.network.HttpClient;
import io.split.android.client.network.HttpMethod;
import io.split.android.client.network.HttpResponse;
import java.net.URI;

/* loaded from: classes6.dex */
public class HttpRecorderImpl<T> implements HttpRecorder<T> {
    private final HttpClient mClient;
    private final HttpRequestBodySerializer<T> mRequestSerializer;
    private final URI mTarget;

    public HttpRecorderImpl(HttpClient httpClient, URI uri, HttpRequestBodySerializer<T> httpRequestBodySerializer) {
        this.mClient = (HttpClient) Preconditions.checkNotNull(httpClient);
        this.mTarget = (URI) Preconditions.checkNotNull(uri);
        this.mRequestSerializer = (HttpRequestBodySerializer) Preconditions.checkNotNull(httpRequestBodySerializer);
    }

    @Override // io.split.android.client.service.http.HttpRecorder
    public void execute(T t) throws HttpRecorderException {
        Preconditions.checkNotNull(t);
        try {
            HttpResponse execute = this.mClient.request(this.mTarget, HttpMethod.POST, this.mRequestSerializer.serialize(t)).execute();
            if (execute.isSuccess()) {
                return;
            }
            int httpStatus = execute.getHttpStatus();
            String obj = this.mTarget.toString();
            StringBuilder sb = new StringBuilder();
            sb.append("http return code ");
            sb.append(httpStatus);
            throw new HttpRecorderException(obj, sb.toString(), Integer.valueOf(httpStatus));
        } catch (HttpRecorderException e) {
            throw e;
        } catch (Exception e2) {
            throw new HttpRecorderException(this.mTarget.toString(), e2.getLocalizedMessage());
        }
    }
}
