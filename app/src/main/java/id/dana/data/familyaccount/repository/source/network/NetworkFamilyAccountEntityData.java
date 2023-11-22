package id.dana.data.familyaccount.repository.source.network;

import android.content.Context;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.data.familyaccount.model.request.ApproveSendMoneyRequestEntity;
import id.dana.data.familyaccount.model.request.ConsultFamilyAcountRequestEntity;
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
import id.dana.data.familyaccount.repository.source.FamilyAccountEntityData;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.userconsent.repository.source.network.RecordAgreementRequest;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B)\b\u0007\u0012\u0006\u0010U\u001a\u00020T\u0012\u0006\u0010W\u001a\u00020V\u0012\u0006\u0010Y\u001a\u00020X\u0012\u0006\u0010[\u001a\u00020Z¢\u0006\u0004\b\\\u0010]J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0006H\u0016¢\u0006\u0004\b\u001d\u0010\fJ\u0015\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u001eH\u0014¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u00062\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b$\u0010%J\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020(0\u00062\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b)\u0010*J\u001d\u0010.\u001a\b\u0012\u0004\u0012\u00020-0\u00062\u0006\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b.\u0010/Ja\u0010:\u001a\b\u0012\u0004\u0012\u0002090\u00062\u0006\u00101\u001a\u0002002\u0006\u00102\u001a\u00020\u00172\b\u00103\u001a\u0004\u0018\u0001002\b\u00104\u001a\u0004\u0018\u0001002\b\u00105\u001a\u0004\u0018\u0001002\b\u00106\u001a\u0004\u0018\u0001002\b\u00107\u001a\u0004\u0018\u0001002\b\u00108\u001a\u0004\u0018\u000100H\u0016¢\u0006\u0004\b:\u0010;J\u001d\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b<\u0010\tJ\u001d\u0010@\u001a\b\u0012\u0004\u0012\u00020?0\u00062\u0006\u0010>\u001a\u00020=H\u0016¢\u0006\u0004\b@\u0010AJ\u001d\u0010E\u001a\b\u0012\u0004\u0012\u00020D0\u00062\u0006\u0010C\u001a\u00020BH\u0016¢\u0006\u0004\bE\u0010FJ\u001d\u0010J\u001a\b\u0012\u0004\u0012\u00020I0\u00062\u0006\u0010H\u001a\u00020GH\u0016¢\u0006\u0004\bJ\u0010KJ\u001d\u0010N\u001a\b\u0012\u0004\u0012\u0002090\u00062\u0006\u0010M\u001a\u00020LH\u0016¢\u0006\u0004\bN\u0010OJ\u001d\u0010R\u001a\u00028\u0000\"\b\b\u0000\u0010Q*\u00020P*\u00028\u0000H\u0002¢\u0006\u0004\bR\u0010S"}, d2 = {"Lid/dana/data/familyaccount/repository/source/network/NetworkFamilyAccountEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/data/familyaccount/repository/source/network/FamilyAccountFacade;", "Lid/dana/data/familyaccount/repository/source/FamilyAccountEntityData;", "Lid/dana/data/familyaccount/model/request/InvitationDecisionRequestEntity;", "requestEntity", "Lio/reactivex/Observable;", "Lid/dana/data/familyaccount/model/result/InvitationDecisionResultEntity;", "acceptInvitation", "(Lid/dana/data/familyaccount/model/request/InvitationDecisionRequestEntity;)Lio/reactivex/Observable;", "Lid/dana/data/familyaccount/model/result/CreateFamilyAccountEntity;", "activateCreateFamilyAccount", "()Lio/reactivex/Observable;", "Lid/dana/data/familyaccount/model/request/ApproveSendMoneyRequestEntity;", "approveSendMoneyRequestEntity", "Lid/dana/data/familyaccount/model/result/ApproveSendMoneyResultEntity;", "approveSendMoneyFamilyAccount", "(Lid/dana/data/familyaccount/model/request/ApproveSendMoneyRequestEntity;)Lio/reactivex/Observable;", "Lid/dana/data/familyaccount/model/request/CreateOrderTopUpRequestEntity;", "createOrderTopUpRequestEntity", "Lid/dana/data/familyaccount/model/result/CreateOrderTopUpResultEntity;", "createOrderTopupFamilyBalance", "(Lid/dana/data/familyaccount/model/request/CreateOrderTopUpRequestEntity;)Lio/reactivex/Observable;", "", "withLimit", "Lid/dana/data/familyaccount/model/result/ConsultFamilyAccountEntity;", "getConsultFamilyAccount", "(Z)Lio/reactivex/Observable;", "Lid/dana/data/familyaccount/model/result/DashboardFamilyAccountEntity;", "getDashboardFamiyAccount", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "Lid/dana/data/familyaccount/model/request/OrganizerSummaryRequestEntity;", "organizerSummaryRequestEntity", "Lid/dana/data/familyaccount/model/result/SummaryResultEntity;", "getOrganizerSummary", "(Lid/dana/data/familyaccount/model/request/OrganizerSummaryRequestEntity;)Lio/reactivex/Observable;", "Lid/dana/data/familyaccount/model/request/TopUpUserConsultRequestEntity;", "topUpUserConsultRequestEntity", "Lid/dana/data/familyaccount/model/result/TopUpUserConsultResultEntity;", "getTopUpUserConsult", "(Lid/dana/data/familyaccount/model/request/TopUpUserConsultRequestEntity;)Lio/reactivex/Observable;", "Lid/dana/data/familyaccount/model/request/InviteMembersRequestEntity;", "inviteMembersRequestEntity", "Lid/dana/data/familyaccount/model/result/InviteMembersResultEntity;", "invite", "(Lid/dana/data/familyaccount/model/request/InviteMembersRequestEntity;)Lio/reactivex/Observable;", "", "agreementKey", "userAgree", "agreementType", "organizerName", "organizerPhoneNumber", "memberPhoneNumber", "memberRelationship", "memberLocation", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "recordAgreement", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "rejectInvitation", "Lid/dana/data/familyaccount/model/request/RejectSendMoneyRequestEntity;", "rejectSendMoneyRequestEntity", "Lid/dana/data/familyaccount/model/result/RejectSendMoneyResultEntity;", "rejectSendMoneyFamilyAccount", "(Lid/dana/data/familyaccount/model/request/RejectSendMoneyRequestEntity;)Lio/reactivex/Observable;", "Lid/dana/data/familyaccount/model/request/RemoveFamilyAccountRequestEntity;", "removeFamilyAccountRequestEntity", "Lid/dana/data/familyaccount/model/result/RemoveFamilyAccountEntity;", "removeFamilyAccount", "(Lid/dana/data/familyaccount/model/request/RemoveFamilyAccountRequestEntity;)Lio/reactivex/Observable;", "Lid/dana/data/familyaccount/model/request/RemoveFamilyMemberRequestEntity;", "removeFamilyMemberEntity", "Lid/dana/data/familyaccount/model/result/RemoveFamilyMemberEntity;", "removeFamilyMember", "(Lid/dana/data/familyaccount/model/request/RemoveFamilyMemberRequestEntity;)Lio/reactivex/Observable;", "Lid/dana/data/familyaccount/model/request/SetLimitAndServicesEntity;", "setLimitAndServicesEntity", "setLimitAndServicesFamilyAccount", "(Lid/dana/data/familyaccount/model/request/SetLimitAndServicesEntity;)Lio/reactivex/Observable;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "T", "applyGeneratedMobileEnvInfo", "(Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;)Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "Lid/dana/network/rpc/RpcConnector;", "rpcConnector", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "apSecurityFacade", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkFamilyAccountEntityData extends SecureBaseNetwork<FamilyAccountFacade> implements FamilyAccountEntityData {
    @Override // id.dana.network.base.BaseNetwork
    public final Class<FamilyAccountFacade> getFacadeClass() {
        return FamilyAccountFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkFamilyAccountEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.data.familyaccount.repository.source.FamilyAccountEntityData
    public final Observable<ConsultFamilyAccountEntity> getConsultFamilyAccount(final boolean withLimit) {
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.familyaccount.repository.source.network.NetworkFamilyAccountEntityData$$ExternalSyntheticLambda6
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                ConsultFamilyAccountEntity m1272getConsultFamilyAccount$lambda0;
                m1272getConsultFamilyAccount$lambda0 = NetworkFamilyAccountEntityData.m1272getConsultFamilyAccount$lambda0(NetworkFamilyAccountEntityData.this, withLimit, (FamilyAccountFacade) obj);
                return m1272getConsultFamilyAccount$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getConsultFamilyAccount$lambda-0  reason: not valid java name */
    public static final ConsultFamilyAccountEntity m1272getConsultFamilyAccount$lambda0(NetworkFamilyAccountEntityData networkFamilyAccountEntityData, boolean z, FamilyAccountFacade familyAccountFacade) {
        Intrinsics.checkNotNullParameter(networkFamilyAccountEntityData, "");
        return familyAccountFacade.consultFamilyAccount((ConsultFamilyAcountRequestEntity) networkFamilyAccountEntityData.applyGeneratedMobileEnvInfo(new ConsultFamilyAcountRequestEntity(z)));
    }

    @Override // id.dana.data.familyaccount.repository.source.FamilyAccountEntityData
    public final Observable<InviteMembersResultEntity> invite(final InviteMembersRequestEntity inviteMembersRequestEntity) {
        Intrinsics.checkNotNullParameter(inviteMembersRequestEntity, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.familyaccount.repository.source.network.NetworkFamilyAccountEntityData$$ExternalSyntheticLambda8
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                InviteMembersResultEntity m1276invite$lambda1;
                m1276invite$lambda1 = NetworkFamilyAccountEntityData.m1276invite$lambda1(NetworkFamilyAccountEntityData.this, inviteMembersRequestEntity, (FamilyAccountFacade) obj);
                return m1276invite$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invite$lambda-1  reason: not valid java name */
    public static final InviteMembersResultEntity m1276invite$lambda1(NetworkFamilyAccountEntityData networkFamilyAccountEntityData, InviteMembersRequestEntity inviteMembersRequestEntity, FamilyAccountFacade familyAccountFacade) {
        Intrinsics.checkNotNullParameter(networkFamilyAccountEntityData, "");
        Intrinsics.checkNotNullParameter(inviteMembersRequestEntity, "");
        return familyAccountFacade.invite((InviteMembersRequestEntity) networkFamilyAccountEntityData.applyGeneratedMobileEnvInfo(inviteMembersRequestEntity));
    }

    @Override // id.dana.data.familyaccount.repository.source.FamilyAccountEntityData
    public final Observable<BaseRpcResult> recordAgreement(final String agreementKey, final boolean userAgree, final String agreementType, final String organizerName, final String organizerPhoneNumber, final String memberPhoneNumber, final String memberRelationship, final String memberLocation) {
        Intrinsics.checkNotNullParameter(agreementKey, "");
        Observable<S> wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.familyaccount.repository.source.network.NetworkFamilyAccountEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                BaseRpcResult m1277recordAgreement$lambda3;
                m1277recordAgreement$lambda3 = NetworkFamilyAccountEntityData.m1277recordAgreement$lambda3(agreementKey, userAgree, agreementType, organizerName, organizerPhoneNumber, memberPhoneNumber, memberRelationship, memberLocation, (FamilyAccountFacade) obj);
                return m1277recordAgreement$lambda3;
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: recordAgreement$lambda-3  reason: not valid java name */
    public static final BaseRpcResult m1277recordAgreement$lambda3(String str, boolean z, String str2, String str3, String str4, String str5, String str6, String str7, FamilyAccountFacade familyAccountFacade) {
        Intrinsics.checkNotNullParameter(str, "");
        RecordAgreementRequest recordAgreementRequest = new RecordAgreementRequest(str, z, str2);
        Map<String, String> map = recordAgreementRequest.extParams;
        Intrinsics.checkNotNullExpressionValue(map, "");
        map.put("organizerName", str3);
        map.put("organizerPhoneNumber", str4);
        map.put("memberPhoneNumber", str5);
        map.put("memberRelationship", str6);
        map.put("memberLocation", str7);
        return familyAccountFacade.recordAgreement(recordAgreementRequest);
    }

    @Override // id.dana.data.familyaccount.repository.source.FamilyAccountEntityData
    public final Observable<CreateFamilyAccountEntity> activateCreateFamilyAccount() {
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.familyaccount.repository.source.network.NetworkFamilyAccountEntityData$$ExternalSyntheticLambda10
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                CreateFamilyAccountEntity m1269activateCreateFamilyAccount$lambda4;
                m1269activateCreateFamilyAccount$lambda4 = NetworkFamilyAccountEntityData.m1269activateCreateFamilyAccount$lambda4(NetworkFamilyAccountEntityData.this, (FamilyAccountFacade) obj);
                return m1269activateCreateFamilyAccount$lambda4;
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: activateCreateFamilyAccount$lambda-4  reason: not valid java name */
    public static final CreateFamilyAccountEntity m1269activateCreateFamilyAccount$lambda4(NetworkFamilyAccountEntityData networkFamilyAccountEntityData, FamilyAccountFacade familyAccountFacade) {
        Intrinsics.checkNotNullParameter(networkFamilyAccountEntityData, "");
        return familyAccountFacade.activateCreateFamilyAccount(networkFamilyAccountEntityData.applyGeneratedMobileEnvInfo(new BaseRpcRequest()));
    }

    @Override // id.dana.data.familyaccount.repository.source.FamilyAccountEntityData
    public final Observable<DashboardFamilyAccountEntity> getDashboardFamiyAccount() {
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.familyaccount.repository.source.network.NetworkFamilyAccountEntityData$$ExternalSyntheticLambda1
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                DashboardFamilyAccountEntity m1273getDashboardFamiyAccount$lambda5;
                m1273getDashboardFamiyAccount$lambda5 = NetworkFamilyAccountEntityData.m1273getDashboardFamiyAccount$lambda5(NetworkFamilyAccountEntityData.this, (FamilyAccountFacade) obj);
                return m1273getDashboardFamiyAccount$lambda5;
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getDashboardFamiyAccount$lambda-5  reason: not valid java name */
    public static final DashboardFamilyAccountEntity m1273getDashboardFamiyAccount$lambda5(NetworkFamilyAccountEntityData networkFamilyAccountEntityData, FamilyAccountFacade familyAccountFacade) {
        Intrinsics.checkNotNullParameter(networkFamilyAccountEntityData, "");
        return familyAccountFacade.dashboardFamilyAccount(networkFamilyAccountEntityData.applyGeneratedMobileEnvInfo(new BaseRpcRequest()));
    }

    @Override // id.dana.data.familyaccount.repository.source.FamilyAccountEntityData
    public final Observable<RemoveFamilyAccountEntity> removeFamilyAccount(final RemoveFamilyAccountRequestEntity removeFamilyAccountRequestEntity) {
        Intrinsics.checkNotNullParameter(removeFamilyAccountRequestEntity, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.familyaccount.repository.source.network.NetworkFamilyAccountEntityData$$ExternalSyntheticLambda13
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                RemoveFamilyAccountEntity m1280removeFamilyAccount$lambda6;
                m1280removeFamilyAccount$lambda6 = NetworkFamilyAccountEntityData.m1280removeFamilyAccount$lambda6(NetworkFamilyAccountEntityData.this, removeFamilyAccountRequestEntity, (FamilyAccountFacade) obj);
                return m1280removeFamilyAccount$lambda6;
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: removeFamilyAccount$lambda-6  reason: not valid java name */
    public static final RemoveFamilyAccountEntity m1280removeFamilyAccount$lambda6(NetworkFamilyAccountEntityData networkFamilyAccountEntityData, RemoveFamilyAccountRequestEntity removeFamilyAccountRequestEntity, FamilyAccountFacade familyAccountFacade) {
        Intrinsics.checkNotNullParameter(networkFamilyAccountEntityData, "");
        Intrinsics.checkNotNullParameter(removeFamilyAccountRequestEntity, "");
        return familyAccountFacade.removeFamilyAccount((RemoveFamilyAccountRequestEntity) networkFamilyAccountEntityData.applyGeneratedMobileEnvInfo(removeFamilyAccountRequestEntity));
    }

    @Override // id.dana.data.familyaccount.repository.source.FamilyAccountEntityData
    public final Observable<RemoveFamilyMemberEntity> removeFamilyMember(final RemoveFamilyMemberRequestEntity removeFamilyMemberEntity) {
        Intrinsics.checkNotNullParameter(removeFamilyMemberEntity, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.familyaccount.repository.source.network.NetworkFamilyAccountEntityData$$ExternalSyntheticLambda11
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                RemoveFamilyMemberEntity m1281removeFamilyMember$lambda7;
                m1281removeFamilyMember$lambda7 = NetworkFamilyAccountEntityData.m1281removeFamilyMember$lambda7(NetworkFamilyAccountEntityData.this, removeFamilyMemberEntity, (FamilyAccountFacade) obj);
                return m1281removeFamilyMember$lambda7;
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: removeFamilyMember$lambda-7  reason: not valid java name */
    public static final RemoveFamilyMemberEntity m1281removeFamilyMember$lambda7(NetworkFamilyAccountEntityData networkFamilyAccountEntityData, RemoveFamilyMemberRequestEntity removeFamilyMemberRequestEntity, FamilyAccountFacade familyAccountFacade) {
        Intrinsics.checkNotNullParameter(networkFamilyAccountEntityData, "");
        Intrinsics.checkNotNullParameter(removeFamilyMemberRequestEntity, "");
        return familyAccountFacade.removeFamilyMember((RemoveFamilyMemberRequestEntity) networkFamilyAccountEntityData.applyGeneratedMobileEnvInfo(removeFamilyMemberRequestEntity));
    }

    @Override // id.dana.data.familyaccount.repository.source.FamilyAccountEntityData
    public final Observable<BaseRpcResult> setLimitAndServicesFamilyAccount(final SetLimitAndServicesEntity setLimitAndServicesEntity) {
        Intrinsics.checkNotNullParameter(setLimitAndServicesEntity, "");
        Observable<S> wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.familyaccount.repository.source.network.NetworkFamilyAccountEntityData$$ExternalSyntheticLambda9
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                BaseRpcResult m1282setLimitAndServicesFamilyAccount$lambda8;
                m1282setLimitAndServicesFamilyAccount$lambda8 = NetworkFamilyAccountEntityData.m1282setLimitAndServicesFamilyAccount$lambda8(NetworkFamilyAccountEntityData.this, setLimitAndServicesEntity, (FamilyAccountFacade) obj);
                return m1282setLimitAndServicesFamilyAccount$lambda8;
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setLimitAndServicesFamilyAccount$lambda-8  reason: not valid java name */
    public static final BaseRpcResult m1282setLimitAndServicesFamilyAccount$lambda8(NetworkFamilyAccountEntityData networkFamilyAccountEntityData, SetLimitAndServicesEntity setLimitAndServicesEntity, FamilyAccountFacade familyAccountFacade) {
        Intrinsics.checkNotNullParameter(networkFamilyAccountEntityData, "");
        Intrinsics.checkNotNullParameter(setLimitAndServicesEntity, "");
        return familyAccountFacade.setLimitFamilyAccount((SetLimitAndServicesEntity) networkFamilyAccountEntityData.applyGeneratedMobileEnvInfo(setLimitAndServicesEntity));
    }

    @Override // id.dana.data.familyaccount.repository.source.FamilyAccountEntityData
    public final Observable<InvitationDecisionResultEntity> acceptInvitation(final InvitationDecisionRequestEntity requestEntity) {
        Intrinsics.checkNotNullParameter(requestEntity, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.familyaccount.repository.source.network.NetworkFamilyAccountEntityData$$ExternalSyntheticLambda12
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                InvitationDecisionResultEntity m1268acceptInvitation$lambda9;
                m1268acceptInvitation$lambda9 = NetworkFamilyAccountEntityData.m1268acceptInvitation$lambda9(NetworkFamilyAccountEntityData.this, requestEntity, (FamilyAccountFacade) obj);
                return m1268acceptInvitation$lambda9;
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: acceptInvitation$lambda-9  reason: not valid java name */
    public static final InvitationDecisionResultEntity m1268acceptInvitation$lambda9(NetworkFamilyAccountEntityData networkFamilyAccountEntityData, InvitationDecisionRequestEntity invitationDecisionRequestEntity, FamilyAccountFacade familyAccountFacade) {
        Intrinsics.checkNotNullParameter(networkFamilyAccountEntityData, "");
        Intrinsics.checkNotNullParameter(invitationDecisionRequestEntity, "");
        return familyAccountFacade.acceptInvitation((InvitationDecisionRequestEntity) networkFamilyAccountEntityData.applyGeneratedMobileEnvInfo(invitationDecisionRequestEntity));
    }

    @Override // id.dana.data.familyaccount.repository.source.FamilyAccountEntityData
    public final Observable<InvitationDecisionResultEntity> rejectInvitation(final InvitationDecisionRequestEntity requestEntity) {
        Intrinsics.checkNotNullParameter(requestEntity, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.familyaccount.repository.source.network.NetworkFamilyAccountEntityData$$ExternalSyntheticLambda5
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                InvitationDecisionResultEntity m1278rejectInvitation$lambda10;
                m1278rejectInvitation$lambda10 = NetworkFamilyAccountEntityData.m1278rejectInvitation$lambda10(NetworkFamilyAccountEntityData.this, requestEntity, (FamilyAccountFacade) obj);
                return m1278rejectInvitation$lambda10;
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: rejectInvitation$lambda-10  reason: not valid java name */
    public static final InvitationDecisionResultEntity m1278rejectInvitation$lambda10(NetworkFamilyAccountEntityData networkFamilyAccountEntityData, InvitationDecisionRequestEntity invitationDecisionRequestEntity, FamilyAccountFacade familyAccountFacade) {
        Intrinsics.checkNotNullParameter(networkFamilyAccountEntityData, "");
        Intrinsics.checkNotNullParameter(invitationDecisionRequestEntity, "");
        return familyAccountFacade.rejectInvitation((InvitationDecisionRequestEntity) networkFamilyAccountEntityData.applyGeneratedMobileEnvInfo(invitationDecisionRequestEntity));
    }

    @Override // id.dana.data.familyaccount.repository.source.FamilyAccountEntityData
    public final Observable<TopUpUserConsultResultEntity> getTopUpUserConsult(final TopUpUserConsultRequestEntity topUpUserConsultRequestEntity) {
        Intrinsics.checkNotNullParameter(topUpUserConsultRequestEntity, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.familyaccount.repository.source.network.NetworkFamilyAccountEntityData$$ExternalSyntheticLambda4
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                TopUpUserConsultResultEntity m1275getTopUpUserConsult$lambda11;
                m1275getTopUpUserConsult$lambda11 = NetworkFamilyAccountEntityData.m1275getTopUpUserConsult$lambda11(NetworkFamilyAccountEntityData.this, topUpUserConsultRequestEntity, (FamilyAccountFacade) obj);
                return m1275getTopUpUserConsult$lambda11;
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getTopUpUserConsult$lambda-11  reason: not valid java name */
    public static final TopUpUserConsultResultEntity m1275getTopUpUserConsult$lambda11(NetworkFamilyAccountEntityData networkFamilyAccountEntityData, TopUpUserConsultRequestEntity topUpUserConsultRequestEntity, FamilyAccountFacade familyAccountFacade) {
        Intrinsics.checkNotNullParameter(networkFamilyAccountEntityData, "");
        Intrinsics.checkNotNullParameter(topUpUserConsultRequestEntity, "");
        return familyAccountFacade.getTopUpUserConsult((TopUpUserConsultRequestEntity) networkFamilyAccountEntityData.applyGeneratedMobileEnvInfo(topUpUserConsultRequestEntity));
    }

    @Override // id.dana.data.familyaccount.repository.source.FamilyAccountEntityData
    public final Observable<CreateOrderTopUpResultEntity> createOrderTopupFamilyBalance(final CreateOrderTopUpRequestEntity createOrderTopUpRequestEntity) {
        Intrinsics.checkNotNullParameter(createOrderTopUpRequestEntity, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.familyaccount.repository.source.network.NetworkFamilyAccountEntityData$$ExternalSyntheticLambda2
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                CreateOrderTopUpResultEntity m1271createOrderTopupFamilyBalance$lambda12;
                m1271createOrderTopupFamilyBalance$lambda12 = NetworkFamilyAccountEntityData.m1271createOrderTopupFamilyBalance$lambda12(NetworkFamilyAccountEntityData.this, createOrderTopUpRequestEntity, (FamilyAccountFacade) obj);
                return m1271createOrderTopupFamilyBalance$lambda12;
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: createOrderTopupFamilyBalance$lambda-12  reason: not valid java name */
    public static final CreateOrderTopUpResultEntity m1271createOrderTopupFamilyBalance$lambda12(NetworkFamilyAccountEntityData networkFamilyAccountEntityData, CreateOrderTopUpRequestEntity createOrderTopUpRequestEntity, FamilyAccountFacade familyAccountFacade) {
        Intrinsics.checkNotNullParameter(networkFamilyAccountEntityData, "");
        Intrinsics.checkNotNullParameter(createOrderTopUpRequestEntity, "");
        return familyAccountFacade.createOrderTopupFamilyBalance((CreateOrderTopUpRequestEntity) networkFamilyAccountEntityData.applyGeneratedMobileEnvInfo(createOrderTopUpRequestEntity));
    }

    @Override // id.dana.data.familyaccount.repository.source.FamilyAccountEntityData
    public final Observable<RejectSendMoneyResultEntity> rejectSendMoneyFamilyAccount(final RejectSendMoneyRequestEntity rejectSendMoneyRequestEntity) {
        Intrinsics.checkNotNullParameter(rejectSendMoneyRequestEntity, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.familyaccount.repository.source.network.NetworkFamilyAccountEntityData$$ExternalSyntheticLambda14
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                RejectSendMoneyResultEntity m1279rejectSendMoneyFamilyAccount$lambda13;
                m1279rejectSendMoneyFamilyAccount$lambda13 = NetworkFamilyAccountEntityData.m1279rejectSendMoneyFamilyAccount$lambda13(NetworkFamilyAccountEntityData.this, rejectSendMoneyRequestEntity, (FamilyAccountFacade) obj);
                return m1279rejectSendMoneyFamilyAccount$lambda13;
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: rejectSendMoneyFamilyAccount$lambda-13  reason: not valid java name */
    public static final RejectSendMoneyResultEntity m1279rejectSendMoneyFamilyAccount$lambda13(NetworkFamilyAccountEntityData networkFamilyAccountEntityData, RejectSendMoneyRequestEntity rejectSendMoneyRequestEntity, FamilyAccountFacade familyAccountFacade) {
        Intrinsics.checkNotNullParameter(networkFamilyAccountEntityData, "");
        Intrinsics.checkNotNullParameter(rejectSendMoneyRequestEntity, "");
        return familyAccountFacade.rejectSendMoneyFamilyAccount((RejectSendMoneyRequestEntity) networkFamilyAccountEntityData.applyGeneratedMobileEnvInfo(rejectSendMoneyRequestEntity));
    }

    @Override // id.dana.data.familyaccount.repository.source.FamilyAccountEntityData
    public final Observable<ApproveSendMoneyResultEntity> approveSendMoneyFamilyAccount(final ApproveSendMoneyRequestEntity approveSendMoneyRequestEntity) {
        Intrinsics.checkNotNullParameter(approveSendMoneyRequestEntity, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.familyaccount.repository.source.network.NetworkFamilyAccountEntityData$$ExternalSyntheticLambda7
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                ApproveSendMoneyResultEntity m1270approveSendMoneyFamilyAccount$lambda14;
                m1270approveSendMoneyFamilyAccount$lambda14 = NetworkFamilyAccountEntityData.m1270approveSendMoneyFamilyAccount$lambda14(NetworkFamilyAccountEntityData.this, approveSendMoneyRequestEntity, (FamilyAccountFacade) obj);
                return m1270approveSendMoneyFamilyAccount$lambda14;
            }
        }, new FamilyAccountExceptionParser());
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: approveSendMoneyFamilyAccount$lambda-14  reason: not valid java name */
    public static final ApproveSendMoneyResultEntity m1270approveSendMoneyFamilyAccount$lambda14(NetworkFamilyAccountEntityData networkFamilyAccountEntityData, ApproveSendMoneyRequestEntity approveSendMoneyRequestEntity, FamilyAccountFacade familyAccountFacade) {
        Intrinsics.checkNotNullParameter(networkFamilyAccountEntityData, "");
        Intrinsics.checkNotNullParameter(approveSendMoneyRequestEntity, "");
        return familyAccountFacade.approveSendMoneyFamilyAccount((ApproveSendMoneyRequestEntity) networkFamilyAccountEntityData.applyGeneratedMobileEnvInfo(approveSendMoneyRequestEntity));
    }

    @Override // id.dana.data.familyaccount.repository.source.FamilyAccountEntityData
    public final Observable<SummaryResultEntity> getOrganizerSummary(final OrganizerSummaryRequestEntity organizerSummaryRequestEntity) {
        Intrinsics.checkNotNullParameter(organizerSummaryRequestEntity, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.familyaccount.repository.source.network.NetworkFamilyAccountEntityData$$ExternalSyntheticLambda3
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                SummaryResultEntity m1274getOrganizerSummary$lambda15;
                m1274getOrganizerSummary$lambda15 = NetworkFamilyAccountEntityData.m1274getOrganizerSummary$lambda15(NetworkFamilyAccountEntityData.this, organizerSummaryRequestEntity, (FamilyAccountFacade) obj);
                return m1274getOrganizerSummary$lambda15;
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getOrganizerSummary$lambda-15  reason: not valid java name */
    public static final SummaryResultEntity m1274getOrganizerSummary$lambda15(NetworkFamilyAccountEntityData networkFamilyAccountEntityData, OrganizerSummaryRequestEntity organizerSummaryRequestEntity, FamilyAccountFacade familyAccountFacade) {
        Intrinsics.checkNotNullParameter(networkFamilyAccountEntityData, "");
        Intrinsics.checkNotNullParameter(organizerSummaryRequestEntity, "");
        return familyAccountFacade.getOrganizerSummary((OrganizerSummaryRequestEntity) networkFamilyAccountEntityData.applyGeneratedMobileEnvInfo(organizerSummaryRequestEntity));
    }

    private final <T extends BaseRpcRequest> T applyGeneratedMobileEnvInfo(T t) {
        t.envInfo = generateMobileEnvInfo();
        return t;
    }
}
