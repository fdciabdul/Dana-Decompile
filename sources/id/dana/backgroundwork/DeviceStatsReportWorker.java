package id.dana.backgroundwork;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkManagerImpl;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.base.extension.WorkManagerFailure;
import id.dana.domain.devicestats.storage.FileDirectorySizeReportExecutor;
import java.util.Collections;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u0003\u001a\u00020\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004R\u0012\u0010\u0006\u001a\u00020\u0005X\u0087\"¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lid/dana/backgroundwork/DeviceStatsReportWorker;", "Landroidx/work/CoroutineWorker;", "Landroidx/work/ListenableWorker$Result;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/domain/devicestats/storage/FileDirectorySizeReportExecutor;", "postInstallAppSizeExecutor", "Lid/dana/domain/devicestats/storage/FileDirectorySizeReportExecutor;", "Landroid/content/Context;", "ctx", "Landroidx/work/WorkerParameters;", "params", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DeviceStatsReportWorker extends CoroutineWorker {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    @Inject
    public FileDirectorySizeReportExecutor postInstallAppSizeExecutor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceStatsReportWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(workerParameters, "");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    @Override // androidx.work.CoroutineWorker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object KClassImpl$Data$declaredNonStaticMembers$2(kotlin.coroutines.Continuation<? super androidx.work.ListenableWorker.Result> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof id.dana.backgroundwork.DeviceStatsReportWorker$doWork$1
            if (r0 == 0) goto L14
            r0 = r6
            id.dana.backgroundwork.DeviceStatsReportWorker$doWork$1 r0 = (id.dana.backgroundwork.DeviceStatsReportWorker$doWork$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 + r2
            r0.label = r6
            goto L19
        L14:
            id.dana.backgroundwork.DeviceStatsReportWorker$doWork$1 r0 = new id.dana.backgroundwork.DeviceStatsReportWorker$doWork$1
            r0.<init>(r5, r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4c
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L32:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.CoroutineDispatcher r6 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r6 = (kotlin.coroutines.CoroutineContext) r6
            id.dana.backgroundwork.DeviceStatsReportWorker$doWork$2 r2 = new id.dana.backgroundwork.DeviceStatsReportWorker$doWork$2
            r4 = 0
            r2.<init>(r5, r4)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r0.label = r3
            java.lang.Object r6 = kotlinx.coroutines.BuildersKt.withContext(r6, r2, r0)
            if (r6 != r1) goto L4c
            return r1
        L4c:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.backgroundwork.DeviceStatsReportWorker.KClassImpl$Data$declaredNonStaticMembers$2(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0006"}, d2 = {"Lid/dana/backgroundwork/DeviceStatsReportWorker$Companion;", "", "Landroid/content/Context;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/content/Context;)V", "getAuthRequestContext", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static void getAuthRequestContext(Context p0) {
            WorkManager PlaceComponentResult;
            OneTimeWorkRequest KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkNotNullParameter(p0, "");
            try {
                PlaceComponentResult = WorkManagerImpl.PlaceComponentResult(p0);
                Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
                ExistingWorkPolicy existingWorkPolicy = ExistingWorkPolicy.REPLACE;
                KClassImpl$Data$declaredNonStaticMembers$2 = new OneTimeWorkRequest.Builder(DeviceStatsReportWorker.class).KClassImpl$Data$declaredNonStaticMembers$2();
                PlaceComponentResult.PlaceComponentResult("Device-Stats-Report", existingWorkPolicy, Collections.singletonList(KClassImpl$Data$declaredNonStaticMembers$2));
            } catch (Exception e) {
                try {
                    Crashlytics.Companion companion = Crashlytics.INSTANCE;
                    Crashlytics authRequestContext = Crashlytics.Companion.getAuthRequestContext();
                    WorkManagerFailure workManagerFailure = new WorkManagerFailure(e);
                    Intrinsics.checkNotNullParameter(workManagerFailure, "");
                    authRequestContext.getAuthRequestContext.recordException(workManagerFailure);
                } catch (Exception unused) {
                }
            }
        }

        public static void KClassImpl$Data$declaredNonStaticMembers$2(Context p0) {
            WorkManager PlaceComponentResult;
            Intrinsics.checkNotNullParameter(p0, "");
            try {
                PlaceComponentResult = WorkManagerImpl.PlaceComponentResult(p0);
                Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
                PlaceComponentResult.MyBillsEntityDataFactory("Device-Stats-Report");
            } catch (Exception e) {
                try {
                    Crashlytics.Companion companion = Crashlytics.INSTANCE;
                    Crashlytics authRequestContext = Crashlytics.Companion.getAuthRequestContext();
                    WorkManagerFailure workManagerFailure = new WorkManagerFailure(e);
                    Intrinsics.checkNotNullParameter(workManagerFailure, "");
                    authRequestContext.getAuthRequestContext.recordException(workManagerFailure);
                } catch (Exception unused) {
                }
            }
        }
    }
}
