package id.dana.data.nearbyme.repository.source.network.result.merchantdetail;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.nearbyme.mapper.NearbyVoucherInfoMapperKt;
import id.dana.data.nearbyme.model.MoneyViewEntityMapperKt;
import id.dana.data.nearbyme.model.ProductInfoEntity;
import id.dana.domain.nearbyme.model.MerchantProductInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0005¢\u0006\u0004\b\u0016\u0010\bJ\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0004R\u001f\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0007¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004"}, d2 = {"Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantPromoDanaDealResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "component1", "()Ljava/lang/String;", "", "Lid/dana/data/nearbyme/model/ProductInfoEntity;", "component2", "()Ljava/util/List;", "providerId", "productInfos", "copy", "(Ljava/lang/String;Ljava/util/List;)Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantPromoDanaDealResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lid/dana/domain/nearbyme/model/MerchantProductInfo;", "toProductInfoList", "toString", "Ljava/util/List;", "getProductInfos", "Ljava/lang/String;", "getProviderId", "<init>", "(Ljava/lang/String;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class MerchantPromoDanaDealResult extends BaseRpcResult {
    private final List<ProductInfoEntity> productInfos;
    private final String providerId;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MerchantPromoDanaDealResult() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.nearbyme.repository.source.network.result.merchantdetail.MerchantPromoDanaDealResult.<init>():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MerchantPromoDanaDealResult copy$default(MerchantPromoDanaDealResult merchantPromoDanaDealResult, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = merchantPromoDanaDealResult.providerId;
        }
        if ((i & 2) != 0) {
            list = merchantPromoDanaDealResult.productInfos;
        }
        return merchantPromoDanaDealResult.copy(str, list);
    }

    /* renamed from: component1  reason: from getter */
    public final String getProviderId() {
        return this.providerId;
    }

    public final List<ProductInfoEntity> component2() {
        return this.productInfos;
    }

    public final MerchantPromoDanaDealResult copy(String providerId, List<ProductInfoEntity> productInfos) {
        return new MerchantPromoDanaDealResult(providerId, productInfos);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MerchantPromoDanaDealResult) {
            MerchantPromoDanaDealResult merchantPromoDanaDealResult = (MerchantPromoDanaDealResult) other;
            return Intrinsics.areEqual(this.providerId, merchantPromoDanaDealResult.providerId) && Intrinsics.areEqual(this.productInfos, merchantPromoDanaDealResult.productInfos);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.providerId;
        int hashCode = str == null ? 0 : str.hashCode();
        List<ProductInfoEntity> list = this.productInfos;
        return (hashCode * 31) + (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MerchantPromoDanaDealResult(providerId=");
        sb.append(this.providerId);
        sb.append(", productInfos=");
        sb.append(this.productInfos);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getProviderId")
    public final String getProviderId() {
        return this.providerId;
    }

    public /* synthetic */ MerchantPromoDanaDealResult(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    @JvmName(name = "getProductInfos")
    public final List<ProductInfoEntity> getProductInfos() {
        return this.productInfos;
    }

    public MerchantPromoDanaDealResult(String str, List<ProductInfoEntity> list) {
        this.providerId = str;
        this.productInfos = list;
    }

    public final List<MerchantProductInfo> toProductInfoList() {
        List<ProductInfoEntity> list = this.productInfos;
        if (list == null) {
            return CollectionsKt.emptyList();
        }
        List<ProductInfoEntity> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (ProductInfoEntity productInfoEntity : list2) {
            arrayList.add(new MerchantProductInfo(productInfoEntity.getGoodsId(), productInfoEntity.getProvider(), productInfoEntity.getType(), productInfoEntity.getDescription(), productInfoEntity.getGoodsTitle(), MoneyViewEntityMapperKt.toMoneyView(productInfoEntity.getPrice()), MoneyViewEntityMapperKt.toMoneyView(productInfoEntity.getDenom()), productInfoEntity.getAvailable(), productInfoEntity.getProductCode(), productInfoEntity.getExtendInfo(), NearbyVoucherInfoMapperKt.toVoucherInfo(productInfoEntity.getVoucherInfo()), productInfoEntity.getSavingRate()));
        }
        return arrayList;
    }
}
