package id.dana.cashier.model;

import id.dana.cashier.domain.model.InsuranceBenefit;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "Lid/dana/cashier/domain/model/InsuranceBenefit;", "Lid/dana/cashier/model/InsuranceBenefitModel;", "PlaceComponentResult", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InsuranceBenefitModelKt {
    public static final List<InsuranceBenefitModel> PlaceComponentResult(List<InsuranceBenefit> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<InsuranceBenefit> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (InsuranceBenefit insuranceBenefit : list2) {
            Intrinsics.checkNotNullParameter(insuranceBenefit, "");
            arrayList.add(new InsuranceBenefitModel(insuranceBenefit.getBenefitIcon(), insuranceBenefit.getBenefitId(), insuranceBenefit.getBenefitSubTitle(), insuranceBenefit.getBenefitTitle()));
        }
        return arrayList;
    }
}
