package id.dana.mybills.data.mapper;

import id.dana.data.nearbyme.model.MoneyViewEntityMapperKt;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.mybills.data.model.response.BizProductResult;
import id.dana.mybills.domain.model.BizProduct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "Lid/dana/mybills/data/model/response/BizProductResult;", "Lid/dana/mybills/domain/model/BizProduct;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BizProductMapperKt {
    public static final List<BizProduct> BuiltInFictitiousFunctionClassFactory(List<BizProductResult> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<BizProductResult> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (BizProductResult bizProductResult : list2) {
            Intrinsics.checkNotNullParameter(bizProductResult, "");
            String bizId = bizProductResult.getBizId();
            String str = bizId == null ? "" : bizId;
            MoneyView moneyView = MoneyViewEntityMapperKt.toMoneyView(bizProductResult.getDenom());
            String goodsId = bizProductResult.getGoodsId();
            String str2 = goodsId == null ? "" : goodsId;
            String goodsTitle = bizProductResult.getGoodsTitle();
            String str3 = goodsTitle == null ? "" : goodsTitle;
            String goodsType = bizProductResult.getGoodsType();
            String str4 = goodsType == null ? "" : goodsType;
            Boolean isGoodsActive = bizProductResult.isGoodsActive();
            boolean booleanValue = isGoodsActive != null ? isGoodsActive.booleanValue() : false;
            String provider = bizProductResult.getProvider();
            String str5 = provider == null ? "" : provider;
            String providerName = bizProductResult.getProviderName();
            String str6 = providerName == null ? "" : providerName;
            Long transactionDate = bizProductResult.getTransactionDate();
            long longValue = transactionDate != null ? transactionDate.longValue() : 0L;
            Map<String, Object> extendInfo = bizProductResult.getExtendInfo();
            if (extendInfo == null) {
                extendInfo = MapsKt.emptyMap();
            }
            Map<String, Object> map = extendInfo;
            String customerName = bizProductResult.getCustomerName();
            arrayList.add(new BizProduct(str, moneyView, str2, str3, str4, booleanValue, str5, str6, longValue, map, customerName == null ? "" : customerName));
        }
        return arrayList;
    }
}
