package io.split.android.client.service.sseclient.notifications;

import com.google.common.base.Preconditions;
import com.google.gson.JsonSyntaxException;
import io.split.android.client.dtos.Split;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.executor.SplitTaskFactory;
import io.split.android.client.service.sseclient.notifications.mysegments.MySegmentsNotificationProcessor;
import io.split.android.client.service.sseclient.notifications.mysegments.MySegmentsNotificationProcessorRegistry;
import io.split.android.client.utils.logger.Logger;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes6.dex */
public class NotificationProcessor implements MySegmentsNotificationProcessorRegistry {
    private final ConcurrentMap<String, MySegmentsNotificationProcessor> mMySegmentsNotificationProcessors = new ConcurrentHashMap();
    private final MySegmentsPayloadDecoder mMySegmentsPayloadDecoder;
    private final NotificationParser mNotificationParser;
    private final SplitTaskExecutor mSplitTaskExecutor;
    private final SplitTaskFactory mSplitTaskFactory;
    private final BlockingQueue<SplitsChangeNotification> mSplitsUpdateNotificationsQueue;

    public NotificationProcessor(SplitTaskExecutor splitTaskExecutor, SplitTaskFactory splitTaskFactory, NotificationParser notificationParser, BlockingQueue<SplitsChangeNotification> blockingQueue, MySegmentsPayloadDecoder mySegmentsPayloadDecoder) {
        this.mSplitTaskExecutor = (SplitTaskExecutor) Preconditions.checkNotNull(splitTaskExecutor);
        this.mSplitTaskFactory = (SplitTaskFactory) Preconditions.checkNotNull(splitTaskFactory);
        this.mNotificationParser = (NotificationParser) Preconditions.checkNotNull(notificationParser);
        this.mSplitsUpdateNotificationsQueue = (BlockingQueue) Preconditions.checkNotNull(blockingQueue);
        this.mMySegmentsPayloadDecoder = (MySegmentsPayloadDecoder) Preconditions.checkNotNull(mySegmentsPayloadDecoder);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.split.android.client.service.sseclient.notifications.NotificationProcessor$1 */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$split$android$client$service$sseclient$notifications$NotificationType;

        static {
            int[] iArr = new int[NotificationType.values().length];
            $SwitchMap$io$split$android$client$service$sseclient$notifications$NotificationType = iArr;
            try {
                iArr[NotificationType.SPLIT_UPDATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$split$android$client$service$sseclient$notifications$NotificationType[NotificationType.SPLIT_KILL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$split$android$client$service$sseclient$notifications$NotificationType[NotificationType.MY_SEGMENTS_UPDATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$split$android$client$service$sseclient$notifications$NotificationType[NotificationType.MY_SEGMENTS_UPDATE_V2.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public void process(IncomingNotification incomingNotification) {
        try {
            String jsonData = incomingNotification.getJsonData();
            int i = AnonymousClass1.$SwitchMap$io$split$android$client$service$sseclient$notifications$NotificationType[incomingNotification.getType().ordinal()];
            if (i == 1) {
                processSplitUpdate(this.mNotificationParser.parseSplitUpdate(jsonData));
            } else if (i == 2) {
                processSplitKill(this.mNotificationParser.parseSplitKill(jsonData));
            } else if (i == 3) {
                processMySegmentUpdate(this.mNotificationParser.parseMySegmentUpdate(jsonData), this.mNotificationParser.extractUserKeyHashFromChannel(incomingNotification.getChannel()));
            } else if (i == 4) {
                processMySegmentUpdateV2(this.mNotificationParser.parseMySegmentUpdateV2(jsonData));
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Unknown notification arrived: ");
                sb.append(jsonData);
                Logger.e(sb.toString());
            }
        } catch (JsonSyntaxException e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Error processing incoming push notification: ");
            sb2.append(e.getLocalizedMessage());
            Logger.e(sb2.toString());
        } catch (Exception e2) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Unknown error while processing incoming push notification: ");
            sb3.append(e2.getLocalizedMessage());
            Logger.e(sb3.toString());
        }
    }

    @Override // io.split.android.client.service.sseclient.notifications.mysegments.MySegmentsNotificationProcessorRegistry
    public void registerMySegmentsProcessor(String str, MySegmentsNotificationProcessor mySegmentsNotificationProcessor) {
        this.mMySegmentsNotificationProcessors.put(str, mySegmentsNotificationProcessor);
    }

    @Override // io.split.android.client.service.sseclient.notifications.mysegments.MySegmentsNotificationProcessorRegistry
    public void unregisterMySegmentsProcessor(String str) {
        this.mMySegmentsNotificationProcessors.remove(str);
    }

    private void processSplitUpdate(SplitsChangeNotification splitsChangeNotification) {
        Logger.d("Received split change notification");
        this.mSplitsUpdateNotificationsQueue.offer(splitsChangeNotification);
    }

    private void processSplitKill(SplitKillNotification splitKillNotification) {
        Split split = new Split();
        split.name = splitKillNotification.getSplitName();
        split.defaultTreatment = splitKillNotification.getDefaultTreatment();
        split.changeNumber = splitKillNotification.getChangeNumber();
        this.mSplitTaskExecutor.submit(this.mSplitTaskFactory.createSplitKillTask(split), null);
        this.mSplitsUpdateNotificationsQueue.offer(new SplitsChangeNotification(split.changeNumber));
    }

    private void processMySegmentUpdate(MySegmentChangeNotification mySegmentChangeNotification, String str) {
        for (Map.Entry<String, MySegmentsNotificationProcessor> entry : this.mMySegmentsNotificationProcessors.entrySet()) {
            String hashUserKeyForMySegmentsV1 = this.mMySegmentsPayloadDecoder.hashUserKeyForMySegmentsV1(entry.getKey());
            if (hashUserKeyForMySegmentsV1 != null && hashUserKeyForMySegmentsV1.equals(str)) {
                entry.getValue().processMySegmentsUpdate(mySegmentChangeNotification);
            }
        }
    }

    private void processMySegmentUpdateV2(MySegmentChangeV2Notification mySegmentChangeV2Notification) {
        Iterator<MySegmentsNotificationProcessor> it = this.mMySegmentsNotificationProcessors.values().iterator();
        while (it.hasNext()) {
            it.next().processMySegmentsUpdateV2(mySegmentChangeV2Notification);
        }
    }
}
