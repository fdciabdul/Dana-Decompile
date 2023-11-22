package id.dana.data.familyaccount.model.result;

import id.dana.data.nearbyme.model.MoneyViewEntityMapperKt;
import id.dana.domain.familyaccount.model.AttributesResult;
import id.dana.domain.familyaccount.model.PayChannelsItem;
import id.dana.domain.familyaccount.model.PayMethodRiskResult;
import id.dana.domain.familyaccount.model.SecurityContextAttributes;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.network.response.expresspurchase.MoneyViewEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a'\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00002\u0010\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0011\u0010\b\u001a\u00020\u0007*\u00020\u0006¢\u0006\u0004\b\b\u0010\t\u001a\u0011\u0010\n\u001a\u00020\u0003*\u00020\u0001¢\u0006\u0004\b\n\u0010\u000b\u001a\u0015\u0010\u000e\u001a\u00020\r*\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000f\u001a#\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0000*\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0000H\u0002¢\u0006\u0004\b\u0010\u0010\u0005\u001a\u0015\u0010\u0013\u001a\u00020\u0012*\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014"}, d2 = {"", "Lid/dana/data/familyaccount/model/result/PayChannelsItemEntity;", "oldItem", "Lid/dana/domain/familyaccount/model/PayChannelsItem;", "map", "(Ljava/util/List;)Ljava/util/List;", "Lid/dana/data/familyaccount/model/result/AttributesResultEntity;", "Lid/dana/domain/familyaccount/model/AttributesResult;", "toAttributesResult", "(Lid/dana/data/familyaccount/model/result/AttributesResultEntity;)Lid/dana/domain/familyaccount/model/AttributesResult;", "toPayChannelsItem", "(Lid/dana/data/familyaccount/model/result/PayChannelsItemEntity;)Lid/dana/domain/familyaccount/model/PayChannelsItem;", "Lid/dana/data/familyaccount/model/result/PayMethodRiskResultEntity;", "Lid/dana/domain/familyaccount/model/PayMethodRiskResult;", "toPayMethodRisk", "(Lid/dana/data/familyaccount/model/result/PayMethodRiskResultEntity;)Lid/dana/domain/familyaccount/model/PayMethodRiskResult;", "toPayMethodRisks", "Lid/dana/data/familyaccount/model/result/SecurityContextAttributesEntity;", "Lid/dana/domain/familyaccount/model/SecurityContextAttributes;", "toSecurity", "(Lid/dana/data/familyaccount/model/result/SecurityContextAttributesEntity;)Lid/dana/domain/familyaccount/model/SecurityContextAttributes;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AttributesResultEntityKt {
    public static final AttributesResult toAttributesResult(AttributesResultEntity attributesResultEntity) {
        Intrinsics.checkNotNullParameter(attributesResultEntity, "");
        String bizOrderId = attributesResultEntity.getBizOrderId();
        List<Object> cashierOrderGoods = attributesResultEntity.getCashierOrderGoods();
        Boolean isSupportMixPayment = attributesResultEntity.isSupportMixPayment();
        Boolean loginStatus = attributesResultEntity.getLoginStatus();
        String maskedLoginId = attributesResultEntity.getMaskedLoginId();
        String merchantName = attributesResultEntity.getMerchantName();
        String networkScenario = attributesResultEntity.getNetworkScenario();
        String orderTitle = attributesResultEntity.getOrderTitle();
        List<PayChannelsItem> map = map(attributesResultEntity.getPayChannels());
        MoneyViewEntity totalAmount = attributesResultEntity.getTotalAmount();
        MoneyView moneyView = totalAmount != null ? MoneyViewEntityMapperKt.toMoneyView(totalAmount) : null;
        return new AttributesResult(map, maskedLoginId, attributesResultEntity.getExtendInfoList(), isSupportMixPayment, toSecurity(attributesResultEntity.getSecurityContext()), attributesResultEntity.isDeeplinkPayment(), loginStatus, networkScenario, merchantName, attributesResultEntity.getMerchantReturnUrlDeeplink(), moneyView, attributesResultEntity.getProcessingStatus(), attributesResultEntity.getTransType(), cashierOrderGoods, bizOrderId, attributesResultEntity.getQueryAgain(), attributesResultEntity.isMixPayment(), attributesResultEntity.getMainAppPayReturnUrlDeeplink(), attributesResultEntity.getSourcePlatform(), attributesResultEntity.getDisplayMerchantOrder(), toPayMethodRisk(attributesResultEntity.getPayMethodRiskResult()), toPayMethodRisks(attributesResultEntity.getRiskVerificationMethods()), orderTitle, attributesResultEntity.getOrderCreatedTime(), attributesResultEntity.getLzdTopupType());
    }

    private static final List<PayMethodRiskResult> toPayMethodRisks(List<PayMethodRiskResultEntity> list) {
        if (list != null) {
            List<PayMethodRiskResultEntity> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(toPayMethodRisk((PayMethodRiskResultEntity) it.next()));
            }
            return arrayList;
        }
        return null;
    }

    private static final PayMethodRiskResult toPayMethodRisk(PayMethodRiskResultEntity payMethodRiskResultEntity) {
        SecurityContextAttributesEntity securityContext;
        SecurityContextAttributesEntity securityContext2;
        String securityId;
        String str = null;
        String result = payMethodRiskResultEntity != null ? payMethodRiskResultEntity.getResult() : null;
        String maskPhoneNumber = payMethodRiskResultEntity != null ? payMethodRiskResultEntity.getMaskPhoneNumber() : null;
        String verificationMethod = payMethodRiskResultEntity != null ? payMethodRiskResultEntity.getVerificationMethod() : null;
        if (payMethodRiskResultEntity != null && (securityContext2 = payMethodRiskResultEntity.getSecurityContext()) != null && (securityId = securityContext2.getSecurityId()) != null) {
            str = securityId;
        } else if (payMethodRiskResultEntity != null && (securityContext = payMethodRiskResultEntity.getSecurityContext()) != null) {
            str = securityContext.getPubKey();
        }
        return new PayMethodRiskResult(result, maskPhoneNumber, verificationMethod, str);
    }

    private static final SecurityContextAttributes toSecurity(SecurityContextAttributesEntity securityContextAttributesEntity) {
        String pubKey = securityContextAttributesEntity != null ? securityContextAttributesEntity.getPubKey() : null;
        if (pubKey == null) {
            pubKey = "";
        }
        return new SecurityContextAttributes(pubKey);
    }

    public static final List<PayChannelsItem> map(List<PayChannelsItemEntity> list) {
        PayChannelsItem payChannelsItem;
        if (list != null) {
            List<PayChannelsItemEntity> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (PayChannelsItemEntity payChannelsItemEntity : list2) {
                if (payChannelsItemEntity == null || (payChannelsItem = toPayChannelsItem(payChannelsItemEntity)) == null) {
                    payChannelsItem = new PayChannelsItem(null, null, null, null, 15, null);
                }
                arrayList.add(payChannelsItem);
            }
            return arrayList;
        }
        return null;
    }

    public static final PayChannelsItem toPayChannelsItem(PayChannelsItemEntity payChannelsItemEntity) {
        Intrinsics.checkNotNullParameter(payChannelsItemEntity, "");
        return new PayChannelsItem(payChannelsItemEntity.getPayMethod(), payChannelsItemEntity.getPayOption(), MoneyViewEntityMapperKt.toMoneyView(payChannelsItemEntity.getChargeAmountEntity()), null, 8, null);
    }
}
