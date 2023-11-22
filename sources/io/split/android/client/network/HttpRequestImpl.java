package io.split.android.client.network;

import com.google.common.base.Preconditions;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* loaded from: classes6.dex */
public class HttpRequestImpl implements HttpRequest {
    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    private final String mBody;
    private final Map<String, String> mHeaders;
    private final HttpMethod mHttpMethod;
    private final OkHttpClient mOkHttpClient;
    private final URI mUri;
    private final UrlSanitizer mUrlSanitizer;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpRequestImpl(OkHttpClient okHttpClient, URI uri, HttpMethod httpMethod, String str, Map<String, String> map) {
        this(okHttpClient, uri, httpMethod, str, map, new UrlSanitizerImpl());
    }

    HttpRequestImpl(OkHttpClient okHttpClient, URI uri, HttpMethod httpMethod, String str, Map<String, String> map, UrlSanitizer urlSanitizer) {
        this.mOkHttpClient = (OkHttpClient) Preconditions.checkNotNull(okHttpClient);
        this.mUri = (URI) Preconditions.checkNotNull(uri);
        this.mHttpMethod = (HttpMethod) Preconditions.checkNotNull(httpMethod);
        this.mBody = str;
        this.mHeaders = new HashMap((Map) Preconditions.checkNotNull(map));
        this.mUrlSanitizer = (UrlSanitizer) Preconditions.checkNotNull(urlSanitizer);
    }

    /* renamed from: io.split.android.client.network.HttpRequestImpl$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$split$android$client$network$HttpMethod;

        static {
            int[] iArr = new int[HttpMethod.values().length];
            $SwitchMap$io$split$android$client$network$HttpMethod = iArr;
            try {
                iArr[HttpMethod.GET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$split$android$client$network$HttpMethod[HttpMethod.POST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // io.split.android.client.network.HttpRequest
    public HttpResponse execute() throws HttpException {
        int i = AnonymousClass1.$SwitchMap$io$split$android$client$network$HttpMethod[this.mHttpMethod.ordinal()];
        if (i != 1) {
            if (i == 2) {
                try {
                    return postRequest();
                } catch (IOException e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Error serializing request body: ");
                    sb.append(e.getLocalizedMessage());
                    throw new HttpException(sb.toString());
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Request HTTP Method not valid: ");
            sb2.append(this.mHttpMethod.name());
            throw new IllegalArgumentException(sb2.toString());
        }
        return getRequest();
    }

    private HttpResponse getRequest() throws HttpException {
        try {
            Request.Builder url = new Request.Builder().url(this.mUrlSanitizer.getUrl(this.mUri));
            addHeaders(url);
            return buildResponse(FirebasePerfOkHttpClient.execute(this.mOkHttpClient.newCall(url.build())));
        } catch (MalformedURLException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("URL is malformed: ");
            sb.append(e.getLocalizedMessage());
            throw new HttpException(sb.toString());
        } catch (ProtocolException e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Http method not allowed: ");
            sb2.append(e2.getLocalizedMessage());
            throw new HttpException(sb2.toString());
        } catch (IOException e3) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Something happened while retrieving data: ");
            sb3.append(e3.getLocalizedMessage());
            throw new HttpException(sb3.toString());
        }
    }

    private HttpResponse postRequest() throws IOException {
        if (this.mBody == null) {
            throw new IOException("Json data is null");
        }
        URL url = this.mUri.toURL();
        Request.Builder post = new Request.Builder().url(url).post(RequestBody.create(JSON, this.mBody));
        addHeaders(post);
        return buildResponse(FirebasePerfOkHttpClient.execute(this.mOkHttpClient.newCall(post.build())));
    }

    private void addHeaders(Request.Builder builder) {
        for (Map.Entry<String, String> entry : this.mHeaders.entrySet()) {
            builder.header(entry.getKey(), entry.getValue());
        }
    }

    private HttpResponse buildResponse(Response response) throws IOException {
        int code = response.code();
        if (code >= 200 && code < 300) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.body().byteStream()));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            bufferedReader.close();
            return new HttpResponseImpl(code, sb.length() > 0 ? sb.toString() : null);
        }
        return new HttpResponseImpl(code);
    }
}
