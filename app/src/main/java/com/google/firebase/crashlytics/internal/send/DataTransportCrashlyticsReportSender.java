package com.google.firebase.crashlytics.internal.send;

import android.content.Context;
import android.os.Process;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import com.google.firebase.crashlytics.internal.common.OnDemandCounter;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;
import com.google.firebase.crashlytics.internal.settings.SettingsProvider;
import java.nio.charset.Charset;
import o.BottomSheetCardBindingView$watcherCardNumberView$1;

/* loaded from: classes.dex */
public class DataTransportCrashlyticsReportSender {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char[] BuiltInFictitiousFunctionClassFactory = null;
    private static final String CRASHLYTICS_API_KEY;
    private static final String CRASHLYTICS_ENDPOINT;
    private static final String CRASHLYTICS_TRANSPORT_NAME = "FIREBASE_CRASHLYTICS_REPORT";
    private static final Transformer<CrashlyticsReport, byte[]> DEFAULT_TRANSFORM;
    private static boolean KClassImpl$Data$declaredNonStaticMembers$2 = false;
    private static boolean MyBillsEntityDataFactory = false;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda0 = 1;
    private static int PlaceComponentResult;
    private static final CrashlyticsReportJsonTransform TRANSFORM;
    private static int getAuthRequestContext;
    private final ReportQueue reportQueue;
    private final Transformer<CrashlyticsReport, byte[]> transportTransform;

    static void PlaceComponentResult() {
        BuiltInFictitiousFunctionClassFactory = new char[]{39454, 39457, 39471, 39878, 39485};
        MyBillsEntityDataFactory = true;
        KClassImpl$Data$declaredNonStaticMembers$2 = true;
        getAuthRequestContext = 909155317;
    }

    static {
        PlaceComponentResult();
        TRANSFORM = new CrashlyticsReportJsonTransform();
        CRASHLYTICS_ENDPOINT = mergeStrings("hts/cahyiseot-agolai.o/1frlglgc/aclg", "tp:/rsltcrprsp.ogepscmv/ieo/eaybtho");
        CRASHLYTICS_API_KEY = mergeStrings("AzSBpY4F0rHiHFdinTvM", "IayrSTFL9eJ69YeSUO2");
        DEFAULT_TRANSFORM = new Transformer() { // from class: com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender$$ExternalSyntheticLambda0
            @Override // com.google.android.datatransport.Transformer
            public final Object apply(Object obj) {
                return DataTransportCrashlyticsReportSender.lambda$static$0((CrashlyticsReport) obj);
            }
        };
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 13;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ byte[] lambda$static$0(CrashlyticsReport crashlyticsReport) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 105;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        String reportToJson = TRANSFORM.reportToJson(crashlyticsReport);
        Object[] objArr = new Object[1];
        a(((Process.getThreadPriority(0) + 20) >> 6) + 127, new byte[]{-123, -124, -125, -126, -127}, null, null, objArr);
        byte[] bytes = reportToJson.getBytes(Charset.forName(((String) objArr[0]).intern()));
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 37;
        PlaceComponentResult = i3 % 128;
        if (i3 % 2 == 0) {
            return bytes;
        }
        int i4 = 24 / 0;
        return bytes;
    }

    public static DataTransportCrashlyticsReportSender create(Context context, SettingsProvider settingsProvider, OnDemandCounter onDemandCounter) {
        try {
            TransportRuntime.initialize(context);
            try {
                TransportFactory newFactory = TransportRuntime.getInstance().newFactory(new CCTDestination(CRASHLYTICS_ENDPOINT, CRASHLYTICS_API_KEY));
                Encoding of = Encoding.of("json");
                Transformer<CrashlyticsReport, byte[]> transformer = DEFAULT_TRANSFORM;
                DataTransportCrashlyticsReportSender dataTransportCrashlyticsReportSender = new DataTransportCrashlyticsReportSender(new ReportQueue(newFactory.getTransport(CRASHLYTICS_TRANSPORT_NAME, CrashlyticsReport.class, of, transformer), settingsProvider.getSettingsSync(), onDemandCounter), transformer);
                int i = PlaceComponentResult + 11;
                NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
                if ((i % 2 == 0 ? 'S' : '1') != '1') {
                    Object obj = null;
                    obj.hashCode();
                    return dataTransportCrashlyticsReportSender;
                }
                return dataTransportCrashlyticsReportSender;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    DataTransportCrashlyticsReportSender(ReportQueue reportQueue, Transformer<CrashlyticsReport, byte[]> transformer) {
        this.reportQueue = reportQueue;
        this.transportTransform = transformer;
    }

    public Task<CrashlyticsReportWithSessionId> enqueueReport(CrashlyticsReportWithSessionId crashlyticsReportWithSessionId, boolean z) {
        Task<CrashlyticsReportWithSessionId> task;
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 33;
        PlaceComponentResult = i % 128;
        if ((i % 2 != 0 ? 'Y' : (char) 11) != 11) {
            task = this.reportQueue.enqueueReport(crashlyticsReportWithSessionId, z).getTask();
            Object obj = null;
            obj.hashCode();
        } else {
            task = this.reportQueue.enqueueReport(crashlyticsReportWithSessionId, z).getTask();
        }
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 97;
        PlaceComponentResult = i2 % 128;
        int i3 = i2 % 2;
        return task;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
    
        if ((r0 < 0) == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0031, code lost:
    
        r3 = com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender.PlaceComponentResult + 95;
        com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender.NetworkUserEntityData$$ExternalSyntheticLambda0 = r3 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003b, code lost:
    
        if ((r3 % 2) != 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003d, code lost:
    
        if (r0 > 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0040, code lost:
    
        if (r0 > 1) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0042, code lost:
    
        r0 = new java.lang.StringBuilder(r5.length() + r6.length());
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0054, code lost:
    
        if (r1 >= r5.length()) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0056, code lost:
    
        r2 = com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender.PlaceComponentResult + 35;
        com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender.NetworkUserEntityData$$ExternalSyntheticLambda0 = r2 % 128;
        r2 = r2 % 2;
        r0.append(r5.charAt(r1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006b, code lost:
    
        if (r6.length() <= r1) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006d, code lost:
    
        r2 = com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender.NetworkUserEntityData$$ExternalSyntheticLambda0 + 49;
        com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender.PlaceComponentResult = r2 % 128;
        r2 = r2 % 2;
        r0.append(r6.charAt(r1));
        r2 = com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender.NetworkUserEntityData$$ExternalSyntheticLambda0 + 65;
        com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender.PlaceComponentResult = r2 % 128;
        r2 = r2 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0088, code lost:
    
        r1 = r1 + 1;
        r2 = com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender.NetworkUserEntityData$$ExternalSyntheticLambda0 + 11;
        com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender.PlaceComponentResult = r2 % 128;
        r2 = r2 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0099, code lost:
    
        return r0.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a1, code lost:
    
        throw new java.lang.IllegalArgumentException("Invalid input received");
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001c, code lost:
    
        if ((r0 >= 0) == true) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String mergeStrings(java.lang.String r5, java.lang.String r6) {
        /*
            int r0 = com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r0 = r0 + 89
            int r1 = r0 % 128
            com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender.PlaceComponentResult = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L21
            int r0 = r5.length()     // Catch: java.lang.Exception -> L1f
            int r3 = r6.length()     // Catch: java.lang.Exception -> L1f
            int r0 = r0 / r3
            if (r0 < 0) goto L1b
            r3 = 1
            goto L1c
        L1b:
            r3 = 0
        L1c:
            if (r3 != r2) goto L9a
            goto L31
        L1f:
            r5 = move-exception
            throw r5
        L21:
            int r0 = r5.length()
            int r3 = r6.length()
            int r0 = r0 - r3
            if (r0 < 0) goto L2e
            r3 = 0
            goto L2f
        L2e:
            r3 = 1
        L2f:
            if (r3 != 0) goto L9a
        L31:
            int r3 = com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender.PlaceComponentResult
            int r3 = r3 + 95
            int r4 = r3 % 128
            com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender.NetworkUserEntityData$$ExternalSyntheticLambda0 = r4
            int r3 = r3 % 2
            if (r3 != 0) goto L40
            if (r0 > 0) goto L9a
            goto L42
        L40:
            if (r0 > r2) goto L9a
        L42:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            int r2 = r5.length()
            int r3 = r6.length()
            int r2 = r2 + r3
            r0.<init>(r2)
        L50:
            int r2 = r5.length()
            if (r1 >= r2) goto L95
            int r2 = com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender.PlaceComponentResult
            int r2 = r2 + 35
            int r3 = r2 % 128
            com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender.NetworkUserEntityData$$ExternalSyntheticLambda0 = r3
            int r2 = r2 % 2
            char r2 = r5.charAt(r1)
            r0.append(r2)
            int r2 = r6.length()
            if (r2 <= r1) goto L88
            int r2 = com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r2 = r2 + 49
            int r3 = r2 % 128
            com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender.PlaceComponentResult = r3
            int r2 = r2 % 2
            char r2 = r6.charAt(r1)
            r0.append(r2)
            int r2 = com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r2 = r2 + 65
            int r3 = r2 % 128
            com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender.PlaceComponentResult = r3
            int r2 = r2 % 2
        L88:
            int r1 = r1 + 1
            int r2 = com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r2 = r2 + 11
            int r3 = r2 % 128
            com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender.PlaceComponentResult = r3
            int r2 = r2 % 2
            goto L50
        L95:
            java.lang.String r5 = r0.toString()     // Catch: java.lang.Exception -> La2
            return r5
        L9a:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "Invalid input received"
            r5.<init>(r6)     // Catch: java.lang.Exception -> La2
            throw r5     // Catch: java.lang.Exception -> La2
        La2:
            r5 = move-exception
            goto La5
        La4:
            throw r5
        La5:
            goto La4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender.mergeStrings(java.lang.String, java.lang.String):java.lang.String");
    }

    private static void a(int i, byte[] bArr, char[] cArr, int[] iArr, Object[] objArr) {
        int i2;
        BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
        char[] cArr2 = BuiltInFictitiousFunctionClassFactory;
        if ((cArr2 != null ? (char) 30 : ']') == 30) {
            int i3 = $11 + 31;
            $10 = i3 % 128;
            int i4 = i3 % 2;
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            int i5 = 0;
            while (i5 < length) {
                cArr3[i5] = (char) (cArr2[i5] ^ 4571606982258105150L);
                i5++;
                try {
                    int i6 = $10 + 107;
                    $11 = i6 % 128;
                    int i7 = i6 % 2;
                } catch (Exception e) {
                    throw e;
                }
            }
            cArr2 = cArr3;
        }
        try {
            int i8 = (int) (getAuthRequestContext ^ 4571606982258105150L);
            if (KClassImpl$Data$declaredNonStaticMembers$2) {
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
                char[] cArr4 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                while (true) {
                    if ((bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult ? 'W' : 'Y') == 'Y') {
                        objArr[0] = new String(cArr4);
                        return;
                    } else {
                        cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i8);
                        bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                    }
                }
            } else if (MyBillsEntityDataFactory) {
                int i9 = $11 + 41;
                $10 = i9 % 128;
                int i10 = i9 % 2;
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
                char[] cArr5 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                    int i11 = $11 + 23;
                    $10 = i11 % 128;
                    if (i11 % 2 != 0) {
                        cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult * 0) % bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] >>> i] << i8);
                        i2 = bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory << 1;
                    } else {
                        cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i8);
                        i2 = bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory + 1;
                    }
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = i2;
                }
                objArr[0] = new String(cArr5);
            } else {
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = iArr.length;
                char[] cArr6 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                while (true) {
                    if ((bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult ? (char) 22 : '`') == '`') {
                        objArr[0] = new String(cArr6);
                        return;
                    } else {
                        cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i8);
                        bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                    }
                }
            }
        } catch (Exception e2) {
            throw e2;
        }
    }
}
