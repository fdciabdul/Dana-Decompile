package id.dana.domain.promocode.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.promocode.model.PromoCode;
import id.dana.domain.promocode.repository.PromoCodeRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/promocode/interactor/ApplyPromoCode;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/promocode/model/PromoCode;", "Lid/dana/domain/promocode/interactor/ApplyPromoCode$ApplyPromoCodeParams;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/promocode/interactor/ApplyPromoCode$ApplyPromoCodeParams;)Lio/reactivex/Observable;", "Lid/dana/domain/promocode/repository/PromoCodeRepository;", "promoCodeRepository", "Lid/dana/domain/promocode/repository/PromoCodeRepository;", "<init>", "(Lid/dana/domain/promocode/repository/PromoCodeRepository;)V", "ApplyPromoCodeParams"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ApplyPromoCode extends BaseUseCase<PromoCode, ApplyPromoCodeParams> {
    private final PromoCodeRepository promoCodeRepository;

    @Inject
    public ApplyPromoCode(PromoCodeRepository promoCodeRepository) {
        Intrinsics.checkNotNullParameter(promoCodeRepository, "");
        this.promoCodeRepository = promoCodeRepository;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0004"}, d2 = {"Lid/dana/domain/promocode/interactor/ApplyPromoCode$ApplyPromoCodeParams;", "", "", "component1", "()Ljava/lang/String;", "promoCode", "copy", "(Ljava/lang/String;)Lid/dana/domain/promocode/interactor/ApplyPromoCode$ApplyPromoCodeParams;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getPromoCode", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class ApplyPromoCodeParams {
        private final String promoCode;

        public static /* synthetic */ ApplyPromoCodeParams copy$default(ApplyPromoCodeParams applyPromoCodeParams, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = applyPromoCodeParams.promoCode;
            }
            return applyPromoCodeParams.copy(str);
        }

        /* renamed from: component1  reason: from getter */
        public final String getPromoCode() {
            return this.promoCode;
        }

        public final ApplyPromoCodeParams copy(String promoCode) {
            Intrinsics.checkNotNullParameter(promoCode, "");
            return new ApplyPromoCodeParams(promoCode);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ApplyPromoCodeParams) && Intrinsics.areEqual(this.promoCode, ((ApplyPromoCodeParams) other).promoCode);
        }

        public final int hashCode() {
            return this.promoCode.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ApplyPromoCodeParams(promoCode=");
            sb.append(this.promoCode);
            sb.append(')');
            return sb.toString();
        }

        public ApplyPromoCodeParams(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.promoCode = str;
        }

        @JvmName(name = "getPromoCode")
        public final String getPromoCode() {
            return this.promoCode;
        }
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<PromoCode> buildUseCase(ApplyPromoCodeParams params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.promoCodeRepository.applyPromoCode(params.getPromoCode());
    }
}
