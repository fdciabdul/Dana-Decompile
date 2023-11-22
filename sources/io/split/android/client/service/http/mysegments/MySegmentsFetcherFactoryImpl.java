package io.split.android.client.service.http.mysegments;

import com.google.common.base.Preconditions;
import io.split.android.client.dtos.MySegment;
import io.split.android.client.network.HttpClient;
import io.split.android.client.network.SdkTargetPath;
import io.split.android.client.service.http.HttpFetcher;
import io.split.android.client.service.http.HttpFetcherImpl;
import io.split.android.client.service.mysegments.MySegmentsResponseParser;
import io.split.android.client.utils.logger.Logger;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/* loaded from: classes6.dex */
public class MySegmentsFetcherFactoryImpl implements MySegmentsFetcherFactory {
    private final String mEndpoint;
    private final HttpClient mHttpClient;
    private final MySegmentsResponseParser mMySegmentsResponseParser = new MySegmentsResponseParser();

    public MySegmentsFetcherFactoryImpl(HttpClient httpClient, String str) {
        this.mHttpClient = (HttpClient) Preconditions.checkNotNull(httpClient);
        this.mEndpoint = (String) Preconditions.checkNotNull(str);
    }

    @Override // io.split.android.client.service.http.mysegments.MySegmentsFetcherFactory
    public HttpFetcher<List<MySegment>> getFetcher(String str) {
        return new HttpFetcherImpl(this.mHttpClient, buildTargetUrl(str), this.mMySegmentsResponseParser);
    }

    private URI buildTargetUrl(String str) {
        try {
            return SdkTargetPath.mySegments(this.mEndpoint, str);
        } catch (URISyntaxException e) {
            Logger.e(e.getMessage());
            return URI.create(this.mEndpoint);
        }
    }
}
