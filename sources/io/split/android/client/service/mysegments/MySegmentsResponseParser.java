package io.split.android.client.service.mysegments;

import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import io.split.android.client.dtos.MySegment;
import io.split.android.client.service.http.HttpResponseParser;
import io.split.android.client.service.http.HttpResponseParserException;
import io.split.android.client.utils.Json;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class MySegmentsResponseParser implements HttpResponseParser<List<MySegment>> {
    private static final Type MY_SEGMENTS_RESPONSE_TYPE = new TypeToken<Map<String, List<MySegment>>>() { // from class: io.split.android.client.service.mysegments.MySegmentsResponseParser.1
    }.getType();

    @Override // io.split.android.client.service.http.HttpResponseParser
    public List<MySegment> parse(String str) throws HttpResponseParserException {
        try {
            return (List) ((Map) Json.fromJson(str, MY_SEGMENTS_RESPONSE_TYPE)).get("mySegments");
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
