package io.split.android.client.service.sseclient.notifications.mysegments;

import com.google.common.base.Preconditions;
import io.split.android.client.common.CompressionUtilProvider;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.sseclient.notifications.MySegmentsV2PayloadDecoder;
import io.split.android.client.service.sseclient.notifications.NotificationParser;

/* loaded from: classes6.dex */
public class MySegmentsNotificationProcessorFactoryImpl implements MySegmentsNotificationProcessorFactory {
    private final CompressionUtilProvider mCompressionProvider;
    private final MySegmentsV2PayloadDecoder mMySegmentsPayloadDecoder;
    private final NotificationParser mNotificationParser;
    private final SplitTaskExecutor mSplitTaskExecutor;

    public MySegmentsNotificationProcessorFactoryImpl(NotificationParser notificationParser, SplitTaskExecutor splitTaskExecutor, MySegmentsV2PayloadDecoder mySegmentsV2PayloadDecoder, CompressionUtilProvider compressionUtilProvider) {
        this.mNotificationParser = (NotificationParser) Preconditions.checkNotNull(notificationParser);
        this.mSplitTaskExecutor = (SplitTaskExecutor) Preconditions.checkNotNull(splitTaskExecutor);
        this.mMySegmentsPayloadDecoder = (MySegmentsV2PayloadDecoder) Preconditions.checkNotNull(mySegmentsV2PayloadDecoder);
        this.mCompressionProvider = (CompressionUtilProvider) Preconditions.checkNotNull(compressionUtilProvider);
    }

    @Override // io.split.android.client.service.sseclient.notifications.mysegments.MySegmentsNotificationProcessorFactory
    public MySegmentsNotificationProcessor getProcessor(MySegmentsNotificationProcessorConfiguration mySegmentsNotificationProcessorConfiguration) {
        return new MySegmentsNotificationProcessorImpl(this.mNotificationParser, this.mSplitTaskExecutor, this.mMySegmentsPayloadDecoder, this.mCompressionProvider, (MySegmentsNotificationProcessorConfiguration) Preconditions.checkNotNull(mySegmentsNotificationProcessorConfiguration));
    }
}
