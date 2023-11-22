package io.split.android.client.service.mysegments;

import java.util.List;

/* loaded from: classes6.dex */
public interface MySegmentsTaskFactory {
    LoadMySegmentsTask createLoadMySegmentsTask();

    MySegmentsOverwriteTask createMySegmentsOverwriteTask(List<String> list);

    MySegmentsSyncTask createMySegmentsSyncTask(boolean z);

    MySegmentsUpdateTask createMySegmentsUpdateTask(boolean z, String str);
}
