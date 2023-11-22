package io.split.android.client.service.sseclient.sseclient;

import com.google.common.base.Preconditions;
import io.split.android.client.network.HttpClient;
import io.split.android.client.network.HttpStreamRequest;
import io.split.android.client.service.sseclient.EventStreamParser;
import io.split.android.client.utils.StringHelper;
import io.split.android.client.utils.logger.Logger;
import java.net.URI;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes6.dex */
public class SseClientImpl implements SseClient {
    private static final String PUSH_NOTIFICATION_CHANNELS_PARAM = "channel";
    private static final String PUSH_NOTIFICATION_TOKEN_PARAM = "accessToken";
    private static final String PUSH_NOTIFICATION_VERSION_PARAM = "v";
    private static final String PUSH_NOTIFICATION_VERSION_VALUE = "1.1";
    private final EventStreamParser mEventStreamParser;
    private final HttpClient mHttpClient;
    private HttpStreamRequest mHttpStreamRequest = null;
    private final AtomicBoolean mIsDisconnectCalled;
    private final SseHandler mSseHandler;
    private final AtomicInteger mStatus;
    private final StringHelper mStringHelper;
    private final URI mTargetUrl;

    public SseClientImpl(URI uri, HttpClient httpClient, EventStreamParser eventStreamParser, SseHandler sseHandler) {
        this.mTargetUrl = (URI) Preconditions.checkNotNull(uri);
        this.mHttpClient = (HttpClient) Preconditions.checkNotNull(httpClient);
        this.mEventStreamParser = (EventStreamParser) Preconditions.checkNotNull(eventStreamParser);
        this.mSseHandler = (SseHandler) Preconditions.checkNotNull(sseHandler);
        AtomicInteger atomicInteger = new AtomicInteger(2);
        this.mStatus = atomicInteger;
        this.mIsDisconnectCalled = new AtomicBoolean(false);
        this.mStringHelper = new StringHelper();
        atomicInteger.set(2);
    }

    @Override // io.split.android.client.service.sseclient.sseclient.SseClient
    public int status() {
        return this.mStatus.get();
    }

    @Override // io.split.android.client.service.sseclient.sseclient.SseClient
    public void disconnect() {
        this.mIsDisconnectCalled.set(true);
        close();
    }

    private void close() {
        Logger.d("Disconnecting SSE client");
        if (this.mStatus.getAndSet(2) != 2) {
            HttpStreamRequest httpStreamRequest = this.mHttpStreamRequest;
            if (httpStreamRequest != null) {
                httpStreamRequest.close();
            }
            Logger.d("SSE client disconnected");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    @Override // io.split.android.client.service.sseclient.sseclient.SseClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void connect(io.split.android.client.service.sseclient.SseJwtToken r7, io.split.android.client.service.sseclient.sseclient.SseClient.ConnectionListener r8) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.split.android.client.service.sseclient.sseclient.SseClientImpl.connect(io.split.android.client.service.sseclient.SseJwtToken, io.split.android.client.service.sseclient.sseclient.SseClient$ConnectionListener):void");
    }

    private void logError(String str, Exception exc) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" : ");
        sb.append(exc.getLocalizedMessage());
        Logger.e(sb.toString());
    }
}
