package id.dana.domain.nearbyme.interactor.merchantreview;

import id.dana.domain.core.usecase.CoroutineWorkerUseCase;
import id.dana.domain.nearbyme.MerchantReviewRepository;
import id.dana.domain.nearbyme.model.MerchantCreateReview;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lid/dana/domain/nearbyme/interactor/merchantreview/CreateMerchantReview;", "Lid/dana/domain/core/usecase/CoroutineWorkerUseCase;", "Lid/dana/domain/nearbyme/model/MerchantCreateReview;", "", "param", "execute", "(Lid/dana/domain/nearbyme/model/MerchantCreateReview;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/domain/nearbyme/MerchantReviewRepository;", "merchantReviewRepository", "Lid/dana/domain/nearbyme/MerchantReviewRepository;", "<init>", "(Lid/dana/domain/nearbyme/MerchantReviewRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CreateMerchantReview extends CoroutineWorkerUseCase<MerchantCreateReview, Unit> {
    private final MerchantReviewRepository merchantReviewRepository;

    @Inject
    public CreateMerchantReview(MerchantReviewRepository merchantReviewRepository) {
        Intrinsics.checkNotNullParameter(merchantReviewRepository, "");
        this.merchantReviewRepository = merchantReviewRepository;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0039  */
    @Override // id.dana.domain.core.usecase.CoroutineWorkerUseCase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object execute(id.dana.domain.nearbyme.model.MerchantCreateReview r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof id.dana.domain.nearbyme.interactor.merchantreview.CreateMerchantReview$execute$1
            if (r0 == 0) goto L14
            r0 = r7
            id.dana.domain.nearbyme.interactor.merchantreview.CreateMerchantReview$execute$1 r0 = (id.dana.domain.nearbyme.interactor.merchantreview.CreateMerchantReview$execute$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 + r2
            r0.label = r7
            goto L19
        L14:
            id.dana.domain.nearbyme.interactor.merchantreview.CreateMerchantReview$execute$1 r0 = new id.dana.domain.nearbyme.interactor.merchantreview.CreateMerchantReview$execute$1
            r0.<init>(r5, r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L39
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r7)
            goto L5b
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L4d
        L39:
            kotlin.ResultKt.throwOnFailure(r7)
            boolean r7 = r6.isUpdateReview()
            if (r7 == 0) goto L50
            id.dana.domain.nearbyme.MerchantReviewRepository r7 = r5.merchantReviewRepository
            r0.label = r4
            java.lang.Object r6 = r7.updateMerchantReview(r6, r0)
            if (r6 != r1) goto L4d
            return r1
        L4d:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L50:
            id.dana.domain.nearbyme.MerchantReviewRepository r7 = r5.merchantReviewRepository
            r0.label = r3
            java.lang.Object r6 = r7.createMerchantReview(r6, r0)
            if (r6 != r1) goto L5b
            return r1
        L5b:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.nearbyme.interactor.merchantreview.CreateMerchantReview.execute(id.dana.domain.nearbyme.model.MerchantCreateReview, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
