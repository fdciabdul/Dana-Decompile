package io.split.android.client.service.sseclient.notifications.mysegments;

import io.split.android.client.service.sseclient.notifications.MySegmentChangeNotification;
import io.split.android.client.service.sseclient.notifications.MySegmentChangeV2Notification;

/* loaded from: classes6.dex */
public interface MySegmentsNotificationProcessor {
    void processMySegmentsUpdate(MySegmentChangeNotification mySegmentChangeNotification);

    void processMySegmentsUpdateV2(MySegmentChangeV2Notification mySegmentChangeV2Notification);
}
