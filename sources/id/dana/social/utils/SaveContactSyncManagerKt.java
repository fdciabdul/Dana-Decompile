package id.dana.social.utils;

import android.content.Context;
import androidx.work.BackoffPolicy;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.impl.WorkManagerImpl;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.base.extension.WorkManagerFailure;
import id.dana.social.workmanager.SaveContactFullSyncWorker;
import id.dana.social.workmanager.SaveContactPartialSyncWorker;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0015\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0004\u001a-\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\f\u001a-\u0010\r\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\f\u001a\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\r\u0010\u0004"}, d2 = {"Landroid/content/Context;", "p0", "", "getAuthRequestContext", "(Landroid/content/Context;)V", "BuiltInFictitiousFunctionClassFactory", "Landroidx/work/ExistingWorkPolicy;", "p1", "", "p2", "Ljava/util/concurrent/TimeUnit;", "p3", "(Landroid/content/Context;Landroidx/work/ExistingWorkPolicy;Ljava/util/concurrent/TimeUnit;)V", "KClassImpl$Data$declaredNonStaticMembers$2"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SaveContactSyncManagerKt {
    public static final void getAuthRequestContext(Context context) {
        WorkManager PlaceComponentResult;
        Intrinsics.checkNotNullParameter(context, "");
        PeriodicWorkRequest KClassImpl$Data$declaredNonStaticMembers$2 = new PeriodicWorkRequest.Builder(SaveContactFullSyncWorker.class, 7L, TimeUnit.DAYS).getAuthRequestContext(BackoffPolicy.EXPONENTIAL, 10000L, TimeUnit.MINUTES).KClassImpl$Data$declaredNonStaticMembers$2();
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        PeriodicWorkRequest periodicWorkRequest = KClassImpl$Data$declaredNonStaticMembers$2;
        try {
            PlaceComponentResult = WorkManagerImpl.PlaceComponentResult(context);
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
            PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2("SAVE_CONTACT_PERIODIC_FULL_SYNC_KEY", ExistingPeriodicWorkPolicy.KEEP, periodicWorkRequest);
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

    public static final void BuiltInFictitiousFunctionClassFactory(Context context) {
        WorkManager PlaceComponentResult;
        Intrinsics.checkNotNullParameter(context, "");
        PeriodicWorkRequest KClassImpl$Data$declaredNonStaticMembers$2 = new PeriodicWorkRequest.Builder(SaveContactPartialSyncWorker.class, 7L, TimeUnit.DAYS).getAuthRequestContext(BackoffPolicy.EXPONENTIAL, 10000L, TimeUnit.MINUTES).KClassImpl$Data$declaredNonStaticMembers$2();
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        PeriodicWorkRequest periodicWorkRequest = KClassImpl$Data$declaredNonStaticMembers$2;
        try {
            PlaceComponentResult = WorkManagerImpl.PlaceComponentResult(context);
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
            PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2("SAVE_CONTACT_PERIODIC_PARTIAL_SYNC_KEY", ExistingPeriodicWorkPolicy.KEEP, periodicWorkRequest);
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

    public static final void BuiltInFictitiousFunctionClassFactory(Context context, ExistingWorkPolicy existingWorkPolicy, TimeUnit timeUnit) {
        WorkManager PlaceComponentResult;
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(existingWorkPolicy, "");
        Intrinsics.checkNotNullParameter(timeUnit, "");
        OneTimeWorkRequest KClassImpl$Data$declaredNonStaticMembers$2 = new OneTimeWorkRequest.Builder(SaveContactFullSyncWorker.class).getAuthRequestContext(BackoffPolicy.EXPONENTIAL, 10000L, TimeUnit.MINUTES).MyBillsEntityDataFactory(30L, timeUnit).KClassImpl$Data$declaredNonStaticMembers$2();
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        OneTimeWorkRequest oneTimeWorkRequest = KClassImpl$Data$declaredNonStaticMembers$2;
        try {
            PlaceComponentResult = WorkManagerImpl.PlaceComponentResult(context);
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
            PlaceComponentResult.PlaceComponentResult("SAVE_CONTACT_FULL_SYNC_KEY", existingWorkPolicy, Collections.singletonList(oneTimeWorkRequest));
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

    public static final void KClassImpl$Data$declaredNonStaticMembers$2(Context context, ExistingWorkPolicy existingWorkPolicy, TimeUnit timeUnit) {
        WorkManager PlaceComponentResult;
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(existingWorkPolicy, "");
        Intrinsics.checkNotNullParameter(timeUnit, "");
        OneTimeWorkRequest KClassImpl$Data$declaredNonStaticMembers$2 = new OneTimeWorkRequest.Builder(SaveContactPartialSyncWorker.class).getAuthRequestContext(BackoffPolicy.EXPONENTIAL, 10000L, TimeUnit.MINUTES).MyBillsEntityDataFactory(30L, timeUnit).KClassImpl$Data$declaredNonStaticMembers$2();
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        OneTimeWorkRequest oneTimeWorkRequest = KClassImpl$Data$declaredNonStaticMembers$2;
        try {
            PlaceComponentResult = WorkManagerImpl.PlaceComponentResult(context);
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
            PlaceComponentResult.PlaceComponentResult("SAVE_CONTACT_PARTIAL_SYNC_KEY", existingWorkPolicy, Collections.singletonList(oneTimeWorkRequest));
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

    public static final void KClassImpl$Data$declaredNonStaticMembers$2(Context context) {
        WorkManager PlaceComponentResult;
        Intrinsics.checkNotNullParameter(context, "");
        try {
            PlaceComponentResult = WorkManagerImpl.PlaceComponentResult(context);
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
            PlaceComponentResult.MyBillsEntityDataFactory("SAVE_CONTACT_PERIODIC_PARTIAL_SYNC_KEY");
            PlaceComponentResult.MyBillsEntityDataFactory("SAVE_CONTACT_PARTIAL_SYNC_KEY");
            PlaceComponentResult.MyBillsEntityDataFactory("SAVE_CONTACT_PERIODIC_FULL_SYNC_KEY");
            PlaceComponentResult.MyBillsEntityDataFactory("SAVE_CONTACT_FULL_SYNC_KEY");
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
