package id.dana.domain.nearbyme.interactor;

import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.nearbyme.MerchantConfigRepository;
import id.dana.domain.nearbyme.model.MerchantDetailPromoConfig;
import id.dana.domain.social.Result;
import id.dana.domain.social.core.SingleUseCase;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lid/dana/domain/nearbyme/interactor/GetMerchantDetailPromoConfig;", "Lid/dana/domain/social/core/SingleUseCase;", "Lid/dana/domain/core/usecase/NoParams;", "Lid/dana/domain/nearbyme/model/MerchantDetailPromoConfig;", "params", "Lid/dana/domain/social/Result;", "buildUseCase", "(Lid/dana/domain/core/usecase/NoParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/domain/nearbyme/MerchantConfigRepository;", "merchantConfigRepository", "Lid/dana/domain/nearbyme/MerchantConfigRepository;", "<init>", "(Lid/dana/domain/nearbyme/MerchantConfigRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetMerchantDetailPromoConfig extends SingleUseCase<NoParams, MerchantDetailPromoConfig> {
    private final MerchantConfigRepository merchantConfigRepository;

    @Override // id.dana.domain.social.core.BaseUseCase
    public final /* bridge */ /* synthetic */ Object buildUseCase(Object obj, Continuation continuation) {
        return buildUseCase((NoParams) obj, (Continuation<? super Result<MerchantDetailPromoConfig>>) continuation);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlinx.coroutines.CoroutineDispatcher] */
    @javax.inject.Inject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public GetMerchantDetailPromoConfig(id.dana.domain.nearbyme.MerchantConfigRepository r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            r2.merchantConfigRepository = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.nearbyme.interactor.GetMerchantDetailPromoConfig.<init>(id.dana.domain.nearbyme.MerchantConfigRepository):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object buildUseCase(id.dana.domain.core.usecase.NoParams r4, kotlin.coroutines.Continuation<? super id.dana.domain.social.Result<id.dana.domain.nearbyme.model.MerchantDetailPromoConfig>> r5) {
        /*
            r3 = this;
            boolean r4 = r5 instanceof id.dana.domain.nearbyme.interactor.GetMerchantDetailPromoConfig$buildUseCase$1
            if (r4 == 0) goto L14
            r4 = r5
            id.dana.domain.nearbyme.interactor.GetMerchantDetailPromoConfig$buildUseCase$1 r4 = (id.dana.domain.nearbyme.interactor.GetMerchantDetailPromoConfig$buildUseCase$1) r4
            int r0 = r4.label
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r1
            if (r0 == 0) goto L14
            int r5 = r4.label
            int r5 = r5 + r1
            r4.label = r5
            goto L19
        L14:
            id.dana.domain.nearbyme.interactor.GetMerchantDetailPromoConfig$buildUseCase$1 r4 = new id.dana.domain.nearbyme.interactor.GetMerchantDetailPromoConfig$buildUseCase$1
            r4.<init>(r3, r5)
        L19:
            java.lang.Object r5 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L32
            if (r1 != r2) goto L2a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L40
        L2a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L32:
            kotlin.ResultKt.throwOnFailure(r5)
            id.dana.domain.nearbyme.MerchantConfigRepository r5 = r3.merchantConfigRepository
            r4.label = r2
            java.lang.Object r5 = r5.getMerchantDetailPromoConfig(r4)
            if (r5 != r0) goto L40
            return r0
        L40:
            id.dana.domain.social.Result$Success r4 = new id.dana.domain.social.Result$Success
            r4.<init>(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.nearbyme.interactor.GetMerchantDetailPromoConfig.buildUseCase(id.dana.domain.core.usecase.NoParams, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
