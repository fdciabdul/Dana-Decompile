package io.split.android.client.service.sseauthentication;

import com.google.gson.JsonSyntaxException;
import io.split.android.client.service.http.HttpResponseParser;
import io.split.android.client.service.http.HttpResponseParserException;
import io.split.android.client.service.sseclient.SseAuthenticationResponse;
import io.split.android.client.utils.Json;

/* loaded from: classes6.dex */
public class SseAuthenticationResponseParser implements HttpResponseParser<SseAuthenticationResponse> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.split.android.client.service.http.HttpResponseParser
    public SseAuthenticationResponse parse(String str) throws HttpResponseParserException {
        try {
            return (SseAuthenticationResponse) Json.fromJson(str, SseAuthenticationResponse.class);
        } catch (JsonSyntaxException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Syntax error parsing my segments http response: ");
            sb.append(e.getLocalizedMessage());
            throw new HttpResponseParserException(sb.toString());
        } catch (Exception e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unknown error parsing my segments http response: ");
            sb2.append(e2.getLocalizedMessage());
            throw new HttpResponseParserException(sb2.toString());
        }
    }
}
