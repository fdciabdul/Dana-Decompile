package id.dana.savings.model;

import id.dana.domain.saving.model.SavingCategory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004*\b\u0012\u0004\u0012\u00020\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/saving/model/SavingCategory;", "Lid/dana/savings/model/SavingCategoryModel;", "getAuthRequestContext", "(Lid/dana/domain/saving/model/SavingCategory;)Lid/dana/savings/model/SavingCategoryModel;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SavingCategoryModelKt {
    public static final List<SavingCategoryModel> KClassImpl$Data$declaredNonStaticMembers$2(List<SavingCategory> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<SavingCategory> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(getAuthRequestContext((SavingCategory) it.next()));
        }
        return arrayList;
    }

    public static final SavingCategoryModel getAuthRequestContext(SavingCategory savingCategory) {
        Intrinsics.checkNotNullParameter(savingCategory, "");
        return new SavingCategoryModel(savingCategory.getCategoryCode(), savingCategory.getName(), savingCategory.getIconUrlDefault(), savingCategory.getIconUrlSelected(), savingCategory.getIconUrlLevel1(), savingCategory.getIconUrlLevel2(), savingCategory.getIconUrlLevel3(), savingCategory.getIconUrlLevel4(), savingCategory.getIconUrlLevel5());
    }
}
