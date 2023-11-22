package id.dana.savings.mapper;

import id.dana.domain.saving.model.SavingEmptyState;
import id.dana.savings.model.SavingEmptyStateModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/domain/saving/model/SavingEmptyState;", "Lid/dana/savings/model/SavingEmptyStateModel;", "MyBillsEntityDataFactory", "(Lid/dana/domain/saving/model/SavingEmptyState;)Lid/dana/savings/model/SavingEmptyStateModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SavingEmptyStateModelMapperKt {
    public static final SavingEmptyStateModel MyBillsEntityDataFactory(SavingEmptyState savingEmptyState) {
        Intrinsics.checkNotNullParameter(savingEmptyState, "");
        return new SavingEmptyStateModel(MainEmptyStateModelMapperKt.MyBillsEntityDataFactory(savingEmptyState.getMainEmptyState()), SavingBenefitModelMapperKt.MyBillsEntityDataFactory(savingEmptyState.getSavingBenefit()));
    }
}
