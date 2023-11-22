package io.split.android.client.service.splits;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import io.split.android.client.dtos.SplitChange;
import io.split.android.client.network.SplitHttpHeadersBuilder;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.service.http.HttpFetcher;
import io.split.android.client.service.http.HttpFetcherException;
import io.split.android.client.service.sseclient.BackoffCounter;
import io.split.android.client.service.sseclient.ReconnectBackoffCounter;
import io.split.android.client.storage.splits.SplitsStorage;
import io.split.android.client.telemetry.model.OperationType;
import io.split.android.client.telemetry.storage.TelemetryRuntimeProducer;
import io.split.android.client.utils.logger.Logger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: classes6.dex */
public class SplitsSyncHelper {
    private static final int ON_DEMAND_FETCH_BACKOFF_MAX_RETRIES = 10;
    private static final int ON_DEMAND_FETCH_BACKOFF_MAX_WAIT = 60;
    private static final String SINCE_PARAM = "since";
    private static final String TILL_PARAM = "till";
    private final BackoffCounter mBackoffCounter;
    private final SplitChangeProcessor mSplitChangeProcessor;
    private final HttpFetcher<SplitChange> mSplitFetcher;
    private final SplitsStorage mSplitsStorage;
    private final TelemetryRuntimeProducer mTelemetryRuntimeProducer;
    public static final byte[] MyBillsEntityDataFactory = {72, -11, 97, 122, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int PlaceComponentResult = 10;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0030). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 7
            int r8 = 106 - r8
            int r6 = r6 * 12
            int r6 = 15 - r6
            int r7 = r7 * 3
            int r7 = 16 - r7
            byte[] r0 = io.split.android.client.service.splits.SplitsSyncHelper.MyBillsEntityDataFactory
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r4 = r8
            r3 = 0
            r8 = r7
            goto L30
        L19:
            r3 = 0
        L1a:
            int r6 = r6 + 1
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r8
            r8 = r7
            r7 = r5
        L30:
            int r4 = -r4
            int r7 = r7 + r4
            int r7 = r7 + 2
            r5 = r8
            r8 = r7
            r7 = r5
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: io.split.android.client.service.splits.SplitsSyncHelper.a(short, byte, short, java.lang.Object[]):void");
    }

    public SplitsSyncHelper(HttpFetcher<SplitChange> httpFetcher, SplitsStorage splitsStorage, SplitChangeProcessor splitChangeProcessor, TelemetryRuntimeProducer telemetryRuntimeProducer) {
        this(httpFetcher, splitsStorage, splitChangeProcessor, telemetryRuntimeProducer, new ReconnectBackoffCounter(1, 60));
    }

    public SplitsSyncHelper(HttpFetcher<SplitChange> httpFetcher, SplitsStorage splitsStorage, SplitChangeProcessor splitChangeProcessor, TelemetryRuntimeProducer telemetryRuntimeProducer, BackoffCounter backoffCounter) {
        this.mSplitFetcher = (HttpFetcher) Preconditions.checkNotNull(httpFetcher);
        this.mSplitsStorage = (SplitsStorage) Preconditions.checkNotNull(splitsStorage);
        this.mSplitChangeProcessor = (SplitChangeProcessor) Preconditions.checkNotNull(splitChangeProcessor);
        this.mTelemetryRuntimeProducer = (TelemetryRuntimeProducer) Preconditions.checkNotNull(telemetryRuntimeProducer);
        this.mBackoffCounter = (BackoffCounter) Preconditions.checkNotNull(backoffCounter);
    }

    public SplitTaskExecutionInfo sync(long j) {
        return sync(j, false, true, false);
    }

    public SplitTaskExecutionInfo sync(long j, boolean z, boolean z2) {
        return sync(j, z, false, z2);
    }

    private SplitTaskExecutionInfo sync(long j, boolean z, boolean z2, boolean z3) {
        try {
            if (!attemptSplitSync(j, z, z2, false, z3)) {
                attemptSplitSync(j, z, z2, true, z3);
            }
            Logger.d("Feature flags have been updated");
            return SplitTaskExecutionInfo.success(SplitTaskType.SPLITS_SYNC);
        } catch (HttpFetcherException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Network error while fetching feature flags");
            sb.append(e.getLocalizedMessage());
            logError(sb.toString());
            this.mTelemetryRuntimeProducer.recordSyncError(OperationType.SPLITS, e.getHttpStatus());
            return SplitTaskExecutionInfo.error(SplitTaskType.SPLITS_SYNC);
        } catch (Exception e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unexpected while fetching feature flags");
            sb2.append(e2.getLocalizedMessage());
            logError(sb2.toString());
            return SplitTaskExecutionInfo.error(SplitTaskType.SPLITS_SYNC);
        }
    }

    private boolean attemptSplitSync(long j, boolean z, boolean z2, boolean z3, boolean z4) throws Exception {
        this.mBackoffCounter.resetCounter();
        int i = 10;
        boolean z5 = z4;
        while (true) {
            i--;
            if (j <= fetchUntil(j, z, z2, z3, z5)) {
                return true;
            }
            if (i <= 0) {
                return false;
            }
            try {
                try {
                    Thread.sleep(TimeUnit.SECONDS.toMillis(this.mBackoffCounter.getNextRetryTime()));
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        throw cause;
                    }
                    throw th;
                }
            } catch (InterruptedException unused) {
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
                Logger.e("Interrupted while waiting for next retry");
            }
            z5 = false;
        }
    }

    private long fetchUntil(long j, boolean z, boolean z2, boolean z3, boolean z4) throws Exception {
        while (true) {
            long till = z4 ? -1L : this.mSplitsStorage.getTill();
            if (j < till) {
                return till;
            }
            SplitChange fetchSplits = fetchSplits(till, z2, z3);
            updateStorage(z, fetchSplits);
            if (fetchSplits.till == fetchSplits.since) {
                return fetchSplits.till;
            }
            z = false;
            z4 = false;
        }
    }

    private SplitChange fetchSplits(long j, boolean z, boolean z2) throws HttpFetcherException {
        HashMap hashMap = new HashMap();
        hashMap.put(SINCE_PARAM, Long.valueOf(j));
        if (z2) {
            hashMap.put(TILL_PARAM, Long.valueOf(j));
        }
        return this.mSplitFetcher.execute(hashMap, getHeaders(z));
    }

    private void updateStorage(boolean z, SplitChange splitChange) {
        if (z) {
            this.mSplitsStorage.clear();
        }
        this.mSplitsStorage.update(this.mSplitChangeProcessor.process(splitChange));
    }

    public boolean cacheHasExpired(long j, long j2, long j3) {
        return j > -1 && j2 > 0 && now() - j2 > j3;
    }

    private long now() {
        return System.currentTimeMillis() / 1000;
    }

    private void logError(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("Error while executing splits sync/update task: ");
        sb.append(str);
        Logger.e(sb.toString());
    }

    private Map<String, String> getHeaders(boolean z) {
        if (z) {
            return SplitHttpHeadersBuilder.noCacheHeaders();
        }
        return null;
    }
}
