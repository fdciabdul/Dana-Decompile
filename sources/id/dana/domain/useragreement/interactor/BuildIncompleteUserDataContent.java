package id.dana.domain.useragreement.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.useragreement.UserConsentRepository;
import io.reactivex.Observable;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u000eB\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/domain/useragreement/interactor/BuildIncompleteUserDataContent;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "", "Lid/dana/domain/useragreement/interactor/BuildIncompleteUserDataContent$Param;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/useragreement/interactor/BuildIncompleteUserDataContent$Param;)Lio/reactivex/Observable;", "Lid/dana/domain/useragreement/UserConsentRepository;", "userConsentRepository", "Lid/dana/domain/useragreement/UserConsentRepository;", "<init>", "(Lid/dana/domain/useragreement/UserConsentRepository;)V", "Param"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BuildIncompleteUserDataContent extends BaseUseCase<List<? extends String>, Param> {
    private final UserConsentRepository userConsentRepository;

    @Inject
    public BuildIncompleteUserDataContent(UserConsentRepository userConsentRepository) {
        Intrinsics.checkNotNullParameter(userConsentRepository, "");
        this.userConsentRepository = userConsentRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<List<String>> buildUseCase(Param params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.userConsentRepository.buildIncompleteUserDataContent(params.getIncompleteUserData$domain_productionRelease());
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\b\u0010\tR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/domain/useragreement/interactor/BuildIncompleteUserDataContent$Param;", "", "", "", "incompleteUserData", "Ljava/util/Set;", "getIncompleteUserData$domain_productionRelease", "()Ljava/util/Set;", "<init>", "(Ljava/util/Set;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Param {
        private final Set<String> incompleteUserData;

        public Param(Set<String> set) {
            Intrinsics.checkNotNullParameter(set, "");
            this.incompleteUserData = set;
        }

        @JvmName(name = "getIncompleteUserData$domain_productionRelease")
        public final Set<String> getIncompleteUserData$domain_productionRelease() {
            return this.incompleteUserData;
        }
    }
}
