package id.dana.social.base;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.di.component.ApplicationComponent;
import id.dana.domain.social.Result;
import id.dana.feeds.domain.synccontact.model.SyncResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H¦@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0007\u001a\u00020\u0006H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\u0007\u0010\rR\u0011\u0010\t\u001a\u00020\u000eX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0011X\u0006¢\u0006\u0006\n\u0004\b\t\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lid/dana/social/base/BaseSocialSyncWorker;", "Landroidx/work/CoroutineWorker;", "Lid/dana/domain/social/Result;", "Lid/dana/feeds/domain/synccontact/model/SyncResult;", "BuiltInFictitiousFunctionClassFactory", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/work/ListenableWorker$Result;", "KClassImpl$Data$declaredNonStaticMembers$2", "", "PlaceComponentResult", "()V", "Lid/dana/di/component/ApplicationComponent;", "p0", "(Lid/dana/di/component/ApplicationComponent;)V", "Landroid/content/Context;", "MyBillsEntityDataFactory", "Landroid/content/Context;", "Landroidx/work/WorkerParameters;", "Landroidx/work/WorkerParameters;", HummerConstants.CONTEXT, "params", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class BaseSocialSyncWorker extends CoroutineWorker {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final Context PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final WorkerParameters BuiltInFictitiousFunctionClassFactory;

    public abstract Object BuiltInFictitiousFunctionClassFactory(Continuation<? super Result<SyncResult>> continuation);

    @Override // androidx.work.CoroutineWorker
    public Object KClassImpl$Data$declaredNonStaticMembers$2(Continuation<? super ListenableWorker.Result> continuation) {
        return getAuthRequestContext(this, continuation);
    }

    public abstract void KClassImpl$Data$declaredNonStaticMembers$2(ApplicationComponent p0);

    public abstract void PlaceComponentResult();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseSocialSyncWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(workerParameters, "");
        this.PlaceComponentResult = context;
        this.BuiltInFictitiousFunctionClassFactory = workerParameters;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Object getAuthRequestContext(id.dana.social.base.BaseSocialSyncWorker r5, kotlin.coroutines.Continuation r6) {
        /*
            boolean r0 = r6 instanceof id.dana.social.base.BaseSocialSyncWorker$doWork$1
            if (r0 == 0) goto L14
            r0 = r6
            id.dana.social.base.BaseSocialSyncWorker$doWork$1 r0 = (id.dana.social.base.BaseSocialSyncWorker$doWork$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 + r2
            r0.label = r6
            goto L19
        L14:
            id.dana.social.base.BaseSocialSyncWorker$doWork$1 r0 = new id.dana.social.base.BaseSocialSyncWorker$doWork$1
            r0.<init>(r5, r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            java.lang.String r4 = ""
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r5 = r0.L$0
            id.dana.social.base.BaseSocialSyncWorker r5 = (id.dana.social.base.BaseSocialSyncWorker) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L65
        L30:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L38:
            kotlin.ResultKt.throwOnFailure(r6)
            int r6 = r5.getRunAttemptCount()
            r2 = 3
            if (r6 <= r2) goto L4a
            androidx.work.ListenableWorker$Result r5 = androidx.work.ListenableWorker.Result.getAuthRequestContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r4)
            return r5
        L4a:
            android.content.Context r6 = r5.getApplicationContext()
            id.dana.DanaApplication r6 = (id.dana.DanaApplication) r6
            id.dana.di.component.ApplicationComponent r6 = r6.getApplicationComponent()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r4)
            r5.KClassImpl$Data$declaredNonStaticMembers$2(r6)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r5.BuiltInFictitiousFunctionClassFactory(r0)
            if (r6 != r1) goto L65
            return r1
        L65:
            id.dana.domain.social.Result r6 = (id.dana.domain.social.Result) r6
            boolean r0 = r6 instanceof id.dana.domain.social.Result.Success
            if (r0 == 0) goto L84
            id.dana.domain.social.Result$Success r6 = (id.dana.domain.social.Result.Success) r6
            java.lang.Object r6 = r6.getData()
            id.dana.feeds.domain.synccontact.model.SyncResult r6 = (id.dana.feeds.domain.synccontact.model.SyncResult) r6
            boolean r6 = r6.getShouldEnqueueAnotherWork()
            if (r6 == 0) goto L7c
            r5.PlaceComponentResult()
        L7c:
            androidx.work.ListenableWorker$Result r5 = androidx.work.ListenableWorker.Result.BuiltInFictitiousFunctionClassFactory()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r4)
            goto Lc2
        L84:
            boolean r5 = r6 instanceof id.dana.domain.social.Result.Error
            if (r5 == 0) goto Lc3
            id.dana.domain.social.Result$Error r6 = (id.dana.domain.social.Result.Error) r6
            java.lang.Exception r5 = r6.getException()
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            java.lang.Class<id.dana.social.base.BaseSocialSyncWorker> r5 = id.dana.social.base.BaseSocialSyncWorker.class
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            java.lang.String r5 = r5.getSimpleName()
            java.lang.Exception r0 = r6.getException()
            java.lang.String r0 = r0.getMessage()
            java.lang.Exception r1 = r6.getException()
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            id.dana.utils.foundation.logger.log.DanaLog.BuiltInFictitiousFunctionClassFactory(r5, r0, r1)
            java.lang.Exception r5 = r6.getException()
            boolean r5 = r5 instanceof id.dana.domain.social.SocialSyncRetryException
            if (r5 == 0) goto Lbb
            androidx.work.ListenableWorker$Result r5 = androidx.work.ListenableWorker.Result.MyBillsEntityDataFactory()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r4)
            goto Lc2
        Lbb:
            androidx.work.ListenableWorker$Result r5 = androidx.work.ListenableWorker.Result.getAuthRequestContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r4)
        Lc2:
            return r5
        Lc3:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.base.BaseSocialSyncWorker.getAuthRequestContext(id.dana.social.base.BaseSocialSyncWorker, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
