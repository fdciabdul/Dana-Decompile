package io.split.android.client.network;

import com.google.common.base.Preconditions;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import io.split.android.client.utils.logger.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes6.dex */
public class HttpStreamRequestImpl implements HttpStreamRequest {
    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    private Map<String, String> mHeaders;
    private OkHttpClient mOkHttpClient;
    private Response mOkHttpResponse;
    private BufferedReader mResponseBufferedReader;
    private URI mUri;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpStreamRequestImpl(OkHttpClient okHttpClient, URI uri, Map<String, String> map) {
        this.mOkHttpClient = (OkHttpClient) Preconditions.checkNotNull(okHttpClient);
        this.mUri = (URI) Preconditions.checkNotNull(uri);
        this.mHeaders = new HashMap((Map) Preconditions.checkNotNull(map));
    }

    @Override // io.split.android.client.network.HttpStreamRequest
    public HttpStreamResponse execute() throws HttpException {
        return getRequest();
    }

    @Override // io.split.android.client.network.HttpStreamRequest
    public void addHeader(String str, String str2) {
        this.mHeaders.put(str, str2);
    }

    @Override // io.split.android.client.network.HttpStreamRequest
    public void close() {
        Logger.d("Closing streaming connection");
        Response response = this.mOkHttpResponse;
        if (response != null) {
            if (response.body() != null) {
                try {
                    this.mOkHttpResponse.close();
                    this.mOkHttpResponse.body().close();
                } catch (Exception e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unknown error closing streaming connection: ");
                    sb.append(e.getLocalizedMessage());
                    Logger.d(sb.toString());
                }
            }
            BufferedReader bufferedReader = this.mResponseBufferedReader;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                    Logger.d("Buffer already closed");
                } catch (Exception e2) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Unknown error closing buffer: ");
                    sb2.append(e2.getLocalizedMessage());
                    Logger.d(sb2.toString());
                }
            }
        }
    }

    private HttpStreamResponse getRequest() throws HttpException {
        try {
            Request.Builder url = new Request.Builder().url(this.mUri.toURL());
            addHeaders(url);
            Response execute = FirebasePerfOkHttpClient.execute(this.mOkHttpClient.newCall(url.build()));
            this.mOkHttpResponse = execute;
            return buildResponse(execute);
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

    private void addHeaders(Request.Builder builder) {
        for (Map.Entry<String, String> entry : this.mHeaders.entrySet()) {
            builder.header(entry.getKey(), entry.getValue());
        }
    }

    private HttpStreamResponse buildResponse(Response response) throws IOException {
        int code = response.code();
        if (code >= 200 && code < 300 && response.body() != null) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.body().byteStream()));
            this.mResponseBufferedReader = bufferedReader;
            return new HttpStreamResponseImpl(code, bufferedReader);
        }
        return new HttpStreamResponseImpl(code);
    }
}
