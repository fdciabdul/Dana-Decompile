package id.dana.cashier.model;

import id.dana.cashier.domain.model.AssetCard;
import id.dana.cashier.domain.model.DailyLimitAmountConf;
import id.dana.cashier.domain.model.ExtendCashierInfo;
import id.dana.cashier.domain.model.RemainingCardLimitAmount;
import id.dana.cashier.mapper.QueryCardPolicyInfoModelMapperKt;
import id.dana.cashier.model.CashierPayMethodModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000*\b\u0012\u0004\u0012\u00020\u00050\u0000¢\u0006\u0004\b\u0006\u0010\u0004"}, d2 = {"", "Lid/dana/cashier/model/AssetCardModel;", "Lid/dana/cashier/model/CashierPayMethodModel$CardPayMethod;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/util/List;)Ljava/util/List;", "Lid/dana/cashier/domain/model/AssetCard;", "MyBillsEntityDataFactory"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AssetCardModelKt {
    public static final List<AssetCardModel> MyBillsEntityDataFactory(List<AssetCard> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<AssetCard> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (AssetCard assetCard : list2) {
            Intrinsics.checkNotNullParameter(assetCard, "");
            String assetType = assetCard.getAssetType();
            String bankPhoneNo = assetCard.getBankPhoneNo();
            String bindingId = assetCard.getBindingId();
            Boolean canUse = assetCard.getCanUse();
            String cardBin = assetCard.getCardBin();
            String cardIndexNo = assetCard.getCardIndexNo();
            Integer cardNoLength = assetCard.getCardNoLength();
            String cardScheme = assetCard.getCardScheme();
            Boolean defaultOption = assetCard.getDefaultOption();
            String deviceId = assetCard.getDeviceId();
            Boolean directDebit = assetCard.getDirectDebit();
            String disableReason = assetCard.getDisableReason();
            Boolean enableStatus = assetCard.getEnableStatus();
            String expiryMonth = assetCard.getExpiryMonth();
            String expiryYear = assetCard.getExpiryYear();
            String instId = assetCard.getInstId();
            String instName = assetCard.getInstName();
            Boolean instSupportDirectDebit = assetCard.getInstSupportDirectDebit();
            String limitMaximum = assetCard.getLimitMaximum();
            Long lastPayTime = assetCard.getLastPayTime();
            String maskedCardNo = assetCard.getMaskedCardNo();
            Integer order = assetCard.getOrder();
            String payMethod = assetCard.getPayMethod();
            String payOption = assetCard.getPayOption();
            List<String> payVerifyElements = assetCard.getPayVerifyElements();
            String promoDescription = assetCard.getPromoDescription();
            Boolean promoStatus = assetCard.getPromoStatus();
            String type = assetCard.getType();
            List<String> verifyElements = assetCard.getVerifyElements();
            String xcoId = assetCard.getXcoId();
            DailyLimitAmountConf dailyLimitAmountConf = assetCard.getDailyLimitAmountConf();
            DailyLimitAmountConfModel PlaceComponentResult = dailyLimitAmountConf != null ? QueryCardPolicyInfoModelMapperKt.PlaceComponentResult(dailyLimitAmountConf) : null;
            Boolean defaultCard = assetCard.getDefaultCard();
            ExtendCashierInfo extendInfo = assetCard.getExtendInfo();
            ExtendCashierModel PlaceComponentResult2 = extendInfo != null ? ExtendCashierModelKt.PlaceComponentResult(extendInfo) : null;
            String holderName = assetCard.getHolderName();
            Boolean payWithoutCvv = assetCard.getPayWithoutCvv();
            RemainingCardLimitAmount remainingCardLimitAmount = assetCard.getRemainingCardLimitAmount();
            arrayList.add(new AssetCardModel(assetType, bankPhoneNo, bindingId, canUse, cardBin, cardIndexNo, cardNoLength, cardScheme, defaultOption, deviceId, directDebit, disableReason, enableStatus, expiryMonth, expiryYear, instId, instName, instSupportDirectDebit, limitMaximum, lastPayTime, maskedCardNo, order, payMethod, payOption, payVerifyElements, promoDescription, promoStatus, type, verifyElements, xcoId, PlaceComponentResult, defaultCard, PlaceComponentResult2, holderName, payWithoutCvv, remainingCardLimitAmount != null ? new RemainingCardLimitAmountModel(remainingCardLimitAmount.getAmount(), remainingCardLimitAmount.getCent(), remainingCardLimitAmount.getCentFactor(), remainingCardLimitAmount.getCurrency(), remainingCardLimitAmount.getCurrencyCode(), remainingCardLimitAmount.getCurrencyValue()) : null, assetCard.getSequence(), assetCard.getInstallmentPeriod()));
        }
        return arrayList;
    }

    public static final List<CashierPayMethodModel.CardPayMethod> KClassImpl$Data$declaredNonStaticMembers$2(List<AssetCardModel> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<AssetCardModel> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(new CashierPayMethodModel.CardPayMethod((AssetCardModel) it.next(), null, null, 6, null));
        }
        return arrayList;
    }
}
