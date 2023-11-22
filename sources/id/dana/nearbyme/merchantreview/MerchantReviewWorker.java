package id.dana.nearbyme.merchantreview;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.di.component.ApplicationComponent;
import id.dana.domain.social.Result;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0005\u001a\u00020\u0004H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H¤@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\b\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH$¢\u0006\u0004\b\b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00028\u0000H$¢\u0006\u0004\b\u0005\u0010\rR\u0014\u0010\u0005\u001a\u00020\u000e8%X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lid/dana/nearbyme/merchantreview/MerchantReviewWorker;", "", "R", "Landroidx/work/CoroutineWorker;", "Landroidx/work/ListenableWorker$Result;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/domain/social/Result;", "getAuthRequestContext", "Lid/dana/di/component/ApplicationComponent;", "p0", "", "(Lid/dana/di/component/ApplicationComponent;)V", "(Ljava/lang/Object;)Landroidx/work/ListenableWorker$Result;", "", "()I", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroidx/work/WorkerParameters;", "params", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class MerchantReviewWorker<R> extends CoroutineWorker {
    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    protected abstract int KClassImpl$Data$declaredNonStaticMembers$2();

    protected abstract ListenableWorker.Result KClassImpl$Data$declaredNonStaticMembers$2(R p0);

    @Override // androidx.work.CoroutineWorker
    public final Object KClassImpl$Data$declaredNonStaticMembers$2(Continuation<? super ListenableWorker.Result> continuation) {
        return PlaceComponentResult(this, continuation);
    }

    protected abstract Object getAuthRequestContext(Continuation<? super Result<? extends R>> continuation);

    protected abstract void getAuthRequestContext(ApplicationComponent p0);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantReviewWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(workerParameters, "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Object PlaceComponentResult(id.dana.nearbyme.merchantreview.MerchantReviewWorker r6, kotlin.coroutines.Continuation r7) {
        /*
            boolean r0 = r7 instanceof id.dana.nearbyme.merchantreview.MerchantReviewWorker$doWork$1
            if (r0 == 0) goto L14
            r0 = r7
            id.dana.nearbyme.merchantreview.MerchantReviewWorker$doWork$1 r0 = (id.dana.nearbyme.merchantreview.MerchantReviewWorker$doWork$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 + r2
            r0.label = r7
            goto L19
        L14:
            id.dana.nearbyme.merchantreview.MerchantReviewWorker$doWork$1 r0 = new id.dana.nearbyme.merchantreview.MerchantReviewWorker$doWork$1
            r0.<init>(r6, r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            java.lang.String r4 = "MerchantReviewWorker.doWork"
            java.lang.String r5 = ""
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r6 = r0.L$0
            id.dana.nearbyme.merchantreview.MerchantReviewWorker r6 = (id.dana.nearbyme.merchantreview.MerchantReviewWorker) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L61
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            kotlin.ResultKt.throwOnFailure(r7)
            id.dana.rum.Rum$Companion r7 = id.dana.rum.Rum.getAuthRequestContext
            id.dana.rum.Rum r7 = id.dana.rum.Rum.Companion.BuiltInFictitiousFunctionClassFactory()
            r7.PlaceComponentResult(r4)
            android.content.Context r7 = r6.getApplicationContext()
            id.dana.DanaApplication r7 = (id.dana.DanaApplication) r7
            id.dana.di.component.ApplicationComponent r7 = r7.getApplicationComponent()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r5)
            r6.getAuthRequestContext(r7)
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r7 = r6.getAuthRequestContext(r0)
            if (r7 != r1) goto L61
            return r1
        L61:
            id.dana.domain.social.Result r7 = (id.dana.domain.social.Result) r7
            boolean r0 = r7 instanceof id.dana.domain.social.Result.Success
            if (r0 == 0) goto L72
            id.dana.domain.social.Result$Success r7 = (id.dana.domain.social.Result.Success) r7
            java.lang.Object r7 = r7.getData()
            androidx.work.ListenableWorker$Result r6 = r6.KClassImpl$Data$declaredNonStaticMembers$2(r7)
            goto La3
        L72:
            boolean r0 = r7 instanceof id.dana.domain.social.Result.Error
            if (r0 == 0) goto Lad
            id.dana.domain.social.Result$Error r7 = (id.dana.domain.social.Result.Error) r7
            java.lang.Exception r7 = r7.getException()
            java.lang.String r0 = r7.getLocalizedMessage()
            if (r0 != 0) goto L83
            r0 = r5
        L83:
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            java.lang.String r1 = "NearbyMeMerchantReview"
            id.dana.utils.foundation.logger.log.DanaLog.BuiltInFictitiousFunctionClassFactory(r1, r0, r7)
            int r7 = r6.getRunAttemptCount()
            int r6 = r6.KClassImpl$Data$declaredNonStaticMembers$2()
            if (r7 >= r6) goto L9c
            androidx.work.ListenableWorker$Result r6 = androidx.work.ListenableWorker.Result.MyBillsEntityDataFactory()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r5)
            goto La3
        L9c:
            androidx.work.ListenableWorker$Result r6 = androidx.work.ListenableWorker.Result.BuiltInFictitiousFunctionClassFactory()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r5)
        La3:
            id.dana.rum.Rum$Companion r7 = id.dana.rum.Rum.getAuthRequestContext
            id.dana.rum.Rum r7 = id.dana.rum.Rum.Companion.BuiltInFictitiousFunctionClassFactory()
            r7.BuiltInFictitiousFunctionClassFactory(r4)
            return r6
        Lad:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.merchantreview.MerchantReviewWorker.PlaceComponentResult(id.dana.nearbyme.merchantreview.MerchantReviewWorker, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
