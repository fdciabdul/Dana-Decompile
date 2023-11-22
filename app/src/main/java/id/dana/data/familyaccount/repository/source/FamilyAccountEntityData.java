package id.dana.data.familyaccount.repository.source;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.familyaccount.model.request.ApproveSendMoneyRequestEntity;
import id.dana.data.familyaccount.model.request.CreateOrderTopUpRequestEntity;
import id.dana.data.familyaccount.model.request.InvitationDecisionRequestEntity;
import id.dana.data.familyaccount.model.request.InviteMembersRequestEntity;
import id.dana.data.familyaccount.model.request.OrganizerSummaryRequestEntity;
import id.dana.data.familyaccount.model.request.RejectSendMoneyRequestEntity;
import id.dana.data.familyaccount.model.request.RemoveFamilyAccountRequestEntity;
import id.dana.data.familyaccount.model.request.RemoveFamilyMemberRequestEntity;
import id.dana.data.familyaccount.model.request.SetLimitAndServicesEntity;
import id.dana.data.familyaccount.model.request.TopUpUserConsultRequestEntity;
import id.dana.data.familyaccount.model.result.ApproveSendMoneyResultEntity;
import id.dana.data.familyaccount.model.result.ConsultFamilyAccountEntity;
import id.dana.data.familyaccount.model.result.CreateFamilyAccountEntity;
import id.dana.data.familyaccount.model.result.CreateOrderTopUpResultEntity;
import id.dana.data.familyaccount.model.result.DashboardFamilyAccountEntity;
import id.dana.data.familyaccount.model.result.InvitationDecisionResultEntity;
import id.dana.data.familyaccount.model.result.InviteMembersResultEntity;
import id.dana.data.familyaccount.model.result.RejectSendMoneyResultEntity;
import id.dana.data.familyaccount.model.result.RemoveFamilyAccountEntity;
import id.dana.data.familyaccount.model.result.RemoveFamilyMemberEntity;
import id.dana.data.familyaccount.model.result.SummaryResultEntity;
import id.dana.data.familyaccount.model.result.TopUpUserConsultResultEntity;
import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H&J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u0014H&J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0003H&J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00032\u0006\u0010\u0019\u001a\u00020\u001aH&J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00032\u0006\u0010\u001d\u001a\u00020\u001eH&J\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00032\u0006\u0010!\u001a\u00020\"H&JZ\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u00032\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00142\b\u0010(\u001a\u0004\u0018\u00010&2\b\u0010)\u001a\u0004\u0018\u00010&2\b\u0010*\u001a\u0004\u0018\u00010&2\b\u0010+\u001a\u0004\u0018\u00010&2\b\u0010,\u001a\u0004\u0018\u00010&2\b\u0010-\u001a\u0004\u0018\u00010&H&J\u0016\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0016\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u00032\u0006\u00101\u001a\u000202H&J\u0016\u00103\u001a\b\u0012\u0004\u0012\u0002040\u00032\u0006\u00105\u001a\u000206H&J\u0016\u00107\u001a\b\u0012\u0004\u0012\u0002080\u00032\u0006\u00109\u001a\u00020:H&J\u0016\u0010;\u001a\b\u0012\u0004\u0012\u00020$0\u00032\u0006\u0010<\u001a\u00020=H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006>À\u0006\u0001"}, d2 = {"Lid/dana/data/familyaccount/repository/source/FamilyAccountEntityData;", "", "acceptInvitation", "Lio/reactivex/Observable;", "Lid/dana/data/familyaccount/model/result/InvitationDecisionResultEntity;", "requestEntity", "Lid/dana/data/familyaccount/model/request/InvitationDecisionRequestEntity;", "activateCreateFamilyAccount", "Lid/dana/data/familyaccount/model/result/CreateFamilyAccountEntity;", "approveSendMoneyFamilyAccount", "Lid/dana/data/familyaccount/model/result/ApproveSendMoneyResultEntity;", "approveSendMoneyRequestEntity", "Lid/dana/data/familyaccount/model/request/ApproveSendMoneyRequestEntity;", "createOrderTopupFamilyBalance", "Lid/dana/data/familyaccount/model/result/CreateOrderTopUpResultEntity;", "createOrderTopUpRequestEntity", "Lid/dana/data/familyaccount/model/request/CreateOrderTopUpRequestEntity;", "getConsultFamilyAccount", "Lid/dana/data/familyaccount/model/result/ConsultFamilyAccountEntity;", "withLimit", "", "getDashboardFamiyAccount", "Lid/dana/data/familyaccount/model/result/DashboardFamilyAccountEntity;", "getOrganizerSummary", "Lid/dana/data/familyaccount/model/result/SummaryResultEntity;", "organizerSummaryRequestEntity", "Lid/dana/data/familyaccount/model/request/OrganizerSummaryRequestEntity;", "getTopUpUserConsult", "Lid/dana/data/familyaccount/model/result/TopUpUserConsultResultEntity;", "topUpUserConsultRequestEntity", "Lid/dana/data/familyaccount/model/request/TopUpUserConsultRequestEntity;", "invite", "Lid/dana/data/familyaccount/model/result/InviteMembersResultEntity;", "inviteMembersRequestEntity", "Lid/dana/data/familyaccount/model/request/InviteMembersRequestEntity;", "recordAgreement", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "agreementKey", "", "userAgree", "agreementType", "organizerName", "organizerPhoneNumber", "memberPhoneNumber", "memberRelationship", "memberLocation", "rejectInvitation", "rejectSendMoneyFamilyAccount", "Lid/dana/data/familyaccount/model/result/RejectSendMoneyResultEntity;", "rejectSendMoneyRequestEntity", "Lid/dana/data/familyaccount/model/request/RejectSendMoneyRequestEntity;", "removeFamilyAccount", "Lid/dana/data/familyaccount/model/result/RemoveFamilyAccountEntity;", "removeFamilyAccountRequestEntity", "Lid/dana/data/familyaccount/model/request/RemoveFamilyAccountRequestEntity;", "removeFamilyMember", "Lid/dana/data/familyaccount/model/result/RemoveFamilyMemberEntity;", "removeFamilyMemberEntity", "Lid/dana/data/familyaccount/model/request/RemoveFamilyMemberRequestEntity;", "setLimitAndServicesFamilyAccount", "setLimitAndServicesEntity", "Lid/dana/data/familyaccount/model/request/SetLimitAndServicesEntity;", "data_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface FamilyAccountEntityData {
    Observable<InvitationDecisionResultEntity> acceptInvitation(InvitationDecisionRequestEntity requestEntity);

    Observable<CreateFamilyAccountEntity> activateCreateFamilyAccount();

    Observable<ApproveSendMoneyResultEntity> approveSendMoneyFamilyAccount(ApproveSendMoneyRequestEntity approveSendMoneyRequestEntity);

    Observable<CreateOrderTopUpResultEntity> createOrderTopupFamilyBalance(CreateOrderTopUpRequestEntity createOrderTopUpRequestEntity);

    Observable<ConsultFamilyAccountEntity> getConsultFamilyAccount(boolean withLimit);

    Observable<DashboardFamilyAccountEntity> getDashboardFamiyAccount();

    Observable<SummaryResultEntity> getOrganizerSummary(OrganizerSummaryRequestEntity organizerSummaryRequestEntity);

    Observable<TopUpUserConsultResultEntity> getTopUpUserConsult(TopUpUserConsultRequestEntity topUpUserConsultRequestEntity);

    Observable<InviteMembersResultEntity> invite(InviteMembersRequestEntity inviteMembersRequestEntity);

    Observable<BaseRpcResult> recordAgreement(String agreementKey, boolean userAgree, String agreementType, String organizerName, String organizerPhoneNumber, String memberPhoneNumber, String memberRelationship, String memberLocation);

    Observable<InvitationDecisionResultEntity> rejectInvitation(InvitationDecisionRequestEntity requestEntity);

    Observable<RejectSendMoneyResultEntity> rejectSendMoneyFamilyAccount(RejectSendMoneyRequestEntity rejectSendMoneyRequestEntity);

    Observable<RemoveFamilyAccountEntity> removeFamilyAccount(RemoveFamilyAccountRequestEntity removeFamilyAccountRequestEntity);

    Observable<RemoveFamilyMemberEntity> removeFamilyMember(RemoveFamilyMemberRequestEntity removeFamilyMemberEntity);

    Observable<BaseRpcResult> setLimitAndServicesFamilyAccount(SetLimitAndServicesEntity setLimitAndServicesEntity);

    /* renamed from: id.dana.data.familyaccount.repository.source.FamilyAccountEntityData$-CC */
    /* loaded from: classes8.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ Observable getConsultFamilyAccount$default(FamilyAccountEntityData familyAccountEntityData, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                return familyAccountEntityData.getConsultFamilyAccount(z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getConsultFamilyAccount");
        }
    }
}
