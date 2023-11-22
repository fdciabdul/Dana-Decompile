package io.split.android.client.service;

import io.split.android.client.dtos.Event;
import io.split.android.client.dtos.KeyImpression;
import io.split.android.client.dtos.MySegment;
import io.split.android.client.dtos.SplitChange;
import io.split.android.client.network.HttpClient;
import io.split.android.client.network.SdkTargetPath;
import io.split.android.client.service.events.EventsRequestBodySerializer;
import io.split.android.client.service.http.HttpFetcher;
import io.split.android.client.service.http.HttpFetcherImpl;
import io.split.android.client.service.http.HttpRecorder;
import io.split.android.client.service.http.HttpRecorderImpl;
import io.split.android.client.service.http.HttpSseAuthTokenFetcher;
import io.split.android.client.service.impressions.ImpressionsCount;
import io.split.android.client.service.impressions.ImpressionsCountRequestBodySerializer;
import io.split.android.client.service.impressions.ImpressionsRequestBodySerializer;
import io.split.android.client.service.impressions.unique.MTK;
import io.split.android.client.service.impressions.unique.MTKRequestBodySerializer;
import io.split.android.client.service.mysegments.MySegmentsResponseParser;
import io.split.android.client.service.splits.SplitChangeResponseParser;
import io.split.android.client.service.sseauthentication.SseAuthenticationResponseParser;
import io.split.android.client.telemetry.TelemetryConfigBodySerializer;
import io.split.android.client.telemetry.TelemetryStatsBodySerializer;
import io.split.android.client.telemetry.model.Config;
import io.split.android.client.telemetry.model.Stats;
import java.net.URISyntaxException;
import java.util.List;

/* loaded from: classes6.dex */
public class ServiceFactory {
    public static HttpFetcher<SplitChange> getSplitsFetcher(HttpClient httpClient, String str, String str2) throws URISyntaxException {
        return new HttpFetcherImpl(httpClient, SdkTargetPath.splitChanges(str, str2), new SplitChangeResponseParser());
    }

    public static HttpFetcher<List<MySegment>> getMySegmentsFetcher(HttpClient httpClient, String str, String str2) throws URISyntaxException {
        return new HttpFetcherImpl(httpClient, SdkTargetPath.mySegments(str, str2), new MySegmentsResponseParser());
    }

    public static HttpRecorder<List<Event>> getEventsRecorder(HttpClient httpClient, String str) throws URISyntaxException {
        return new HttpRecorderImpl(httpClient, SdkTargetPath.events(str), new EventsRequestBodySerializer());
    }

    public static HttpRecorder<List<KeyImpression>> getImpressionsRecorder(HttpClient httpClient, String str) throws URISyntaxException {
        return new HttpRecorderImpl(httpClient, SdkTargetPath.impressions(str), new ImpressionsRequestBodySerializer());
    }

    public static HttpRecorder<ImpressionsCount> getImpressionsCountRecorder(HttpClient httpClient, String str) throws URISyntaxException {
        return new HttpRecorderImpl(httpClient, SdkTargetPath.impressionsCount(str), new ImpressionsCountRequestBodySerializer());
    }

    public static HttpRecorder<MTK> getUniqueKeysRecorder(HttpClient httpClient, String str) throws URISyntaxException {
        return new HttpRecorderImpl(httpClient, SdkTargetPath.uniqueKeys(str), new MTKRequestBodySerializer());
    }

    public static HttpSseAuthTokenFetcher getSseAuthenticationFetcher(HttpClient httpClient, String str) throws URISyntaxException {
        return new HttpSseAuthTokenFetcher(httpClient, SdkTargetPath.sseAuthentication(str), new SseAuthenticationResponseParser());
    }

    public static HttpRecorder<Config> getTelemetryConfigRecorder(HttpClient httpClient, String str) throws URISyntaxException {
        return new HttpRecorderImpl(httpClient, SdkTargetPath.telemetryConfig(str), new TelemetryConfigBodySerializer());
    }

    public static HttpRecorder<Stats> getTelemetryStatsRecorder(HttpClient httpClient, String str) throws URISyntaxException {
        return new HttpRecorderImpl(httpClient, SdkTargetPath.telemetryStats(str), new TelemetryStatsBodySerializer());
    }
}
