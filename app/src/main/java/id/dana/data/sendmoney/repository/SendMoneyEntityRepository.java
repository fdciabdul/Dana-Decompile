package id.dana.data.sendmoney.repository;

import id.dana.data.account.AccountEntity;
import id.dana.data.card.repository.CardCredentialEntityRepository;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.config.source.ConfigEntityData;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.config.source.amcs.result.OTCAcceptExpiryTimeConfigResult;
import id.dana.data.config.source.split.SplitConfigEntityData;
import id.dana.data.content.SpaceCode;
import id.dana.data.content.mapper.ContentMapper;
import id.dana.data.content.mapper.ContentsMapper;
import id.dana.data.content.source.ContentDeliveryEntityData;
import id.dana.data.content.source.ContentDeliveryEntityDataFactory;
import id.dana.data.content.source.network.result.SpaceRpcResult;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.promotion.repository.source.PromoEntityData;
import id.dana.data.promotion.repository.source.persistence.PromoEntityDataFactory;
import id.dana.data.security.source.SecurityEntityData;
import id.dana.data.security.source.SecurityEntityDataFactory;
import id.dana.data.sendmoney.AddPayMethodConfigEntityData;
import id.dana.data.sendmoney.BillerX2BEntityData;
import id.dana.data.sendmoney.DigitalMoneyEntityData;
import id.dana.data.sendmoney.SendMoneyEntityData;
import id.dana.data.sendmoney.mapper.BizOTCTransferInitMapper;
import id.dana.data.sendmoney.mapper.BizTransferInitMapper;
import id.dana.data.sendmoney.mapper.SendMoneyMapper;
import id.dana.data.sendmoney.mapper.SendMoneyScenariosMapper;
import id.dana.data.sendmoney.mapper.TransferInitParamRequestMapper;
import id.dana.data.sendmoney.mapper.TransferOTCSubmitRequestMapper;
import id.dana.data.sendmoney.mapper.TransferOrderCreateMapper;
import id.dana.data.sendmoney.mapper.TransferPrePayMapper;
import id.dana.data.sendmoney.mapper.TransferSubmitParamMapper;
import id.dana.data.sendmoney.mapper.WithdrawInitMapper;
import id.dana.data.sendmoney.mapper.WithdrawNameCheckMapper;
import id.dana.data.sendmoney.model.BillerX2BEntityKt;
import id.dana.data.sendmoney.model.DigitalMoneyEntityKt;
import id.dana.data.sendmoney.model.SendMoneyScenarioEntity;
import id.dana.data.sendmoney.model.TransferSubmitParam;
import id.dana.data.sendmoney.model.WithdrawChannelInfoEntityKt;
import id.dana.data.sendmoney.repository.source.AddPayMethodConfigFactory;
import id.dana.data.sendmoney.repository.source.BillerX2BEntityDataFactory;
import id.dana.data.sendmoney.repository.source.DigitalMoneyEntityDataFactory;
import id.dana.data.sendmoney.repository.source.SendMoneyDataFactory;
import id.dana.data.sendmoney.repository.source.SendMoneyPreferenceEntityDataFactory;
import id.dana.data.sendmoney.repository.source.SendMoneyScenariosConfigEntityDataFactory;
import id.dana.data.sendmoney.repository.source.SendMoneyScenariosEntityData;
import id.dana.data.sendmoney.repository.source.SortingSendMoneyPreferenceEntityDataFactory;
import id.dana.data.sendmoney.repository.source.local.PreferenceSendMoneyEntityData;
import id.dana.data.sendmoney.repository.source.local.PreferenceSortingSendMoneyEntityData;
import id.dana.data.sendmoney.repository.source.network.request.BizTransferPrePayRequest;
import id.dana.data.sendmoney.repository.source.network.request.TransferInitRequest;
import id.dana.data.sendmoney.repository.source.network.request.TransferOTCInitRequest;
import id.dana.data.sendmoney.repository.source.network.request.WithdrawInitRequest;
import id.dana.data.sendmoney.repository.source.network.result.BizGroupModifyEntityResult;
import id.dana.data.sendmoney.repository.source.network.result.BizTransferInitResult;
import id.dana.data.sendmoney.repository.source.network.result.BizTransferOrderCreateResult;
import id.dana.data.sendmoney.repository.source.network.result.BizTransferPrePayResult;
import id.dana.data.sendmoney.repository.source.network.result.SendMoneyInitResult;
import id.dana.data.sendmoney.repository.source.network.result.SendMoneyResult;
import id.dana.data.sendmoney.repository.source.network.result.WithdrawInitResult;
import id.dana.data.sendmoney.repository.source.network.result.WithdrawNameCheckResult;
import id.dana.data.util.ConfigUtil;
import id.dana.domain.geocode.GeocodeRepository;
import id.dana.domain.geocode.model.LocationSubdisivision;
import id.dana.domain.promotion.CdpContent;
import id.dana.domain.sendmoney.model.AddPayMethod;
import id.dana.domain.sendmoney.model.BillerX2B;
import id.dana.domain.sendmoney.model.DigitalMoney;
import id.dana.domain.sendmoney.model.NameCheckParam;
import id.dana.domain.sendmoney.model.OTCTransferInit;
import id.dana.domain.sendmoney.model.SendMoneyConfirm;
import id.dana.domain.sendmoney.model.SendMoneyConfirmOTCParam;
import id.dana.domain.sendmoney.model.SendMoneyConfirmParam;
import id.dana.domain.sendmoney.model.SendMoneyInit;
import id.dana.domain.sendmoney.model.SendMoneyScenario;
import id.dana.domain.sendmoney.model.TransferInit;
import id.dana.domain.sendmoney.model.TransferInitParam;
import id.dana.domain.sendmoney.model.TransferPrepay;
import id.dana.domain.sendmoney.model.WithdrawChannelInfoData;
import id.dana.domain.sendmoney.model.WithdrawInit;
import id.dana.domain.sendmoney.model.WithdrawNameCheck;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.mixed.CompletableAndThenObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.functions.Function1;

@Singleton
/* loaded from: classes2.dex */
public class SendMoneyEntityRepository implements SendMoneyRepository {
    private final AddPayMethodConfigFactory addPayMethodConfigFactory;
    private final BillerX2BEntityDataFactory billerX2BEntityDataFactory;
    private final BizOTCTransferInitMapper bizOTCTransferInitMapper;
    private BizTransferInitMapper bizTransferInitMapper;
    private final CardCredentialEntityRepository cardCredentialEntityRepository;
    private final ConfigEntityDataFactory configEntityDataFactory;
    private ContentDeliveryEntityDataFactory contentDeliveryEntityDataFactory;
    private ContentsMapper contentsMapper;
    private final DeviceInformationProvider deviceInformationProvider;
    private final DigitalMoneyEntityDataFactory digitalMoneyDataFactory;
    private GeocodeRepository geocodeRepository;
    private final HoldLoginV1EntityRepository holdLoginV1EntityRepository;
    private ContentMapper mapper;
    private final PromoEntityDataFactory promoEntityDataFactory;
    private final SecurityEntityDataFactory securityEntityDataFactory;
    private final SendMoneyDataFactory sendMoneyDataFactory;
    private SendMoneyMapper sendMoneyMapper;
    private final SendMoneyPreferenceEntityDataFactory sendMoneyPreferenceEntityDataFactory;
    private final SendMoneyScenariosConfigEntityDataFactory sendMoneyScenariosConfigEntityDataFactory;
    private SendMoneyScenariosMapper sendMoneyScenariosMapper;
    private final SortingSendMoneyPreferenceEntityDataFactory sortingSendMoneyPreferenceEntityDataFactory;
    private SplitConfigEntityData splitConfigEntityData;
    private TransferInitParamRequestMapper transferInitParamRequestMapper;
    private final TransferOTCSubmitRequestMapper transferOTCSubmitRequestMapper;
    private TransferOrderCreateMapper transferOrderCreateMapper;
    private TransferPrePayMapper transferPrePayMapper;
    private TransferSubmitParamMapper transferSubmitParamMapper;
    private WithdrawInitMapper withdrawInitMapper;
    private WithdrawNameCheckMapper withdrawNameCheckMapper;

    @Inject
    public SendMoneyEntityRepository(SendMoneyDataFactory sendMoneyDataFactory, DeviceInformationProvider deviceInformationProvider, AddPayMethodConfigFactory addPayMethodConfigFactory, TransferOTCSubmitRequestMapper transferOTCSubmitRequestMapper, ConfigEntityDataFactory configEntityDataFactory, BizOTCTransferInitMapper bizOTCTransferInitMapper, WithdrawInitMapper withdrawInitMapper, SendMoneyScenariosConfigEntityDataFactory sendMoneyScenariosConfigEntityDataFactory, PromoEntityDataFactory promoEntityDataFactory, DigitalMoneyEntityDataFactory digitalMoneyEntityDataFactory, SecurityEntityDataFactory securityEntityDataFactory, SendMoneyPreferenceEntityDataFactory sendMoneyPreferenceEntityDataFactory, SortingSendMoneyPreferenceEntityDataFactory sortingSendMoneyPreferenceEntityDataFactory, SplitConfigEntityData splitConfigEntityData, BillerX2BEntityDataFactory billerX2BEntityDataFactory, GeocodeRepository geocodeRepository, HoldLoginV1EntityRepository holdLoginV1EntityRepository, CardCredentialEntityRepository cardCredentialEntityRepository) {
        this.sendMoneyDataFactory = sendMoneyDataFactory;
        this.deviceInformationProvider = deviceInformationProvider;
        this.addPayMethodConfigFactory = addPayMethodConfigFactory;
        this.transferOTCSubmitRequestMapper = transferOTCSubmitRequestMapper;
        this.configEntityDataFactory = configEntityDataFactory;
        this.bizOTCTransferInitMapper = bizOTCTransferInitMapper;
        this.withdrawInitMapper = withdrawInitMapper;
        this.sendMoneyScenariosConfigEntityDataFactory = sendMoneyScenariosConfigEntityDataFactory;
        this.promoEntityDataFactory = promoEntityDataFactory;
        this.digitalMoneyDataFactory = digitalMoneyEntityDataFactory;
        this.securityEntityDataFactory = securityEntityDataFactory;
        this.sendMoneyPreferenceEntityDataFactory = sendMoneyPreferenceEntityDataFactory;
        this.sortingSendMoneyPreferenceEntityDataFactory = sortingSendMoneyPreferenceEntityDataFactory;
        this.splitConfigEntityData = splitConfigEntityData;
        this.billerX2BEntityDataFactory = billerX2BEntityDataFactory;
        this.geocodeRepository = geocodeRepository;
        this.holdLoginV1EntityRepository = holdLoginV1EntityRepository;
        this.cardCredentialEntityRepository = cardCredentialEntityRepository;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public void injectMapperDependencies(SendMoneyMapper sendMoneyMapper, BizTransferInitMapper bizTransferInitMapper, WithdrawNameCheckMapper withdrawNameCheckMapper, TransferSubmitParamMapper transferSubmitParamMapper, TransferPrePayMapper transferPrePayMapper, ContentsMapper contentsMapper, TransferInitParamRequestMapper transferInitParamRequestMapper, SendMoneyScenariosMapper sendMoneyScenariosMapper, TransferOrderCreateMapper transferOrderCreateMapper) {
        this.sendMoneyMapper = sendMoneyMapper;
        this.bizTransferInitMapper = bizTransferInitMapper;
        this.withdrawNameCheckMapper = withdrawNameCheckMapper;
        this.transferSubmitParamMapper = transferSubmitParamMapper;
        this.transferInitParamRequestMapper = transferInitParamRequestMapper;
        this.transferPrePayMapper = transferPrePayMapper;
        this.contentsMapper = contentsMapper;
        this.sendMoneyScenariosMapper = sendMoneyScenariosMapper;
        this.transferOrderCreateMapper = transferOrderCreateMapper;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public void injectCdpDependencies(ContentDeliveryEntityDataFactory contentDeliveryEntityDataFactory, ContentMapper contentMapper) {
        this.contentDeliveryEntityDataFactory = contentDeliveryEntityDataFactory;
        this.mapper = contentMapper;
    }

    @Override // id.dana.domain.sendmoney.repository.SendMoneyRepository
    public Observable<SendMoneyInit> getSendMoneyOption() {
        Observable authenticatedRequest = this.holdLoginV1EntityRepository.authenticatedRequest(createSendMoneyData().init());
        Observable<List<AddPayMethod>> addPayMethodConfig = getAddPayMethodConfig();
        final SendMoneyMapper sendMoneyMapper = this.sendMoneyMapper;
        Objects.requireNonNull(sendMoneyMapper);
        return authenticatedRequest.zipWith(addPayMethodConfig, new BiFunction() { // from class: id.dana.data.sendmoney.repository.SendMoneyEntityRepository$$ExternalSyntheticLambda28
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return SendMoneyMapper.this.transform((SendMoneyInitResult) obj, (List) obj2);
            }
        });
    }

    @Override // id.dana.domain.sendmoney.repository.SendMoneyRepository
    public Observable<SendMoneyInit> sendMoneyInit(String str, String str2, String str3) {
        Observable authenticatedRequest = this.holdLoginV1EntityRepository.authenticatedRequest(createSendMoneyData().init(str, str2, str3));
        final SendMoneyMapper sendMoneyMapper = this.sendMoneyMapper;
        Objects.requireNonNull(sendMoneyMapper);
        return authenticatedRequest.map(new Function() { // from class: id.dana.data.sendmoney.repository.SendMoneyEntityRepository$$ExternalSyntheticLambda25
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SendMoneyMapper.this.transform((SendMoneyInitResult) obj);
            }
        });
    }

    @Override // id.dana.domain.sendmoney.repository.SendMoneyRepository
    public Observable<TransferPrepay> initPrePay(final String str, final String str2) {
        Observable authenticatedRequest = this.holdLoginV1EntityRepository.authenticatedRequest(this.geocodeRepository.getLatestSubdivisions().switchMap(new Function() { // from class: id.dana.data.sendmoney.repository.SendMoneyEntityRepository$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SendMoneyEntityRepository.this.m1909xf232b389(str, str2, (LocationSubdisivision) obj);
            }
        }));
        final TransferPrePayMapper transferPrePayMapper = this.transferPrePayMapper;
        Objects.requireNonNull(transferPrePayMapper);
        return authenticatedRequest.map(new Function() { // from class: id.dana.data.sendmoney.repository.SendMoneyEntityRepository$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return TransferPrePayMapper.this.apply((BizTransferPrePayResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$initPrePay$0$id-dana-data-sendmoney-repository-SendMoneyEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1909xf232b389(String str, String str2, LocationSubdisivision locationSubdisivision) throws Exception {
        return createSendMoneyData().initPrePay(new BizTransferPrePayRequest(str, str2), locationSubdisivision.getIndoSubdivisions().getCityName());
    }

    @Override // id.dana.domain.sendmoney.repository.SendMoneyRepository
    public Observable<SendMoneyConfirm> sendMoney(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, final boolean z, final String str8) {
        Observable<R> flatMap = this.holdLoginV1EntityRepository.createAccountData().getAccount().flatMap(new Function() { // from class: id.dana.data.sendmoney.repository.SendMoneyEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SendMoneyEntityRepository.this.m1913x55522e93(str, str2, str3, str4, str5, str6, str7, z, str8, (AccountEntity) obj);
            }
        });
        SendMoneyMapper sendMoneyMapper = this.sendMoneyMapper;
        Objects.requireNonNull(sendMoneyMapper);
        return flatMap.map(new SendMoneyEntityRepository$$ExternalSyntheticLambda27(sendMoneyMapper));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$sendMoney$1$id-dana-data-sendmoney-repository-SendMoneyEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1913x55522e93(String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z, String str8, AccountEntity accountEntity) throws Exception {
        return this.holdLoginV1EntityRepository.authenticatedRequest(createSendMoneyData().confirm(this.deviceInformationProvider.getDeviceUUID(), str, str2, accountEntity.getAvatarUrl(), accountEntity.getNickname(), str3, str4, str5, str6, str7, z, str8));
    }

    @Override // id.dana.domain.sendmoney.repository.SendMoneyRepository
    public Observable<TransferInit> getTransferOption(String str) {
        TransferInitRequest transferInitRequest = new TransferInitRequest();
        transferInitRequest.setNeedTransferMethod(true);
        transferInitRequest.setNeedPayMethod(true);
        transferInitRequest.setNeedWithdrawMethod(true);
        HoldLoginV1EntityRepository holdLoginV1EntityRepository = this.holdLoginV1EntityRepository;
        Observable<BizTransferInitResult> bizInit = bizInit(transferInitRequest);
        final BizTransferInitMapper bizTransferInitMapper = this.bizTransferInitMapper;
        Objects.requireNonNull(bizTransferInitMapper);
        return holdLoginV1EntityRepository.authenticatedRequest(bizInit.map(new Function() { // from class: id.dana.data.sendmoney.repository.SendMoneyEntityRepository$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return BizTransferInitMapper.this.apply((BizTransferInitResult) obj);
            }
        }));
    }

    @Override // id.dana.domain.sendmoney.repository.SendMoneyRepository
    public Observable<TransferInit> getPayMethod(String str) {
        TransferInitRequest transferInitRequest = new TransferInitRequest();
        transferInitRequest.setNeedTransferMethod(true);
        transferInitRequest.setNeedPayMethod(true);
        if ("OTC".equals(str)) {
            transferInitRequest.setNeedWithdrawMethod(true);
        }
        transferInitRequest.setTransferMethod(str);
        return this.holdLoginV1EntityRepository.authenticatedRequest(bizInit(transferInitRequest).zipWith(getAddPayMethodConfig(), new BiFunction() { // from class: id.dana.data.sendmoney.repository.SendMoneyEntityRepository$$ExternalSyntheticLambda29
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return SendMoneyEntityRepository.this.m1907xa44c1d89((BizTransferInitResult) obj, (List) obj2);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getPayMethod$2$id-dana-data-sendmoney-repository-SendMoneyEntityRepository  reason: not valid java name */
    public /* synthetic */ TransferInit m1907xa44c1d89(BizTransferInitResult bizTransferInitResult, List list) throws Exception {
        this.bizTransferInitMapper.setPayChannelFromAmcs(list);
        return this.bizTransferInitMapper.apply(bizTransferInitResult);
    }

    @Override // id.dana.domain.sendmoney.repository.SendMoneyRepository
    public Observable<TransferInit> transferInit(TransferInitParam transferInitParam) {
        return this.holdLoginV1EntityRepository.authenticatedRequest(bizInit(this.transferInitParamRequestMapper.map(transferInitParam)).zipWith(getAddPayMethodConfig(), new BiFunction() { // from class: id.dana.data.sendmoney.repository.SendMoneyEntityRepository$$ExternalSyntheticLambda23
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return SendMoneyEntityRepository.this.m1914xeebbeab2((BizTransferInitResult) obj, (List) obj2);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$transferInit$3$id-dana-data-sendmoney-repository-SendMoneyEntityRepository  reason: not valid java name */
    public /* synthetic */ TransferInit m1914xeebbeab2(BizTransferInitResult bizTransferInitResult, List list) throws Exception {
        this.bizTransferInitMapper.setPayChannelFromAmcs(list);
        return this.bizTransferInitMapper.apply(bizTransferInitResult);
    }

    @Override // id.dana.domain.sendmoney.repository.SendMoneyRepository
    public Observable<OTCTransferInit> transferOTCInit(String str, String str2) {
        TransferOTCInitRequest transferOTCInitRequest = new TransferOTCInitRequest();
        transferOTCInitRequest.setNeedTransferMethod(true);
        transferOTCInitRequest.setAmount(str);
        transferOTCInitRequest.setFundType(str2);
        return this.holdLoginV1EntityRepository.authenticatedRequest(Observable.zip(bizInitOtc(transferOTCInitRequest), getAddPayMethodConfig(), getOtcAcceptExpiryTimeConfig(), new Function3() { // from class: id.dana.data.sendmoney.repository.SendMoneyEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function3
            public final Object apply(Object obj, Object obj2, Object obj3) {
                return SendMoneyEntityRepository.this.m1915xa6822961((BizTransferInitResult) obj, (List) obj2, (OTCAcceptExpiryTimeConfigResult) obj3);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$transferOTCInit$4$id-dana-data-sendmoney-repository-SendMoneyEntityRepository  reason: not valid java name */
    public /* synthetic */ OTCTransferInit m1915xa6822961(BizTransferInitResult bizTransferInitResult, List list, OTCAcceptExpiryTimeConfigResult oTCAcceptExpiryTimeConfigResult) throws Exception {
        this.bizOTCTransferInitMapper.setPayChannelFromAmcs(list);
        this.bizOTCTransferInitMapper.setAcceptExpiryTimeValue(oTCAcceptExpiryTimeConfigResult.getValue());
        this.bizOTCTransferInitMapper.setAcceptExpiryTimeUnit(oTCAcceptExpiryTimeConfigResult.getUnit());
        return this.bizOTCTransferInitMapper.apply(bizTransferInitResult);
    }

    @Override // id.dana.domain.sendmoney.repository.SendMoneyRepository
    public Observable<WithdrawInit> withdrawInit(Boolean bool, String str) {
        WithdrawInitRequest withdrawInitRequest = new WithdrawInitRequest(bool, str);
        HoldLoginV1EntityRepository holdLoginV1EntityRepository = this.holdLoginV1EntityRepository;
        Observable<WithdrawInitResult> withdrawInit = withdrawInit(withdrawInitRequest);
        final WithdrawInitMapper withdrawInitMapper = this.withdrawInitMapper;
        Objects.requireNonNull(withdrawInitMapper);
        return holdLoginV1EntityRepository.authenticatedRequest(withdrawInit.map(new Function() { // from class: id.dana.data.sendmoney.repository.SendMoneyEntityRepository$$ExternalSyntheticLambda26
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return WithdrawInitMapper.this.apply((WithdrawInitResult) obj);
            }
        }));
    }

    @Override // id.dana.domain.sendmoney.repository.SendMoneyRepository
    public Observable<WithdrawNameCheck> nameCheck(final NameCheckParam nameCheckParam) {
        HoldLoginV1EntityRepository holdLoginV1EntityRepository = this.holdLoginV1EntityRepository;
        Observable<R> flatMap = this.splitConfigEntityData.isEncryptCardEnabled().flatMap(new Function() { // from class: id.dana.data.sendmoney.repository.SendMoneyEntityRepository$$ExternalSyntheticLambda14
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SendMoneyEntityRepository.this.m1911xca2cb17d(nameCheckParam, (Boolean) obj);
            }
        });
        final WithdrawNameCheckMapper withdrawNameCheckMapper = this.withdrawNameCheckMapper;
        Objects.requireNonNull(withdrawNameCheckMapper);
        return holdLoginV1EntityRepository.authenticatedRequest(flatMap.map(new Function() { // from class: id.dana.data.sendmoney.repository.SendMoneyEntityRepository$$ExternalSyntheticLambda15
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return WithdrawNameCheckMapper.this.apply((WithdrawNameCheckResult) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$nameCheck$6$id-dana-data-sendmoney-repository-SendMoneyEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1911xca2cb17d(final NameCheckParam nameCheckParam, final Boolean bool) throws Exception {
        return getCardCredentialKey().flatMap(new Function() { // from class: id.dana.data.sendmoney.repository.SendMoneyEntityRepository$$ExternalSyntheticLambda22
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SendMoneyEntityRepository.this.m1910xfb710fc(nameCheckParam, bool, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$nameCheck$5$id-dana-data-sendmoney-repository-SendMoneyEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1910xfb710fc(NameCheckParam nameCheckParam, Boolean bool, String str) throws Exception {
        return createSendMoneyData().nameCheck(nameCheckParam, str, bool);
    }

    @Override // id.dana.domain.sendmoney.repository.SendMoneyRepository
    public Observable<SendMoneyConfirm> confirmSendMoney(SendMoneyConfirmParam sendMoneyConfirmParam) {
        if (sendMoneyConfirmParam == null) {
            return Observable.error(new NoSuchElementException());
        }
        TransferSubmitParam apply = this.transferSubmitParamMapper.apply(sendMoneyConfirmParam);
        apply.setRequestId(this.deviceInformationProvider.getDeviceUUID());
        HoldLoginV1EntityRepository holdLoginV1EntityRepository = this.holdLoginV1EntityRepository;
        Observable<SendMoneyResult> transferSubmit = createSendMoneyData().transferSubmit(apply);
        SendMoneyMapper sendMoneyMapper = this.sendMoneyMapper;
        Objects.requireNonNull(sendMoneyMapper);
        return holdLoginV1EntityRepository.authenticatedRequest(transferSubmit.map(new SendMoneyEntityRepository$$ExternalSyntheticLambda27(sendMoneyMapper)));
    }

    @Override // id.dana.domain.sendmoney.repository.SendMoneyRepository
    public Observable<SendMoneyConfirm> confirmSendMoneyOTC(SendMoneyConfirmOTCParam sendMoneyConfirmOTCParam) {
        if (sendMoneyConfirmOTCParam == null) {
            return Observable.error(new NoSuchElementException());
        }
        HoldLoginV1EntityRepository holdLoginV1EntityRepository = this.holdLoginV1EntityRepository;
        Observable<SendMoneyResult> transferOTCSubmit = createSendMoneyData().transferOTCSubmit(this.transferOTCSubmitRequestMapper.apply(sendMoneyConfirmOTCParam, this.deviceInformationProvider.getDeviceUUID()));
        SendMoneyMapper sendMoneyMapper = this.sendMoneyMapper;
        Objects.requireNonNull(sendMoneyMapper);
        return holdLoginV1EntityRepository.authenticatedRequest(transferOTCSubmit.map(new SendMoneyEntityRepository$$ExternalSyntheticLambda27(sendMoneyMapper)));
    }

    @Override // id.dana.domain.sendmoney.repository.SendMoneyRepository
    public Observable<CdpContent> getSendMoneyBanner() {
        Observable authenticatedRequest = this.holdLoginV1EntityRepository.authenticatedRequest(createContentDelivery().get(SpaceCode.SEND_MONEY_BANNER));
        final ContentMapper contentMapper = this.mapper;
        Objects.requireNonNull(contentMapper);
        return authenticatedRequest.map(new Function() { // from class: id.dana.data.sendmoney.repository.SendMoneyEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ContentMapper.this.apply((SpaceRpcResult) obj);
            }
        });
    }

    @Override // id.dana.domain.sendmoney.repository.SendMoneyRepository
    public Observable<List<CdpContent>> getSendMoneyVendorLogo() {
        Observable authenticatedRequest = this.holdLoginV1EntityRepository.authenticatedRequest(createContentDelivery().get(SpaceCode.SEND_MONEY_VENDOR_LOGO));
        final ContentsMapper contentsMapper = this.contentsMapper;
        Objects.requireNonNull(contentsMapper);
        return authenticatedRequest.map(new Function() { // from class: id.dana.data.sendmoney.repository.SendMoneyEntityRepository$$ExternalSyntheticLambda24
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ContentsMapper.this.apply((SpaceRpcResult) obj);
            }
        });
    }

    @Override // id.dana.domain.sendmoney.repository.SendMoneyRepository
    public Observable<List<SendMoneyScenario>> getSendMoneyScenarios() {
        Observable onErrorResumeNext = ConfigUtil.getConfigFallback(new SendMoneyScenariosEntityData[]{createSplitSendMoneyScenarioCategories()}, new Function1() { // from class: id.dana.data.sendmoney.repository.SendMoneyEntityRepository$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ((SendMoneyScenariosEntityData) obj).getSendMoneyScenarios();
            }
        }).onErrorResumeNext(emptySendMoneyScenarios()).flatMap(getSendMoneyDefaultScenarios()).onErrorResumeNext(emptySendMoneyScenarios());
        final SendMoneyScenariosMapper sendMoneyScenariosMapper = this.sendMoneyScenariosMapper;
        Objects.requireNonNull(sendMoneyScenariosMapper);
        return onErrorResumeNext.map(new Function() { // from class: id.dana.data.sendmoney.repository.SendMoneyEntityRepository$$ExternalSyntheticLambda11
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SendMoneyScenariosMapper.this.apply((List) obj);
            }
        });
    }

    @Override // id.dana.domain.sendmoney.repository.SendMoneyRepository
    public Observable<List<DigitalMoney>> getEWalletsBankAccountPrefix() {
        return ConfigUtil.getConfigFallback(new DigitalMoneyEntityData[]{createSplitDigitalMoneyData(), createLocalDigitalMoneyData()}, new Function1() { // from class: id.dana.data.sendmoney.repository.SendMoneyEntityRepository$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ((DigitalMoneyEntityData) obj).getEWalletPrefix();
            }
        }).map(new Function() { // from class: id.dana.data.sendmoney.repository.SendMoneyEntityRepository$$ExternalSyntheticLambda13
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return DigitalMoneyEntityKt.toDigitalMoneyList((List) obj);
            }
        });
    }

    @Override // id.dana.domain.sendmoney.repository.SendMoneyRepository
    public Observable<Boolean> isNeedToShowExternalOnboardingDialog() {
        return createPreferenceSendMoneyEntityData().isNeedToShowExternalOnboardingDialog();
    }

    @Override // id.dana.domain.sendmoney.repository.SendMoneyRepository
    public Observable<Boolean> saveIsNeedToShowExternalOnboardingDialog(Boolean bool) {
        return createPreferenceSendMoneyEntityData().saveIsNeedToShowExternalOnboardingDialog(bool.booleanValue());
    }

    @Override // id.dana.domain.sendmoney.repository.SendMoneyRepository
    public Observable<String> getSortingSendMoney() {
        return createPreferenceSortingSendMoneyEntityData().getSortingSendMoney();
    }

    @Override // id.dana.domain.sendmoney.repository.SendMoneyRepository
    public Observable<Boolean> saveSortingSendMoney(String str) {
        return createPreferenceSortingSendMoneyEntityData().saveSortingSendMoney(str);
    }

    @Override // id.dana.domain.sendmoney.repository.SendMoneyRepository
    public Observable<Boolean> saveStateSendMoneyShareFeed(String str) {
        return createPreferenceSendMoneyEntityData().saveStateSendMoneyShareFeed(str);
    }

    @Override // id.dana.domain.sendmoney.repository.SendMoneyRepository
    public Observable<String> getStateSendMoneyShareFeed() {
        return createPreferenceSendMoneyEntityData().getStateSendMoneyShareFeed();
    }

    @Override // id.dana.domain.sendmoney.repository.SendMoneyRepository
    public Observable<List<BillerX2B>> getAllBillerX2B() {
        return ConfigUtil.getConfigFallback(new BillerX2BEntityData[]{createSplitBillerX2BEntityData(), createDefaultBillerX2BEntityData()}, new Function1() { // from class: id.dana.data.sendmoney.repository.SendMoneyEntityRepository$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ((BillerX2BEntityData) obj).getListBillerX2B();
            }
        }).map(new Function() { // from class: id.dana.data.sendmoney.repository.SendMoneyEntityRepository$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return BillerX2BEntityKt.toBillerX2BList((List) obj);
            }
        });
    }

    @Override // id.dana.domain.sendmoney.repository.SendMoneyRepository
    public Observable<List<WithdrawChannelInfoData>> getWithdrawChannelInfoData() {
        return createSplitConfigData().getWithdrawChannelInfoConfig().map(new Function() { // from class: id.dana.data.sendmoney.repository.SendMoneyEntityRepository$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return WithdrawChannelInfoEntityKt.toWithdrawChannelInfoDatas((List) obj);
            }
        });
    }

    @Override // id.dana.domain.sendmoney.repository.SendMoneyRepository
    public Observable<SendMoneyConfirm> confirmSendMoneyToBank(SendMoneyConfirmParam sendMoneyConfirmParam) {
        if (sendMoneyConfirmParam == null) {
            return Observable.error(new NoSuchElementException());
        }
        if (Boolean.TRUE.equals(Boolean.valueOf(this.splitConfigEntityData.getFeatureSendMoneyAddOn().blockingFirst().getEnable())) && Objects.equals(sendMoneyConfirmParam.getTransferMethod(), "BANK_TRANSFER")) {
            Observable authenticatedRequest = this.holdLoginV1EntityRepository.authenticatedRequest(createSendMoneyData().transferCreateOrder(this.transferOrderCreateMapper.transform(sendMoneyConfirmParam)));
            final TransferOrderCreateMapper transferOrderCreateMapper = this.transferOrderCreateMapper;
            Objects.requireNonNull(transferOrderCreateMapper);
            return authenticatedRequest.map(new Function() { // from class: id.dana.data.sendmoney.repository.SendMoneyEntityRepository$$ExternalSyntheticLambda20
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return TransferOrderCreateMapper.this.transform((BizTransferOrderCreateResult) obj);
                }
            });
        }
        TransferSubmitParam apply = this.transferSubmitParamMapper.apply(sendMoneyConfirmParam);
        apply.setRequestId(this.deviceInformationProvider.getDeviceUUID());
        HoldLoginV1EntityRepository holdLoginV1EntityRepository = this.holdLoginV1EntityRepository;
        Observable<SendMoneyResult> transferSubmit = createSendMoneyData().transferSubmit(apply);
        SendMoneyMapper sendMoneyMapper = this.sendMoneyMapper;
        Objects.requireNonNull(sendMoneyMapper);
        return holdLoginV1EntityRepository.authenticatedRequest(transferSubmit.map(new SendMoneyEntityRepository$$ExternalSyntheticLambda27(sendMoneyMapper)));
    }

    @Override // id.dana.domain.sendmoney.repository.SendMoneyRepository
    public Observable<String> deleteGroup(String str) {
        return this.holdLoginV1EntityRepository.authenticatedRequest(createSendMoneyData().deleteGroup(str)).map(new Function() { // from class: id.dana.data.sendmoney.repository.SendMoneyEntityRepository$$ExternalSyntheticLambda30
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ((BizGroupModifyEntityResult) obj).getGroupId();
            }
        });
    }

    @Override // id.dana.domain.sendmoney.repository.SendMoneyRepository
    public Observable<Boolean> saveStateSuspiciousAccountSmartFriction(boolean z) {
        return createPreferenceSendMoneyEntityData().saveIsNeedToShowSuspiciousAccountSmartFriction(z);
    }

    @Override // id.dana.domain.sendmoney.repository.SendMoneyRepository
    public Observable<Boolean> getStateSuspiciousAccountSmartFriction() {
        return createPreferenceSendMoneyEntityData().getIsNeedToShowSuspiciousAccountSmartFriction();
    }

    @Override // id.dana.domain.sendmoney.repository.SendMoneyRepository
    public Observable<Boolean> saveIsUserCertifiedGlobalSend() {
        return createPreferenceSendMoneyEntityData().saveIsUserCertifiedGlobalSend();
    }

    @Override // id.dana.domain.sendmoney.repository.SendMoneyRepository
    public Observable<Boolean> getIsUserCertifiedGlobalSend() {
        return createPreferenceSendMoneyEntityData().getIsUserCertifiedGlobalSend();
    }

    private Observable<OTCAcceptExpiryTimeConfigResult> getOtcAcceptExpiryTimeConfig() {
        return createSplitConfigData().getOTCExpiryConfig();
    }

    private SecurityEntityData createSecurityData() {
        return this.securityEntityDataFactory.createData2("network");
    }

    private Observable<String> getCardCredentialKey() {
        return this.cardCredentialEntityRepository.getCardCredentialPublicKey();
    }

    private DigitalMoneyEntityData createSplitDigitalMoneyData() {
        return this.digitalMoneyDataFactory.createData2("split");
    }

    private DigitalMoneyEntityData createLocalDigitalMoneyData() {
        return this.digitalMoneyDataFactory.createData2("local");
    }

    private Observable<BizTransferInitResult> bizInit(TransferInitRequest transferInitRequest) {
        return createSendMoneyData().bizInit(transferInitRequest).flatMap(saveBankFreeTransferCount());
    }

    private Observable<BizTransferInitResult> bizInitOtc(TransferOTCInitRequest transferOTCInitRequest) {
        return createSendMoneyData().bizOTCInit(transferOTCInitRequest).flatMap(saveBankFreeTransferCount());
    }

    private Observable<WithdrawInitResult> withdrawInit(WithdrawInitRequest withdrawInitRequest) {
        return createSendMoneyData().withdrawInit(withdrawInitRequest);
    }

    private Function<BizTransferInitResult, Observable<BizTransferInitResult>> saveBankFreeTransferCount() {
        return new Function() { // from class: id.dana.data.sendmoney.repository.SendMoneyEntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SendMoneyEntityRepository.this.m1912x746e3fc0((BizTransferInitResult) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$saveBankFreeTransferCount$7$id-dana-data-sendmoney-repository-SendMoneyEntityRepository  reason: not valid java name */
    public /* synthetic */ Observable m1912x746e3fc0(BizTransferInitResult bizTransferInitResult) throws Exception {
        Completable freeTransferCount = getLocalPromoDataEntity().setFreeTransferCount("BANK_TRANSFER", bizTransferInitResult.getFreeBankTransferCount("BANK_TRANSFER"));
        Observable just = Observable.just(bizTransferInitResult);
        ObjectHelper.PlaceComponentResult(just, "next is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new CompletableAndThenObservable(freeTransferCount, just));
    }

    private PromoEntityData getLocalPromoDataEntity() {
        return this.promoEntityDataFactory.createData2("local");
    }

    private Function<Throwable, ObservableSource<List<SendMoneyScenarioEntity>>> emptySendMoneyScenarios() {
        return new Function() { // from class: id.dana.data.sendmoney.repository.SendMoneyEntityRepository$$ExternalSyntheticLambda21
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SendMoneyEntityRepository.lambda$emptySendMoneyScenarios$8((Throwable) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ObservableSource lambda$emptySendMoneyScenarios$8(Throwable th) throws Exception {
        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.SEND_MONEY_TAG, th.getMessage(), th);
        return Observable.just(Collections.emptyList());
    }

    private Function<List<SendMoneyScenarioEntity>, ObservableSource<List<SendMoneyScenarioEntity>>> getSendMoneyDefaultScenarios() {
        return new Function() { // from class: id.dana.data.sendmoney.repository.SendMoneyEntityRepository$$ExternalSyntheticLambda19
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SendMoneyEntityRepository.this.m1908xd2c9bf81((List) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getSendMoneyDefaultScenarios$9$id-dana-data-sendmoney-repository-SendMoneyEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1908xd2c9bf81(List list) throws Exception {
        if (list.isEmpty()) {
            return createDefaultSendMoneyScenarioCategories().getSendMoneyScenarios();
        }
        return Observable.just(list);
    }

    private SendMoneyScenariosEntityData createSplitSendMoneyScenarioCategories() {
        return this.sendMoneyScenariosConfigEntityDataFactory.createData2("split");
    }

    private SendMoneyScenariosEntityData createDefaultSendMoneyScenarioCategories() {
        return this.sendMoneyScenariosConfigEntityDataFactory.createData2("local");
    }

    private Observable<List<AddPayMethod>> getAddPayMethodConfig() {
        return this.holdLoginV1EntityRepository.authenticatedRequest(createAddPayMethodData("split").getAddPayMethodConfig()).onErrorResumeNext(new Function() { // from class: id.dana.data.sendmoney.repository.SendMoneyEntityRepository$$ExternalSyntheticLambda16
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource apply;
                apply = SendMoneyEntityRepository.this.apply((Throwable) obj);
                return apply;
            }
        }).map(new Function() { // from class: id.dana.data.sendmoney.repository.SendMoneyEntityRepository$$ExternalSyntheticLambda17
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ((Map) obj).entrySet();
            }
        }).map(new Function() { // from class: id.dana.data.sendmoney.repository.SendMoneyEntityRepository$$ExternalSyntheticLambda18
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SendMoneyEntityRepository.lambda$getAddPayMethodConfig$10((Set) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ List lambda$getAddPayMethodConfig$10(Set set) throws Exception {
        ArrayList arrayList = new ArrayList();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            arrayList.add((AddPayMethod) ((Map.Entry) it.next()).getValue());
        }
        return arrayList;
    }

    private ConfigEntityData createSplitConfigData() {
        return this.configEntityDataFactory.createData2("split");
    }

    private AddPayMethodConfigEntityData createAddPayMethodData(String str) {
        return this.addPayMethodConfigFactory.createData2(str);
    }

    private SendMoneyEntityData createSendMoneyData() {
        return this.sendMoneyDataFactory.createData2("network");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ObservableSource<? extends Map<String, AddPayMethod>> apply(Throwable th) {
        return createAddPayMethodData("local").getAddPayMethodConfig();
    }

    private ContentDeliveryEntityData createContentDelivery() {
        return this.contentDeliveryEntityDataFactory.createData2("network");
    }

    private PreferenceSendMoneyEntityData createPreferenceSendMoneyEntityData() {
        return this.sendMoneyPreferenceEntityDataFactory.createData2("local");
    }

    private PreferenceSortingSendMoneyEntityData createPreferenceSortingSendMoneyEntityData() {
        return this.sortingSendMoneyPreferenceEntityDataFactory.createData2("local");
    }

    private BillerX2BEntityData createSplitBillerX2BEntityData() {
        return this.billerX2BEntityDataFactory.createData2("split");
    }

    private BillerX2BEntityData createDefaultBillerX2BEntityData() {
        return this.billerX2BEntityDataFactory.createData2("local");
    }
}
