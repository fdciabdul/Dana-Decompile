package id.dana.familyaccount.view.summary;

import id.dana.cashier.model.AttributeCashierPayModel;
import id.dana.cashier.model.CashierPayChannelModel;
import id.dana.cashier.model.RiskVerificationMethodModel;
import id.dana.domain.familyaccount.model.AttributesResult;
import id.dana.domain.familyaccount.model.PayChannelsItem;
import id.dana.domain.familyaccount.model.PayMethodRiskResult;
import id.dana.domain.familyaccount.model.SecurityContextAttributes;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/domain/familyaccount/model/AttributesResult;", "Lid/dana/cashier/model/AttributeCashierPayModel;", "getAuthRequestContext", "(Lid/dana/domain/familyaccount/model/AttributesResult;)Lid/dana/cashier/model/AttributeCashierPayModel;", "Lid/dana/domain/familyaccount/model/PayMethodRiskResult;", "Lid/dana/cashier/model/RiskVerificationMethodModel;", "PlaceComponentResult", "(Lid/dana/domain/familyaccount/model/PayMethodRiskResult;)Lid/dana/cashier/model/RiskVerificationMethodModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AttributeCashierPayModelExtKt {
    public static final AttributeCashierPayModel getAuthRequestContext(AttributesResult attributesResult) {
        ArrayList arrayList;
        PayChannelsItem payChannelsItem;
        PayChannelsItem payChannelsItem2;
        Intrinsics.checkNotNullParameter(attributesResult, "");
        String bizOrderId = attributesResult.getBizOrderId();
        Boolean loginStatus = attributesResult.getLoginStatus();
        String maskedLoginId = attributesResult.getMaskedLoginId();
        String merchantName = attributesResult.getMerchantName();
        String orderTitle = attributesResult.getOrderTitle();
        MoneyView totalAmount = attributesResult.getTotalAmount();
        String amount = totalAmount != null ? totalAmount.getAmount() : null;
        String str = amount == null ? "" : amount;
        MoneyView totalAmount2 = attributesResult.getTotalAmount();
        String currency = totalAmount2 != null ? totalAmount2.getCurrency() : null;
        MoneyViewModel moneyViewModel = new MoneyViewModel(str, currency == null ? "" : currency, null, 4, null);
        List<PayChannelsItem> payChannels = attributesResult.getPayChannels();
        String payMethod = (payChannels == null || (payChannelsItem2 = (PayChannelsItem) CollectionsKt.getOrNull(payChannels, 0)) == null) ? null : payChannelsItem2.getPayMethod();
        List<PayChannelsItem> payChannels2 = attributesResult.getPayChannels();
        List listOf = CollectionsKt.listOf(new CashierPayChannelModel(null, null, null, moneyViewModel, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, payMethod, null, null, null, null, null, null, null, null, null, null, null, null, null, (payChannels2 == null || (payChannelsItem = (PayChannelsItem) CollectionsKt.getOrNull(payChannels2, 0)) == null) ? null : payChannelsItem.getPayOption(), null, null, null, null, null, null, null, null, null, -524297, 2045, null));
        MoneyView totalAmount3 = attributesResult.getTotalAmount();
        String amount2 = totalAmount3 != null ? totalAmount3.getAmount() : null;
        String str2 = amount2 == null ? "" : amount2;
        MoneyView totalAmount4 = attributesResult.getTotalAmount();
        String currency2 = totalAmount4 != null ? totalAmount4.getCurrency() : null;
        MoneyViewModel moneyViewModel2 = new MoneyViewModel(str2, currency2 == null ? "" : currency2, null, 4, null);
        Boolean isDeeplinkPayment = attributesResult.isDeeplinkPayment();
        Boolean mainAppPayReturnUrlDeeplink = attributesResult.getMainAppPayReturnUrlDeeplink();
        Boolean merchantReturnUrlDeeplink = attributesResult.getMerchantReturnUrlDeeplink();
        String processingStatus = attributesResult.getProcessingStatus();
        String transType = attributesResult.getTransType();
        Boolean queryAgain = attributesResult.getQueryAgain();
        Boolean isMixPayment = attributesResult.isMixPayment();
        Boolean displayMerchantOrder = attributesResult.getDisplayMerchantOrder();
        SecurityContextAttributes securityContextAttributes = attributesResult.getSecurityContextAttributes();
        String pubKey = securityContextAttributes != null ? securityContextAttributes.getPubKey() : null;
        List<PayMethodRiskResult> riskVerificationMethods = attributesResult.getRiskVerificationMethods();
        if (riskVerificationMethods != null) {
            List<PayMethodRiskResult> list = riskVerificationMethods;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(PlaceComponentResult((PayMethodRiskResult) it.next()));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        PayMethodRiskResult payMethodRiskResult = attributesResult.getPayMethodRiskResult();
        return new AttributeCashierPayModel(null, listOf, null, null, maskedLoginId, null, null, null, loginStatus, null, merchantName, moneyViewModel2, processingStatus, null, null, null, transType, bizOrderId, queryAgain, isMixPayment, null, null, displayMerchantOrder, orderTitle, null, null, attributesResult.getOrderCreatedTime(), attributesResult.getLzdTopupType(), pubKey, arrayList, payMethodRiskResult != null ? PlaceComponentResult(payMethodRiskResult) : null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, isDeeplinkPayment, null, merchantReturnUrlDeeplink, null, mainAppPayReturnUrlDeeplink, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2093948179, -344065, 31, null);
    }

    private static final RiskVerificationMethodModel PlaceComponentResult(PayMethodRiskResult payMethodRiskResult) {
        return new RiskVerificationMethodModel(payMethodRiskResult.getResult(), payMethodRiskResult.getPubKey(), payMethodRiskResult.getVerificationMethod(), payMethodRiskResult.getMaskPhoneNumber(), null, null, null, 112, null);
    }
}
