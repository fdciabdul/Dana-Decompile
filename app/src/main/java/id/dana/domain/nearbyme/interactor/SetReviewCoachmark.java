package id.dana.domain.nearbyme.interactor;

import id.dana.domain.nearbyme.MerchantInfoRepository;
import id.dana.domain.social.Result;
import id.dana.domain.social.core.CompletableUseCase;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lid/dana/domain/nearbyme/interactor/SetReviewCoachmark;", "Lid/dana/domain/social/core/CompletableUseCase;", "Lid/dana/domain/nearbyme/interactor/SetReviewCoachmark$Params;", "params", "Lid/dana/domain/social/Result;", "", "buildUseCase", "(Lid/dana/domain/nearbyme/interactor/SetReviewCoachmark$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/domain/nearbyme/MerchantInfoRepository;", "merchantInfoRepository", "Lid/dana/domain/nearbyme/MerchantInfoRepository;", "<init>", "(Lid/dana/domain/nearbyme/MerchantInfoRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SetReviewCoachmark extends CompletableUseCase<Params> {
    private final MerchantInfoRepository merchantInfoRepository;

    @Override // id.dana.domain.social.core.BaseUseCase
    public final /* bridge */ /* synthetic */ Object buildUseCase(Object obj, Continuation<? super Result<? extends Unit>> continuation) {
        return buildUseCase((Params) obj, (Continuation<? super Result<Unit>>) continuation);
    }

    @Inject
    public SetReviewCoachmark(MerchantInfoRepository merchantInfoRepository) {
        Intrinsics.checkNotNullParameter(merchantInfoRepository, "");
        this.merchantInfoRepository = merchantInfoRepository;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object buildUseCase(id.dana.domain.nearbyme.interactor.SetReviewCoachmark.Params r5, kotlin.coroutines.Continuation<? super id.dana.domain.social.Result<kotlin.Unit>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof id.dana.domain.nearbyme.interactor.SetReviewCoachmark$buildUseCase$1
            if (r0 == 0) goto L14
            r0 = r6
            id.dana.domain.nearbyme.interactor.SetReviewCoachmark$buildUseCase$1 r0 = (id.dana.domain.nearbyme.interactor.SetReviewCoachmark$buildUseCase$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 + r2
            r0.label = r6
            goto L19
        L14:
            id.dana.domain.nearbyme.interactor.SetReviewCoachmark$buildUseCase$1 r0 = new id.dana.domain.nearbyme.interactor.SetReviewCoachmark$buildUseCase$1
            r0.<init>(r4, r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L44
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r6)
            id.dana.domain.nearbyme.MerchantInfoRepository r6 = r4.merchantInfoRepository
            boolean r5 = r5.getEnabled()
            r0.label = r3
            java.lang.Object r5 = r6.setReviewCoachmark(r5, r0)
            if (r5 != r1) goto L44
            return r1
        L44:
            id.dana.domain.social.Result$Success r5 = new id.dana.domain.social.Result$Success
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            r5.<init>(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.nearbyme.interactor.SetReviewCoachmark.buildUseCase(id.dana.domain.nearbyme.interactor.SetReviewCoachmark$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004"}, d2 = {"Lid/dana/domain/nearbyme/interactor/SetReviewCoachmark$Params;", "", "", "component1", "()Z", "enabled", "copy", "(Z)Lid/dana/domain/nearbyme/interactor/SetReviewCoachmark$Params;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Z", "getEnabled", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Params {
        private final boolean enabled;

        public static /* synthetic */ Params copy$default(Params params, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = params.enabled;
            }
            return params.copy(z);
        }

        /* renamed from: component1  reason: from getter */
        public final boolean getEnabled() {
            return this.enabled;
        }

        public final Params copy(boolean enabled) {
            return new Params(enabled);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Params) && this.enabled == ((Params) other).enabled;
        }

        public final int hashCode() {
            boolean z = this.enabled;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(enabled=");
            sb.append(this.enabled);
            sb.append(')');
            return sb.toString();
        }

        public Params(boolean z) {
            this.enabled = z;
        }

        @JvmName(name = "getEnabled")
        public final boolean getEnabled() {
            return this.enabled;
        }
    }
}
