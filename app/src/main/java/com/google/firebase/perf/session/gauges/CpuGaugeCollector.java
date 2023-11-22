package com.google.firebase.perf.session.gauges;

import android.os.Build;
import android.os.Process;
import android.system.Os;
import android.system.OsConstants;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.v1.CpuMetricReading;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class CpuGaugeCollector {
    private static final int CSTIME_POSITION_IN_PROC_PID_STAT = 16;
    private static final int CUTIME_POSITION_IN_PROC_PID_STAT = 15;
    public static final long INVALID_CPU_COLLECTION_FREQUENCY = -1;
    private static final int INVALID_SC_PER_CPU_CLOCK_TICK = -1;
    private static final int STIME_POSITION_IN_PROC_PID_STAT = 14;
    private static final int UNSET_CPU_METRIC_COLLECTION_RATE = -1;
    private static final int UTIME_POSITION_IN_PROC_PID_STAT = 13;
    private final long clockTicksPerSecond;
    private long cpuMetricCollectionRateMs;
    private final ScheduledExecutorService cpuMetricCollectorExecutor;
    private ScheduledFuture cpuMetricCollectorJob;
    public final ConcurrentLinkedQueue<CpuMetricReading> cpuMetricReadings;
    private final String procFileName;
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private static final long MICROSECONDS_PER_SECOND = TimeUnit.SECONDS.toMicros(1);

    public static boolean isInvalidCollectionFrequency(long j) {
        return j <= 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CpuGaugeCollector() {
        this.cpuMetricCollectorJob = null;
        this.cpuMetricCollectionRateMs = -1L;
        this.cpuMetricReadings = new ConcurrentLinkedQueue<>();
        this.cpuMetricCollectorExecutor = Executors.newSingleThreadScheduledExecutor();
        int myPid = Process.myPid();
        StringBuilder sb = new StringBuilder();
        sb.append("/proc/");
        sb.append(Integer.toString(myPid));
        sb.append("/stat");
        this.procFileName = sb.toString();
        this.clockTicksPerSecond = getClockTicksPerSecond();
    }

    CpuGaugeCollector(ScheduledExecutorService scheduledExecutorService, String str, long j) {
        this.cpuMetricCollectorJob = null;
        this.cpuMetricCollectionRateMs = -1L;
        this.cpuMetricReadings = new ConcurrentLinkedQueue<>();
        this.cpuMetricCollectorExecutor = scheduledExecutorService;
        this.procFileName = str;
        this.clockTicksPerSecond = j;
    }

    public void startCollecting(long j, Timer timer) {
        long j2 = this.clockTicksPerSecond;
        if (j2 == -1 || j2 == 0 || isInvalidCollectionFrequency(j)) {
            return;
        }
        if (this.cpuMetricCollectorJob == null) {
            scheduleCpuMetricCollectionWithRate(j, timer);
        } else if (this.cpuMetricCollectionRateMs != j) {
            stopCollecting();
            scheduleCpuMetricCollectionWithRate(j, timer);
        }
    }

    public void stopCollecting() {
        ScheduledFuture scheduledFuture = this.cpuMetricCollectorJob;
        if (scheduledFuture == null) {
            return;
        }
        scheduledFuture.cancel(false);
        this.cpuMetricCollectorJob = null;
        this.cpuMetricCollectionRateMs = -1L;
    }

    public void collectOnce(Timer timer) {
        scheduleCpuMetricCollectionOnce(timer);
    }

    private void scheduleCpuMetricCollectionWithRate(long j, final Timer timer) {
        synchronized (this) {
            this.cpuMetricCollectionRateMs = j;
            try {
                this.cpuMetricCollectorJob = this.cpuMetricCollectorExecutor.scheduleAtFixedRate(new Runnable() { // from class: com.google.firebase.perf.session.gauges.CpuGaugeCollector$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        CpuGaugeCollector.this.m189x1cbd6996(timer);
                    }
                }, 0L, j, TimeUnit.MILLISECONDS);
            } catch (RejectedExecutionException e) {
                AndroidLogger androidLogger = logger;
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to start collecting Cpu Metrics: ");
                sb.append(e.getMessage());
                androidLogger.warn(sb.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$scheduleCpuMetricCollectionWithRate$0$com-google-firebase-perf-session-gauges-CpuGaugeCollector  reason: not valid java name */
    public /* synthetic */ void m189x1cbd6996(Timer timer) {
        CpuMetricReading syncCollectCpuMetric = syncCollectCpuMetric(timer);
        if (syncCollectCpuMetric != null) {
            this.cpuMetricReadings.add(syncCollectCpuMetric);
        }
    }

    private void scheduleCpuMetricCollectionOnce(final Timer timer) {
        synchronized (this) {
            try {
                this.cpuMetricCollectorExecutor.schedule(new Runnable() { // from class: com.google.firebase.perf.session.gauges.CpuGaugeCollector$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        CpuGaugeCollector.this.m188xc89eb492(timer);
                    }
                }, 0L, TimeUnit.MILLISECONDS);
            } catch (RejectedExecutionException e) {
                AndroidLogger androidLogger = logger;
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to collect Cpu Metric: ");
                sb.append(e.getMessage());
                androidLogger.warn(sb.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$scheduleCpuMetricCollectionOnce$1$com-google-firebase-perf-session-gauges-CpuGaugeCollector  reason: not valid java name */
    public /* synthetic */ void m188xc89eb492(Timer timer) {
        CpuMetricReading syncCollectCpuMetric = syncCollectCpuMetric(timer);
        if (syncCollectCpuMetric != null) {
            this.cpuMetricReadings.add(syncCollectCpuMetric);
        }
    }

    private CpuMetricReading syncCollectCpuMetric(Timer timer) {
        if (timer == null) {
            return null;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(this.procFileName));
            try {
                long currentTimestampMicros = timer.getCurrentTimestampMicros();
                String[] split = bufferedReader.readLine().split(" ");
                long parseLong = Long.parseLong(split[13]);
                long parseLong2 = Long.parseLong(split[15]);
                CpuMetricReading build = CpuMetricReading.newBuilder().setClientTimeUs(currentTimestampMicros).setSystemTimeUs(convertClockTicksToMicroseconds(Long.parseLong(split[14]) + Long.parseLong(split[16]))).setUserTimeUs(convertClockTicksToMicroseconds(parseLong + parseLong2)).build();
                bufferedReader.close();
                return build;
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e) {
            AndroidLogger androidLogger = logger;
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to read 'proc/[pid]/stat' file: ");
            sb.append(e.getMessage());
            androidLogger.warn(sb.toString());
            return null;
        } catch (ArrayIndexOutOfBoundsException e2) {
            e = e2;
            AndroidLogger androidLogger2 = logger;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unexpected '/proc/[pid]/stat' file format encountered: ");
            sb2.append(e.getMessage());
            androidLogger2.warn(sb2.toString());
            return null;
        } catch (NullPointerException e3) {
            e = e3;
            AndroidLogger androidLogger22 = logger;
            StringBuilder sb22 = new StringBuilder();
            sb22.append("Unexpected '/proc/[pid]/stat' file format encountered: ");
            sb22.append(e.getMessage());
            androidLogger22.warn(sb22.toString());
            return null;
        } catch (NumberFormatException e4) {
            e = e4;
            AndroidLogger androidLogger222 = logger;
            StringBuilder sb222 = new StringBuilder();
            sb222.append("Unexpected '/proc/[pid]/stat' file format encountered: ");
            sb222.append(e.getMessage());
            androidLogger222.warn(sb222.toString());
            return null;
        }
    }

    private long getClockTicksPerSecond() {
        if (Build.VERSION.SDK_INT >= 21) {
            return Os.sysconf(OsConstants._SC_CLK_TCK);
        }
        return -1L;
    }

    private long convertClockTicksToMicroseconds(long j) {
        double d = j;
        double d2 = this.clockTicksPerSecond;
        Double.isNaN(d);
        Double.isNaN(d2);
        double d3 = d / d2;
        double d4 = MICROSECONDS_PER_SECOND;
        Double.isNaN(d4);
        return Math.round(d3 * d4);
    }
}
