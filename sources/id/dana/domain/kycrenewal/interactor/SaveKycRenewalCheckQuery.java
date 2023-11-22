package id.dana.domain.kycrenewal.interactor;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.kycrenewal.KycRenewalRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/kycrenewal/interactor/SaveKycRenewalCheckQuery;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/kycrenewal/interactor/SaveKycRenewalCheckQuery$Param;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/kycrenewal/interactor/SaveKycRenewalCheckQuery$Param;)Lio/reactivex/Observable;", "Lid/dana/domain/kycrenewal/KycRenewalRepository;", "kycRenewalRepository", "Lid/dana/domain/kycrenewal/KycRenewalRepository;", "<init>", "(Lid/dana/domain/kycrenewal/KycRenewalRepository;)V", "Param"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SaveKycRenewalCheckQuery extends BaseUseCase<Boolean, Param> {
    private final KycRenewalRepository kycRenewalRepository;

    @Inject
    public SaveKycRenewalCheckQuery(KycRenewalRepository kycRenewalRepository) {
        Intrinsics.checkNotNullParameter(kycRenewalRepository, "");
        this.kycRenewalRepository = kycRenewalRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Boolean> buildUseCase(Param params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.kycRenewalRepository.saveQueryKYCRenewalDialog(params.getTimeStamp());
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004"}, d2 = {"Lid/dana/domain/kycrenewal/interactor/SaveKycRenewalCheckQuery$Param;", "", "", "component1", "()J", LogConstants.KEY_TIME_STAPM, "copy", "(J)Lid/dana/domain/kycrenewal/interactor/SaveKycRenewalCheckQuery$Param;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "J", "getTimeStamp", "<init>", "(J)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Param {
        private final long timeStamp;

        public static /* synthetic */ Param copy$default(Param param, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = param.timeStamp;
            }
            return param.copy(j);
        }

        /* renamed from: component1  reason: from getter */
        public final long getTimeStamp() {
            return this.timeStamp;
        }

        public final Param copy(long timeStamp) {
            return new Param(timeStamp);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Param) && this.timeStamp == ((Param) other).timeStamp;
        }

        public final int hashCode() {
            return Cbor$Arg$$ExternalSyntheticBackport0.m(this.timeStamp);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Param(timeStamp=");
            sb.append(this.timeStamp);
            sb.append(')');
            return sb.toString();
        }

        public Param(long j) {
            this.timeStamp = j;
        }

        @JvmName(name = "getTimeStamp")
        public final long getTimeStamp() {
            return this.timeStamp;
        }
    }
}
