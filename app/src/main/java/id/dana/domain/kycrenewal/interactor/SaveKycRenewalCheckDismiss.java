package id.dana.domain.kycrenewal.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.kycrenewal.KycRenewalRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/kycrenewal/interactor/SaveKycRenewalCheckDismiss;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/kycrenewal/interactor/SaveKycRenewalCheckDismiss$Param;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/kycrenewal/interactor/SaveKycRenewalCheckDismiss$Param;)Lio/reactivex/Observable;", "Lid/dana/domain/kycrenewal/KycRenewalRepository;", "kycRenewalRepository", "Lid/dana/domain/kycrenewal/KycRenewalRepository;", "<init>", "(Lid/dana/domain/kycrenewal/KycRenewalRepository;)V", "Param"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SaveKycRenewalCheckDismiss extends BaseUseCase<Boolean, Param> {
    private final KycRenewalRepository kycRenewalRepository;

    @Inject
    public SaveKycRenewalCheckDismiss(KycRenewalRepository kycRenewalRepository) {
        Intrinsics.checkNotNullParameter(kycRenewalRepository, "");
        this.kycRenewalRepository = kycRenewalRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Boolean> buildUseCase(Param params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.kycRenewalRepository.setKYCRenewalDismissCount(params.getCount());
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0004"}, d2 = {"Lid/dana/domain/kycrenewal/interactor/SaveKycRenewalCheckDismiss$Param;", "", "", "component1", "()I", "count", "copy", "(I)Lid/dana/domain/kycrenewal/interactor/SaveKycRenewalCheckDismiss$Param;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "I", "getCount", "<init>", "(I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Param {
        private final int count;

        public static /* synthetic */ Param copy$default(Param param, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = param.count;
            }
            return param.copy(i);
        }

        /* renamed from: component1  reason: from getter */
        public final int getCount() {
            return this.count;
        }

        public final Param copy(int count) {
            return new Param(count);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Param) && this.count == ((Param) other).count;
        }

        public final int hashCode() {
            return this.count;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Param(count=");
            sb.append(this.count);
            sb.append(')');
            return sb.toString();
        }

        public Param(int i) {
            this.count = i;
        }

        @JvmName(name = "getCount")
        public final int getCount() {
            return this.count;
        }
    }
}
