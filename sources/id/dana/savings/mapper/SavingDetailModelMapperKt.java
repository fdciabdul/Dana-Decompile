package id.dana.savings.mapper;

import id.dana.domain.saving.model.SavingDetail;
import id.dana.savings.model.SavingDetailModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/domain/saving/model/SavingDetail;", "Lid/dana/savings/model/SavingDetailModel;", "MyBillsEntityDataFactory", "(Lid/dana/domain/saving/model/SavingDetail;)Lid/dana/savings/model/SavingDetailModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SavingDetailModelMapperKt {
    public static final SavingDetailModel MyBillsEntityDataFactory(SavingDetail savingDetail) {
        Intrinsics.checkNotNullParameter(savingDetail, "");
        return new SavingDetailModel(SavingModelMapperKt.BuiltInFictitiousFunctionClassFactory(savingDetail.getSavingGoalView()), TopUpModelMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(savingDetail.getTopUpViews()), savingDetail.getHasNext());
    }
}
