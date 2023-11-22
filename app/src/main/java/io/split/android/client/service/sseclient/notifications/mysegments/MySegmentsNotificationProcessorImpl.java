package io.split.android.client.service.sseclient.notifications.mysegments;

import com.google.common.base.Preconditions;
import io.split.android.client.common.CompressionUtilProvider;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.sseclient.notifications.KeyList;
import io.split.android.client.service.sseclient.notifications.MySegmentChangeNotification;
import io.split.android.client.service.sseclient.notifications.MySegmentChangeV2Notification;
import io.split.android.client.service.sseclient.notifications.MySegmentUpdateStrategy;
import io.split.android.client.service.sseclient.notifications.MySegmentsV2PayloadDecoder;
import io.split.android.client.service.sseclient.notifications.NotificationParser;
import io.split.android.client.utils.logger.Logger;
import java.util.ArrayList;

/* loaded from: classes6.dex */
public class MySegmentsNotificationProcessorImpl implements MySegmentsNotificationProcessor {
    private final CompressionUtilProvider mCompressionProvider;
    private final MySegmentsNotificationProcessorConfiguration mConfiguration;
    private final MySegmentsV2PayloadDecoder mMySegmentsPayloadDecoder;
    private final NotificationParser mNotificationParser;
    private final SplitTaskExecutor mSplitTaskExecutor;

    public MySegmentsNotificationProcessorImpl(NotificationParser notificationParser, SplitTaskExecutor splitTaskExecutor, MySegmentsV2PayloadDecoder mySegmentsV2PayloadDecoder, CompressionUtilProvider compressionUtilProvider, MySegmentsNotificationProcessorConfiguration mySegmentsNotificationProcessorConfiguration) {
        this.mNotificationParser = (NotificationParser) Preconditions.checkNotNull(notificationParser);
        this.mSplitTaskExecutor = (SplitTaskExecutor) Preconditions.checkNotNull(splitTaskExecutor);
        this.mMySegmentsPayloadDecoder = (MySegmentsV2PayloadDecoder) Preconditions.checkNotNull(mySegmentsV2PayloadDecoder);
        this.mCompressionProvider = (CompressionUtilProvider) Preconditions.checkNotNull(compressionUtilProvider);
        this.mConfiguration = (MySegmentsNotificationProcessorConfiguration) Preconditions.checkNotNull(mySegmentsNotificationProcessorConfiguration);
    }

    @Override // io.split.android.client.service.sseclient.notifications.mysegments.MySegmentsNotificationProcessor
    public void processMySegmentsUpdate(MySegmentChangeNotification mySegmentChangeNotification) {
        if (!mySegmentChangeNotification.isIncludesPayload()) {
            this.mConfiguration.getMySegmentUpdateNotificationsQueue().offer(mySegmentChangeNotification);
        } else {
            this.mSplitTaskExecutor.submit(this.mConfiguration.getMySegmentsTaskFactory().createMySegmentsOverwriteTask(mySegmentChangeNotification.getSegmentList() != null ? mySegmentChangeNotification.getSegmentList() : new ArrayList<>()), null);
        }
    }

    /* renamed from: io.split.android.client.service.sseclient.notifications.mysegments.MySegmentsNotificationProcessorImpl$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$split$android$client$service$sseclient$notifications$MySegmentUpdateStrategy;

        static {
            int[] iArr = new int[MySegmentUpdateStrategy.values().length];
            $SwitchMap$io$split$android$client$service$sseclient$notifications$MySegmentUpdateStrategy = iArr;
            try {
                iArr[MySegmentUpdateStrategy.UNBOUNDED_FETCH_REQUEST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$split$android$client$service$sseclient$notifications$MySegmentUpdateStrategy[MySegmentUpdateStrategy.BOUNDED_FETCH_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$split$android$client$service$sseclient$notifications$MySegmentUpdateStrategy[MySegmentUpdateStrategy.KEY_LIST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$split$android$client$service$sseclient$notifications$MySegmentUpdateStrategy[MySegmentUpdateStrategy.SEGMENT_REMOVAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // io.split.android.client.service.sseclient.notifications.mysegments.MySegmentsNotificationProcessor
    public void processMySegmentsUpdateV2(MySegmentChangeV2Notification mySegmentChangeV2Notification) {
        try {
            int i = AnonymousClass1.$SwitchMap$io$split$android$client$service$sseclient$notifications$MySegmentUpdateStrategy[mySegmentChangeV2Notification.getUpdateStrategy().ordinal()];
            if (i == 1) {
                Logger.d("Received Unbounded my segment fetch request");
                notifyMySegmentRefreshNeeded();
            } else if (i == 2) {
                Logger.d("Received Bounded my segment fetch request");
                executeBoundedFetch(this.mMySegmentsPayloadDecoder.decodeAsBytes(mySegmentChangeV2Notification.getData(), this.mCompressionProvider.get(mySegmentChangeV2Notification.getCompression())));
            } else if (i == 3) {
                Logger.d("Received KeyList my segment fetch request");
                updateSegments(this.mMySegmentsPayloadDecoder.decodeAsString(mySegmentChangeV2Notification.getData(), this.mCompressionProvider.get(mySegmentChangeV2Notification.getCompression())), mySegmentChangeV2Notification.getSegmentName());
            } else if (i == 4) {
                Logger.d("Received Segment removal request");
                removeSegment(mySegmentChangeV2Notification.getSegmentName());
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Unknown my segment change v2 notification type: ");
                sb.append(mySegmentChangeV2Notification.getUpdateStrategy());
                Logger.i(sb.toString());
            }
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Executing unbounded fetch because an error has occurred processing my segmentV2 notification: ");
            sb2.append(e.getLocalizedMessage());
            Logger.e(sb2.toString());
            notifyMySegmentRefreshNeeded();
        }
    }

    private void notifyMySegmentRefreshNeeded() {
        this.mConfiguration.getMySegmentUpdateNotificationsQueue().offer(new MySegmentChangeNotification());
    }

    private void removeSegment(String str) {
        if (str == null) {
            return;
        }
        this.mSplitTaskExecutor.submit(this.mConfiguration.getMySegmentsTaskFactory().createMySegmentsUpdateTask(false, str), null);
    }

    private void executeBoundedFetch(byte[] bArr) {
        if (this.mMySegmentsPayloadDecoder.isKeyInBitmap(bArr, this.mMySegmentsPayloadDecoder.computeKeyIndex(this.mConfiguration.getHashedUserKey(), bArr.length))) {
            Logger.d("Executing Unbounded my segment fetch request");
            notifyMySegmentRefreshNeeded();
        }
    }

    private void updateSegments(String str, String str2) {
        if (str2 == null) {
            return;
        }
        KeyList.Action keyListAction = this.mMySegmentsPayloadDecoder.getKeyListAction(this.mNotificationParser.parseKeyList(str), this.mConfiguration.getHashedUserKey());
        boolean z = keyListAction != KeyList.Action.REMOVE;
        if (keyListAction == KeyList.Action.NONE) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Executing KeyList my segment fetch request: Adding = ");
        sb.append(z);
        Logger.d(sb.toString());
        this.mSplitTaskExecutor.submit(this.mConfiguration.getMySegmentsTaskFactory().createMySegmentsUpdateTask(z, str2), null);
    }
}
