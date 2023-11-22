package id.dana.data.promodiscovery.repository.source.network.response;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.gson.annotations.SerializedName;
import id.dana.data.nearbyme.model.MoneyViewEntityMapperKt;
import id.dana.data.nearbyme.model.VoucherInfoEntity;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.domain.nearbyme.model.VoucherInfo;
import id.dana.domain.promodiscovery.model.ProductInfoDiscoveryModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0005"}, d2 = {"Lid/dana/data/promodiscovery/repository/source/network/response/ProductInfoResponse;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "Lid/dana/domain/promodiscovery/model/ProductInfoDiscoveryModel;", "toProductInfoList", "()Ljava/util/List;", "", "hasNext", "Ljava/lang/Boolean;", "getHasNext", "()Ljava/lang/Boolean;", "Lid/dana/data/promodiscovery/repository/source/network/response/ProductInfoEntity;", "productInfos", "Ljava/util/List;", "getProductInfos", "<init>", "(Ljava/lang/Boolean;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ProductInfoResponse extends BaseRpcResult {
    @SerializedName("hasNext")
    private final Boolean hasNext;
    @SerializedName("productInfos")
    private final List<ProductInfoEntity> productInfos;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker, java.lang.Boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ProductInfoResponse() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.promodiscovery.repository.source.network.response.ProductInfoResponse.<init>():void");
    }

    public /* synthetic */ ProductInfoResponse(Boolean bool, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Boolean.FALSE : bool, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    @JvmName(name = "getHasNext")
    public final Boolean getHasNext() {
        return this.hasNext;
    }

    @JvmName(name = "getProductInfos")
    public final List<ProductInfoEntity> getProductInfos() {
        return this.productInfos;
    }

    public ProductInfoResponse(Boolean bool, List<ProductInfoEntity> list) {
        this.hasNext = bool;
        this.productInfos = list;
    }

    public final List<ProductInfoDiscoveryModel> toProductInfoList() {
        List<ProductInfoEntity> list = this.productInfos;
        if (list == null) {
            return CollectionsKt.emptyList();
        }
        List<ProductInfoEntity> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (ProductInfoEntity productInfoEntity : list2) {
            String goodsId = productInfoEntity.getGoodsId();
            String str = goodsId == null ? "" : goodsId;
            String provider = productInfoEntity.getProvider();
            String str2 = provider == null ? "" : provider;
            String type = productInfoEntity.getType();
            String str3 = type == null ? "" : type;
            String description = productInfoEntity.getDescription();
            String str4 = description == null ? "" : description;
            String goodsTitle = productInfoEntity.getGoodsTitle();
            String str5 = goodsTitle == null ? "" : goodsTitle;
            String goodsTitle2 = productInfoEntity.getGoodsTitle();
            String str6 = goodsTitle2 == null ? "" : goodsTitle2;
            MoneyView moneyView = MoneyViewEntityMapperKt.toMoneyView(productInfoEntity.getPrice());
            MoneyView moneyView2 = MoneyViewEntityMapperKt.toMoneyView(productInfoEntity.getDenom());
            Boolean available = productInfoEntity.getAvailable();
            boolean booleanValue = available != null ? available.booleanValue() : false;
            Map<String, String> extendInfo = productInfoEntity.getExtendInfo();
            VoucherInfoEntity voucherInfo = productInfoEntity.getVoucherInfo();
            if (voucherInfo == null) {
                voucherInfo = new VoucherInfoEntity(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
            }
            VoucherInfo voucherInfo2 = voucherInfo.toVoucherInfo();
            Double savingRate = productInfoEntity.getSavingRate();
            arrayList.add(new ProductInfoDiscoveryModel(str, str2, str3, str4, str5, str6, moneyView, moneyView2, booleanValue, extendInfo, voucherInfo2, savingRate != null ? savingRate.doubleValue() : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
        }
        return arrayList;
    }
}
