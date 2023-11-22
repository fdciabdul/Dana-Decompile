package id.dana.social.utils;

import android.content.Context;
import androidx.view.LiveData;
import androidx.view.MutableLiveData;
import androidx.work.BackoffPolicy;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.impl.WorkManagerImpl;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.base.extension.WorkManagerFailure;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a!\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\n\u0010\t\u001a-\u0010\n\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\n\u0010\u0011\u001a%\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0015\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0012\u0010\t"}, d2 = {"Landroid/content/Context;", "p0", "Landroidx/lifecycle/LiveData;", "", "Landroidx/work/WorkInfo;", "getAuthRequestContext", "(Landroid/content/Context;)Landroidx/lifecycle/LiveData;", "", "MyBillsEntityDataFactory", "(Landroid/content/Context;)V", "BuiltInFictitiousFunctionClassFactory", "Landroidx/work/ExistingWorkPolicy;", "p1", "", "p2", "Ljava/util/concurrent/TimeUnit;", "p3", "(Landroid/content/Context;Landroidx/work/ExistingWorkPolicy;JLjava/util/concurrent/TimeUnit;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/content/Context;JLjava/util/concurrent/TimeUnit;)V"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SocialSyncManagerKt {
    public static final void BuiltInFictitiousFunctionClassFactory(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        BuiltInFictitiousFunctionClassFactory(context, ExistingWorkPolicy.KEEP, 0L, TimeUnit.SECONDS);
        KClassImpl$Data$declaredNonStaticMembers$2(context, 0L, TimeUnit.SECONDS);
    }

    public static final void MyBillsEntityDataFactory(Context context) {
        WorkManager PlaceComponentResult;
        Intrinsics.checkNotNullParameter(context, "");
        PeriodicWorkRequest.Builder authRequestContext = new PeriodicWorkRequest.Builder(PartialSyncContactWorker.class, 7L, TimeUnit.DAYS).getAuthRequestContext(BackoffPolicy.EXPONENTIAL, 10000L, TimeUnit.MINUTES);
        authRequestContext.PlaceComponentResult.add("PARTIAL_SYNC_KEYRECURRING_SYNC_KEY");
        PeriodicWorkRequest KClassImpl$Data$declaredNonStaticMembers$2 = authRequestContext.MyBillsEntityDataFactory().KClassImpl$Data$declaredNonStaticMembers$2();
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        PeriodicWorkRequest periodicWorkRequest = KClassImpl$Data$declaredNonStaticMembers$2;
        try {
            PlaceComponentResult = WorkManagerImpl.PlaceComponentResult(context);
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
            PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2("PARTIAL_SYNC_KEYRECURRING_SYNC_KEY", ExistingPeriodicWorkPolicy.KEEP, periodicWorkRequest);
        } catch (Exception e) {
            try {
                Crashlytics.Companion companion = Crashlytics.INSTANCE;
                Crashlytics authRequestContext2 = Crashlytics.Companion.getAuthRequestContext();
                WorkManagerFailure workManagerFailure = new WorkManagerFailure(e);
                Intrinsics.checkNotNullParameter(workManagerFailure, "");
                authRequestContext2.getAuthRequestContext.recordException(workManagerFailure);
            } catch (Exception unused) {
            }
        }
    }

    public static final void KClassImpl$Data$declaredNonStaticMembers$2(Context context, long j, TimeUnit timeUnit) {
        WorkManager PlaceComponentResult;
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(timeUnit, "");
        OneTimeWorkRequest.Builder MyBillsEntityDataFactory = new OneTimeWorkRequest.Builder(PartialSyncContactWorker.class).getAuthRequestContext(BackoffPolicy.EXPONENTIAL, 10000L, TimeUnit.MINUTES).MyBillsEntityDataFactory(j, timeUnit);
        MyBillsEntityDataFactory.PlaceComponentResult.add("PARTIAL_SYNC_KEY");
        OneTimeWorkRequest KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsEntityDataFactory.MyBillsEntityDataFactory().KClassImpl$Data$declaredNonStaticMembers$2();
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        OneTimeWorkRequest oneTimeWorkRequest = KClassImpl$Data$declaredNonStaticMembers$2;
        try {
            PlaceComponentResult = WorkManagerImpl.PlaceComponentResult(context);
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
            PlaceComponentResult.PlaceComponentResult("PARTIAL_SYNC_KEY", ExistingWorkPolicy.KEEP, Collections.singletonList(oneTimeWorkRequest));
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

    public static final void BuiltInFictitiousFunctionClassFactory(Context context, ExistingWorkPolicy existingWorkPolicy, long j, TimeUnit timeUnit) {
        WorkManager PlaceComponentResult;
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(existingWorkPolicy, "");
        Intrinsics.checkNotNullParameter(timeUnit, "");
        OneTimeWorkRequest.Builder MyBillsEntityDataFactory = new OneTimeWorkRequest.Builder(FullSyncContactWorker.class).getAuthRequestContext(BackoffPolicy.EXPONENTIAL, 10000L, TimeUnit.MINUTES).MyBillsEntityDataFactory(j, timeUnit);
        MyBillsEntityDataFactory.PlaceComponentResult.add("FULL_SYNC_KEY");
        OneTimeWorkRequest KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsEntityDataFactory.MyBillsEntityDataFactory().KClassImpl$Data$declaredNonStaticMembers$2();
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        OneTimeWorkRequest oneTimeWorkRequest = KClassImpl$Data$declaredNonStaticMembers$2;
        try {
            PlaceComponentResult = WorkManagerImpl.PlaceComponentResult(context);
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
            PlaceComponentResult.PlaceComponentResult("FULL_SYNC_KEY", existingWorkPolicy, Collections.singletonList(oneTimeWorkRequest));
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
            PlaceComponentResult.MyBillsEntityDataFactory("PARTIAL_SYNC_KEY");
            PlaceComponentResult.MyBillsEntityDataFactory("FULL_SYNC_KEY");
            PlaceComponentResult.MyBillsEntityDataFactory("RECURRING_SYNC_KEY");
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

    public static final LiveData<List<WorkInfo>> getAuthRequestContext(Context context) {
        LiveData<List<WorkInfo>> liveData;
        WorkManager PlaceComponentResult;
        Intrinsics.checkNotNullParameter(context, "");
        try {
            PlaceComponentResult = WorkManagerImpl.PlaceComponentResult(context);
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
            liveData = PlaceComponentResult.BuiltInFictitiousFunctionClassFactory("FULL_SYNC_KEY");
        } catch (Exception e) {
            try {
                Crashlytics.Companion companion = Crashlytics.INSTANCE;
                Crashlytics authRequestContext = Crashlytics.Companion.getAuthRequestContext();
                WorkManagerFailure workManagerFailure = new WorkManagerFailure(e);
                Intrinsics.checkNotNullParameter(workManagerFailure, "");
                authRequestContext.getAuthRequestContext.recordException(workManagerFailure);
            } catch (Exception unused) {
            }
            liveData = null;
        }
        return liveData == null ? new MutableLiveData(CollectionsKt.emptyList()) : liveData;
    }
}
