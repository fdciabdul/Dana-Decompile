package id.dana.cashier.mapper;

import id.dana.cashier.domain.model.AssetCard;
import id.dana.cashier.domain.model.Attribute;
import id.dana.cashier.domain.model.CashierOrderGood;
import id.dana.cashier.domain.model.IntlOrderInfoDTO;
import id.dana.cashier.domain.model.PayMethodFeeInfo;
import id.dana.cashier.domain.model.PayMethodViewDto;
import id.dana.cashier.domain.model.ProcessingMilestone;
import id.dana.cashier.domain.model.Risk3dsAdditionalData;
import id.dana.cashier.domain.model.RiskVerificationMethod;
import id.dana.cashier.model.AssetCardModel;
import id.dana.cashier.model.AssetCardModelKt;
import id.dana.cashier.model.AttributeCashierPayModel;
import id.dana.cashier.model.AttributeModel;
import id.dana.cashier.model.CashierOrderGoodModel;
import id.dana.cashier.model.CashierOrderGoodModelKt;
import id.dana.cashier.model.CashierPayChannelModel;
import id.dana.cashier.model.IntlOrderInfoDTOModelKt;
import id.dana.cashier.model.PayMethodFeeModel;
import id.dana.cashier.model.PayMethodFeeModelKt;
import id.dana.cashier.model.PayMethodViewDtoModel;
import id.dana.cashier.model.ProcessingMilestoneModel;
import id.dana.cashier.model.ProcessingMilestoneModelKt;
import id.dana.cashier.model.Risk3dsAdditionalDataModel;
import id.dana.cashier.model.Risk3dsAdditionalDataModelKt;
import id.dana.cashier.model.RiskVerificationMethodModel;
import id.dana.cashier.model.RiskVerificationMethodModelKt;
import id.dana.cashier.model.TransactionFeeViewModel;
import id.dana.cashier.model.TransactionFeeViewModelKt;
import id.dana.data.base.BaseMapper;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\b*\b\u0012\u0004\u0012\u00020\t0\bH\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000e"}, d2 = {"Lid/dana/cashier/mapper/AttributeModelMapper;", "Lid/dana/data/base/BaseMapper;", "Lid/dana/cashier/domain/model/Attribute;", "Lid/dana/cashier/model/AttributeModel;", "p0", "Lid/dana/cashier/model/AttributeCashierPayModel;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/cashier/domain/model/Attribute;)Lid/dana/cashier/model/AttributeCashierPayModel;", "", "Lid/dana/cashier/domain/model/PayMethodViewDto;", "Lid/dana/cashier/model/PayMethodViewDtoModel;", "PlaceComponentResult", "(Ljava/util/List;)Ljava/util/List;", "Lid/dana/cashier/mapper/CashierPayChannelModelsMapper;", "Lid/dana/cashier/mapper/CashierPayChannelModelsMapper;", "MyBillsEntityDataFactory", "<init>", "(Lid/dana/cashier/mapper/CashierPayChannelModelsMapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AttributeModelMapper extends BaseMapper<Attribute, AttributeModel> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final CashierPayChannelModelsMapper MyBillsEntityDataFactory;

    @Override // id.dana.data.base.BaseMapper
    public final /* synthetic */ AttributeModel map(Attribute attribute) {
        MoneyViewModel moneyViewModel;
        MoneyViewModel moneyViewModel2;
        LinkedHashMap linkedHashMap;
        MoneyViewModel moneyViewModel3;
        MoneyViewModel moneyViewModel4;
        MoneyViewModel moneyViewModel5;
        MoneyViewModel moneyViewModel6;
        MoneyViewModel moneyViewModel7;
        MoneyViewModel moneyViewModel8;
        MoneyViewModel moneyViewModel9;
        MoneyViewModel moneyViewModel10;
        MoneyViewModel moneyViewModel11;
        MoneyViewModel moneyViewModel12;
        MoneyViewModel moneyViewModel13;
        MoneyViewModel moneyViewModel14;
        Attribute attribute2 = attribute;
        if (attribute2 != null) {
            List<AssetCard> assetCards = attribute2.getAssetCards();
            List<AssetCardModel> MyBillsEntityDataFactory = assetCards != null ? AssetCardModelKt.MyBillsEntityDataFactory(assetCards) : null;
            String bizOrderId = attribute2.getBizOrderId();
            Boolean canSaveCC = attribute2.getCanSaveCC();
            List<String> cardSchemes = attribute2.getCardSchemes();
            List<CashierOrderGood> cashierOrderGoods = attribute2.getCashierOrderGoods();
            List<CashierOrderGoodModel> BuiltInFictitiousFunctionClassFactory = cashierOrderGoods != null ? CashierOrderGoodModelKt.BuiltInFictitiousFunctionClassFactory(cashierOrderGoods) : null;
            Boolean couponRejectedByRisk = attribute2.getCouponRejectedByRisk();
            String defaultOption = attribute2.getDefaultOption();
            String directDebitDescription = attribute2.getDirectDebitDescription();
            List<String> directDebitInstIds = attribute2.getDirectDebitInstIds();
            String directDebitTitle = attribute2.getDirectDebitTitle();
            Integer initialChannelNum = attribute2.getInitialChannelNum();
            Integer initialSavedCardNum = attribute2.getInitialSavedCardNum();
            Boolean isSupportMixPayment = attribute2.isSupportMixPayment();
            Boolean loginStatus = attribute2.getLoginStatus();
            String maskPhoneNumber = attribute2.getMaskPhoneNumber();
            String maskedLoginId = attribute2.getMaskedLoginId();
            String merchantLogoUrl = attribute2.getMerchantLogoUrl();
            String merchantName = attribute2.getMerchantName();
            String merchantReturnUrl = attribute2.getMerchantReturnUrl();
            String mainAppPayReturnUrl = attribute2.getMainAppPayReturnUrl();
            String mobileMerchantLogoUrl = attribute2.getMobileMerchantLogoUrl();
            String networkScenario = attribute2.getNetworkScenario();
            MoneyView orderAmount = attribute2.getOrderAmount();
            if (orderAmount != null) {
                MoneyViewModel.Companion companion = MoneyViewModel.INSTANCE;
                moneyViewModel = MoneyViewModel.Companion.PlaceComponentResult(orderAmount);
            } else {
                moneyViewModel = null;
            }
            String orderTitle = attribute2.getOrderTitle();
            List<? extends CashierPayChannelModel> apply = this.MyBillsEntityDataFactory.apply(attribute2.getPayChannels());
            List<String> paymentMethodOrder = attribute2.getPaymentMethodOrder();
            if (paymentMethodOrder == null) {
                paymentMethodOrder = CollectionsKt.emptyList();
            }
            List<String> list = paymentMethodOrder;
            String pcMerchantLogoUrl = attribute2.getPcMerchantLogoUrl();
            String promoMessage = attribute2.getPromoMessage();
            Boolean reachSaveCardLimit = attribute2.getReachSaveCardLimit();
            Integer saveCardLimitNumber = attribute2.getSaveCardLimitNumber();
            String pubKey = attribute2.getPubKey();
            Boolean showTutorialButton = attribute2.getShowTutorialButton();
            Boolean showAutorouteSwitch = attribute2.getShowAutorouteSwitch();
            String choosePaymentMethod = attribute2.getChoosePaymentMethod();
            String confirmPayment = attribute2.getConfirmPayment();
            MoneyView adminFeeAmount = attribute2.getAdminFeeAmount();
            if (adminFeeAmount != null) {
                MoneyViewModel.Companion companion2 = MoneyViewModel.INSTANCE;
                moneyViewModel2 = MoneyViewModel.Companion.PlaceComponentResult(adminFeeAmount);
            } else {
                moneyViewModel2 = null;
            }
            MoneyView tipAmount = attribute2.getTipAmount();
            MoneyViewModel.Companion companion3 = MoneyViewModel.INSTANCE;
            MoneyViewModel PlaceComponentResult = MoneyViewModel.Companion.PlaceComponentResult(tipAmount);
            TransactionFeeViewModel KClassImpl$Data$declaredNonStaticMembers$2 = TransactionFeeViewModelKt.KClassImpl$Data$declaredNonStaticMembers$2(attribute2.getTransactionFeeAmount());
            Map<String, MoneyView> payFeeChargeMap = attribute2.getPayFeeChargeMap();
            if (payFeeChargeMap != null) {
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(payFeeChargeMap.size()));
                Iterator it = payFeeChargeMap.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    Iterator it2 = it;
                    Object key = entry.getKey();
                    MoneyView moneyView = (MoneyView) entry.getValue();
                    MoneyViewModel.Companion companion4 = MoneyViewModel.INSTANCE;
                    linkedHashMap2.put(key, MoneyViewModel.Companion.PlaceComponentResult(moneyView));
                    it = it2;
                }
                linkedHashMap = linkedHashMap2;
            } else {
                linkedHashMap = null;
            }
            MoneyView totalAmount = attribute2.getTotalAmount();
            if (totalAmount != null) {
                MoneyViewModel.Companion companion5 = MoneyViewModel.INSTANCE;
                moneyViewModel3 = MoneyViewModel.Companion.PlaceComponentResult(totalAmount);
            } else {
                moneyViewModel3 = null;
            }
            List<AssetCard> autoroutedPayChannels = attribute2.getAutoroutedPayChannels();
            List<AssetCardModel> MyBillsEntityDataFactory2 = autoroutedPayChannels != null ? AssetCardModelKt.MyBillsEntityDataFactory(autoroutedPayChannels) : null;
            List<AssetCard> mixPayAutoroutedPayChannels = attribute2.getMixPayAutoroutedPayChannels();
            List<AssetCardModel> MyBillsEntityDataFactory3 = mixPayAutoroutedPayChannels != null ? AssetCardModelKt.MyBillsEntityDataFactory(mixPayAutoroutedPayChannels) : null;
            MoneyView currentMonthFundInAmount = attribute2.getCurrentMonthFundInAmount();
            String expressPayAgreementToken = attribute2.getExpressPayAgreementToken();
            MoneyView maxAmount = attribute2.getMaxAmount();
            if (maxAmount != null) {
                MoneyViewModel.Companion companion6 = MoneyViewModel.INSTANCE;
                moneyViewModel4 = MoneyViewModel.Companion.PlaceComponentResult(maxAmount);
            } else {
                moneyViewModel4 = null;
            }
            MoneyView maxBalanceAmount = attribute2.getMaxBalanceAmount();
            if (maxBalanceAmount != null) {
                MoneyViewModel.Companion companion7 = MoneyViewModel.INSTANCE;
                moneyViewModel5 = MoneyViewModel.Companion.PlaceComponentResult(maxBalanceAmount);
            } else {
                moneyViewModel5 = null;
            }
            MoneyView maxMonthFundInAmount = attribute2.getMaxMonthFundInAmount();
            if (maxMonthFundInAmount != null) {
                MoneyViewModel.Companion companion8 = MoneyViewModel.INSTANCE;
                moneyViewModel6 = MoneyViewModel.Companion.PlaceComponentResult(maxMonthFundInAmount);
            } else {
                moneyViewModel6 = null;
            }
            MoneyView minAmount = attribute2.getMinAmount();
            if (minAmount != null) {
                MoneyViewModel.Companion companion9 = MoneyViewModel.INSTANCE;
                moneyViewModel7 = MoneyViewModel.Companion.PlaceComponentResult(minAmount);
            } else {
                moneyViewModel7 = null;
            }
            List<PayMethodViewDto> payMethodViewDtos = attribute2.getPayMethodViewDtos();
            List<PayMethodViewDtoModel> PlaceComponentResult2 = payMethodViewDtos != null ? PlaceComponentResult(payMethodViewDtos) : null;
            Boolean success = attribute2.getSuccess();
            String userAccountName = attribute2.getUserAccountName();
            Boolean isDeeplinkPayment = attribute2.isDeeplinkPayment();
            Boolean mainAppPayReturnUrlDeeplink = attribute2.getMainAppPayReturnUrlDeeplink();
            Boolean merchantReturnUrlDeeplink = attribute2.getMerchantReturnUrlDeeplink();
            Boolean isSupportTopupPay = attribute2.isSupportTopupPay();
            List<RiskVerificationMethod> riskVerificationMethods = attribute2.getRiskVerificationMethods();
            List<RiskVerificationMethodModel> PlaceComponentResult3 = riskVerificationMethods != null ? RiskVerificationMethodModelKt.PlaceComponentResult(riskVerificationMethods) : null;
            RiskVerificationMethod payMethodRisk = attribute2.getPayMethodRisk();
            RiskVerificationMethodModel KClassImpl$Data$declaredNonStaticMembers$22 = payMethodRisk != null ? RiskVerificationMethodModelKt.KClassImpl$Data$declaredNonStaticMembers$2(payMethodRisk) : null;
            RiskVerificationMethod queryPaymentRiskResult = attribute2.getQueryPaymentRiskResult();
            RiskVerificationMethodModel KClassImpl$Data$declaredNonStaticMembers$23 = queryPaymentRiskResult != null ? RiskVerificationMethodModelKt.KClassImpl$Data$declaredNonStaticMembers$2(queryPaymentRiskResult) : null;
            String redirectUrl = attribute2.getRedirectUrl();
            Object param = attribute2.getParam();
            String httpMethod = attribute2.getHttpMethod();
            String contentType = attribute2.getContentType();
            List<Risk3dsAdditionalData> risk3dsAdditionalData = attribute2.getRisk3dsAdditionalData();
            List<Risk3dsAdditionalDataModel> PlaceComponentResult4 = risk3dsAdditionalData != null ? Risk3dsAdditionalDataModelKt.PlaceComponentResult(risk3dsAdditionalData) : null;
            MoneyView transferAmount = attribute2.getTransferAmount();
            if (transferAmount != null) {
                MoneyViewModel.Companion companion10 = MoneyViewModel.INSTANCE;
                moneyViewModel8 = MoneyViewModel.Companion.PlaceComponentResult(transferAmount);
            } else {
                moneyViewModel8 = null;
            }
            MoneyView transferFeeAmount = attribute2.getTransferFeeAmount();
            if (transferFeeAmount != null) {
                MoneyViewModel.Companion companion11 = MoneyViewModel.INSTANCE;
                moneyViewModel9 = MoneyViewModel.Companion.PlaceComponentResult(transferFeeAmount);
            } else {
                moneyViewModel9 = null;
            }
            Boolean isUseFreeTransfer = attribute2.isUseFreeTransfer();
            Boolean isUseOrganizerFreeTransfer = attribute2.isUseOrganizerFreeTransfer();
            MoneyView organizerTransferFeeAmount = attribute2.getOrganizerTransferFeeAmount();
            if (organizerTransferFeeAmount != null) {
                MoneyViewModel.Companion companion12 = MoneyViewModel.INSTANCE;
                moneyViewModel10 = MoneyViewModel.Companion.PlaceComponentResult(organizerTransferFeeAmount);
            } else {
                moneyViewModel10 = null;
            }
            String productCode = attribute2.getProductCode();
            List<PayMethodFeeInfo> payMethodFees = attribute2.getPayMethodFees();
            List<PayMethodFeeModel> authRequestContext = payMethodFees != null ? PayMethodFeeModelKt.getAuthRequestContext(payMethodFees) : null;
            String groupName = attribute2.getGroupName();
            Integer totalParticipants = attribute2.getTotalParticipants();
            String acquirerName = attribute2.getAcquirerName();
            String merchantCity = attribute2.getMerchantCity();
            String merchantPan = attribute2.getMerchantPan();
            String postalCode = attribute2.getPostalCode();
            String countryCode = attribute2.getCountryCode();
            MoneyView orderForeignAmount = attribute2.getOrderForeignAmount();
            if (orderForeignAmount != null) {
                MoneyViewModel.Companion companion13 = MoneyViewModel.INSTANCE;
                moneyViewModel11 = MoneyViewModel.Companion.PlaceComponentResult(orderForeignAmount);
            } else {
                moneyViewModel11 = null;
            }
            MoneyView totalForeignAmount = attribute2.getTotalForeignAmount();
            if (totalForeignAmount != null) {
                MoneyViewModel.Companion companion14 = MoneyViewModel.INSTANCE;
                moneyViewModel12 = MoneyViewModel.Companion.PlaceComponentResult(totalForeignAmount);
            } else {
                moneyViewModel12 = null;
            }
            MoneyView convertAmount = attribute2.getConvertAmount();
            if (convertAmount != null) {
                MoneyViewModel.Companion companion15 = MoneyViewModel.INSTANCE;
                moneyViewModel13 = MoneyViewModel.Companion.PlaceComponentResult(convertAmount);
            } else {
                moneyViewModel13 = null;
            }
            MoneyView exchangeRate = attribute2.getExchangeRate();
            if (exchangeRate != null) {
                MoneyViewModel.Companion companion16 = MoneyViewModel.INSTANCE;
                moneyViewModel14 = MoneyViewModel.Companion.PlaceComponentResult(exchangeRate);
            } else {
                moneyViewModel14 = null;
            }
            String qrisBizType = attribute2.getQrisBizType();
            IntlOrderInfoDTO intlOrderInfoDTO = attribute2.getIntlOrderInfoDTO();
            return new AttributeModel(MyBillsEntityDataFactory, bizOrderId, canSaveCC, cardSchemes, BuiltInFictitiousFunctionClassFactory, couponRejectedByRisk, defaultOption, directDebitDescription, directDebitInstIds, directDebitTitle, initialChannelNum, initialSavedCardNum, isSupportMixPayment, loginStatus, maskPhoneNumber, maskedLoginId, merchantLogoUrl, merchantName, merchantReturnUrl, mainAppPayReturnUrl, mobileMerchantLogoUrl, networkScenario, moneyViewModel, orderTitle, apply, list, pcMerchantLogoUrl, promoMessage, reachSaveCardLimit, saveCardLimitNumber, pubKey, showTutorialButton, showAutorouteSwitch, choosePaymentMethod, confirmPayment, moneyViewModel2, PlaceComponentResult, KClassImpl$Data$declaredNonStaticMembers$2, linkedHashMap, moneyViewModel3, MyBillsEntityDataFactory2, MyBillsEntityDataFactory3, null, currentMonthFundInAmount, expressPayAgreementToken, moneyViewModel4, moneyViewModel5, moneyViewModel6, moneyViewModel7, PlaceComponentResult2, success, userAccountName, isDeeplinkPayment, merchantReturnUrlDeeplink, mainAppPayReturnUrlDeeplink, isSupportTopupPay, PlaceComponentResult3, KClassImpl$Data$declaredNonStaticMembers$22, KClassImpl$Data$declaredNonStaticMembers$23, redirectUrl, param, httpMethod, contentType, PlaceComponentResult4, moneyViewModel8, moneyViewModel9, isUseFreeTransfer, isUseOrganizerFreeTransfer, moneyViewModel10, productCode, authRequestContext, groupName, totalParticipants, acquirerName, merchantCity, merchantPan, postalCode, countryCode, moneyViewModel11, moneyViewModel12, moneyViewModel13, moneyViewModel14, qrisBizType, false, intlOrderInfoDTO != null ? IntlOrderInfoDTOModelKt.MyBillsEntityDataFactory(intlOrderInfoDTO) : null, 0, 1024, 524288, null);
        }
        return null;
    }

    @Inject
    public AttributeModelMapper(CashierPayChannelModelsMapper cashierPayChannelModelsMapper) {
        Intrinsics.checkNotNullParameter(cashierPayChannelModelsMapper, "");
        this.MyBillsEntityDataFactory = cashierPayChannelModelsMapper;
    }

    private final List<PayMethodViewDtoModel> PlaceComponentResult(List<PayMethodViewDto> list) {
        List<PayMethodViewDto> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (PayMethodViewDto payMethodViewDto : list2) {
            String defaultChannelOption = payMethodViewDto.getDefaultChannelOption();
            List<AssetCard> payCardOptionViewDtos = payMethodViewDto.getPayCardOptionViewDtos();
            arrayList.add(new PayMethodViewDtoModel(defaultChannelOption, payCardOptionViewDtos != null ? AssetCardModelKt.MyBillsEntityDataFactory(payCardOptionViewDtos) : null, this.MyBillsEntityDataFactory.apply(payMethodViewDto.getPayChannelOptionViewDtos()), payMethodViewDto.getPayMethod()));
        }
        return arrayList;
    }

    public final AttributeCashierPayModel BuiltInFictitiousFunctionClassFactory(Attribute p0) {
        MoneyViewModel moneyViewModel;
        MoneyViewModel moneyViewModel2;
        MoneyViewModel moneyViewModel3;
        MoneyViewModel moneyViewModel4;
        MoneyViewModel moneyViewModel5;
        MoneyViewModel moneyViewModel6 = null;
        if (p0 != null) {
            String cardIndexNo = p0.getCardIndexNo();
            List<? extends CashierPayChannelModel> apply = this.MyBillsEntityDataFactory.apply(p0.getPayChannels());
            String merchantTransType = p0.getMerchantTransType();
            String payAccountNo = p0.getPayAccountNo();
            String maskedLoginId = p0.getMaskedLoginId();
            String accountName = p0.getAccountName();
            String maskPhoneNumber = p0.getMaskPhoneNumber();
            String paidTime = p0.getPaidTime();
            Boolean loginStatus = p0.getLoginStatus();
            String merchantId = p0.getMerchantId();
            String merchantName = p0.getMerchantName();
            MoneyView totalAmount = p0.getTotalAmount();
            if (totalAmount != null) {
                MoneyViewModel.Companion companion = MoneyViewModel.INSTANCE;
                moneyViewModel = MoneyViewModel.Companion.PlaceComponentResult(totalAmount);
            } else {
                moneyViewModel = null;
            }
            String processingStatus = p0.getProcessingStatus();
            MoneyView orderAmount = p0.getOrderAmount();
            if (orderAmount != null) {
                MoneyViewModel.Companion companion2 = MoneyViewModel.INSTANCE;
                moneyViewModel2 = MoneyViewModel.Companion.PlaceComponentResult(orderAmount);
            } else {
                moneyViewModel2 = null;
            }
            MoneyView originalOrderAmount = p0.getOriginalOrderAmount();
            if (originalOrderAmount != null) {
                MoneyViewModel.Companion companion3 = MoneyViewModel.INSTANCE;
                moneyViewModel3 = MoneyViewModel.Companion.PlaceComponentResult(originalOrderAmount);
            } else {
                moneyViewModel3 = null;
            }
            List<CashierOrderGood> cashierOrderGoods = p0.getCashierOrderGoods();
            List<CashierOrderGoodModel> BuiltInFictitiousFunctionClassFactory = cashierOrderGoods != null ? CashierOrderGoodModelKt.BuiltInFictitiousFunctionClassFactory(cashierOrderGoods) : null;
            String transType = p0.getTransType();
            String bizOrderId = p0.getBizOrderId();
            Boolean queryAgain = p0.getQueryAgain();
            Boolean isMixPayment = p0.isMixPayment();
            String merchantTransId = p0.getMerchantTransId();
            Boolean isCanSaveCard = p0.isCanSaveCard();
            Boolean displayMerchantOrder = p0.getDisplayMerchantOrder();
            String orderTitle = p0.getOrderTitle();
            String vaExpiredTime = p0.getVaExpiredTime();
            String addonId = p0.getAddonId();
            String orderCreatedTime = p0.getOrderCreatedTime();
            String lzdTopUpType = p0.getLzdTopUpType();
            String pubKey = p0.getPubKey();
            List<RiskVerificationMethod> riskVerificationMethods = p0.getRiskVerificationMethods();
            List<RiskVerificationMethodModel> PlaceComponentResult = riskVerificationMethods != null ? RiskVerificationMethodModelKt.PlaceComponentResult(riskVerificationMethods) : null;
            RiskVerificationMethod payMethodRisk = p0.getPayMethodRisk();
            RiskVerificationMethodModel KClassImpl$Data$declaredNonStaticMembers$2 = payMethodRisk != null ? RiskVerificationMethodModelKt.KClassImpl$Data$declaredNonStaticMembers$2(payMethodRisk) : null;
            RiskVerificationMethod queryPaymentRiskResult = p0.getQueryPaymentRiskResult();
            RiskVerificationMethodModel KClassImpl$Data$declaredNonStaticMembers$22 = queryPaymentRiskResult != null ? RiskVerificationMethodModelKt.KClassImpl$Data$declaredNonStaticMembers$2(queryPaymentRiskResult) : null;
            Integer maxFailedLimit = p0.getMaxFailedLimit();
            Integer identFailedCount = p0.getIdentFailedCount();
            Integer lockedExpireMins = p0.getLockedExpireMins();
            String redirectUrl = p0.getRedirectUrl();
            Object param = p0.getParam();
            String httpMethod = p0.getHttpMethod();
            String contentType = p0.getContentType();
            List<Risk3dsAdditionalData> risk3dsAdditionalData = p0.getRisk3dsAdditionalData();
            List<Risk3dsAdditionalDataModel> PlaceComponentResult2 = risk3dsAdditionalData != null ? Risk3dsAdditionalDataModelKt.PlaceComponentResult(risk3dsAdditionalData) : null;
            String networkScenarioType = p0.getNetworkScenarioType();
            String transactionScenario = p0.getTransactionScenario();
            String headerDesc = p0.getHeaderDesc();
            List<PayMethodViewDto> payMethodViewDtos = p0.getPayMethodViewDtos();
            List<PayMethodViewDtoModel> PlaceComponentResult3 = payMethodViewDtos != null ? PlaceComponentResult(payMethodViewDtos) : null;
            Boolean success = p0.getSuccess();
            String userAccountName = p0.getUserAccountName();
            Boolean isDeeplinkPayment = p0.isDeeplinkPayment();
            String merchantReturnUrl = p0.getMerchantReturnUrl();
            Boolean mainAppPayReturnUrlDeeplink = p0.getMainAppPayReturnUrlDeeplink();
            String mainAppPayReturnUrl = p0.getMainAppPayReturnUrl();
            Boolean merchantReturnUrlDeeplink = p0.getMerchantReturnUrlDeeplink();
            Boolean isSupportTopupPay = p0.isSupportTopupPay();
            String cardCacheToken = p0.getCardCacheToken();
            ProcessingMilestone processingMilestone = p0.getProcessingMilestone();
            ProcessingMilestoneModel KClassImpl$Data$declaredNonStaticMembers$23 = processingMilestone != null ? ProcessingMilestoneModelKt.KClassImpl$Data$declaredNonStaticMembers$2(processingMilestone) : null;
            Long orderExpiredTime = p0.getOrderExpiredTime();
            String productCode = p0.getProductCode();
            MoneyView payMethodFee = p0.getPayMethodFee();
            if (payMethodFee != null) {
                MoneyViewModel.Companion companion4 = MoneyViewModel.INSTANCE;
                moneyViewModel4 = MoneyViewModel.Companion.PlaceComponentResult(payMethodFee);
            } else {
                moneyViewModel4 = null;
            }
            String groupName = p0.getGroupName();
            String acquirerName = p0.getAcquirerName();
            String merchantCity = p0.getMerchantCity();
            String merchantPan = p0.getMerchantPan();
            String postalCode = p0.getPostalCode();
            String countryCode = p0.getCountryCode();
            String riskInfo = p0.getRiskInfo();
            MoneyView totalForeignAmount = p0.getTotalForeignAmount();
            if (totalForeignAmount != null) {
                MoneyViewModel.Companion companion5 = MoneyViewModel.INSTANCE;
                moneyViewModel5 = MoneyViewModel.Companion.PlaceComponentResult(totalForeignAmount);
            } else {
                moneyViewModel5 = null;
            }
            String innerRedirectUrl = p0.getInnerRedirectUrl();
            String sourcePlatform = p0.getSourcePlatform();
            String batchNumber = p0.getBatchNumber();
            MoneyView transferFeeAmount = p0.getTransferFeeAmount();
            if (transferFeeAmount != null) {
                MoneyViewModel.Companion companion6 = MoneyViewModel.INSTANCE;
                moneyViewModel6 = MoneyViewModel.Companion.PlaceComponentResult(transferFeeAmount);
            }
            return new AttributeCashierPayModel(cardIndexNo, apply, merchantTransType, payAccountNo, maskedLoginId, accountName, maskPhoneNumber, paidTime, loginStatus, merchantId, merchantName, moneyViewModel, processingStatus, moneyViewModel2, moneyViewModel3, BuiltInFictitiousFunctionClassFactory, transType, bizOrderId, queryAgain, isMixPayment, merchantTransId, isCanSaveCard, displayMerchantOrder, orderTitle, vaExpiredTime, addonId, orderCreatedTime, lzdTopUpType, pubKey, PlaceComponentResult, KClassImpl$Data$declaredNonStaticMembers$2, KClassImpl$Data$declaredNonStaticMembers$22, maxFailedLimit, identFailedCount, lockedExpireMins, redirectUrl, param, httpMethod, contentType, PlaceComponentResult2, networkScenarioType, transactionScenario, headerDesc, PlaceComponentResult3, success, userAccountName, isDeeplinkPayment, merchantReturnUrl, merchantReturnUrlDeeplink, mainAppPayReturnUrl, mainAppPayReturnUrlDeeplink, isSupportTopupPay, cardCacheToken, KClassImpl$Data$declaredNonStaticMembers$23, orderExpiredTime, productCode, moneyViewModel4, groupName, acquirerName, merchantCity, merchantPan, postalCode, countryCode, riskInfo, moneyViewModel5, innerRedirectUrl, sourcePlatform, batchNumber, moneyViewModel6);
        }
        return null;
    }
}
