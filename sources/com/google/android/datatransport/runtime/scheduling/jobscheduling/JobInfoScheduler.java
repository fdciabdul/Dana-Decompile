package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.os.Process;
import android.os.SystemClock;
import android.util.Base64;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.zip.Adler32;
import o.BottomSheetCardBindingView$watcherCardNumberView$1;

/* loaded from: classes7.dex */
public class JobInfoScheduler implements WorkScheduler {
    private static int $10 = 0;
    private static int $11 = 1;
    static final String ATTEMPT_NUMBER = "attemptNumber";
    static final String BACKEND_NAME = "backendName";
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    static final String EVENT_PRIORITY = "priority";
    static final String EXTRAS = "extras";
    private static final String LOG_TAG = "JobInfoScheduler";
    private static int scheduleImpl = 1;
    private final SchedulerConfig config;
    private final Context context;
    private final EventStore eventStore;
    private static char[] PlaceComponentResult = {39474, 39477, 39875, 39898, 39889};
    private static boolean MyBillsEntityDataFactory = true;
    private static boolean getAuthRequestContext = true;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 909155209;

    public JobInfoScheduler(Context context, EventStore eventStore, SchedulerConfig schedulerConfig) {
        this.context = context;
        this.eventStore = eventStore;
        this.config = schedulerConfig;
    }

    int getJobId(TransportContext transportContext) {
        Adler32 adler32 = new Adler32();
        String packageName = this.context.getPackageName();
        Object[] objArr = new Object[1];
        a(128 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), new byte[]{-123, -124, -125, -126, -127}, null, null, objArr);
        adler32.update(packageName.getBytes(Charset.forName(((String) objArr[0]).intern())));
        String backendName = transportContext.getBackendName();
        Object[] objArr2 = new Object[1];
        a(127 - (Process.myPid() >> 22), new byte[]{-123, -124, -125, -126, -127}, null, null, objArr2);
        adler32.update(backendName.getBytes(Charset.forName(((String) objArr2[0]).intern())));
        adler32.update(ByteBuffer.allocate(4).putInt(PriorityMapping.toInt(transportContext.getPriority())).array());
        if (!(transportContext.getExtras() == null)) {
            int i = scheduleImpl + 9;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
            adler32.update(transportContext.getExtras());
            int i3 = BuiltInFictitiousFunctionClassFactory + 109;
            scheduleImpl = i3 % 128;
            int i4 = i3 % 2;
        }
        return (int) adler32.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0019, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean isJobServiceOn(android.app.job.JobScheduler r6, int r7, int r8) {
        /*
            r5 = this;
            java.util.List r6 = r6.getAllPendingJobs()     // Catch: java.lang.Exception -> L50
            java.util.Iterator r6 = r6.iterator()     // Catch: java.lang.Exception -> L50
        L8:
            boolean r0 = r6.hasNext()
            r1 = 51
            if (r0 == 0) goto L13
            r0 = 51
            goto L15
        L13:
            r0 = 67
        L15:
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L1b
        L19:
            r2 = 0
            goto L4f
        L1b:
            int r0 = com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoScheduler.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 79
            int r1 = r0 % 128
            com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoScheduler.scheduleImpl = r1
            int r0 = r0 % 2
            java.lang.Object r0 = r6.next()
            android.app.job.JobInfo r0 = (android.app.job.JobInfo) r0
            android.os.PersistableBundle r1 = r0.getExtras()
            java.lang.String r4 = "attemptNumber"
            int r1 = r1.getInt(r4)
            int r0 = r0.getId()
            if (r0 != r7) goto L3d
            r0 = 0
            goto L3e
        L3d:
            r0 = 1
        L3e:
            if (r0 == r2) goto L8
            if (r1 < r8) goto L19
            int r6 = com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoScheduler.BuiltInFictitiousFunctionClassFactory
            int r6 = r6 + 71
            int r7 = r6 % 128
            com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoScheduler.scheduleImpl = r7
            int r6 = r6 % 2
            if (r6 != 0) goto L4f
            goto L19
        L4f:
            return r2
        L50:
            r6 = move-exception
            goto L53
        L52:
            throw r6
        L53:
            goto L52
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoScheduler.isJobServiceOn(android.app.job.JobScheduler, int, int):boolean");
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler
    public void schedule(TransportContext transportContext, int i) {
        int i2 = BuiltInFictitiousFunctionClassFactory + 123;
        scheduleImpl = i2 % 128;
        if (i2 % 2 == 0) {
        }
        schedule(transportContext, i, false);
        int i3 = BuiltInFictitiousFunctionClassFactory + 89;
        scheduleImpl = i3 % 128;
        if (i3 % 2 != 0) {
            return;
        }
        int i4 = 74 / 0;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler
    public void schedule(TransportContext transportContext, int i, boolean z) {
        ComponentName componentName = new ComponentName(this.context, JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) this.context.getSystemService("jobscheduler");
        int jobId = getJobId(transportContext);
        if (!z) {
            int i2 = scheduleImpl + 73;
            BuiltInFictitiousFunctionClassFactory = i2 % 128;
            int i3 = i2 % 2;
            if ((isJobServiceOn(jobScheduler, jobId, i) ? 'T' : '6') != '6') {
                int i4 = BuiltInFictitiousFunctionClassFactory + 35;
                scheduleImpl = i4 % 128;
                int i5 = i4 % 2;
                Logging.d(LOG_TAG, "Upload for context %s is already scheduled. Returning...", transportContext);
                return;
            }
        }
        try {
            long nextCallTime = this.eventStore.getNextCallTime(transportContext);
            try {
                JobInfo.Builder configureJob = this.config.configureJob(new JobInfo.Builder(jobId, componentName), transportContext.getPriority(), nextCallTime, i);
                PersistableBundle persistableBundle = new PersistableBundle();
                persistableBundle.putInt(ATTEMPT_NUMBER, i);
                persistableBundle.putString(BACKEND_NAME, transportContext.getBackendName());
                persistableBundle.putInt(EVENT_PRIORITY, PriorityMapping.toInt(transportContext.getPriority()));
                if ((transportContext.getExtras() != null ? 'W' : '6') == 'W') {
                    persistableBundle.putString(EXTRAS, Base64.encodeToString(transportContext.getExtras(), 0));
                }
                configureJob.setExtras(persistableBundle);
                Logging.d(LOG_TAG, "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", transportContext, Integer.valueOf(jobId), Long.valueOf(this.config.getScheduleDelay(transportContext.getPriority(), nextCallTime, i)), Long.valueOf(nextCallTime), Integer.valueOf(i));
                jobScheduler.schedule(configureJob.build());
                int i6 = scheduleImpl + 31;
                BuiltInFictitiousFunctionClassFactory = i6 % 128;
                if ((i6 % 2 != 0 ? '?' : (char) 15) != '?') {
                    return;
                }
                Object obj = null;
                obj.hashCode();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static void a(int i, byte[] bArr, char[] cArr, int[] iArr, Object[] objArr) {
        BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
        try {
            char[] cArr2 = PlaceComponentResult;
            if ((cArr2 != null ? '[' : 'a') == '[') {
                int i2 = $11 + 43;
                $10 = i2 % 128;
                int i3 = i2 % 2;
                int length = cArr2.length;
                char[] cArr3 = new char[length];
                for (int i4 = 0; i4 < length; i4++) {
                    int i5 = $10 + 113;
                    $11 = i5 % 128;
                    int i6 = i5 % 2;
                    cArr3[i4] = (char) (cArr2[i4] ^ 4571606982258105150L);
                }
                cArr2 = cArr3;
            }
            try {
                int i7 = (int) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 4571606982258105150L);
                if (!getAuthRequestContext) {
                    if (MyBillsEntityDataFactory) {
                        bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
                        char[] cArr4 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                        bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                        while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                            int i8 = $11 + 81;
                            $10 = i8 % 128;
                            int i9 = i8 % 2;
                            cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i7);
                            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                            int i10 = $10 + 55;
                            $11 = i10 % 128;
                            int i11 = i10 % 2;
                        }
                        objArr[0] = new String(cArr4);
                        return;
                    }
                    bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = iArr.length;
                    char[] cArr5 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                    while (true) {
                        if (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory >= bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                            break;
                        }
                        cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i7);
                        bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                        int i12 = $11 + 65;
                        $10 = i12 % 128;
                        int i13 = i12 % 2;
                    }
                    String str = new String(cArr5);
                    int i14 = $10 + 53;
                    $11 = i14 % 128;
                    if ((i14 % 2 == 0 ? ';' : (char) 30) == 30) {
                        objArr[0] = str;
                        return;
                    }
                    Object obj = null;
                    obj.hashCode();
                    objArr[0] = str;
                    return;
                }
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
                char[] cArr6 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                while (true) {
                    if (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory >= bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                        objArr[0] = new String(cArr6);
                        return;
                    } else {
                        cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i7);
                        bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                    }
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }
}
