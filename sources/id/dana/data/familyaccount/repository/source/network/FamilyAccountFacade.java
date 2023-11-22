package id.dana.data.familyaccount.repository.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.familyaccount.model.request.ApproveSendMoneyRequestEntity;
import id.dana.data.familyaccount.model.request.CreateOrderTopUpRequestEntity;
import id.dana.data.familyaccount.model.request.InvitationDecisionRequestEntity;
import id.dana.data.familyaccount.model.request.InviteMembersRequestEntity;
import id.dana.data.familyaccount.model.request.OrganizerSummaryRequestEntity;
import id.dana.data.familyaccount.model.request.RejectSendMoneyRequestEntity;
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
import id.dana.data.userconsent.repository.source.network.RecordAgreementRequest;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\fH'¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H'¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u001bH'¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020\u001fH'¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020%2\u0006\u0010\u0003\u001a\u00020$H'¢\u0006\u0004\b&\u0010'J\u0017\u0010*\u001a\u00020)2\u0006\u0010\u0003\u001a\u00020(H'¢\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b,\u0010\u0006J\u0017\u0010/\u001a\u00020.2\u0006\u0010\u0003\u001a\u00020-H'¢\u0006\u0004\b/\u00100J\u0017\u00102\u001a\u0002012\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b2\u00103J\u0017\u00105\u001a\u0002042\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b5\u00106J\u0017\u00109\u001a\u00020)2\u0006\u00108\u001a\u000207H'¢\u0006\u0004\b9\u0010:ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/familyaccount/repository/source/network/FamilyAccountFacade;", "", "Lid/dana/data/familyaccount/model/request/InvitationDecisionRequestEntity;", "request", "Lid/dana/data/familyaccount/model/result/InvitationDecisionResultEntity;", "acceptInvitation", "(Lid/dana/data/familyaccount/model/request/InvitationDecisionRequestEntity;)Lid/dana/data/familyaccount/model/result/InvitationDecisionResultEntity;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "baseRpcRequest", "Lid/dana/data/familyaccount/model/result/CreateFamilyAccountEntity;", "activateCreateFamilyAccount", "(Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;)Lid/dana/data/familyaccount/model/result/CreateFamilyAccountEntity;", "Lid/dana/data/familyaccount/model/request/ApproveSendMoneyRequestEntity;", "Lid/dana/data/familyaccount/model/result/ApproveSendMoneyResultEntity;", "approveSendMoneyFamilyAccount", "(Lid/dana/data/familyaccount/model/request/ApproveSendMoneyRequestEntity;)Lid/dana/data/familyaccount/model/result/ApproveSendMoneyResultEntity;", "Lid/dana/data/familyaccount/model/result/ConsultFamilyAccountEntity;", "consultFamilyAccount", "(Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;)Lid/dana/data/familyaccount/model/result/ConsultFamilyAccountEntity;", "Lid/dana/data/familyaccount/model/request/CreateOrderTopUpRequestEntity;", "createOrderTopUpRequestEntity", "Lid/dana/data/familyaccount/model/result/CreateOrderTopUpResultEntity;", "createOrderTopupFamilyBalance", "(Lid/dana/data/familyaccount/model/request/CreateOrderTopUpRequestEntity;)Lid/dana/data/familyaccount/model/result/CreateOrderTopUpResultEntity;", "Lid/dana/data/familyaccount/model/result/DashboardFamilyAccountEntity;", "dashboardFamilyAccount", "(Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;)Lid/dana/data/familyaccount/model/result/DashboardFamilyAccountEntity;", "Lid/dana/data/familyaccount/model/request/OrganizerSummaryRequestEntity;", "Lid/dana/data/familyaccount/model/result/SummaryResultEntity;", "getOrganizerSummary", "(Lid/dana/data/familyaccount/model/request/OrganizerSummaryRequestEntity;)Lid/dana/data/familyaccount/model/result/SummaryResultEntity;", "Lid/dana/data/familyaccount/model/request/TopUpUserConsultRequestEntity;", "topUpUserConsultRequestEntity", "Lid/dana/data/familyaccount/model/result/TopUpUserConsultResultEntity;", "getTopUpUserConsult", "(Lid/dana/data/familyaccount/model/request/TopUpUserConsultRequestEntity;)Lid/dana/data/familyaccount/model/result/TopUpUserConsultResultEntity;", "Lid/dana/data/familyaccount/model/request/InviteMembersRequestEntity;", "Lid/dana/data/familyaccount/model/result/InviteMembersResultEntity;", "invite", "(Lid/dana/data/familyaccount/model/request/InviteMembersRequestEntity;)Lid/dana/data/familyaccount/model/result/InviteMembersResultEntity;", "Lid/dana/data/userconsent/repository/source/network/RecordAgreementRequest;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "recordAgreement", "(Lid/dana/data/userconsent/repository/source/network/RecordAgreementRequest;)Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "rejectInvitation", "Lid/dana/data/familyaccount/model/request/RejectSendMoneyRequestEntity;", "Lid/dana/data/familyaccount/model/result/RejectSendMoneyResultEntity;", "rejectSendMoneyFamilyAccount", "(Lid/dana/data/familyaccount/model/request/RejectSendMoneyRequestEntity;)Lid/dana/data/familyaccount/model/result/RejectSendMoneyResultEntity;", "Lid/dana/data/familyaccount/model/result/RemoveFamilyAccountEntity;", "removeFamilyAccount", "(Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;)Lid/dana/data/familyaccount/model/result/RemoveFamilyAccountEntity;", "Lid/dana/data/familyaccount/model/result/RemoveFamilyMemberEntity;", "removeFamilyMember", "(Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;)Lid/dana/data/familyaccount/model/result/RemoveFamilyMemberEntity;", "Lid/dana/data/familyaccount/model/request/SetLimitAndServicesEntity;", "setLimitAndServicesEntity", "setLimitFamilyAccount", "(Lid/dana/data/familyaccount/model/request/SetLimitAndServicesEntity;)Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface FamilyAccountFacade {
    @OperationType("alipayplus.mobilewallet.familyaccount.acceptinvitation")
    @SignCheck
    InvitationDecisionResultEntity acceptInvitation(InvitationDecisionRequestEntity request);

    @OperationType("alipayplus.mobilewallet.familyaccount.createaccount")
    @SignCheck
    CreateFamilyAccountEntity activateCreateFamilyAccount(BaseRpcRequest baseRpcRequest);

    @OperationType("alipayplus.mobilewallet.biztransfer.approve")
    @SignCheck
    ApproveSendMoneyResultEntity approveSendMoneyFamilyAccount(ApproveSendMoneyRequestEntity request);

    @OperationType("alipayplus.mobilewallet.familyaccount.consult")
    @SignCheck
    ConsultFamilyAccountEntity consultFamilyAccount(BaseRpcRequest baseRpcRequest);

    @OperationType("alipayplus.mobilewallet.fund.topup.createOrder")
    @SignCheck
    CreateOrderTopUpResultEntity createOrderTopupFamilyBalance(CreateOrderTopUpRequestEntity createOrderTopUpRequestEntity);

    @OperationType("alipayplus.mobilewallet.familyaccount.dashboard")
    @SignCheck
    DashboardFamilyAccountEntity dashboardFamilyAccount(BaseRpcRequest baseRpcRequest);

    @OperationType("alipayplus.mobilewallet.biztransfer.summary")
    @SignCheck
    SummaryResultEntity getOrganizerSummary(OrganizerSummaryRequestEntity request);

    @OperationType("alipayplus.mobilewallet.fund.topup.userConsult")
    @SignCheck
    TopUpUserConsultResultEntity getTopUpUserConsult(TopUpUserConsultRequestEntity topUpUserConsultRequestEntity);

    @OperationType("alipayplus.mobilewallet.familyaccount.invite")
    @SignCheck
    InviteMembersResultEntity invite(InviteMembersRequestEntity request);

    @OperationType("dana.mobilewallet.agreementcenter.record")
    @SignCheck
    BaseRpcResult recordAgreement(RecordAgreementRequest request);

    @OperationType("alipayplus.mobilewallet.familyaccount.rejectinvitation")
    @SignCheck
    InvitationDecisionResultEntity rejectInvitation(InvitationDecisionRequestEntity request);

    @OperationType("alipayplus.mobilewallet.biztransfer.reject")
    @SignCheck
    RejectSendMoneyResultEntity rejectSendMoneyFamilyAccount(RejectSendMoneyRequestEntity request);

    @OperationType("alipayplus.mobilewallet.familyaccount.remove")
    @SignCheck
    RemoveFamilyAccountEntity removeFamilyAccount(BaseRpcRequest baseRpcRequest);

    @OperationType("alipayplus.mobilewallet.familyaccount.removemember")
    @SignCheck
    RemoveFamilyMemberEntity removeFamilyMember(BaseRpcRequest baseRpcRequest);

    @OperationType("alipayplus.mobilewallet.familyaccount.setlimit")
    @SignCheck
    BaseRpcResult setLimitFamilyAccount(SetLimitAndServicesEntity setLimitAndServicesEntity);
}
