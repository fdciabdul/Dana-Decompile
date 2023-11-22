package id.dana.social.utils;

import android.content.Context;
import androidx.work.ExistingWorkPolicy;
import androidx.work.WorkerParameters;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.di.component.ApplicationComponent;
import id.dana.feeds.domain.synccontact.SyncRunner;
import id.dana.social.base.BaseSocialSyncWorker;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0007\u001a\u00020\u0006H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0007\u0010\rR\u0012\u0010\u000f\u001a\u00020\u000eX\u0087\"¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lid/dana/social/utils/FullSyncContactWorker;", "Lid/dana/social/base/BaseSocialSyncWorker;", "Lid/dana/domain/social/Result;", "Lid/dana/feeds/domain/synccontact/model/SyncResult;", "BuiltInFictitiousFunctionClassFactory", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/work/ListenableWorker$Result;", "KClassImpl$Data$declaredNonStaticMembers$2", "", "PlaceComponentResult", "()V", "Lid/dana/di/component/ApplicationComponent;", "p0", "(Lid/dana/di/component/ApplicationComponent;)V", "Lid/dana/feeds/domain/synccontact/SyncRunner;", "syncRunner", "Lid/dana/feeds/domain/synccontact/SyncRunner;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroidx/work/WorkerParameters;", "params", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FullSyncContactWorker extends BaseSocialSyncWorker {
    @Inject
    @Named("fullsync")
    public SyncRunner syncRunner;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullSyncContactWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(workerParameters, "");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0034  */
    @Override // id.dana.social.base.BaseSocialSyncWorker, androidx.work.CoroutineWorker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object KClassImpl$Data$declaredNonStaticMembers$2(kotlin.coroutines.Continuation<? super androidx.work.ListenableWorker.Result> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof id.dana.social.utils.FullSyncContactWorker$doWork$1
            if (r0 == 0) goto L14
            r0 = r6
            id.dana.social.utils.FullSyncContactWorker$doWork$1 r0 = (id.dana.social.utils.FullSyncContactWorker$doWork$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 + r2
            r0.label = r6
            goto L19
        L14:
            id.dana.social.utils.FullSyncContactWorker$doWork$1 r0 = new id.dana.social.utils.FullSyncContactWorker$doWork$1
            r0.<init>(r5, r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            java.lang.String r4 = "FullSyncContactWorker.doWork"
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r6)
            goto L49
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L34:
            kotlin.ResultKt.throwOnFailure(r6)
            id.dana.rum.Rum$Companion r6 = id.dana.rum.Rum.getAuthRequestContext
            id.dana.rum.Rum r6 = id.dana.rum.Rum.Companion.BuiltInFictitiousFunctionClassFactory()
            r6.PlaceComponentResult(r4)
            r0.label = r3
            java.lang.Object r6 = super.KClassImpl$Data$declaredNonStaticMembers$2(r0)
            if (r6 != r1) goto L49
            return r1
        L49:
            r0 = r6
            androidx.work.ListenableWorker$Result r0 = (androidx.work.ListenableWorker.Result) r0
            id.dana.rum.Rum$Companion r0 = id.dana.rum.Rum.getAuthRequestContext
            id.dana.rum.Rum r0 = id.dana.rum.Rum.Companion.BuiltInFictitiousFunctionClassFactory()
            r0.BuiltInFictitiousFunctionClassFactory(r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.utils.FullSyncContactWorker.KClassImpl$Data$declaredNonStaticMembers$2(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // id.dana.social.base.BaseSocialSyncWorker
    public final void KClassImpl$Data$declaredNonStaticMembers$2(ApplicationComponent p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.MyBillsEntityDataFactory(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ca  */
    @Override // id.dana.social.base.BaseSocialSyncWorker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object BuiltInFictitiousFunctionClassFactory(kotlin.coroutines.Continuation<? super id.dana.domain.social.Result<id.dana.feeds.domain.synccontact.model.SyncResult>> r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof id.dana.social.utils.FullSyncContactWorker$doSync$1
            if (r0 == 0) goto L14
            r0 = r12
            id.dana.social.utils.FullSyncContactWorker$doSync$1 r0 = (id.dana.social.utils.FullSyncContactWorker$doSync$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r12 = r0.label
            int r12 = r12 + r2
            r0.label = r12
            goto L19
        L14:
            id.dana.social.utils.FullSyncContactWorker$doSync$1 r0 = new id.dana.social.utils.FullSyncContactWorker$doSync$1
            r0.<init>(r11, r12)
        L19:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            java.lang.String r5 = ""
            r6 = 1
            if (r2 == 0) goto L4d
            if (r2 == r6) goto L45
            if (r2 == r4) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r0 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r12)
            goto Lcb
        L35:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L3d:
            java.lang.Object r2 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r12)
            r12 = r2
            goto Lbd
        L45:
            java.lang.Object r2 = r0.L$0
            id.dana.social.utils.FullSyncContactWorker r2 = (id.dana.social.utils.FullSyncContactWorker) r2
            kotlin.ResultKt.throwOnFailure(r12)
            goto L68
        L4d:
            kotlin.ResultKt.throwOnFailure(r12)
            id.dana.feeds.domain.synccontact.SyncRunner r12 = r11.syncRunner
            if (r12 == 0) goto L55
            goto L59
        L55:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r12 = 0
        L59:
            r11.getRunAttemptCount()
            r0.L$0 = r11
            r0.label = r6
            java.lang.Object r12 = r12.BuiltInFictitiousFunctionClassFactory(r0)
            if (r12 != r1) goto L67
            return r1
        L67:
            r2 = r11
        L68:
            r7 = r12
            id.dana.domain.social.Result r7 = (id.dana.domain.social.Result) r7
            boolean r8 = r7 instanceof id.dana.domain.social.Result.Success
            if (r8 == 0) goto Lcc
            id.dana.domain.social.Result$Success r7 = (id.dana.domain.social.Result.Success) r7
            java.lang.Object r7 = r7.getData()
            id.dana.feeds.domain.synccontact.model.SyncResult r7 = (id.dana.feeds.domain.synccontact.model.SyncResult) r7
            boolean r7 = r7.getShouldEnqueueAnotherWork()
            if (r7 != 0) goto Lcc
            kotlin.Pair[] r7 = new kotlin.Pair[r6]
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
            java.lang.String r8 = "All_CONTACT_SYNCHED"
            kotlin.Pair r6 = kotlin.TuplesKt.to(r8, r6)
            r8 = 0
            r7[r8] = r6
            androidx.work.Data$Builder r6 = new androidx.work.Data$Builder
            r6.<init>()
        L91:
            if (r8 > 0) goto La5
            r9 = r7[r8]
            int r8 = r8 + 1
            java.lang.Object r10 = r9.getFirst()
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r9 = r9.getSecond()
            r6.MyBillsEntityDataFactory(r10, r9)
            goto L91
        La5:
            androidx.work.Data r7 = new androidx.work.Data
            java.util.Map<java.lang.String, java.lang.Object> r6 = r6.MyBillsEntityDataFactory
            r7.<init>(r6)
            androidx.work.Data.getAuthRequestContext(r7)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r5)
            r0.L$0 = r12
            r0.label = r4
            java.lang.Object r2 = r2.MyBillsEntityDataFactory(r7, r0)
            if (r2 != r1) goto Lbd
            return r1
        Lbd:
            r0.L$0 = r12
            r0.label = r3
            r2 = 5000(0x1388, double:2.4703E-320)
            java.lang.Object r0 = kotlinx.coroutines.DelayKt.delay(r2, r0)
            if (r0 != r1) goto Lca
            return r1
        Lca:
            r0 = r12
        Lcb:
            r12 = r0
        Lcc:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.utils.FullSyncContactWorker.BuiltInFictitiousFunctionClassFactory(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // id.dana.social.base.BaseSocialSyncWorker
    public final void PlaceComponentResult() {
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "");
        SocialSyncManagerKt.BuiltInFictitiousFunctionClassFactory(applicationContext, ExistingWorkPolicy.REPLACE, 1L, TimeUnit.MINUTES);
    }
}
