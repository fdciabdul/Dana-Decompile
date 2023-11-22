package id.dana.data.sendmoney.repository.source.network;

import android.content.Context;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.foundation.utils.CookieUtil;
import id.dana.data.promocode.PromoAndReferralCodeUtilKt;
import id.dana.data.security.SecureString;
import id.dana.data.sendmoney.SendMoneyEntityData;
import id.dana.data.sendmoney.mapper.NameCheckParamMapper;
import id.dana.data.sendmoney.mapper.TransferSubmitRequestMapper;
import id.dana.data.sendmoney.model.TransferOTCSubmitRequest;
import id.dana.data.sendmoney.model.TransferSubmitParam;
import id.dana.data.sendmoney.repository.source.network.request.BizGroupModifyEntityRequest;
import id.dana.data.sendmoney.repository.source.network.request.BizTransferOrderCreateRequest;
import id.dana.data.sendmoney.repository.source.network.request.BizTransferPrePayRequest;
import id.dana.data.sendmoney.repository.source.network.request.SendMoneyInitRequest;
import id.dana.data.sendmoney.repository.source.network.request.SendMoneyRequest;
import id.dana.data.sendmoney.repository.source.network.request.TransferInitRequest;
import id.dana.data.sendmoney.repository.source.network.request.TransferOTCInitRequest;
import id.dana.data.sendmoney.repository.source.network.request.TransferSubmitRequest;
import id.dana.data.sendmoney.repository.source.network.request.WithdrawInitRequest;
import id.dana.data.sendmoney.repository.source.network.request.WithdrawNameCheckRequest;
import id.dana.data.sendmoney.repository.source.network.result.BizGroupModifyEntityResult;
import id.dana.data.sendmoney.repository.source.network.result.BizTransferInitResult;
import id.dana.data.sendmoney.repository.source.network.result.BizTransferOrderCreateResult;
import id.dana.data.sendmoney.repository.source.network.result.BizTransferPrePayResult;
import id.dana.data.sendmoney.repository.source.network.result.SendMoneyInitResult;
import id.dana.data.sendmoney.repository.source.network.result.SendMoneyResult;
import id.dana.data.sendmoney.repository.source.network.result.WithdrawInitResult;
import id.dana.data.sendmoney.repository.source.network.result.WithdrawNameCheckResult;
import id.dana.domain.sendmoney.model.NameCheckParam;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.ExceptionParserAphome;
import id.dana.network.base.ResultResponse;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class NetworkSendMoneyEntityData extends SecureBaseNetwork<SendMoneyFacade> implements SendMoneyEntityData {
    private final NameCheckParamMapper nameCheckParamMapper;
    private final NameCheckSecureApi nameCheckSecureApi;
    private final TransferSubmitRequestMapper transferSubmitRequestMapper;

    @Inject
    public NetworkSendMoneyEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context, NameCheckSecureApi nameCheckSecureApi, NameCheckParamMapper nameCheckParamMapper, TransferSubmitRequestMapper transferSubmitRequestMapper) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        this.nameCheckSecureApi = nameCheckSecureApi;
        this.nameCheckParamMapper = nameCheckParamMapper;
        this.transferSubmitRequestMapper = transferSubmitRequestMapper;
    }

    @Override // id.dana.network.base.BaseNetwork
    public Class<SendMoneyFacade> getFacadeClass() {
        return SendMoneyFacade.class;
    }

    @Override // id.dana.data.sendmoney.SendMoneyEntityData
    public Observable<SendMoneyInitResult> init(String str, String str2, String str3) {
        final SendMoneyInitRequest sendMoneyInitRequest = new SendMoneyInitRequest();
        sendMoneyInitRequest.envInfo = generateMobileEnvInfo();
        sendMoneyInitRequest.payeeLoginId = str;
        sendMoneyInitRequest.payeeUserId = str2;
        sendMoneyInitRequest.version = str3;
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.sendmoney.repository.source.network.NetworkSendMoneyEntityData$$ExternalSyntheticLambda8
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                SendMoneyInitResult init;
                init = ((SendMoneyFacade) obj).init(SendMoneyInitRequest.this);
                return init;
            }
        });
    }

    @Override // id.dana.data.sendmoney.SendMoneyEntityData
    public Observable<SendMoneyInitResult> init() {
        return init(null, null, null);
    }

    @Override // id.dana.data.sendmoney.SendMoneyEntityData
    public Observable<BizTransferPrePayResult> initPrePay(final BizTransferPrePayRequest bizTransferPrePayRequest, String str) {
        bizTransferPrePayRequest.envInfo = generateMobileEnvInfo();
        PromoAndReferralCodeUtilKt.setUserCity(bizTransferPrePayRequest.envInfo.extendInfo, str);
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.sendmoney.repository.source.network.NetworkSendMoneyEntityData$$ExternalSyntheticLambda7
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                BizTransferPrePayResult initPrePay;
                initPrePay = ((SendMoneyFacade) obj).initPrePay(BizTransferPrePayRequest.this);
                return initPrePay;
            }
        });
    }

    @Override // id.dana.data.sendmoney.SendMoneyEntityData
    public Observable<SendMoneyResult> confirm(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, boolean z, String str11) {
        final SendMoneyRequest sendMoneyRequest = new SendMoneyRequest();
        sendMoneyRequest.envInfo = generateMobileEnvInfo();
        sendMoneyRequest.requestId = str;
        sendMoneyRequest.payAmount = str2;
        sendMoneyRequest.payCurrency = str3;
        sendMoneyRequest.payerAvatar = str4;
        sendMoneyRequest.payerNickname = str5;
        sendMoneyRequest.payeeAvatar = str6;
        sendMoneyRequest.payeeNickname = str7;
        sendMoneyRequest.payeeLoginId = str8;
        sendMoneyRequest.payeeUserId = str9;
        sendMoneyRequest.comment = str10;
        sendMoneyRequest.share = Boolean.valueOf(z);
        sendMoneyRequest.payMethod = str11;
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.sendmoney.repository.source.network.NetworkSendMoneyEntityData$$ExternalSyntheticLambda3
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                SendMoneyResult confirm;
                confirm = ((SendMoneyFacade) obj).confirm(SendMoneyRequest.this);
                return confirm;
            }
        });
    }

    @Override // id.dana.data.sendmoney.SendMoneyEntityData
    public Observable<BizTransferInitResult> bizInit(final TransferInitRequest transferInitRequest) {
        transferInitRequest.envInfo = generateMobileEnvInfo();
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.sendmoney.repository.source.network.NetworkSendMoneyEntityData$$ExternalSyntheticLambda10
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                BizTransferInitResult bizInit;
                bizInit = ((SendMoneyFacade) obj).bizInit(TransferInitRequest.this);
                return bizInit;
            }
        }, BizTransferInitResult.class);
    }

    @Override // id.dana.data.sendmoney.SendMoneyEntityData
    public Observable<BizTransferInitResult> bizOTCInit(final TransferOTCInitRequest transferOTCInitRequest) {
        transferOTCInitRequest.envInfo = generateMobileEnvInfo();
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.sendmoney.repository.source.network.NetworkSendMoneyEntityData$$ExternalSyntheticLambda4
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                BizTransferInitResult bizOTCInit;
                bizOTCInit = ((SendMoneyFacade) obj).bizOTCInit(TransferOTCInitRequest.this);
                return bizOTCInit;
            }
        }, BizTransferInitResult.class);
    }

    @Override // id.dana.data.sendmoney.SendMoneyEntityData
    public Observable<WithdrawInitResult> withdrawInit(final WithdrawInitRequest withdrawInitRequest) {
        withdrawInitRequest.envInfo = generateMobileEnvInfo();
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.sendmoney.repository.source.network.NetworkSendMoneyEntityData$$ExternalSyntheticLambda6
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                WithdrawInitResult withdrawInit;
                withdrawInit = ((SendMoneyFacade) obj).withdrawInit(WithdrawInitRequest.this);
                return withdrawInit;
            }
        });
    }

    @Override // id.dana.data.sendmoney.SendMoneyEntityData
    public Observable<WithdrawNameCheckResult> nameCheck(NameCheckParam nameCheckParam, String str, Boolean bool) {
        WithdrawNameCheckRequest map = this.nameCheckParamMapper.map(nameCheckParam, str, bool);
        map.envInfo = generateMobileEnvInfo();
        SecureString authRequestContext = CookieUtil.getAuthRequestContext();
        Observable<WithdrawNameCheckResult> flatMap = this.nameCheckSecureApi.nameCheck(authRequestContext.toString(), map).map(new Function() { // from class: id.dana.data.sendmoney.repository.source.network.NetworkSendMoneyEntityData$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return (WithdrawNameCheckResult) ((ResultResponse) obj).getResult();
            }
        }).flatMap(new ExceptionParserAphome());
        authRequestContext.clear();
        return flatMap;
    }

    @Override // id.dana.data.sendmoney.SendMoneyEntityData
    public Observable<SendMoneyResult> transferSubmit(TransferSubmitParam transferSubmitParam) {
        final TransferSubmitRequest apply = this.transferSubmitRequestMapper.apply(transferSubmitParam);
        apply.envInfo = generateMobileEnvInfo();
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.sendmoney.repository.source.network.NetworkSendMoneyEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                SendMoneyResult transferSubmit;
                transferSubmit = ((SendMoneyFacade) obj).transferSubmit(TransferSubmitRequest.this);
                return transferSubmit;
            }
        });
    }

    @Override // id.dana.data.sendmoney.SendMoneyEntityData
    public Observable<SendMoneyResult> transferOTCSubmit(final TransferOTCSubmitRequest transferOTCSubmitRequest) {
        transferOTCSubmitRequest.envInfo = generateMobileEnvInfo();
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.sendmoney.repository.source.network.NetworkSendMoneyEntityData$$ExternalSyntheticLambda9
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                SendMoneyResult transferOTCSubmit;
                transferOTCSubmit = ((SendMoneyFacade) obj).transferOTCSubmit(TransferOTCSubmitRequest.this);
                return transferOTCSubmit;
            }
        });
    }

    @Override // id.dana.data.sendmoney.SendMoneyEntityData
    public Observable<BizTransferOrderCreateResult> transferCreateOrder(final BizTransferOrderCreateRequest bizTransferOrderCreateRequest) {
        bizTransferOrderCreateRequest.envInfo = generateMobileEnvInfo();
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.sendmoney.repository.source.network.NetworkSendMoneyEntityData$$ExternalSyntheticLambda5
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                BizTransferOrderCreateResult transferOrderCreate;
                transferOrderCreate = ((SendMoneyFacade) obj).transferOrderCreate(BizTransferOrderCreateRequest.this);
                return transferOrderCreate;
            }
        });
    }

    @Override // id.dana.data.sendmoney.SendMoneyEntityData
    public Observable<BizGroupModifyEntityResult> deleteGroup(String str) {
        final BizGroupModifyEntityRequest createBizGroupModifyRequest = BizGroupModifyEntityRequest.INSTANCE.createBizGroupModifyRequest(str);
        createBizGroupModifyRequest.envInfo = generateMobileEnvInfo();
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.sendmoney.repository.source.network.NetworkSendMoneyEntityData$$ExternalSyntheticLambda1
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                BizGroupModifyEntityResult modifyGroup;
                modifyGroup = ((SendMoneyFacade) obj).modifyGroup(BizGroupModifyEntityRequest.this);
                return modifyGroup;
            }
        });
    }
}
