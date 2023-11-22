package id.dana.mybills.data.model.response;

import id.dana.mybills.domain.model.GeneralProductModel;
import id.dana.mybills.domain.model.ProductGoodsInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0004*\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/mybills/data/model/response/GeneralProductResult;", "Lid/dana/mybills/domain/model/GeneralProductModel;", "toGeneralProduct", "(Lid/dana/mybills/data/model/response/GeneralProductResult;)Lid/dana/mybills/domain/model/GeneralProductModel;", "", "Lid/dana/mybills/data/model/response/ProductGoodsResult;", "Lid/dana/mybills/domain/model/ProductGoodsInfo;", "toListGoodModel", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GeneralProductResultKt {
    public static final GeneralProductModel toGeneralProduct(GeneralProductResult generalProductResult) {
        Intrinsics.checkNotNullParameter(generalProductResult, "");
        String aboutUrl = generalProductResult.getAboutUrl();
        List<ProductGoodsResult> goods = generalProductResult.getGoods();
        return new GeneralProductModel(aboutUrl, goods != null ? toListGoodModel(goods) : null, generalProductResult.getHasNext());
    }

    public static final List<ProductGoodsInfo> toListGoodModel(List<ProductGoodsResult> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<ProductGoodsResult> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(ProductGoodsResultKt.toProductGoodsInfo((ProductGoodsResult) it.next()));
        }
        return arrayList;
    }
}
