package id.dana.data.saving.model;

import id.dana.domain.saving.constant.SavingConstant;
import id.dana.domain.saving.model.SavingCategory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0011\u0010\u0005\u001a\u00020\u0002*\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lid/dana/data/saving/model/SavingCategoryEntity;", "Lid/dana/domain/saving/model/SavingCategory;", "toSavingCategories", "(Ljava/util/List;)Ljava/util/List;", "toSavingCategory", "(Lid/dana/data/saving/model/SavingCategoryEntity;)Lid/dana/domain/saving/model/SavingCategory;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SavingCategoryEntityKt {
    public static final List<SavingCategory> toSavingCategories(List<SavingCategoryEntity> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<SavingCategoryEntity> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toSavingCategory((SavingCategoryEntity) it.next()));
        }
        return arrayList;
    }

    public static final SavingCategory toSavingCategory(SavingCategoryEntity savingCategoryEntity) {
        Intrinsics.checkNotNullParameter(savingCategoryEntity, "");
        String categoryCode = savingCategoryEntity.getCategoryCode();
        if (categoryCode == null) {
            String removePrefix = StringsKt.removePrefix(SavingConstant.DEFAULT_SAVING_CATEGORY_KEY, (CharSequence) SavingConstant.SAVING_CATEGORY_KEY_PREFIX);
            Locale locale = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(locale, "");
            categoryCode = removePrefix.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(categoryCode, "");
        }
        return new SavingCategory(categoryCode, savingCategoryEntity.getName(), savingCategoryEntity.getIconUrlDefault(), savingCategoryEntity.getIconUrlSelected(), savingCategoryEntity.getIconUrlLevel1(), savingCategoryEntity.getIconUrlLevel2(), savingCategoryEntity.getIconUrlLevel3(), savingCategoryEntity.getIconUrlLevel4(), savingCategoryEntity.getIconUrlLevel5());
    }
}
