package id.dana.domain.useragreement.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.useragreement.UserConsentRepository;
import id.dana.domain.useragreement.model.ConsultAgreementResponse;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/useragreement/interactor/ConsultAgreementOnlyParamSpaceCodes;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/useragreement/model/ConsultAgreementResponse;", "Lid/dana/domain/useragreement/interactor/ConsultAgreementOnlyParamSpaceCodes$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/useragreement/interactor/ConsultAgreementOnlyParamSpaceCodes$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/useragreement/UserConsentRepository;", "userConsentRepository", "Lid/dana/domain/useragreement/UserConsentRepository;", "<init>", "(Lid/dana/domain/useragreement/UserConsentRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ConsultAgreementOnlyParamSpaceCodes extends BaseUseCase<ConsultAgreementResponse, Params> {
    private final UserConsentRepository userConsentRepository;

    @Inject
    public ConsultAgreementOnlyParamSpaceCodes(UserConsentRepository userConsentRepository) {
        Intrinsics.checkNotNullParameter(userConsentRepository, "");
        this.userConsentRepository = userConsentRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<ConsultAgreementResponse> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.userConsentRepository.consultAgreement(params.getSpaceCodes(), params.getAlwaysDisplayAgreementContent());
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00068\u0007¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0016\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0005"}, d2 = {"Lid/dana/domain/useragreement/interactor/ConsultAgreementOnlyParamSpaceCodes$Params;", "", "", "", "component1", "()Ljava/util/List;", "", "component2", "()Ljava/lang/Boolean;", "spaceCodes", "alwaysDisplayAgreementContent", "copy", "(Ljava/util/List;Ljava/lang/Boolean;)Lid/dana/domain/useragreement/interactor/ConsultAgreementOnlyParamSpaceCodes$Params;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "Ljava/lang/Boolean;", "getAlwaysDisplayAgreementContent", "Ljava/util/List;", "getSpaceCodes", "<init>", "(Ljava/util/List;Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class Params {
        private final Boolean alwaysDisplayAgreementContent;
        private final List<String> spaceCodes;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Params copy$default(Params params, List list, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                list = params.spaceCodes;
            }
            if ((i & 2) != 0) {
                bool = params.alwaysDisplayAgreementContent;
            }
            return params.copy(list, bool);
        }

        public final List<String> component1() {
            return this.spaceCodes;
        }

        /* renamed from: component2  reason: from getter */
        public final Boolean getAlwaysDisplayAgreementContent() {
            return this.alwaysDisplayAgreementContent;
        }

        public final Params copy(List<String> spaceCodes, Boolean alwaysDisplayAgreementContent) {
            Intrinsics.checkNotNullParameter(spaceCodes, "");
            return new Params(spaceCodes, alwaysDisplayAgreementContent);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Params) {
                Params params = (Params) other;
                return Intrinsics.areEqual(this.spaceCodes, params.spaceCodes) && Intrinsics.areEqual(this.alwaysDisplayAgreementContent, params.alwaysDisplayAgreementContent);
            }
            return false;
        }

        public final int hashCode() {
            int hashCode = this.spaceCodes.hashCode();
            Boolean bool = this.alwaysDisplayAgreementContent;
            return (hashCode * 31) + (bool == null ? 0 : bool.hashCode());
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(spaceCodes=");
            sb.append(this.spaceCodes);
            sb.append(", alwaysDisplayAgreementContent=");
            sb.append(this.alwaysDisplayAgreementContent);
            sb.append(')');
            return sb.toString();
        }

        public Params(List<String> list, Boolean bool) {
            Intrinsics.checkNotNullParameter(list, "");
            this.spaceCodes = list;
            this.alwaysDisplayAgreementContent = bool;
        }

        public /* synthetic */ Params(List list, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, (i & 2) != 0 ? null : bool);
        }

        @JvmName(name = "getSpaceCodes")
        public final List<String> getSpaceCodes() {
            return this.spaceCodes;
        }

        @JvmName(name = "getAlwaysDisplayAgreementContent")
        public final Boolean getAlwaysDisplayAgreementContent() {
            return this.alwaysDisplayAgreementContent;
        }
    }
}
