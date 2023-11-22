package id.dana.riskChallenges.domain.passkey.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.riskChallenges.domain.passkey.PasskeyRepository;
import id.dana.riskChallenges.domain.passkey.model.PasskeyCredential;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u000bB\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/riskChallenges/domain/passkey/interactor/PasskeyEnrollmentStatus;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/riskChallenges/domain/passkey/model/PasskeyCredential;", "Lid/dana/riskChallenges/domain/passkey/interactor/PasskeyEnrollmentStatus$Params;", "Lid/dana/riskChallenges/domain/passkey/PasskeyRepository;", "MyBillsEntityDataFactory", "Lid/dana/riskChallenges/domain/passkey/PasskeyRepository;", "p0", "<init>", "(Lid/dana/riskChallenges/domain/passkey/PasskeyRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PasskeyEnrollmentStatus extends BaseUseCase<List<? extends PasskeyCredential>, Params> {
    private final PasskeyRepository MyBillsEntityDataFactory;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<List<? extends PasskeyCredential>> buildUseCase(Params params) {
        Params params2 = params;
        Intrinsics.checkNotNullParameter(params2, "");
        return this.MyBillsEntityDataFactory.PlaceComponentResult(params2.getPlaceComponentResult());
    }

    @Inject
    public PasskeyEnrollmentStatus(PasskeyRepository passkeyRepository) {
        Intrinsics.checkNotNullParameter(passkeyRepository, "");
        this.MyBillsEntityDataFactory = passkeyRepository;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00038\u0007¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/riskChallenges/domain/passkey/interactor/PasskeyEnrollmentStatus$Params;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "Z", "PlaceComponentResult", "()Z", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Params {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        private final boolean PlaceComponentResult;

        public Params() {
            this(false, 1, null);
        }

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            return (p0 instanceof Params) && this.PlaceComponentResult == ((Params) p0).PlaceComponentResult;
        }

        public final int hashCode() {
            boolean z = this.PlaceComponentResult;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(PlaceComponentResult=");
            sb.append(this.PlaceComponentResult);
            sb.append(')');
            return sb.toString();
        }

        public Params(boolean z) {
            this.PlaceComponentResult = z;
        }

        public /* synthetic */ Params(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z);
        }

        @JvmName(name = "PlaceComponentResult")
        /* renamed from: PlaceComponentResult  reason: from getter */
        public final boolean getPlaceComponentResult() {
            return this.PlaceComponentResult;
        }
    }
}
