package id.dana.wallet_v3.view.sort.mapper;

import id.dana.domain.wallet_v3.model.SortCategory;
import id.dana.wallet_v3.view.sort.model.SortCategoryModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0011\u0010\u0005\u001a\u00020\u0002*\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lid/dana/domain/wallet_v3/model/SortCategory;", "Lid/dana/wallet_v3/view/sort/model/SortCategoryModel;", "toListSortCategoryModel", "(Ljava/util/List;)Ljava/util/List;", "toSortCategoryModel", "(Lid/dana/domain/wallet_v3/model/SortCategory;)Lid/dana/wallet_v3/view/sort/model/SortCategoryModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class WalletSortMapperKt {
    public static final List<SortCategoryModel> toListSortCategoryModel(List<SortCategory> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<SortCategory> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toSortCategoryModel((SortCategory) it.next()));
        }
        return arrayList;
    }

    public static final SortCategoryModel toSortCategoryModel(SortCategory sortCategory) {
        Intrinsics.checkNotNullParameter(sortCategory, "");
        return new SortCategoryModel(sortCategory.getTitleEn(), sortCategory.getTitleId(), sortCategory.getOrder(), false, 8, null);
    }
}
