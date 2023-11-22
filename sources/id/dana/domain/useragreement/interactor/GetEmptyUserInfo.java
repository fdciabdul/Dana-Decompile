package id.dana.domain.useragreement.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.useragreement.UserConsentRepository;
import io.reactivex.Observable;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\r\u000e\u000fB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/useragreement/interactor/GetEmptyUserInfo;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/useragreement/interactor/GetEmptyUserInfo$UserInfo;", "Lid/dana/domain/useragreement/interactor/GetEmptyUserInfo$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/useragreement/interactor/GetEmptyUserInfo$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/useragreement/UserConsentRepository;", "repository", "Lid/dana/domain/useragreement/UserConsentRepository;", "<init>", "(Lid/dana/domain/useragreement/UserConsentRepository;)V", "Params", "Status", "UserInfo"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GetEmptyUserInfo extends BaseUseCase<UserInfo, Params> {
    private final UserConsentRepository repository;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006"}, d2 = {"Lid/dana/domain/useragreement/interactor/GetEmptyUserInfo$Status;", "", "<init>", "(Ljava/lang/String;I)V", "INCOMPLETE", "COMPLETE", "EMAIL_UNVERIFIED"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public enum Status {
        INCOMPLETE,
        COMPLETE,
        EMAIL_UNVERIFIED
    }

    @Inject
    public GetEmptyUserInfo(UserConsentRepository userConsentRepository) {
        Intrinsics.checkNotNullParameter(userConsentRepository, "");
        this.repository = userConsentRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<UserInfo> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.repository.checkUserInfo(params.getServiceKeyOrAppId(), params.getScopes(), params.getClientId(), params.getIsMiniProgram());
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\u00028\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006"}, d2 = {"Lid/dana/domain/useragreement/interactor/GetEmptyUserInfo$Params;", "", "", "clientId", "Ljava/lang/String;", "getClientId$domain_productionRelease", "()Ljava/lang/String;", "", "isMiniProgram", "Z", "isMiniProgram$domain_productionRelease", "()Z", "scopes", "getScopes$domain_productionRelease", "serviceKeyOrAppId", "getServiceKeyOrAppId$domain_productionRelease", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Params {
        private final String clientId;
        private final boolean isMiniProgram;
        private final String scopes;
        private final String serviceKeyOrAppId;

        public Params(String str, String str2, String str3, boolean z) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            this.serviceKeyOrAppId = str;
            this.scopes = str2;
            this.clientId = str3;
            this.isMiniProgram = z;
        }

        @JvmName(name = "getServiceKeyOrAppId$domain_productionRelease")
        /* renamed from: getServiceKeyOrAppId$domain_productionRelease  reason: from getter */
        public final String getServiceKeyOrAppId() {
            return this.serviceKeyOrAppId;
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

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\t\u001a\u00020\b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\r\u0010\u000eR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/domain/useragreement/interactor/GetEmptyUserInfo$UserInfo;", "", "", "", "incompleteUserData", "Ljava/util/Set;", "getIncompleteUserData", "()Ljava/util/Set;", "Lid/dana/domain/useragreement/interactor/GetEmptyUserInfo$Status;", "status", "Lid/dana/domain/useragreement/interactor/GetEmptyUserInfo$Status;", "getStatus", "()Lid/dana/domain/useragreement/interactor/GetEmptyUserInfo$Status;", "<init>", "(Lid/dana/domain/useragreement/interactor/GetEmptyUserInfo$Status;Ljava/util/Set;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class UserInfo {
        private final Set<String> incompleteUserData;
        private final Status status;

        public UserInfo(Status status, Set<String> set) {
            Intrinsics.checkNotNullParameter(status, "");
            Intrinsics.checkNotNullParameter(set, "");
            this.status = status;
            this.incompleteUserData = set;
        }

        @JvmName(name = "getStatus")
        public final Status getStatus() {
            return this.status;
        }

        @JvmName(name = "getIncompleteUserData")
        public final Set<String> getIncompleteUserData() {
            return this.incompleteUserData;
        }
    }
}
