package id.dana.domain.familyaccount;

import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.domain.familyaccount.model.ApproveSendMoneyRequest;
import id.dana.domain.familyaccount.model.ApproveSendMoneyResult;
import id.dana.domain.familyaccount.model.AvailableServicesConfig;
import id.dana.domain.familyaccount.model.ConsultFamilyAccountResult;
import id.dana.domain.familyaccount.model.CreateFamilyAccountResult;
import id.dana.domain.familyaccount.model.CreateOrderTopupRequest;
import id.dana.domain.familyaccount.model.CreateOrderTopupResult;
import id.dana.domain.familyaccount.model.DashboardFamilyAccountResult;
import id.dana.domain.familyaccount.model.InvitationDecisionInfo;
import id.dana.domain.familyaccount.model.InvitationDecisionRequestInfo;
import id.dana.domain.familyaccount.model.InviteMemberRequest;
import id.dana.domain.familyaccount.model.InviteMemberResult;
import id.dana.domain.familyaccount.model.MaxMemberLimitConfig;
import id.dana.domain.familyaccount.model.OrganizerSummaryRequest;
import id.dana.domain.familyaccount.model.QuestionnaireDataConfig;
import id.dana.domain.familyaccount.model.RejectSendMoneyRequest;
import id.dana.domain.familyaccount.model.RemoveFamilyAccountResult;
import id.dana.domain.familyaccount.model.RemoveFamilyMemberResult;
import id.dana.domain.familyaccount.model.SetLimitAndServicesRequest;
import id.dana.domain.familyaccount.model.SummaryResult;
import id.dana.domain.familyaccount.model.TopUpUserConsultResult;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H&J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0003H&J\u0014\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0003H&J\u0018\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u0019H&J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0003H&J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0003H&J\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00032\u0006\u0010 \u001a\u00020!H&J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u0003H&J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u0003H&J\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u00032\u0006\u0010(\u001a\u00020)H&JZ\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u00032\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00192\b\u0010/\u001a\u0004\u0018\u00010-2\b\u00100\u001a\u0004\u0018\u00010-2\b\u00101\u001a\u0004\u0018\u00010-2\b\u00102\u001a\u0004\u0018\u00010-2\b\u00103\u001a\u0004\u0018\u00010-2\b\u00104\u001a\u0004\u0018\u00010-H&J\u0016\u00105\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0016\u00106\u001a\b\u0012\u0004\u0012\u00020-0\u00032\u0006\u00107\u001a\u000208H&J\u0018\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u00032\b\u0010;\u001a\u0004\u0018\u00010-H&J\"\u0010<\u001a\b\u0012\u0004\u0012\u00020=0\u00032\b\u0010>\u001a\u0004\u0018\u00010-2\b\u0010;\u001a\u0004\u0018\u00010-H&J\u0016\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00190\u00032\u0006\u0010@\u001a\u00020AH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006BÀ\u0006\u0001"}, d2 = {"Lid/dana/domain/familyaccount/FamilyAccountRepository;", "", "acceptInvitation", "Lio/reactivex/Observable;", "Lid/dana/domain/familyaccount/model/InvitationDecisionInfo;", "requestInfo", "Lid/dana/domain/familyaccount/model/InvitationDecisionRequestInfo;", "activateCreateFamilyAccount", "Lid/dana/domain/familyaccount/model/CreateFamilyAccountResult;", "approveSendMoneyFamilyAccount", "Lid/dana/domain/familyaccount/model/ApproveSendMoneyResult;", "approveSendMoneyRequest", "Lid/dana/domain/familyaccount/model/ApproveSendMoneyRequest;", "createOrderTopUpFamilyBalance", "Lid/dana/domain/familyaccount/model/CreateOrderTopupResult;", "createOrderTopupRequest", "Lid/dana/domain/familyaccount/model/CreateOrderTopupRequest;", "dashboardFamilyAccount", "Lid/dana/domain/familyaccount/model/DashboardFamilyAccountResult;", "getAvailableServices", "", "Lid/dana/domain/familyaccount/model/AvailableServicesConfig;", "getConsultFamilyAccount", "Lid/dana/domain/familyaccount/model/ConsultFamilyAccountResult;", "withLimit", "", "getFamilyAccountMaxMember", "", "getMaxMemberLimit", "Lid/dana/domain/familyaccount/model/MaxMemberLimitConfig;", "getOrganizerSummary", "Lid/dana/domain/familyaccount/model/SummaryResult;", "organizerSummaryRequest", "Lid/dana/domain/familyaccount/model/OrganizerSummaryRequest;", "getQuestionnaireData", "Lid/dana/domain/familyaccount/model/QuestionnaireDataConfig;", "getTopUpUserConsult", "Lid/dana/domain/familyaccount/model/TopUpUserConsultResult;", "invite", "Lid/dana/domain/familyaccount/model/InviteMemberResult;", "inviteMemberRequest", "Lid/dana/domain/familyaccount/model/InviteMemberRequest;", "recordAgreement", "", "agreementKey", "", "userAgree", "agreementType", "organizerName", "organizerPhoneNumber", "memberPhoneNumber", "memberRelationship", "memberLocation", "rejectInvitation", "rejectSendMoneyFamilyAccount", "rejectSendMoneyRequest", "Lid/dana/domain/familyaccount/model/RejectSendMoneyRequest;", "removeFamilyAccount", "Lid/dana/domain/familyaccount/model/RemoveFamilyAccountResult;", BioUtilityBridge.SECURITY_ID, "removeFamilyMember", "Lid/dana/domain/familyaccount/model/RemoveFamilyMemberResult;", "invitationId", "setLimitAndServicesFamilyAccount", "setLimitAndServicesRequest", "Lid/dana/domain/familyaccount/model/SetLimitAndServicesRequest;", "domain_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface FamilyAccountRepository {
    Observable<InvitationDecisionInfo> acceptInvitation(InvitationDecisionRequestInfo requestInfo);

    Observable<CreateFamilyAccountResult> activateCreateFamilyAccount();

    Observable<ApproveSendMoneyResult> approveSendMoneyFamilyAccount(ApproveSendMoneyRequest approveSendMoneyRequest);

    Observable<CreateOrderTopupResult> createOrderTopUpFamilyBalance(CreateOrderTopupRequest createOrderTopupRequest);

    Observable<DashboardFamilyAccountResult> dashboardFamilyAccount();

    Observable<List<AvailableServicesConfig>> getAvailableServices();

    Observable<ConsultFamilyAccountResult> getConsultFamilyAccount(boolean withLimit);

    Observable<Integer> getFamilyAccountMaxMember();

    Observable<MaxMemberLimitConfig> getMaxMemberLimit();

    Observable<SummaryResult> getOrganizerSummary(OrganizerSummaryRequest organizerSummaryRequest);

    Observable<QuestionnaireDataConfig> getQuestionnaireData();

    Observable<TopUpUserConsultResult> getTopUpUserConsult();

    Observable<InviteMemberResult> invite(InviteMemberRequest inviteMemberRequest);

    Observable<Unit> recordAgreement(String agreementKey, boolean userAgree, String agreementType, String organizerName, String organizerPhoneNumber, String memberPhoneNumber, String memberRelationship, String memberLocation);

    Observable<InvitationDecisionInfo> rejectInvitation(InvitationDecisionRequestInfo requestInfo);

    Observable<String> rejectSendMoneyFamilyAccount(RejectSendMoneyRequest rejectSendMoneyRequest);

    Observable<RemoveFamilyAccountResult> removeFamilyAccount(String securityId);

    Observable<RemoveFamilyMemberResult> removeFamilyMember(String invitationId, String securityId);

    Observable<Boolean> setLimitAndServicesFamilyAccount(SetLimitAndServicesRequest setLimitAndServicesRequest);

    /* renamed from: id.dana.domain.familyaccount.FamilyAccountRepository$-CC  reason: invalid class name */
    /* loaded from: classes8.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ Observable getConsultFamilyAccount$default(FamilyAccountRepository familyAccountRepository, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                return familyAccountRepository.getConsultFamilyAccount(z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getConsultFamilyAccount");
        }
    }
}
