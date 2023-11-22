package io.split.android.client.service.http.mysegments;

import io.split.android.client.dtos.MySegment;
import io.split.android.client.service.http.HttpFetcher;
import java.util.List;

/* loaded from: classes6.dex */
public interface MySegmentsFetcherFactory {
    HttpFetcher<List<MySegment>> getFetcher(String str);
}
