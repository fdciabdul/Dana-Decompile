package io.split.android.client.service.http;

import com.google.common.base.Preconditions;
import io.split.android.client.network.HttpClient;
import io.split.android.client.network.HttpMethod;
import io.split.android.client.network.HttpResponse;
import io.split.android.client.network.URIBuilder;
import io.split.android.client.utils.logger.Logger;
import java.net.URI;
import java.util.Map;

/* loaded from: classes6.dex */
public class HttpFetcherImpl<T> implements HttpFetcher<T> {
    private final HttpClient mClient;
    private final HttpResponseParser<T> mResponseParser;
    private final URI mTarget;

    public HttpFetcherImpl(HttpClient httpClient, URI uri, HttpResponseParser<T> httpResponseParser) {
        this.mClient = (HttpClient) Preconditions.checkNotNull(httpClient);
        this.mTarget = (URI) Preconditions.checkNotNull(uri);
        this.mResponseParser = (HttpResponseParser) Preconditions.checkNotNull(httpResponseParser);
    }

    @Override // io.split.android.client.service.http.HttpFetcher
    public T execute(Map<String, Object> map, Map<String, String> map2) throws HttpFetcherException {
        Preconditions.checkNotNull(map);
        try {
            URIBuilder uRIBuilder = new URIBuilder(this.mTarget);
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                Object value = entry.getValue();
                uRIBuilder.addParameter(entry.getKey(), value != null ? value.toString() : "");
            }
            URI build = uRIBuilder.build();
            HttpResponse execute = this.mClient.request(build, HttpMethod.GET, null, map2).execute();
            StringBuilder sb = new StringBuilder();
            sb.append("Received from: ");
            sb.append(build.toString());
            sb.append(" -> ");
            sb.append(execute.getData());
            Logger.d(sb.toString());
            if (!execute.isSuccess()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("http return code ");
                sb2.append(execute.getHttpStatus());
                throw new IllegalStateException(sb2.toString());
            }
            T parse = this.mResponseParser.parse(execute.getData());
            if (parse != null) {
                return parse;
            }
            throw new IllegalStateException("Wrong data received from split changes server");
        } catch (Exception e) {
            throw new HttpFetcherException(this.mTarget.toString(), e.getLocalizedMessage());
        }
    }
}
