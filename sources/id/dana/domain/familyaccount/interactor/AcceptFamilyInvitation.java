package id.dana.domain.familyaccount.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.familyaccount.FamilyAccountRepository;
import id.dana.domain.familyaccount.model.InvitationDecisionInfo;
import id.dana.domain.familyaccount.model.InvitationDecisionRequestInfo;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/familyaccount/interactor/AcceptFamilyInvitation;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/familyaccount/model/InvitationDecisionInfo;", "Lid/dana/domain/familyaccount/interactor/AcceptFamilyInvitation$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/familyaccount/interactor/AcceptFamilyInvitation$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/familyaccount/FamilyAccountRepository;", "familyAccountRepository", "Lid/dana/domain/familyaccount/FamilyAccountRepository;", "<init>", "(Lid/dana/domain/familyaccount/FamilyAccountRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AcceptFamilyInvitation extends BaseUseCase<InvitationDecisionInfo, Params> {
    private final FamilyAccountRepository familyAccountRepository;

    @Inject
    public AcceptFamilyInvitation(FamilyAccountRepository familyAccountRepository) {
        Intrinsics.checkNotNullParameter(familyAccountRepository, "");
        this.familyAccountRepository = familyAccountRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<InvitationDecisionInfo> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.familyAccountRepository.acceptInvitation(params.getRequest());
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/familyaccount/interactor/AcceptFamilyInvitation$Params;", "", "Lid/dana/domain/familyaccount/model/InvitationDecisionRequestInfo;", "request", "Lid/dana/domain/familyaccount/model/InvitationDecisionRequestInfo;", "getRequest$domain_productionRelease", "()Lid/dana/domain/familyaccount/model/InvitationDecisionRequestInfo;", "<init>", "(Lid/dana/domain/familyaccount/model/InvitationDecisionRequestInfo;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final InvitationDecisionRequestInfo request;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/familyaccount/interactor/AcceptFamilyInvitation$Params$Companion;", "", "Lid/dana/domain/familyaccount/model/InvitationDecisionRequestInfo;", "request", "Lid/dana/domain/familyaccount/interactor/AcceptFamilyInvitation$Params;", "createInvitationRequest", "(Lid/dana/domain/familyaccount/model/InvitationDecisionRequestInfo;)Lid/dana/domain/familyaccount/interactor/AcceptFamilyInvitation$Params;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Params createInvitationRequest(InvitationDecisionRequestInfo request) {
                Intrinsics.checkNotNullParameter(request, "");
                return new Params(request);
            }
        }

        public Params(InvitationDecisionRequestInfo invitationDecisionRequestInfo) {
            Intrinsics.checkNotNullParameter(invitationDecisionRequestInfo, "");
            this.request = invitationDecisionRequestInfo;
        }

        @JvmName(name = "getRequest$domain_productionRelease")
        /* renamed from: getRequest$domain_productionRelease  reason: from getter */
        public final InvitationDecisionRequestInfo getRequest() {
            return this.request;
        }
    }
}
