package io.split.android.client.service.http;

import com.google.common.base.Preconditions;
import io.split.android.client.network.HttpClient;
import io.split.android.client.network.HttpMethod;
import io.split.android.client.network.HttpResponse;
import io.split.android.client.network.URIBuilder;
import io.split.android.client.service.sseclient.SseAuthenticationResponse;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes6.dex */
public class HttpSseAuthTokenFetcher implements HttpFetcher<SseAuthenticationResponse> {
    private final HttpClient mClient;
    private final HttpResponseParser<SseAuthenticationResponse> mResponseParser;
    private final URI mTarget;

    @Override // io.split.android.client.service.http.HttpFetcher
    public /* bridge */ /* synthetic */ SseAuthenticationResponse execute(Map map, Map map2) throws HttpFetcherException {
        return execute((Map<String, Object>) map, (Map<String, String>) map2);
    }

    public HttpSseAuthTokenFetcher(HttpClient httpClient, URI uri, HttpResponseParser<SseAuthenticationResponse> httpResponseParser) {
        this.mClient = (HttpClient) Preconditions.checkNotNull(httpClient);
        this.mTarget = (URI) Preconditions.checkNotNull(uri);
        this.mResponseParser = (HttpResponseParser) Preconditions.checkNotNull(httpResponseParser);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.split.android.client.service.http.HttpFetcher
    public SseAuthenticationResponse execute(Map<String, Object> map, Map<String, String> map2) throws HttpFetcherException {
        Preconditions.checkNotNull(map);
        try {
            HttpResponse execute = this.mClient.request(getUri(map, this.mTarget), HttpMethod.GET).execute();
            if (!execute.isSuccess()) {
                if (execute.isClientRelatedError()) {
                    return new SseAuthenticationResponse(true);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("http return code ");
                sb.append(execute.getHttpStatus());
                throw new IllegalStateException(sb.toString());
            }
            SseAuthenticationResponse parse = this.mResponseParser.parse(execute.getData());
            if (parse != null) {
                return parse;
            }
            throw new IllegalStateException("Wrong data received from authentication server");
        } catch (Exception e) {
            throw new HttpFetcherException(this.mTarget.toString(), e.getLocalizedMessage());
        }
    }

    private static URI getUri(Map<String, Object> map, URI uri) throws URISyntaxException {
        URIBuilder uRIBuilder = new URIBuilder(uri);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getValue() instanceof Iterable) {
                Iterator it = ((Iterable) entry.getValue()).iterator();
                while (it.hasNext()) {
                    uRIBuilder.addParameter(entry.getKey(), it.next().toString());
                }
            } else {
                uRIBuilder.addParameter(entry.getKey(), String.valueOf(entry.getValue()));
            }
        }
        return uRIBuilder.build();
    }
}
