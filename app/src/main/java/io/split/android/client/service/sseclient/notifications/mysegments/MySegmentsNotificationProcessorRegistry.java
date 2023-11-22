package io.split.android.client.service.sseclient.notifications.mysegments;

/* loaded from: classes6.dex */
public interface MySegmentsNotificationProcessorRegistry {
    void registerMySegmentsProcessor(String str, MySegmentsNotificationProcessor mySegmentsNotificationProcessor);

    void unregisterMySegmentsProcessor(String str);
}
