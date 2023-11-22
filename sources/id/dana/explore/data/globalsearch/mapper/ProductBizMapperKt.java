package id.dana.explore.data.globalsearch.mapper;

import id.dana.domain.globalsearch.model.Denom;
import id.dana.domain.globalsearch.model.ProductBizId;
import id.dana.explore.data.globalsearch.source.network.result.DenomEntity;
import id.dana.explore.data.globalsearch.source.network.result.ProductBizIdEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "Lid/dana/explore/data/globalsearch/source/network/result/ProductBizIdEntity;", "Lid/dana/domain/globalsearch/model/ProductBizId;", "PlaceComponentResult", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ProductBizMapperKt {
    /* JADX WARN: Type inference failed for: r13v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    public static final List<ProductBizId> PlaceComponentResult(List<ProductBizIdEntity> list) {
        Denom denom;
        Intrinsics.checkNotNullParameter(list, "");
        List<ProductBizIdEntity> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (ProductBizIdEntity productBizIdEntity : list2) {
            Intrinsics.checkNotNullParameter(productBizIdEntity, "");
            String bizId = productBizIdEntity.getBizId();
            String str = bizId == null ? "" : bizId;
            String secondaryBizId = productBizIdEntity.getSecondaryBizId();
            String str2 = secondaryBizId == null ? "" : secondaryBizId;
            String transactionDate = productBizIdEntity.getTransactionDate();
            String str3 = transactionDate == null ? "" : transactionDate;
            String customerName = productBizIdEntity.getCustomerName();
            String str4 = customerName == null ? "" : customerName;
            String goodsId = productBizIdEntity.getGoodsId();
            String str5 = goodsId == null ? "" : goodsId;
            String goodsTitle = productBizIdEntity.getGoodsTitle();
            String str6 = goodsTitle == null ? "" : goodsTitle;
            String goodsType = productBizIdEntity.getGoodsType();
            String str7 = goodsType == null ? "" : goodsType;
            DenomEntity denom2 = productBizIdEntity.getDenom();
            if (denom2 == null) {
                ?? r13 = 0;
                denom = new Denom(r13, r13, 3, r13);
            } else {
                Intrinsics.checkNotNullParameter(denom2, "");
                String amount = denom2.getAmount();
                if (amount == null) {
                    amount = "";
                }
                String currency = denom2.getCurrency();
                if (currency == null) {
                    currency = "";
                }
                denom = new Denom(amount, currency);
            }
            String provider = productBizIdEntity.getProvider();
            String str8 = provider == null ? "" : provider;
            String providerName = productBizIdEntity.getProviderName();
            String str9 = providerName == null ? "" : providerName;
            Boolean isGoodsActive = productBizIdEntity.getIsGoodsActive();
            boolean booleanValue = isGoodsActive != null ? isGoodsActive.booleanValue() : false;
            String productCode = productBizIdEntity.getProductCode();
            String str10 = productCode == null ? "" : productCode;
            String productDesc = productBizIdEntity.getProductDesc();
            String str11 = productDesc == null ? "" : productDesc;
            String profileKey = productBizIdEntity.getProfileKey();
            String str12 = profileKey == null ? "" : profileKey;
            Map<String, Object> extendInfo = productBizIdEntity.getExtendInfo();
            if (extendInfo == null) {
                extendInfo = MapsKt.emptyMap();
            }
            arrayList.add(new ProductBizId(str, str2, str3, str4, str5, str6, str7, denom, str8, str9, booleanValue, str10, str11, str12, extendInfo));
        }
        return arrayList;
    }
}
