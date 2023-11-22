package io.split.android.client.service.mysegments;

import com.google.common.base.Preconditions;
import io.split.android.client.dtos.MySegment;
import io.split.android.client.events.SplitEventsManager;
import io.split.android.client.service.http.HttpFetcher;
import io.split.android.client.storage.mysegments.MySegmentsStorage;
import java.util.List;

/* loaded from: classes6.dex */
public class MySegmentsTaskFactoryConfiguration {
    private final SplitEventsManager mEventsManager;
    private final HttpFetcher<List<MySegment>> mHttpFetcher;
    private final MySegmentsStorage mStorage;

    public MySegmentsTaskFactoryConfiguration(HttpFetcher<List<MySegment>> httpFetcher, MySegmentsStorage mySegmentsStorage, SplitEventsManager splitEventsManager) {
        this.mHttpFetcher = (HttpFetcher) Preconditions.checkNotNull(httpFetcher);
        this.mStorage = (MySegmentsStorage) Preconditions.checkNotNull(mySegmentsStorage);
        this.mEventsManager = (SplitEventsManager) Preconditions.checkNotNull(splitEventsManager);
    }

    public HttpFetcher<List<MySegment>> getHttpFetcher() {
        return this.mHttpFetcher;
    }

    public MySegmentsStorage getStorage() {
        return this.mStorage;
    }

    public SplitEventsManager getEventsManager() {
        return this.mEventsManager;
    }
}
