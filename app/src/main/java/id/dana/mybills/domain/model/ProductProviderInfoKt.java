package id.dana.mybills.domain.model;

import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.mybills.ui.model.BillPaymentStatusModelKt;
import id.dana.mybills.ui.model.MobileRechargeProductModel;
import id.dana.mybills.ui.model.MoneyViewModel;
import id.dana.mybills.ui.model.ProductGoodsModel;
import id.dana.mybills.ui.model.ProviderPackageModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0000*\b\u0012\u0004\u0012\u00020\u00050\u0000¢\u0006\u0004\b\u0007\u0010\u0004\u001a\u0011\u0010\n\u001a\u00020\t*\u00020\b¢\u0006\u0004\b\n\u0010\u000b\u001a\u0011\u0010\f\u001a\u00020\u0002*\u00020\u0001¢\u0006\u0004\b\f\u0010\r\u001a\u0013\u0010\u000e\u001a\u00020\u0006*\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\u000f"}, d2 = {"", "Lid/dana/mybills/domain/model/ProductGoodsInfo;", "Lid/dana/mybills/ui/model/ProductGoodsModel;", "toListProductGoodsModel", "(Ljava/util/List;)Ljava/util/List;", "Lid/dana/mybills/domain/model/ProviderPackageInfo;", "Lid/dana/mybills/ui/model/ProviderPackageModel;", "toListProviderPackageModel", "Lid/dana/mybills/domain/model/ProductProviderInfo;", "Lid/dana/mybills/ui/model/MobileRechargeProductModel;", "toMobileRechargeProductModel", "(Lid/dana/mybills/domain/model/ProductProviderInfo;)Lid/dana/mybills/ui/model/MobileRechargeProductModel;", "toProductGoodsModel", "(Lid/dana/mybills/domain/model/ProductGoodsInfo;)Lid/dana/mybills/ui/model/ProductGoodsModel;", "toProviderPackageModel", "(Lid/dana/mybills/domain/model/ProviderPackageInfo;)Lid/dana/mybills/ui/model/ProviderPackageModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class ProductProviderInfoKt {
    public static final MobileRechargeProductModel toMobileRechargeProductModel(ProductProviderInfo productProviderInfo) {
        Intrinsics.checkNotNullParameter(productProviderInfo, "");
        String providerName = productProviderInfo.getProviderName();
        String str = providerName != null ? providerName : "";
        List<ProviderPackageInfo> packages = productProviderInfo.getPackages();
        return new MobileRechargeProductModel(str, packages != null ? toListProviderPackageModel(packages) : null);
    }

    public static final List<ProviderPackageModel> toListProviderPackageModel(List<ProviderPackageInfo> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<ProviderPackageInfo> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toProviderPackageModel((ProviderPackageInfo) it.next()));
        }
        return arrayList;
    }

    private static final ProviderPackageModel toProviderPackageModel(ProviderPackageInfo providerPackageInfo) {
        String type = providerPackageInfo.getType();
        List<ProductGoodsInfo> goods = providerPackageInfo.getGoods();
        return new ProviderPackageModel(goods != null ? toListProductGoodsModel(goods) : null, type);
    }

    public static final List<ProductGoodsModel> toListProductGoodsModel(List<ProductGoodsInfo> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<ProductGoodsInfo> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toProductGoodsModel((ProductGoodsInfo) it.next()));
        }
        return arrayList;
    }

    public static final ProductGoodsModel toProductGoodsModel(ProductGoodsInfo productGoodsInfo) {
        Intrinsics.checkNotNullParameter(productGoodsInfo, "");
        Boolean available = productGoodsInfo.getAvailable();
        MoneyView denom = productGoodsInfo.getDenom();
        MoneyViewModel moneyViewModel = denom != null ? BillPaymentStatusModelKt.toMoneyViewModel(denom) : null;
        String description = productGoodsInfo.getDescription();
        String goodsId = productGoodsInfo.getGoodsId();
        String goodsTitle = productGoodsInfo.getGoodsTitle();
        MoneyView price = productGoodsInfo.getPrice();
        return new ProductGoodsModel(available, moneyViewModel, description, goodsId, goodsTitle, price != null ? BillPaymentStatusModelKt.toMoneyViewModel(price) : null, productGoodsInfo.getProductCode(), productGoodsInfo.getProvider(), productGoodsInfo.getType());
    }
}
