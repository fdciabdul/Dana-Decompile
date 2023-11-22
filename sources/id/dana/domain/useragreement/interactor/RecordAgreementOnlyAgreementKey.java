package id.dana.domain.useragreement.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.useragreement.UserConsentRepository;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/useragreement/interactor/RecordAgreementOnlyAgreementKey;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/useragreement/interactor/RecordAgreementOnlyAgreementKey$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/useragreement/interactor/RecordAgreementOnlyAgreementKey$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/useragreement/UserConsentRepository;", "userConsentRepository", "Lid/dana/domain/useragreement/UserConsentRepository;", "<init>", "(Lid/dana/domain/useragreement/UserConsentRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RecordAgreementOnlyAgreementKey extends BaseUseCase<Boolean, Params> {
    private final UserConsentRepository userConsentRepository;

    @Inject
    public RecordAgreementOnlyAgreementKey(UserConsentRepository userConsentRepository) {
        Intrinsics.checkNotNullParameter(userConsentRepository, "");
        this.userConsentRepository = userConsentRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Boolean> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.userConsentRepository.recordAgreement(params.getAgreementKey$domain_productionRelease(), params.getUserAgree());
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/domain/useragreement/interactor/RecordAgreementOnlyAgreementKey$Params;", "", "", "", "agreementKey", "Ljava/util/List;", "getAgreementKey$domain_productionRelease", "()Ljava/util/List;", "", "userAgree", "Z", "getUserAgree$domain_productionRelease", "()Z", "<init>", "(Ljava/util/List;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {
        private final List<String> agreementKey;
        private final boolean userAgree;

        public Params(List<String> list, boolean z) {
            Intrinsics.checkNotNullParameter(list, "");
            this.agreementKey = list;
            this.userAgree = z;
        }

        @JvmName(name = "getAgreementKey$domain_productionRelease")
        public final List<String> getAgreementKey$domain_productionRelease() {
            return this.agreementKey;
        }

        @JvmName(name = "getUserAgree$domain_productionRelease")
        /* renamed from: getUserAgree$domain_productionRelease  reason: from getter */
        public final boolean getUserAgree() {
            return this.userAgree;
        }
    }
}
