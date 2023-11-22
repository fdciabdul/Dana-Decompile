package id.dana.savings.mapper;

import id.dana.domain.saving.model.SavingBenefit;
import id.dana.savings.model.SavingBenefitModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "Lid/dana/domain/saving/model/SavingBenefit;", "Lid/dana/savings/model/SavingBenefitModel;", "MyBillsEntityDataFactory", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SavingBenefitModelMapperKt {
    public static final List<SavingBenefitModel> MyBillsEntityDataFactory(List<SavingBenefit> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<SavingBenefit> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (SavingBenefit savingBenefit : list2) {
            Intrinsics.checkNotNullParameter(savingBenefit, "");
            arrayList.add(new SavingBenefitModel(savingBenefit.getIcon(), savingBenefit.getTitle(), savingBenefit.getSubtitle()));
        }
        return arrayList;
    }
}
