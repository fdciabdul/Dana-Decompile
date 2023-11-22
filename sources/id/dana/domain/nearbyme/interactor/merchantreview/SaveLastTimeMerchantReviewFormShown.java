package id.dana.domain.nearbyme.interactor.merchantreview;

import id.dana.domain.nearbyme.MerchantReviewFormRepository;
import id.dana.domain.social.Result;
import id.dana.domain.social.core.SingleUseCase;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lid/dana/domain/nearbyme/interactor/merchantreview/SaveLastTimeMerchantReviewFormShown;", "Lid/dana/domain/social/core/SingleUseCase;", "", "", "lastTimeMerchantReviewShown", "Lid/dana/domain/social/Result;", "buildUseCase", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/domain/nearbyme/MerchantReviewFormRepository;", "merchantReviewFormRepository", "Lid/dana/domain/nearbyme/MerchantReviewFormRepository;", "<init>", "(Lid/dana/domain/nearbyme/MerchantReviewFormRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SaveLastTimeMerchantReviewFormShown extends SingleUseCase<Long, Boolean> {
    private final MerchantReviewFormRepository merchantReviewFormRepository;

    @Override // id.dana.domain.social.core.BaseUseCase
    public final /* synthetic */ Object buildUseCase(Object obj, Continuation continuation) {
        return buildUseCase(((Number) obj).longValue(), continuation);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlinx.coroutines.CoroutineDispatcher] */
    @javax.inject.Inject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public SaveLastTimeMerchantReviewFormShown(id.dana.domain.nearbyme.MerchantReviewFormRepository r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            r2.merchantReviewFormRepository = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.nearbyme.interactor.merchantreview.SaveLastTimeMerchantReviewFormShown.<init>(id.dana.domain.nearbyme.MerchantReviewFormRepository):void");
    }

    public final Object buildUseCase(long j, Continuation<? super Result<Boolean>> continuation) {
        return new Result.Success(Boxing.boxBoolean(this.merchantReviewFormRepository.saveLastTimeMerchantReviewShown(j)));
    }
}
