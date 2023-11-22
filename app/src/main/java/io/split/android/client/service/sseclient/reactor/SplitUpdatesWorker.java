package io.split.android.client.service.sseclient.reactor;

import com.google.common.base.Preconditions;
import io.split.android.client.common.CompressionUtilProvider;
import io.split.android.client.dtos.Split;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskExecutionListener;
import io.split.android.client.service.executor.SplitTaskExecutionStatus;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.executor.SplitTaskFactory;
import io.split.android.client.service.sseclient.notifications.SplitsChangeNotification;
import io.split.android.client.service.synchronizer.Synchronizer;
import io.split.android.client.storage.splits.SplitsStorage;
import io.split.android.client.utils.Base64Util;
import io.split.android.client.utils.CompressionUtil;
import io.split.android.client.utils.Json;
import io.split.android.client.utils.logger.Logger;
import java.util.concurrent.BlockingQueue;

/* loaded from: classes6.dex */
public class SplitUpdatesWorker extends UpdateWorker {
    private final Base64Decoder mBase64Decoder;
    private final CompressionUtilProvider mCompressionUtilProvider;
    private final BlockingQueue<SplitsChangeNotification> mNotificationsQueue;
    private final SplitTaskExecutor mSplitTaskExecutor;
    private final SplitTaskFactory mSplitTaskFactory;
    private final SplitsStorage mSplitsStorage;
    private final Synchronizer mSynchronizer;

    /* loaded from: classes6.dex */
    public interface Base64Decoder {
        byte[] decode(String str);
    }

    public SplitUpdatesWorker(Synchronizer synchronizer, BlockingQueue<SplitsChangeNotification> blockingQueue, SplitsStorage splitsStorage, CompressionUtilProvider compressionUtilProvider, SplitTaskExecutor splitTaskExecutor, SplitTaskFactory splitTaskFactory) {
        this(synchronizer, blockingQueue, splitsStorage, compressionUtilProvider, splitTaskExecutor, splitTaskFactory, new Base64DecoderImpl());
    }

    public SplitUpdatesWorker(Synchronizer synchronizer, BlockingQueue<SplitsChangeNotification> blockingQueue, SplitsStorage splitsStorage, CompressionUtilProvider compressionUtilProvider, SplitTaskExecutor splitTaskExecutor, SplitTaskFactory splitTaskFactory, Base64Decoder base64Decoder) {
        this.mSynchronizer = (Synchronizer) Preconditions.checkNotNull(synchronizer);
        this.mNotificationsQueue = (BlockingQueue) Preconditions.checkNotNull(blockingQueue);
        this.mSplitsStorage = (SplitsStorage) Preconditions.checkNotNull(splitsStorage);
        this.mCompressionUtilProvider = (CompressionUtilProvider) Preconditions.checkNotNull(compressionUtilProvider);
        this.mSplitTaskExecutor = (SplitTaskExecutor) Preconditions.checkNotNull(splitTaskExecutor);
        this.mSplitTaskFactory = (SplitTaskFactory) Preconditions.checkNotNull(splitTaskFactory);
        this.mBase64Decoder = (Base64Decoder) Preconditions.checkNotNull(base64Decoder);
    }

    @Override // io.split.android.client.service.sseclient.reactor.UpdateWorker
    protected void onWaitForNotificationLoop() throws InterruptedException {
        try {
            SplitsChangeNotification take = this.mNotificationsQueue.take();
            Logger.d("A new notification to update feature flags has been received");
            long till = this.mSplitsStorage.getTill();
            if (take.getChangeNumber() <= till) {
                Logger.d("Notification change number is lower than the current one. Ignoring notification");
                return;
            }
            if (!isLegacyNotification(take) && !isInvalidChangeNumber(take, till)) {
                handleNotification(take);
                return;
            }
            handleLegacyNotification(take.getChangeNumber());
        } catch (InterruptedException e) {
            Logger.d("Feature flags update worker has been interrupted");
            throw e;
        }
    }

    private static boolean isInvalidChangeNumber(SplitsChangeNotification splitsChangeNotification, long j) {
        return splitsChangeNotification.getPreviousChangeNumber() == null || splitsChangeNotification.getPreviousChangeNumber().longValue() == 0 || j != splitsChangeNotification.getPreviousChangeNumber().longValue();
    }

    private static boolean isLegacyNotification(SplitsChangeNotification splitsChangeNotification) {
        return splitsChangeNotification.getData() == null || splitsChangeNotification.getCompressionType() == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleLegacyNotification(long j) {
        this.mSynchronizer.synchronizeSplits(j);
        Logger.d("Enqueuing polling task");
    }

    private void handleNotification(final SplitsChangeNotification splitsChangeNotification) {
        String decompressData = decompressData(splitsChangeNotification.getData(), this.mCompressionUtilProvider.get(splitsChangeNotification.getCompressionType()));
        if (decompressData == null) {
            handleLegacyNotification(splitsChangeNotification.getChangeNumber());
            return;
        }
        try {
            this.mSplitTaskExecutor.submit(this.mSplitTaskFactory.createSplitsUpdateTask((Split) Json.fromJson(decompressData, Split.class), splitsChangeNotification.getChangeNumber()), new SplitTaskExecutionListener() { // from class: io.split.android.client.service.sseclient.reactor.SplitUpdatesWorker.1
                @Override // io.split.android.client.service.executor.SplitTaskExecutionListener
                public void taskExecuted(SplitTaskExecutionInfo splitTaskExecutionInfo) {
                    if (splitTaskExecutionInfo.getStatus() == SplitTaskExecutionStatus.ERROR) {
                        SplitUpdatesWorker.this.handleLegacyNotification(splitsChangeNotification.getChangeNumber());
                    }
                }
            });
        } catch (Exception unused) {
            Logger.e("Could not parse feature flag");
            handleLegacyNotification(splitsChangeNotification.getChangeNumber());
        }
    }

    private String decompressData(String str, CompressionUtil compressionUtil) {
        try {
            if (compressionUtil == null) {
                Logger.e("Compression type not supported");
                return null;
            }
            byte[] decode = this.mBase64Decoder.decode(str);
            if (decode == null) {
                Logger.e("Could not decode payload");
                return null;
            }
            byte[] decompress = compressionUtil.decompress(decode);
            if (decompress == null) {
                Logger.e("Decompressed payload is null");
                return null;
            }
            return new String(decompress);
        } catch (Exception unused) {
            Logger.e("Could not decompress payload");
            return null;
        }
    }

    /* loaded from: classes6.dex */
    static class Base64DecoderImpl implements Base64Decoder {
        private Base64DecoderImpl() {
        }

        @Override // io.split.android.client.service.sseclient.reactor.SplitUpdatesWorker.Base64Decoder
        public byte[] decode(String str) {
            return Base64Util.bytesDecode(str);
        }
    }
}
