package id.dana.domain.useragreement.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.oauth.model.Agreement;
import id.dana.domain.useragreement.UserConsentRepository;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004\u0012\u0004\u0012\u00020\u00050\u0001:\u0001\u000fB\u0011\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\b\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00040\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/domain/useragreement/interactor/BuildAgreementContent;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "Lid/dana/domain/useragreement/interactor/BuildAgreementContent$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/useragreement/interactor/BuildAgreementContent$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/useragreement/UserConsentRepository;", "userConsentRepository", "Lid/dana/domain/useragreement/UserConsentRepository;", "<init>", "(Lid/dana/domain/useragreement/UserConsentRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BuildAgreementContent extends BaseUseCase<ArrayList<String>, Params> {
    private final UserConsentRepository userConsentRepository;

    @Inject
    public BuildAgreementContent(UserConsentRepository userConsentRepository) {
        Intrinsics.checkNotNullParameter(userConsentRepository, "");
        this.userConsentRepository = userConsentRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<ArrayList<String>> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.userConsentRepository.buildAgreementContent(params.getAppName(), params.getAgreementContents$domain_productionRelease());
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/domain/useragreement/interactor/BuildAgreementContent$Params;", "", "", "Lid/dana/domain/oauth/model/Agreement;", "agreementContents", "Ljava/util/List;", "getAgreementContents$domain_productionRelease", "()Ljava/util/List;", "", "appName", "Ljava/lang/String;", "getAppName$domain_productionRelease", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Params {
        private final List<Agreement> agreementContents;
        private final String appName;

        /* JADX WARN: Multi-variable type inference failed */
        public Params(String str, List<? extends Agreement> list) {
            Intrinsics.checkNotNullParameter(str, "");
            this.appName = str;
            this.agreementContents = list;
        }

        @JvmName(name = "getAppName$domain_productionRelease")
        /* renamed from: getAppName$domain_productionRelease  reason: from getter */
        public final String getAppName() {
            return this.appName;
        }

        @JvmName(name = "getAgreementContents$domain_productionRelease")
        public final List<Agreement> getAgreementContents$domain_productionRelease() {
            return this.agreementContents;
        }
    }
}
