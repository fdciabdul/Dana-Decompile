package id.dana.domain.useragreement.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.useragreement.UserConsentRepository;
import id.dana.domain.useragreement.model.ConsultAgreementResponse;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/useragreement/interactor/ConsultAgreement;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/useragreement/model/ConsultAgreementResponse;", "Lid/dana/domain/useragreement/interactor/ConsultAgreement$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/useragreement/interactor/ConsultAgreement$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/useragreement/UserConsentRepository;", "userConsentRepository", "Lid/dana/domain/useragreement/UserConsentRepository;", "<init>", "(Lid/dana/domain/useragreement/UserConsentRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ConsultAgreement extends BaseUseCase<ConsultAgreementResponse, Params> {
    private final UserConsentRepository userConsentRepository;

    @Inject
    public ConsultAgreement(UserConsentRepository userConsentRepository) {
        Intrinsics.checkNotNullParameter(userConsentRepository, "");
        this.userConsentRepository = userConsentRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<ConsultAgreementResponse> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.userConsentRepository.consultAgreement(params.getServiceKeyOrAppId(), params.getSpaceCodes$domain_productionRelease(), params.getAgreementType(), params.getScopes(), params.getClientId(), params.getIsMiniProgram());
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0006\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u00028\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00128\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/domain/useragreement/interactor/ConsultAgreement$Params;", "", "", "agreementType", "Ljava/lang/String;", "getAgreementType$domain_productionRelease", "()Ljava/lang/String;", "clientId", "getClientId$domain_productionRelease", "", "isMiniProgram", "Z", "isMiniProgram$domain_productionRelease", "()Z", "scopes", "getScopes$domain_productionRelease", "serviceKeyOrAppId", "getServiceKeyOrAppId$domain_productionRelease", "", "spaceCodes", "Ljava/util/List;", "getSpaceCodes$domain_productionRelease", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Params {
        private final String agreementType;
        private final String clientId;
        private final boolean isMiniProgram;
        private final String scopes;
        private final String serviceKeyOrAppId;
        private final List<String> spaceCodes;

        public Params(String str, List<String> list, String str2, String str3, String str4, boolean z) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(list, "");
            this.serviceKeyOrAppId = str;
            this.spaceCodes = list;
            this.agreementType = str2;
            this.scopes = str3;
            this.clientId = str4;
            this.isMiniProgram = z;
        }

        @JvmName(name = "getServiceKeyOrAppId$domain_productionRelease")
        /* renamed from: getServiceKeyOrAppId$domain_productionRelease  reason: from getter */
        public final String getServiceKeyOrAppId() {
            return this.serviceKeyOrAppId;
        }

        @JvmName(name = "getSpaceCodes$domain_productionRelease")
        public final List<String> getSpaceCodes$domain_productionRelease() {
            return this.spaceCodes;
        }

        @JvmName(name = "getAgreementType$domain_productionRelease")
        /* renamed from: getAgreementType$domain_productionRelease  reason: from getter */
        public final String getAgreementType() {
            return this.agreementType;
        }

        @JvmName(name = "getScopes$domain_productionRelease")
        /* renamed from: getScopes$domain_productionRelease  reason: from getter */
        public final String getScopes() {
            return this.scopes;
        }

        @JvmName(name = "getClientId$domain_productionRelease")
        /* renamed from: getClientId$domain_productionRelease  reason: from getter */
        public final String getClientId() {
            return this.clientId;
        }

        @JvmName(name = "isMiniProgram$domain_productionRelease")
        /* renamed from: isMiniProgram$domain_productionRelease  reason: from getter */
        public final boolean getIsMiniProgram() {
            return this.isMiniProgram;
        }
    }
}
