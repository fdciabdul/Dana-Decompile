package id.dana.mybills.data.model.response;

import id.dana.mybills.domain.model.ProductGoodsInfo;
import id.dana.mybills.domain.model.ProductProviderInfo;
import id.dana.mybills.domain.model.ProviderPackageInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0011\u0010\u0007\u001a\u00020\u0006*\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b\u001a\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0000*\b\u0012\u0004\u0012\u00020\u00050\u0000¢\u0006\u0004\b\t\u0010\u0004\u001a\u0013\u0010\f\u001a\u00020\u000b*\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\r\u001a\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0000*\b\u0012\u0004\u0012\u00020\n0\u0000H\u0002¢\u0006\u0004\b\u000e\u0010\u0004"}, d2 = {"", "Lid/dana/mybills/data/model/response/ProductGoodsResult;", "Lid/dana/mybills/domain/model/ProductGoodsInfo;", "toProductGoodsInfo", "(Ljava/util/List;)Ljava/util/List;", "Lid/dana/mybills/data/model/response/ProductProviderResult;", "Lid/dana/mybills/domain/model/ProductProviderInfo;", "toProductProviderInfo", "(Lid/dana/mybills/data/model/response/ProductProviderResult;)Lid/dana/mybills/domain/model/ProductProviderInfo;", "toProductProviderInfos", "Lid/dana/mybills/data/model/response/ProviderPackageResult;", "Lid/dana/mybills/domain/model/ProviderPackageInfo;", "toProviderPackageInfo", "(Lid/dana/mybills/data/model/response/ProviderPackageResult;)Lid/dana/mybills/domain/model/ProviderPackageInfo;", "toProviderPackagesInfos"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ProductProviderResultKt {
    public static final List<ProductProviderInfo> toProductProviderInfos(List<ProductProviderResult> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<ProductProviderResult> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toProductProviderInfo((ProductProviderResult) it.next()));
        }
        return arrayList;
    }

    public static final ProductProviderInfo toProductProviderInfo(ProductProviderResult productProviderResult) {
        Intrinsics.checkNotNullParameter(productProviderResult, "");
        return new ProductProviderInfo(productProviderResult.getProviderName(), toProviderPackagesInfos(productProviderResult.getPackages()));
    }

    private static final List<ProviderPackageInfo> toProviderPackagesInfos(List<ProviderPackageResult> list) {
        List<ProviderPackageResult> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toProviderPackageInfo((ProviderPackageResult) it.next()));
        }
        return arrayList;
    }

    private static final ProviderPackageInfo toProviderPackageInfo(ProviderPackageResult providerPackageResult) {
        List<ProductGoodsResult> goods = providerPackageResult.getGoods();
        return new ProviderPackageInfo(goods != null ? toProductGoodsInfo(goods) : null, providerPackageResult.getType());
    }

    private static final List<ProductGoodsInfo> toProductGoodsInfo(List<ProductGoodsResult> list) {
        List<ProductGoodsResult> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(ProductGoodsResultKt.toProductGoodsInfo((ProductGoodsResult) it.next()));
        }
        return arrayList;
    }
}
