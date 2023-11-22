package id.dana.data.familyaccount.mapper;

import id.dana.data.familyaccount.model.request.ApproveSendMoneyRequestEntity;
import id.dana.data.familyaccount.model.request.CreateOrderTopUpRequestEntity;
import id.dana.data.familyaccount.model.request.InvitationDecisionRequestEntity;
import id.dana.data.familyaccount.model.request.InviteMembersRequestEntity;
import id.dana.data.familyaccount.model.request.OrganizerSummaryRequestEntity;
import id.dana.data.familyaccount.model.request.RejectSendMoneyRequestEntity;
import id.dana.data.familyaccount.model.request.SetLimitAndServicesEntity;
import id.dana.data.familyaccount.model.result.ApproveSendMoneyResultEntity;
import id.dana.data.familyaccount.model.result.AttributesResultEntity;
import id.dana.data.familyaccount.model.result.AttributesResultEntityKt;
import id.dana.data.familyaccount.model.result.AvailableServicesConfigEntity;
import id.dana.data.familyaccount.model.result.ConsultFamilyAccountEntity;
import id.dana.data.familyaccount.model.result.CreateFamilyAccountEntity;
import id.dana.data.familyaccount.model.result.CreateOrderTopUpResultEntity;
import id.dana.data.familyaccount.model.result.InvitationDecisionResultEntity;
import id.dana.data.familyaccount.model.result.InviteMembersResultEntity;
import id.dana.data.familyaccount.model.result.LimitInfoEntity;
import id.dana.data.familyaccount.model.result.MaxMemberLimitConfigEntity;
import id.dana.data.familyaccount.model.result.PayeeUserInfoEntity;
import id.dana.data.familyaccount.model.result.PayerUserInfoEntity;
import id.dana.data.familyaccount.model.result.QuestionnaireDataConfigEntity;
import id.dana.data.familyaccount.model.result.RemoveFamilyAccountEntity;
import id.dana.data.familyaccount.model.result.RemoveFamilyMemberEntity;
import id.dana.data.familyaccount.model.result.SecurityContextEntityKt;
import id.dana.data.familyaccount.model.result.SummaryResultEntity;
import id.dana.data.familyaccount.model.result.TopUpUserConsultResultEntity;
import id.dana.data.nearbyme.model.MoneyViewEntityMapperKt;
import id.dana.domain.auth.face.result.VerificationMethodInfo;
import id.dana.domain.familyaccount.model.ApproveSendMoneyRequest;
import id.dana.domain.familyaccount.model.ApproveSendMoneyResult;
import id.dana.domain.familyaccount.model.AttributesResult;
import id.dana.domain.familyaccount.model.AvailableServicesConfig;
import id.dana.domain.familyaccount.model.ConsultFamilyAccountResult;
import id.dana.domain.familyaccount.model.CreateFamilyAccountResult;
import id.dana.domain.familyaccount.model.CreateOrderTopupRequest;
import id.dana.domain.familyaccount.model.CreateOrderTopupResult;
import id.dana.domain.familyaccount.model.InvitationDecisionInfo;
import id.dana.domain.familyaccount.model.InvitationDecisionRequestInfo;
import id.dana.domain.familyaccount.model.InviteMemberRequest;
import id.dana.domain.familyaccount.model.InviteMemberResult;
import id.dana.domain.familyaccount.model.MaxMemberLimitConfig;
import id.dana.domain.familyaccount.model.OrganizerSummaryRequest;
import id.dana.domain.familyaccount.model.PayeeUserInfo;
import id.dana.domain.familyaccount.model.PayerUserInfo;
import id.dana.domain.familyaccount.model.QuestionnaireDataConfig;
import id.dana.domain.familyaccount.model.RejectSendMoneyRequest;
import id.dana.domain.familyaccount.model.RemoveFamilyAccountResult;
import id.dana.domain.familyaccount.model.RemoveFamilyMemberResult;
import id.dana.domain.familyaccount.model.SetLimitAndServicesRequest;
import id.dana.domain.familyaccount.model.SummaryResult;
import id.dana.domain.familyaccount.model.TopUpUserConsultResult;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.domain.payasset.model.PayMethodView;
import id.dana.network.response.authface.VerificationMethodInfoEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000¢\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\n\u001a\u00020\t*\u00020\b¢\u0006\u0004\b\n\u0010\u000b\u001a\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\f*\b\u0012\u0004\u0012\u00020\b0\f¢\u0006\u0004\b\r\u0010\u000e\u001a\u0011\u0010\u0011\u001a\u00020\u0010*\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0011\u0010\u0015\u001a\u00020\u0014*\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0011\u0010\u0019\u001a\u00020\u0018*\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0011\u0010\u001d\u001a\u00020\u001c*\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u0011\u0010!\u001a\u00020 *\u00020\u001f¢\u0006\u0004\b!\u0010\"\u001a\u0011\u0010%\u001a\u00020$*\u00020#¢\u0006\u0004\b%\u0010&\u001a\u0011\u0010)\u001a\u00020(*\u00020'¢\u0006\u0004\b)\u0010*\u001a\u0011\u0010-\u001a\u00020,*\u00020+¢\u0006\u0004\b-\u0010.\u001a\u0011\u00101\u001a\u000200*\u00020/¢\u0006\u0004\b1\u00102\u001a\u0011\u00105\u001a\u000204*\u000203¢\u0006\u0004\b5\u00106\u001a\u0011\u00109\u001a\u000208*\u000207¢\u0006\u0004\b9\u0010:\u001a\u0011\u0010=\u001a\u00020<*\u00020;¢\u0006\u0004\b=\u0010>\u001a\u0011\u0010A\u001a\u00020@*\u00020?¢\u0006\u0004\bA\u0010B\u001a\u0011\u0010E\u001a\u00020D*\u00020C¢\u0006\u0004\bE\u0010F\u001a\u0011\u0010I\u001a\u00020H*\u00020G¢\u0006\u0004\bI\u0010J\u001a\u0011\u0010M\u001a\u00020L*\u00020K¢\u0006\u0004\bM\u0010N\u001a\u0011\u0010Q\u001a\u00020P*\u00020O¢\u0006\u0004\bQ\u0010R\u001a\u0011\u0010U\u001a\u00020T*\u00020S¢\u0006\u0004\bU\u0010V\u001a!\u0010[\u001a\u00020Z*\u00020W2\u000e\u0010Y\u001a\n\u0012\u0004\u0012\u00020X\u0018\u00010\f¢\u0006\u0004\b[\u0010\\\u001a\u0013\u0010_\u001a\u00020^*\u00020]H\u0002¢\u0006\u0004\b_\u0010`\u001a\u001d\u0010a\u001a\b\u0012\u0004\u0012\u00020^0\f*\b\u0012\u0004\u0012\u00020]0\f¢\u0006\u0004\ba\u0010\u000e"}, d2 = {"Lid/dana/domain/familyaccount/model/ApproveSendMoneyRequest;", "Lid/dana/data/familyaccount/model/request/ApproveSendMoneyRequestEntity;", "toApproveSendMoneyRequestEntity", "(Lid/dana/domain/familyaccount/model/ApproveSendMoneyRequest;)Lid/dana/data/familyaccount/model/request/ApproveSendMoneyRequestEntity;", "Lid/dana/data/familyaccount/model/result/ApproveSendMoneyResultEntity;", "Lid/dana/domain/familyaccount/model/ApproveSendMoneyResult;", "toApproveSendMoneyResult", "(Lid/dana/data/familyaccount/model/result/ApproveSendMoneyResultEntity;)Lid/dana/domain/familyaccount/model/ApproveSendMoneyResult;", "Lid/dana/data/familyaccount/model/result/AvailableServicesConfigEntity;", "Lid/dana/domain/familyaccount/model/AvailableServicesConfig;", "toAvailableServiceConfig", "(Lid/dana/data/familyaccount/model/result/AvailableServicesConfigEntity;)Lid/dana/domain/familyaccount/model/AvailableServicesConfig;", "", "toAvailableServicesConfigList", "(Ljava/util/List;)Ljava/util/List;", "Lid/dana/data/familyaccount/model/result/ConsultFamilyAccountEntity;", "Lid/dana/domain/familyaccount/model/ConsultFamilyAccountResult;", "toConsultFamilyAccountResult", "(Lid/dana/data/familyaccount/model/result/ConsultFamilyAccountEntity;)Lid/dana/domain/familyaccount/model/ConsultFamilyAccountResult;", "Lid/dana/domain/familyaccount/model/CreateOrderTopupRequest;", "Lid/dana/data/familyaccount/model/request/CreateOrderTopUpRequestEntity;", "toCreataOrderTopUpRequestEntity", "(Lid/dana/domain/familyaccount/model/CreateOrderTopupRequest;)Lid/dana/data/familyaccount/model/request/CreateOrderTopUpRequestEntity;", "Lid/dana/data/familyaccount/model/result/CreateFamilyAccountEntity;", "Lid/dana/domain/familyaccount/model/CreateFamilyAccountResult;", "toCreateFamilyAccountResult", "(Lid/dana/data/familyaccount/model/result/CreateFamilyAccountEntity;)Lid/dana/domain/familyaccount/model/CreateFamilyAccountResult;", "Lid/dana/data/familyaccount/model/result/CreateOrderTopUpResultEntity;", "Lid/dana/domain/familyaccount/model/CreateOrderTopupResult;", "toCreateOrderTopUpResult", "(Lid/dana/data/familyaccount/model/result/CreateOrderTopUpResultEntity;)Lid/dana/domain/familyaccount/model/CreateOrderTopupResult;", "Lid/dana/data/familyaccount/model/result/InvitationDecisionResultEntity;", "Lid/dana/domain/familyaccount/model/InvitationDecisionInfo;", "toInvitationDecisionInfo", "(Lid/dana/data/familyaccount/model/result/InvitationDecisionResultEntity;)Lid/dana/domain/familyaccount/model/InvitationDecisionInfo;", "Lid/dana/domain/familyaccount/model/InvitationDecisionRequestInfo;", "Lid/dana/data/familyaccount/model/request/InvitationDecisionRequestEntity;", "toInvitationDecisionRequestEntity", "(Lid/dana/domain/familyaccount/model/InvitationDecisionRequestInfo;)Lid/dana/data/familyaccount/model/request/InvitationDecisionRequestEntity;", "Lid/dana/domain/familyaccount/model/InviteMemberRequest;", "Lid/dana/data/familyaccount/model/request/InviteMembersRequestEntity;", "toInviteMemberRequestEntity", "(Lid/dana/domain/familyaccount/model/InviteMemberRequest;)Lid/dana/data/familyaccount/model/request/InviteMembersRequestEntity;", "Lid/dana/data/familyaccount/model/result/InviteMembersResultEntity;", "Lid/dana/domain/familyaccount/model/InviteMemberResult;", "toInviteMemberResult", "(Lid/dana/data/familyaccount/model/result/InviteMembersResultEntity;)Lid/dana/domain/familyaccount/model/InviteMemberResult;", "Lid/dana/data/familyaccount/model/result/MaxMemberLimitConfigEntity;", "Lid/dana/domain/familyaccount/model/MaxMemberLimitConfig;", "toMaxMemberLimitConfig", "(Lid/dana/data/familyaccount/model/result/MaxMemberLimitConfigEntity;)Lid/dana/domain/familyaccount/model/MaxMemberLimitConfig;", "Lid/dana/domain/familyaccount/model/OrganizerSummaryRequest;", "Lid/dana/data/familyaccount/model/request/OrganizerSummaryRequestEntity;", "toOrganizerSummaryRequestEntity", "(Lid/dana/domain/familyaccount/model/OrganizerSummaryRequest;)Lid/dana/data/familyaccount/model/request/OrganizerSummaryRequestEntity;", "Lid/dana/data/familyaccount/model/result/PayeeUserInfoEntity;", "Lid/dana/domain/familyaccount/model/PayeeUserInfo;", "toPayeeUserInfo", "(Lid/dana/data/familyaccount/model/result/PayeeUserInfoEntity;)Lid/dana/domain/familyaccount/model/PayeeUserInfo;", "Lid/dana/data/familyaccount/model/result/PayerUserInfoEntity;", "Lid/dana/domain/familyaccount/model/PayerUserInfo;", "toPayerUserInfo", "(Lid/dana/data/familyaccount/model/result/PayerUserInfoEntity;)Lid/dana/domain/familyaccount/model/PayerUserInfo;", "Lid/dana/data/familyaccount/model/result/QuestionnaireDataConfigEntity;", "Lid/dana/domain/familyaccount/model/QuestionnaireDataConfig;", "toQuestionnaireDataConfig", "(Lid/dana/data/familyaccount/model/result/QuestionnaireDataConfigEntity;)Lid/dana/domain/familyaccount/model/QuestionnaireDataConfig;", "Lid/dana/domain/familyaccount/model/RejectSendMoneyRequest;", "Lid/dana/data/familyaccount/model/request/RejectSendMoneyRequestEntity;", "toRejectSendMoneyRequestEntity", "(Lid/dana/domain/familyaccount/model/RejectSendMoneyRequest;)Lid/dana/data/familyaccount/model/request/RejectSendMoneyRequestEntity;", "Lid/dana/data/familyaccount/model/result/RemoveFamilyAccountEntity;", "Lid/dana/domain/familyaccount/model/RemoveFamilyAccountResult;", "toRemoveFamilyAccountResult", "(Lid/dana/data/familyaccount/model/result/RemoveFamilyAccountEntity;)Lid/dana/domain/familyaccount/model/RemoveFamilyAccountResult;", "Lid/dana/data/familyaccount/model/result/RemoveFamilyMemberEntity;", "Lid/dana/domain/familyaccount/model/RemoveFamilyMemberResult;", "toRemoveFamilyMemberResult", "(Lid/dana/data/familyaccount/model/result/RemoveFamilyMemberEntity;)Lid/dana/domain/familyaccount/model/RemoveFamilyMemberResult;", "Lid/dana/domain/familyaccount/model/SetLimitAndServicesRequest;", "Lid/dana/data/familyaccount/model/request/SetLimitAndServicesEntity;", "toSetLimitAndServicesEntity", "(Lid/dana/domain/familyaccount/model/SetLimitAndServicesRequest;)Lid/dana/data/familyaccount/model/request/SetLimitAndServicesEntity;", "Lid/dana/data/familyaccount/model/result/SummaryResultEntity;", "Lid/dana/domain/familyaccount/model/SummaryResult;", "toSummaryResult", "(Lid/dana/data/familyaccount/model/result/SummaryResultEntity;)Lid/dana/domain/familyaccount/model/SummaryResult;", "Lid/dana/data/familyaccount/model/result/TopUpUserConsultResultEntity;", "Lid/dana/domain/payasset/model/PayMethodView;", "payMethodView", "Lid/dana/domain/familyaccount/model/TopUpUserConsultResult;", "toTopUpUserConsultResult", "(Lid/dana/data/familyaccount/model/result/TopUpUserConsultResultEntity;Ljava/util/List;)Lid/dana/domain/familyaccount/model/TopUpUserConsultResult;", "Lid/dana/network/response/authface/VerificationMethodInfoEntity;", "Lid/dana/domain/auth/face/result/VerificationMethodInfo;", "toVerificationMethodInfo", "(Lid/dana/network/response/authface/VerificationMethodInfoEntity;)Lid/dana/domain/auth/face/result/VerificationMethodInfo;", "toVerificationMethodInfoList"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FamilyAccountMapperKt {
    public static final InviteMembersRequestEntity toInviteMemberRequestEntity(InviteMemberRequest inviteMemberRequest) {
        Intrinsics.checkNotNullParameter(inviteMemberRequest, "");
        boolean consult = inviteMemberRequest.getConsult();
        boolean resendInvitation = inviteMemberRequest.getResendInvitation();
        return new InviteMembersRequestEntity(Boolean.valueOf(consult), Boolean.valueOf(resendInvitation), inviteMemberRequest.getPhoneNumber(), inviteMemberRequest.getRelation(), inviteMemberRequest.getAddress(), inviteMemberRequest.getSecurityId(), inviteMemberRequest.getValidateData());
    }

    public static final InviteMemberResult toInviteMemberResult(InviteMembersResultEntity inviteMembersResultEntity) {
        Intrinsics.checkNotNullParameter(inviteMembersResultEntity, "");
        String invitationId = inviteMembersResultEntity.getInvitationId();
        String str = invitationId == null ? "" : invitationId;
        boolean areEqual = Intrinsics.areEqual(inviteMembersResultEntity.getUserInvited(), Boolean.TRUE);
        List<VerificationMethodInfoEntity> verificationMethodInfoList = inviteMembersResultEntity.getVerificationMethodInfoList();
        if (verificationMethodInfoList == null) {
            verificationMethodInfoList = CollectionsKt.emptyList();
        }
        List<VerificationMethodInfo> verificationMethodInfoList2 = toVerificationMethodInfoList(verificationMethodInfoList);
        String securityId = inviteMembersResultEntity.getSecurityId();
        return new InviteMemberResult(str, areEqual, verificationMethodInfoList2, securityId == null ? "" : securityId, SecurityContextEntityKt.toSecurityContext(SecurityContextEntityKt.toSecurityContextEntity(inviteMembersResultEntity.getSecurityContext())));
    }

    public static final ConsultFamilyAccountResult toConsultFamilyAccountResult(ConsultFamilyAccountEntity consultFamilyAccountEntity) {
        Intrinsics.checkNotNullParameter(consultFamilyAccountEntity, "");
        MoneyView moneyView = MoneyViewEntityMapperKt.toMoneyView(consultFamilyAccountEntity.getBalance());
        String status = consultFamilyAccountEntity.getStatus();
        String str = status == null ? "" : status;
        String role = consultFamilyAccountEntity.getRole();
        String str2 = role == null ? "" : role;
        String organizerName = consultFamilyAccountEntity.getOrganizerName();
        String str3 = organizerName == null ? "" : organizerName;
        LimitInfoEntity limitInfo = consultFamilyAccountEntity.getLimitInfo();
        return new ConsultFamilyAccountResult(moneyView, str, str2, str3, MoneyViewEntityMapperKt.toMoneyView(limitInfo != null ? limitInfo.getAmount() : null));
    }

    public static final QuestionnaireDataConfig toQuestionnaireDataConfig(QuestionnaireDataConfigEntity questionnaireDataConfigEntity) {
        Intrinsics.checkNotNullParameter(questionnaireDataConfigEntity, "");
        return new QuestionnaireDataConfig(questionnaireDataConfigEntity.getAddress(), questionnaireDataConfigEntity.getRelation());
    }

    public static final CreateFamilyAccountResult toCreateFamilyAccountResult(CreateFamilyAccountEntity createFamilyAccountEntity) {
        Intrinsics.checkNotNullParameter(createFamilyAccountEntity, "");
        String certificateId = createFamilyAccountEntity.getCertificateId();
        return new CreateFamilyAccountResult(certificateId != null ? certificateId : "");
    }

    public static final RemoveFamilyAccountResult toRemoveFamilyAccountResult(RemoveFamilyAccountEntity removeFamilyAccountEntity) {
        Intrinsics.checkNotNullParameter(removeFamilyAccountEntity, "");
        boolean z = removeFamilyAccountEntity.success;
        List<VerificationMethodInfoEntity> verificationMethodInfoList = removeFamilyAccountEntity.getVerificationMethodInfoList();
        if (verificationMethodInfoList == null) {
            verificationMethodInfoList = CollectionsKt.emptyList();
        }
        List<VerificationMethodInfo> verificationMethodInfoList2 = toVerificationMethodInfoList(verificationMethodInfoList);
        String securityId = removeFamilyAccountEntity.getSecurityId();
        return new RemoveFamilyAccountResult(z, verificationMethodInfoList2, securityId != null ? securityId : "", SecurityContextEntityKt.toSecurityContext(SecurityContextEntityKt.toSecurityContextEntity(removeFamilyAccountEntity.getSecurityContext())));
    }

    public static final RemoveFamilyMemberResult toRemoveFamilyMemberResult(RemoveFamilyMemberEntity removeFamilyMemberEntity) {
        Intrinsics.checkNotNullParameter(removeFamilyMemberEntity, "");
        List<VerificationMethodInfoEntity> verificationMethodInfoList = removeFamilyMemberEntity.getVerificationMethodInfoList();
        if (verificationMethodInfoList == null) {
            verificationMethodInfoList = CollectionsKt.emptyList();
        }
        List<VerificationMethodInfo> verificationMethodInfoList2 = toVerificationMethodInfoList(verificationMethodInfoList);
        String securityId = removeFamilyMemberEntity.getSecurityId();
        return new RemoveFamilyMemberResult(verificationMethodInfoList2, securityId != null ? securityId : "", SecurityContextEntityKt.toSecurityContext(SecurityContextEntityKt.toSecurityContextEntity(removeFamilyMemberEntity.getSecurityContext())));
    }

    public static final SetLimitAndServicesEntity toSetLimitAndServicesEntity(SetLimitAndServicesRequest setLimitAndServicesRequest) {
        Intrinsics.checkNotNullParameter(setLimitAndServicesRequest, "");
        return new SetLimitAndServicesEntity(setLimitAndServicesRequest.getMemberId(), setLimitAndServicesRequest.getUseCases(), setLimitAndServicesRequest.getAmount());
    }

    public static final InvitationDecisionRequestEntity toInvitationDecisionRequestEntity(InvitationDecisionRequestInfo invitationDecisionRequestInfo) {
        Intrinsics.checkNotNullParameter(invitationDecisionRequestInfo, "");
        return new InvitationDecisionRequestEntity(invitationDecisionRequestInfo.getInvitationId(), invitationDecisionRequestInfo.getSecurityId());
    }

    public static final InvitationDecisionInfo toInvitationDecisionInfo(InvitationDecisionResultEntity invitationDecisionResultEntity) {
        Intrinsics.checkNotNullParameter(invitationDecisionResultEntity, "");
        boolean z = invitationDecisionResultEntity.success;
        List<VerificationMethodInfoEntity> verificationMethodInfoList = invitationDecisionResultEntity.getVerificationMethodInfoList();
        if (verificationMethodInfoList == null) {
            verificationMethodInfoList = CollectionsKt.emptyList();
        }
        return new InvitationDecisionInfo(Boolean.valueOf(z), toVerificationMethodInfoList(verificationMethodInfoList), invitationDecisionResultEntity.getSecurityId());
    }

    public static final List<VerificationMethodInfo> toVerificationMethodInfoList(List<VerificationMethodInfoEntity> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<VerificationMethodInfoEntity> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toVerificationMethodInfo((VerificationMethodInfoEntity) it.next()));
        }
        return arrayList;
    }

    public static final List<AvailableServicesConfig> toAvailableServicesConfigList(List<AvailableServicesConfigEntity> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<AvailableServicesConfigEntity> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toAvailableServiceConfig((AvailableServicesConfigEntity) it.next()));
        }
        return arrayList;
    }

    public static final AvailableServicesConfig toAvailableServiceConfig(AvailableServicesConfigEntity availableServicesConfigEntity) {
        Intrinsics.checkNotNullParameter(availableServicesConfigEntity, "");
        return new AvailableServicesConfig(availableServicesConfigEntity.getIcon(), availableServicesConfigEntity.getUseCase(), availableServicesConfigEntity.getServiceName(), availableServicesConfigEntity.getDefaultAvailability(), availableServicesConfigEntity.isEnable());
    }

    public static final TopUpUserConsultResult toTopUpUserConsultResult(TopUpUserConsultResultEntity topUpUserConsultResultEntity, List<? extends PayMethodView> list) {
        Intrinsics.checkNotNullParameter(topUpUserConsultResultEntity, "");
        return new TopUpUserConsultResult(MoneyViewEntityMapperKt.toMoneyView(topUpUserConsultResultEntity.getMinAmount()), MoneyViewEntityMapperKt.toMoneyView(topUpUserConsultResultEntity.getMaxAmount()), list, MoneyViewEntityMapperKt.toMoneyView(topUpUserConsultResultEntity.getMaxBalanceAmount()), MoneyViewEntityMapperKt.toMoneyView(topUpUserConsultResultEntity.getMaxMonthFundInAmount()));
    }

    public static final MaxMemberLimitConfig toMaxMemberLimitConfig(MaxMemberLimitConfigEntity maxMemberLimitConfigEntity) {
        Intrinsics.checkNotNullParameter(maxMemberLimitConfigEntity, "");
        return new MaxMemberLimitConfig(maxMemberLimitConfigEntity.getMaxAllMemberLimit(), maxMemberLimitConfigEntity.getMaxSetMemberLimit());
    }

    public static final CreateOrderTopUpRequestEntity toCreataOrderTopUpRequestEntity(CreateOrderTopupRequest createOrderTopupRequest) {
        Intrinsics.checkNotNullParameter(createOrderTopupRequest, "");
        return new CreateOrderTopUpRequestEntity(null, createOrderTopupRequest.getRequestId(), MoneyViewEntityMapperKt.toMoneyViewEntity(createOrderTopupRequest.getTopUpAmount()), 1, null);
    }

    public static final CreateOrderTopupResult toCreateOrderTopUpResult(CreateOrderTopUpResultEntity createOrderTopUpResultEntity) {
        Intrinsics.checkNotNullParameter(createOrderTopUpResultEntity, "");
        String checkoutUrl = createOrderTopUpResultEntity.getCheckoutUrl();
        return new CreateOrderTopupResult(checkoutUrl != null ? checkoutUrl : "");
    }

    public static final RejectSendMoneyRequestEntity toRejectSendMoneyRequestEntity(RejectSendMoneyRequest rejectSendMoneyRequest) {
        Intrinsics.checkNotNullParameter(rejectSendMoneyRequest, "");
        return new RejectSendMoneyRequestEntity(rejectSendMoneyRequest.getFundOrderId(), rejectSendMoneyRequest.getFundType());
    }

    public static final ApproveSendMoneyRequestEntity toApproveSendMoneyRequestEntity(ApproveSendMoneyRequest approveSendMoneyRequest) {
        Intrinsics.checkNotNullParameter(approveSendMoneyRequest, "");
        return new ApproveSendMoneyRequestEntity(approveSendMoneyRequest.getFundType(), approveSendMoneyRequest.getFundOrderId(), approveSendMoneyRequest.getVersion(), approveSendMoneyRequest.getAmount(), approveSendMoneyRequest.getPayMethod(), approveSendMoneyRequest.getTransferMethod(), approveSendMoneyRequest.getTransferScenario(), approveSendMoneyRequest.getRemarks());
    }

    public static final ApproveSendMoneyResult toApproveSendMoneyResult(ApproveSendMoneyResultEntity approveSendMoneyResultEntity) {
        AttributesResult attributesResult;
        Intrinsics.checkNotNullParameter(approveSendMoneyResultEntity, "");
        String fundOrderId = approveSendMoneyResultEntity.getFundOrderId();
        if (fundOrderId == null) {
            fundOrderId = "";
        }
        MoneyView moneyView = MoneyViewEntityMapperKt.toMoneyView(approveSendMoneyResultEntity.getFundAmount());
        String cashierOrderId = approveSendMoneyResultEntity.getCashierOrderId();
        String str = cashierOrderId != null ? cashierOrderId : "";
        AttributesResultEntity attributes = approveSendMoneyResultEntity.getAttributes();
        if (attributes == null || (attributesResult = AttributesResultEntityKt.toAttributesResult(attributes)) == null) {
            attributesResult = new AttributesResult(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 33554431, null);
        }
        return new ApproveSendMoneyResult(fundOrderId, moneyView, str, attributesResult);
    }

    private static final VerificationMethodInfo toVerificationMethodInfo(VerificationMethodInfoEntity verificationMethodInfoEntity) {
        VerificationMethodInfo verificationMethodInfo = new VerificationMethodInfo();
        verificationMethodInfo.setPriority(Integer.valueOf(verificationMethodInfoEntity.getPriority()));
        String verificationMethod = verificationMethodInfoEntity.getVerificationMethod();
        if (verificationMethod == null) {
            verificationMethod = "";
        }
        verificationMethodInfo.setVerificationMethod(verificationMethod);
        String verificationMethodCode = verificationMethodInfoEntity.getVerificationMethodCode();
        verificationMethodInfo.setVerificationMethodCode(verificationMethodCode != null ? verificationMethodCode : "");
        return verificationMethodInfo;
    }

    public static final OrganizerSummaryRequestEntity toOrganizerSummaryRequestEntity(OrganizerSummaryRequest organizerSummaryRequest) {
        Intrinsics.checkNotNullParameter(organizerSummaryRequest, "");
        return new OrganizerSummaryRequestEntity(organizerSummaryRequest.getFundOrderId());
    }

    public static final SummaryResult toSummaryResult(SummaryResultEntity summaryResultEntity) {
        Intrinsics.checkNotNullParameter(summaryResultEntity, "");
        MoneyView moneyView = MoneyViewEntityMapperKt.toMoneyView(summaryResultEntity.getFundAmount());
        Long completedTime = summaryResultEntity.getCompletedTime();
        Boolean enableToClaim = summaryResultEntity.getEnableToClaim();
        Long paidTime = summaryResultEntity.getPaidTime();
        PayerUserInfoEntity payerUserInfo = summaryResultEntity.getPayerUserInfo();
        PayerUserInfo payerUserInfo2 = payerUserInfo != null ? toPayerUserInfo(payerUserInfo) : null;
        String token = summaryResultEntity.getToken();
        String fundType = summaryResultEntity.getFundType();
        MoneyView moneyView2 = MoneyViewEntityMapperKt.toMoneyView(summaryResultEntity.getBalanceFamily());
        Long createdTime = summaryResultEntity.getCreatedTime();
        String status = summaryResultEntity.getStatus();
        String shareLink = summaryResultEntity.getShareLink();
        PayeeUserInfoEntity payeeUserInfo = summaryResultEntity.getPayeeUserInfo();
        return new SummaryResult(moneyView, completedTime, enableToClaim, paidTime, payerUserInfo2, token, fundType, moneyView2, createdTime, status, shareLink, payeeUserInfo != null ? toPayeeUserInfo(payeeUserInfo) : null, MoneyViewEntityMapperKt.toMoneyView(summaryResultEntity.getChargeAmount()), summaryResultEntity.getRemarks(), MoneyViewEntityMapperKt.toMoneyView(summaryResultEntity.getPaidTotalAmount()));
    }

    public static final PayerUserInfo toPayerUserInfo(PayerUserInfoEntity payerUserInfoEntity) {
        Intrinsics.checkNotNullParameter(payerUserInfoEntity, "");
        return new PayerUserInfo(payerUserInfoEntity.getKycLevel(), payerUserInfoEntity.getPhoneNumber(), payerUserInfoEntity.getNickName(), payerUserInfoEntity.getCertified(), payerUserInfoEntity.getAvatar(), payerUserInfoEntity.getUserId());
    }

    public static final PayeeUserInfo toPayeeUserInfo(PayeeUserInfoEntity payeeUserInfoEntity) {
        Intrinsics.checkNotNullParameter(payeeUserInfoEntity, "");
        return new PayeeUserInfo(payeeUserInfoEntity.getKycLevel(), payeeUserInfoEntity.getPhoneNumber(), payeeUserInfoEntity.getNickName(), payeeUserInfoEntity.getCertified(), payeeUserInfoEntity.getAvatar(), payeeUserInfoEntity.getUserId(), payeeUserInfoEntity.getInstId(), payeeUserInfoEntity.getInstName(), payeeUserInfoEntity.getMaskedNickName(), payeeUserInfoEntity.getMaskedAccountNo());
    }
}
