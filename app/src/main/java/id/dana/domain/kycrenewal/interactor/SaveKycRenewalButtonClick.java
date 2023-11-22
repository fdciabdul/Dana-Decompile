package id.dana.domain.kycrenewal.interactor;

import com.alibaba.griver.beehive.lottie.player.DynamicLayerModel;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.kycrenewal.KycRenewalRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/kycrenewal/interactor/SaveKycRenewalButtonClick;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/kycrenewal/interactor/SaveKycRenewalButtonClick$Param;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/kycrenewal/interactor/SaveKycRenewalButtonClick$Param;)Lio/reactivex/Observable;", "Lid/dana/domain/kycrenewal/KycRenewalRepository;", "kycRenewalRepository", "Lid/dana/domain/kycrenewal/KycRenewalRepository;", "<init>", "(Lid/dana/domain/kycrenewal/KycRenewalRepository;)V", "Param"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SaveKycRenewalButtonClick extends BaseUseCase<Boolean, Param> {
    private final KycRenewalRepository kycRenewalRepository;

    @Inject
    public SaveKycRenewalButtonClick(KycRenewalRepository kycRenewalRepository) {
        Intrinsics.checkNotNullParameter(kycRenewalRepository, "");
        this.kycRenewalRepository = kycRenewalRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Boolean> buildUseCase(Param params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.kycRenewalRepository.saveClickKYCRenewalButton(params.getClick());
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004"}, d2 = {"Lid/dana/domain/kycrenewal/interactor/SaveKycRenewalButtonClick$Param;", "", "", "component1", "()Z", DynamicLayerModel.TYPE_CLICK, "copy", "(Z)Lid/dana/domain/kycrenewal/interactor/SaveKycRenewalButtonClick$Param;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Z", "getClick", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Param {
        private final boolean click;

        public static /* synthetic */ Param copy$default(Param param, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = param.click;
            }
            return param.copy(z);
        }

        /* renamed from: component1  reason: from getter */
        public final boolean getClick() {
            return this.click;
        }

        public final Param copy(boolean click) {
            return new Param(click);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Param) && this.click == ((Param) other).click;
        }

        public final int hashCode() {
            boolean z = this.click;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Param(click=");
            sb.append(this.click);
            sb.append(')');
            return sb.toString();
        }

        public Param(boolean z) {
            this.click = z;
        }

        @JvmName(name = "getClick")
        public final boolean getClick() {
            return this.click;
        }
    }
}
