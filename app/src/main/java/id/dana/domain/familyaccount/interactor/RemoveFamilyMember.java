package id.dana.domain.familyaccount.interactor;

import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.familyaccount.FamilyAccountRepository;
import id.dana.domain.familyaccount.model.RemoveFamilyMemberResult;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/familyaccount/interactor/RemoveFamilyMember;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/familyaccount/model/RemoveFamilyMemberResult;", "Lid/dana/domain/familyaccount/interactor/RemoveFamilyMember$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/familyaccount/interactor/RemoveFamilyMember$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/familyaccount/FamilyAccountRepository;", "familyAccountRepository", "Lid/dana/domain/familyaccount/FamilyAccountRepository;", "<init>", "(Lid/dana/domain/familyaccount/FamilyAccountRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RemoveFamilyMember extends BaseUseCase<RemoveFamilyMemberResult, Params> {
    private final FamilyAccountRepository familyAccountRepository;

    @Inject
    public RemoveFamilyMember(FamilyAccountRepository familyAccountRepository) {
        Intrinsics.checkNotNullParameter(familyAccountRepository, "");
        this.familyAccountRepository = familyAccountRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<RemoveFamilyMemberResult> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.familyAccountRepository.removeFamilyMember(params.getInvitationId(), params.getSecurityId());
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\u00020\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006"}, d2 = {"Lid/dana/domain/familyaccount/interactor/RemoveFamilyMember$Params;", "", "", "invitationId", "Ljava/lang/String;", "getInvitationId$domain_productionRelease", "()Ljava/lang/String;", BioUtilityBridge.SECURITY_ID, "getSecurityId$domain_productionRelease", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {
        private final String invitationId;
        private final String securityId;

        public Params(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            this.securityId = str;
            this.invitationId = str2;
        }

        @JvmName(name = "getSecurityId$domain_productionRelease")
        /* renamed from: getSecurityId$domain_productionRelease  reason: from getter */
        public final String getSecurityId() {
            return this.securityId;
        }

        @JvmName(name = "getInvitationId$domain_productionRelease")
        /* renamed from: getInvitationId$domain_productionRelease  reason: from getter */
        public final String getInvitationId() {
            return this.invitationId;
        }
    }
}
