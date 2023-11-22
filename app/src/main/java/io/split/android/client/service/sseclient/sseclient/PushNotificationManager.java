package io.split.android.client.service.sseclient.sseclient;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import io.split.android.client.service.executor.SplitSingleThreadTaskExecutor;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.service.sseclient.SseJwtToken;
import io.split.android.client.service.sseclient.feedbackchannel.DelayStatusEvent;
import io.split.android.client.service.sseclient.feedbackchannel.PushManagerEventBroadcaster;
import io.split.android.client.service.sseclient.feedbackchannel.PushStatusEvent;
import io.split.android.client.service.sseclient.sseclient.SseClient;
import io.split.android.client.telemetry.model.OperationType;
import io.split.android.client.telemetry.model.streaming.SyncModeUpdateStreamingEvent;
import io.split.android.client.telemetry.model.streaming.TokenRefreshStreamingEvent;
import io.split.android.client.telemetry.storage.TelemetryRuntimeProducer;
import io.split.android.client.utils.logger.Logger;
import java.lang.Thread;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes6.dex */
public class PushNotificationManager {
    private static final long AWAIT_SHUTDOWN_TIME = 5;
    private static final int POOL_SIZE = 1;
    private final SplitTask mBackgroundDisconnectionTask;
    private final PushManagerEventBroadcaster mBroadcasterChannel;
    private Future<?> mConnectionTask;
    private final long mDefaultSSEConnectionDelayInSecs;
    private final SseDisconnectionTimer mDisconnectionTimer;
    private final ScheduledExecutorService mExecutor;
    private final AtomicBoolean mIsPaused;
    private final AtomicBoolean mIsStopped;
    private final SseRefreshTokenTimer mRefreshTokenTimer;
    private final SseAuthenticator mSseAuthenticator;
    private final SseClient mSseClient;
    private final TelemetryRuntimeProducer mTelemetryRuntimeProducer;
    public static final byte[] MyBillsEntityDataFactory = {125, -100, 71, Ascii.FS, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 223;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002d -> B:11:0x0039). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = io.split.android.client.service.sseclient.sseclient.PushNotificationManager.MyBillsEntityDataFactory
            int r7 = r7 * 3
            int r7 = 16 - r7
            int r6 = r6 * 12
            int r6 = 15 - r6
            int r8 = r8 * 7
            int r8 = 106 - r8
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1d
            r8 = r7
            r3 = r1
            r4 = 0
            r7 = r6
            r1 = r0
            r0 = r9
            r9 = r8
            goto L39
        L1d:
            r3 = 0
        L1e:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r6 = r6 + 1
            if (r3 != r7) goto L2d
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2d:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L39:
            int r6 = -r6
            int r8 = r8 + r6
            int r8 = r8 + 2
            r6 = r7
            r7 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1e
        */
        throw new UnsupportedOperationException("Method not decompiled: io.split.android.client.service.sseclient.sseclient.PushNotificationManager.a(byte, byte, int, java.lang.Object[]):void");
    }

    public PushNotificationManager(PushManagerEventBroadcaster pushManagerEventBroadcaster, SseAuthenticator sseAuthenticator, SseClient sseClient, SseRefreshTokenTimer sseRefreshTokenTimer, TelemetryRuntimeProducer telemetryRuntimeProducer, long j, long j2, ScheduledExecutorService scheduledExecutorService) {
        this(pushManagerEventBroadcaster, sseAuthenticator, sseClient, sseRefreshTokenTimer, new SseDisconnectionTimer(new SplitSingleThreadTaskExecutor(), PushNotificationManager$$ExternalSyntheticBackport0.m(j2)), telemetryRuntimeProducer, j, scheduledExecutorService);
    }

    public PushNotificationManager(PushManagerEventBroadcaster pushManagerEventBroadcaster, SseAuthenticator sseAuthenticator, SseClient sseClient, SseRefreshTokenTimer sseRefreshTokenTimer, SseDisconnectionTimer sseDisconnectionTimer, TelemetryRuntimeProducer telemetryRuntimeProducer, long j, ScheduledExecutorService scheduledExecutorService) {
        this.mBroadcasterChannel = (PushManagerEventBroadcaster) Preconditions.checkNotNull(pushManagerEventBroadcaster);
        this.mSseAuthenticator = (SseAuthenticator) Preconditions.checkNotNull(sseAuthenticator);
        SseClient sseClient2 = (SseClient) Preconditions.checkNotNull(sseClient);
        this.mSseClient = sseClient2;
        SseRefreshTokenTimer sseRefreshTokenTimer2 = (SseRefreshTokenTimer) Preconditions.checkNotNull(sseRefreshTokenTimer);
        this.mRefreshTokenTimer = sseRefreshTokenTimer2;
        this.mDisconnectionTimer = (SseDisconnectionTimer) Preconditions.checkNotNull(sseDisconnectionTimer);
        this.mTelemetryRuntimeProducer = (TelemetryRuntimeProducer) Preconditions.checkNotNull(telemetryRuntimeProducer);
        this.mIsStopped = new AtomicBoolean(false);
        this.mIsPaused = new AtomicBoolean(false);
        this.mBackgroundDisconnectionTask = new BackgroundDisconnectionTask(sseClient2, sseRefreshTokenTimer2);
        this.mDefaultSSEConnectionDelayInSecs = j;
        if (scheduledExecutorService != null) {
            this.mExecutor = scheduledExecutorService;
        } else {
            this.mExecutor = buildExecutor();
        }
    }

    public void start() {
        synchronized (this) {
            this.mTelemetryRuntimeProducer.recordStreamingEvents(new SyncModeUpdateStreamingEvent(SyncModeUpdateStreamingEvent.Mode.STREAMING, System.currentTimeMillis()));
            Logger.d("Push notification manager started");
            connect();
        }
    }

    public void pause() {
        this.mIsPaused.set(true);
        this.mDisconnectionTimer.schedule(this.mBackgroundDisconnectionTask);
        Logger.d("Push notification manager paused");
    }

    public void resume() {
        if (this.mIsPaused.compareAndSet(true, false)) {
            this.mDisconnectionTimer.cancel();
            if (isSseClientDisconnected() && !this.mIsStopped.get()) {
                connect();
            }
            Logger.d("Push notification manager resumed");
        }
    }

    public boolean isSseClientDisconnected() {
        return this.mSseClient.status() == 2;
    }

    public void stop() {
        synchronized (this) {
            Logger.d("Shutting down SSE client");
            this.mIsStopped.set(true);
            disconnect();
            shutdownAndAwaitTermination();
        }
    }

    public void disconnect() {
        Logger.d("Disconnecting down SSE client");
        this.mDisconnectionTimer.cancel();
        this.mRefreshTokenTimer.cancel();
        this.mSseClient.disconnect();
    }

    public void connect() {
        if (this.mSseClient.status() == 1) {
            this.mSseClient.disconnect();
        }
        Future<?> future = this.mConnectionTask;
        if (future != null && (!future.isDone() || !this.mConnectionTask.isCancelled())) {
            this.mConnectionTask.cancel(true);
        }
        this.mConnectionTask = this.mExecutor.submit(new StreamingConnection(this.mDefaultSSEConnectionDelayInSecs));
    }

    private void shutdownAndAwaitTermination() {
        this.mExecutor.shutdown();
        try {
            if (this.mExecutor.awaitTermination(5L, TimeUnit.SECONDS)) {
                return;
            }
            this.mExecutor.shutdownNow();
            if (this.mExecutor.awaitTermination(5L, TimeUnit.SECONDS)) {
                return;
            }
            System.err.println("Sse client pool did not terminate");
        } catch (InterruptedException unused) {
            this.mExecutor.shutdownNow();
            try {
                byte b = (byte) (MyBillsEntityDataFactory[15] + 1);
                byte b2 = b;
                Object[] objArr = new Object[1];
                a(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = (byte) (-MyBillsEntityDataFactory[15]);
                byte b4 = b3;
                Object[] objArr2 = new Object[1];
                a(b3, b4, b4, objArr2);
                ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).interrupt();
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
    }

    private ScheduledThreadPoolExecutor buildExecutor() {
        ThreadFactoryBuilder threadFactoryBuilder = new ThreadFactoryBuilder();
        threadFactoryBuilder.setDaemon(true);
        threadFactoryBuilder.setNameFormat("split-sse_client-%d");
        threadFactoryBuilder.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: io.split.android.client.service.sseclient.sseclient.PushNotificationManager.1
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                Logger.e(th, "Error in thread: %s", thread.getName());
            }
        });
        return new ScheduledThreadPoolExecutor(1, threadFactoryBuilder.build());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class StreamingConnection implements Runnable {
        private final long mDefaultSSEConnectionDelayInSecs;
        public static final byte[] PlaceComponentResult = {114, -124, TarHeader.LF_CONTIG, 72, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
        public static final int BuiltInFictitiousFunctionClassFactory = 36;

        /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0034). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void a(byte r7, byte r8, int r9, java.lang.Object[] r10) {
            /*
                int r7 = r7 * 7
                int r7 = r7 + 99
                int r8 = r8 + 4
                int r9 = r9 * 3
                int r9 = 16 - r9
                byte[] r0 = io.split.android.client.service.sseclient.sseclient.PushNotificationManager.StreamingConnection.PlaceComponentResult
                byte[] r1 = new byte[r9]
                r2 = 0
                if (r0 != 0) goto L18
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r10
                r10 = r9
                r9 = r8
                goto L34
            L18:
                r3 = 0
            L19:
                int r8 = r8 + 1
                int r4 = r3 + 1
                byte r5 = (byte) r7
                r1[r3] = r5
                if (r4 != r9) goto L2a
                java.lang.String r7 = new java.lang.String
                r7.<init>(r1, r2)
                r10[r2] = r7
                return
            L2a:
                r3 = r0[r8]
                r6 = r8
                r8 = r7
                r7 = r3
                r3 = r1
                r1 = r0
                r0 = r10
                r10 = r9
                r9 = r6
            L34:
                int r8 = r8 + r7
                int r7 = r8 + 2
                r8 = r9
                r9 = r10
                r10 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                goto L19
            */
            throw new UnsupportedOperationException("Method not decompiled: io.split.android.client.service.sseclient.sseclient.PushNotificationManager.StreamingConnection.a(byte, byte, int, java.lang.Object[]):void");
        }

        public StreamingConnection(long j) {
            this.mDefaultSSEConnectionDelayInSecs = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            SseAuthenticationResult authenticate = PushNotificationManager.this.mSseAuthenticator.authenticate(this.mDefaultSSEConnectionDelayInSecs);
            PushNotificationManager.this.mTelemetryRuntimeProducer.recordSyncLatency(OperationType.TOKEN, System.currentTimeMillis() - currentTimeMillis);
            if (authenticate.isSuccess() && !authenticate.isPushEnabled()) {
                handlePushDisabled();
            } else if (!authenticate.isSuccess() && !authenticate.isErrorRecoverable()) {
                handleNonRetryableError(authenticate);
                recordNonRetryableError(authenticate);
            } else if (!authenticate.isSuccess() && authenticate.isErrorRecoverable()) {
                handleRetryableError();
            } else {
                final SseJwtToken jwtToken = authenticate.getJwtToken();
                if (jwtToken == null || jwtToken.getChannels() == null || jwtToken.getRawJwt() == null) {
                    handleAuthError();
                    return;
                }
                recordSuccessfulSyncAndTokenRefreshes(jwtToken);
                long sseConnectionDelay = authenticate.getSseConnectionDelay();
                if (sseConnectionDelay <= 0 || delay(sseConnectionDelay)) {
                    PushNotificationManager.this.mBroadcasterChannel.pushMessage(new DelayStatusEvent(sseConnectionDelay));
                    if (PushNotificationManager.this.mIsPaused.get() || PushNotificationManager.this.mIsStopped.get()) {
                        return;
                    }
                    PushNotificationManager.this.mSseClient.connect(jwtToken, new SseClient.ConnectionListener() { // from class: io.split.android.client.service.sseclient.sseclient.PushNotificationManager.StreamingConnection.1
                        @Override // io.split.android.client.service.sseclient.sseclient.SseClient.ConnectionListener
                        public void onConnectionSuccess() {
                            PushNotificationManager.this.mBroadcasterChannel.pushMessage(new PushStatusEvent(PushStatusEvent.EventType.PUSH_SUBSYSTEM_UP));
                            PushNotificationManager.this.mRefreshTokenTimer.schedule(jwtToken.getIssuedAtTime(), jwtToken.getExpirationTime());
                        }
                    });
                }
            }
        }

        private void recordSuccessfulSyncAndTokenRefreshes(SseJwtToken sseJwtToken) {
            PushNotificationManager.this.mTelemetryRuntimeProducer.recordSuccessfulSync(OperationType.TOKEN, System.currentTimeMillis());
            PushNotificationManager.this.mTelemetryRuntimeProducer.recordStreamingEvents(new TokenRefreshStreamingEvent(sseJwtToken.getExpirationTime(), System.currentTimeMillis()));
            PushNotificationManager.this.mTelemetryRuntimeProducer.recordTokenRefreshes();
        }

        private void handlePushDisabled() {
            Logger.d("Streaming disabled");
            PushNotificationManager.this.mBroadcasterChannel.pushMessage(new PushStatusEvent(PushStatusEvent.EventType.PUSH_SUBSYSTEM_DOWN));
            PushNotificationManager.this.mIsStopped.set(true);
        }

        private void handleNonRetryableError(SseAuthenticationResult sseAuthenticationResult) {
            Logger.d("Streaming no recoverable auth error.");
            PushNotificationManager.this.mBroadcasterChannel.pushMessage(new PushStatusEvent(PushStatusEvent.EventType.PUSH_NON_RETRYABLE_ERROR));
            PushNotificationManager.this.mIsStopped.set(true);
        }

        private void recordNonRetryableError(SseAuthenticationResult sseAuthenticationResult) {
            PushNotificationManager.this.mTelemetryRuntimeProducer.recordAuthRejections();
            if (sseAuthenticationResult.getHttpStatus() != null) {
                PushNotificationManager.this.mTelemetryRuntimeProducer.recordSyncError(OperationType.TOKEN, sseAuthenticationResult.getHttpStatus());
            }
        }

        private void handleAuthError() {
            Logger.d("Streaming auth error. Retrying");
            handleRetryableError();
        }

        private void handleRetryableError() {
            PushNotificationManager.this.mBroadcasterChannel.pushMessage(new PushStatusEvent(PushStatusEvent.EventType.PUSH_RETRYABLE_ERROR));
        }

        private boolean delay(long j) {
            try {
                try {
                    Thread.sleep(j * 1000);
                    return true;
                } catch (InterruptedException unused) {
                    Object[] objArr = new Object[1];
                    a(PlaceComponentResult[15], PlaceComponentResult[22], (byte) (PlaceComponentResult[15] - 1), objArr);
                    Class<?> cls = Class.forName((String) objArr[0]);
                    Object[] objArr2 = new Object[1];
                    a((byte) (PlaceComponentResult[15] - 1), (byte) (-PlaceComponentResult[15]), PlaceComponentResult[15], objArr2);
                    ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).interrupt();
                    return false;
                }
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class BackgroundDisconnectionTask implements SplitTask {
        private final SseRefreshTokenTimer mRefreshTokenTimer;
        private final SseClient mSseClient;

        public BackgroundDisconnectionTask(SseClient sseClient, SseRefreshTokenTimer sseRefreshTokenTimer) {
            this.mSseClient = sseClient;
            this.mRefreshTokenTimer = sseRefreshTokenTimer;
        }

        @Override // io.split.android.client.service.executor.SplitTask
        public SplitTaskExecutionInfo execute() {
            Logger.d("Disconnecting streaming while in background");
            this.mSseClient.disconnect();
            this.mRefreshTokenTimer.cancel();
            return SplitTaskExecutionInfo.success(SplitTaskType.GENERIC_TASK);
        }
    }
}
