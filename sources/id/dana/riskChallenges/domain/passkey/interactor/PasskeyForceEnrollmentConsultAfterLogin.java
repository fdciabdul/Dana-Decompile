package id.dana.riskChallenges.domain.passkey.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.riskChallenges.domain.passkey.PasskeyRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u000bB\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/riskChallenges/domain/passkey/interactor/PasskeyForceEnrollmentConsultAfterLogin;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lkotlin/Pair;", "", "Lid/dana/riskChallenges/domain/passkey/interactor/PasskeyForceEnrollmentConsultAfterLogin$Params;", "Lid/dana/riskChallenges/domain/passkey/PasskeyRepository;", "PlaceComponentResult", "Lid/dana/riskChallenges/domain/passkey/PasskeyRepository;", "p0", "<init>", "(Lid/dana/riskChallenges/domain/passkey/PasskeyRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class PasskeyForceEnrollmentConsultAfterLogin extends BaseUseCase<Pair<? extends Boolean, ? extends Boolean>, Params> {
    private final PasskeyRepository PlaceComponentResult;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/riskChallenges/domain/passkey/interactor/PasskeyForceEnrollmentConsultAfterLogin$Params;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "getAuthRequestContext"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final /* data */ class Params {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        final String getAuthRequestContext;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            return (p0 instanceof Params) && Intrinsics.areEqual(this.getAuthRequestContext, ((Params) p0).getAuthRequestContext);
        }

        public final int hashCode() {
            return this.getAuthRequestContext.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(')');
            return sb.toString();
        }
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<Pair<? extends Boolean, ? extends Boolean>> buildUseCase(Params params) {
        Params params2 = params;
        Intrinsics.checkNotNullParameter(params2, "");
        return this.PlaceComponentResult.PlaceComponentResult(params2.getAuthRequestContext);
    }

    @Inject
    public PasskeyForceEnrollmentConsultAfterLogin(PasskeyRepository passkeyRepository) {
        Intrinsics.checkNotNullParameter(passkeyRepository, "");
        this.PlaceComponentResult = passkeyRepository;
    }
}
