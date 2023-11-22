package id.dana.cashier.data.repository.source.network.result;

import id.dana.cashier.domain.model.AssetCard;
import id.dana.cashier.domain.model.DailyLimitAmountConf;
import id.dana.cashier.domain.model.DailyLimitAmountConfKt;
import id.dana.cashier.domain.model.ExtendCashierInfo;
import id.dana.data.sendmoney.model.HolderName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004*\b\u0012\u0004\u0012\u00020\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/cashier/data/repository/source/network/result/AssetCardResult;", "Lid/dana/cashier/domain/model/AssetCard;", "toAssetCardInfo", "(Lid/dana/cashier/data/repository/source/network/result/AssetCardResult;)Lid/dana/cashier/domain/model/AssetCard;", "", "toListAssetCardInfo", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AssetCardResultKt {
    public static final List<AssetCard> toListAssetCardInfo(List<AssetCardResult> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<AssetCardResult> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toAssetCardInfo((AssetCardResult) it.next()));
        }
        return arrayList;
    }

    private static final AssetCard toAssetCardInfo(AssetCardResult assetCardResult) {
        String assetType = assetCardResult.getAssetType();
        String bankPhoneNo = assetCardResult.getBankPhoneNo();
        String bindingId = assetCardResult.getBindingId();
        Boolean canUse = assetCardResult.getCanUse();
        String cardBin = assetCardResult.getCardBin();
        String cardIndexNo = assetCardResult.getCardIndexNo();
        Integer cardNoLength = assetCardResult.getCardNoLength();
        String cardScheme = assetCardResult.getCardScheme();
        Boolean defaultOption = assetCardResult.getDefaultOption();
        String deviceId = assetCardResult.getDeviceId();
        Boolean directDebit = assetCardResult.getDirectDebit();
        String disableReason = assetCardResult.getDisableReason();
        Boolean enableStatus = assetCardResult.getEnableStatus();
        String expiryMonth = assetCardResult.getExpiryMonth();
        String expiryYear = assetCardResult.getExpiryYear();
        String instId = assetCardResult.getInstId();
        String instName = assetCardResult.getInstName();
        Boolean instSupportDirectDebit = assetCardResult.getInstSupportDirectDebit();
        String limitMaximum = assetCardResult.getLimitMaximum();
        Long lastPayTime = assetCardResult.getLastPayTime();
        String maskedCardNo = assetCardResult.getMaskedCardNo();
        Integer order = assetCardResult.getOrder();
        String payMethod = assetCardResult.getPayMethod();
        String payOption = assetCardResult.getPayOption();
        List<String> payVerifyElements = assetCardResult.getPayVerifyElements();
        PromoInfoResult promo = assetCardResult.getPromo();
        String description = promo != null ? promo.getDescription() : null;
        PromoInfoResult promo2 = assetCardResult.getPromo();
        Boolean status = promo2 != null ? promo2.getStatus() : null;
        String type = assetCardResult.getType();
        List<String> verifyElements = assetCardResult.getVerifyElements();
        String xcoId = assetCardResult.getXcoId();
        DailyLimitAmountConfResult dailyLimitAmountConf = assetCardResult.getDailyLimitAmountConf();
        DailyLimitAmountConf dailyLimitAmountConf2 = dailyLimitAmountConf != null ? DailyLimitAmountConfKt.toDailyLimitAmountConf(dailyLimitAmountConf) : null;
        Boolean defaultCard = assetCardResult.getDefaultCard();
        ExtendInfoResult extendInfo = assetCardResult.getExtendInfo();
        ExtendCashierInfo extendCashierInfo = extendInfo != null ? ExtendInfoResultKt.toExtendCashierInfo(extendInfo) : null;
        HolderName holderName = assetCardResult.getHolderName();
        String name = holderName != null ? holderName.getName() : null;
        Boolean payWithoutCvv = assetCardResult.getPayWithoutCvv();
        RemainingCardLimitAmountResult remainingCardLimitAmount = assetCardResult.getRemainingCardLimitAmount();
        return new AssetCard(assetType, bankPhoneNo, bindingId, canUse, cardBin, cardIndexNo, cardNoLength, cardScheme, defaultOption, deviceId, directDebit, disableReason, enableStatus, expiryMonth, expiryYear, instId, instName, instSupportDirectDebit, limitMaximum, lastPayTime, maskedCardNo, order, payMethod, payOption, payVerifyElements, description, status, type, verifyElements, xcoId, dailyLimitAmountConf2, defaultCard, extendCashierInfo, name, payWithoutCvv, remainingCardLimitAmount != null ? RemainingCardLimitAmountResultKt.toRemainingCardLimitAmount(remainingCardLimitAmount) : null, assetCardResult.getSequence(), assetCardResult.getInstallmentPeriod());
    }
}
