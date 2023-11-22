package io.split.android.client.service.splits;

import com.google.gson.JsonSyntaxException;
import io.split.android.client.dtos.SplitChange;
import io.split.android.client.service.http.HttpResponseParser;
import io.split.android.client.service.http.HttpResponseParserException;
import io.split.android.client.utils.Json;

/* loaded from: classes6.dex */
public class SplitChangeResponseParser implements HttpResponseParser<SplitChange> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.split.android.client.service.http.HttpResponseParser
    public SplitChange parse(String str) throws HttpResponseParserException {
        try {
            return (SplitChange) Json.fromJson(str, SplitChange.class);
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
