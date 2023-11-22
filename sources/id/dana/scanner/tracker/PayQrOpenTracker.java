package id.dana.scanner.tracker;

import id.dana.scanner.ScannerReadyTimerHelper;
import id.dana.utils.DateTimeUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0004J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J;\u0010\u0003\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u0003\u0010\u000eR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\t@\u0007X\u0086\n¢\u0006\f\n\u0004\b\u000f\u0010\u0010\"\u0004\b\u000f\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0013"}, d2 = {"Lid/dana/scanner/tracker/PayQrOpenTracker;", "", "", "MyBillsEntityDataFactory", "()V", "Landroid/content/Context;", "p0", "", "p1", "", "p2", "", "p3", "p4", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Integer;ZZ)V", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/Integer;", "(Ljava/lang/Integer;)V", "getAuthRequestContext", "Z", "PlaceComponentResult", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PayQrOpenTracker {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private static Integer getAuthRequestContext;
    public static final PayQrOpenTracker INSTANCE = new PayQrOpenTracker();

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private static boolean PlaceComponentResult;

    private PayQrOpenTracker() {
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    public static void BuiltInFictitiousFunctionClassFactory(Integer num) {
        getAuthRequestContext = num;
    }

    public static void MyBillsEntityDataFactory() {
        PlaceComponentResult = false;
        getAuthRequestContext = null;
        ScannerReadyTimerHelper scannerReadyTimerHelper = ScannerReadyTimerHelper.INSTANCE;
        ScannerReadyTimerHelper.MyBillsEntityDataFactory();
        ScannerReadyTimerHelper.MyBillsEntityDataFactory = Long.valueOf(DateTimeUtil.BuiltInFictitiousFunctionClassFactory());
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0031, code lost:
    
        if (r0 < 0) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void MyBillsEntityDataFactory(android.content.Context r6, java.lang.String r7, java.lang.Integer r8, boolean r9, boolean r10) {
        /*
            boolean r0 = id.dana.scanner.tracker.PayQrOpenTracker.PlaceComponentResult
            if (r0 == 0) goto L6
            if (r9 != 0) goto Lbc
        L6:
            id.dana.scanner.ScannerReadyTimerHelper r0 = id.dana.scanner.ScannerReadyTimerHelper.INSTANCE
            long r0 = id.dana.utils.DateTimeUtil.BuiltInFictitiousFunctionClassFactory()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            id.dana.scanner.ScannerReadyTimerHelper.PlaceComponentResult = r0
            java.lang.Long r1 = id.dana.scanner.ScannerReadyTimerHelper.MyBillsEntityDataFactory
            r2 = 0
            if (r1 == 0) goto L33
            if (r0 != 0) goto L1b
            goto L33
        L1b:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            long r0 = r0.longValue()
            java.lang.Long r4 = id.dana.scanner.ScannerReadyTimerHelper.MyBillsEntityDataFactory
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            long r4 = r4.longValue()
            long r0 = r0 - r4
            id.dana.scanner.ScannerReadyTimerHelper.MyBillsEntityDataFactory()
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L34
        L33:
            r0 = r2
        L34:
            id.dana.tracker.EventTrackerModel$Builder r4 = new id.dana.tracker.EventTrackerModel$Builder
            r4.<init>(r6)
            java.lang.String r6 = "Pay QR Open"
            r4.MyBillsEntityDataFactory = r6
            java.lang.String r6 = "Source"
            r4.MyBillsEntityDataFactory(r6, r7)
            id.dana.performancetracker.IdleTimeUtil r6 = id.dana.performancetracker.IdleTimeUtil.INSTANCE
            long r6 = id.dana.performancetracker.IdleTimeUtil.PlaceComponentResult()
            java.lang.String r5 = "Idle Time in Millisecond"
            r4.BuiltInFictitiousFunctionClassFactory(r5, r6)
            r6 = 0
            if (r8 != 0) goto L54
            java.lang.Integer r7 = id.dana.scanner.tracker.PayQrOpenTracker.getAuthRequestContext
            if (r7 == 0) goto L6a
        L54:
            if (r8 == 0) goto L5b
            int r7 = r8.intValue()
            goto L65
        L5b:
            java.lang.Integer r7 = id.dana.scanner.tracker.PayQrOpenTracker.getAuthRequestContext
            if (r7 == 0) goto L64
            int r7 = r7.intValue()
            goto L65
        L64:
            r7 = 0
        L65:
            java.lang.String r8 = "Payment Method Count"
            r4.PlaceComponentResult(r8, r7)
        L6a:
            if (r9 == 0) goto L77
            if (r10 == 0) goto L77
            int r7 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r7 <= 0) goto L77
            java.lang.String r7 = "Scanner Ready"
            r4.BuiltInFictitiousFunctionClassFactory(r7, r0)
        L77:
            r4.BuiltInFictitiousFunctionClassFactory()
            id.dana.performancetracker.AppReadyMixpanelTracker r7 = id.dana.performancetracker.AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory
            long r7 = id.dana.performancetracker.AppReadyMixpanelTracker.NetworkUserEntityData$$ExternalSyntheticLambda0()
            long r7 = id.dana.performancetracker.FirstActionEntryPointClickTracker.MyBillsEntityDataFactory(r7)
            java.lang.String r9 = "Home Entry Point Click"
            r4.BuiltInFictitiousFunctionClassFactory(r9, r7)
            long r7 = id.dana.performancetracker.FirstActionEntryPointClickTracker.PlaceComponentResult()
            java.lang.String r9 = "Init Time in Millisecond"
            r4.BuiltInFictitiousFunctionClassFactory(r9, r7)
            long r7 = id.dana.performancetracker.IdleTimeUtil.MyBillsEntityDataFactory()
            long r7 = id.dana.performancetracker.FirstActionEntryPointClickTracker.PlaceComponentResult(r7)
            java.lang.String r9 = "Roaming Time in Millisecond"
            r4.BuiltInFictitiousFunctionClassFactory(r9, r7)
            id.dana.performancetracker.AppReadyMixpanelTracker r7 = id.dana.performancetracker.AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory
            long r7 = id.dana.performancetracker.AppReadyMixpanelTracker.NetworkUserEntityData$$ExternalSyntheticLambda0()
            long r7 = id.dana.performancetracker.FirstActionEntryPointClickTracker.BuiltInFictitiousFunctionClassFactory(r7)
            java.lang.String r9 = "Total Time in Millisecond"
            r4.BuiltInFictitiousFunctionClassFactory(r9, r7)
            r4.PlaceComponentResult()
            id.dana.tracker.EventTrackerModel r7 = new id.dana.tracker.EventTrackerModel
            r7.<init>(r4, r6)
            id.dana.tracker.EventTracker.PlaceComponentResult(r7)
            r6 = 1
            id.dana.scanner.tracker.PayQrOpenTracker.PlaceComponentResult = r6
        Lbc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.scanner.tracker.PayQrOpenTracker.MyBillsEntityDataFactory(android.content.Context, java.lang.String, java.lang.Integer, boolean, boolean):void");
    }
}
