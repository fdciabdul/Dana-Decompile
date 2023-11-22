package io.split.android.client.service.sseclient.sseclient;

import com.google.common.base.Preconditions;
import io.split.android.client.service.http.HttpFetcher;
import io.split.android.client.service.http.HttpFetcherException;
import io.split.android.client.service.sseclient.InvalidJwtTokenException;
import io.split.android.client.service.sseclient.SseAuthenticationResponse;
import io.split.android.client.service.sseclient.SseJwtParser;
import io.split.android.client.utils.ConcurrentSet;
import io.split.android.client.utils.logger.Logger;
import java.util.HashMap;
import java.util.Set;

/* loaded from: classes6.dex */
public class SseAuthenticator {
    private static final String USER_KEY_PARAM = "users";
    private final HttpFetcher<SseAuthenticationResponse> mAuthFetcher;
    private final SseJwtParser mJwtParser;
    private final Set<String> mUserKeys = new ConcurrentSet();

    public SseAuthenticator(HttpFetcher<SseAuthenticationResponse> httpFetcher, SseJwtParser sseJwtParser) {
        this.mAuthFetcher = (HttpFetcher) Preconditions.checkNotNull(httpFetcher);
        this.mJwtParser = (SseJwtParser) Preconditions.checkNotNull(sseJwtParser);
    }

    public SseAuthenticationResult authenticate(long j) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(USER_KEY_PARAM, this.mUserKeys);
            SseAuthenticationResponse execute = this.mAuthFetcher.execute(hashMap, null);
            Logger.d("SSE Authentication done, now parsing token");
            if (execute.isClientError()) {
                Logger.d("Error while authenticating to streaming. Check your SDK key is correct.");
                return new SseAuthenticationResult(false, false, false, 0L, null);
            } else if (!execute.isStreamingEnabled()) {
                Logger.d("Streaming disabled for SDK key");
                return new SseAuthenticationResult(true, true, false, 0L, null);
            } else {
                try {
                    if (execute.getSseConnectionDelay() != null) {
                        j = execute.getSseConnectionDelay().longValue();
                    }
                    Logger.d("SSE token parsed successfully");
                    return new SseAuthenticationResult(true, true, true, j, this.mJwtParser.parse(execute.getToken()));
                } catch (InvalidJwtTokenException unused) {
                    Logger.e("Error while parsing Jwt");
                    return unexpectedError();
                }
            }
        } catch (HttpFetcherException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unexpected ");
            sb.append(e.getLocalizedMessage());
            logError(sb.toString());
            if (e.getHttpStatus() != null) {
                return unexpectedHttpError(e.getHttpStatus().intValue());
            }
            return unexpectedError();
        } catch (Exception e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unexpected ");
            sb2.append(e2.getLocalizedMessage());
            logError(sb2.toString());
            return unexpectedError();
        }
    }

    public void registerKey(String str) {
        this.mUserKeys.add(str);
    }

    public void unregisterKey(String str) {
        this.mUserKeys.remove(str);
    }

    private void logError(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("Error while authenticating to SSE server: ");
        sb.append(str);
        Logger.e(sb.toString());
    }

    private SseAuthenticationResult unexpectedError() {
        return new SseAuthenticationResult(false, true);
    }

    private SseAuthenticationResult unexpectedHttpError(int i) {
        return new SseAuthenticationResult(i);
    }
}
