package id.dana.domain.useragreement.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.useragreement.UserConsentRepository;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/useragreement/interactor/RecordAgreement;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/useragreement/interactor/RecordAgreement$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/useragreement/interactor/RecordAgreement$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/useragreement/UserConsentRepository;", "userConsentRepository", "Lid/dana/domain/useragreement/UserConsentRepository;", "<init>", "(Lid/dana/domain/useragreement/UserConsentRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RecordAgreement extends BaseUseCase<Unit, Params> {
    private final UserConsentRepository userConsentRepository;

    @Inject
    public RecordAgreement(UserConsentRepository userConsentRepository) {
        Intrinsics.checkNotNullParameter(userConsentRepository, "");
        this.userConsentRepository = userConsentRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Unit> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.userConsentRepository.recordAgreement(params.getServiceKeyOrAppId(), params.getAgreementKeys$domain_productionRelease(), params.getUserAgree(), params.getAgreementType(), params.getScopes(), params.getAppId(), params.getClientId(), params.getMerchantId());
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001b\u0010\u001cR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00038\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u00038\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000bR\u001a\u0010\u0014\u001a\u00020\u00038\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u0014\u0010\t\u001a\u0004\b\u0015\u0010\u000bR\u001a\u0010\u0017\u001a\u00020\u00168\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a"}, d2 = {"Lid/dana/domain/useragreement/interactor/RecordAgreement$Params;", "", "", "", "agreementKeys", "Ljava/util/List;", "getAgreementKeys$domain_productionRelease", "()Ljava/util/List;", "agreementType", "Ljava/lang/String;", "getAgreementType$domain_productionRelease", "()Ljava/lang/String;", "appId", "getAppId$domain_productionRelease", "clientId", "getClientId$domain_productionRelease", "merchantId", "getMerchantId$domain_productionRelease", "scopes", "getScopes$domain_productionRelease", "serviceKeyOrAppId", "getServiceKeyOrAppId$domain_productionRelease", "", "userAgree", "Z", "getUserAgree$domain_productionRelease", "()Z", "<init>", "(Ljava/lang/String;Ljava/util/List;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Params {
        private final List<String> agreementKeys;
        private final String agreementType;
        private final String appId;
        private final String clientId;
        private final String merchantId;
        private final String scopes;
        private final String serviceKeyOrAppId;
        private final boolean userAgree;

        public Params(String str, List<String> list, boolean z, String str2, String str3, String str4, String str5, String str6) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(list, "");
            Intrinsics.checkNotNullParameter(str3, "");
            this.serviceKeyOrAppId = str;
            this.agreementKeys = list;
            this.userAgree = z;
            this.agreementType = str2;
            this.scopes = str3;
            this.appId = str4;
            this.clientId = str5;
            this.merchantId = str6;
        }

        @JvmName(name = "getServiceKeyOrAppId$domain_productionRelease")
        /* renamed from: getServiceKeyOrAppId$domain_productionRelease  reason: from getter */
        public final String getServiceKeyOrAppId() {
            return this.serviceKeyOrAppId;
        }

        @JvmName(name = "getAgreementKeys$domain_productionRelease")
        public final List<String> getAgreementKeys$domain_productionRelease() {
            return this.agreementKeys;
        }

        @JvmName(name = "getUserAgree$domain_productionRelease")
        /* renamed from: getUserAgree$domain_productionRelease  reason: from getter */
        public final boolean getUserAgree() {
            return this.userAgree;
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

        @JvmName(name = "getAppId$domain_productionRelease")
        /* renamed from: getAppId$domain_productionRelease  reason: from getter */
        public final String getAppId() {
            return this.appId;
        }

        @JvmName(name = "getClientId$domain_productionRelease")
        /* renamed from: getClientId$domain_productionRelease  reason: from getter */
        public final String getClientId() {
            return this.clientId;
        }

        @JvmName(name = "getMerchantId$domain_productionRelease")
        /* renamed from: getMerchantId$domain_productionRelease  reason: from getter */
        public final String getMerchantId() {
            return this.merchantId;
        }
    }
}
