package io.split.android.client.network;

import com.google.common.base.Strings;
import com.google.common.net.UrlEscapers;
import java.net.URI;
import java.net.URISyntaxException;

/* loaded from: classes6.dex */
public class SdkTargetPath {
    public static final String EVENTS = "/events/bulk";
    public static final String IMPRESSIONS = "/testImpressions/bulk";
    public static final String IMPRESSIONS_COUNT = "/testImpressions/count";
    public static final String MY_SEGMENTS = "/mySegments";
    public static final String SPLIT_CHANGES = "/splitChanges";
    public static final String SSE_AUTHENTICATION = "/auth";
    public static final String TELEMETRY_CONFIG = "/metrics/config";
    public static final String TELEMETRY_STATS = "/metrics/usage";
    public static final String UNIQUE_KEYS = "/keys/cs";

    public static URI splitChanges(String str, String str2) throws URISyntaxException {
        return buildUrl(str, SPLIT_CHANGES, str2);
    }

    public static URI mySegments(String str, String str2) throws URISyntaxException {
        String escape = str2 != null ? UrlEscapers.urlPathSegmentEscaper().escape(str2) : null;
        StringBuilder sb = new StringBuilder();
        sb.append("/mySegments/");
        sb.append(escape);
        return buildUrl(str, sb.toString());
    }

    public static URI events(String str) throws URISyntaxException {
        return buildUrl(str, EVENTS);
    }

    public static URI impressions(String str) throws URISyntaxException {
        return buildUrl(str, IMPRESSIONS);
    }

    public static URI impressionsCount(String str) throws URISyntaxException {
        return buildUrl(str, IMPRESSIONS_COUNT);
    }

    public static URI sseAuthentication(String str) throws URISyntaxException {
        return buildUrl(str, SSE_AUTHENTICATION);
    }

    public static URI telemetryConfig(String str) throws URISyntaxException {
        return buildUrl(str, TELEMETRY_CONFIG);
    }

    public static URI telemetryStats(String str) throws URISyntaxException {
        return buildUrl(str, TELEMETRY_STATS);
    }

    public static URI uniqueKeys(String str) throws URISyntaxException {
        return buildUrl(str, UNIQUE_KEYS);
    }

    private static URI buildUrl(String str, String str2) throws URISyntaxException {
        return buildUrl(str, str2, null);
    }

    private static URI buildUrl(String str, String str2, String str3) throws URISyntaxException {
        if (str != null && str.endsWith("/")) {
            str = removeLastChar(str);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        String obj = sb.toString();
        if (!Strings.isNullOrEmpty(str3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(obj);
            sb2.append("?");
            sb2.append(str3);
            obj = sb2.toString();
        }
        return new URI(obj);
    }

    private static String removeLastChar(String str) {
        return (str == null || str.length() == 0) ? str : str.substring(0, str.length() - 1);
    }
}
