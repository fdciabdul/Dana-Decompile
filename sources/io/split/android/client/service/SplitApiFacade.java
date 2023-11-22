package io.split.android.client.service;

import com.google.common.base.Preconditions;
import io.split.android.client.dtos.Event;
import io.split.android.client.dtos.KeyImpression;
import io.split.android.client.dtos.MySegment;
import io.split.android.client.dtos.SplitChange;
import io.split.android.client.service.http.HttpFetcher;
import io.split.android.client.service.http.HttpRecorder;
import io.split.android.client.service.http.mysegments.MySegmentsFetcherFactory;
import io.split.android.client.service.impressions.ImpressionsCount;
import io.split.android.client.service.impressions.unique.MTK;
import io.split.android.client.service.sseclient.SseAuthenticationResponse;
import io.split.android.client.telemetry.model.Config;
import io.split.android.client.telemetry.model.Stats;
import java.util.List;

/* loaded from: classes6.dex */
public class SplitApiFacade {
    private final HttpRecorder<List<Event>> mEventsRecorder;
    private final HttpRecorder<ImpressionsCount> mImpressionsCountRecorder;
    private final HttpRecorder<List<KeyImpression>> mImpressionsRecorder;
    private final MySegmentsFetcherFactory mMySegmentsFetcherFactory;
    private final HttpFetcher<SplitChange> mSplitFetcher;
    private final HttpFetcher<SseAuthenticationResponse> mSseAuthenticationFetcher;
    private final HttpRecorder<Config> mTelemetryConfigRecorder;
    private final HttpRecorder<Stats> mTelemetryStatsRecorder;
    private final HttpRecorder<MTK> mUniqueKeysRecorder;

    public SplitApiFacade(HttpFetcher<SplitChange> httpFetcher, MySegmentsFetcherFactory mySegmentsFetcherFactory, HttpFetcher<SseAuthenticationResponse> httpFetcher2, HttpRecorder<List<Event>> httpRecorder, HttpRecorder<List<KeyImpression>> httpRecorder2, HttpRecorder<ImpressionsCount> httpRecorder3, HttpRecorder<MTK> httpRecorder4, HttpRecorder<Config> httpRecorder5, HttpRecorder<Stats> httpRecorder6) {
        this.mSplitFetcher = (HttpFetcher) Preconditions.checkNotNull(httpFetcher);
        this.mMySegmentsFetcherFactory = (MySegmentsFetcherFactory) Preconditions.checkNotNull(mySegmentsFetcherFactory);
        this.mSseAuthenticationFetcher = (HttpFetcher) Preconditions.checkNotNull(httpFetcher2);
        this.mEventsRecorder = (HttpRecorder) Preconditions.checkNotNull(httpRecorder);
        this.mImpressionsRecorder = (HttpRecorder) Preconditions.checkNotNull(httpRecorder2);
        this.mImpressionsCountRecorder = (HttpRecorder) Preconditions.checkNotNull(httpRecorder3);
        this.mUniqueKeysRecorder = (HttpRecorder) Preconditions.checkNotNull(httpRecorder4);
        this.mTelemetryConfigRecorder = (HttpRecorder) Preconditions.checkNotNull(httpRecorder5);
        this.mTelemetryStatsRecorder = (HttpRecorder) Preconditions.checkNotNull(httpRecorder6);
    }

    public HttpFetcher<SplitChange> getSplitFetcher() {
        return this.mSplitFetcher;
    }

    public HttpFetcher<List<MySegment>> getMySegmentsFetcher(String str) {
        return this.mMySegmentsFetcherFactory.getFetcher(str);
    }

    public HttpFetcher<SseAuthenticationResponse> getSseAuthenticationFetcher() {
        return this.mSseAuthenticationFetcher;
    }

    public HttpRecorder<List<Event>> getEventsRecorder() {
        return this.mEventsRecorder;
    }

    public HttpRecorder<List<KeyImpression>> getImpressionsRecorder() {
        return this.mImpressionsRecorder;
    }

    public HttpRecorder<ImpressionsCount> getImpressionsCountRecorder() {
        return this.mImpressionsCountRecorder;
    }

    public HttpRecorder<MTK> getUniqueKeysRecorder() {
        return this.mUniqueKeysRecorder;
    }

    public HttpRecorder<Config> getTelemetryConfigRecorder() {
        return this.mTelemetryConfigRecorder;
    }

    public HttpRecorder<Stats> getTelemetryStatsRecorder() {
        return this.mTelemetryStatsRecorder;
    }
}
