package id.dana.domain.kycrenewal.interactor;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.common.container.provider.ui.ContainerUIProvider;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.kycrenewal.KycRenewalRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/kycrenewal/interactor/SaveKycRenewalCheckShow;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/kycrenewal/interactor/SaveKycRenewalCheckShow$Param;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/kycrenewal/interactor/SaveKycRenewalCheckShow$Param;)Lio/reactivex/Observable;", "Lid/dana/domain/kycrenewal/KycRenewalRepository;", "kycRenewalRepository", "Lid/dana/domain/kycrenewal/KycRenewalRepository;", "<init>", "(Lid/dana/domain/kycrenewal/KycRenewalRepository;)V", "Param"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SaveKycRenewalCheckShow extends BaseUseCase<Boolean, Param> {
    private final KycRenewalRepository kycRenewalRepository;

    @Inject
    public SaveKycRenewalCheckShow(KycRenewalRepository kycRenewalRepository) {
        Intrinsics.checkNotNullParameter(kycRenewalRepository, "");
        this.kycRenewalRepository = kycRenewalRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Boolean> buildUseCase(Param params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.kycRenewalRepository.saveShowKYCRenewalDialog(params.getShow(), params.getTimeStamp());
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007"}, d2 = {"Lid/dana/domain/kycrenewal/interactor/SaveKycRenewalCheckShow$Param;", "", "", "component1", "()Z", "", "component2", "()J", ContainerUIProvider.KEY_SHOW, LogConstants.KEY_TIME_STAPM, "copy", "(ZJ)Lid/dana/domain/kycrenewal/interactor/SaveKycRenewalCheckShow$Param;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Z", "getShow", "J", "getTimeStamp", "<init>", "(ZJ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Param {
        private final boolean show;
        private final long timeStamp;

        public static /* synthetic */ Param copy$default(Param param, boolean z, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                z = param.show;
            }
            if ((i & 2) != 0) {
                j = param.timeStamp;
            }
            return param.copy(z, j);
        }

        /* renamed from: component1  reason: from getter */
        public final boolean getShow() {
            return this.show;
        }

        /* renamed from: component2  reason: from getter */
        public final long getTimeStamp() {
            return this.timeStamp;
        }

        public final Param copy(boolean show, long timeStamp) {
            return new Param(show, timeStamp);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Param) {
                Param param = (Param) other;
                return this.show == param.show && this.timeStamp == param.timeStamp;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public final int hashCode() {
            boolean z = this.show;
            ?? r0 = z;
            if (z) {
                r0 = 1;
            }
            return (r0 * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.timeStamp);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Param(show=");
            sb.append(this.show);
            sb.append(", timeStamp=");
            sb.append(this.timeStamp);
            sb.append(')');
            return sb.toString();
        }

        public Param(boolean z, long j) {
            this.show = z;
            this.timeStamp = j;
        }

        @JvmName(name = "getShow")
        public final boolean getShow() {
            return this.show;
        }

        @JvmName(name = "getTimeStamp")
        public final long getTimeStamp() {
            return this.timeStamp;
        }
    }
}
