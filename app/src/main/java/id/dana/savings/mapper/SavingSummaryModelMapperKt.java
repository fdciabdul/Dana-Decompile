package id.dana.savings.mapper;

import id.dana.domain.saving.model.SavingSummary;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.savings.model.SavingSummaryModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/domain/saving/model/SavingSummary;", "Lid/dana/savings/model/SavingSummaryModel;", "PlaceComponentResult", "(Lid/dana/domain/saving/model/SavingSummary;)Lid/dana/savings/model/SavingSummaryModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SavingSummaryModelMapperKt {
    public static final SavingSummaryModel PlaceComponentResult(SavingSummary savingSummary) {
        Intrinsics.checkNotNullParameter(savingSummary, "");
        MoneyViewModel.Companion companion = MoneyViewModel.INSTANCE;
        MoneyViewModel PlaceComponentResult = MoneyViewModel.Companion.PlaceComponentResult(savingSummary.getSavingBalanceAmount());
        MoneyViewModel.Companion companion2 = MoneyViewModel.INSTANCE;
        MoneyViewModel PlaceComponentResult2 = MoneyViewModel.Companion.PlaceComponentResult(savingSummary.getMaxSavingAmount());
        long maxSavingCount = savingSummary.getMaxSavingCount();
        String maxSavingCountNonKyc = savingSummary.getMaxSavingCountNonKyc();
        String maxSavingAmountNonKyc = savingSummary.getMaxSavingAmountNonKyc();
        String maxSavingAmountKyc = savingSummary.getMaxSavingAmountKyc();
        MoneyViewModel.Companion companion3 = MoneyViewModel.INSTANCE;
        return new SavingSummaryModel(PlaceComponentResult, PlaceComponentResult2, maxSavingCount, maxSavingCountNonKyc, maxSavingAmountNonKyc, maxSavingAmountKyc, MoneyViewModel.Companion.PlaceComponentResult(savingSummary.getRemainingAmount()), savingSummary.getRemainingCount(), SavingModelMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(savingSummary.getSavingGoalViews()), savingSummary.getHasNext());
    }
}
