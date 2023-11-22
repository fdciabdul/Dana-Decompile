package id.dana.cashier.data.mapper;

import id.dana.cashier.data.repository.source.network.result.AssetCardResult;
import id.dana.cashier.data.repository.source.network.result.AssetCardResultKt;
import id.dana.cashier.data.repository.source.network.result.AttributesResult;
import id.dana.cashier.data.repository.source.network.result.CashierOrderGoodsResult;
import id.dana.cashier.data.repository.source.network.result.DirectDebitInfoResult;
import id.dana.cashier.data.repository.source.network.result.IntlOrderInfoDTOResult;
import id.dana.cashier.data.repository.source.network.result.IntlOrderInfoDTOResultKt;
import id.dana.cashier.data.repository.source.network.result.OrderCreateExtendInfoResult;
import id.dana.cashier.data.repository.source.network.result.OrderCreateExtendInfoResultKt;
import id.dana.cashier.data.repository.source.network.result.PayMethodFeeResult;
import id.dana.cashier.data.repository.source.network.result.PayMethodFeeResultKt;
import id.dana.cashier.data.repository.source.network.result.PayMethodViewDtoResult;
import id.dana.cashier.data.repository.source.network.result.ProcessingMilestoneResult;
import id.dana.cashier.data.repository.source.network.result.ProcessingMilestoneResultKt;
import id.dana.cashier.data.repository.source.network.result.Risk3dsAdditionalDataResult;
import id.dana.cashier.data.repository.source.network.result.Risk3dsAdditionalDataResultKt;
import id.dana.cashier.data.repository.source.network.result.RiskVerificationMethodResult;
import id.dana.cashier.data.repository.source.network.result.RiskVerificationMethodResultKt;
import id.dana.cashier.data.repository.source.network.result.SecurityContextResult;
import id.dana.cashier.data.repository.source.network.result.TitleInfoResult;
import id.dana.cashier.data.repository.source.network.result.TransactionFeeViewEntityKt;
import id.dana.cashier.domain.model.AssetCard;
import id.dana.cashier.domain.model.Attribute;
import id.dana.cashier.domain.model.CashierOrderGood;
import id.dana.cashier.domain.model.CashierPayChannelInfo;
import id.dana.cashier.domain.model.PayMethodFeeInfo;
import id.dana.cashier.domain.model.PayMethodViewDto;
import id.dana.cashier.domain.model.ProcessingMilestone;
import id.dana.cashier.domain.model.Risk3dsAdditionalData;
import id.dana.cashier.domain.model.RiskVerificationMethod;
import id.dana.cashier.domain.model.TransactionFeeView;
import id.dana.data.base.BaseMapper;
import id.dana.data.nearbyme.model.MoneyViewEntityMapperKt;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.network.response.expresspurchase.MoneyViewEntity;
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

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001d\u0010\u001eJ\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u0007\u001a\u00020\u0003*\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0013\u0010\n\u001a\u00020\t*\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\f*\b\u0012\u0004\u0012\u00020\b0\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ+\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00120\u000f*\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0017\u001a\u00020\u0016*\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\f*\b\u0012\u0004\u0012\u00020\u00150\fH\u0002¢\u0006\u0004\b\u0019\u0010\u000eR\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c"}, d2 = {"Lid/dana/cashier/data/mapper/AttributesResultMapper;", "Lid/dana/data/base/BaseMapper;", "Lid/dana/cashier/data/repository/source/network/result/AttributesResult;", "Lid/dana/cashier/domain/model/Attribute;", "oldItem", "map", "(Lid/dana/cashier/data/repository/source/network/result/AttributesResult;)Lid/dana/cashier/domain/model/Attribute;", "toAttribute", "Lid/dana/cashier/data/repository/source/network/result/CashierOrderGoodsResult;", "Lid/dana/cashier/domain/model/CashierOrderGood;", "toCashierOrderGood", "(Lid/dana/cashier/data/repository/source/network/result/CashierOrderGoodsResult;)Lid/dana/cashier/domain/model/CashierOrderGood;", "", "toListCashierAddOnInfos", "(Ljava/util/List;)Ljava/util/List;", "", "", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "Lid/dana/domain/nearbyme/model/MoneyView;", "toPayFeeChargeMapInfo", "(Ljava/util/Map;)Ljava/util/Map;", "Lid/dana/cashier/data/repository/source/network/result/PayMethodViewDtoResult;", "Lid/dana/cashier/domain/model/PayMethodViewDto;", "toPayMethodViewDto", "(Lid/dana/cashier/data/repository/source/network/result/PayMethodViewDtoResult;)Lid/dana/cashier/domain/model/PayMethodViewDto;", "toPayMethodViewDtos", "Lid/dana/cashier/data/mapper/PayChannelsInfoResultMapper;", "payChannelsInfoResultMapper", "Lid/dana/cashier/data/mapper/PayChannelsInfoResultMapper;", "<init>", "(Lid/dana/cashier/data/mapper/PayChannelsInfoResultMapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AttributesResultMapper extends BaseMapper<AttributesResult, Attribute> {
    private final PayChannelsInfoResultMapper payChannelsInfoResultMapper;

    @Inject
    public AttributesResultMapper(PayChannelsInfoResultMapper payChannelsInfoResultMapper) {
        Intrinsics.checkNotNullParameter(payChannelsInfoResultMapper, "");
        this.payChannelsInfoResultMapper = payChannelsInfoResultMapper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public final Attribute map(AttributesResult oldItem) {
        if (oldItem != null) {
            return toAttribute(oldItem);
        }
        return null;
    }

    private final Attribute toAttribute(AttributesResult attributesResult) {
        String cardIndexNo = attributesResult.getCardIndexNo();
        List<? extends CashierPayChannelInfo> apply = this.payChannelsInfoResultMapper.apply(attributesResult.getPayChannels());
        String merchantTransType = attributesResult.getMerchantTransType();
        String payAccountNo = attributesResult.getPayAccountNo();
        String maskedLoginId = attributesResult.getMaskedLoginId();
        String accountName = attributesResult.getAccountName();
        String maskPhoneNumber = attributesResult.getMaskPhoneNumber();
        String paidTime = attributesResult.getPaidTime();
        Boolean loginStatus = attributesResult.getLoginStatus();
        String merchantId = attributesResult.getMerchantId();
        String merchantName = attributesResult.getMerchantName();
        MoneyView moneyView = MoneyViewEntityMapperKt.toMoneyView(attributesResult.getTotalAmount());
        String processingStatus = attributesResult.getProcessingStatus();
        MoneyView moneyView2 = MoneyViewEntityMapperKt.toMoneyView(attributesResult.getOrderAmount());
        MoneyView moneyView3 = MoneyViewEntityMapperKt.toMoneyView(attributesResult.getOriginalOrderAmount());
        String transType = attributesResult.getTransType();
        String bizOrderId = attributesResult.getBizOrderId();
        Boolean queryAgain = attributesResult.getQueryAgain();
        Boolean isMixPayment = attributesResult.isMixPayment();
        String merchantTransId = attributesResult.getMerchantTransId();
        Boolean isCanSaveCard = attributesResult.isCanSaveCard();
        Boolean displayMerchantOrder = attributesResult.getDisplayMerchantOrder();
        String orderTitle = attributesResult.getOrderTitle();
        String vaExpiredTime = attributesResult.getVaExpiredTime();
        String addonId = attributesResult.getAddonId();
        if (addonId == null) {
            addonId = "";
        }
        String str = addonId;
        String orderCreatedTime = attributesResult.getOrderCreatedTime();
        String lzdTopUpType = attributesResult.getLzdTopUpType();
        SecurityContextResult securityContext = attributesResult.getSecurityContext();
        String pubKey = securityContext != null ? securityContext.getPubKey() : null;
        List<RiskVerificationMethodResult> riskVerificationMethods = attributesResult.getRiskVerificationMethods();
        List<RiskVerificationMethod> riskVerificationMethods2 = riskVerificationMethods != null ? RiskVerificationMethodResultKt.toRiskVerificationMethods(riskVerificationMethods) : null;
        RiskVerificationMethodResult payMethodRiskResult = attributesResult.getPayMethodRiskResult();
        RiskVerificationMethod riskVerificationMethod = payMethodRiskResult != null ? RiskVerificationMethodResultKt.toRiskVerificationMethod(payMethodRiskResult) : null;
        RiskVerificationMethodResult queryPaymentRiskResult = attributesResult.getQueryPaymentRiskResult();
        RiskVerificationMethod riskVerificationMethod2 = queryPaymentRiskResult != null ? RiskVerificationMethodResultKt.toRiskVerificationMethod(queryPaymentRiskResult) : null;
        Integer maxFailedLimit = attributesResult.getMaxFailedLimit();
        Integer identFailedCount = attributesResult.getIdentFailedCount();
        Integer lockedExpireMins = attributesResult.getLockedExpireMins();
        String redirectUrl = attributesResult.getRedirectUrl();
        Object param = attributesResult.getParam();
        String httpMethod = attributesResult.getHttpMethod();
        String contentType = attributesResult.getContentType();
        List<Risk3dsAdditionalDataResult> risk3dsAdditionalDataResult = attributesResult.getRisk3dsAdditionalDataResult();
        List<Risk3dsAdditionalData> risk3dsAdditionalData = risk3dsAdditionalDataResult != null ? Risk3dsAdditionalDataResultKt.toRisk3dsAdditionalData(risk3dsAdditionalDataResult) : null;
        MoneyView moneyView4 = MoneyViewEntityMapperKt.toMoneyView(attributesResult.getTipAmount());
        TransactionFeeView transactionFeeView = TransactionFeeViewEntityKt.toTransactionFeeView(attributesResult.getTransactionFeeAmount());
        Map<String, MoneyViewEntity> payFeeChargeMap = attributesResult.getPayFeeChargeMap();
        Map<String, MoneyView> payFeeChargeMapInfo = payFeeChargeMap != null ? toPayFeeChargeMapInfo(payFeeChargeMap) : null;
        List<AssetCardResult> assetCards = attributesResult.getAssetCards();
        List<AssetCard> listAssetCardInfo = assetCards != null ? AssetCardResultKt.toListAssetCardInfo(assetCards) : null;
        Boolean canSaveCC = attributesResult.getCanSaveCC();
        List<String> cardSchemes = attributesResult.getCardSchemes();
        List<CashierOrderGoodsResult> cashierOrderGoods = attributesResult.getCashierOrderGoods();
        List<CashierOrderGood> listCashierAddOnInfos = cashierOrderGoods != null ? toListCashierAddOnInfos(cashierOrderGoods) : null;
        Boolean couponRejectedByRisk = attributesResult.getCouponRejectedByRisk();
        String defaultOption = attributesResult.getDefaultOption();
        DirectDebitInfoResult directDebit = attributesResult.getDirectDebit();
        String description = directDebit != null ? directDebit.getDescription() : null;
        DirectDebitInfoResult directDebit2 = attributesResult.getDirectDebit();
        List<String> instIds = directDebit2 != null ? directDebit2.getInstIds() : null;
        DirectDebitInfoResult directDebit3 = attributesResult.getDirectDebit();
        String title = directDebit3 != null ? directDebit3.getTitle() : null;
        Integer initialChannelNum = attributesResult.getInitialChannelNum();
        Integer initialSavedCardNum = attributesResult.getInitialSavedCardNum();
        Boolean isSupportMixPayment = attributesResult.isSupportMixPayment();
        Boolean isSupportTopupPay = attributesResult.isSupportTopupPay();
        String merchantLogoUrl = attributesResult.getMerchantLogoUrl();
        String merchantReturnUrl = attributesResult.getMerchantReturnUrl();
        String mainAppPayReturnUrl = attributesResult.getMainAppPayReturnUrl();
        String mobileMerchantLogoUrl = attributesResult.getMobileMerchantLogoUrl();
        String networkScenario = attributesResult.getNetworkScenario();
        List<String> paymentMethodOrder = attributesResult.getPaymentMethodOrder();
        String pcMerchantLogoUrl = attributesResult.getPcMerchantLogoUrl();
        String promoMessage = attributesResult.getPromoMessage();
        Boolean reachSaveCardLimit = attributesResult.getReachSaveCardLimit();
        Integer saveCardLimitNumber = attributesResult.getSaveCardLimitNumber();
        Boolean showTutorialButton = attributesResult.getShowTutorialButton();
        Boolean showAutorouteSwitch = attributesResult.getShowAutorouteSwitch();
        TitleInfoResult title2 = attributesResult.getTitle();
        String choosePaymentMethod = title2 != null ? title2.getChoosePaymentMethod() : null;
        TitleInfoResult title3 = attributesResult.getTitle();
        String confirmPayment = title3 != null ? title3.getConfirmPayment() : null;
        MoneyView moneyView5 = MoneyViewEntityMapperKt.toMoneyView(attributesResult.getAdminFeeAmount());
        List<AssetCardResult> autoroutedPayChannels = attributesResult.getAutoroutedPayChannels();
        List<AssetCard> listAssetCardInfo2 = autoroutedPayChannels != null ? AssetCardResultKt.toListAssetCardInfo(autoroutedPayChannels) : null;
        List<AssetCardResult> mixPayAutoroutedPayChannels = attributesResult.getMixPayAutoroutedPayChannels();
        List<AssetCard> listAssetCardInfo3 = mixPayAutoroutedPayChannels != null ? AssetCardResultKt.toListAssetCardInfo(mixPayAutoroutedPayChannels) : null;
        String networkScenarioType = attributesResult.getNetworkScenarioType();
        String transactionScenario = attributesResult.getTransactionScenario();
        MoneyViewEntity currentMonthFundInAmount = attributesResult.getCurrentMonthFundInAmount();
        MoneyView moneyView6 = currentMonthFundInAmount != null ? MoneyViewEntityMapperKt.toMoneyView(currentMonthFundInAmount) : null;
        String expressPayAgreementToken = attributesResult.getExpressPayAgreementToken();
        MoneyViewEntity maxAmount = attributesResult.getMaxAmount();
        MoneyView moneyView7 = maxAmount != null ? MoneyViewEntityMapperKt.toMoneyView(maxAmount) : null;
        MoneyViewEntity maxBalanceAmount = attributesResult.getMaxBalanceAmount();
        MoneyView moneyView8 = maxBalanceAmount != null ? MoneyViewEntityMapperKt.toMoneyView(maxBalanceAmount) : null;
        MoneyViewEntity maxMonthFundInAmount = attributesResult.getMaxMonthFundInAmount();
        MoneyView moneyView9 = maxMonthFundInAmount != null ? MoneyViewEntityMapperKt.toMoneyView(maxMonthFundInAmount) : null;
        MoneyViewEntity minAmount = attributesResult.getMinAmount();
        MoneyView moneyView10 = minAmount != null ? MoneyViewEntityMapperKt.toMoneyView(minAmount) : null;
        List<PayMethodViewDtoResult> payMethodViewDtos = attributesResult.getPayMethodViewDtos();
        List<PayMethodViewDto> payMethodViewDtos2 = payMethodViewDtos != null ? toPayMethodViewDtos(payMethodViewDtos) : null;
        Boolean success = attributesResult.getSuccess();
        String userAccountName = attributesResult.getUserAccountName();
        Boolean isDeeplinkPayment = attributesResult.isDeeplinkPayment();
        Boolean merchantReturnUrlDeeplink = attributesResult.getMerchantReturnUrlDeeplink();
        Boolean mainAppPayReturnUrlDeeplink = attributesResult.getMainAppPayReturnUrlDeeplink();
        String headerDescription = attributesResult.getHeaderDescription();
        String cardCacheToken = attributesResult.getCardCacheToken();
        MoneyViewEntity transferAmount = attributesResult.getTransferAmount();
        MoneyView moneyView11 = transferAmount != null ? MoneyViewEntityMapperKt.toMoneyView(transferAmount) : null;
        MoneyViewEntity transferFeeAmount = attributesResult.getTransferFeeAmount();
        MoneyView moneyView12 = transferFeeAmount != null ? MoneyViewEntityMapperKt.toMoneyView(transferFeeAmount) : null;
        Boolean isUseFreeTransfer = attributesResult.isUseFreeTransfer();
        ProcessingMilestoneResult processingMilestone = attributesResult.getProcessingMilestone();
        ProcessingMilestone processingMilestone2 = processingMilestone != null ? ProcessingMilestoneResultKt.toProcessingMilestone(processingMilestone) : null;
        Boolean isUseOrganizerFreeTransfer = attributesResult.isUseOrganizerFreeTransfer();
        MoneyViewEntity organizerTransferFeeAmount = attributesResult.getOrganizerTransferFeeAmount();
        MoneyView moneyView13 = organizerTransferFeeAmount != null ? MoneyViewEntityMapperKt.toMoneyView(organizerTransferFeeAmount) : null;
        Long orderExpiredTime = attributesResult.getOrderExpiredTime();
        String productCode = attributesResult.getProductCode();
        List<PayMethodFeeResult> payMethodFees = attributesResult.getPayMethodFees();
        List<PayMethodFeeInfo> payMethodFeeList = payMethodFees != null ? PayMethodFeeResultKt.toPayMethodFeeList(payMethodFees) : null;
        MoneyViewEntity payMethodFee = attributesResult.getPayMethodFee();
        MoneyView moneyView14 = payMethodFee != null ? MoneyViewEntityMapperKt.toMoneyView(payMethodFee) : null;
        String groupName = attributesResult.getGroupName();
        Integer totalParticipants = attributesResult.getTotalParticipants();
        String acquirerName = attributesResult.getAcquirerName();
        String merchantCity = attributesResult.getMerchantCity();
        String merchantPan = attributesResult.getMerchantPan();
        String postalCode = attributesResult.getPostalCode();
        String countryCode = attributesResult.getCountryCode();
        String riskInfo = attributesResult.getRiskInfo();
        MoneyViewEntity orderForeignAmount = attributesResult.getOrderForeignAmount();
        MoneyView moneyView15 = orderForeignAmount != null ? MoneyViewEntityMapperKt.toMoneyView(orderForeignAmount) : null;
        MoneyViewEntity totalForeignAmount = attributesResult.getTotalForeignAmount();
        MoneyView moneyView16 = totalForeignAmount != null ? MoneyViewEntityMapperKt.toMoneyView(totalForeignAmount) : null;
        MoneyViewEntity convertAmount = attributesResult.getConvertAmount();
        MoneyView moneyView17 = convertAmount != null ? MoneyViewEntityMapperKt.toMoneyView(convertAmount) : null;
        MoneyViewEntity exchangeRate = attributesResult.getExchangeRate();
        MoneyView moneyView18 = exchangeRate != null ? MoneyViewEntityMapperKt.toMoneyView(exchangeRate) : null;
        String qrisBizType = attributesResult.getQrisBizType();
        String innerRedirectUrl = attributesResult.getInnerRedirectUrl();
        String sourcePlatform = attributesResult.getSourcePlatform();
        String batchNumber = attributesResult.getBatchNumber();
        IntlOrderInfoDTOResult intlOrderInfoDTO = attributesResult.getIntlOrderInfoDTO();
        return new Attribute(cardIndexNo, apply, merchantTransType, payAccountNo, maskedLoginId, accountName, maskPhoneNumber, paidTime, loginStatus, merchantId, merchantName, moneyView, processingStatus, moneyView2, moneyView3, transType, bizOrderId, queryAgain, isMixPayment, merchantTransId, isCanSaveCard, displayMerchantOrder, orderTitle, vaExpiredTime, str, orderCreatedTime, lzdTopUpType, pubKey, riskVerificationMethods2, riskVerificationMethod, riskVerificationMethod2, maxFailedLimit, identFailedCount, lockedExpireMins, redirectUrl, param, httpMethod, contentType, risk3dsAdditionalData, moneyView4, transactionFeeView, payFeeChargeMapInfo, listAssetCardInfo, canSaveCC, cardSchemes, listCashierAddOnInfos, couponRejectedByRisk, defaultOption, description, instIds, title, initialChannelNum, initialSavedCardNum, isSupportMixPayment, isSupportTopupPay, merchantLogoUrl, merchantReturnUrl, mainAppPayReturnUrl, mobileMerchantLogoUrl, networkScenario, paymentMethodOrder, pcMerchantLogoUrl, promoMessage, reachSaveCardLimit, saveCardLimitNumber, showTutorialButton, showAutorouteSwitch, choosePaymentMethod, confirmPayment, moneyView5, listAssetCardInfo2, listAssetCardInfo3, networkScenarioType, transactionScenario, moneyView6, expressPayAgreementToken, moneyView7, moneyView8, moneyView9, moneyView10, payMethodViewDtos2, success, userAccountName, isDeeplinkPayment, merchantReturnUrlDeeplink, mainAppPayReturnUrlDeeplink, headerDescription, cardCacheToken, moneyView11, moneyView12, isUseFreeTransfer, processingMilestone2, isUseOrganizerFreeTransfer, moneyView13, orderExpiredTime, productCode, payMethodFeeList, moneyView14, groupName, totalParticipants, acquirerName, merchantCity, merchantPan, postalCode, countryCode, riskInfo, moneyView15, moneyView16, moneyView17, moneyView18, qrisBizType, innerRedirectUrl, sourcePlatform, batchNumber, intlOrderInfoDTO != null ? IntlOrderInfoDTOResultKt.toIntlOrderInfoDTO(intlOrderInfoDTO) : null);
    }

    private final List<CashierOrderGood> toListCashierAddOnInfos(List<CashierOrderGoodsResult> list) {
        List<CashierOrderGoodsResult> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toCashierOrderGood((CashierOrderGoodsResult) it.next()));
        }
        return arrayList;
    }

    private final CashierOrderGood toCashierOrderGood(CashierOrderGoodsResult cashierOrderGoodsResult) {
        String category = cashierOrderGoodsResult.getCategory();
        Boolean choosable = cashierOrderGoodsResult.getChoosable();
        Boolean chosen = cashierOrderGoodsResult.getChosen();
        Boolean displayable = cashierOrderGoodsResult.getDisplayable();
        MoneyView moneyView = MoneyViewEntityMapperKt.toMoneyView(cashierOrderGoodsResult.getGoodsAmount());
        String goodsDescription = cashierOrderGoodsResult.getGoodsDescription();
        String goodsId = cashierOrderGoodsResult.getGoodsId();
        String goodsName = cashierOrderGoodsResult.getGoodsName();
        String goodsType = cashierOrderGoodsResult.getGoodsType();
        String goodsUnitType = cashierOrderGoodsResult.getGoodsUnitType();
        String quantity = cashierOrderGoodsResult.getQuantity();
        String toolTip = cashierOrderGoodsResult.getToolTip();
        Boolean stackInsurance = cashierOrderGoodsResult.getStackInsurance();
        OrderCreateExtendInfoResult orderCreateExtendInfoResult = cashierOrderGoodsResult.getOrderCreateExtendInfoResult();
        return new CashierOrderGood(category, choosable, chosen, displayable, moneyView, goodsDescription, goodsId, goodsName, goodsType, goodsUnitType, quantity, toolTip, stackInsurance, orderCreateExtendInfoResult != null ? OrderCreateExtendInfoResultKt.toOrderCreateExtendInfo(orderCreateExtendInfoResult) : null);
    }

    private final List<PayMethodViewDto> toPayMethodViewDtos(List<PayMethodViewDtoResult> list) {
        List<PayMethodViewDtoResult> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toPayMethodViewDto((PayMethodViewDtoResult) it.next()));
        }
        return arrayList;
    }

    private final PayMethodViewDto toPayMethodViewDto(PayMethodViewDtoResult payMethodViewDtoResult) {
        String defaultChannelOption = payMethodViewDtoResult.getDefaultChannelOption();
        List<AssetCardResult> payCardOptionViewDTOs = payMethodViewDtoResult.getPayCardOptionViewDTOs();
        return new PayMethodViewDto(defaultChannelOption, payCardOptionViewDTOs != null ? AssetCardResultKt.toListAssetCardInfo(payCardOptionViewDTOs) : null, this.payChannelsInfoResultMapper.apply(payMethodViewDtoResult.getPayChannelOptionViewDTOs()), payMethodViewDtoResult.getPayMethod());
    }

    private final Map<String, MoneyView> toPayFeeChargeMapInfo(Map<String, MoneyViewEntity> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), MoneyViewEntityMapperKt.toMoneyView((MoneyViewEntity) entry.getValue()));
        }
        return linkedHashMap;
    }
}
